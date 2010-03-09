import com.google.appengine.api.datastore.Entity

// Save the message and return the user to the guestbook - very Web 1.0

def nick = params.nick
def message = params.message

if(nick && message && nick.size() && message.size()) {
	def guestbookEntry = new Entity("guestbookentry")
	guestbookEntry.nick = nick
	guestbookEntry.message = message
	guestbookEntry.dateCreated = new Date()
	guestbookEntry.save()
	
	request.message = "Thanks for your entry!"
} else {
	request.message = "Please fill out both the nickanme and the message..."
}

forward '/guestbook.groovy'