<%-- 
    Document   : formulario
    Created on : 30-08-2016, 02:14:30 PM
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
        <form action="validaciones">
            <h1>Formulario</h1>
            <table>
                <tbody>
                    <tr>
                        <td>Nombre:</td>
                        <td><input type="text" name="txtNombre" value="" /></td>
                    </tr>
                    <tr>
                        <td>Edad:</td>
                        <td><input type="text" name="txtEdad" value="" /></td>
                    </tr>
                    <tr>
                        <td>Sexo:</td>
                        <td><input type="radio" name="rdbSexo" value="Masculino" checked="checked" />Masculino<input type="radio" name="rdbSexo" value="Femenino" />Femenino</td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" value="enviar" /></td>
                    </tr>
                </tbody>
            </table>
        </form>

    </body>
</html>
