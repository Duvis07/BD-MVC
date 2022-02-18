package modelo;

public class Usuario {
    private String documento;
    private int seguridadSocial;
    private String nombre;
    private String apellido;

    public Usuario(String documento, int seguridadSocial, String nombre, String apellido) {
        this.documento = documento;
        this.seguridadSocial = seguridadSocial;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getDocumento() {
        return documento;
    }

    public int getSeguridadSocial() {
        return seguridadSocial;
    }

    public void setSeguridadSocial(int seguridadSocial) {
        this.seguridadSocial = seguridadSocial;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }    
}
