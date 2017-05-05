<%-- 
    Document   : listaAlumno
    Created on : 02-may-2017, 23:16:50
    Author     : Mario
--%>

<%@page import="java.io.*"%>
<%@page import="java.io.EOFException"%>
<%@page import="model.Product"%>
<%@page import="controller.Archive"%>
<%@page import="util.DateUtil"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de Productos</title>
        <%@include file="/jspf/css-files.jspf" %>
    </head>
    <body>
        <%@include file="/jspf/header.jspf"%>
        <section>
            <h1>Listado de Productos</h1>
            <%--@include file="/view/nav.html" --%>
            <ol class="breadcrumb">
                <li><a href="/Comercio">Inicio</a></li>
                <li class="active">Listado de Productos</li>
            </ol>
            <div class="datagrid">
                <table>
                    <thead>
                        <tr>
                            <th>Nombre</th>
                            <th>Descripcion</th>
                            <th>Precio</th>
                            <th>Fecha Entrada</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            ObjectInputStream ois;
                            String respuesta = "";

                            Archive f = new Archive("ficherodb.bin", "rb");
                            Product aux = (Product) f.readObject();
                            while (aux != null) {

                                respuesta += "<tr>\n"
                                        + "<td>" + aux.getName() + "</td>\n"
                                        + "<td>" + aux.getDescription() + "</td>\n"
                                        + "<td>" + String.format("%10.2f", aux.getPrice()) + " &euro;</td>\n"
                                        + "<td>" + DateUtil.spanishDateToString(aux.getInputDate()) + "</td>\n"
                                        + "</tr>\n";
                                //respuesta+=aux.toString();

                                aux = (Product) f.readObject();
                            }

                            f.close();
                        %>
                        <%=respuesta%>
                    </tbody>
                    <tfoot><tr><td colspan="4"><div id="paging"><ul><li><a href="#"><span>Previous</span></a></li><li><a href="#" class="active"><span>1</span></a></li><li><a href="#"><span>2</span></a></li><li><a href="#"><span>3</span></a></li><li><a href="#"><span>4</span></a></li><li><a href="#"><span>5</span></a></li><li><a href="#"><span>Next</span></a></li></ul></div></tr></tfoot>
                </table>
            </div>
        </section>
        <%@include file="/jspf/footer.jspf"%>
    </body>
    <%@include file="/jspf/js-files.jspf" %>
</html>
