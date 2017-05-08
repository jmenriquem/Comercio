<%-- 
    Document   : index
    Created on : 02-may-2017, 15:47:17
    Author     : Mario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Comercio App</title>
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
        <link rel="stylesheet" type="text/css" href="css/style.css"/>
    </head>
    <body>
        <header>
            <a href="http://192.168.1.122:8080/Comercio"><img src="img/banner.jpg" alt="Paisaje" /></a>
        </header>
        <section>
            <h1>Comercio</h1>
            <h2>Opciones disponibles</h2>
            <ul>
                <li><a href="view/product-list.jsp">Listado de Productos</a></li>
                <li><a href="view/product-add.jsp">Inserción de Productos</a></li>
                    <%--li><a href="buscaAlumno.jsp">Buscar un alumno</a></li--%>
                <li><a href="view/product-remove.jsp">Borrar un Producto</a></li>
            </ul>
        </section>
        <footer>
            <small>&copy; 2017 IKEA Muebles Fáciles de Montar.</small><br/>
            <small>Diseño web by web8.</small>
        </footer>
    </body>
    <script src="../js/jquery-3.2.1.min.js"></script>
    <script src="../js/bootstrap.min.js"></script>
</html>
