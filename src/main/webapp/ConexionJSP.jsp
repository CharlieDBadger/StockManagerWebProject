<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List,java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>LISTADO COLORES</h1>

	<%
	List<String> colores = (List<String>) request.getAttribute("listaColores");
	for (String color : colores) {
	%>
	<p><%=color%></p>
	<%
	}
	%>
	<table>

	</table>


</body>
</html>