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
	<table>
		<thead>
			<tr>
				<th>Borrar</th>
				<th>Modificar</th>
				<th>Nombre</th>
				<th>Apellido</th>
				<th>DNI</th>
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
				<td><button id="delete" onclick="enviarDatos('<%=user.getDni()%>')">Borrar</button></td>
				<td><button id="modify" onclick="enviarDatos('<%=user.getId()%>')">Modificar</button></td>
				<td><%=user.getName()%></td>
				<td><%=user.getLastName()%></td>
				<td><%=user.getDni()%></td>
				<td><%=user.getRole()%></td>
				<td><%=user.getMail()%></td>
				<td><%=user.getPhone()%></td>
				<td><%=user.getGender()%></td>
				<td><%=user.getBirth()%></td>
			</tr>
			<!-- Puedes agregar más filas de datos aquí -->
		</tbody>
	</table>
	<%
	}
	%>
</body>
</html>