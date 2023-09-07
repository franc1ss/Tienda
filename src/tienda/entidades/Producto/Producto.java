package tienda.entidades.Producto;

public class Producto {
    private int codigo; 
    private String nombre;
    private double precio;
    private int codigoFabricante;

    public Producto() {
    }
    
    public int getCodigo() {
        return this.codigo;
    }

    public String getNombre() {
        return this.nombre;
    }

    public double getPrecio() {
        return this.precio;
    }

    public int getCodigoFabricante() {
        return this.codigoFabricante;
    }   

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setCodigoFabricante(int codigoFabricante) {
        this.codigoFabricante = codigoFabricante;
    }
    
}
