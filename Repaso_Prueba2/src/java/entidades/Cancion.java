/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author SP
 */
public class Cancion {
    private Persona interprete;
    private String nombre;
    private int duracion;
    private boolean vivo;

    public Cancion() {
    }

    public Cancion(Persona interprete, String nombre, int duracion, boolean vivo) {
        setInterprete(interprete);
        setNombre(nombre);
        setDuracion(duracion);
        setVivo(vivo);
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
        if (nombre.length() > 2) {
            this.nombre = nombre;
        } else {
            throw new IllegalArgumentException("nombre cancion mayor a 2");
        }
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        if (duracion >=60) {
            this.duracion = duracion;
        } else {
            throw new IllegalArgumentException("duracion mayor a 60");
        }
    }

    public boolean isVivo() {
        return vivo;
    }

    public void setVivo(boolean vivo) {
        this.vivo = vivo;
    }
}
