<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="entities.Customer,entities.Address,java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form id="manipulateCustomer" action="/StockManagerWebProject/CustomerServlet" method="get">
		<table>
			<thead>
				<tr align="center">
					<th align="center">Borrar</th>
					<th align="center">Modificar</th>
					<th align="center">Nombre</th>
					<th align="center">DNI</th>
					<th align="center">Movil</th>
					<th align="center">Dirección</th>
					<th align="center">Provincia</th>
					<th align="center">Observación</th>
				</tr>
			</thead>
			<%
			List<Customer> customerList = (List<Customer>) request.getAttribute("customerList");
			for (Customer customer : customerList) {
				Address address = customer.getAddress();
			%>
			<tbody>
				<tr align="center">
					<td><button name="delete" type="submit"	value="<%=customer.getId()%>">Borrar</button></td>
					<td><button name="modify" type="submit" value="<%=customer.getDni()%>">Modificar</button></td>
					<td align="center"><%=customer.getName()%></td>
					<td align="center"><%=customer.getDni()%></td>
					<td align="center"><%=customer.getMobile()%></td>
					<td align="center"><%=address.getName()%></td>
					<td align="center"><%=address.getProvince()%></td>
					<td align="center"><%=customer.getObservation()%></td>
				</tr>
				<!-- Puedes agregar más filas de datos aquí -->
			</tbody>
		</table>
	</form>
		<%
	}
	%>
	
</body>
</html>