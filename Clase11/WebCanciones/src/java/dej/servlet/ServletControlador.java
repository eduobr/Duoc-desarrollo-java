package dej.servlet;

import dej.controlador.DaoCancion;
import dej.entidades.Cl_Cancion;
import dej.entidades.Cl_Interprete;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ServletControlador", urlPatterns = {"/ServletControlador"})
public class ServletControlador extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String boton = request.getParameter("btnAccion");

        if (boton.equals("Guardar")) {
            agregar(response, request);
        }
        if (boton.equals("Eliminar")) {
            eliminar(response, request);
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void agregar(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
        try {
            String nombre = request.getParameter("txtNombre");
            int edad = Integer.parseInt(request.getParameter("txtEdad"));
            char sexo = request.getParameter("sexo").charAt(0);
            String tema = request.getParameter("txtTema");
            int duracion = Integer.parseInt(request.getParameter("txtDuracion"));
            boolean enVivo = (request.getParameter("ddlEnVivo").equals("Si") ? true : false);

            HttpSession se = request.getSession();
            DaoCancion dao;

            if (se.getAttribute("persistencia") == null) {
                dao = new DaoCancion();
                se.setAttribute("persistencia", dao);
            } else {
                dao = (DaoCancion) se.getAttribute("persistencia");
            }
            Cl_Interprete inter = new Cl_Interprete(nombre, edad, sexo);
            Cl_Cancion can = new Cl_Cancion(inter, tema, duracion, enVivo);
            boolean resp = dao.Agregar(can);
            //boolean resp=true;
            String mensaje = (resp ? "Guardó" : "Ya existe la cancion");
            request.setAttribute("mensaje", mensaje);
        } catch (Exception e) {
            request.setAttribute("mensaje", e.getMessage());
        } finally {
            request.getRequestDispatcher("Ingresar.jsp").forward(request, response);
        }
    }

    private void eliminar(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
        try {
            String nombre = request.getParameter("txtInterprete");
            String tema = request.getParameter("txtTema");
            HttpSession se = request.getSession();
            DaoCancion dao;
            String mensaje = "";
            if (se.getAttribute("persistencia") == null) {
                mensaje = "No existen Datos";
            } else {
                dao = (DaoCancion) se.getAttribute("persistencia");
                boolean resp = dao.Eliminar(nombre, tema);
                mensaje = (resp ? "Eliminó" : "No existe la cancion con ese interprete");
            }
            request.setAttribute("mensaje", mensaje);
        } catch (Exception e) {
            request.setAttribute("mensaje", e.getMessage());
        } finally {
            request.getRequestDispatcher("Ingresar.jsp").forward(request, response);
        }
    }
}
