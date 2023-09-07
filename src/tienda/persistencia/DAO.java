package tienda.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class DAO {

    protected Connection conexion = null;
    protected ResultSet resultado = null;
    protected Statement stmt = null;

    private final String USER = "root";
    private final String PASSWORD = "root";
    private final String DATABASE = "tienda";
    private final String DRIVER = "com.mysql.jdbc.Driver";

    protected void conectarBase() throws ClassNotFoundException, SQLException {
        try {
            Class.forName(DRIVER);
            String urlBaseDeDatos = "jdbc:mysql://localhost:3306/" + DATABASE + "?useSSL=false";
            conexion = DriverManager.getConnection(urlBaseDeDatos, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException ex) {
            throw ex;
        }
    }

    protected void desconectarBase() throws Exception {
        try {
            if (resultado != null) {
                resultado.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conexion != null) {
                conexion.close();
            }
        } catch (Exception e) {
            throw e;
        }
    }

    protected void insertarModificarEliminar(String sql) throws Exception {
        try {
            conectarBase();
            stmt = conexion.createStatement();
            stmt.executeUpdate(sql);
        } catch (SQLException | ClassNotFoundException ex) {
            //conexion.rollback();
            /*
            Descomentar la linea anterior si desean tener en cuenta el rollback.
            Correr el siguiente script en workbench
            
            SET autocommit = 1;
            COMMIT;
            
            **Sin rollback igual anda
             */
            throw ex;
        } finally {
            desconectarBase();
        }
    }

    protected void consultarBase(String sql) throws Exception {
        try {
            conectarBase();
            stmt = conexion.createStatement();
            resultado = stmt.executeQuery(sql);
        } catch (Exception e) {
            throw e;
        }
    }
}

/*
    Principales metodos para DAO 

public void guardarProducto(Producto producto) throws Exception {
        try {
            if (producto == null) {
                throw new Exception("Debe indicar un producto");
            }
            String sql = "INSERT INTO producto (nombre, precio, codigo_fabricante)"
                    + "VALUES ('" + producto.getNombre() + "', '" + producto.getPrecio() + "', '" + producto.getCodigoFabricante() + "');";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        }
    }

    public void modificarProducto(Producto producto) throws Exception {
        try {
            if (producto == null) {
                throw new Exception("Debe indicar un producto a modificar");
            }
            String sql = "UPDATE producto SET "
                    + "nombre = '" + producto.getNombre() + "', precio = '" + producto.getPrecio() + "', codigo_fabricante = '" + producto.getCodigoFabricante() + "' "
                    + "WHERE codigo = '" + producto.getCodigo() + "'";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        }
    }

    public void eliminarProducto(int codigo) throws Exception {
        try {
            String sql = "DELETE FROM producto WHERE codigo = '" + codigo + "';";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        }
    }
public void buscarProductoPorNombre(String nombre) throws Exception{
        try {
            String sql = "SELECT * FROM producto WHERE nombre = '"+ nombre+"';";
            consultarBase(sql);
            
            Producto producto = null;
            
            while(resultado.next()){
                producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getDouble(3));
                producto.setCodigoFabricante(resultado.getInt(4));
            }
            desconectarBase();
            
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }
    
    public ArrayList<String> listarTodoPorNombre() throws Exception{
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
}
*/