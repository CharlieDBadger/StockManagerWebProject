<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="entities.Supplier,entities.Address,java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form id="manipulateSupplier" action="/StockManagerWebProject/SupplierServlet" method="get">
		<table>
			<thead>
				<tr align="center">
					<th align="center">Borrar</th>
					<th align="center">Modificar</th>
					<th align="center">Nombre</th>
					<th align="center">CIF</th>
					<th align="center">Movil</th>
					<th align="center">Dirección</th>
					<th align="center">Provincia</th>
					<th align="center">Descripción</th>
				</tr>
			</thead>
			<%
			List<Supplier> supplierList = (List<Supplier>) request.getAttribute("customerList");
			for (Supplier supplier : supplierList) {
				Address address = supplier.getAddress();
			%>
			<tbody>
				<tr align="center">
					<td><button name="delete" type="submit"	value="<%=supplier.getId()%>">Borrar</button></td>
					<td><button name="modify" type="submit" value="<%=supplier.getCif()%>">Modificar</button></td>
					<td align="center"><%=supplier.getName()%></td>
					<td align="center"><%=supplier.getCif()%></td>
					<td align="center"><%=supplier.getMobile()%></td>
					<td align="center"><%=address.getName()%></td>
					<td align="center"><%=address.getProvince()%></td>
					<td align="center"><%=supplier.getDescription()%></td>
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