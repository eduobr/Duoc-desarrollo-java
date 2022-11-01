<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : listarEquipo
    Created on : 04-11-2016, 13:22:27
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
            SELECT * FROM equipo;
        </sql:query>  
        <%--  bootstrap --%>

        <div class="container">
            <div class="panel panel-primary">
                <div class="panel-heading" style="background-color: #000">
                    <h1>  Listado de Equipos </h1>
                </div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-lg-9">
                            <form action="servletEquipo" method="post">
                                <table  class="table" border="8">                                    
                                    <tr>
                                        <td>id</td>
                                        <td>Nombre</td>
                                        <td>Fecha</td>

                                    </tr>
                                    <c:forEach var="coleccion" items="${R.rows}">
                                        <tr>
                                            <td><c:out value="${coleccion.id_equipo}"/></td>
                                            <td><c:out value="${coleccion.nombre}"/></td>
                                            <td><c:out value="${coleccion.fecha_creacion}"/></td>                                                
                                        </tr>
                                    </c:forEach>
                                </table>
                            </form>
                        </div>
                    </div>
                </div>                   
            </div>
        </div>
    </body>
</html>
