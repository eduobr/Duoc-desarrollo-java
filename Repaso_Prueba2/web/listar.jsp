<%-- 
    Document   : listar
    Created on : 05-09-2016, 19:17:15
    Author     : SP
--%>

<%@page import="entidades.DaoCanciones"%>
<%@page import="entidades.Cancion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            HttpSession sesion = request.getSession();
            if(sesion.getAttribute("usuario") == null){
                response.sendRedirect("login.jsp");
            }    
        %>
        <div>
            <form>
                <center>
                    <h1>Lista de canciones</h1>
                    
                    
                    <%
                        DaoCanciones dao;
                        //HttpSession sesion = request.getSession();
                        
                        if (sesion.getAttribute("albunes")==null) {
                            dao = new DaoCanciones();
                          sesion.setAttribute("albunes", dao);
                                
                            }
                        else
                        {
                            dao = (DaoCanciones) sesion.getAttribute("albunes");
                        
                        }
                        
                        
                        
                        
                    for (Cancion item: dao.Listar()) {
                            
                        
                    %>
                    <table>
                        <tr>
                            <td>Nombre Cancion:</td>
                            <td><%=item.getNombre() %></td>
                        </tr>
                        <tr>
                            <td>Duracion:</td>
                            <td><%= item.getDuracion() %></td>
                        </tr>
                        <tr>
                            <td>¿En vivo?:</td>
                            <td><%= item.isVivo() %></td>
                        </tr>
                        <tr>
                            <td>Nombre Persona:</td>
                            <td><%= item.getInterprete().getNombre() %></td>
                        </tr>
                        <tr>
                            <td>Edad:</td>
                            <td><%= item.getInterprete().getEdad() %></td>
                        </tr>
                        <tr>
                            <td>Sexo:</td>
                            <td><%= item.getInterprete().getSexo() %></td>
                        </tr>
                    </table>
                    <%}%>
                </center>
            </form>
        </div>
        <div>
            <center>
                ${mensaje}
            </center>
        </div>
    </body>
</html>
