
package Formulario.Paciente;

import bd.Conexion;
import bd.LogicaBD;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class TablaEspecialidad {
    JButton BtnModificar = new JButton("CONSULTAR"); 
     
    DefaultTableModel objtabla;
    TableColumn columna;
    
    String [] TitCol = {"Especialidad" , "Consultar" , "Fecha de la visita" };
    String [][] Filas = { };
    Conexion con = new Conexion();
    private PreparedStatement ps; 
    private ResultSet rs; //pa CONSULTA
    private int registro;
    private String enfermedad;
    private String apyn;
    private int cantReg=0;
    
    private int legajo;
    private String especialidad;
    
     private int dniMedico;
   

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
   
    
     
    public void ver_tabla(JTable tabla,int leg) {
        legajo=leg;
       
        tabla.setDefaultRenderer(Object.class, new  Render());
        
        BtnModificar.setName("Consultar"); 
        
        tabla.setModel(Titulos());
        tabla.setModel(ConsultarHistoria(legajo));
        tabla.setRowHeight(30);
        tabla.getColumnModel().getColumn(0).setPreferredWidth(300);
        tabla.getColumnModel().getColumn(1).setPreferredWidth(200);
        tabla.getColumnModel().getColumn(2).setPreferredWidth(350);
        
           
    }
    //METODO TITULO********************************************************************
    public DefaultTableModel Titulos()//para colocar el titulo, es algo fijo
    {    
        objtabla = new DefaultTableModel(Filas, TitCol)
        {
            public boolean isCellEditable(int row, int column) {
                return false;
           }
        }   
        ;
        return objtabla;
    }
    //METODO Datos********************************************************************
   
    public DefaultTableModel ConsultarHistoria(int legajo ) {
       //System.out.println(legajo);
        String str_sql="SELECT Especilidad, feAtención FROM fichamedica where Paciente_legajo = '"+ legajo +"' group by Especilidad order by feAtención desc;";
         try {
            con = new Conexion();
            ps = con.conectar().prepareStatement(str_sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                //this.setIdEspecialidad(Integer.parseInt(rs.getString(1))); //int
                this.setEspecialidad(rs.getString(1));
                this.setFechaSql(java.sql.Date.valueOf(rs.getString(2)));
                //System.out.println(this.getEnfermedad());
                //System.out.println(this.getApyn());
                //System.out.println(this.getFechaSql());
                cantReg++;
         // new Object [][] {{"acne",BtnModificar,"pedro","30/10/1982"},{"acne",BtnModificar,"juan","30/10/1982"},{"acne",BtnModificar,"rosa","30/10/1982"},{"acne",BtnModificar,"maria","30/10/1982"}}, 
                Object [] fila={this.getEspecialidad(), BtnModificar, this.getFechaSql()};
                //Object [] fila={1,2,3,4 };
                objtabla.addRow(fila);
            }
             
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error con la base de datos al intentar buscar la especialidad. Intente mas tarde.");
        }
         return objtabla;
    }
    
   
    
    
     public String getEnfermedad() {
        return enfermedad;
    }

    public void setEnfermedad(String enfermedad) {
        this.enfermedad = enfermedad;
    }

    public String getApyn() {
        return apyn;
    }

    public void setApyn(String apyn) {
        this.apyn = apyn;
    }

    public Date getFechaSql() {
        return fechaSql;
    }

    public void setFechaSql(Date fechaSql) {
        this.fechaSql = fechaSql;
    }
    private java.sql.Date fechaSql;
    LogicaBD logica = new LogicaBD();
}
