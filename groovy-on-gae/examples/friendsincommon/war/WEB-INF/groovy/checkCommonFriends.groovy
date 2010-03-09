import com.google.appengine.api.urlfetch.*
import se.qbranch.friendsincommon.*

if(params.clearCache) {
	memcache.clearAll()
	forward '/index.gtpl'
}


def twitterNicks = params.twitterNicks.split(",").collect { it.trim() } 

def fetchFriendXml(nick, cursor = -1) {
	def requestUrl = "http://api.twitter.com/1/statuses/friends.xml?screen_name=$nick&cursor=$cursor"
	
	def response = urlFetch.fetch(
			new HTTPRequest(requestUrl.toURL()))
	def content = new String(response.content)
	def xml = new XmlSlurper().parseText(content)
}

def fetchFriends(nick) {
	def xml = fetchFriendXml(nick)
	
	def nextCursor = Long.parseLong(xml.next_cursor.text())
	def friends = buildUsersFromXml(xml.users.user)
	
	while(nextCursor != 0) {
		xml = fetchFriendXml(nick, nextCursor)
		nextCursor = xml.next_cursor
		friends.addAll(buildUsersFromXml(xml.users.user))
	}
	
	
	return friends
}

def buildUsersFromXml(users) {
	def friends = []
	for(user in users) {
		def tu = new TwitterUser()
		tu.name = user.name.text()
		tu.screenName = user.screen_name.text()
		tu.profileImageUrl = user.profile_image_url.text()
		friends << tu
	}
	friends
}

def twittersWithFriends = twitterNicks.collect {
	def nick = it
	def friends
	if(nick in memcache) {
		friends = memcache[nick]
	} else {
		friends = fetchFriends(nick)
		memcache[nick] = friends
	}
	

	[nick: nick, friends: friends]
}

def friendsInCommon = twittersWithFriends[1..-1].inject(twittersWithFriends[0].friends) { friendsInCommon, twitterUser ->
	friendsInCommon.retainAll(twitterUser.friends)
	friendsInCommon
}

request.friendsInCommon = friendsInCommon



request.nicks = twitterNicks[1..-1].inject(twitterNicks[0]) { nicks, nick -> nicks += ", $nick"}
forward '/index.gtpl'