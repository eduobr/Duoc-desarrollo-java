<%-- 
    Document   : login
    Created on : 05-09-2016, 18:43:31
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
        <div>
            <form action="servletLogin" method="post">
                <center>
                    <h1>Login</h1>
                    <table border="1">
                        <tr>
                            <td>
                               <table>
                                    <tr>
                                        <td>Usuario</td>
                                        <td><input type="text" name="txtUsuario" required=""></td>
                                    </tr>
                                    <tr>
                                        <td>Contraseña</td>
                                        <td><input type="password" name="txtPassword" required=""></td>
                                    </tr>
                                    <tr>
                                        <td><input type="submit" name="btnEnviarLogin" value="Enviar"></td>
                                        <td><input type="reset" name="btnLimpiarLogin" value="Limpiar" ></td>
                                    </tr>

                                </table> 
                            </td>
                        </tr>
                    </table>  
                </center>
            </form>
        </div>
        
                <div>
                    <center>
                    <% if (request.getAttribute("mensaje")!=null) {
                            out.println(request.getAttribute("mensaje"));
                        }
                    %>
                    </center>
                </div>
            
        
    </body>
</html>
