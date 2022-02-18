package controlador;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import modelo.Gestion;
import modelo.Usuario;

public class Controlador {
    private Gestion gestion;
    
    public DefaultTableModel listar(){
        DefaultTableModel modelo = new DefaultTableModel();
        gestion = new Gestion();
        List<Usuario> usuarios = new ArrayList<>();
        modelo = new DefaultTableModel(){
          @Override
          public boolean isCellEditable(int row, int column){
              return false;
          }
        };
        modelo.addColumn("Documento");
        modelo.addColumn("SS");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        usuarios = gestion.consultar();
        String registros[] = new String[4];
        for(Usuario us:usuarios){
            registros[0] = us.getDocumento();
            registros[1] = String.valueOf(us.getSeguridadSocial());
            registros[2] = us.getNombre();
            registros[3] = us.getApellido();
            modelo.addRow(registros);
        }
        return modelo;
    }
    
    public int agregar(Usuario usuario){
        int resultado = 0;
        gestion = new Gestion();
        resultado = gestion.guardar(usuario);
        return resultado;
    }
    
    public boolean eliminar(String documento){
        boolean res = false;
        gestion = new Gestion();
        res = gestion.eliminarPorDocumento(documento);
        return res;
    }
}
