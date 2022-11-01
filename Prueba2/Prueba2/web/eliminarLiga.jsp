<%-- 
    Document   : eliminarLiga
    Created on : 04-11-2016, 05:25:52 PM
    Author     : Duoc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="home.jsp" %>
        <center>
        <h1>Eliminar Liga</h1>
        <form action="servletJugador">
            <table>
                <tr>
                    <td>Id de la Liga</td>
                    <td>
                        <input type="text" name="txtIDEliminarL" required/>
                        <input type="submit" name="btnAccion" value="Eliminar Liga" required />
                    </td>
                </tr>               
            </table>
        </form>
    </center>
    </body>
</html>
