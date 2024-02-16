<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login - StockManager</title>
        <!--JavaScrip & JQuery-->
    <script src='./assets/jquery.min.js'></script>
    <script src="./assets/script.js"></script>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        /* Estilos personalizados */
        body {
            background-color: #323334; /* Color de fondo gris oscuro */
        }
        .login-container {
            max-width: 400px;
            margin: 0 auto;
            padding: 20px;
            background-color: #ffffff; /* Color de fondo del formulario */
            border-radius: 10px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1); /* Sombra suave */
        }
        .login-form input[type="text"],
        .login-form input[type="password"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ced4da; /* Borde gris claro */
            border-radius: 5px;
        }
        .login-form input[type="checkbox"] {
            margin-right: 5px;
        }
        .login-form .btn-primary {
            background-color: #818181; /* Color de botón gris claro */
            border: none;
            width: 100%;
        }
        .login-form .btn-primary:hover {
            background-color: #606263; /* Color de botón gris oscuro al pasar el ratón */
        }
        .footer{
            position: center;
            font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif;
            font-style: normal;
            color: bisque;
        }
    </style>
</head>
<body>
    <div class="container mt-5">
        <div class="login-container">
            <h2 class="text-center mb-4">Inicio de Sesión</h2>
            <form class="login-form" id="login" action="/StockManagerWebProject/LoginServlet" method="post">
                <div class="form-group">
                    <p>Usuario</p>
                    <input type="text" class="form-control" placeholder="Introduce tu usuario" required>
                </div>
                <div class="form-group">
                    <p>Contraseña</p>
                    <input type="password" class="form-control" placeholder="Introduce tu contraseña" required>
                </div>
                <div class="form-group form-check">
                    <input type="checkbox" class="form-check-input" id="rememberMe">
                    <label class="form-check-label" for="rememberMe">Recordarme</label>
                </div>
                <button type="submit" class="btn btn-primary">Iniciar Sesión</button>
            </form>
        </div>
    </div>
    <!-- Agrega el enlace a Bootstrap JS (opcional) -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <div class="footer" align="center"> Designed & Coded by Carlos & David</div>
</body>
</html>