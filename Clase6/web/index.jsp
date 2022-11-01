<%-- 
    Document   : index
    Created on : 25-08-2016, 03:27:16 PM
    Author     : Duoc
--%>

<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body style="background-image: url(img_1142.jpg)">
        <h1>-INFORMACION-</h1>
        <% HttpSession sesion = request.getSession();
        //Imprimir la variable sesion.
        out.println("idSesion: "+sesion.getId());
        //tiempo creacion de la variable.
        out.println("<br>Creacion: "+sesion.getCreationTime());
        //Podemos conocer la fecha y la hora que se accedio
        //por ultima vez a la sesion.
        Date momento = new Date(session.getCreationTime());
        out.println("<br>Fecha de creacion:"+momento);
        Date acceso = new Date(session.getLastAccessedTime());
        out.println("<br>Ultimo acceso:"+acceso);
         //Obtener el tiempo de session.
        long duracion = session.getLastAccessedTime();
        session.getCreationTime();
        Date tiempo = new Date(duracion);
        out.println("<br>Duracion: "+tiempo.getMinutes()+"min "+tiempo.getSeconds()+" seg.");
        //Consultando si la session es nueva.
        out.println("<br>Nueva: "+session.isNew());
        //Creando una variable de sesion.
        
        %>
    <center>
        <form action="pagina2.jsp">
            <table>
                <tbody>
                    <tr>
                        <td>Nombre:</td>
                        <td><input type="text" name="txtNombre" value="" /></td>
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
