<% include '/WEB-INF/includes/header.gtpl' %>

<H1>Friends in common</H1><BR/>

<form action="/checkCommonFriends.groovy" method="POST">
<B>Tweeple to check:</B><input type="text" name="twitterNicks" value=""/><input type="submit" name="Submit" value="Submit"/>
</form>

<% if(request.getAttribute('nicks') && request.getAttribute('friendsInCommon')) { %>
<H2><%= request.nicks %> has <%=request.friendsInCommon.size() %> friends in common...</H2>
<table>
	<tr><td>&nbsp;</td><td>Nick</td><td>Name</td></tr>
	<% for(friend in request.friendsInCommon) { %>
		<tr>
			<td><img src="<%=friend.profileImageUrl %>" /></td>
			<td><a href="http://twitter.com/<%=friend.screenName %>"><%=friend.screenName %></a></td>
			<td><%=friend.name %></td>
		</tr>
	
	<% } %>
</table>

<% } %>

<% include '/WEB-INF/includes/footer.gtpl' %>