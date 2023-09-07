package tienda.persistencia;

import java.util.ArrayList;
import java.util.Collection;
import tienda.entidades.Producto.Producto;

public final class ProductoDAO extends DAO {

    /**
     * Lista una tabla de productos, y muestra el nombre de cada uno.
     *
     * @return Array de productos.
     * @throws java.lang.Exception
     */
    public ArrayList<String> listarTodoPorNombre() throws Exception {
        try {
            String sql = "SELECT nombre FROM producto;";
            consultarBase(sql);
            ArrayList<String> productos = new ArrayList();
            while (resultado.next()) {
                productos.add(resultado.getString(1));
            }
            desconectarBase();
            return productos;
        } catch (Exception e) {
            desconectarBase();
            throw new Exception("Error del sistema");
        }
    }

    /**
     * Lista una tabla de productos, y muestra el nombre y precio.
     *
     * @return Array de productos.
     * @throws Exception
     */
    public Collection<Producto> listarTodoPorNombreYPrecio() throws Exception {
        try {
            String sql = "SELECT nombre, precio FROM producto;";
            consultarBase(sql);
            Producto producto = null;
            Collection<Producto> productos = new ArrayList();
            while (resultado.next()) {
                producto = new Producto();
                producto.setNombre(resultado.getString(1));
                producto.setPrecio(resultado.getDouble(2));
                productos.add(producto);
            }
            desconectarBase();
            return productos;
        } catch (Exception e) {
            desconectarBase();
            throw new Exception("Error del sistema");
        }

    }
    /**
     * Lista una tabla de productos, y los muestra segun el precio.
     * @param a Precio minimo
     * @param b Precio maximo
     * @return Collecion de productos.
     * @throws Exception 
     */
    public Collection<Producto> listarRangoPrecio(int a, int b) throws Exception {
        try {
            String sql = "SELECT * FROM producto WHERE precio BETWEEN "+a+" AND "+b+";";
            consultarBase(sql);
            Producto producto = null;
            Collection<Producto> productos = new ArrayList();
            while (resultado.next()) {
                producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getDouble(3));
                producto.setCodigoFabricante(resultado.getInt(4));
                productos.add(producto);
            }
            desconectarBase();
            return productos;
        } catch (Exception e) {
            desconectarBase();
            throw new Exception("Error del sistema");
        }
        
    }
    /**
     * Lista una tabla de productos, mostrando los portatiles.
     * @return Collecion de productos.
     * @throws Exception 
     */
    public Collection<Producto> listarPortatiles() throws Exception {
        try {
            String sql = "SELECT * FROM producto WHERE nombre LIKE '%Portátil%';";
            consultarBase(sql);
            Producto producto = null;
            Collection<Producto> productos = new ArrayList();
            while (resultado.next()) {
                producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getDouble(3));
                producto.setCodigoFabricante(resultado.getInt(4));
                productos.add(producto);
            }
            desconectarBase();
            return productos;
        } catch (Exception e) {
            desconectarBase();
            throw new Exception("Error del sistema");
        }
    }
    /**
     * Busca el producto mas barato de todos.
     * @return Collecion de productos.
     * @throws Exception 
     */
    public Collection<Producto> listarMasBarato() throws Exception {
        try {
            String sql = "SELECT nombre, precio FROM producto ORDER BY precio asc LIMIT 1;";
            consultarBase(sql);
            Producto producto = null;
            Collection<Producto> productos = new ArrayList();
            while (resultado.next()) {
                producto = new Producto();
                producto.setNombre(resultado.getString(1));
                producto.setPrecio(resultado.getDouble(2));
                productos.add(producto);
            }
            desconectarBase();
            return productos;
        } catch (Exception e) {
            desconectarBase();
            throw new Exception("Error del sistema");
        }
    }
    /**
     * Guarda un producto.
     * @param producto
     * @throws Exception 
     */
    public void guardarProducto(Producto producto) throws Exception{
        try {
            if (producto==null) {
                throw new Exception("Debe indicar un producto");
            }
            String sql = "INSERT INTO producto(nombre, precio, codigo_fabricante) "
                    + "VALUES('"+producto.getNombre()+"', '"+producto.getPrecio()+"', '"+producto.getCodigoFabricante()+"');";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        }
    }
}
