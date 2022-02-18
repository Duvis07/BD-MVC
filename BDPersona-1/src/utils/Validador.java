package utils;

import javax.swing.JTextField;

public interface Validador {
    
    public static boolean esNumero(String txt){
        try{
          Float.parseFloat(txt);  
        }catch(NumberFormatException ex){
            return false;
        }
        return true;
    }
    
    public static boolean validarNumero(JTextField campo){
        try{
            Float.parseFloat(campo.getText());
            return true;
        }catch(NumberFormatException ex){
            Mensaje.mensajeError("Error", "El campo: "+ campo.getName()
            + " no es numero");
            campo.grabFocus();
            return false;
        }
    }
    
    public static boolean estanVacios(JTextField [] campos){
        int i = 0;
        boolean vacio = false;
        while(i < campos.length && !vacio){
            vacio = (campos[i].getText()).isEmpty();
            if(vacio){
                Mensaje.mensajeInfo("Advertencia", "El campo "
                        + campos[i].getName() + " no debe ser vacio");
                campos[i].grabFocus();
            }
            i++;
        }
        return vacio;
    }
}
