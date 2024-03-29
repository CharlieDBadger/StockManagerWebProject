<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="entities.User,tools.Tools"%>
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
       		<%
		User user = (User) request.getAttribute("userToModify");
		%>
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
                    <!-- Nuevo botÃ³n de dropdown "Consultas" -->
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
                    <!-- Nuevo botÃ³n de dropdown "Consultas" -->
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
                    <!-- BotÃ³n "Cerrar SesiÃ³n" -->
                    <li class="nav-item">
                        <a class="nav-link" href="index.jsp">Cerrar Sesion</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <!-- Navegador y Menu Responsive-->
    <header class="d-flex justify-content-center">
        <div class="header col-md-4 mt-4 mb-4 justify-content-center d-md-block">
            <form class="header-form container" id="createUser" action="/StockManagerWebProject/UserServlet"
                method="post">
                    <div class="head"><strong>Formulario<span class="text-primary"> Alta</span></strong></div>
                    <br>
                    <div class="container">
                        <div class="form-group">
                            <label class="text-primary" for="dni"><strong>Nombre:</strong></label><br>
                            <input type="text" name="name" value="<%= user == null ? "" : user.getName() %>" id="name" class="form-control" placeholder="Nombre" required>
                        </div>
                        <div class="form-group">
                            <label class="text-primary" for="lastName"><strong>Apellido:</strong></label><br>
                            <input type="text" name="lastName" value="<%= user == null ? "" : user.getLastName()%>" id="lastName" class="form-control" placeholder="Apellido" required>
                        </div>
                        <div class="form-group">
                            <label class="text-primary" for="dni"><strong>DNI:</strong></label><br>
                            <input type="text" name="dni" value="<%= user == null ? "" : user.getDni()%>" id="dni" class="form-control" placeholder="Introduce DNI" required>
                        </div>
                        <div class="form-group">
                            <label class="text-primary" for="email"><strong>Email:</strong></label><br>
                            <input type="email" name="email" value="<%= user == null ? "" : user.getMail()%>" id="email" class="form-control" placeholder="Email" required>
                        </div>
                        <div class="form-group">
                            <label class="text-primary" for="password"><strong>Password:</strong></label><br>
                            <input type="password" name="password" value="<%= user == null ? "" : user.getPassword()%>" id="password" class="form-control" placeholder="Password" required>
                        </div>
                        <div class="form-group">
                            <label class="text-primary" for="idUser" ><strong>ID Usuarios:</strong></label><br>
                            <input type="text" name="idUser" value="<%= user == null ? "" : user.getId()%>" id="idUser" class="form-control" placeholder="No se le ha asignado un ID" readonly>
                        </div>
                        <!-- Validado solo coge numeros, ningun caracter o simbolo. Y tienen que ser 9 Digitos-->
                        <div class="form-group">
                            <label class="text-primary" for="telephone"><strong>Telefono:</strong></label><br>
                            <input type="tel" pattern="[0-9]{9}" maxlength="9"  name="telephone" value="<%= user == null ? "" : user.getPhone()%>" id="telephone" class="form-control" placeholder="Telefono" required>
                        </div>
                        <div class="form-group">
                            <label class="text-primary" for="role"><strong>Cargo:</strong></label><br>
                        <select id="role" name="role" required>
                            <option class="text-muted" disabled>Seleccione Cargo</option>
                            <option value="Usuario" <% if (user == null || !user.getRole().equals("Admin")) { %> selected <% } %>>Usuario</option>
                            <option value="Admin" <% if (user != null && user.getRole().equals("Admin")) { %> selected <% } %>>Admin</option>
                        </select>
                        </div>
                        <label class="text-primary" for="gender"><strong>Genero:</strong></label><br>
                        <div class="form-check-inline text-center">
                            <label class="text-primary" for="male"><strong>Masculino</strong></label><br>
                            <input type="radio" name="gender" id="male" value="Masculino" <% if (user != null && user.getGender().equals("Masculino")) { %> checked <% } %> class="form-control" placeholder=Masculino required>
                            <label class="text-primary" for="male"><strong>Femenino</strong></label><br>
                            <input type="radio" name="gender" id="female" value="Femenino" <% if (user != null && user.getGender().equals("Femenino")) { %> checked <% } %> class="form-control" placeholder=Femenino required>
                            <label class="text-primary" for="male"><strong>Otro</strong></label><br>
                            <input type="radio" name="gender" id="other" value="Otro" <% if (user != null && user.getGender().equals("Otro")) { %> checked <% } %> class="form-control" placeholder=Otro required>
                        </div>
                        <br><br>

                      <div class="form-group">
                            <label class="text-primary" for="birth"><strong>Fecha de Nacimiento:</strong></label><br>
                            <input type="date" name="birth" value="<%= user == null ? "" : Tools.convertDateToString(user.getBirth())%>" id="birth"><br>
                        </div>
                    </div>
                    <div class="footer">
                        <button type=submit class="btn btn-primary btn-block text-center mt-5 mb-4"><strong><%= user == null ? "Enviar" : "Actualizar"%></strong></button>

                        <%if (user != null ){ %>
                        <button name="delete" type="submit" class="btn btn-primary btn-block text-center mt-5 mb-4" formaction="/StockManagerWebProject/UserServlet" formmethod = "get" value="<%=user.getId()%>"><strong>Borrar</strong></button>
       					<% } %>
                </div>
            </div>
        </form>
      </div>
    </header>
<!-- Pie de Pagina / Creditos -->
<footer class="navbar navbar-fixed-bottom py-3 bg-dark text-light"> 
    <div class="container text-center">
        <p class="mb-1 media-body font-weight-light">Design & Code by: <a href="https://github.com/CharlieDBadger/"> Carlos</a> & <a href="https://github.com/DPM81Dev/">David</a></p>
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

