/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexion.Conexion;
import dto.EquipoDTO;
import dto.JugadorDTO;
import interfaces.MetodosCRUD;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.regex.Pattern;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

/**
 *
 * @author Duoc
 */
public class JugadorDAO implements MetodosCRUD<JugadorDTO> {

    public static final String SQL_INSERT = "INSERT INTO participante(id_participante,nombre,rol,posicion,fecha_nacimiento,id_equipo) VALUES (?,?,?,?,?,?)";
    public static final String SQL_UPDATE = "UPDATE participante SET nombre=?,rol=?,posicion=?,fecha_nacimiento=?,id_equipo=? WHERE id_participante=?";
    public static final String SQL_DELETE = "DELETE FROM participante WHERE id_participante=?";
    public static final String SQL_READ = "SELECT * FROM participante WHERE id_participante=?";
    public static final String SQL_READALL = "SELECT * FROM participante WHERE id_equipo= ? ORDER BY posicion ASC";

    private static final Logger log = Logger.getLogger(JugadorDAO.class);

    public JugadorDAO() {
        try {
            log.addAppender(new FileAppender(new PatternLayout(), "G:\\Desarrollo Java\\Prueba2\\Logs\\JugadorDTOLog.txt", true));
        } catch (IOException ex) {
            log.warn(ex);
        }
    }

    public static final Conexion conn = Conexion.obtenerConexion();

    @Override
    public boolean create(JugadorDTO objeto) {
        PreparedStatement ps;
        try {
            ps = conn.getConn().prepareStatement(SQL_INSERT);
            ps.setInt(1, objeto.getIdJugador());
            ps.setString(2, objeto.getNombre());
            ps.setString(3, objeto.getRol());
            ps.setInt(4, objeto.getPosicion());
            ps.setDate(5, objeto.getFechaNacimiento());
            ps.setInt(6, objeto.getId_equipo());

            if (ps.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException ex) {
            log.error("Error en create Jugador:" + ex);
        } finally {
            conn.cerrarConexion();
        }
        return false;
    }

    @Override
    public boolean update(JugadorDTO objeto) {
        try {
            PreparedStatement ps;
            ps = conn.getConn().prepareStatement(SQL_UPDATE);
            ps.setString(1, objeto.getNombre());
            ps.setString(2, objeto.getRol());
            ps.setInt(3, objeto.getPosicion());
            ps.setDate(4, objeto.getFechaNacimiento());
            ps.setInt(5, objeto.getId_equipo());
            ps.setInt(6, objeto.getIdJugador());
            if (ps.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException ex) {
            log.error("Error en update Jugador:" + ex);
        } finally {
            conn.cerrarConexion();
        }
        return false;
    }

    @Override
    public boolean delete(Object pk) {
        PreparedStatement ps;
        try {
            ps = conn.getConn().prepareStatement(SQL_DELETE);
            ps.setInt(1, (int) pk);
            if (ps.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException ex) {
            log.error("error en delete Jugador:" + ex);
        } finally {
            conn.cerrarConexion();
        }
        return false;
    }

    @Override
    public JugadorDTO read(Object pk) {
        PreparedStatement ps;
        JugadorDTO jugador = null;
        ResultSet rs;
        try {
            ps = conn.getConn().prepareStatement(SQL_READ);
            ps.setInt(1, (int) pk);
            rs = ps.executeQuery();
            while (rs.next()) {
                jugador = new JugadorDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDate(5), rs.getInt(6));
            }
            return jugador;
        } catch (SQLException ex) {
            //java.util.logging.Logger.getLogger(JugadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conn.cerrarConexion();
        }
        return jugador;
    }

    public List<JugadorDTO> readAll(Object pk) {
        PreparedStatement ps;
        ArrayList<JugadorDTO> jugadores = new ArrayList<>();
        ResultSet rs;
        try {
            ps = conn.getConn().prepareStatement(SQL_READALL);
            ps.setInt(1, (int) pk);
            rs = ps.executeQuery();
            while (rs.next()) {
                jugadores.add(new JugadorDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDate(5), rs.getInt(6)));
            }
        } catch (SQLException ex) {
            //java.util.logging.Logger.getLogger(JugadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conn.cerrarConexion();
        }
        return jugadores;
    }

    @Override
    public List<JugadorDTO> readAll() {
        try {
            String sql="SELECT * FROM participante ";
            PreparedStatement pstm=conn.getConn().prepareCall(sql);

            ResultSet rs=pstm.executeQuery();
            ArrayList<JugadorDTO> lista=new ArrayList<JugadorDTO>();
            while(rs.next()){
                lista.add(new JugadorDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDate(5), rs.getInt(6)));
            }
            return lista;
        } catch (Exception e) {
            log.error("Error en el listar jugadores :"+e);
            System.out.println("Error Listado: "+e.getMessage());
            return null;
        }
    }
    public List<JugadorDTO> ListadoPorEquipo(Object pk){
        try {
            String sql="SELECT * FROM participante WHERE id_equipo= ? ORDER BY posicion ASC";
            PreparedStatement pstm=conn.getConn().prepareCall(sql);
            pstm.setInt(1, (int) pk);
            
            ResultSet rs=pstm.executeQuery();
            ArrayList<JugadorDTO> lista=new ArrayList<JugadorDTO>();
            while(rs.next()){
                lista.add(new JugadorDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDate(5), rs.getInt(6)));
            }
            return lista;
        } catch (Exception e) {
            log.error("Error en el listar jugadores :"+e);
            System.out.println("Error Listado: "+e.getMessage());
            return null;
        }
    }

}
