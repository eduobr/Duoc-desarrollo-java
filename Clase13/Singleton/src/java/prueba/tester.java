/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package prueba;

import dao.AlumnoDAO;
import dto.AlumnoDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Duoc
 */
public class tester {
    
    public static void main(String[] args) {
        AlumnoDAO alumno = new AlumnoDAO();
        
//        alumno.create(new AlumnoDTO("1111","Sergio","Donoso",10));
//        alumno.create(new AlumnoDTO("2222","Sergio2","Donoso2",11));
//        alumno.create(new AlumnoDTO("3333","Sergio3","Donoso3",12));
//        alumno.create(new AlumnoDTO("4444","Sergio4","Donoso4",13));
//        alumno.update(new AlumnoDTO("1111","Julio","Perez",20));
//        alumno.delete("1111");
//        AlumnoDTO a = alumno.read("1111");
//        System.out.println("Rut:"+a.getRut()+" Nombre: "+a.getNombre());
        
        ArrayList<AlumnoDTO> alumnos = (ArrayList<AlumnoDTO>)alumno.readAll();
        
        for (AlumnoDTO alumnoDTO : alumnos) {
            System.out.println("Rut: "+alumnoDTO.getRut()+" Nombre: "+alumnoDTO.getNombre() );
        }
        
        
    }
   
}
