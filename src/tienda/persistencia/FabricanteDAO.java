package tienda.persistencia;

import tienda.entidades.Fabricante.Fabricante;

public final class FabricanteDAO extends DAO {

    public void guardarFabricante(Fabricante fabricante) throws Exception {
        try {
            if (fabricante == null) {
                throw new Exception("Debe indicar un producto");
            }
            String sql = "INSERT INTO fabricante(codigo, nombre) "
                    + "VALUES('"+fabricante.getCodigo()+"', '" + fabricante.getNombre() + "');";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        }
    }

}
