<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : insertar
    Created on : 21-10-2016, 04:06:56 PM
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
        <h1>Ingresar</h1>
        <form action="servletAlumno" method="post"> 
            <table border="1">
                <tr>
                    <td>Rut:</td>
                    <td> <input type="text" name="txtRut" value="" /></td>
                </tr>
                <tr>
                    <td>Nombre:</td>
                    <td><input type="text" name="txtNombre" value="" /></td>
                </tr>
                <tr>
                    <td>Apellido:</td>
                    <td><input type="text" name="txtApellido" value="" /></td>
                </tr>
                <tr>
                    <td>Edad:</td>
                    <td>
                        <select name="cboEdad">
                            <c:forEach var="edad" begin="5" end="60">
                            <option>${edad}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td> <input type="submit" value="Guardar" name="btnAction" /> </td>
                    <td> <input type="reset" value="Eliminar" name="btnAction" /> </td>

                </tr>
            </table>
        </form>
        ${mensaje}
    </body>
</html>
