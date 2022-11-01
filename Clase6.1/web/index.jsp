<%-- 
    crear una pagina de login donde el usuario es duoc y la constraseña
    es duoc, se debe crear la variable de sesion asociada al usuario 
    imprimiendo sus valores mas inportantes
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <% HttpSession sesion = request.getSession();
            
        %>
    <center>
        <form action="pag2.jsp">
            <table>
                <tbody>
                <tr>
                    <td>Nombre:</td>
                    <td><input type="text" name="txtNombre" value="" /></td>
                </tr>
                <tr>
                    <td>Contraseña:</td>
                    <td><input type="password" name="txtContra" value="" /></td>                        
                    <td><input type="submit" value="enviar" /></td>
                </tr>
                </tbody>
            </table>
        </form>
    </center>
</body>
</html>
