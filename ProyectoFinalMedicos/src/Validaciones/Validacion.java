
package Validaciones;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import javax.swing.JOptionPane;


public class Validacion {
    private boolean cuadro_dialogo;// = false;
    String mensaje="\n";
    String cad;

    public String getCad() {
        return cad;
    }

    public void setCad(String cad) {
        this.cad = cad;
    }
 
    
   
    
    public void validarSoloLetras(java.awt.event.KeyEvent evt, int opcion ) {
        char letra = evt.getKeyChar();
        int Bs = (int) evt.getKeyChar();
        
        if (!Character.isLetter(letra) && Bs != 32 && Bs != 8 && Bs != 127) {
            switch (opcion) {
                 case 100:
                     JOptionPane.showMessageDialog(null, "La respuesta debe tener sólo letras");
                     break;
                 case 1:
                     JOptionPane.showMessageDialog(null, "El nombre debe tener sólo letras");
                     break;
                 case 2:
                     JOptionPane.showMessageDialog(null, "El apellido debe tener sólo letras");
                     break;
                 default:
                     throw new AssertionError();
             }
            
            evt.consume();
        }
    }
    
     public void validoComboBox(java.awt.event.KeyEvent evt, javax.swing.JTextField texto) {
       char nro = evt.getKeyChar();
         if (Character.isDigit(nro)) {
             texto.setText(null);
             cad="null";
         }
    }
    
    public void validarSoloNumero(java.awt.event.KeyEvent evt, int opcion) {
        char nro = evt.getKeyChar();
        int Bs = (int) evt.getKeyChar();
        if (!Character.isDigit(nro) && Bs != 8 && Bs != 127) {
             switch (opcion) {
                 case 8:
                     JOptionPane.showMessageDialog(null, "El documento debe ser sólo números");
                     break;
                 case 6:
                     JOptionPane.showMessageDialog(null, "El legajo debe ser sólo números");
                     break;
                case -100:
                     JOptionPane.showMessageDialog(null, "La respuesta debe tener sólo números");
                     break;     
                case 3:
                     JOptionPane.showMessageDialog(null, "El teléfono debe tener sólo números");
                     break;
                case 4:
                     JOptionPane.showMessageDialog(null, "El celular debe tener sólo números");
                     break;
                case 24:
                     JOptionPane.showMessageDialog(null, "La hora debe tener sólo números");
                     break;
                case 60:
                     JOptionPane.showMessageDialog(null, "Los minutos deben tener sólo números");
                     break;     
                 default:
                     throw new AssertionError();
             }
            evt.consume();
        }        
    }
           
     public void validarLetrasyNumero(java.awt.event.KeyEvent evt, int opcion) {
        char nro = evt.getKeyChar();
        int Bs = (int) evt.getKeyChar();
        if (!Character.isDigit(nro) && !Character.isLetter(nro) && Bs != 8) {
            switch (opcion) {
                case -1:
                    JOptionPane.showMessageDialog(null, "La contraseña debe ser sólo caracteres alfanuméricos");
                    break;
                default:
                    throw new AssertionError();
            }
            
            evt.consume();
        }        
    }
     
     public void validarTamanioMaximo(String cad, int valor, java.awt.event.KeyEvent evt, int opcion) {
         if (cad.length() >= valor) {
             switch (opcion) {
                 case -100:
                     JOptionPane.showMessageDialog(null, "El año de la respuesta debe tener " + valor + " caracteres.");
                     break;
                 case -1:
                     JOptionPane.showMessageDialog(null, "La contraseña debe tener maximo " + valor + " caracteres.");
                     break;                 
                 case 1:
                     JOptionPane.showMessageDialog(null, "El nombre debe tener maximo " + valor + " caracteres.");
                     break;
                 case 2:
                     JOptionPane.showMessageDialog(null, "El apellido debe tener maximo " + valor + " caracteres.");
                     break;
                 case 3:
                     JOptionPane.showMessageDialog(null, "El teléfono debe tener maximo " + valor + " caracteres.");
                     break;
                 case 4:
                     JOptionPane.showMessageDialog(null, "El celular debe tener " + valor + " caracteres.");
                     break;
                 case 6:
                     JOptionPane.showMessageDialog(null, "El legajo deben tener maximo " + valor + " caracteres.");
                     break;    
                 case 8:
                     JOptionPane.showMessageDialog(null, "El dni deben tener maximo " + valor + " caracteres.");
                     break;
                 case 10:
                     JOptionPane.showMessageDialog(null, "La localidad deben tener maximo " + valor + " caracteres.");
                     break;    
                 case 11:
                     JOptionPane.showMessageDialog(null, "La dirección deben tener maximo " + valor + " caracteres.");
                     break;
                 case 24:
                     JOptionPane.showMessageDialog(null, "La hora debe tener maximo " + valor + " caracteres.");
                     break;
                 case 60:
                     JOptionPane.showMessageDialog(null, "Los minutos deben tener maximo " + valor + " caracteres.");
                     break;
                 case 100:
                     JOptionPane.showMessageDialog(null, "La respuesta debe tener maximo " + valor + " caracteres.");
                     break;    
                 default:
                     throw new AssertionError();
             }
             
             
             evt.consume();
         }            
    } 
     
    public void validarTamanioMinimo(String cad, int valor, java.awt.event.KeyEvent evt) {
         if (cad.length() < valor) {
             JOptionPane.showMessageDialog(null, "La contraseña debe tener minimo " + valor + " caracteres.");
             evt.consume();
         }            
    } 
     
     public boolean validarNroEntero(String cad) {
        if(!cad.matches("-?[0-9]+")) {
            JOptionPane.showMessageDialog(null, "Debe ingresar un número entero");
            return false;
         }              
         return true;
     } 
     
     public boolean validarNroReal(String cad) {
        if(!cad.matches("-?[0-9]+.[0-9]+")) {
            JOptionPane.showMessageDialog(null, "Debe ingresar un número real");
            return false;
         }              
         return true;
     }
     
     public boolean verificarTextoVacio(String cad) {
         return true;
     }
     
     public boolean ValidarRespuestaComboBox(int indice, String cad) {
        
         if (indice==2 &&  !cad.matches("[0-9]+")) {
             cuadro_dialogo = true; 
             mensaje = mensaje + "La respuesta debe ser numérica.\n";
             //JOptionPane.showMessageDialog(null, "La respuesta debe ser numérica.");
             return false;
         }
         if (indice!=2 &&  !cad.matches("[a-z|A-Z]+")) {
             cuadro_dialogo = true; 
             mensaje = mensaje +"Debe ingresar solo texto para la respuesta. \n";
             //JOptionPane.showMessageDialog(null, "Debe ingresar solo texto para la respuesta.");
             return false;
         }
         return true;
     }
     
     public boolean validarTamanioMinimo(String cad, int valor,int opcion) {
         if (cad.length() < valor) {
             switch (opcion) {
                 case -1:
                     cuadro_dialogo = true; 
                     mensaje = mensaje +"La contraseña debe tener minimo " + valor + " caracteres. \n";
                     break;
                 case -100:
                     cuadro_dialogo = true; 
                     mensaje = mensaje +"El año es un campo numerico de 4 dígitos. \n";
                     break;
                 case 8:
                      cuadro_dialogo = true; 
                     mensaje = mensaje +"El dni debe tener 8 caracteres. \n";
                     break;
                 default:
                     throw new AssertionError();
             }             
             return false;            
         }            
         return true;
    } 
//     public boolean ValidarEspecialidad(int nro) {
//         if (nro==0) {
//             return false;
//         }
//         return true;
//     }
     
     public boolean ValidarEspecialidad(int nro){
         if (nro==0) {
             cuadro_dialogo = true; 
             mensaje = mensaje + "Debe seleccionar al menos una especialidad. \n";
             //JOptionPane.showMessageDialog(null, "Debe seleccionar una especialidad.");
             return false;
         }         
         return true;
     }
     
     public boolean ValidarDias(boolean lunes, boolean martes, boolean miercoles, boolean jueves, boolean viernes, boolean sabado, boolean domingo) {
         if(!lunes && !martes && !miercoles && !jueves && !viernes && !sabado && !domingo) {
             return false;
         }
         return true;
     }
     
      
     
     public boolean ValidarEspecialidadYdias(int nro, boolean lunes, boolean martes, boolean miercoles, boolean jueves, boolean viernes, boolean sabado, boolean domingo){
         if (!ValidarEspecialidad(nro)) {
             cuadro_dialogo = true; 
             mensaje = mensaje + "Debe seleccionar al menos una especialidad. \n";
             //JOptionPane.showMessageDialog(null, "Debe seleccionar una especialidad.");
         }
         
         if (!ValidarDias(lunes, martes, miercoles, jueves, viernes, sabado, domingo)) {
             cuadro_dialogo = true;
             mensaje = mensaje + "Debe seleccionar el/los días de que trabaja. \n";
             //JOptionPane.showMessageDialog(null, "Debe seleccionar el/los días de que trabaja.");
         } 
         if (!ValidarEspecialidad(nro) || !ValidarDias(lunes, martes, miercoles, jueves, viernes, sabado, domingo)) {
             return false;
         }
         return true;
     }
     
    
     
     public boolean validarHora(int hora) {
         if (hora < 0 || hora > 23) {
             cuadro_dialogo = true;
             mensaje = mensaje + "La hora debe estar en el rango de 0 a 23 hs. \n";
             return false;
         }
         return true;
     }
     
     public boolean validarMinutos(int minutos) {
         if (minutos < 0 || minutos > 59) {
             cuadro_dialogo = true;
             mensaje = mensaje + "Los minutos debeb estar en el rango de 0 a 59. \n";
            return false;
         }
         return true;
     }
     
      public boolean validoFecha(com.toedter.calendar.JDateChooser JdcNacimiento) {
         if (JdcNacimiento.getDate()== null) {
             cuadro_dialogo = true;
             mensaje = mensaje + "El formato de la fecha NO es valido. \n";             
             return false;
         }
         return true;
     }
     
      public boolean CompararFechas(java.util.Date fechaSeleccionada) {
        
        
            
            LocalDate FechaActual = LocalDate.now();
            LocalDate fechaSlelecionada_2 = fechaSeleccionada.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            Period comparacion = Period.between(fechaSlelecionada_2, FechaActual);
            if (comparacion.getDays() < 0) {
                cuadro_dialogo = true;
                mensaje = mensaje + "La fecha de nacimiento es mayor a la fecha actua. Reingrese fecha. \n";  
                return false;
            }
        return true;
    } 
      
     public boolean validarPassword(String cad, String cad2) {
         if (!cad.equals(cad2)) {
             cuadro_dialogo = true;
             mensaje = mensaje + "Las contraseñas no coinciden. \n";
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
