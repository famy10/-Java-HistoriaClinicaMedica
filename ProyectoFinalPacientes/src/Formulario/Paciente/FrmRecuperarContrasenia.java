
package Formulario.Paciente;

import Validaciones.Vacio;
import Validaciones.Validacion;
import bd.LogicaLogueo;
import javax.swing.JOptionPane;

public class FrmRecuperarContrasenia extends javax.swing.JFrame {
    //CONSTANTE
    final int RESPUESTA=200;
    final int COMBO_RESPUESTA_STRING = 100;
    final int COMBO_RESPUESTA_INT = -100;
    
    //CONSTANTES DE BASE DE DATOS
    final int CTE_LOGIN = 20;
    
    //VARIABLES
    private int dni;
    
    //OBJETOS DE MI PACKAGE
    private Vacio vacio = new Vacio();
    private LogicaLogueo logicaLogeo = new LogicaLogueo();
    private Validacion validacion = new Validacion();
    
    public FrmRecuperarContrasenia(int nro) {
        initComponents();
        DatosComunes();
        ConfiguracionElementos();
        dni=nro;
    }
    
    private void DatosComunes() {
        this.setLocationRelativeTo(null);
        this.setTitle("Recuperar contraseña");
        this.setResizable(false);
    }
    
    private void ConfiguracionElementos() {
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JpPpal = new javax.swing.JPanel();
        JpTitulo = new javax.swing.JPanel();
        LbTitulo = new javax.swing.JLabel();
        JpDatos = new javax.swing.JPanel();
        LbPregunta = new javax.swing.JLabel();
        LbRespuesta = new javax.swing.JLabel();
        CbPregunta = new javax.swing.JComboBox<>();
        TxtRespuesta = new javax.swing.JTextField();
        JpBotones = new javax.swing.JPanel();
        BtnVolver = new javax.swing.JButton();
        BtnConfirmar = new javax.swing.JButton();
        JpRecuperación = new javax.swing.JPanel();
        LbPass = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 102, 102));

        JpPpal.setBackground(new java.awt.Color(240, 230, 155));

        JpTitulo.setBackground(new java.awt.Color(240, 230, 155));

        LbTitulo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        LbTitulo.setForeground(new java.awt.Color(255, 0, 0));
        LbTitulo.setText("Proceso de recuperación de contraseña");

        javax.swing.GroupLayout JpTituloLayout = new javax.swing.GroupLayout(JpTitulo);
        JpTitulo.setLayout(JpTituloLayout);
        JpTituloLayout.setHorizontalGroup(
            JpTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpTituloLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(LbTitulo)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        JpTituloLayout.setVerticalGroup(
            JpTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LbTitulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        JpDatos.setBackground(new java.awt.Color(227, 247, 174));
        JpDatos.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        LbPregunta.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        LbPregunta.setText("Elija la pregunta registrada");

        LbRespuesta.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        LbRespuesta.setText("Respuesta");

        CbPregunta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "El apellido de soltera de tu madre.", "El nombre de tu primera mascota.", "¿En qué año empezaste el colegio primario?", "¿En qué ciudad naciste?" }));

        TxtRespuesta.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TxtRespuesta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtRespuestaKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout JpDatosLayout = new javax.swing.GroupLayout(JpDatos);
        JpDatos.setLayout(JpDatosLayout);
        JpDatosLayout.setHorizontalGroup(
            JpDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JpDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(LbRespuesta)
                    .addComponent(LbPregunta))
                .addGap(18, 18, 18)
                .addGroup(JpDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CbPregunta, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TxtRespuesta))
                .addContainerGap())
        );
        JpDatosLayout.setVerticalGroup(
            JpDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JpDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LbPregunta)
                    .addComponent(CbPregunta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(JpDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LbRespuesta)
                    .addComponent(TxtRespuesta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        JpBotones.setBackground(new java.awt.Color(227, 247, 174));
        JpBotones.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        BtnVolver.setText("VOLVER");
        BtnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnVolverActionPerformed(evt);
            }
        });

        BtnConfirmar.setText("CONFIRMAR");
        BtnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnConfirmarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JpBotonesLayout = new javax.swing.GroupLayout(JpBotones);
        JpBotones.setLayout(JpBotonesLayout);
        JpBotonesLayout.setHorizontalGroup(
            JpBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpBotonesLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(BtnConfirmar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BtnVolver)
                .addGap(31, 31, 31))
        );
        JpBotonesLayout.setVerticalGroup(
            JpBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpBotonesLayout.createSequentialGroup()
                .addGroup(JpBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnVolver)
                    .addComponent(BtnConfirmar))
                .addGap(0, 15, Short.MAX_VALUE))
        );

        JpRecuperación.setBackground(new java.awt.Color(227, 247, 174));
        JpRecuperación.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        LbPass.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jButton3.setText("INICIAR SESIÓN");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JpRecuperaciónLayout = new javax.swing.GroupLayout(JpRecuperación);
        JpRecuperación.setLayout(JpRecuperaciónLayout);
        JpRecuperaciónLayout.setHorizontalGroup(
            JpRecuperaciónLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpRecuperaciónLayout.createSequentialGroup()
                .addGroup(JpRecuperaciónLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JpRecuperaciónLayout.createSequentialGroup()
                        .addGap(161, 161, 161)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(JpRecuperaciónLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(LbPass, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        JpRecuperaciónLayout.setVerticalGroup(
            JpRecuperaciónLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpRecuperaciónLayout.createSequentialGroup()
                .addComponent(LbPass, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3))
        );

        javax.swing.GroupLayout JpPpalLayout = new javax.swing.GroupLayout(JpPpal);
        JpPpal.setLayout(JpPpalLayout);
        JpPpalLayout.setHorizontalGroup(
            JpPpalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JpTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(JpDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(JpPpalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JpPpalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JpBotones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JpRecuperación, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        JpPpalLayout.setVerticalGroup(
            JpPpalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpPpalLayout.createSequentialGroup()
                .addComponent(JpTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JpDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JpBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JpRecuperación, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
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

    private void BtnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnConfirmarActionPerformed
        //RESPUESTA=200
        if (!vacio.vacio_1(TxtRespuesta.getText(), RESPUESTA)) {
            vacio.informar();
        }
        else {
            if (!validacion.ValidarRespuestaComboBox(this.CbPregunta.getSelectedIndex(),this.TxtRespuesta.getText())) {
                validacion.informar();
                this.TxtRespuesta.setText(null);
            }
            else {
                int pregunta = this.CbPregunta.getSelectedIndex();
                String rta = this.TxtRespuesta.getText();        
                if (logicaLogeo.BuscarContraseniaPaciente(dni,pregunta,rta )) {
                   this.LbPass.setText("Su contraseña es: " + logicaLogeo.getRta());
                }
            }
        }        
    }//GEN-LAST:event_BtnConfirmarActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void BtnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnVolverActionPerformed
        // TODO add your handling code here:
        FrmLogin login = new FrmLogin();
        login.setVisible(true);
    }//GEN-LAST:event_BtnVolverActionPerformed

    private void TxtRespuestaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtRespuestaKeyTyped
        // TODO add your handling code here:
      
        if (this.CbPregunta.getSelectedIndex()==2) {
            validacion.validarSoloNumero(evt,COMBO_RESPUESTA_INT);
            validacion.validarTamanioMaximo(this.TxtRespuesta.getText(), 4, evt, COMBO_RESPUESTA_INT);
        }
        else {
            validacion.validarSoloLetras(evt, COMBO_RESPUESTA_STRING);
        }
    }//GEN-LAST:event_TxtRespuestaKeyTyped
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnConfirmar;
    private javax.swing.JButton BtnVolver;
    private javax.swing.JComboBox<String> CbPregunta;
    private javax.swing.JPanel JpBotones;
    private javax.swing.JPanel JpDatos;
    private javax.swing.JPanel JpPpal;
    private javax.swing.JPanel JpRecuperación;
    private javax.swing.JPanel JpTitulo;
    private javax.swing.JLabel LbPass;
    private javax.swing.JLabel LbPregunta;
    private javax.swing.JLabel LbRespuesta;
    private javax.swing.JLabel LbTitulo;
    private javax.swing.JTextField TxtRespuesta;
    private javax.swing.JButton jButton3;
    // End of variables declaration//GEN-END:variables
}
