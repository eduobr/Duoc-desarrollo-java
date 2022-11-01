/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import entidades.Cancion;
import entidades.DaoCanciones;
import entidades.Persona;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author SP
 */
public class servletCanciones extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        try (PrintWriter out = response.getWriter()) {
            //Recibimos el boton
            String opcion = request.getParameter("btnAccion");
            //Validamos que accion hace el boton
            if (opcion.equals("Guardar")) {
                agregar(request,response);
            }
            
            if (opcion.equals("Eliminar")) {
                eliminar(request, response);
            }
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

    private void agregar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        try {
            
            String nombrePersona = request.getParameter("txtNombrePersona");
            int edad = Integer.parseInt(request.getParameter("cboEdad"));
            char sexo = request.getParameter("cboSexo").charAt(0);
            Persona persona = new Persona(nombrePersona,edad,sexo);
            
            String nombreCancion = request.getParameter("txtNombreCancion");
            int duracion= Integer.parseInt(request.getParameter("cboDuracion"));
            boolean vivo = request.getParameter("cboEnVivo").equals("true") ? true:false;
            Cancion cancion = new Cancion(persona,nombreCancion,duracion,vivo);

            DaoCanciones dao; 
            HttpSession sesion = request.getSession();
        
            if (sesion.getAttribute("albunes") == null) {
                dao = new DaoCanciones();
                sesion.setAttribute("albunes", dao);
            } else {
                dao =(DaoCanciones)sesion.getAttribute("albunes");
            }
        
            boolean resp = dao.Agregar(cancion);
        
            if (resp) {
                request.setAttribute("mensaje", "cancion grabada");
            } else {
                request.setAttribute("mensaje", "cancion no grabada");
            }

        } catch(Exception e)  {
            request.setAttribute("mensaje", e.getMessage());
        } finally {
            request.getRequestDispatcher("agregar.jsp").forward(request, response);
        }
    }

    private void eliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        try {
            String nombreEliminar = request.getParameter("txtEliminarCancion");
            HttpSession se=request.getSession();
            DaoCanciones dao;
            
            if(se.getAttribute("albunes")==null){
                dao = new DaoCanciones();
                se.setAttribute("albunes", dao);
            } else {
                dao = (DaoCanciones)se.getAttribute("albunes");
            }
            
            boolean resp = dao.Eliminar(nombreEliminar);
                
            if (resp) {
                request.setAttribute("mensaje", "Eliminado");
            } else {
                request.setAttribute("mensaje", "no elimino, no existe cancion con el nombre "+nombreEliminar);
            }        
        } catch (Exception e) {
            request.setAttribute("mensaje", e.getMessage());
        } finally {
            request.getRequestDispatcher("eliminar.jsp").forward(request, response);
        }   
    }
}
