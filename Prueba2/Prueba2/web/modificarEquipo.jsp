<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : modificarEquipo
    Created on : 06-11-2016, 14:26:04
    Author     : Coke
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
         <sql:setDataSource user="root" password="" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost:3306/campeonato?zeroDateTimeBehavior=convertToNull" var="conexion"></sql:setDataSource>

        <sql:query var="R" dataSource="${conexion}">
            SELECT * FROM equipo ;
        </sql:query>  
    <center>
        <center>
        <div class="container">
            <div class="panel panel-primary">
                <div class="panel-heading" style="background-color: #000">
                    <h1>  Modificar Equipo </h1>
                </div>
                <div class="panel-body">
        <form action="servletEquipo" method="post">
            <div class="row">
                            <div class="col-lg-9">
                                
            <table class="table" border="8">
            <c:forEach var="coleccion" items="${R.rows}">
                <tr>
                    <td>Nombre</td>
                    <td><input type="text" name="txtNommbreEquipo"  value="${coleccion.nombre}" required/></td>
                </tr>
                <tr>
                    <td>Fecha de Creacion</td>
                    <td>
                        <input type="date" name="dtFechaEquipo" value="${coleccion.fecha_creacion}" required/>
                        
                    </td>
                </tr>
                <tr> 
                        <td colspan="2">
                            <input type="submit" name="btnAccion" value="Modificar" required />
                            <input type="reset" name="btnAccion" value="Limpiar" required />
                        </td>
                    </tr>
                    </c:forEach>
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
