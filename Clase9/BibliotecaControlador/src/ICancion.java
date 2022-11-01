
import Dej_Entidades.Cl_Cancion;
import java.util.ArrayList;


public interface ICancion {
    boolean Agregar(Cl_Cancion cancion);
    Cl_Cancion Buscar(String nombre,String tema);
    ArrayList<Cl_Cancion>Listar();
    boolean Modificar(Cl_Cancion nueva_cancion);
    boolean Eliminar(String nombre,String tema);
}
