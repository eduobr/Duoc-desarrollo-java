/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package prueba;

import dao.AlumnoDAO;
import dto.AlumnoDTO;

/**
 *
 * @author Duoc
 */
public class tester {
    public static void main(String[] args) {
        AlumnoDAO alumno = new AlumnoDAO();
        
        //alumno.create(new AlumnoDTO("1111","Sergio","Donoso",10));
        alumno.update(new AlumnoDTO("1111","Julio","Perez",20));
        AlumnoDTO a = alumno.read("1111");
        
        System.out.println("Nombre"+a.getNombre());
    }
}
