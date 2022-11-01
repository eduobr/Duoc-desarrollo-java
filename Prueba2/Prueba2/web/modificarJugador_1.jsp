
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : modificarJugador
    Created on : 07-11-2016, 22:27:36
    Author     : Coke
--%>
<%@page import="entidades.Jugador"%>
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
                    <h1>  Modificar Jugador </h1>
                </div>
                <div class="panel-body">
                    <form action="servletJugador" method="post">
                        <sql:setDataSource user="root" password="" driver="com.mysql.jdbc.Driver" 
                                                               url="jdbc:mysql://localhost:3306/campeonato?zeroDateTimeBehavior=convertToNull"
                                                               var="bde"></sql:setDataSource>
                                            <sql:query var="registros" dataSource="${bde}">
                                                SELECT * FROM participante;
                                            </sql:query>
                        <div class="row">
                            <div class="col-lg-9">
                                <table  class="table" border="8">
                                    <tr>
                                        <td>Seleccione Jugador a Modificar:</td>
                                        <td>
                                            
                                            <select name="cboOpcion" var="id">
                                                <option value="0">Seleccione</option>
                                                <c:forEach var="reg" items="${registros.rows}">
                                                    <option value="${reg.id_participante}"><c:out value="${reg.nombre}"/></option>
                                                </c:forEach>
                                            </select>
                                            
                                        </td>
                                        <td>
                                            <input type="submit" value="Buscar" name="btnAccion">
                                        </td>
                                    </tr>
                                    
                                </table>
                            </div>
                        </div>
                </div>                   
                 </form>

                    <form action="servletJugador" method="post"> 
                        <c:set var="val" value="id"/>
                        <div class="row">
                            <div class="col-lg-9">
                                <table  class="table" border="8">
                                    <tr>
                                        <td>Nombre:</td>
                                        <td><input type="text" name="txtNombre" value="${listaJ.getNombre()}"   /></td>
                                    </tr>
                                    <tr>
                                        <td>Rol</td>
                                        <td>
                                            <select name="cboRol" >
                                                <option>Tanque</option>  
                                                <option>Atacante</option>  
                                                <option>Asistidor</option>  
                                            </select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>Posicion</td>
                                        <td>
                                            <input type="number" name="txtPosicion" value="${listaJ.getPosicion()}" min="1" max="5"  />
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>Fecha de Nacimiento</td>
                                        <td>
                                            <input type="date" name="dtFechaNacimiento" value="${listaJ.getFechaNacimiento()}" />
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
                                        <select name="cboOpcion2">
                                                <option value="0">Seleccione</option>
                                                <c:forEach var="reg" items="${registros.rows}">
                                                    <option value="${reg.id_equipo}"><c:out value="${reg.nombre}"/></option>
                                                </c:forEach>
                                            </select>
                                    </td>  

                                    </tr>
                                    

                                    <tr > 

                                        <td colspan="2">
                                            <input type="submit" name="btnAccion" value="Modificar"  />
                                            <input type="reset" name="btnAccion" value="Limpiar"  />
                                        </td>

                                    </tr>
                                </table>
                            </div>
                                        <div>
            
            ${mensajeInsertar}
        </div>
                        </div>             
                </form>
               
            </div>
        </div>
        
    </body>
</html>
