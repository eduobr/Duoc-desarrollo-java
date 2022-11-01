/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import dao.AlumnoDAO;
import dto.AlumnoDTO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Duoc
 */
public class servAlumno extends HttpServlet {

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
    
    protected void guardar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String rut = request.getParameter("txtRut");
        String nombre = request.getParameter("txtNombre");
        String apellido = request.getParameter("txtApellido");
        int edad = Integer.parseInt(request.getParameter("cboEdad"));
        
        AlumnoDAO dao = new AlumnoDAO();
        
        if( dao.create(new AlumnoDTO(rut, nombre, apellido, edad)) ) {
            request.getSession().setAttribute("mensajeInsertar", "Exito");
            response.sendRedirect("ingresar.jsp");
        } else {
            request.getSession().setAttribute("mensajeInsertar", "Error Ingresar");
            response.sendRedirect("ingresar.jsp");
        }
        
    }
    
    protected void eliminar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String rut = request.getParameter("txtRut");

        AlumnoDAO dao = new AlumnoDAO();
        
        if( dao.delete(rut) ) {
            request.getSession().setAttribute("mensajeEliminar", "Exito");
            response.sendRedirect("eliminar.jsp");
        } else {
            request.getSession().setAttribute("mensajeEliminar", "Error Eliminar");
            response.sendRedirect("eliminar.jsp");
        }
    }
    
    protected void modificar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String rut = request.getParameter("txtRut");
        String nombre = request.getParameter("txtNombre");
        String apellido = request.getParameter("txtApellido");
        int edad = Integer.parseInt(request.getParameter("cboEdad"));
        
        AlumnoDAO dao = new AlumnoDAO();
        
        if( dao.update(new AlumnoDTO(rut, nombre, apellido, edad)) ) {
            request.getSession().setAttribute("mensajeUpdate", "Exito");
            response.sendRedirect("modificar.jsp");
        } else {
            request.getSession().setAttribute("mensajeUpdate", "Error Update");
            response.sendRedirect("modificar.jsp");
        }
        
    }
    
    protected void buscar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String rut = request.getParameter("txtRut");
        AlumnoDAO dao = new AlumnoDAO();
        request.getSession().setAttribute("datosAlumno", dao.read(rut));
        response.sendRedirect("buscar.jsp");
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

}
