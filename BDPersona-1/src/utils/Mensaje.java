package utils;

import javax.swing.JOptionPane;

public interface Mensaje {
    
    public static void mostrarMensaje(String titulo, 
            String mensaje, int tipo){
        JOptionPane.showMessageDialog(null, mensaje, 
                titulo,tipo);
    }
    
    public static void mensajeError(String titulo, String msg){
        mostrarMensaje(titulo, msg, JOptionPane.ERROR_MESSAGE);
    }
    
    public static void mensajeInfo(String titulo, String msg){
        mostrarMensaje(titulo, msg, JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static boolean mensajeConfirm(String titulo, String msg){
        JOptionPane jP = new JOptionPane();
        return jP.showConfirmDialog(null, msg, titulo, jP.YES_NO_OPTION) == jP.YES_OPTION;
    }
    
    public static void mensajeAdv(String titulo, String msj){
        mostrarMensaje(titulo, titulo, JOptionPane.WARNING_MESSAGE);
    }
}
