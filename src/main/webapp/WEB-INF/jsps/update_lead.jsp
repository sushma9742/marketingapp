<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>
<h2>Update Lead</h2>
<form action="updateLead" method="post">
<pre>
<input type="hidden" name="id" value="${leads.id}"/>
FirstName<input type="text" name="firstName" value="${leads.firstName}"/>
LastName<input type="text" name="lastName" value="${leads.lastName}"/>
email<input type="text" name="email" value="${leads.email}"/>
mobile<input type="text" name="mobile" value="${leads.mobile}"/>
<input type="submit" value="update"/>
</pre>
</form>
</body>
</html>