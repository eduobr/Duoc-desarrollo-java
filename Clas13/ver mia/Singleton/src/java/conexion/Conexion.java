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
    private static Conexion instance; //lo utilizaremos para el singleton

    public static Conexion getInstance() {
        return instance;
    }

    public static void setInstance(Conexion aInstance) {
        instance = aInstance;
    }
    private Connection conn;//para crearel statment
    
    private Conexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver");//Driver Class
            //DATABASE URL, USER, PASS
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/curso?zeroDateTimeBehavior=convertToNull","root","");
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
    //comprobamos is existe la instancia
    //synchronized: nos permite generar unalista de espera
    public synchronized static Conexion obtenerConexion(){
        if (instance==null) {
            instance=new Conexion();
        }
        return instance;
    }
    
    //cerramos la conexion
    public void cerrarConexion(){
        instance=null;
    }
}
