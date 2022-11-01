<%-- 
    Document   : pagina2
    Created on : 25-08-2016, 04:05:10 PM
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
        <%String nombre = request.getParameter("txtNombre");
        session.setAttribute("ElNombre", nombre);
        %>
        <a href="pagina3.jsp">Continuar</a>
    </body>
</html>
