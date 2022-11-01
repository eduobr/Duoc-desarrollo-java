/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.ArrayList;

/**
 *
 * @author SP
 */
public class DaoCanciones {
    private ArrayList<Cancion> albunes;

    public DaoCanciones() {
        albunes = new ArrayList<Cancion>();
    }
    
    //metodos;
    public boolean Agregar(Cancion cancion){
        if(ExisteCancion(cancion)==false){
            albunes.add(cancion);
            return true;
        }
        return false;
    }

    private boolean ExisteCancion(Cancion cancion) {
        for (Cancion item : albunes) {
            if(item.getInterprete().getNombre().equals(cancion.getInterprete().getNombre()) && item.getNombre().equals(cancion.getNombre())){
                return true;
            }
        }
        return false;
    }

    public boolean Eliminar(String nombre_cancion){
        for (Cancion item : albunes) {
            if (item.getNombre().equals(nombre_cancion)) {
                albunes.remove(item); 
                return true;
            }
        }
        return false;
    }
    
    public ArrayList<Cancion> Listar(){
        return albunes;
    }
    
}
