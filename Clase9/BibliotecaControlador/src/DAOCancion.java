
import Dej_Entidades.Cl_Cancion;
import java.util.ArrayList;

public class DAOCancion implements ICancion {

    private ArrayList<Cl_Cancion> canciones;

    public DAOCancion(ArrayList<Cl_Cancion> canciones) {
        this.canciones = new ArrayList<Cl_Cancion>();
    }

    @Override
    public boolean Agregar(Cl_Cancion cancion) {
        if (ExisteCancion(cancion) == false) {
            canciones.add(cancion);
            return true;
        }
        return false;
    }

    @Override
    public Cl_Cancion Buscar(String nombre, String tema) {
        for (Cl_Cancion item : canciones) {
            if (item.getInterprete().getNombre().equals(nombre)
                    && item.getTema().equals(tema)) {
                return item;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Cl_Cancion> Listar() {
        return canciones;
    }

    @Override
    public boolean Modificar(Cl_Cancion nueva_cancion) {
        for (Cl_Cancion item : canciones) {
            if (item.getInterprete().getNombre().equals(nueva_cancion.getInterprete().getNombre())
                    && item.getTema().equals(nueva_cancion.getTema())) {
                canciones.remove(item);
                canciones.add(nueva_cancion);
                return true;
            }
        }
        return false;
    }

    @Override
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

    private boolean ExisteCancion(Cl_Cancion cancion) {
        for (Cl_Cancion item : canciones) {
            if (item.getInterprete().getNombre().equals(cancion.getInterprete().getNombre())
                    && item.getTema().equals(cancion.getTema())) {
                return true;
            }
        }
        return false;
    }
}
