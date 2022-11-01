<%-- 
    Document   : buscar
    Created on : 24-oct-2016, 0:13:44
    Author     : Francisco
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="servAlumno" method="post">
        <table>
            <tr>
                <td>Rut a buscar:</td>
                <td><input type="text" name="txtRut" /></td>
                <td><input type="submit" name="btnAccion" value="Buscar" /></td>
            </tr>
        </table>
        </form>
            
            <table border="1">
                <tbody>
                    <tr>
                        <td>Rut</td>
                        <td><input type="text" name="txtRut" value="${datosAlumno.getRut()}" /></td>
                    </tr>
                    <tr>
                        <td>Nombre</td>
                        <td><input type="text" name="txtNombre" value="${datosAlumno.getNombre()}" /></td>
                    </tr>
                    <tr>
                        <td>Apellido</td>
                        <td><input type="text" name="txtApellido" value="${datosAlumno.getApellido()}" /></td>
                    </tr>
                    <tr>
                        <td>Edad</td>
                        <td><input type="text" name="txtApellido" value="${datosAlumno.getEdad()}" /></td>
                    </tr>
                </tbody>
            </table>
        
        
    </body>
</html>
