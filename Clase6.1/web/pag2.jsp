<%-- 
    Document   : pag2
    Created on : 24-08-2016, 04:43:56 PM
    Author     : Duoc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body style="background-image: url(img_1142.jpg)">
        <% String nombre = request.getParameter("txtNombre");
            String contraseña = request.getParameter("txtContra");

            if (request.getParameter("txtNombre").equals("duoc")) {
                session.setAttribute("Usuario", nombre);
                out.println("Usuario:" +nombre);
            } else {
                out.println("¡ERROR!");

            }
            
            if (request.getParameter("txtContra").equals("duoc")) {
                session.setAttribute("Contraseña", contraseña);
                out.println("Contraseña:" +contraseña);
            } else {
                out.println("¡ERROR!");

            }
        %>
    </body>
</html>
