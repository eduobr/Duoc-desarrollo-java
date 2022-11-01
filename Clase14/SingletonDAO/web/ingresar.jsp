<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : ingresar
    Created on : 21-10-2016, 12:39:15 PM
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
        
        <h1>Hello World!</h1>
        <form action="servAlumno" method="post">
            <table border="1">
                <tbody>
                    <tr>
                        <td>Rut</td>
                        <td><input type="text" name="txtRut" required /></td>
                    </tr>
                    <tr>
                        <td>Nombre</td>
                        <td><input type="text" name="txtNombre" required /></td>
                    </tr>
                    <tr>
                        <td>Apellido</td>
                        <td><input type="text" name="txtApellido" required /></td>
                    </tr>
                    <tr>
                        <td>Edad</td>
                        <td>
                            <select name="cboEdad">
                                <c:forEach var="edad" begin="5" end="80">
                                    <option>${edad}</option>
                                </c:forEach>     
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="submit" name="btnAccion" value="Guardar" required />
                            <input type="reset" name="btnAccion" value="Limpiar" required />
                        </td>
                    </tr>
                </tbody>
            </table>
        </form>
        ${mensajeInsertar}
    </body>
</html>
