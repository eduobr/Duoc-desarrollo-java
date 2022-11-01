/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Tester;

import DAO.AlumnoDAO;
import DTO.Alumno;

/**
 *
 * @author Duoc
 */
public class test {
    public static void main(String[] args) {
        Alumno al = new Alumno("1111", "Francisco", 28);
        AlumnoDAO dao = new AlumnoDAO();
        //dao.crearAlumno(al);
        //dao.buscarPorRut("1111");
        //dao.eliminarAlumno("123456789");
        //dao.updateAlumno(al);
        //dao.ListarAlumno();
    }
}
