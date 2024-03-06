<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="entities.User,java.util.List"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Listado de Usuarios</title>
<!-- Estilos CSS -->
<!--     <link rel="stylesheet" href="./assets/estilo.css"> -->
<!-- JavaScript & JQuery -->
<script src='./assets/jquery.min.js'></script>
<script src="./assets/script.js"></script>
</head>
<body>
	<h1>Inserción Completa</h1>
	   <form id="createUser" action="/StockManagerWebProject/UserServlet" method="get">
	<table>
		<thead>
			<tr>
				<th>Borrar</th>
				<th>Modificar</th>
				<th><button name="ascendentName" type="submit" value="ascendentName">Nombre</button></th>
				<th>Apellido</th>
				<th><button name="ascendentDni" type="submit" value="ascendentDni">DNI</button></th>
				<th>Rol</th>
				<th>Mail</th>
				<th>Telefono</th>
				<th>Genero</th>
				<th>Fecha de nacimiento</th>
			</tr>
		</thead>
		<%
		List<User> userList = (List<User>) request.getAttribute("userList");
		for (User user : userList) {
		%>
		<tbody>
			<tr>
				<td><button name="delete" type="submit" value="<%=user.getId()%>">Borrar</button></td>
				<td><button name="modify" type="submit" value="<%=user.getDni()%>">Modificar</button></td>
				<td><%=user.getName()%></td>
				<td><%=user.getLastName()%></td>
				<td><%=user.getDni()%></td>
				<td><%=user.getRole()%></td>
				<td><%=user.getMail()%></td>
				<td><%=user.getPhone()%></td>
				<td><%=user.getGender()%></td>
				<td><%=user.getBirth()%></td>
			</tr>
			<%
	}
	%>
			<!-- Puedes agregar más filas de datos aquí -->
		</tbody>
	</table>
	
	</form>
</body>
</html>