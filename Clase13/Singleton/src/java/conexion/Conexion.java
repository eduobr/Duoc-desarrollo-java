/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Duoc
 */
public class Conexion {
    public static Conexion instance; // lo utilizaremos para el singleton
    public Connection conn; // para crear el statement
    
    private Conexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver"); // Driver Class
            //DATABASE URL , user, pass
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/curso?zeroDateTimeBehavior=convertToNull", "root", ""); // Database URL
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }
    
    //Comprobamos si existe la instancia
    //synchronized : nos permite hacer una lista de espera.
    public synchronized static Conexion obtenerConexion() {
        if ( instance == null ) {
            instance = new Conexion();
        }
        return instance;
    }
    
    //cerramos la conexion
    public void cerrarConexion() {
        instance = null;
    }
}
