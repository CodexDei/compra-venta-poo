import org.personas.codexdei.Cliente;
import org.personas.codexdei.Vendedor;
import org.productos.codexdei.Limpieza;
import org.productos.codexdei.NoPerecederos;
import org.productos.codexdei.Perecederos;
import org.productos.codexdei.Producto;

import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Locale;

public class EjemploCompraVenta {

    public static boolean estatusPrograma = false;

    public static void main(String[] args) throws ParseException {

        do{

            try{

                int menu = Integer.parseInt(JOptionPane.showInputDialog(
                        "Ingrese la opcion que desee:\n" +
                                "1. Ir de compras amiguis!!!\n" +
                                "2. Salir"));

                switch (menu){

                    case 1:

                        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);

                        String fechaLeche = "27/08/2024";
                        String fechaHuevos = "15/09/2024";

                        Date fechaCaducidadLeche = formatoFecha.parse(fechaLeche);
                        Date fechaCaducidadHuevos = formatoFecha.parse(fechaHuevos);

                        //Objetos Perecederos
                        Perecederos leche = new Perecederos("Paca leche", 7,6,fechaCaducidadLeche);
                        Perecederos huevos = new Perecederos("Cubeta huevos", 5,1,fechaCaducidadHuevos);

                        //Objetos No perecederos
                        NoPerecederos arroz = new NoPerecederos("Arroz Roa",5,500,150);
                        NoPerecederos lentejas = new NoPerecederos("lentejas Leti",8,500,350);

                        //Limpieza
                        Limpieza clorox = new Limpieza("Blancox", 2.23,"hipoclorito de sodio",2.0);
                        Limpieza jabonLiquido = new Limpieza("Fab Liquido", 6.73,
                                "Fosfatos, Tensioactivos no iónicos, Carbonatos,\n" +
                                        "Perborato, Blanqueantes ópticos y Componentes inertes",1.8);

                        //Cliente
                        Cliente cliente1 = new Cliente("Jorge","Castillo",30);
                        cliente1.setEfectivo(50);

                        //Vendedor
                        Vendedor vendedor1 = new Vendedor("Marye", "Mora",30);
                        Vendedor vendedor2 = new Vendedor("Samy", "Acosta",18);

                        Object[] vendedores = {vendedor1.getNombrePersona(), vendedor2.getNombrePersona()};

                        int elijaVendedor = JOptionPane.showOptionDialog(
                                null,"Quien desea que lo atienda", "Elija un vendedor",
                                JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE,null,vendedores,vendedores[0]);

                        Vendedor vendedorElejido = (elijaVendedor == 0) ? vendedor1 : vendedor2;

                        //funcion almacenara los productos es un array
                        IrDeCompras(leche,huevos,arroz,lentejas,clorox,jabonLiquido, cliente1,vendedorElejido);

                        //Vendedor
                        vendedorElejido.setSueldo(100);
                        vendedorElejido.setVentas(cliente1.getCompras());
                        //set modifica el atributo comision, el metodo comision calcula la comision con
                        //el valor del getVentas
                        vendedorElejido.setComision(vendedorElejido.comision(vendedorElejido.getVentas()));

                        JOptionPane.showMessageDialog(null,
                                "La comision de " + vendedorElejido.getNombrePersona() + " fue de: " +
                                          + vendedorElejido.getComision() + "\n\nequivalente a:\n\n" +
                                         "Compra: " + vendedorElejido.getVentas() + " * " + " 5% " + " = " + vendedorElejido.getComision());

                        break;

                    case 2:

                        JOptionPane.showMessageDialog(null,
                                "Ha selecionado Salir, gracias por utilizar programas\n" +
                                        "FAMILIA ACOSTA MORA");

                        estatusPrograma = true;

                        break;

                    default:

                        JOptionPane.showMessageDialog(null,
                        "Elija una opcion valida","Error",JOptionPane.WARNING_MESSAGE);

                        break;
                }

            }catch (InputMismatchException e){

                JOptionPane.showMessageDialog(null,
                "Ingrese una opcion valida","ERROR",JOptionPane.ERROR_MESSAGE);

            }catch (Exception e){

                JOptionPane.showMessageDialog(null,
                "ERROR EN LA EJECUCION: " + e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);

            }
        }while (!estatusPrograma);
    }

    private static void IrDeCompras(Producto leche,Producto huevos, Producto arroz,
           Producto lentejas,Producto clorox, Producto jabonLiquido, Cliente cliente, Vendedor vendedor) {

        StringBuilder mostrarCompra = new StringBuilder("COMPRA EN TIENDA ACMOR\n\n");

        int totalCompra = 0;
        boolean efectivoSuficiente = false;

        while (!efectivoSuficiente) {

            try {

                StringBuilder mensaje = new StringBuilder("LISTA DE PRODUCTOS:\n");

                ArrayList<Producto> productosParaComprar = new ArrayList<>();

                productosParaComprar.add(leche);
                productosParaComprar.add(huevos);
                productosParaComprar.add(arroz);
                productosParaComprar.add(lentejas);
                productosParaComprar.add(clorox);
                productosParaComprar.add(jabonLiquido);

                ArrayList<Producto> productosComprados = new ArrayList<>();
                //for para almacenar la lista de productos para luego mostrar al usuario
                for (int i = 0; i < productosParaComprar.size(); i++) {

                    mensaje.append(i + 1).append(". ").append(productosParaComprar.get(i));
                }

                boolean estatusCompras = false;

                mostrarCompra.append("Haz comprado:\n\n");

                do {


                    Object mensajeCuadroDialogo = "Desea comprar?";
                    Object[] opciones = {"SI", "NO"};

                    int comprar = JOptionPane.showOptionDialog(null,
                            mensajeCuadroDialogo, "Tienda ACOMOR", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
                            opciones, opciones[0]);

                    if (comprar == JOptionPane.YES_OPTION) {

                        int productoComprado = Integer.parseInt(JOptionPane.showInputDialog(
                                vendedor.getNombrePersona() + ": Bienvenido a Tiendas ACOMOR" + "\n" +
                                "Tiene en efectivo: " + cliente.getEfectivo() + "\n\n" +
                                        "Que desea comprar??:\n\n" + mensaje));

                        if (productoComprado <= 0 || productoComprado > productosParaComprar.size()) {

                            JOptionPane.showMessageDialog(null,
                                    "Ese Item no esta en la lista, intente de nuevo", "Advertencia", JOptionPane.WARNING_MESSAGE);
                            continue;
                        }
                        //aqui se agrega el producto comprado
                        int cuantosProductos = Integer.parseInt(JOptionPane.showInputDialog(null,"Cuantos productos " +
                                productosParaComprar.get(productoComprado-1).getNombreProducto() + " quiere comprar"));

                        for (int i = 0; i < cuantosProductos; i++){

                            productosComprados.add(productosParaComprar.get(productoComprado - 1));
                        }

                        JOptionPane.showMessageDialog(null,
                            mostrarCompra.append(productosParaComprar.get(productoComprado - 1).getNombreProducto())
                                         .append(" X ")
                                         .append(cuantosProductos).append("\n"));

                    } else if (comprar == JOptionPane.NO_OPTION) {

                        JOptionPane.showMessageDialog(null, "Gracias por visitarnos!!");
                        mostrarCompra.append("No has comprado ningun producto\n");
                        estatusCompras = true;
                    }

                } while (!estatusCompras);

                for (Producto valorproducto : productosComprados) {
                    totalCompra += valorproducto.getPrecio();
                }

                cliente.setCompras(totalCompra);

                double validarEfectivoParaCompra = vendedor.cobrarCompra(cliente.getEfectivo(),cliente.getCompras());

                if (validarEfectivoParaCompra < 0) {

                    JOptionPane.showMessageDialog(null,
                            "El valor de la compra supera el valor del efectivo del cliente",
                            "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);

                    productosParaComprar.clear();
                    mostrarCompra = new StringBuilder(" ");
                    totalCompra = 0;

                }else {

                    mostrarCompra.append("\nSu efectivo era de " + cliente.getEfectivo()).append("\n")
                                 .append("Su compra fue de: " + cliente.getCompras()).append("\n")
                                 .append("Sus vueltas o cambio son de: " + validarEfectivoParaCompra).append("\n\n");

                    JOptionPane.showMessageDialog(null,mostrarCompra);

                    efectivoSuficiente = true;
                }

            } catch (InputMismatchException e) {

                JOptionPane.showMessageDialog(null,
                        "Ingrese una opcion valida", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
}

