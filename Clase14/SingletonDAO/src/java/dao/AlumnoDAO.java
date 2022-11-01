/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import conexion.Conexion;
import dto.AlumnoDTO;
import interfaces.MetodosCrud;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Duoc
 */
public class AlumnoDAO implements MetodosCrud<AlumnoDTO>{

    //Querys
    public static final String SQL_INSERT = "INSERT INTO alumno(rut,nombre,apellido,edad) VALUES (?,?,?,?)";
    public static final String SQL_UPDATE = "UPDATE alumno SET nombre = ?, apellido = ?, edad = ? WHERE rut = ?";
    public static final String SQL_DELETE = "DELETE FROM alumno WHERE rut = ?";
    public static final String SQL_READ = "SELECT * FROM alumno WHERE rut = ?";
    public static final String SQL_READALL = "SELECT * FROM alumno";
    
    //para saber la conexion a la base de datos
    public static final Conexion conn = Conexion.obtenerConexion(); // se implemento el singleton
    
    @Override
    public boolean create(AlumnoDTO objeto) {
        PreparedStatement ps;
        try {    
            ps = conn.getConn().prepareStatement(SQL_INSERT);
            ps.setString(1, objeto.getRut());
            ps.setString(2, objeto.getNombre());
            ps.setString(3, objeto.getApellido());
            ps.setInt(4, objeto.getEdad());
            
            if( ps.executeUpdate() == 1 ) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conn.cerrarConexion();
        }
        return false;
    }

    @Override
    public boolean update(AlumnoDTO objeto) {
        PreparedStatement ps;
        try {    
            ps = conn.getConn().prepareStatement(SQL_UPDATE);
            ps.setString(1, objeto.getNombre());
            ps.setString(2, objeto.getApellido());
            ps.setInt(3, objeto.getEdad());
            ps.setString(4, objeto.getRut());
            
            if( ps.executeUpdate() == 1 ) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoDAO.class.getName()).log(Level.SEVERE, null, ex);
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
            ps.setString(1, pk.toString());
            
            if( ps.executeUpdate() == 1 ) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conn.cerrarConexion();
        }
        return false;
    }

    @Override
    public AlumnoDTO read(Object pk) {
    PreparedStatement ps;
    AlumnoDTO alumno = null;
    ResultSet rs; // almacena un select
        try {    
            ps = conn.getConn().prepareStatement(SQL_READ);
            ps.setString(1, pk.toString());
            rs = ps.executeQuery(); // ejecutamos el query y retorna un select
            
            while(rs.next()) {
                alumno = new AlumnoDTO(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4));
            }
            
            return alumno;
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conn.cerrarConexion();
        }
        return alumno;    
    }

    @Override
    public List<AlumnoDTO> readAll() {
        PreparedStatement ps;
        ArrayList<AlumnoDTO> alumnos = new ArrayList<>();
        ResultSet rs; // almacena un select
        try {    
            ps = conn.getConn().prepareStatement(SQL_READALL);
            rs = ps.executeQuery(); // ejecutamos el query y retorna un select
            
            while(rs.next()) {
                alumnos.add(new AlumnoDTO(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4)));
            }           
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conn.cerrarConexion();
        }
        return alumnos;    
    }
    
}
