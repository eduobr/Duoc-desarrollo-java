/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dej.servlet;

import dej.controlador.DaoCancion;
import dej.entidades.Cl_Cancion;
import dej.entidades.Cl_Interprete;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Duoc
 */
public class servletControlador extends HttpServlet {

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
        String boton=request.getParameter("btnAccion");
        if (boton.equals("Grabar")) {
            agregar(response,request);
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
        try{
            String nombre=request.getParameter("txtNombre");
            int edad=Integer.parseInt(request.getParameter("txtEdad"));
            char sexo = request.getParameter("sexo").charAt(0);
            String tema = request.getParameter("txtTema");
            int duracion = Integer.parseInt(request.getParameter("txtDuracion"));
            boolean enVivo=(request.getParameter("cboEnVivo").equals("Si") ? true:false);
            
            HttpSession se = request.getSession();
            
            DaoCancion dao;
            
            if (se.getAttribute("persistencia")==null) {
                dao = new DaoCancion();
                se.setAttribute("persistencia", dao);
            }else{
                dao=(DaoCancion)se.getAttribute("persistencia");
            }Cl_Interprete inter = new Cl_Interprete(nombre, edad, sexo);
            Cl_Cancion can = new Cl_Cancion(inter,tema,duracion,enVivo);
            boolean resp = dao.Agregar(can);
            String mensaje=(resp ? "Grabo":"Existe Cancion");
            request.setAttribute("mensaje", mensaje);
            
        }catch(Exception e){
            request.setAttribute("mensaje", e.getMessage());
        }finally{
            request.getRequestDispatcher("agregar.jsp").forward(request, response);
        }
    }

}
