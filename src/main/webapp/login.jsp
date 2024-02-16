<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Login - StockManager</title>
    <!--Stilos CSS.-->
    <link rel="stylesheet" href="./assets/estilo.css">
    <!--JavaScrip & JQuery-->
    <script src='./assets/jquery.min.js'></script>
    <script src="./assets/script.js"></script>
</head>

<body>
    <div class="contenedor cf">
        <div class="logo"></div>
			<form id="login" action="/StockManagerWebProject/LoginServlet" method="post">
            <label for="userName">Usuario:</label>
            <input type="text" id="userName" name="userName" placeholder="Introduce tu Usuario" required><br>
            <label for="userPassword">Password:</label>
            <input type="password" id="userPassword" name="userPassword" placeholder="Introduce tu Password" required><br>
            <input type="submit" value="Enviar">
        </form>
    </div>
</body>

</html>