/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;


import dao.JugadorDAO;
import dto.JugadorDTO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;


/**
 *
 * @author Coke
 */
public class servletJugador extends HttpServlet {

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
        if(opcion.equals("Seleccionar")) {
            listarPorEquipo(request, response);
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
        
        JugadorDAO dao = new JugadorDAO();
        JugadorDTO j  = new JugadorDTO();
        String nombre = request.getParameter("txtNombre");
        String rol = request.getParameter("cboRol");
        int posicion = Integer.parseInt(request.getParameter("txtPosicion"));
        String uno = request.getParameter("dtFechaNacimiento");
        Date fecha = Date.valueOf(uno);
        
        int e = Integer.parseInt(request.getParameter("cboOpcion"));

        int id = j.getIdJugador();

        if( dao.create(new JugadorDTO(id, nombre, rol, posicion, fecha,e))) {
            request.getSession().setAttribute("mensajeInsertar", "Agrego!");
            response.sendRedirect("ingresarJugador.jsp");
        } else {
            request.getSession().setAttribute("mensajeInsertar", "Error  al Agregar");
            response.sendRedirect("ingresarJugador.jsp");
        }
    }

    private void eliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       try {
            String id=request.getParameter("cboOpcion");
            JugadorDAO dao=new JugadorDAO();
            boolean resp=dao.delete(Integer.parseInt(id));
            String mensaje=(resp ? "Elimino" : "No Elimino" );
            request.setAttribute("mensaje", mensaje);
        } catch (Exception e) {
            request.setAttribute("mensaje", e.getMessage());
        }
        finally{
            request.getRequestDispatcher("eliminarJugador.jsp").forward(request, response);
        }
    }

    private void modificar(HttpServletRequest request, HttpServletResponse response) throws IOException {
        
        JugadorDAO dao = new JugadorDAO();
        JugadorDTO j = new JugadorDTO();
        String nombre = request.getParameter("txtNombre");
        String rol = request.getParameter("cboRol");
        int posicion = Integer.parseInt(request.getParameter("txtPosicion"));
        String uno = request.getParameter("dtFechaNacimiento");
        Date fecha = Date.valueOf(uno);
        
        int e = Integer.parseInt(request.getParameter("cboOpcion2"));

        int id = j.getIdJugador();

        if( dao.update(new JugadorDTO(id, nombre, rol, posicion, fecha,e))) {
            request.getSession().setAttribute("mensajeInsertar", "Modifico!");
            response.sendRedirect("modificarJugador.jsp");
        } else {
            request.getSession().setAttribute("mensajeInsertar", "Error  al modificar");
            response.sendRedirect("modificarJugador.jsp");
        }
    }

    private void buscar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       try {
            int e = Integer.parseInt(request.getParameter("cboOpcion"));
            JugadorDAO dao=new JugadorDAO();
            JugadorDTO jug=dao.read(e);
                request.setAttribute("jugador", jug);

        } catch (Exception e) {
            request.setAttribute("mensaje", e.getMessage());
        }finally{
            request.getRequestDispatcher("modificarJugador.jsp").forward(request, response);
        
        }
    }

    private void listarPorEquipo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int ie = Integer.parseInt(request.getParameter("cboOpcion"));
            JugadorDAO dao=new JugadorDAO();
            ArrayList<JugadorDTO> alum=(ArrayList<JugadorDTO>) dao.ListadoPorEquipo(ie);
            
                request.setAttribute("jugador", alum);
                request.getSession().setAttribute("listaJugador", dao.ListadoPorEquipo(ie));
                request.setAttribute("mensajeInsertar", ie);
                request.getRequestDispatcher("listajugadoresPorEuipo.jsp").forward(request, response);
    }

}
