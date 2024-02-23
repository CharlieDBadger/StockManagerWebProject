<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="entities.Customer,entities.Address,tools.Tools" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<body>
    <div class="contenedor cf">
        <div class="logo">
        <form id="createUser" action="/StockManagerWebProject/UserServlet" method="post">
        		<%
		Customer customer = (Customer) request.getAttribute("customerToModify");
		%>
        
            <label for="name">Nombre:</label><br>
            <input value="<%= customer == null ? "" : user.getName() %>" type="text" id="name" name="name" placeholder="Introduce tu Nombre" required>
            <br>
            
            <label for="lastName">Apellido:</label><br>
            <input value="<%= customer == null ? "" : user.getLastName()%>" type="text" id="lastName" name="lastName" placeholder="Introduce tu Apellido" required>
            <br>
            
            <label for="dni">DNI:</label><br>
            <input value="<%= customer == null ? "" : user.getDni()%>" type="text" id="dni" name="dni" placeholder="Introduce tu DNI" required>
            <br>
            
            <label for="email">Email:</label><br>
            <input value="<%= customer == null ? "" : user.getMail()%>" type="text" id="email" name="email" placeholder="Introduce tu Email" required>
            <br>
            
            <label for="password">Contraseña:</label><br>
            <input value="<%= customer == null ? "" : user.getPassword()%>" type="password" id="password" name="password" placeholder="Introduce tu Contraseña" required>
            <br>
            
             <label for="idUser">ID Usuario:</label><br>
            <input value ="<%= customer == null ? "" : user.getId()%>" type="text" readonly id="idUser" name="idUser"  placeholder="No se le ha asignado un id" required>
            <br>
            
            <label for="telephone">Telefono: </label><br>
            <input value="<%= customer == null ? "" : user.getPhone()%>" type="text" id="telephone" name="telephone" placeholder="Introduce tu Telefono" required>
            <br>
            
            <label for="role">Rol de Usuario</label><br>
            <select id="role" name="role" required>
                <option value="Usuario" <% if (customer == null || !user.getRole().equals("Admin")) { %> selected <% } %>>Usuario</option>
                <option value="Admin" <% if (customer != null && user.getRole().equals("Admin")) { %> selected <% } %>>Administrador</option>
            </select>
            <br>
            <br>
            
            <label for="gender">Sexo:</label><br>
            <input type="radio" id="male" name="gender" value="Masculino" <% if (customer != null && user.getGender().equals("Masculino")) { %> checked <% } %> required>
            <label for="male">Masculino</label><br>
            <input type="radio" id="female" name="gender" value="Femenino" <% if (customer != null && user.getGender().equals("Femenino")) { %> checked <% } %> required>
            <label for="female">Femenino</label><br>
            <input type="radio" id="other" name="gender" value="Otro" <% if (customer != null && user.getGender().equals("Otro")) { %> checked <% } %> required>
            <label for="other">Otro</label><br>
            <br>
            
            <label for="birth">Fecha de Nacimiento: </label><br>
            <%if (customer == null){ %>
            <input type="date" name="birth" id="birth"><br>
            	<%}else if (customer != null) { %>
           	 	<input type="date" name="birth" id="birth" readonly value= "<%=Tools.convertDateToString(user.getBirth())%>" >
            	<%} %>
            <br>
            <input type="submit" value="<%= customer == null ? "Enviar" : "Actualizar"%>">
        </form>
       	</div>
    </div>
 
      <%if (customer != null ){ %>
          <form id="createUser" action="/StockManagerWebProject/UserServlet" method="get">
          <button name="delete" type="submit" value="<%=user.getId()%>">Borrar</button>
          </form>
        <% } %>
        
</body>


</body>
</html>