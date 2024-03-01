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
        Address address = null;
        if (customer != null){
        address = customer.getAddress();
        }
		%>
        	<p>Cliente</p>
            <label for="name" >Nombre:</label><br>
            <input name="name" value="<%= customer == null ? "" : customer.getName() %>" type="text" id="name" placeholder="Introduce tu Nombre" required>
            <br>
            
            <label for="dni">DNI:</label><br>
            <input name="dni" value="<%= customer == null ? "" : customer.getDni()%>" type="text" id="dni" placeholder="Introduce tu DNI" required>
            <br>
            
            <label for="mobile">Telefono: </label><br>
            <input name="mobile" value="<%= customer == null ? "" : customer.getMobile()%>" type="text" id="mobile" placeholder="Introduce tu Telefono" required>
            <br>
            
            <label for="observation">Observacion sobre el Cliente: </label>
            <br>
     		<textarea name="observation" rows="3" cols="50" >
     		<%= customer == null ? "" : customer.getObservation()%>
     		</textarea>
     		<br>
            
            <p>Dirección</p>
            <label for="addressName">Nombre: </label><br>
            <input name="addressName" value="<%= customer == null ? "" : address.getName()%>" type="text" id="addressName" placeholder="Introduce el nombre de la calle" required>
            <br> 
            <label for="provincias">Selecciona una provincia:</label> 
            <br> 
            <select id="provincias" name="province">
					<option value="Álava"
						<%if (address != null && address.getProvince().equals("Álava")) {%>
						selected <%}%>>Álava</option>
					<option value="Albacete"
						<%if (address != null && address.getProvince().equals("Albacete")) {%>
						selected <%}%>>Albacete</option>
					<option value="Alicante"
						<%if (address != null && address.getProvince().equals("Alicante")) {%>
						selected <%}%>>Alicante</option>
					<option value="Almería"
						<%if (address != null && address.getProvince().equals("Almería")) {%>
						selected <%}%>>Almería</option>
					<option value="Ávila"
						<%if (address != null && address.getProvince().equals("Ávila")) {%>
						selected <%}%>>Ávila</option>
					<option value="Badajoz"
						<%if (address != null && address.getProvince().equals("Badajoz")) {%>
						selected <%}%>>Badajoz</option>
					<option value="Barcelona"
						<%if (address != null && address.getProvince().equals("Barcelona")) {%>
						selected <%}%>>Barcelona</option>
					<option value="Burgos"
						<%if (address != null && address.getProvince().equals("Burgos")) {%>
						selected <%}%>>Burgos</option>
					<option value="Cáceres"
						<%if (address != null && address.getProvince().equals("Cáceres")) {%>
						selected <%}%>>Cáceres</option>
					<option value="Cádiz"
						<%if (address != null && address.getProvince().equals("Cádiz")) {%>
						selected <%}%>>Cádiz</option>
					<option value="Cantabria"
						<%if (address != null && address.getProvince().equals("Cantabria")) {%>
						selected <%}%>>Cantabria</option>
					<option value="Castellón"
						<%if (address != null && address.getProvince().equals("Castellón")) {%>
						selected <%}%>>Castellón</option>
					<option value="Ceuta"
						<%if (address != null && address.getProvince().equals("Ceuta")) {%>
						selected <%}%>>Ceuta</option>
					<option value="Ciudad Real"
						<%if (address != null && address.getProvince().equals("Ciudad Real")) {%>
						selected <%}%>>Ciudad Real</option>
					<option value="Córdoba"
						<%if (address != null && address.getProvince().equals("Córdoba")) {%>
						selected <%}%>>Córdoba</option>
					<option value="Cuenca"
						<%if (address != null && address.getProvince().equals("Cuenca")) {%>
						selected <%}%>>Cuenca</option>
					<option value="Gerona"
						<%if (address != null && address.getProvince().equals("Gerona")) {%>
						selected <%}%>>Gerona</option>
					<option value="Granada"
						<%if (address != null && address.getProvince().equals("Granada")) {%>
						selected <%}%>>Granada</option>
					<option value="Guadalajara"
						<%if (address != null && address.getProvince().equals("Guadalajara")) {%>
						selected <%}%>>Guadalajara</option>
					<option value="Guipúzcoa"
						<%if (address != null && address.getProvince().equals("Guipúzcoa")) {%>
						selected <%}%>>Guipúzcoa</option>
					<option value="Huelva"
						<%if (address != null && address.getProvince().equals("Huelva")) {%>
						selected <%}%>>Huelva</option>
					<option value="Huesca"
						<%if (address != null && address.getProvince().equals("Huesca")) {%>
						selected <%}%>>Huesca</option>
					<option value="Islas Baleares"
						<%if (address != null && address.getProvince().equals("Islas Baleares")) {%>
						selected <%}%>>Islas Baleares</option>
					<option value="Jaén"
						<%if (address != null && address.getProvince().equals("Jaén")) {%>
						selected <%}%>>Jaén</option>
					<option value="La Rioja"
						<%if (address != null && address.getProvince().equals("La Rioja")) {%>
						selected <%}%>>La Rioja</option>
					<option value="Las Palmas"
						<%if (address != null && address.getProvince().equals("Las Palmas")) {%>
						selected <%}%>>Las Palmas</option>
					<option value="León"
						<%if (address != null && address.getProvince().equals("León")) {%>
						selected <%}%>>León</option>
					<option value="Lérida"
						<%if (address != null && address.getProvince().equals("Lérida")) {%>
						selected <%}%>>Lérida</option>
					<option value="Lugo"
						<%if (address != null && address.getProvince().equals("Lugo")) {%>
						selected <%}%>>Lugo</option>
					<option value="Madrid"
						<%if (address != null && address.getProvince().equals("Madrid")) {%>
						selected <%}%>>Madrid</option>
					<option value="Málaga"
						<%if (address != null && address.getProvince().equals("Málaga")) {%>
						selected <%}%>>Málaga</option>
					<option value="Melilla"
						<%if (address != null && address.getProvince().equals("Melilla")) {%>
						selected <%}%>>Melilla</option>
					<option value="Murcia"
						<%if (address != null && address.getProvince().equals("Murcia")) {%>
						selected <%}%>>Murcia</option>
					<option value="Navarra"
						<%if (address != null && address.getProvince().equals("Navarra")) {%>
						selected <%}%>>Navarra</option>
					<option value="Orense"
						<%if (address != null && address.getProvince().equals("Orense")) {%>
						selected <%}%>>Orense</option>
					<option value="Palencia"
						<%if (address != null && address.getProvince().equals("Palencia")) {%>
						selected <%}%>>Palencia</option>
					<option value="Pontevedra"
						<%if (address != null && address.getProvince().equals("Pontevedra")) {%>
						selected <%}%>>Pontevedra</option>
					<option value="Salamanca"
						<%if (address != null && address.getProvince().equals("Salamanca")) {%>
						selected <%}%>>Salamanca</option>
					<option value="Santa Cruz de Tenerife"
						<%if (address != null && address.getProvince().equals("Santa Cruz de Tenerife")) {%>
						selected <%}%>>Santa Cruz de Tenerife</option>
					<option value="Segovia"
						<%if (address != null && !address.getProvince().equals("Segovia")) {%>
						selected <%}%>>Segovia</option>
					<option value="Sevilla"
						<%if (address != null && address.getProvince().equals("Sevilla")) {%>
						selected <%}%>>Sevilla</option>
					<option value="Soria"
						<%if (address != null && address.getProvince().equals("Soria")) {%>
						selected <%}%>>Soria</option>
					<option value="Tarragona"
						<%if (address != null && address.getProvince().equals("Tarragona")) {%>
						selected <%}%>>Tarragona</option>
					<option value="Teruel"
						<%if (address != null && address.getProvince().equals("Teruel")) {%>
						selected <%}%>>Teruel</option>
					<option value="Toledo"
						<%if (address != null && address.getProvince().equals("Toledo")) {%>
						selected <%}%>>Toledo</option>
					<option value="Valencia"
						<%if (address != null && address.getProvince().equals("Valencia")) {%>
						selected <%}%>>Valencia</option>
					<option value="Valladolid"
						<%if (address != null && address.getProvince().equals("Valladolid")) {%>
						selected <%}%>>Valladolid</option>
					<option value="Vizcaya"
						<%if (address != null && address.getProvince().equals("Vizcaya")) {%>
						selected <%}%>>Vizcaya</option>
					<option value="Zamora"
						<%if (address != null && address.getProvince().equals("Zamora")) {%>
						selected <%}%>>Zamora</option>
					<option value="Zaragoza"
						<%if (address != null && address.getProvince().equals("Zaragoza")) {%>
						selected <%}%>>Zaragoza</option>
				</select> 
			<br> 
			<label for="cityAddress">Ciudad : </label>
			<br>
            <input value="<%=customer == null ? "" : address.getCity()%>" type="text" id="cityAddress" name="cityAddress" placeholder="Introduce la ciudad" required>
            <br>
            
            <label for="pcAddress">Codigo Postal: </label><br>
            <input value="<%= customer == null ? "" : address.getPostalCode()%>" type="text" id="pcAddress" name="pcAddress" placeholder="Introduce el Codigo Postal" required>
            <br>
            
            <input type="submit" value="<%= customer == null ? "Enviar" : "Actualizar"%>">
        </form>
       	</div>
    </div>
 
      <%if (customer != null ){ %>
          <form id="delete" action="/StockManagerWebProject/CustomerServlet" method="get">
          <button name="delete" type="submit" value="<%=customer.getId()%>">Borrar</button>
          </form>
        <% } %>
        
</body>


</body>
</html>