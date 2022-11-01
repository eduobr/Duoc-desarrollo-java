<%-- 
    Document   : index
    Created on : 10-08-2016, 04:55:51 PM
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
        <form action="pagina2">
            <center>
                <table border="1">
                    <tbody>
                        <tr>
                            <td>Ingrese su edad:</td>
                            <td> <select name="edad">
                                    <%for (int i = 0; i < 100; i++) {%>
                                    <option><%= i %></option>
                                    <% } %>
                                </select> </td>
                        </tr>
                        <tr>
                            <td></td>
                            <td> <input type="submit" value="Enviar" /> </td>
                        </tr>
                    </tbody>
                </table>
            </center>
        </form>
    </body>
</html>
