<%-- 
    Document   : menu
    Created on : 05-09-2016, 18:59:16
    Author     : SP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
    </head>
    <body>
        
        <%
            HttpSession sesion = request.getSession();
            if(sesion.getAttribute("usuario") == null){
                response.sendRedirect("login.jsp");
            }    
        %>
        <br>
        <div>
            <form>
                <center>
                    <table border="1">
                        <tr>
                            <td>
                                <table class="table table-striped">
                                    <h1>Menu Principal</h1>
                                    <tr>
                                        <td><a href="agregar.jsp">Agregar</a></td>
                                        <td><a href="eliminar.jsp">Eliminar</a></td>
                                        <td><a href="listar.jsp">Listar</a></td>
                                    </tr>
                                </table>
                            </td>
                        </tr>
                    </table>         
                </center>
            </form>
        </div>
    
    </body>
</html>
