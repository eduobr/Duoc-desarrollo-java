package dej.controlador;

import dej.entidades.Cl_Cancion;
import java.util.ArrayList;

public class DaoCancion implements ICancion {

    //1 - Generar la coleccion
    private ArrayList<Cl_Cancion> canciones;

    public DaoCancion() {
        canciones = new ArrayList<Cl_Cancion>();
    }

    //2 - Implementar los metodos
    public boolean Agregar(Cl_Cancion cancion) {
        if (ExisteCancion(cancion) == false) {
            canciones.add(cancion);
            return true;
        }
        return false;
    }

    private boolean ExisteCancion(Cl_Cancion cancion) {
        for (Cl_Cancion item : canciones) {
            if (item.getInterprete().getNombre().equals(cancion.
                    getInterprete().getNombre())
                    && item.getTema().equals(cancion.getTema())) {
                return true;
            }
        }
        return false;
    }

    public Cl_Cancion Buscar(String nombre, String tema) {
        for (Cl_Cancion item : canciones) {
            if (item.getInterprete().getNombre().equals(nombre)
                    && item.getTema().equals(tema)) {
                return item;
            }
        }
        return null;
    }

    public ArrayList<Cl_Cancion> Listar() {
        return canciones;
    }

    public boolean Modificar(Cl_Cancion nuevaCancion) {
        for (Cl_Cancion item : canciones) {
            if (item.equals(nuevaCancion)) {
                canciones.remove(item);
                canciones.add(nuevaCancion);
                return true;
            }
        }
        return false;
    }

    public boolean Eliminar(String nombre, String tema) {
        for (Cl_Cancion item : canciones) {
            if (item.getInterprete().getNombre().equals(nombre)
                    && item.getTema().equals(tema)) {
                canciones.remove(item);
                return true;
            }
        }
        return false;
    }
}
