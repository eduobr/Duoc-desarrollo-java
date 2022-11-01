<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : ingresarLiga
    Created on : 04-11-2016, 05:07:56 PM
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
        <div class="container">
            <div class="panel panel-primary">
                <div class="panel-heading" style="background-color: #000">
                    <h1>  Ingreso de Liga </h1>
                </div>
                <div class="panel-body">
                    <form action="servletLiga" method="post">
                        <div class="row">
                            <div class="col-lg-9">

                                <table class="table" border="8">
                                    <tr>
                                        <td>Nombre</td>
                                        <td><input type="text" name="txtNommbreLiga" value="" placeholder="ingrese el nombre del club" required/></td>
                                    </tr>
                                    <tr>
                                        <td>Clasificacion</td>
                                        <td>
                                            <select name="cboClasificacion">
                                                <option  value="A">Amateur</option>
                                                <option value="P">Profesional</option>
                                                <option value="V">Veterano</option>
                                            </select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <sql:setDataSource user="root" password="" driver="com.mysql.jdbc.Driver" 
                                                           url="jdbc:mysql://localhost:3306/campeonato?zeroDateTimeBehavior=convertToNull"
                                                           var="bdd"></sql:setDataSource>
                                        <sql:query var="registros" dataSource="${bdd}">
                                            SELECT * FROM equipo;
                                        </sql:query>
                                        <td>Equipo</td>
                                        <td>
                                            <select name="cboOpcion">
                                                <option value="0">Seleccione</option>
                                                <c:forEach var="reg" items="${registros.rows}">
                                                    <option value="${reg.id_equipo}"><c:out value="${reg.nombre}"/></option>
                                                </c:forEach>
                                            </select>
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
            </div>
            <div>
                ${mensajeInsertar}
            </div>
        </div>
    </center>
</body>
</html>
