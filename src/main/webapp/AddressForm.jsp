<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <h2>Formulario de Dirección</h2>
    <form id="AddressForm" action="/StockManagerWebProject/AddressServlet" method="post">
        <input type="hidden" name="idDireccion" value="999" />
        <label for="nombreDireccion">Nombre:</label>
        <input type="text" id="nombreDireccion" name="nombreDireccion" value="a" required /><br><br>
        <label for="provinciaDireccion">Provincia:</label>
        <input type="text" id="provinciaDireccion" name="provinciaDireccion" value="a" required /><br><br>
        <label for="ciudadDireccion">Ciudad:</label>
        <input type="text" id="ciudadDireccion" name="ciudadDireccion" value="a" required /><br><br>
        <label for="codigoPostalDireccion">Código Postal:</label>
        <input type="text" id="codigoPostalDireccion" name="codigoPostalDireccion" value="a" required /><br><br>
        <input type="submit" value="Enviar" />
</form>
</body>
</body>
</html>