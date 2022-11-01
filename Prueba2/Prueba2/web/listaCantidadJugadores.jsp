<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : listaCantidadJugadores
    Created on : 08-11-2016, 12:08:32
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
            <%-- SELECT * FROM equipo; --%>
            SELECT equipo.id_equipo,participante.id_equipo,equipo.nombre,equipo.fecha_creacion,COALESCE(COUNT(participante.id_participante),0) a FROM equipo INNER JOIN participante ON equipo.id_equipo=participante.id_equipo;
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
                                                <tr class="info">
                                                    <td>Nombre</td>
                                                    <td>Fecha</td>
                                                    <td>Cantidad de jugadores</td>
                                                </tr>
                                                <c:forEach var="coleccion" items="${R.rows}">
                                                    <tr>
                                                        <td><c:out value="${coleccion.nombre}"/></td>
                                                        <td><c:out value="${coleccion.fecha_creacion}"/></td>
                                                        <td><c:out value="${coleccion.a}"/></td>
                                                                                                 

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
