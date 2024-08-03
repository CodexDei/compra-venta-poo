package org.productos.codexdei;

public class Limpieza extends Producto{

    private String composicion;
    private double litros;

    public Limpieza(String nombreProducto, double precio, String composicion,double litros){

        super(nombreProducto, precio);
        this.composicion = composicion;
        this.litros = litros;
    }

    public String getComposicion(){
        return this.composicion;
    }

    public double getLitros(){
        return this.litros;
    }

    @Override
    public String toString(){
        return super.toString() +
               "Composicion=" + composicion + "  " +
               "Litros=" + litros + "\n";
    }
}
