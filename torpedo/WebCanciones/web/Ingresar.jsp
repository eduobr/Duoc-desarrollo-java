<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ingresar</title>
    </head>
    <body>
        <jsp:include page="index.html"></jsp:include>
        <center>
            <div>
                <form style="background: lightblue" action="ServletControlador" method="post">
                    <table border="1" style="background: cornflowerblue">
                        <tr>
                            <td align="center" colspan="2">Formulario de Ingreso de Canciones</td>
                        </tr>
                        <tr>
                            <td align="center" colspan="2">Datos del Interprete</td>                   
                        </tr>
                        <tr>
                            <td>Nombre:</td>  
                            <td> <input type="text" name="txtNombre" value="" 
                                        placeholder="Ingrese nombre" required=""/> 
                            </td> 
                        </tr>
                        <tr>
                            <td>Edad:</td>  
                            <td>  
                                <input type="number" min="5" max="100" name="txtEdad" 
                                       value="" requerid=""/>
                            </td> 
                        </tr>
                        <tr>
                            <td>Sexo:</td>  
                            <td>
                                <input type="radio" name="sexo" 
                                       value="F" />Femenino
                                <input type="radio" name="sexo" 
                                       value="M" />Masculino
                            </td> 
                        </tr>
                        <tr>
                            <td align="center" colspan="2">Datos de la Cancion</td>  
                        </tr>
                        <tr>
                            <td>Tema:</td>  
                            <td>
                                <input type="text" name="txtTema" value=""
                                       requerid=""/>
                            </td> 
                        </tr>
                        <tr>
                            <td>Duracion:</td>  
                            <td>
                                <input type="number" min="61" name="txtDuracion" value=""
                                       requerid=""/>
                            </td> 
                        </tr>
                        <tr>
                            <td>En vivo:</td>  
                            <td>
                                <select name="ddlEnVivo">
                                    <option>Seleccione</option>
                                    <option>No</option>
                                    <option>Si</option>
                                </select>
                            </td> 
                        </tr>
                        <tr>
                            <td align="center" colspan="2">
                                <input type="submit" name="btnAccion"  value="Guardar" />
                                <input type="reset" value="Limpiar"/>                            
                            </td>
                        </tr>
                    </table>
                    <a href="Home.jsp">Volver al Home</a>
                </form>
            </div>
        <%
            if (request.getAttribute("mensaje") != null) {
                out.print(request.getAttribute("mensaje"));
            }
        %>
    </center>
</body>
</html>
