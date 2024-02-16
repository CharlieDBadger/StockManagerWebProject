<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "entities.User" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Alta - StockManager</title>
    <!-- Estilos CSS -->
<!--     <link rel="stylesheet" href="./assets/estilo.css"> -->
    <!-- JavaScript & JQuery -->
    <script src='./assets/jquery.min.js'></script>
    <script src="./assets/script.js"></script>
</head>
<body>
   <h1>Inserción Completa</h1>
   <% User userInserted = (User)request.getAttribute("userSelected"); 
   String name = userInserted.getName();
   String lastName = userInserted.getLastName();
   Long id = userInserted.getId();
   %>
   
   <p>Usuario <%= name %> <%= lastName %> dado de alta con exito! su id es: <%= id %><p>
   
</body>
</html>