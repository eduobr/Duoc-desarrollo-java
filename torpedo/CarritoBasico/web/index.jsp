<%-- 
    Document   : index
    Created on : 29-sep-2016, 22:45:30
    Author     : Francisco
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <!-- Latest compiled and minified CSS -->
        <!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        </head>
    <body>    
    <center>
        <h1>Tienda Virtual</h1>
        <div class="row">
            <div class="col-sm-8"></div>
            <div class="col-sm-4"><a href="mostrarcarrito.jsp"><img src="img/carro.png"  width="64" height="64"></a></div>
            </div>
        <table border="2" >
            <tr>
                <td>
                    <table class="table table-striped">
                        <tr>
                            <td width="10%"></td>
                            <td align="center">
                                Chaqueta Mujer<br>
                                <img src="img/c01.png">
                                <br>
                                <form name="producto" action="servletAgregarCarro" >
                                    <input type="text" name="txtCantidad" value="1" width="20" class="form-control"/>   
                                    <input type="hidden" name="nombreProducto" value="Chaqueta Mujer" /> 
                                    <input type="hidden" name="precioProducto" value="35000" /> 
                                    <input type="hidden" name="imgProducto" value="img/c01.png" /> 
                                    <input type="submit" value="Enviar" class="btn btn-info"/> 
                                </form>
                            </td>
                            <td width="10%"></td>
                            <td align="center">
                                Blusa Mujer<br>
                                <img src="img/c02.png">
                                <br>
                                <form name="producto" action="servletAgregarCarro" method="post">
                                    <input type="text" name="txtCantidad" value="1" width="20" class="form-control"/>   
                                    <input type="hidden" name="nombreProducto" value="Blusa Mujer" /> 
                                    <input type="hidden" name="precioProducto" value="8000" /> 
                                    <input type="hidden" name="imgProducto" value="img/c02.png" /> 
                                    <input type="submit" name="btnEnvio" class="btn btn-info"/> 
                                </form>
                            </td>
                            <td width="10%"></td>
                            <td align="center">
                                Polera Manga Larga<br>
                                <img src="img/c03.png">
                                <br>
                                <form name="producto" action="servletAgregarCarro" method="post">
                                    <input type="text" name="txtCantidad" value="1" width="20" class="form-control"/>   
                                    <input type="hidden" name="nombreProducto" value="Polera Manga Larga" /> 
                                    <input type="hidden" name="precioProducto" value="9990" /> 
                                    <input type="hidden" name="imgProducto" value="img/c03.png" /> 
                                    <input type="submit" name="btnEnvio" class="btn btn-info" /> 
                                </form>
                            </td>
                        </tr>
                        <tr>
                            <td width="10%"></td>
                            <td align="center">
                                <br>Pijama Mujer<br>
                                <img src="img/c04.png">
                                <br>
                                <form name="producto" action="servletAgregarCarro" method="post">
                                    <input type="text" name="txtCantidad" value="1" width="10" class="form-control"/>   
                                    <input type="hidden" name="nombreProducto" value="Pijama Mujer" /> 
                                    <input type="hidden" name="precioProducto" value="13000" /> 
                                    <input type="hidden" name="imgProducto" value="img/c04.png" /> 
                                    <input type="submit" name="btnEnvio" class="btn btn-info"/> 
                                </form>
                            </td>
                            <td width="10%"></td>
                            <td align="center">
                                <br>Poleron Hombre<br>
                                <img src="img/c05.png">
                                <br>
                                <form name="producto" action="servletAgregarCarro" method="post">
                                    <input type="text" name="txtCantidad" value="1" width="20" class="form-control"/>   
                                    <input type="hidden" name="nombreProducto" value="Poleron Hombre" /> 
                                    <input type="hidden" name="precioProducto" value="20000" /> 
                                    <input type="hidden" name="imgProducto" value="img/c05.png" /> 
                                    <input type="submit" name="btnEnvio" class="btn btn-info"/> 
                                </form>
                            </td>
                            
                            <td width="10%"></td>
                            <td align="center">
                                <br>Corbata<br>
                                <img src="img/c06.png">
                                <br>
                                <form name="producto" action="servletAgregarCarro" method="post">
                                    <input type="text" name="txtCantidad" value="1" width="20" class="form-control"/>   
                                    <input type="hidden" name="nombreProducto" value="Corbata" /> 
                                    <input type="hidden" name="precioProducto" value="12000" /> 
                                    <input type="hidden" name="imgProducto" value="img/c06.png" /> 
                                    <input type="submit" name="btnEnvio" class="btn btn-info"/> 
                                </form>
                            </td>
                        </tr>
                        <tr>
                            <td width="10%"></td>
                            <td align="center">
                                <br>Zapato Mujer<br>
                                <img src="img/c07.png">
                                <br>
                                <form name="producto" action="servletAgregarCarro" method="post">
                                    <input type="text" name="txtCantidad" value="1" width="20" class="form-control"/>   
                                    <input type="hidden" name="nombreProducto" value="Zapato Mujer" /> 
                                    <input type="hidden" name="precioProducto" value="14990" /> 
                                    <input type="hidden" name="imgProducto" value="img/c07.png" /> 
                                    <input type="submit" name="btnEnvio" class="btn btn-info"/> 
                                </form>
                            </td>
                            <td width="10%"></td>
                            <td align="center">
                                <br>Zapatilla Hombre<br>
                                <img src="img/c08.png">
                                <br>
                                <form name="producto" action="servletAgregarCarro" method="post">
                                    <input type="text" name="txtCantidad" value="1" width="20" class="form-control"/>   
                                    <input type="hidden" name="nombreProducto" value="Zapatilla Hombre" /> 
                                    <input type="hidden" name="precioProducto" value="36000" /> 
                                    <input type="hidden" name="imgProducto" value="img/c08.png" /> 
                                    <input type="submit" name="btnEnvio" class="btn btn-info"/> 
                                </form>
                            </td>
                            <td width="10%"></td>
                            <td align="center">
                               <br> Pantalon Hombre<br>
                                <img src="img/c09.png">
                                <br>
                                <form name="producto" action="servletAgregarCarro" method="post">
                                    <input type="text" name="txtCantidad" value="1" width="20" class="form-control"/>   
                                    <input type="hidden" name="nombreProducto" value="Pantalon Hombre" /> 
                                    <input type="hidden" name="precioProducto" value="17000" /> 
                                    <input type="hidden" name="imgProducto" value="img/c09.png" /> 
                                    <input type="submit" name="btnEnvio" class="btn btn-info"/> 
                                </form>
                            </td>
                        </tr>
                        <tr>
                            <td width="10%"></td>
                            <td align="center">
                                <br>Vestido<br>
                                <img src="img/c10.png">
                                <br>
                                <form name="producto" action="servletAgregarCarro" method="post">
                                    <input type="text" name="txtCantidad" value="1" width="20" class="form-control"/>   
                                    <input type="hidden" name="nombreProducto" value="Vestido" /> 
                                    <input type="hidden" name="precioProducto" value="10000" /> 
                                    <input type="hidden" name="imgProducto" value="img/c10.png" /> 
                                    <input type="submit" name="btnEnvio" class="btn btn-info"/> 
                                </form>
                            </td>
                            <td width="10%"></td>
                            <td align="center">
                                <br>Cartera<br>
                                <img src="img/c11.png">
                                <br>
                                <form name="producto" action="servletAgregarCarro" method="post">
                                    <input type="text" name="txtCantidad" value="1" width="20" class="form-control"/>   
                                    <input type="hidden" name="nombreProducto" value="Cartera" /> 
                                    <input type="hidden" name="precioProducto" value="12000" /> 
                                    <input type="hidden" name="imgProducto" value="img/c11.png" /> 
                                    <input type="submit" name="btnEnvio" class="btn btn-info"/> 
                                </form>
                            </td>
                            <td width="10%"></td>
                            <td align="center">
                                <br>Falda<br>
                                <img src="img/c12.png">
                                <br>
                                <form name="producto" action="servletAgregarCarro" method="post">
                                    <input type="text" name="txtCantidad" value="1" width="20" class="form-control"/>   
                                    <input type="hidden" name="nombreProducto" value="Falda" /> 
                                    <input type="hidden" name="precioProducto" value="12000" /> 
                                    <input type="hidden" name="imgProducto" value="img/c12.png" /> 
                                    <input type="submit" name="btnEnvio" class="btn btn-info"/> 
                                </form>
                            </td>
                        </tr>
                    </table>
                </td>
            </tr>
        </table>
    </body>
</html>
