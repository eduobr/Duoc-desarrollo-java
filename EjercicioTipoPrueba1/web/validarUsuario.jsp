<%-- 
    Document   : validarUsuario
    Created on : 30-08-2016, 01:57:40 PM
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
        <%
            String usuario = request.getParameter("txtUsuario");
            String contrasena = request.getParameter("txtContrasena");
            
            if (usuario.equals("admin") && contrasena.equals("admin")) {
                response.sendRedirect("formulario.jsp");
            }
              else{
                out.println("ERROR ! usuario o contraseña incorrectos");         
            }                    
        %>
    </body>
</html>
