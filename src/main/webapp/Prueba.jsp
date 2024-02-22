<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="entities.User,tools.Tools"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Stock Manager App</title>
<link rel="icon" type="image/icon" href="Stock FRONT/favicon.ico" />
<!-- Enlace al CSS de Bootstrap -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<style>
/* Estilos personalizados */
body {
	background-color: #323334;
	/* Color de fondo gris oscuro */
}

.menu-container {
	max-width: 800px;
	margin: 0 auto;
	padding: 20px;
	background-color: #ffffff;
	/* Color de fondo del formulario */
	border-radius: 10px;
	box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
	/* Sombra suave */
}

.menu-label {
	color: #ffffff;
	/* Color blanco para la etiqueta "Menú" */
	font-size: 14px;
	text-align: left;
	margin-top: 20px;
}

.menu-container .btn-primary {
	background-color: #818181;
	/* Color de botón gris claro */
	border: none;
}

.menu-container .btn-primary:hover {
	background-color: #606263;
	/* Color de botón gris oscuro al pasar el ratón */
}

.footer {
	position: center;
	font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS',
		sans-serif;
	font-style: normal;
	color: bisque;
}

/* Personalizar el color de fondo del dropdown para que sea el mismo que btn-primary */
.dropdown-menu {
	background-color: #818181;
	color: white;
}

/* Personalizar el color de fondo de las opciones del dropdown cuando se seleccionan */
.dropdown-menu .dropdown-item:focus, .dropdown-menu .dropdown-item:hover
	{
	background-color: #343a40;
	color: white;
}

/* Personalizar el color de fondo del botón para que sea gris */
.btn-primary {
	background-color: #6c757d;
	border-color: #6c757d;
}

/* Personalizar el color de fondo del botón cuando se pasa por encima o se selecciona */
.btn-primary:hover, .btn-primary:focus, .btn-primary:active {
	background-color: #5a6268;
	border-color: #545b62;
}
</style>
<script>
	localStorage.setItem('loggedIn', 'true');
	var loggedIn = JSON.parse(localStorage.getItem("loggedIn"));
	document.getElementById('logoutButton').addEventListener('click',
			function() {
				localStorage.setItem('loggedIn', 'false');
				alert('Has cerrado la sesión');
			});
</script>

</head>
<body>
	<div class="container mt-5">
		<div class="menu-container">
			<div class="form-group" align="center">
				<div class="dropdown">
					<!-- Botón que activa el dropdown -->
					<!-- Elementos del dropdown -->
					<button type="submit" class="btn btn-primary"
						data-toggle="dropdown">Altas</button>

					<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
						<a class="dropdown-item" href="#">Usuarios</a> <a
							class="dropdown-item" href="#">Clientes</a> <a
							class="dropdown-item" href="#">Articulos</a> <a
							class="dropdown-item" href="#">Proveedores</a> <a
							class="dropdown-item" href="#">Factura</a> <a
							class="dropdown-item" href="#">Entrada</a>
					</div>
					<button type="submit" class="btn btn-primary"
						data-toggle="dropdown">Bajas</button>

					<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
						<a class="dropdown-item" href="#">Usuarios</a> <a
							class="dropdown-item" href="#">Clientes</a> <a
							class="dropdown-item" href="#">Articulos</a> <a
							class="dropdown-item" href="#">Proveedores</a> <a
							class="dropdown-item" href="#">Factura</a> <a
							class="dropdown-item" href="#">Entrada</a>
					</div>
					<button type="submit" class="btn btn-primary"
						data-toggle="dropdown">Consultas</button>

					<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
						<a class="dropdown-item" href="#">Usuarios</a> <a
							class="dropdown-item" href="#">Clientes</a> <a
							class="dropdown-item" href="#">Articulos</a> <a
							class="dropdown-item" href="#">Mov. Articulos</a> <a
							class="dropdown-item" href="#">Proveedores</a>
					</div>

					<button type="submit" class="btn btn-primary">Cerrar
						Sesión</button>
				</div>

				<h2 class="text-center col-12 mb-4 mt-4">
					Bienvenido!
					<%=session.getAttribute("usuario")%>
				</h2>

				<%--                 <div class="container-form col-12 col-md-6 col-lg-3"><%= codigo de JAVA mostrando Formulario %></div> --%>
			</div>
		</div>
	</div>
    <!-- Importar JS de Bootstrap y sus dependencias -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <div class="footer" align="center">Designed & Coded by Carlos & David</div>
</body>

</html>
