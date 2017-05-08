<%-- 
    Document   : product-remove
    Created on : 08-may-2017, 12:54:00
    Author     : alumno
--%>
<%@page import="java.io.*"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Product"%>
<%@page import="controller.Archive"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Eliminación de Producto</title>
        <%@include file="/jspf/css-files.jspf" %>
    </head>
    <%
        String name = request.getParameter("name");
        String respuesta = "";
        if (name != null) {
            respuesta = "No se encontraron coincidencias";
            Archive f = new Archive("ficherodb.bin", "rb");
            ArrayList<Product> products = Product.ObjectToProduct(f.leerTodos());
            f.close();
            ArrayList<Product> productsToSave = new ArrayList<>();
            for (Product product : products) {
                if (!product.getName().equals(name)) {
                    productsToSave.add(product);
                } else {
                    respuesta = "Encontré al menos una coincidencia";
                }
            }
            f = new Archive("ficherodb.bin", "wb");
            f.escribirTodos(Product.ProductToObject(productsToSave));
            f.close();
        }
    %>
    <body>
        <%@include file="/jspf/header.jspf"%>
        <section>
            <h1>Eliminación de Producto</h1>
            <%--@include file="/view/nav.html" --%>
            <ol class="breadcrumb">
                <li><a href="/Comercio">Inicio</a></li>
                <li class="active">Eliminación de Productos</li>
            </ol>
            <form action="product-remove.jsp" method="POST">
                <div class="row">
                    <div class="col-lg-4">
                        <div class="form-group">
                            <label for="name">Nombre:</label>
                            <input id="name" class="form-control" type="text" name="name" required />
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-4">
                        <div class="btn-group btn-group-justified">
                            <div class="btn-group" role="group">
                                <input type="submit" value="Borrar" class="btn btn-primary" />
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4">
                        <div class="btn-group btn-group-justified">
                            <div class="btn-group" role="group">
                                <input type="reset" value="Reset" class="btn btn-warning" />
                            </div>
                        </div>
                    </div>
                </div>
            </form>
            <%=respuesta%>
        </section>
        <%@include file="/jspf/footer.jspf"%>
    </body>
    <%@include file="/jspf/js-files.jspf" %>
</html>