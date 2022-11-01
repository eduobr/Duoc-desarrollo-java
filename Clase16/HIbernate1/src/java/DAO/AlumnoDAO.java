/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import DTO.Alumno;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Duoc
 */
public class AlumnoDAO {
    private Session sesion;
    private Transaction tx;
    
    private void iniOperacion(){
        sesion=HibernateUtil.getSessionFactory().openSession();
        tx = sesion.beginTransaction();
    }
    
    public boolean crearAlumno(Alumno alumno){
        try {
            iniOperacion();
            sesion.save(alumno);
            tx.commit();
            sesion.close();
            return true;
        } catch (Exception e) {
            tx.rollback();
            sesion.close();
            throw new RuntimeException("No se guardo el Alumno: "+e.getMessage());
        }
    }
        
        public Alumno buscarPorRut(String rut){
            try {
                iniOperacion();
                List<Alumno> listado=sesion.createQuery("from Alumno where rut='"+rut+"'").list();
                for (Alumno li : listado) {
                    return li;
                }
            } 
            catch (Exception e) {
                sesion.close();
                throw new RuntimeException("No se encontor el Alumno :"+e.getMessage());
            }
            return null;
        }
        
        public boolean eliminarAlumno(String rut){
            try {
                iniOperacion();
                Alumno alumno = buscarPorRut(rut);
                sesion.delete(alumno);
                tx.commit();
                sesion.close();
                return true;
            } catch (Exception e) {
                sesion.close();
                throw new RuntimeException("No se elimino el Alumno"+e.getMessage());
            }
        }
        
        public boolean updateAlumno(Alumno alumno){
            try {
                iniOperacion();
                Alumno alumnoOLD = buscarPorRut(alumno.getRut());
                alumnoOLD.setNombre(alumno.getNombre());
                alumnoOLD.setEdad(alumno.getEdad());
                sesion.update(alumnoOLD);
                tx.commit();
                sesion.close();
                return true;
            } catch (Exception e) {
                sesion.close();
                throw new RuntimeException("No se actualizo el administrador:; "+e.getMessage());
            }
        }
        
        public List<Alumno>ListarAlumno(){
            try {
                iniOperacion();
                List<Alumno>li=sesion.createQuery("from Alumno").list();
                return li;
            } catch (Exception e) {
                sesion.close();
                throw new RuntimeException("No se listo a los Alumnos: "+e.getMessage());
            }
        }
}
