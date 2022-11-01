package DTO;
// Generated 15-11-2016 03:06:05 PM by Hibernate Tools 3.6.0


import java.util.HashSet;
import java.util.Set;

/**
 * Alumno generated by hbm2java
 */
public class Alumno  implements java.io.Serializable {


     private String rut;
     private String nombre;
     private int edad;
     private Set<Nota> notas = new HashSet<Nota>(0);

    public Alumno() {
    }

	
    public Alumno(String rut, String nombre, int edad) {
        this.rut = rut;
        this.nombre = nombre;
        this.edad = edad;
    }
    public Alumno(String rut, String nombre, int edad, Set<Nota> notas) {
       this.rut = rut;
       this.nombre = nombre;
       this.edad = edad;
       this.notas = notas;
    }
   
    public String getRut() {
        return this.rut;
    }
    
    public void setRut(String rut) {
        this.rut = rut;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getEdad() {
        return this.edad;
    }
    
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public Set<Nota> getNotas() {
        return this.notas;
    }
    
    public void setNotas(Set<Nota> notas) {
        this.notas = notas;
    }




}


