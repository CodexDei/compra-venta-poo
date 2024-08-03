package org.productos.codexdei;

public class NoPerecederos extends Producto{

    //Atributos de la clase
    private int contenido;
    private int calorias;

    public NoPerecederos(String nombreProducto, int precio, int contenido, int calorias) {
        super(nombreProducto, precio);
        this.contenido = contenido;
        this.calorias = calorias;
    }

    public int getContenido() {
        return contenido;
    }

    public int getCalorias() {
        return calorias;
    }

    @Override
    public String toString() {
        return  super.toString() +
                "Contenido=" + contenido + " Lb  " +
                "Calorias=" + calorias + "\n";
    }
}
