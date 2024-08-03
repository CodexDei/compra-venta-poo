package org.productos.codexdei;

public class Producto {

    private String nombreProducto;
    private double precio;

    //Constructor vacio
    public Producto(){}

    //Contructor con parametros
    public Producto(String nombreProducto, double precio){

        this.nombreProducto = nombreProducto;
        this.precio = precio;
    }

    //getters
    public String getNombreProducto(){
        return this.nombreProducto;
    }

    public double getPrecio(){
        return this.precio;
    }

    //toString
    @Override
    public String toString(){
        return "Nombre producto=" + nombreProducto + "  " +
               "precio=" + precio + " USD " + "  ";
    }
}
