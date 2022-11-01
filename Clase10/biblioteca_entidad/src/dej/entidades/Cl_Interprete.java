package dej.entidades;

public class Cl_Interprete {

    private String nombre;
    private int edad;
    private char sexo;

    public Cl_Interprete() {
    }

    public Cl_Interprete(String nombre, int edad, char sexo) {
        setNombre(nombre);
        setEdad(edad);
        setSexo(sexo);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre.length() > 2) {
            this.nombre = nombre;
        } else {
            throw new IllegalArgumentException("nombre largo minimo 2");
        }
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        if (edad >= 5 && edad <= 100) {
            this.edad = edad;
        } else {
            throw new IllegalArgumentException("edad entre 5 y 100");
        }

    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

}
