package org.personas.codexdei;

public class Persona {

    private String nombrePersona;
    private String apellido;
    private int edad;

    public Persona(){
    }

    public Persona(String nombrePersona, String apellido, int edad){

        this.nombrePersona = nombrePersona;
        this.apellido = apellido;
        this.edad = edad;
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    public String getApellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }

    @Override
    public String toString() {
        return  "Nombre Persona=" + nombrePersona + "\n" +
                "Apellido=" + apellido + "\n" +
                "Edad=" + edad + "\n";
    }
}
