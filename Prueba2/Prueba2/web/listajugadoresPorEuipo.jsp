<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : listajugadoresPorEuipo
    Created on : 07-11-2016, 19:51:11
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
        
         <div class="container">
            <div class="panel panel-primary">
                <div class="panel-heading" style="background-color: #000">
                    <h1>  Lista de Jugadores por Equipo </h1>
                </div>
                <div class="panel-body">
                    <form action="servletJugador" method="post">
                        <sql:setDataSource user="root" password="" driver="com.mysql.jdbc.Driver" 
                                                               url="jdbc:mysql://localhost:3306/campeonato?zeroDateTimeBehavior=convertToNull"
                                                               var="bde"></sql:setDataSource>
                                            <sql:query var="registros" dataSource="${bde}">
                                                SELECT * FROM participante;
                                            </sql:query>
                                            <sql:query var="registro" dataSource="${bde}">
                                                SELECT * FROM equipo;
                                            </sql:query>
                        <div class="row">
                            <div class="col-lg-9">
                                <table  class="table" border="8">
                                    <tr>
                                        <td>Seleccione Equipo:</td>
                                        <td>
                                            
                                            <select name="cboOpcion" var="id">
                                                <option value="0">Seleccione</option>
                                                <c:forEach var="reg" items="${registro.rows}">
                                                    <option value="${reg.id_equipo}"><c:out value="${reg.nombre}"/></option>
                                                </c:forEach>
                                            </select>
                                            
                                        </td>
                                        <td>
                                            <input type="submit" value="Seleccionar" name="btnAccion">
                                        </td>
                                    </tr>
                                    
                                </table>
                            </div>
                        </div>
                </div>                   
                  </form>

<form >  
                        <c:set var="val" value="id"/>
                        <div class="row">
                            <div class="col-lg-9">
                                <table  class="table" border="8">
                                <tbody>
                                    <tr class="info">
                                        <td>id</td>
                                        <td>Nombre</td>
                                        <td>Rol</td>
                                        <td>Posicion</td>
                                        <td>fecha_nacimiento</td>
                                        <td>Equipo</td>
                                        <c:forEach var="lista" items="${sessionScope.listaJugador}">
                                    </tr>
                                            <td><c:out value="${lista.getIdJugador()}"/></td>
                                            <td><c:out value="${lista.getNombre()}"/></td>
                                            <td><c:out value="${lista.getRol()}"/></td>
                                            <td><c:out value="${lista.getPosicion()}"/></td>
                                            <td><c:out value="${lista.getFechaNacimiento()}"/></td>
                                            <td><c:out value="${lista.getId_equipo()}"/></td>
                                          
                                        </tr>
                                        </c:forEach>
                                </tbody>
                            </table>
                            </div>
                        </div>             
                </form>
               
            </div>
        </div>
        <div>
            
            ${mensajeInsertar}
        </div>
    </body>
</html>
