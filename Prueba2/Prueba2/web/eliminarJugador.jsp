<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : eliminarJugador
    Created on : 04-11-2016, 05:11:50 PM
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
         <div class="container">
            <div class="panel panel-primary">
                <div class="panel-heading" style="background-color: #000">
                    <h1>  Eliminar Jugador </h1>
                </div>
                <div class="panel-body">
                    <form action="servletJugador" method="post">
                        <div class="row">
                            <div class="col-lg-9">
                                <table  class="table" border="8">
                                    <tr>
                                        <td>Seleccione Jugador a Eliminar:</td>
                                        <td>
                                            <sql:setDataSource user="root" password="" driver="com.mysql.jdbc.Driver" 
                                                               url="jdbc:mysql://localhost:3306/campeonato?zeroDateTimeBehavior=convertToNull"
                                                               var="bde"></sql:setDataSource>
                                            <sql:query var="registros" dataSource="${bde}">
                                                SELECT * FROM participante;
                                            </sql:query>
                                            <select name="cboOpcion">
                                                <option value="0">Seleccione</option>
                                                <c:forEach var="reg" items="${registros.rows}">
                                                    <option value="${reg.id_participante}"><c:out value="${reg.nombre}"/></option>
                                                </c:forEach>
                                            </select>
                                            
                                        </td>
                                        <td>
                                            <input type="submit" value="Eliminar" name="btnAccion">
                                        </td>
                                    </tr>
                                    
                                </table>
                            </div>
                        </div>
                </div>                   
                </form>

            </div>
        </div>
        <div>
            ${mensaje}
        </div>
    </center>
   
    </body>
</html>
