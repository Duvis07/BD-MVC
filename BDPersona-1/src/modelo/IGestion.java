package modelo;

import java.util.List;

public interface IGestion {
    
    public List<Usuario> consultar();
    
    public int guardar(Usuario usuario);
    
    public boolean eliminarPorDocumento(String documento);
}
