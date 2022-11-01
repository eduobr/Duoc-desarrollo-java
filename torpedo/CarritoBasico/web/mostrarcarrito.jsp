<%-- 
    Document   : mostrarcarrito
    Created on : 29-sep-2016, 23:44:32
    Author     : Francisco
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Producto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
    HttpSession sesion = request.getSession();
    ArrayList<Producto> carrito = (ArrayList<Producto>)sesion.getAttribute("carrito");
   
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <!-- Latest compiled JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <body style="div { text-align: center; }">
    <center>
        <h1>Su carrito de compras!</h1>
        <div class="row">
            <div class="col-sm-6"></div>
            <div class="col-sm-6"><a href="index.jsp"><img src="img/tienda.png" width="64" height="64"></a></div>
            </div>
        <div>
        <table border="2" >
            <tr>
                <td>
                    <table class="table table-striped">
                        <tr>
                            <td> 
                            </td>
                            <th>NOMBRE</th>
                            <th>PRECIO</th>
                            <th>CANTIDAD</th>
                        </tr>
                        <% for(int i=0; i<carrito.size(); i++) { %>
                        <tr>
                            <td><img src="<%= carrito.get(i).getImagen()%>" width="100" height="100"></td>
                            <td><%= carrito.get(i).getNombre()%></td>
                            <td><%= carrito.get(i).getPrecio() %></td>
                            <td><%= carrito.get(i).getCantidad() %></td>
                        </tr>
                        <%}%>
                    </table>
                </td>
            </tr>
        </table>
        </div>
    </body>
</html>
