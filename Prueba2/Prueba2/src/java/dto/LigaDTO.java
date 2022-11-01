/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author Duoc
 */
public class LigaDTO {

    private int idLiga;
    private String nombre;
    private char clasificacion;
    private int idEquipo;

    public LigaDTO() {
    }

    public LigaDTO(int idLiga, String nombre, char clasificacion, int idEquipo) {
        this.idLiga = idLiga;
        setNombre(nombre);
        setClasificacion(clasificacion);
        this.idEquipo = idEquipo;
    }

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre.length() > 3) {
            this.nombre = nombre;
        } else {
            throw new IllegalArgumentException("el nombre debe ser mayor a 3 caracteres");
        }
    }

    public char getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(char clasificacion) {
        if (clasificacion == 'A' || clasificacion=='V' || clasificacion=='P') {
            this.clasificacion = clasificacion;
        }else{
            throw new IllegalArgumentException("La clasificacion solo puede ser Amateur, Veteranos y Profesionales");
        }
    }

    public int getIdLiga() {
        return idLiga;
    }

    public void setIdLiga(int idLiga) {
        this.idLiga = idLiga;
    }

}
