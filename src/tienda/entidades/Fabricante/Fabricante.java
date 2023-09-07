package tienda.entidades.Fabricante;

public class Fabricante {
    private int codigo;
    private String nombre;

    public Fabricante() {
    }

    public int getCodigo() {
        return this.codigo;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
