<%-- 
    Document   : agregar
    Created on : 14-09-2016, 05:05:47 PM
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
        <div>
            <form action="servletControlador" method="post">      
                <table border="1">
                    <tr>
                        <td colspan="2">Formulario de ingreso de canciones</td>
                    </tr>
                    <tr>
                        <td colspan="2">Datos del interprete</td>
                    </tr>
                    <tr>
                        <td>Nombre:</td>
                        <td><input type="text" name="txtNombre" value="" placeholder="Ingrese Nombre" required/></td>
                    </tr>
                    <tr>
                        <td>Edad:</td>
                        <td> <input type="number" min="5" max="100" name="txtEdad" value="" required/></td>
                    </tr>
                    <tr>
                        <td>Sexo:</td>
                        <td> <input type="radio" name="sexo" value="Femenino" value="F"/>Femenino<input type="radio" name="sexo" value="Masculino" value="M"/>Masculino</td>
                    </tr>
                    <tr>
                        <td colspan="2">Datos de la cancion</td>
                    </tr>
                    <tr>
                        <td>Tema:</td>
                        <td> <input type="text" name="txtTema" value="" required/> </td>
                    </tr>
                    <tr>
                        <td>Duracion:</td>
                        <td> <input type="number" min="61" name="txtDuracion" value="" required/> </td>
                    </tr>
                    <tr>
                        <td>En Vivo:</td>
                        <td>
                            <select name="cboEnVivo">
                                <option>Seleccione</option>
                                <option>Si</option>
                                <option>No</option>
                            </select>
                        </td>
                    </tr>
                    <tr colspan="2">
                        <td>
                            <input type="submit" name="btnAccion" value="Grabar" />              
                            <input type="reset" value="Limpiar" />
                        </td>>
                    </tr>
                </table>
            </form>
        </div>
        <%
            if (request.getAttribute("mensaje")!=null) {
                    out.println(request.getAttribute("mensaje"));
                }
            %>
    </body>
</html>
