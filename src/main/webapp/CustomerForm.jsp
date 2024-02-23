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
        <form id="createCustomer" action="/StockManagerWebProject/CustomerServlet" method="post">
        		<%
		Customer customer = (Customer) request.getAttribute("customerToModify");
		%>
        
            <label for="name">Nombre:</label><br>
            <input value="<%= customer == null ? "" : customer.getName() %>" type="text" id="name" name="name" placeholder="Introduce tu Nombre" required>
            <br>
            
            <label for="mobile">DNI:</label><br>
            <input value="<%= customer == null ? "" : customer.getDni()%>" type="text" id="dni" name="dni" placeholder="Introduce tu DNI" required>
            <br>
            
            <label for="telephone">Telefono: </label><br>
            <input value="<%= customer == null ? "" : customer.getMobile()%>" type="text" id="mobile" name="mobile" placeholder="Introduce tu Telefono" required>
            <br>
            
            <label for="observation">Observacion: </label><br>
     		<textarea name="observation" rows="3" cols="50"></textarea>
     		<br>
     		
            <input type="submit" value="<%= customer == null ? "Enviar" : "Actualizar"%>">
        </form>
       	</div>
    </div>
 
      <%if (customer != null ){ %>
          <form id="createUser" action="/StockManagerWebProject/UserServlet" method="get">
          <button name="delete" type="submit" value="<%=customer.getId()%>">Borrar</button>
          </form>
        <% } %>
        
</body>


</body>
</html>