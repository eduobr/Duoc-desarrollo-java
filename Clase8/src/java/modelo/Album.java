/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.util.ArrayList;

/**
 *
 * @author Duoc
 */
public class Album {
    ArrayList<Cancion>canciones;
    
    public Album(){
        canciones = new ArrayList<Cancion>();
    }
    
    public void agregarCancion(Cancion nueva){
        if (this.validarCancion(nueva.getNombre(), nueva.getInterprete().getNombre())==false) {
            canciones.add(nueva);
        }
    }
    
    public boolean validarCancion(String nombreCancion,String interprete){
        boolean valida = false;
        for (Cancion temporal : canciones) {
            if (temporal.getNombre().equals(nombreCancion) && temporal.getInterprete().getNombre().equals(interprete)) {
                valida = true;
                break;
            }
        }
        return valida;
    }
    
    public ArrayList listar(){
        ArrayList lista = new ArrayList();
        for (Cancion temporal : canciones) {
            lista.add(temporal.getNombre());
        }
        return lista;
    }
}
