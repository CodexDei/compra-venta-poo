package org.personas.codexdei;

public class Cliente extends Persona{

    private double efectivo;
    private double compras;

    public Cliente(String nombrePersona, String apellido, int edad) {
        super(nombrePersona, apellido, edad);
    }

    public double getEfectivo() {
        return efectivo;
    }

    public void setEfectivo(double efectivo) {
        this.efectivo = efectivo;
    }

    public double getCompras() {
        return compras;
    }

    public void setCompras(double compras) {
        this.compras = compras;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Efectivo=" + efectivo + "\n" +
                "Compras=" + compras + "\n";
    }
}
