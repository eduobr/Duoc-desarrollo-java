/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

/**
 *
 * @author Duoc
 */
public class Cancion {
    private String nombre;
    private int duracion;
    private boolean enVivo;
    private Persona interprete;

    public Cancion() {
    }

    public Cancion(String nombre, int duracion, boolean enVivo, Persona interprete) {
        this.nombre = nombre;
        this.duracion = duracion;
        this.enVivo = enVivo;
        this.interprete = interprete;
    }

    public Persona getInterprete() {
        return interprete;
    }

    public void setInterprete(Persona interprete) {
        this.interprete = interprete;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public boolean isEnVivo() {
        return enVivo;
    }

    public void setEnVivo(boolean enVivo) {
        this.enVivo = enVivo;
    }
    
    
    
}
