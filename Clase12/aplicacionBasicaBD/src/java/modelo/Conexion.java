/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Duoc
 */
public class Conexion {

    Connection conn; //Conecta con la bd
    Statement state; //Ejecuta el query
    ResultSet rs;    //almacena un select

    public Conexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/curso?zeroDateTimeBehavior=convertToNull", "root", "");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int insertarAlumno(Alumno alumno) {
        int resultado = 0;
        try {
            String query = "INSERT INTO Alumno (rut, nombre, apellido, edad) VALUES ('"+alumno.getRut()+"','"+alumno.getNombre()+"','"+alumno.getApellido()+"','"+alumno.getEdad()+"')";
            state = conn.createStatement();
            resultado = state.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
    
    public int eliminarAlumno(String rut) {
        int resultado = 0;
        try {
            String query = "";
            state = conn.createStatement();
            resultado = state.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }

}
