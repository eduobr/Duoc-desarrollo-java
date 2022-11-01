<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : ingresarEquipo
    Created on : 04-11-2016, 04:52:21 PM
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
        <center>
        <div class="container">
            <div class="panel panel-primary">
                <div class="panel-heading" style="background-color: #000">
                    <h1>  Ingreso del Equipo </h1>
                </div>
                <div class="panel-body">
        <form action="servletEquipo" method="post">
            <div class="row">
                            <div class="col-lg-9">
                                
            <table class="table" border="8">
                <tr>
                    <td>Nombre</td>
                    <td><input type="text" name="txtNommbreEquipo"  placeholder="ingrese el nombre del club" required/></td>
                </tr>
                <tr>
                    <td>Fecha de Creacion</td>
                    <td>
                        <input type="date" name="dtFechaEquipo" required/>
                        
                    </td>
                </tr>
                <tr> 
                        <td colspan="2">
                            <input type="submit" name="btnAccion" value="Guardar" required />
                            <input type="reset" name="btnAccion" value="Limpiar" required />
                        </td>
                    </tr>
                   
            </table>
                </div>
            </div>
                </div>
        </form>
                    ${mensajeInsertar}
                    </div>
            </div>
        </center>
    </body>
</html>
