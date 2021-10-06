

package bd;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class LogicaLogueo {
     Conexion con = new Conexion();
    private PreparedStatement ps; 
    private ResultSet rs; //pa CONSULTA
    private int registro;
    
    private String rta;
    private int dni;

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }
    public String getRta() {
        return rta;
    }

    public void setRta(String rta) {
        this.rta = rta;
    }
    
    public boolean BuscarDni(int dni) {
        String Str_sql="SELECT doc FROM medico where doc = '"+ dni +"';";
        try {
            ps = con.conectar().prepareStatement(Str_sql);
            rs = ps.executeQuery();
            if (rs.next()) {
               
                ps.close();
                return true;
            }
            else {
                JOptionPane.showMessageDialog(null, "El dni no se encuentra en nuestra base de datos. Intente nuevamente.");              
                return false;
            }
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al intentar verificar el dni ingresado");             
                return false;
        }
    }
    
    public boolean BuscarContrasenia(int dni, int pregunta, String respuesta) {
        String Str_sql = "SELECT contrasenia FROM medico where doc = '"+ dni +"'  and pregunta = '"+  pregunta +"' and respuesta = '"+  respuesta +"' ;";
        try {
            ps = con.conectar().prepareStatement(Str_sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                //this.setBdNroEspecialidad(rs.getInt(1));
                this.setRta(rs.getNString(1));
                ps.close();
                return true;
            }
            else {
                JOptionPane.showMessageDialog(null, "Respuesta incorrecta. Intente nuevamente");              
                return false;
            }
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al intentar recuperar contraseña");             
                return false;
        }
       
    }
    
     public boolean BuscarContraseniaPaciente(int dni, int pregunta, String respuesta) {
        String Str_sql = "SELECT contrasenia FROM paciente where doc = '"+ dni +"'  and pregunta = '"+  pregunta +"' and respuesta = '"+  respuesta +"' ;";
        try {
            ps = con.conectar().prepareStatement(Str_sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                //this.setBdNroEspecialidad(rs.getInt(1));
                this.setRta(rs.getNString(1));
                ps.close();
                return true;
            }
            else {
                JOptionPane.showMessageDialog(null, "Respuesta incorrecta. Intente nuevamente");              
                return false;
            }
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al intentar recuperar contraseña");             
                return false;
        }
       
    }
    
    public boolean autenticacion(int dni, String contrasenia) {
        String Str_sql="SELECT doc, contrasenia FROM medico where doc = '"+ dni +"'  and contrasenia = BINARY  '"+ contrasenia  +"';";
        try {
            ps = con.conectar().prepareStatement(Str_sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                
                this.setDni(rs.getInt(1));
                //System.out.println("dni desde el logueo: " + this.getDni());
                ps.close();
                return true;
            }
            else {
                JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrecta. Intente nuevamente");              
                return false;
            }
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al intentar conectarse con nuestra base de datos");             
                return false;
        }
    }
    
    public boolean autenticacionPaciente(int dni, String contrasenia) {
        String Str_sql="SELECT doc, contrasenia FROM paciente where doc = '"+ dni +"'  and contrasenia = BINARY  '"+ contrasenia  +"';";
        try {
            ps = con.conectar().prepareStatement(Str_sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                
                this.setDni(rs.getInt(1));
                //System.out.println("dni desde el logueo: " + this.getDni());
                ps.close();
                return true;
            }
            else {
                JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrecta. Intente nuevamente");              
                return false;
            }
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al intentar conectarse con nuestra base de datos");             
                return false;
        }
    }
}
