package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utils.Mensaje;

public class Gestion implements IGestion{

    private Conexion conn;
    private PreparedStatement pStm;
    
    @Override
    public List<Usuario> consultar() {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM usuarios";
        conn = new Conexion();
        try {
            Statement st = conn.getCon().createStatement();
            ResultSet rS = st.executeQuery(sql);
            while(rS.next()){
                String doc = rS.getString("documento");
                int ss = rS.getInt("seguridad_social");
                String nomb = rS.getString("nombre");
                String apell = rS.getString("apellido");
                Usuario usuario = new Usuario(doc, ss, nomb, apell);
                usuarios.add(usuario);
            }
            st.close();
            rS.close();
        } catch (SQLException ex) {
            Mensaje.mensajeError("Error", ex.getMessage());
        }
        return usuarios;
    }

    @Override
    public int guardar(Usuario usuario) {
        int resultado = 0;
        conn = new Conexion();
        String sql = "INSERT INTO usuarios "
                + "(documento,seguridad_social,nombre,apellido) " +
                "VALUES (?,?,?,?)";
        try {
            pStm = conn.getCon().prepareStatement(sql);
            pStm.setString(1, usuario.getDocumento());
            pStm.setInt(2, usuario.getSeguridadSocial());
            pStm.setString(3, usuario.getNombre());
            pStm.setString(4, usuario.getApellido());
            resultado = pStm.executeUpdate();
        } catch (SQLException ex) {
            Mensaje.mensajeError("Error", ex.getMessage());
        }
        return resultado;
    }

    @Override
    public boolean eliminarPorDocumento(String documento) {
         boolean resultado = false;
         conn = new Conexion();
         String sql = "DELETE FROM usuarios WHERE documento=?";         
        try {
            pStm = conn.getCon().prepareStatement(sql);
            pStm.setString(1, documento);
            pStm.executeUpdate();
            resultado = true;
        } catch (SQLException ex) {
            Mensaje.mensajeError("Error", ex.getMessage());
        }
         return resultado;
    }    
}
