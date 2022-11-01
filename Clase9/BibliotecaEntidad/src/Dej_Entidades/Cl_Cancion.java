/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dej_Entidades;

/**
 *
 * @author Duoc
 */
public class Cl_Cancion {

    private Cl_Interprete interprete;
    private String tema;
    private int duracion;
    private boolean enVivo;

    public Cl_Cancion() {
    }

    public Cl_Cancion(Cl_Interprete interprete, String tema, int duracion, boolean enVivo) {
        this.interprete = interprete;
        this.tema = tema;
        setDuracion(duracion);
        this.enVivo = enVivo;
    }

    public Cl_Interprete getInterprete() {
        return interprete;
    }

    public void setInterprete(Cl_Interprete interprete) {
        this.interprete = interprete;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        if (duracion > 60) {
            this.duracion = duracion;
        }else{
            throw new IllegalArgumentException("duracion minimo 60 seg");
        }
    }

    public boolean isEnVivo() {
        return enVivo;
    }

    public void setEnVivo(boolean enVivo) {
        this.enVivo = enVivo;
    }

}
