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
                <h4><strong class="text-primary">Stock</strong><strong><span class="text-bold">Manager</span></strong></h4>
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
                            <li><a class="dropdown-item" href="Ref2">Clientes</a></li>
                            <li><a class="dropdown-item" href="Ref3">Articulos</a></li>
                            <li><a class="dropdown-item" href="Ref3">Proveedores</a></li>
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
                            <li><a class="dropdown-item" href="Ref1">Usuarios</a></li>
                            <li><a class="dropdown-item" href="Ref2">Clientes</a></li>
                            <li><a class="dropdown-item" href="Ref3">Articulos</a></li>
                            <li><a class="dropdown-item" href="Ref3">Proveedores</a></li>
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
                            <li><a class="dropdown-item" href="Ref2">Clientes</a></li>
                            <li><a class="dropdown-item" href="Ref3">Articulos</a></li>
                            <li><a class="dropdown-item" href="Ref3">Proveedores</a></li>/li>
                        </ul>
                    </li>
                    <!-- Botón "Cerrar Sesión" -->
                    <li class="nav-item">
                        <a class="nav-link" href="#">Cerrar Sesión</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <!-- Fin menu -->
    <header class="d-flex justify-content-center">
        <div class="header col-md-8 mt-4 mb-4 justify-content-center d-md-block w-100 text-nowrap">
            <form class="header-form">
                <form class="container" id="manipulateUser" action="/StockManagerWebProject/UserServlet" method="get">
                    <div class="container">
                        <div class="head mb-3" ><strong>Consulta de<span class="text-primary"> Usuarios</span></strong></div>
                        <input class="form-control" id="myInput" type="text" placeholder="Buscar..">
                        </div>
                        <div class="scrollable-table">
                            <div class="container mt-3">
                                <div class="row table-responsive d-block d-md-table">
                                    <div class="col-md-12 mt-4 mb-4">
                                        <table class="table table-responsive width ml-auto d-block d-md-table">
                                    <thead class="col-md-12" align="center">
                                        <tr class="col-md-12">
                                            <th scope="col-md-12"><button class="btn btn-basic btn-sm">Editar</button></th>
                                            <th scope="col-md-12"><button class="btn btn-basic btn-sm">Borrar</button></th>
                                            <th scope="col-md-12"><button class="btn btn-basic btn-sm">Nombre</button></th>
                                            <th scope="col-md-12"><button class="btn btn-basic btn-sm">Apellido</button></th>
                                            <th scope="col-md-12"><button class="btn btn-basic btn-sm">DNI</button></th>
                                            <th scope="col-md-12"><button class="btn btn-basic btn-sm">Email</button></th>
                                            <th scope="col-md-12"><button class="btn btn-basic btn-sm">Telefono</button></th>
                                            <th scope="col-md-12"><button class="btn btn-basic btn-sm">Cargo</button></th>
                                            <th scope="col-md-12"><button class="btn btn-basic btn-sm">Genero</button></th>
                                            <th scope="col-md-12"><button class="btn btn-basic btn-sm">Fecha</button></th>
                                        </tr>
                                    </thead>
                                    <tbody id="myTable" class="col-md-12" align="center">
                                        <tr>
                                            <td width ml-auto><img src="assets/imgs/editar.png" alt="editar"></td>
                                            <td width ml-auto><img src="assets/imgs/borrar.png" alt="borrar"></td>
                                            <td width ml-auto>Linea de datos</td>
                                            <td>Linea de datos</td>
                                            <td>Linea de datos</td>
                                            <td>Linea de datos</td>
                                            <td>Linea de datos</td>
                                            <td>Linea de datos</td>
                                            <td>Linea de datos</td>
                                        </tr>
                                        <tr>
                                            <td><img src="assets/imgs/editar.png" alt="editar"></td>
                                            <td><img src="assets/imgs/borrar.png" alt="borrar"></td>
                                        </tr>                                        
                                        <tr>
                                            <td><img src="assets/imgs/editar.png" alt="editar"></td>
                                            <td><img src="assets/imgs/borrar.png" alt="borrar"></td>
                                        </tr>
                                        <tr>
                                            <td><img src="assets/imgs/editar.png" alt="editar"></td>
                                            <td><img src="assets/imgs/borrar.png" alt="borrar"></td>
                                        </tr>
                                        <tr>
                                            <td><img src="assets/imgs/editar.png" alt="editar"></td>
                                            <td><img src="assets/imgs/borrar.png" alt="borrar"></td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </header>
    <!-- Pie de Pagina / Creditos -->
    <footer class="footer py-3 bg-dark text-light">
        <div class="container text-center">
            <p class="mb-1 media-body font-weight-light">Desing & Code by: <a href="https://github.com/CharlieDBadger/">
                    Carlos</a> & <a href="https://github.com/DPM81Dev/">David</a></p>
        </div>
    </footer>
    <!-- JQuery,Bootstrap, JS  -->
    <script src="assets/jquery/jquery-3.4.1.js"></script>
    <script src="assets/bootstrap/bootstrap.bundle.js"></script>
    <script src="assets/bootstrap/bootstrap.affix.js"></script>
    <script src="assets/script.js"></script>
    <!-- Libreria para Dropdowns-->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    <!-- JS para realizar busqueda filtrando datos coincidentes. -->
    <script>
        $(document).ready(function () {
            $("#myInput").on("keyup", function () {
                var value = $(this).val().toLowerCase();
                $("#myTable tr").filter(function () {
                    $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
                });
            });
        });
    </script>
</body>

</html>