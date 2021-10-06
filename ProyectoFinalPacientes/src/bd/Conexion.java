package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class Conexion {
  private final String bdd= "jdbc:mysql://Localhost/sistema_v2";
   private final String usu="root";
   private final String clave="";
    private final String driver = "com.mysql.jdbc.Driver";
    Connection con;

    public Conexion() {
        con = null;
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(bdd, usu, clave);           

        } catch (Exception ex) {
                    System.out.println("Error al registrar el Driver de Mysql");
                    JOptionPane.showMessageDialog(null,"Error al registrar el Driver de Mysql");
                }     
    }

    public Connection conectar() {
        return con;
    }

    public void desconectar() {

    }

}
