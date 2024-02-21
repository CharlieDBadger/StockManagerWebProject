<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="entities.User,tools.Tools"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
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

 <div class="container mt-5">
        <div class="menu-container">
            <div class="form-group" align="center">
                <button type="button" class="btn btn-primary "><a href="#">Altas</a></button>

                <button type="button" class="btn btn-primary"><a href="#">Bajas</a></button>

                <button type="button" class="btn btn-primary"><a href="#">Consulta Listado</a></button>

                <button type="button" class="btn btn-primary" id="logoutButton">Cerrar Sesión</button>

                <h2 class="text-center col-12 mb-4 mt-4">Bienvenido! <%= session.getAttribute("usuario") %></h2>

                <div class="contenedor cf">
        <div class="logo">
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
            
            <label for="telephone">Telefono: </label><br>
            <input value="<%= user == null ? "" : user.getPhone()%>" type="text" id="telephone" name="telephone" placeholder="Introduce tu Telefono" required>
            <br>
            
            <label for="role">Rol de Usuario</label><br>
            <select id="role" name="role" required>
                <option value="Usuario" <% if (user == null || !user.getRole().equals("Admin")) { %> selected <% } %>>Usuario</option>
                <option value="Admin" <% if (user != null && user.getRole().equals("Admin")) { %> selected <% } %>>Administrador</option>
            </select>
            <br>
            <br>
            
            <label for="gender">Sexo:</label><br>
            <input type="radio" id="male" name="gender" value="Masculino" <% if (user != null && user.getGender().equals("Masculino")) { %> checked <% } %> required>
            <label for="male">Masculino</label><br>
            <input type="radio" id="female" name="gender" value="Femenino" <% if (user != null && user.getGender().equals("Femenino")) { %> checked <% } %> required>
            <label for="female">Femenino</label><br>
            <input type="radio" id="other" name="gender" value="Otro" <% if (user != null && user.getGender().equals("Otro")) { %> checked <% } %> required>
            <label for="other">Otro</label><br>
            <br>
            
            <label for="birth">Fecha de Nacimiento: </label><br>
            <%if (user == null){ %>
            <input type="date" name="birth" id="birth"><br>
            	<%}else if (user != null) { %>
           	 	<input type="date" name="birth" id="birth" readonly value= "<%=Tools.convertDateToString(user.getBirth())%>" >
            	<%} %>
            <br>
            <input type="submit" value="<%= user == null ? "Enviar" : "Actualizar"%>">
        </form>
       	</div>
    </div>
 
      <%if (user != null ){ %>
          <form id="createUser" action="/StockManagerWebProject/UserServlet" method="get">
          <button name="delete" type="submit" value="<%=user.getId()%>">Borrar</button>
          </form>
        <% } %>
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