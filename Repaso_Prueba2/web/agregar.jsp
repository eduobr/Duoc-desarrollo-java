<%-- 
    Document   : agregar
    Created on : 05-09-2016, 19:16:36
    Author     : SP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            HttpSession sesion = request.getSession();
            if(sesion.getAttribute("usuario") == null){
                response.sendRedirect("login.jsp");
            }    
        %>
        <div>
            <form action="servletCanciones">
                <center>
                    <h1>Agregar</h1>
                    <table>
                        <tr>
                            <td>Nombre cancion: </td>
                            <td><input type="text" name="txtNombreCancion" /></td>
                        </tr>
                        <tr>
                            <td>Duracion:</td>
                            <td>
                                <input type="number" min="60" name="cboDuracion">
                            </td>
                        </tr>
                        <tr>
                            <td>¿En Vivo?</td>
                                    <td>
                                        <select name="cboEnVivo">
                                            <option value="true">Si</option>
                                            <option value="false">No</option>
                                
                                        </select>
                                    </td>
                        </tr>
                        <tr>
                            <td>Nombre Persona:</td>
                            <td><input type="text" name="txtNombrePersona" /></td>
                        </tr>
                        <tr>
                            <td>Edad:</td>
                            <td>
                                <select name="cboEdad">
                                    <%
                                        for(int i=5;i<101; i++)
                                        {           
                               %>
                                        
                                    <option> <%=i%> </option>
                                   <% } %>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>Sexo:</td>
                            <td><select name="cboSexo">
                                    <option value="F">Femenino</option>
                                    <option value="M">Masculino</option>
                                </select></td>
                        </tr>
                        <tr>
                            <td><input type="submit" value="Guardar" name="btnAccion" /></td>
                            <td><input type="reset" value="Limpiar" name="txtLimpiar" /></td>
                        </tr>
                    </table>
                </center>
            </form>
        </div>
        <div>
            <center>
                ${mensaje}
            </center>
        </div>
    </body>
</html>
