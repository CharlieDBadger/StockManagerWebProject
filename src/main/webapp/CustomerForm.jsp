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
            
            <p>Direcci�n</p>
            <label for="addressName">Nombre: </label><br>
            <input name="addressName" value="<%= customer == null ? "" : address.getName()%>" type="text" id="addressName" placeholder="Introduce el nombre de la calle" required>
            <br> 
            <label for="provincias">Selecciona una provincia:</label> 
            <br> 
            <select id="provincias" name="province">
					<option value="�lava"
						<%if (address != null && address.getProvince().equals("�lava")) {%>
						selected <%}%>>�lava</option>
					<option value="Albacete"
						<%if (address != null && address.getProvince().equals("Albacete")) {%>
						selected <%}%>>Albacete</option>
					<option value="Alicante"
						<%if (address != null && address.getProvince().equals("Alicante")) {%>
						selected <%}%>>Alicante</option>
					<option value="Almer�a"
						<%if (address != null && address.getProvince().equals("Almer�a")) {%>
						selected <%}%>>Almer�a</option>
					<option value="�vila"
						<%if (address != null && address.getProvince().equals("�vila")) {%>
						selected <%}%>>�vila</option>
					<option value="Badajoz"
						<%if (address != null && address.getProvince().equals("Badajoz")) {%>
						selected <%}%>>Badajoz</option>
					<option value="Barcelona"
						<%if (address != null && address.getProvince().equals("Barcelona")) {%>
						selected <%}%>>Barcelona</option>
					<option value="Burgos"
						<%if (address != null && address.getProvince().equals("Burgos")) {%>
						selected <%}%>>Burgos</option>
					<option value="C�ceres"
						<%if (address != null && address.getProvince().equals("C�ceres")) {%>
						selected <%}%>>C�ceres</option>
					<option value="C�diz"
						<%if (address != null && address.getProvince().equals("C�diz")) {%>
						selected <%}%>>C�diz</option>
					<option value="Cantabria"
						<%if (address != null && address.getProvince().equals("Cantabria")) {%>
						selected <%}%>>Cantabria</option>
					<option value="Castell�n"
						<%if (address != null && address.getProvince().equals("Castell�n")) {%>
						selected <%}%>>Castell�n</option>
					<option value="Ceuta"
						<%if (address != null && address.getProvince().equals("Ceuta")) {%>
						selected <%}%>>Ceuta</option>
					<option value="Ciudad Real"
						<%if (address != null && address.getProvince().equals("Ciudad Real")) {%>
						selected <%}%>>Ciudad Real</option>
					<option value="C�rdoba"
						<%if (address != null && address.getProvince().equals("C�rdoba")) {%>
						selected <%}%>>C�rdoba</option>
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
					<option value="Guip�zcoa"
						<%if (address != null && address.getProvince().equals("Guip�zcoa")) {%>
						selected <%}%>>Guip�zcoa</option>
					<option value="Huelva"
						<%if (address != null && address.getProvince().equals("Huelva")) {%>
						selected <%}%>>Huelva</option>
					<option value="Huesca"
						<%if (address != null && address.getProvince().equals("Huesca")) {%>
						selected <%}%>>Huesca</option>
					<option value="Islas Baleares"
						<%if (address != null && address.getProvince().equals("Islas Baleares")) {%>
						selected <%}%>>Islas Baleares</option>
					<option value="Ja�n"
						<%if (address != null && address.getProvince().equals("Ja�n")) {%>
						selected <%}%>>Ja�n</option>
					<option value="La Rioja"
						<%if (address != null && address.getProvince().equals("La Rioja")) {%>
						selected <%}%>>La Rioja</option>
					<option value="Las Palmas"
						<%if (address != null && address.getProvince().equals("Las Palmas")) {%>
						selected <%}%>>Las Palmas</option>
					<option value="Le�n"
						<%if (address != null && address.getProvince().equals("Le�n")) {%>
						selected <%}%>>Le�n</option>
					<option value="L�rida"
						<%if (address != null && address.getProvince().equals("L�rida")) {%>
						selected <%}%>>L�rida</option>
					<option value="Lugo"
						<%if (address != null && address.getProvince().equals("Lugo")) {%>
						selected <%}%>>Lugo</option>
					<option value="Madrid"
						<%if (address != null && address.getProvince().equals("Madrid")) {%>
						selected <%}%>>Madrid</option>
					<option value="M�laga"
						<%if (address != null && address.getProvince().equals("M�laga")) {%>
						selected <%}%>>M�laga</option>
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