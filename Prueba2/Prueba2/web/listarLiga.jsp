<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : listarLiga
    Created on : 05-11-2016, 17:58:57
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
            SELECT * FROM liga;
        </sql:query>  
        <%--  bootstrap --%>

        <div class="container">
            <div class="panel panel-primary">
                <div class="panel-heading" style="background-color: #000">
                    <h1>  Listado de Ligas </h1>
                </div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-lg-9">
                            <table  class="table" border="8">
                                <tbody>
                                    <tr>
                                        <td>id</td>
                                        <td>Nombre</td>
                                        <td>clasificacion</td>
                                        <td>Id Equipo</td>
                                    </tr>
                                    <c:forEach var="coleccion" items="${R.rows}">
                                        <tr>
                                            <td><c:out value="${coleccion.id_liga}"/></td>
                                            <td><c:out value="${coleccion.nombre}"/></td>
                                            <td><c:out value="${coleccion.clasificacion}"/></td>
                                            <td><c:out value="${coleccion.id_equipo}"/></td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>                   
            </div>
        </div>
    </body>
</html>
