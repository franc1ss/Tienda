package tienda;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import tienda.entidades.Fabricante.FabricanteService;
import tienda.entidades.Producto.ProductoService;

public class main {

    public static void main(String[] args) {
        ProductoService ps = new ProductoService();
        FabricanteService fs = new FabricanteService();
        Scanner cin = new Scanner(System.in).useDelimiter("\n");

        //Menu
        int band;
        System.out.println("1. Listar el nombre de todos los productos que hay en la tabla producto.");
        System.out.println("2. Lista los nombres y los precios de todos los productos de la tabla producto.");
        System.out.println("3. Listar aquellos productos que su precio esté entre 120 y 202.");
        System.out.println("4. Buscar y listar todos los Portátiles de la tabla producto.");
        System.out.println("5. Listar el nombre y el precio del producto más barato.");
        System.out.println("6. Ingresar un producto a la base de datos.");
        System.out.println("7. Ingresar un fabricante a la base de datos");
        System.out.println("Seleccione la accion a realizar: ");
        //opciones
        band = cin.nextInt();
        switch (band) {
            case 1:
                try {
                    ps.mostrarTodoPorNombre();
                } catch (Exception ex) {
                    Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case 2:
                try {
                    ps.mostrarTodoPorNombreYPrecio();
                } catch (Exception ex) {
                    Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case 3:
                try {
                    ps.mostrarPorRangoPrecio();
                } catch (Exception ex1) {
                    Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex1);
                }
                break;
            case 4:
                try {
                    ps.mostrarPortatiles();
                } catch (Exception e) {
                    Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, e);
                }
                break;
            case 5:
                try {
                    ps.mostrarMasBarato();
                } catch (Exception ex) {
                    Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case 6:
                try {
                    ps.agregarProducto();
                } catch (Exception ex) {
                    Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case 7:
                try {
                    fs.agregarFabricante();
                } catch (Exception ex) {
                    Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            default:
                throw new AssertionError();
        }
    }
}
