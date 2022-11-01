<%@page import="java.util.ArrayList"%>
<%@page import="dej.entidades.Cl_Cancion"%>
<%@page import="dej.controlador.DaoCancion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado</title>
    </head>
    <body>
    <center>
        <jsp:include page="index.html"></jsp:include>
            <div>
            <%
                HttpSession se = request.getSession();
                if (se.getAttribute("persistencia") == null) {
                    out.print("No existen datos");
                } else {
                    DaoCancion dao = (DaoCancion) se.getAttribute("persistencia");
                    ArrayList<Cl_Cancion> lista = dao.Listar();
            %>
            <table border="1" style="background: lightskyblue">
                <tr>
                    <td>Nombre del Interprete</td>
                    <td>Edad</td>
                    <td>Sexo</td>
                    <td>Tema</td>
                    <td>Duracion</td>
                    <td>En vivo</td>
                </tr>
                <% for (Cl_Cancion item : lista) {%>
                <tr>
                    <td><%=item.getInterprete().getNombre()%></td>
                    <td><%=item.getInterprete().getEdad()%></td>
                    <td><%=item.getInterprete().getSexo()%></td>
                    <td><%=item.getTema()%></td>
                    <td><%=item.getDuracion()%></td>
                    <td><%=item.isEnVivo()%></td>
                </tr>
                <%}%>
            </table>
            <%}%>
        </div>
         <a href="Home.jsp">Volver al Home</a>
    </center>
</body>
</html>
