<%-- 
    Document   : insertaAlumno
    Created on : 02-may-2017, 22:33:38
    Author     : Mario
--%>

<%@page import="java.io.*"%>
<%@page import="model.Product"%>
<%@page import="controller.Archive"%>
<%@page import="util.DateUtil"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inserción de Producto</title>
        <%@include file="/jspf/css-files.jspf" %>
    </head>
    <%
        String respuesta;

        try {
            String submitted = request.getParameter("submitted");
            System.out.println("submited: " + submitted);
            String name = request.getParameter("name");
            System.out.println("name: " + name);
            String description = request.getParameter("description");
            String price = request.getParameter("price");
            String inputDate = request.getParameter("inputDate");
            Archive f = new Archive("ficherodb.bin", "ab");
            if (name == null || description == null || price == null || inputDate == null) {
                if (submitted != null) {
                    respuesta = "Alguno de los campos quedó sin rellenar";
                } else {
                    respuesta = " ";
                }
            } else {
                f.writeObject(new Product(name, description, Float.parseFloat(price), DateUtil.parseSpanishDate(inputDate)));
                respuesta = "Se insertó con éxito";
            }
            f.close();
        } catch (NumberFormatException nfe) {
            respuesta = "Error en los numeros";
        }
    %>
    <body>
        <%@include file="/jspf/header.jspf"%>
        <section>
            <h1>Inserción de Producto</h1>
            <%--@include file="/view/nav.html" --%>
            <ol class="breadcrumb">
                <li><a href="/Comercio">Inicio</a></li>
                <li class="active">Inserción de Productos</li>
            </ol>
            <h2>Formulario</h2>
            <form action="product-add.jsp" method="POST">
                <div class="row">
                    <div class="col-lg-4">
                        <div class="form-group">
                            <label for="name">Nombre:</label>
                            <input id="name" class="form-control" type="text" name="name" placeholder="Nombre del artículo">
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-4">
                        <div class="form-group">
                            <label for="description">Descripción:</label>
                            <input id="description" class="form-control" type="text" name="description" placeholder="Descripción del artículo" required>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-4">
                        <div class="form-group">
                            <label for="price">Precio:</label>
                            <input id="price" class="form-control" type="number" name="price" step="0.01" placeholder="Precio del artículo" required>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-4">
                        <div class="form-group">
                            <label for="inputDate">Fecha de Entrada:</label>
                            <input id="inputDate" class="form-control" type="text" name="inputDate" pattern="\d{1,2}/\d{1,2}/\d{4}" placeholder="Fecha de entrada del artículo" required>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-4">
                        <div class="btn-group btn-group-justified">
                            <div class="btn-group" role="group">
                                <input type="submit" value="Enviar" class="btn btn-primary">
                            </div>
                            <div class="btn-group" role="group">
                                <input type="reset" value="Reset" class="btn btn-warning">
                            </div>
                            <input type="hidden" name="submitted" value="true"/>
                        </div>
                    </div>
                </div>
            </form>
            <p><%=respuesta%></p>
        </section>
        <%@include file="/jspf/footer.jspf"%>
    </body>
    <%@include file="/jspf/js-files.jspf" %>
</html>
