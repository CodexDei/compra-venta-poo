package org.personas.codexdei;

public class Vendedor extends Persona{

    private double sueldo;
    private double ventas;
    private double comision;

    public Vendedor(String nombrePersona, String apellido, int edad){

        super(nombrePersona, apellido, edad);
    }

    public double getSueldo(){
        return this.sueldo;
    }

    public double getVentas(){
        return this.ventas;
    }

    public void setSueldo(double sueldo){
        this.sueldo = sueldo;
    }

    public void setVentas(double ventas) {
        this.ventas = ventas;
    }

    public double getComision() {
        return comision;
    }

    public void setComision(double comision) {
        this.comision = comision;
    }

    public double comision(double ventas){

        return (ventas * 5) / 100;
    }

    public double cobrarCompra(double efectivo, double valorcompra){

        return efectivo - valorcompra;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Sueldo=" + sueldo + "\n" +
                "Ventas=" + ventas + "\n";
    }
}
