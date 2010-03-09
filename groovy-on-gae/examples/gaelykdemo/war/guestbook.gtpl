<% include '/WEB-INF/includes/header.gtpl' %>

<H1>Gaelyk Guestbook</H1>
<% if(request.message) { %>
<B><%=request.message %></B>
<% } %>

<% if(user) { %>
<a href="<%=users.createLogoutURL("http://gtug-gaelyk-demo.appspot.com/") %>">Logout</a><BR/>
<form action="/saveMessage.groovy" method="POST">
<input type="hidden" name="nick" value="<%=user.nickname %>" />
Nick: <%=user.nickname %><BR/>
Message:<BR/>
<textarea name="message"></textarea><BR/>
<input type="submit" value="Submit">
</form>
<% } else { %>
	Login to be able to send messages: <a href="<%=users.createLoginURL("http://gtug-gaelyk-demo.appspot.com/") %>">Login!</a><BR/>
<% } %>

<% for(entry in request.entries) { %>
Nick: <B><%=entry.nick %></B><BR/>
Date: <%=entry.dateCreated %><BR/>
Message: <%=entry.message %><BR/><BR/>
<% } %>

<% include '/WEB-INF/includes/footer.gtpl' %>