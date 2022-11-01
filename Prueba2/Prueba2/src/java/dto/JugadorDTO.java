/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.sql.Date;


/**
 *
 * @author Duoc
 */
public class JugadorDTO {
    
    private int idJugador;
    private String nombre;
    private String rol;
    private int posicion;
    private Date fechaNacimiento;
    private int id_equipo;
    private Date hoy;

    public JugadorDTO() {
    }

    public JugadorDTO(int idJugador, String nombre, String rol, int posicion, Date fechaNacimiento, int id_equipo) {
        this.idJugador = idJugador;
        setNombre(nombre);
        setRol(rol);
        setPosicion(posicion);
        setFechaNacimiento(fechaNacimiento);
        this.id_equipo = id_equipo;
    }

    public int getId_equipo() {
        return id_equipo;
    }

    public void setId_equipo(int id_equipo) {
        this.id_equipo = id_equipo;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre.length() > 3) {
            this.nombre = nombre;
        } else {
            throw new IllegalArgumentException("El nombre debe tener mas de 3 caracteres");
        }
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        if (rol.equals("Tanque") || rol.equals("Atacante") || rol.equals("Asistidor")) {
            this.rol = rol;
        } else {
            throw new IllegalArgumentException("El rol solo puede ser: Tanque,Atacante o Asistidor");
        }
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        if (posicion > 0 && posicion < 6) {
            this.posicion = posicion;
        } else {
            throw new IllegalArgumentException("La posicion solo puede estar  entre 1 y 5");
        }
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
//        if (fechaNacimiento.before(hoy)) {
//            this.fechaNacimiento = fechaNacimiento;
//        }else{
//            throw new IllegalArgumentException("La fecha debe ser menor a la de hoy");
//        }
    }

    public int getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(int idJugador) {
        this.idJugador = idJugador;
    }
    
    

}
