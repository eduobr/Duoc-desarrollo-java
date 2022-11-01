/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import conexion.Conexion;
import static dao.EquipoDAO.SQL_DELETE;
import static dao.EquipoDAO.SQL_READ;
import static dao.EquipoDAO.conn;
import dto.EquipoDTO;
import dto.LigaDTO;
import interfaces.MetodosCRUD;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

/**
 *
 * @author Duoc
 */
public class LigaDAO implements MetodosCRUD<LigaDTO>{
    
    public static final String SQL_INSERT = "INSERT INTO liga(id_liga,nombre,clasificacion,id_equipo) VALUES (?,?,?,?)";
    public static final String SQL_UPDATE = "UPDATE liga SET nombre=?,clasificacion=?,id_equipo=? WHERE id_liga=?";
    public static final String SQL_DELETE = "DELETE FROM liga WHERE id_liga=?";
    public static final String SQL_READ = "SELECT * FROM liga WHERE id_liga=?";
    public static final String SQL_READALL = "SELECT * FROM liga";

    private static final Logger log = Logger.getLogger(LigaDAO.class);

    public LigaDAO() {
        try {
            log.addAppender(new FileAppender(new PatternLayout(), "G:\\Desarrollo Java\\Prueba2\\Logs\\LigaDTOLog.txt", true));
        } catch (IOException ex) {
            log.warn(ex);
        }
    }
    
    public static final Conexion conn = Conexion.obtenerConexion();

    @Override
    public boolean create(LigaDTO objeto) {
        PreparedStatement ps;
        try {
            ps = conn.getConn().prepareStatement(SQL_INSERT);
            ps.setInt(1, objeto.getIdLiga());
            ps.setString(2, objeto.getNombre());
            ps.setString(3,String.valueOf(objeto.getClasificacion()));
            ps.setInt(4, objeto.getIdEquipo());
            if (ps.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException ex) {
            log.error("Error en create Liga:" + ex);
        } finally {
            conn.cerrarConexion();
        }
        return false;
    }

    @Override
    public boolean update(LigaDTO objeto) {
        PreparedStatement ps;
        try {
            ps = conn.getConn().prepareStatement(SQL_UPDATE);
            ps.setString(1, objeto.getNombre());
            ps.setString(2,String.valueOf(objeto.getClasificacion()));
            ps.setInt(3, objeto.getIdEquipo());
            ps.setInt(4, objeto.getIdLiga());
            if (ps.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException ex) {
            log.error("Error en update Liga:" + ex);
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
            log.error("error en delete Liga:" + ex);
        } finally {
            conn.cerrarConexion();
        }
        return false;
    }

    @Override
    public LigaDTO read(Object pk) {
        PreparedStatement ps;
        LigaDTO liga = null;
        ResultSet rs;
        try {
            ps = conn.getConn().prepareStatement(SQL_READ);
            ps.setInt(1, (int) pk);
            rs = ps.executeQuery();
            while (rs.next()) {
                char aux = rs.getString(3).charAt(0);
               liga = new LigaDTO(rs.getInt(1), rs.getString(2), aux,rs.getInt(4));
            }
            return liga;
        } catch (SQLException ex) {
            //java.util.logging.Logger.getLogger(JugadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conn.cerrarConexion();
        }
        return liga;
    }

    @Override
    public List<LigaDTO> readAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
