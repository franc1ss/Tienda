package tienda.entidades.Producto;

import java.util.Scanner;
import tienda.persistencia.ProductoDAO;

public class ProductoService {
    
    private ProductoDAO dao;
    private Scanner cin = new Scanner(System.in).useDelimiter("\n");
    
    public ProductoService(){
        this.dao = new ProductoDAO();
    }
    
    public void mostrarTodoPorNombre() throws Exception{
        try {
            for (String nombre : dao.listarTodoPorNombre()) {
                System.out.println(nombre);
            }
        } catch (Exception e) {
            throw e;
        }
    }
    public void mostrarTodoPorNombreYPrecio() throws Exception{
        try {
            for (Producto producto : dao.listarTodoPorNombreYPrecio()) {
                System.out.println(producto.getNombre() + " --- " + producto.getPrecio());
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void mostrarPorRangoPrecio() throws Exception{
        try {
            for (Producto producto : dao.listarRangoPrecio(120, 202)) {
                System.out.println(producto.getCodigo()+" - "+producto.getNombre()+" - "+producto.getPrecio()+" - "+producto.getCodigoFabricante());
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void mostrarPortatiles() throws Exception{
        try {
            for (Producto producto : dao.listarPortatiles()) {
                System.out.println(producto.getCodigo()+" - "+producto.getNombre()+" - "+producto.getPrecio()+" - "+producto.getCodigoFabricante());
            }
            } catch (Exception ex) {
                throw ex;
            }
    }
    
    public void mostrarMasBarato() throws Exception{
        try {
            for (Producto producto : dao.listarMasBarato()) {
                System.out.println(producto.getNombre() +" - " +producto.getPrecio());
            }
        } catch (Exception e) {
            throw e;
        }
    }
    public void agregarProducto() throws Exception{
        try {
        Producto producto = new Producto();
        System.out.println("Digite el nombre: ");
        producto.setNombre(cin.nextLine());
        System.out.println("Digite el precio: ");
        producto.setPrecio(cin.nextDouble());
        System.out.println("Digite el codigo de fabricante: ");
        producto.setCodigoFabricante(cin.nextInt());   
        dao.guardarProducto(producto);
        } catch (Exception e) {
            throw e;
        }
    }
}
