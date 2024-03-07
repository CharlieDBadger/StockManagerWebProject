 <!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="Creacion de Proyecto JAVA Hibernate-MAVEN-Bootstrap-CSS-HTML-Responsive">
    <meta name="authors" content="Carlos & David">
    <title>StockManager v.2</title>
    <!-- Favicon -->
    <link rel="icon" href="assets/imgs/favicon.ico" type="image/x-icon">
    <!-- Coleccion de font icons -->
    <link rel="stylesheet" href="assets/themify-icons.css">
    <!-- Bootstrap + stilo CSS -->
    <link rel="stylesheet" href="assets/stock.css">
</head>

<body>
    <!-- Menu Dropdown y cabecera responsive-->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container-fluid">
            <a class="navbar-brand">
                <h4><strong class="text-primary">Stock</strong><strong><span class="text-bold">Manager</span></strong>
                </h4>
            </a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                data-bs-target="#navbarNavDarkDropdown" aria-controls="navbarNavDarkDropdown" aria-expanded="false"
                aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNavDarkDropdown">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDarkDropdownMenuLink" role="button"
                            data-bs-toggle="dropdown" aria-expanded="false">
                            Altas
                        </a>
                        <ul class="dropdown-menu dropdown-menu-dark" aria-labelledby="navbarDarkDropdownMenuLink">
                            <li><a class="dropdown-item" href="UserForm.jsp">Usuarios</a></li>
                            <!-- <li><a class="dropdown-item" href="Ref2">Clientes</a></li>
                            <li><a class="dropdown-item" href="Ref3">Articulos</a></li>
                            <li><a class="dropdown-item" href="Ref3">Proveedores</a></li> -->
                            <!-- <li><a class="dropdown-item" href="Ref4">Facturas</a></li>
                        <li><a class="dropdown-item" href="Ref5">Entrada</a></li> -->
                        </ul>
                    </li>
                    <!-- Nuevo botón de dropdown "Consultas" -->
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDarkDropdownMenuLink2" role="button"
                            data-bs-toggle="dropdown" aria-expanded="false">
                            Consultas
                        </a>
                        <ul class="dropdown-menu dropdown-menu-dark" aria-labelledby="navbarDarkDropdownMenuLink2">
                            <!-- <li><a class="dropdown-item" href="Ref1">Usuarios</a></li>
                            <li><a class="dropdown-item" href="Ref2">Clientes</a></li>
                            <li><a class="dropdown-item" href="Ref3">Articulos</a></li>
                            <li><a class="dropdown-item" href="Ref3">Proveedores</a></li> -->
                            <!-- <li><a class="dropdown-item" href="#">Proveedores</a></li>
                            <li><a class="dropdown-item" href="#">Facturas</a></li>
                            <li><a class="dropdown-item" href="#">Entrada</a></li> -->
                        </ul>
                    </li>
                    <!-- Nuevo botón de dropdown "Consultas" -->
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDarkDropdownMenuLink2" role="button"
                            data-bs-toggle="dropdown" aria-expanded="false">
                            Listados
                        </a>
                        <ul class="dropdown-menu dropdown-menu-dark" aria-labelledby="navbarDarkDropdownMenuLink2">
                            <li><a class="dropdown-item" href="/StockManagerWebProject/UserListServlet">Usuarios</a></li>
                            <!-- <li><a class="dropdown-item" href="Ref2">Clientes</a></li>
                            <li><a class="dropdown-item" href="Ref3">Articulos</a></li>
                            <li><a class="dropdown-item" href="Ref3">Proveedores</a></li>/li> -->
                        </ul>
                    </li>
                    <!-- Botón "Cerrar Sesión" -->
                    <li class="nav-item">
                        <a class="nav-link" href="index.jsp">Cerrar Sesión</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <!-- Navegador y Menu Responsive-->
    <header class="d-flex justify-content-center">
        <div class="header col-md-6 mt-4 mb-4 justify-content-center d-md-block">
            <div class="container text-center text-primary">
                <h3><strong>Proyecto realizado por: </strong><span class="text-light">Carlos y
                        David</span><br><br><strong>Tecnologias Usadas: </strong><span
                        class="text-light">Hibernate-MAVEN-Bootstrap-CSS-HTML-Responsive</span></h3>
                        <br>
                <div class="content mt-1 text-left text-light">
                    <br>
                    <a href="/StockManagerWebProject/login.jsp">Login</a>
                    <div>
                        <br>
                        <h5>URL Usuario</h5>
                        <a href="/StockManagerWebProject/UserForm.jsp">UserForm</a>
                        <br>
                        <a href="/StockManagerWebProject/UserListServlet">ListaUsuarios</a>
                    </div>
                </div>
            </div>
        </div>
    </header>
    <!-- Pie de Pagina / Creditos -->
    <footer class="navbar navbar-fixed-bottom py-3 bg-dark text-light">
        <div class="container text-center">
            <p class="mb-1 media-body font-weight-light">Design & Code by: <a href="https://github.com/CharlieDBadger/">
                    Carlos</a> & <a href="https://github.com/DPM81Dev/">David</a></p>
        </div>
    </footer>
    <!-- JQuery,Bootstrap, JS  -->
    <script src="assets/jquery/jquery-3.4.1.js"></script>
    <script src="assets/bootstrap/bootstrap.bundle.js"></script>
    <script src="assets/bootstrap/bootstrap.affix.js"></script>
    <script src="assets/script.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>

</html>