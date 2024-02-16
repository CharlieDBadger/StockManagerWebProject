<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="entities.User"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Alta - StockManager</title>
    <!-- Estilos CSS -->
<!--     <link rel="stylesheet" href="./assets/estilo.css"> -->
     <link rel="stylesheet" href="./assets/style.css">
    <!-- JavaScript & JQuery -->
    <script src='./assets/jquery.min.js'></script>
    <script src="./assets/script.js"></script>
</head>
<body>
    <div class="contenedor cf">
        <div class="logo"></div>
        <form id="createUser" action="/StockManagerWebProject/UserServlet" method="post">
        		<%
		User user = (User) request.getAttribute("userToModify");
		%>
        
            <label for="name">Nombre:</label><br>
            <input value="<%= user == null ? "" : user.getName() %>" type="text" id="name" name="name" placeholder="Introduce tu Nombre" required>
            <br>
            <label for="lastName">Apellido:</label><br>
            <input value="<%= user == null ? "" : user.getLastName()%>" type="text" id="lastName" name="lastName" placeholder="Introduce tu Apellido" required>
            <br>
            <label for="dni">DNI:</label><br>
            <input value="<%= user == null ? "" : user.getDni()%>" type="text" id="dni" name="dni" placeholder="Introduce tu DNI" required>
            <br>
            <label for="email">Email:</label><br>
            <input value="<%= user == null ? "" : user.getMail()%>" type="text" id="email" name="email" placeholder="Introduce tu Email" required>
            <br>
            <label for="password">Contraseña:</label><br>
            <input value="<%= user == null ? "" : user.getPassword()%>" type="password" id="password" name="password" placeholder="Introduce tu Contraseña" required>
            <br>
             <label for="idUser">ID Usuario:</label><br>
            <input value ="<%= user == null ? "" : user.getId()%>" type="text" readonly id="idUser" name="idUser"  placeholder="No se le ha asignado un id" required>
            <br>
            <label for="role">Rol de Usuario</label><br>
            <select id="role" name="role" required>
                <option value="user">Usuario</option>
                <option value="admin">Administrador</option>
            </select><br>
            <br>
		    <label for="telephone">Telefono: </label><br>
            <input value="<%= user == null ? "" : user.getPhone()%>" type="text" id="telephone" name="telephone" placeholder="Introduce tu Telefono" required>
            <br>
            <label for="gender">Sexo:</label><br>
            <input type="radio" id="male" name="gender" value="male" required>
            <label for="male">Masculino</label><br>
            <input type="radio" id="female" name="gender" value="female" required>
            <label for="female">Femenino</label><br>
            <input type="radio" id="other" name="gender" value="other" required>
            <label for="other">Otro</label><br>
            <br>
            <label for="birth">Fecha de Nacimiento: </label><br>
            <%if (user == null){ %>
            <input type="date" name="birth" id="birth"><br>
            
            	<%}else if (user.getBirth()!= null) { %>
           	 	<input type="date" name="birth" id="birth" value= "<% user.getBirth(); %>" >
            	<%} %>
            <br>
            <input type="submit" value="Enviar">
        </form>
    </div>
</body>
</html>