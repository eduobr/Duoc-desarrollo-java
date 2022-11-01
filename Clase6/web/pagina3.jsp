<%-- 
    Document   : pagina3
    Created on : 25-08-2016, 03:14:05 PM
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
        Hola, <%= session.getAttribute("ElNombre")%>
        <!-- Para invalidar una sesion se utiliza la instruccion
             sesion.invalidate(); -->
        
        
    </body>
</html>
