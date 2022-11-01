<%-- 
    Document   : Promedio
    Created on : 10-08-2016, 03:44:55 PM
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
        <%
            int valor1 = 0, valor2 = 0, valor3 = 0, valor4 = 0;
            boolean estado1 = false, estado2 = false, estado3 = false, estado4 = false;
            boolean estadoPonderacion=false;
            String nota1 = request.getParameter("nota1");
            int n1 = Integer.parseInt(nota1);
            if (n1 >= 10 && n1 <= 70) {
                valor1 = n1;
                estado1 = true;
            } else {
                out.println("La nota 1 debe estar en el rango 10 y 70");

            }

            String nota2 = request.getParameter("nota2");
            int n2 = Integer.parseInt(nota2);
            if (n2 >= 10 && n2 <= 70) {
                valor2 = n2;
                estado2 = true;
            } else {
                out.println("La nota 2 debe estar en el rango 10 y 70");

            }

            String nota3 = request.getParameter("nota3");
            int n3 = Integer.parseInt(nota3);
            if (n3 >= 10 && n3 <= 70) {
                valor3 = n3;
                estado3 = true;
            } else {
                out.println("La nota 3 debe estar en el rango 10 y 70");

            }
            String nota4 = request.getParameter("notaExamen");
            int n4 = Integer.parseInt(nota4);
            if (n4 >= 10 && n4 <= 70) {
                valor4 = n4;
                estado4 = true;
            } else {
                out.println("La nota 3 debe estar en el rango 10 y 70");
            }

            String p1 = request.getParameter("ponderacion1");
            int ponderacion1 = Integer.parseInt(p1);

            String p2 = request.getParameter("ponderacion2");
            int ponderacion2 = Integer.parseInt(p2);

            String p3 = request.getParameter("ponderacion3");
            int ponderacion3 = Integer.parseInt(p3);
            
            String p4 = request.getParameter("ponderacionExamen");
            int ponderacion4 = Integer.parseInt(p4);

            if (ponderacion1 + ponderacion2 + ponderacion3 + ponderacion4 == 100) {
                estadoPonderacion = true;
            } else {
                out.println("La suma de las ponderaciones debe ser 100");
            }

            //calcular el promdio presentacion examen
            double promedio = (valor1 * ponderacion1 + valor2 * ponderacion2 + valor3 * ponderacion3) / 100;
            if (estado1 == true && estado2 == true && estado3 == true && estado4 == true && estadoPonderacion==true) {
                double promedioFinal = (promedio*(100-ponderacion4)+valor4*ponderacion4) / 100;
                out.println("El promedio final es: "+promedioFinal);
                if (promedioFinal>=40) {
                        out.println("El alumno esta aprobado");
                    }else{
                    out.println("El alumno esta reprobado");
                }
            }else{
                out.println("No se puede calcular el promedio final");
            }
        %>
    </body>
</html>
