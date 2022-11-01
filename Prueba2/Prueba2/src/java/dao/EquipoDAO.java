/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import conexion.Conexion;
import dto.EquipoDTO;

import interfaces.MetodosCRUD;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

/**
 *
 * @author Duoc
 */
public class EquipoDAO implements MetodosCRUD<EquipoDTO>{
    public static final String SQL_INSERT = "INSERT INTO equipo(id_equipo,nombre,fecha_creacion) VALUES (?,?,?)";
    public static final String SQL_UPDATE = "UPDATE equipo SET nombre=?,fecha_creacion=? WHERE id_equipo=?";
    public static final String SQL_DELETE = "DELETE FROM equipo WHERE id_equipo=?";
    public static final String SQL_READ = "SELECT * FROM equipo WHERE id_equipo=?";
    public static final String SQL_READALL = "SELECT * FROM equipo";

    private static final Logger log = Logger.getLogger(EquipoDAO.class);

    public EquipoDAO() {
        try {
            log.addAppender(new FileAppender(new PatternLayout(), "G:\\Desarrollo Java\\Prueba2\\Logs\\EquipoDTOLog.txt", true));
        } catch (IOException ex) {
            log.warn(ex);
        }
    }
    
    public static final Conexion conn = Conexion.obtenerConexion();

    @Override
    public boolean create(EquipoDTO objeto) {
        PreparedStatement ps;
        try {
            ps = conn.getConn().prepareStatement(SQL_INSERT);
            ps.setInt(1, objeto.getIdEquipo());
            ps.setString(2, objeto.getNombre());
            ps.setDate(3, objeto.getFechaCreacion());

            if (ps.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException ex) {
            log.error("Error en create Equipo:" + ex);
        } finally {
            conn.cerrarConexion();
        }
        return false;
    }

    @Override
    public boolean update(EquipoDTO objeto) {
        try {
            PreparedStatement ps;
            ps = conn.getConn().prepareStatement(SQL_UPDATE);
            ps.setString(1, objeto.getNombre());
            ps.setDate(2, objeto.getFechaCreacion());
            ps.setInt(3, objeto.getIdEquipo());
            if (ps.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException ex) {
            log.error("Error en update Equipo:" + ex);
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
            log.error("error en delete Equipo:" + ex);
        } finally {
            conn.cerrarConexion();
        }
        return false;
    }

    @Override
    public EquipoDTO read(Object pk) {
        PreparedStatement ps;
        EquipoDTO equipo = null;
        ResultSet rs;
        try {
            ps = conn.getConn().prepareStatement(SQL_READ);
            ps.setInt(1, (int) pk);
            rs = ps.executeQuery();
            while (rs.next()) {
                equipo = new EquipoDTO(rs.getInt(1), rs.getString(2), rs.getDate(3));
            }
            return equipo;
        } catch (SQLException ex) {
            //java.util.logging.Logger.getLogger(JugadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conn.cerrarConexion();
        }
        return equipo;
    }

    @Override
    public List<EquipoDTO> readAll() {
        PreparedStatement ps;
        ArrayList<EquipoDTO> equipos = new ArrayList<>();
        ResultSet rs;
        try {
            ps = conn.getConn().prepareStatement(SQL_READALL);
            rs = ps.executeQuery();
            while (rs.next()) {
                equipos.add(new EquipoDTO(rs.getInt(1), rs.getString(2), rs.getDate(3)));
            }
        } catch (SQLException ex) {
            //java.util.logging.Logger.getLogger(JugadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conn.cerrarConexion();
        }
        return equipos;
    }
    
}
