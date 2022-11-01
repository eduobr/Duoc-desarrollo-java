<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : listarAlumno
    Created on : 21-10-2016, 03:35:46 PM
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
        <table>
            <tr>
                <td>                   
                    <table border="1">
                        <tr>
                            <td>Rut</td>
                            <td>Nombre</td>
                            <td>Apellido</td>
                            <td>Edad</td>
                        </tr>
                        <c:forEach var="lista" items="${sessionScope.listaAlumno}">           
                            <tr>
                                <td>${lista.getRut()}</td>
                                <td>${lista.getNombre()}</td>
                                <td>${lista.getApellido()}</td>
                                <td>${lista.getEdad()}</td>
                            </tr>
                        </c:forEach>
                    </table>
                </td>
            </tr>
        </table>
    </body>
</html>
