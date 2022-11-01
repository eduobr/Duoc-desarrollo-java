/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package prueba;

import dao.AlumnoDAO;
import dto.AlumnoDTO;
import java.util.ArrayList;

/**
 *
 * @author Duoc
 */
public class tester {
    
    public static void main(String[] args) {
        AlumnoDAO alumno = new AlumnoDAO();
        //alumno.create(new AlumnoDTO("1111","Felipe","Araneda",20));
        //alumno.create(new AlumnoDTO("2222","Felipe2","Araneda2",21));
        //alumno.create(new AlumnoDTO("3333","Felipe3","Araneda3",22));
        //alumno.create(new AlumnoDTO("4444","Felipe4","Araneda4",23));
        //alumno.update(new AlumnoDTO("1111","Cesar","Curin",30));
        //alumno.delete("1111");
        
        AlumnoDTO a = alumno.read("1111");
        System.out.println("Nombre: " + a.getNombre());
        
        //ArrayList<AlumnoDTO> alumnos = (ArrayList<AlumnoDTO>)alumno.readAll();
        
        //for (AlumnoDTO a : alumnos) {
        //    System.out.println("Nombre: " + a.getNombre());    
        //}
        
    }
}
