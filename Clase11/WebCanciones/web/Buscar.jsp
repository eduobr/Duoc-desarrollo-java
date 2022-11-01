<%-- 
    Document   : Buscar
    Created on : 20-09-2016, 04:31:40 PM
    Author     : Duoc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Buscar</title>
    </head>
    <body>
        <jsp:include page="index.html"></jsp:include>
    <center>
        <form>
            <table border="1">
                <tr>
                    <td>Nombre del Interprete:</td>
                    <td> <input type="text" name="txtInterprete" value="" 
                                placeholder="Ingrese nombre" required=""/> </td>
                </tr>
                <tr>
                    <td>Nombre de la Cancion:</td>
                    <td><input type="text" name="txtTema" value="" 
                               placeholder="Ingrese tema" required=""/> </td></td>
                </tr>
                <tr>
                    <td align="center" colspan="2">
                        <input type="submit" name="btnAccion"  value="Buscar" />
                        <input type="reset" value="Limpiar"/>                            
                    </td>
                </tr>
            </table>
            <a href="Home.jsp">Volver al Home</a>
        </form>        
    </center>
</body>
</html>
