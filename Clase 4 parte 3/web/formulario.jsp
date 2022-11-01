<%-- 
    Document   : formulario
    Created on : 18-08-2016, 05:01:48 PM
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
    <center>
        <table style="border: black 1px solid">
            <tr>
                <% String[] parametros = request.getParameterValues("opciones");
                    for (String temp : parametros) {%>
                    <td style="border: black 1px solid"><%=temp%></td>
                <%}%>

            </tr>
        </table>
    </center>

</body>
</html>
