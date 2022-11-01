<%-- 
    Document   : index
    Created on : 30-08-2016, 01:52:45 PM
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
    <center>
        <form action="validarUsuario.jsp">
            <table>
                <tr>
                    <td>Usuario:</td>
                    <td><input type="text" name="txtUsuario" value="" /></td>
                </tr>
                <tr>
                    <td>Contraseña:</td>
                    <td><input type="text" name="txtContrasena" value="" /></td>
                </tr>
                <tr>
                    <td><input type="reset" value="limpiar" /></td>
                    <td><input type="submit" value="enviar" /></td>
                </tr>
            </table>
        </form>
    </center>
    </body>
</html>
