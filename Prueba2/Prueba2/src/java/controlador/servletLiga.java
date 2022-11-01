/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.JugadorDAO;
import dao.LigaDAO;
import dto.LigaDTO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpSession;;

/**
 *
 * @author Coke
 */
public class servletLiga extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String opcion = request.getParameter("btnAccion");
        
        if(opcion.equals("Guardar")) {
            guardar(request, response);
        }
        if(opcion.equals("Eliminar")) {
            eliminar(request, response);
        }
        if(opcion.equals("Modificar")) {
            modificar(request, response);
        }
        if(opcion.equals("Buscar")) {
            buscar(request, response);
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

    private void guardar(HttpServletRequest request, HttpServletResponse response) throws IOException {
        LigaDAO dao = new LigaDAO();
        LigaDTO j = new LigaDTO();
        String nombre = request.getParameter("txtNommbreLiga");
        char clasificacion = request.getParameter("cboClasificacion").charAt(0);   
        //String clasificacio = String.valueOf(clasificacion);
        int e = Integer.parseInt(request.getParameter("cboOpcion"));

        int id = j.getIdLiga();

        if( dao.create(new LigaDTO(id, nombre, clasificacion,e))) {
            request.getSession().setAttribute("mensajeInsertar", "Agrego!");
            response.sendRedirect("ingresarLiga.jsp");
        } else {
            request.getSession().setAttribute("mensajeInsertar", "Error  al Agregar");
            response.sendRedirect("ingresarLiga.jsp");
        }
    }

    private void eliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String id=request.getParameter("txtIDEliminarL");
            LigaDAO dao=new LigaDAO();
            boolean resp=dao.delete(Integer.parseInt(id));
            String mensaje=(resp ? "Elimino" : "No Elimino" );
            request.setAttribute("mensaje", mensaje);
        } catch (Exception e) {
            request.setAttribute("mensaje", e.getMessage());
        }
        finally{
            request.getRequestDispatcher("eliminarLiga.jsp").forward(request, response);
        }
    }

    private void modificar(HttpServletRequest request, HttpServletResponse response) throws IOException {
        LigaDAO dao = new LigaDAO();
        LigaDTO j = new LigaDTO();
        String nombre = request.getParameter("cboOpcionNombre");
        char clasificacion = request.getParameter("cboClasificacion").charAt(0);   
        //String clasificacio = String.valueOf(clasificacion);
        int e = Integer.parseInt(request.getParameter("cboOpcion"));

        int id = j.getIdLiga();

        if( dao.update(new LigaDTO(id, nombre, clasificacion,e))) {
            request.getSession().setAttribute("mensajeModificar", "Modifico!");
            response.sendRedirect("modificarLiga.jsp");
        } else {
            request.getSession().setAttribute("mensajeModificar", "Error  al Modificar");
            response.sendRedirect("modificarLiga.jsp");
        }
    }

    private void buscar(HttpServletRequest request, HttpServletResponse response) {
        int idLiga = Integer.parseInt(request.getParameter("txtIdLiga"));
        LigaDAO dao = new LigaDAO();
        request.getSession().setAttribute("datosLiga", dao.read(idLiga));
        //response.sendRedirect("buscar.jsp");
    }

}
