<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="entities.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

		<%
		User userLogged = (User) request.getAttribute("userLogged");
		%>

<p><%= userLogged.getName() %></p>
</body>
</html>