package tienda.entidades.Fabricante;

import java.util.Scanner;
import tienda.persistencia.FabricanteDAO;

public class FabricanteService {

    private FabricanteDAO dao;
    private Scanner cin = new Scanner(System.in).useDelimiter("\n");

    public FabricanteService() {
        this.dao = new FabricanteDAO();
    }
    
public void agregarFabricante() throws Exception{
        try {
        Fabricante fabricante = new Fabricante();
        System.out.println("Digite el codigo: ");
        fabricante.setCodigo(cin.nextInt());
        cin.nextLine();
        System.out.println("Digite el nombre: ");
        fabricante.setNombre(cin.nextLine());
        dao.guardarFabricante(fabricante);
        } catch (Exception e) {
            throw e;
        }
    }    
}
