package Validaciones;

import javax.swing.JOptionPane;

public class Vacio {
    private boolean cuadro_dialogo;
    String mensaje="\n";
    public boolean vacio_8(String doc, String pass, String pass2, String rta, String nom, String ape, String loc, String dire) {
        if (doc.isEmpty() || pass.isEmpty() || pass2.isEmpty() || rta.isEmpty() || nom.isEmpty() || ape.isEmpty() || loc.isEmpty() || dire.isEmpty()) {
            return false;
        }        
        return true;
    }
    
     public boolean vacio_10(String doc, String pass, String pass2, String rta, String nom, String ape, String loc, String dire, String matricula, String hora) {
        if (doc.isEmpty() || pass.isEmpty() || pass2.isEmpty() || rta.isEmpty() || nom.isEmpty() || ape.isEmpty() || loc.isEmpty() || dire.isEmpty() || matricula.isEmpty()) {
            return false;
        }        
        return true;
    }
     
    
//    public boolean DniVacio(String dni) {
//        if (dni.isEmpty()) {
//            return false;        
//        }
//        return true;
//    }
    
    public boolean vacio_1(String cad, int opcion) {
        if (cad.isEmpty()) {
            switch (opcion) {
                case 8:
                    cuadro_dialogo = true;
                    mensaje = mensaje + "Ingrese dni. \n";
                    break;
                case 200:
                    cuadro_dialogo = true;
                     mensaje = mensaje + "Campo incompleto: la respuesta es un requisito obligatorio para recuperar su contraseña. \n";
                    
                    break;
                default:
                    throw new AssertionError();
            }
            return false;        
        }
        return true;
    }
    
    public boolean loginVacio(String dni, String contrasenia){
        if (dni.isEmpty() || contrasenia.isEmpty()) {
            if (dni.isEmpty()) {
                cuadro_dialogo = true;
                mensaje = mensaje + "Ingrese dni. \n";
            }
            if (contrasenia.isEmpty()) {
                cuadro_dialogo = true;
                mensaje = mensaje + "Ingrese contraseña. \n";
            }
            return false;
        }
        return true;
    }
    
     public void informar() {
         if (cuadro_dialogo == true) {
             JOptionPane.showMessageDialog(null, mensaje);
             mensaje="";
             cuadro_dialogo = false;
         }
     }
}
