package org.productos.codexdei;

import java.util.Date;

public class Perecederos extends Producto{

    //Atributos de la clase
    private int cantidad;
    private Date fechaCaducidad;

    //Constructores
    public Perecederos(String nombreProducto, int precio, int cantidad, Date fechaCaducidad){

        super(nombreProducto, precio);
        this.cantidad = cantidad;
        this.fechaCaducidad = fechaCaducidad;
    }

    public int getCantidad(){
        return this.cantidad;
    }

    public Date getFechaCaducidad() {
        return this.fechaCaducidad;
    }

    @Override
    public String toString(){
        return super.toString() +
               "Cantidad=" + cantidad + "  " +
               "Fecha de caducidad=" + fechaCaducidad + "\n";
    }
}


