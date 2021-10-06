
package Formulario.Paciente;

import bd.LogicaBD;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

public class FrmHistoriaClinica extends javax.swing.JFrame {
    
   
    
    DefaultTableModel ModeloTabla;
    javax.swing.JLabel LbEspecialidad;
    javax.swing.JButton BtnVer;
    
    LogicaBD logica = new LogicaBD();
    TablaEspecialidad te = new TablaEspecialidad();
    private int dniPaciente;
    
    public FrmHistoriaClinica(int doc) {
        initComponents();
        dniPaciente=doc;
        DatosComunes();
       
        ConfiguracionElementos();
        
    }
    
//    public DefaultTableModel Datos() {
//        LbEspecialidad = new javax.swing.JLabel();
//        BtnVer = new javax.swing.JButton();
//        return DefaultTableModel;
//    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JpPpal = new javax.swing.JPanel();
        JpTitulo = new javax.swing.JPanel();
        LbTitulo = new javax.swing.JLabel();
        JpDatosPersonales = new javax.swing.JPanel();
        TextApellido = new javax.swing.JTextField();
        TxtNombre = new javax.swing.JTextField();
        TxtSexo = new javax.swing.JTextField();
        TxtTelefono = new javax.swing.JTextField();
        TxtCelular = new javax.swing.JTextField();
        TxtLegajo = new javax.swing.JTextField();
        TxtDni = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        SpHistoriaClinica = new javax.swing.JScrollPane();
        JtHistoria = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 102, 102));

        JpPpal.setBackground(new java.awt.Color(240, 230, 155));

        JpTitulo.setBackground(new java.awt.Color(240, 230, 155));

        LbTitulo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        LbTitulo.setForeground(new java.awt.Color(255, 0, 0));
        LbTitulo.setText("HISTORIA CLÍNICA");

        javax.swing.GroupLayout JpTituloLayout = new javax.swing.GroupLayout(JpTitulo);
        JpTitulo.setLayout(JpTituloLayout);
        JpTituloLayout.setHorizontalGroup(
            JpTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpTituloLayout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(LbTitulo)
                .addContainerGap(97, Short.MAX_VALUE))
        );
        JpTituloLayout.setVerticalGroup(
            JpTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LbTitulo, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        TxtCelular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtCelularActionPerformed(evt);
            }
        });

        TxtDni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtDniActionPerformed(evt);
            }
        });

        jTextField1.setForeground(java.awt.Color.blue);
        jTextField1.setText("Datos Personales");
        jTextField1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTextField1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout JpDatosPersonalesLayout = new javax.swing.GroupLayout(JpDatosPersonales);
        JpDatosPersonales.setLayout(JpDatosPersonalesLayout);
        JpDatosPersonalesLayout.setHorizontalGroup(
            JpDatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpDatosPersonalesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JpDatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(JpDatosPersonalesLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(JpDatosPersonalesLayout.createSequentialGroup()
                        .addGroup(JpDatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TextApellido, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(TxtNombre))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TxtSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(JpDatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpDatosPersonalesLayout.createSequentialGroup()
                                .addComponent(TxtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TxtDni, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpDatosPersonalesLayout.createSequentialGroup()
                                .addComponent(TxtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TxtLegajo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        JpDatosPersonalesLayout.setVerticalGroup(
            JpDatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpDatosPersonalesLayout.createSequentialGroup()
                .addGroup(JpDatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JpDatosPersonalesLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(TxtSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(JpDatosPersonalesLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(JpDatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(JpDatosPersonalesLayout.createSequentialGroup()
                                .addComponent(TextApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(JpDatosPersonalesLayout.createSequentialGroup()
                                .addGroup(JpDatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(TxtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TxtLegajo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(JpDatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(TxtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TxtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        JtHistoria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "", "", ""
            }
        ));
        JtHistoria.setRowHeight(35);
        JtHistoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JtHistoriaMouseClicked(evt);
            }
        });
        SpHistoriaClinica.setViewportView(JtHistoria);

        javax.swing.GroupLayout JpPpalLayout = new javax.swing.GroupLayout(JpPpal);
        JpPpal.setLayout(JpPpalLayout);
        JpPpalLayout.setHorizontalGroup(
            JpPpalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JpTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(JpDatosPersonales, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(SpHistoriaClinica, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        JpPpalLayout.setVerticalGroup(
            JpPpalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpPpalLayout.createSequentialGroup()
                .addComponent(JpDatosPersonales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JpTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(SpHistoriaClinica, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JpPpal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JpPpal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TxtDniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtDniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtDniActionPerformed

    private void TxtCelularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtCelularActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtCelularActionPerformed

    private void JtHistoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JtHistoriaMouseClicked
        int column = JtHistoria.getColumnModel().getColumnIndexAtX(evt.getX()); //posicion X donde hago clic
        int row = evt.getY()/JtHistoria.getRowHeight(); //posicion Y donde hago clic
        
        if (row < JtHistoria.getRowCount() && row >= 0 && column < JtHistoria.getColumnCount() && column >= 0) {
            Object value = JtHistoria.getValueAt(row, column); //obtiene coordenada X , Y
            if (value instanceof JButton) {  //si la coordenada es un boton
                ((JButton)value).doClick(); //si hace clic en dicho boton
                JButton boton = (JButton) value; //devielvo el boton donde hice clic
                
               int filita = JtHistoria.getSelectedRow();
               String especialidad = JtHistoria.getValueAt(filita, 0).toString();
               
                //System.out.println("especialidad: " + especialidad);
               
//                FrmLogin f = new FrmLogin();
//                f.setVisible(true);
                FrmConsultarEnfermedades esp = new FrmConsultarEnfermedades(dniPaciente, logica.getLegajo(), especialidad);
                esp.setVisible(true);
               this.dispose();
//               ConsultarEnfermedad c = new ConsultarEnfermedad(dniMedico, logica.getLegajo(),dniPaciente, enfermedad, logica.getApyn(), sqlFecha);
//                c.setVisible(true);
                
            }
        }
    }//GEN-LAST:event_JtHistoriaMouseClicked
     private java.sql.Date ConvertirASql(java.util.Date FechaDelFormulario)  
   {

	java.sql.Date SqlFechaConvertida = new java.sql.Date(FechaDelFormulario.getTime()); 
        return SqlFechaConvertida;
      }
    private void jTextField1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField1MouseClicked
         final int formularioHistoriaClinica = 500;
         SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
          Date fecha;
        try {
            fecha = formato.parse("2020-10-10");
            java.sql.Date sqlFecha2 = ConvertirASql(fecha);
        FrmRegistrar reg = new FrmRegistrar(formularioHistoriaClinica, dniPaciente, 0, "c", "e", sqlFecha2);
        reg.setVisible(true);
        this.dispose();
        } catch (ParseException ex) {
            Logger.getLogger(FrmHistoriaClinica.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }//GEN-LAST:event_jTextField1MouseClicked
    
    private void CargarCabecera() {
        this.TextApellido.setText(logica.getApellido());
        this.TxtNombre.setText(logica.getNombre());
        if (logica.getSexo()=='F') {
            this.TxtSexo.setText("Femenino");
        }
        else {
             this.TxtSexo.setText("Masculino");
        }
        this.TxtCelular.setText(String.valueOf(logica.getCelular()));
        this.TxtTelefono.setText(String.valueOf(logica.getTelefono()));
        if (logica.getCelular()==0) {
            this.TxtCelular.setVisible(false);
        }
        if (logica.getTelefono()==0) {
            this.TxtTelefono.setVisible(false);
        }
        this.TxtLegajo.setText(String.valueOf(logica.getLegajo()));
        this.TxtDni.setText(String.valueOf(logica.getDni()));
    }
    
    private void DatosComunes() {
        this.setLocationRelativeTo(null);
        this.setTitle("Historia Clínica");        
        if (logica.ConsultarPaciente(dniPaciente)) {
            CargarCabecera();
            //System.out.println(logica.getLegajo());
            te.ver_tabla(JtHistoria, logica.getLegajo());
        }
       // if (logica.buscarLegajo(dni)) {
            
      //  }
        this.setResizable(false);
    }
    
    private void ConfiguracionElementos() {
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JpDatosPersonales;
    private javax.swing.JPanel JpPpal;
    private javax.swing.JPanel JpTitulo;
    private javax.swing.JTable JtHistoria;
    private javax.swing.JLabel LbTitulo;
    private javax.swing.JScrollPane SpHistoriaClinica;
    private javax.swing.JTextField TextApellido;
    private javax.swing.JTextField TxtCelular;
    private javax.swing.JTextField TxtDni;
    private javax.swing.JTextField TxtLegajo;
    private javax.swing.JTextField TxtNombre;
    private javax.swing.JTextField TxtSexo;
    private javax.swing.JTextField TxtTelefono;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
