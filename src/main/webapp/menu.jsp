<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="entities.User"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Enlace al CSS de Bootstrap -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        /* Estilos personalizados */
        body {
            background-color: #323334; /* Color de fondo gris oscuro */
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
</head>
<body>
		<%
		User userLogged = (User) request.getAttribute("userLogged");
		%>
    <div class="container mt-5">
        <div class="menu-container">
            <div class="form-group" align="center">
                <button type="submit" class="btn btn-primary ">Altas</button>

                <button type="submit" class="btn btn-primary">Bajas</button>

                <button type="submit" class="btn btn-primary">Consulta Listado</button>

                <button type="submit" class="btn btn-primary">Cerrar Sesión</button>

                <h2 class="text-center col-12 mb-4 mt-4">Bienvenido! <%= userLogged.getName() %></h2>
            </div>
        </div>
    </div>
    <!-- Enlace a los scripts de Bootstrap (opcional) -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <div class="footer" align="center"> Designed & Coded by Carlos & David</div>
</body>
</html>


