<%-- 
    Document   : agregar
    Created on : 11-10-2016, 08:09:28 PM
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
        <h1>Agregar</h1>
        <table>
            <tr>
                <td>Rut:</td>
                <td><input type="text" name="txtRut" value="" /> </td>
            </tr>
            <tr>
                <td>Nombre:</td>
                <td><input type="text" name="txtNombre" value="" /> </td>
            </tr>
            <tr>
                <td>Apellido:</td>
                <td><input type="text" name="txtApellido" value="" /> </td>
            </tr>
            <tr>
                <td>Edad:</td>
                <td><input type="text" name="txtEdad" value="" /> </td>
            </tr>
            <tr>
            <center><td colspan="2"> <input type="submit" value="Enviar" name="btnEnviar" /></center> </td>
            </tr>
        </table>
    </center>
</body>
</html>
