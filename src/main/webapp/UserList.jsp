<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="entities.User,java.util.List"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Listado</title>
    <!-- Enlace al CSS de Bootstrap -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        /* Estilos personalizados */
        body {
            background-color: #323334; /* Color de fondo gris oscuro */
        /* Boton btn-primary evitamos que cambie de color y eliminamos subrayado.*/ 
        }
        .btn-primary a {
            color: white; /* El color que prefieras */
            text-decoration: none; /* Elimina el subrayado */
        }
        .btn-primary a:visited {
            color: white; /* El color que prefieras */
        }
        .btn-primary a:hover {
            color: white; /* El color que prefieras */
        }
        .menu-container {
            max-width: 800px;
            margin: 0 auto;
            padding: 20px;
            background-color: #ffffff; /* Color de fondo del formulario */
            border-radius: 10px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1); /* Sombra suave */
        }
        .menu-label {
            color: #ffffff; /* Color blanco para la etiqueta "Menú" */
            font-size: 14px;
            text-align: left;
            margin-top: 20px;
        }
        .menu-container .btn-primary {
            background-color: #818181; /* Color de botón gris claro */
            border: none;
        }
        .menu-container .btn-primary:hover {
            background-color: #606263; /* Color de botón gris oscuro al pasar el ratón */
        }
        .footer{
            position: center;
            font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif;
            font-style: normal;
            color: bisque;
        }
    </style>
    <script>
    localStorage.setItem('loggedIn', 'true');
    var loggedIn = JSON.parse(localStorage.getItem("loggedIn"));
    document.getElementById('logoutButton').addEventListener('click', function() {
        localStorage.setItem('loggedIn', 'false');
        alert('Has cerrado la sesión');
    });
    </script>
        <!-- JavaScript & JQuery -->
    <script src='./assets/jquery.min.js'></script>
    <script src="./assets/script.js"></script>
</head>
<body>
<div class="container col-12 md-9 lg-6 mt-5">
		<div class="menu-container">
			<div class="form-group" align="center">
				<div class="dropdown">
					<!-- Botón que activa el dropdown -->
					<!-- Elementos del dropdown -->
										<button type="button" class="btn btn-primary"
						data-toggle="dropdown">Altas</button>

					<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
						<a class="dropdown-item" href="UserForm.jsp">Usuarios</a> <a
							class="dropdown-item" href="ClientForm.jsp">Clientes</a> <a
							class="dropdown-item" href="ArticleForm.jsp">Articulos</a> <a
							class="dropdown-item" href="SupplierForm.jsp">Proveedores</a> <a
							class="dropdown-item" href="FacturaForm.jsp">Factura</a> <a
							class="dropdown-item" href="EntryForm.jsp">Entrada</a>
					</div>
					<button type="button" class="btn btn-primary"
						data-toggle="dropdown">Consultas</button>

					<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
						<a class="dropdown-item" href="User.jsp">Usuarios</a>
						<a class="dropdown-item" href="Cliente.jsp">Clientes</a>
						<a class="dropdown-item" href="Article.jsp">Articulos</a>
						<a class="dropdown-item" href="Supplier.jsp">Proveedores</a>
						<a class="dropdown-item" href="Factura.jsp">Factura</a>
						<a class="dropdown-item" href="Entry.jsp">Entrada</a>
					</div>
					<button type="button" class="btn btn-primary"
						data-toggle="dropdown">Listados</button>

					<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
						<a class="dropdown-item" href="UserList.jsp">Usuarios</a> 
						<a class="dropdown-item" href="ClientList.jsp">Clientes</a>
						<a class="dropdown-item" href="ArticleList.jsp">Articulos</a>
						<a class="dropdown-item" href="MovArticleList.jsp">Mov. Articulos</a>
						<a class="dropdown-item" href="SupplierList.jsp">Proveedores</a>
					</div>

					<button type="button" class="btn btn-primary">Cerrar
						Sesión</button>
				</div>

                <h2 class="text-center col-12 mb-4 mt-4">Bienvenido! <%= session.getAttribute("usuario") %></h2>

	   <form id="manipulateUser" action="/StockManagerWebProject/UserServlet" method="get">
	<table>
		<thead>
			<tr align="center">
				<th align="center">Borrar</th>
				<th align="center">Modificar</th>
				<th align="center">Nombre</th>
				<th align="center">Apellido</th>
				<th align="center">DNI</th>
				<th align="center">Rol</th>
				<th align="center">Mail</th>
				<th align="center">Telefono</th>
				<th align="center">Genero</th>
			</tr>
		</thead>
		<%
		List<User> userList = (List<User>) request.getAttribute("userList");
		for (User user : userList) {
		%>
		<tbody>
			<tr align="center">
				<td><button name="delete" type="submit" value="<%=user.getId()%>">Borrar</button></td>
				<td><button name="modify" type="submit" value="<%=user.getDni()%>">Modificar</button></td>
				<td align="center"><%=user.getName()%></td>
				<td align="center"><%=user.getLastName()%></td>
				<td align="center" ><%=user.getDni()%></td>
				<td align="center"><%=user.getRole()%></td>
				<td align="center"><%=user.getMail()%></td>
				<td align="center"><%=user.getPhone()%></td>
				<td align="center"><%=user.getGender()%></td>
			</tr>
			<!-- Puedes agregar más filas de datos aquí -->
		</tbody>
	</table>
	<%
	}
	%>
	</form>
            </div>
        </div>
    </div>
    <!-- Enlace a los scripts de Bootstrap (opcional) -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <div class="footer" align="center">Designed & Coded by Carlos & David</div>
</body>
</html>