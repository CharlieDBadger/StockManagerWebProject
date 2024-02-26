<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="entities.User"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Stock Manager App</title>
<!-- favicon -->
<link rel="icon" type="image/icon" href="favicon.ico" />
<!-- Enlace al CSS de Bootstrap -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<!-- Enlace al CSS personalizado -->
<link rel="stylesheet" href="assets/estilo.css">
</head>
<body>
	<%
	User userLogged = (User) session.getAttribute("userLogged");
	%>
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
							class="dropdown-item" href="CurstomerForm.jsp">Clientes</a> <a
							class="dropdown-item" href="ArticleForm.jsp">Articulos</a> <a
							class="dropdown-item" href="SupplierForm.jsp">Proveedores</a> <a
							class="dropdown-item" href="FacturaForm.jsp">Factura</a> <a
							class="dropdown-item" href="EntryForm.jsp">Entrada</a>
					</div>
					<button type="button" class="btn btn-primary"
						data-toggle="dropdown">Consultas</button>

					<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
						<a class="dropdown-item" href="UserSearch.jsp">Usuarios</a>
						<a class="dropdown-item" href="CustomerSearch.jsp">Clientes</a>
						<a class="dropdown-item" href="Article.jsp">Articulos</a>
						<a class="dropdown-item" href="SupplierSearch.jsp">Proveedores</a>
						<a class="dropdown-item" href="Factura.jsp">Factura</a>
						<a class="dropdown-item" href="Entry.jsp">Entrada</a>
					</div>
					<button type="button" class="btn btn-primary"
						data-toggle="dropdown">Listados</button>

					<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
						<a class="dropdown-item" href="UserList.jsp">Usuarios</a> 
						<a class="dropdown-item" href="CustomerList.jsp">Clientes</a>
						<a class="dropdown-item" href="ArticleList.jsp">Articulos</a>
						<a class="dropdown-item" href="MovArticleList.jsp">Mov. Articulos</a>
						<a class="dropdown-item" href="SupplierList.jsp">Proveedores</a>
					</div>

					<button type="button" class="btn btn-primary">Cerrar
						Sesión</button>
				</div>

				<h2 class="text-center col-12 mb-4 mt-4">
					Bienvenido!
					<%= userLogged.getName() %></h2>
				<%-- <div class="container-form col-12 col-md-6 col-lg-3"><%= codigo de JAVA mostrando Formulario %></div> --%>
			</div>
		</div>
	</div>
	<!-- Importar JS de Bootstrap y sus dependencias -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
	<div class="footer" align="center">Designed & Coded by Carlos &
		David</div>
</body>


