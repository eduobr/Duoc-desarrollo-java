/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.EquipoDAO;
import dto.EquipoDTO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Coke
 */
public class servletEquipo extends HttpServlet {
            EquipoDTO e = new EquipoDTO();


    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.text.ParseException
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

    private void guardar(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException{
                    int id = e.getIdEquipo();
                    String nombre = request.getParameter("txtNommbreEquipo");
                    String uno = request.getParameter("dtFechaEquipo");
                    Date fecha = Date.valueOf(uno);
                    EquipoDAO dao = new EquipoDAO(); 
                    
                    if( dao.create(new EquipoDTO(id, nombre, fecha))) {
                        request.getSession().setAttribute("mensajeInsertar", "agrego equipo!");
                        response.sendRedirect("ingresarEquipo.jsp");
                    } else {
                        request.getSession().setAttribute("mensajeInsertar", "Error  al Agregar");
                        response.sendRedirect("ingresarEquipo.jsp");
                    }  

    }

    private void eliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       try {
            String id=request.getParameter("cboOpcion");
            EquipoDAO dao=new EquipoDAO();
            boolean resp=dao.delete(Integer.parseInt(id));
            String mensaje=(resp ? "Elimino" : "No Elimino" );
            request.setAttribute("mensaje", mensaje);
        } catch (Exception e) {
            request.setAttribute("mensaje", e.getMessage());
        }
        finally{
            request.getRequestDispatcher("eliminarEquipo.jsp").forward(request, response);
        }
    }

    private void modificar(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
                    String nombre = request.getParameter("txtNommbreEquipo");
                    String uno = request.getParameter("dtFechaEquipo");
                    Date fecha = Date.valueOf(uno);
                    EquipoDAO dao = new EquipoDAO();
                    
                    if( dao.update(new EquipoDTO(id, nombre, fecha))) {
                        request.getSession().setAttribute("mensajeInsertar", "Equipo Modificado");
                        response.sendRedirect("modificarEquipo.jsp");
                    } else {
                        request.getSession().setAttribute("mensajeInsertar", "Error  al Modificar");
                        response.sendRedirect("modificarEquipo.jsp");
                    }  

    }

    private void buscar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String nombre = request.getParameter("txtNombre");
        EquipoDAO dao = new EquipoDAO();
        request.getSession().setAttribute("equipo", dao.read(nombre));
        response.sendRedirect("buscarEquipo.jsp");
    }


}
