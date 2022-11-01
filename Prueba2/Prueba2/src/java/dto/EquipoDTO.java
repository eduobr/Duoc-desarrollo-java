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
public class EquipoDTO {
    
    private int idEquipo;
    private String nombre;
    private Date fechaCreacion;

    public EquipoDTO() {
    }

    public EquipoDTO(int idEquipo, String nombre, Date fechaCreacion) {
        this.idEquipo = idEquipo;
        setNombre(nombre);
        setFechaCreacion(fechaCreacion);
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre.length() > 3) {
            this.nombre = nombre;
        }else{
            throw new IllegalArgumentException("El nombre debe tener mas de 3 caracteres");
        }
    }

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

}
