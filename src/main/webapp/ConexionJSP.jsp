<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>Listado</h1>
	<%
	// 	Se debe castear lo que se recibe según el objeto que se manda desde el servlet y 
	// 	se debe importar las librerias necesarias.
	List<String> colores = (List<String>) request.getAttribute("listaColores");

	System.out.println(colores.size());

	for (String color : colores) {

	%>
	<p>
		<%=color%>
	</p>

	<%
	}
	%>
</body>
</html>