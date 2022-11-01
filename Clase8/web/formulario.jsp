<%-- 
    Document   : formulario
    Created on : 01-09-2016, 03:40:25 PM
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
        <form action="controlador">
            <center>
                <h1>Formulario Persona</h1>
                <table>
                    <tbody>
                        <tr>
                            <td>Nombre:</td>
                            <td><input type="text" name="txtNombre" value="" /></td>
                        </tr>
                        <tr>
                            <td>Edad:</td>
                            <td><select name="edad">
                                    <%for(int i=5;i<=100;i++){
                                            %><option><%=i%></option><%
                                        }%>
                                </select></td>
                        </tr>
                        <tr>
                            <td>Sexo:</td>
                            <td><input type="radio" name="rdbSexo" value="M" checked="checked" />Masculino<input type="radio" name="rdbSexo" value="F" />Femenino</td>
                        </tr>
                        <tr>
                            <td></td>
                            <td><input type="submit" value="enviar" /></td>
                        </tr>
                    </tbody>
                </table>
        </form>
            </center>
    </body>
</html>
