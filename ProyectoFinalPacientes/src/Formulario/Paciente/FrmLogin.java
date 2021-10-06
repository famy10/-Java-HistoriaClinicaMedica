
package Formulario.Paciente;

import Validaciones.Vacio;
import Validaciones.Validacion;
import bd.LogicaBD;
import bd.LogicaLogueo;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class FrmLogin extends javax.swing.JFrame {
    //CONSTANTES PARA VALIDACION
    final int CONTRASENIA = -1;
    final int DOCUMENTO = 8;
    
    //CONSTANTES DE BASE DE DATOS
    final int CTE_LOGIN = 20;
    
    //VARIABLES
    private String contrasenia;  
    private char[] arrayC ;
    
    //OBJETOS DE MI PACKAGE
    Vacio vacio = new Vacio();
    LogicaLogueo logicaLogueo = new LogicaLogueo();
    LogicaBD logica = new LogicaBD();
    
    public FrmLogin() {
        initComponents();
        DatosComunes();
        ConfiguracionElementos();
    }
   
     private void DatosComunes() {
        this.setLocationRelativeTo(null);
        this.setTitle("Login");
        this.setResizable(false);
    }
    
    private void ConfiguracionElementos() {
        //this.LbOlvidar.
        LbOlvidar = new javax.swing.JLabel("Underlined LbOlvidar");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JpPpal = new javax.swing.JPanel();
        JpBotones = new javax.swing.JPanel();
        LbOlvidar = new javax.swing.JLabel();
        BtnRegistrarPaciente = new javax.swing.JButton();
        BtnIniciarPaciente = new javax.swing.JButton();
        JpTitulo = new javax.swing.JPanel();
        LbTitulo = new javax.swing.JLabel();
        JpDatos = new javax.swing.JPanel();
        LbPass = new javax.swing.JLabel();
        LbDoc = new javax.swing.JLabel();
        TxtDoc = new javax.swing.JTextField();
        JPfPass = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 102, 102));

        JpPpal.setBackground(new java.awt.Color(240, 230, 155));

        JpBotones.setBackground(new java.awt.Color(227, 247, 174));
        JpBotones.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        LbOlvidar.setBackground(java.awt.Color.white);
        LbOlvidar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        LbOlvidar.setForeground(java.awt.Color.blue);
        LbOlvidar.setText("¿Olvidaste tu contraseña?");
        LbOlvidar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LbOlvidar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LbOlvidarMouseClicked(evt);
            }
        });

        BtnRegistrarPaciente.setText("REGISTRAR");
        BtnRegistrarPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRegistrarPacienteActionPerformed(evt);
            }
        });

        BtnIniciarPaciente.setText("INICIAR");
        BtnIniciarPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnIniciarPacienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JpBotonesLayout = new javax.swing.GroupLayout(JpBotones);
        JpBotones.setLayout(JpBotonesLayout);
        JpBotonesLayout.setHorizontalGroup(
            JpBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpBotonesLayout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(LbOlvidar)
                .addContainerGap(143, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpBotonesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BtnRegistrarPaciente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BtnIniciarPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        JpBotonesLayout.setVerticalGroup(
            JpBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpBotonesLayout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(JpBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnRegistrarPaciente)
                    .addComponent(BtnIniciarPaciente))
                .addGap(36, 36, 36)
                .addComponent(LbOlvidar))
        );

        JpTitulo.setBackground(new java.awt.Color(240, 230, 155));

        LbTitulo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        LbTitulo.setForeground(new java.awt.Color(255, 0, 0));
        LbTitulo.setText("INICIAR");

        javax.swing.GroupLayout JpTituloLayout = new javax.swing.GroupLayout(JpTitulo);
        JpTitulo.setLayout(JpTituloLayout);
        JpTituloLayout.setHorizontalGroup(
            JpTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpTituloLayout.createSequentialGroup()
                .addGap(161, 161, 161)
                .addComponent(LbTitulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        JpTituloLayout.setVerticalGroup(
            JpTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LbTitulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        LbPass.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        LbPass.setText("Contraseña");

        LbDoc.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        LbDoc.setText("Número de documento");

        TxtDoc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TxtDoc.setText("345");
        TxtDoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtDocActionPerformed(evt);
            }
        });
        TxtDoc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TxtDocKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtDocKeyTyped(evt);
            }
        });

        JPfPass.setText("pe");

        javax.swing.GroupLayout JpDatosLayout = new javax.swing.GroupLayout(JpDatos);
        JpDatos.setLayout(JpDatosLayout);
        JpDatosLayout.setHorizontalGroup(
            JpDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpDatosLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(JpDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(LbPass)
                    .addComponent(LbDoc))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(JpDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TxtDoc, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                    .addComponent(JPfPass))
                .addContainerGap())
        );
        JpDatosLayout.setVerticalGroup(
            JpDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpDatosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(JpDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TxtDoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LbDoc))
                .addGap(18, 18, 18)
                .addGroup(JpDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LbPass)
                    .addComponent(JPfPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout JpPpalLayout = new javax.swing.GroupLayout(JpPpal);
        JpPpal.setLayout(JpPpalLayout);
        JpPpalLayout.setHorizontalGroup(
            JpPpalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JpTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(JpPpalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JpPpalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JpDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JpBotones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        JpPpalLayout.setVerticalGroup(
            JpPpalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpPpalLayout.createSequentialGroup()
                .addComponent(JpTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JpDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JpBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
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
    
    private void TxtDocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtDocActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtDocActionPerformed

     private java.sql.Date ConvertirASql(java.util.Date FechaDelFormulario)  
   {

	java.sql.Date SqlFechaConvertida = new java.sql.Date(FechaDelFormulario.getTime()); 
        return SqlFechaConvertida;
      }
    private void BtnRegistrarPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRegistrarPacienteActionPerformed
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
         Date fecha;
        try {
            fecha = formato.parse("2020-10-10");
             java.sql.Date sqlFecha2 = ConvertirASql(fecha);
             FrmRegistrar registrar = new FrmRegistrar(0,0,0,"c","e",sqlFecha2);
             registrar.setVisible(true);
            this.dispose();
        } catch (ParseException ex) {
            Logger.getLogger(FrmLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
           
    }//GEN-LAST:event_BtnRegistrarPacienteActionPerformed

    private void BtnIniciarPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnIniciarPacienteActionPerformed
        
        arrayC = this.JPfPass.getPassword();
        contrasenia = new String(arrayC);
        if (!vacio.loginVacio(this.TxtDoc.getText(),contrasenia)) {
           vacio.informar();
        }
        else {
             if(logicaLogueo.autenticacionPaciente(Integer.parseInt(this.TxtDoc.getText()),contrasenia)) {                
                 FrmHistoriaClinica historia = new FrmHistoriaClinica(Integer.parseInt(this.TxtDoc.getText()));
                historia.setVisible(true);
                this.dispose();
            }
        }
        
        
    }//GEN-LAST:event_BtnIniciarPacienteActionPerformed

    private void LbOlvidarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LbOlvidarMouseClicked
        // TODO add your handling code here:
        //DOCUMENTO = 8
        if (!vacio.vacio_1(this.TxtDoc.getText(),DOCUMENTO)) {
           vacio.informar();
        }
        else {
           if (logica.buscarDni(Integer.parseInt(this.TxtDoc.getText()),1)==0) {
                 FrmRecuperarContrasenia form_rc = new FrmRecuperarContrasenia(Integer.parseInt(this.TxtDoc.getText()));
                form_rc.setVisible(true);
            }
        }
    }//GEN-LAST:event_LbOlvidarMouseClicked

    private void TxtDocKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtDocKeyPressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_TxtDocKeyPressed

    private void TxtDocKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtDocKeyTyped
        // TODO add your handling code here:
        Validacion validacion = new Validacion();
        validacion.validarSoloNumero(evt,DOCUMENTO);
    }//GEN-LAST:event_TxtDocKeyTyped
    
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnIniciarPaciente;
    private javax.swing.JButton BtnRegistrarPaciente;
    private javax.swing.JPasswordField JPfPass;
    private javax.swing.JPanel JpBotones;
    private javax.swing.JPanel JpDatos;
    private javax.swing.JPanel JpPpal;
    private javax.swing.JPanel JpTitulo;
    private javax.swing.JLabel LbDoc;
    private javax.swing.JLabel LbOlvidar;
    private javax.swing.JLabel LbPass;
    private javax.swing.JLabel LbTitulo;
    private javax.swing.JTextField TxtDoc;
    // End of variables declaration//GEN-END:variables
}
