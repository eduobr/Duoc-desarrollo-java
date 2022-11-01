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
    public static Conexion instance; // servira para el singleton
    public Connection conn; // para crear el statement
    
    private Conexion() {
        try {
            // driver Class
            Class.forName("com.mysql.jdbc.Driver");
            // url database , user , pass
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/curso?zeroDateTimeBehavior=convertToNull","root","");
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
    
    //comprobamos si existe la instancia
    //synchronized: nos permite hacer una lista de espera.
    public synchronized static Conexion obtenerConexion() {
        if ( instance == null ) {
            instance = new Conexion();
        }
        return instance;
    }
    
    //cerrar conexion
    public void cerrarConexion() {
        instance = null;
    }
}
