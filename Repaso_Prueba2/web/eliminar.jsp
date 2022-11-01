<%-- 
    Document   : eliminar
    Created on : 05-09-2016, 19:16:45
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
        <div>
            <form action="servletCanciones">
                <center>
                    <h1>Eliminar Cancion</h1>
                    <table>
                        <tr>
                            <td>Nombre Cancion:</td>
                            <td><input type="text" name="txtEliminarCancion" value="" /></td>
                        </tr>
                        <tr>
                            <td>Eliminar:</td>
                            <td><input type="submit" value="Eliminar" name="btnAccion" /></td>
                        </tr>
                    </table>
                </center>
            </form>
        </div>
        <div>
            <center>
                ${mensaje}
            </center>
        </div>
    </body>
</html>
