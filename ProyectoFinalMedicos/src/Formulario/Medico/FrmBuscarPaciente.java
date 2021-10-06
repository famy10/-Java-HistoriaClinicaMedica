
package Formulario.Medico;

import Validaciones.Validacion;
import bd.LogicaBD;
import bd.LogicaLogueo;
import javax.swing.JOptionPane;

public class FrmBuscarPaciente extends javax.swing.JFrame {
    //CONSTANTERS
    final int DOCUMENTO = 8;
    final int LEGAJO = 6;
    
    //CONSTANTES DE BASE DE DATOS
    final int CTE_LOGIN = 20;
    
    Validacion validacion = new Validacion(); 
    LogicaLogueo logicaLogueo = new LogicaLogueo();
    LogicaBD logica = new LogicaBD();
    
    private int dni;
    public FrmBuscarPaciente(int nro) {
        initComponents();
        dni=nro;
        DatosComunes();
        ConfiguracionElementos();
        
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JpPpal = new javax.swing.JPanel();
        JpBotones = new javax.swing.JPanel();
        BtnBuscar = new javax.swing.JButton();
        JpTitulo = new javax.swing.JPanel();
        LbTitulo = new javax.swing.JLabel();
        JpDatos = new javax.swing.JPanel();
        TxtDni = new javax.swing.JTextField();
        LbDni = new javax.swing.JLabel();
        JpSaludo = new javax.swing.JPanel();
        LbSaludo = new javax.swing.JLabel();
        LbEspecialidad = new javax.swing.JLabel();
        LbCerrarSesion = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 102, 102));

        JpPpal.setBackground(new java.awt.Color(240, 230, 155));

        JpBotones.setBackground(new java.awt.Color(227, 247, 174));
        JpBotones.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        BtnBuscar.setText("BUSCAR");
        BtnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JpBotonesLayout = new javax.swing.GroupLayout(JpBotones);
        JpBotones.setLayout(JpBotonesLayout);
        JpBotonesLayout.setHorizontalGroup(
            JpBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpBotonesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BtnBuscar)
                .addGap(139, 139, 139))
        );
        JpBotonesLayout.setVerticalGroup(
            JpBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpBotonesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BtnBuscar)
                .addContainerGap())
        );

        JpTitulo.setBackground(new java.awt.Color(240, 230, 155));

        LbTitulo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        LbTitulo.setForeground(new java.awt.Color(255, 0, 0));
        LbTitulo.setText("BUSCAR PACIENTE");

        javax.swing.GroupLayout JpTituloLayout = new javax.swing.GroupLayout(JpTitulo);
        JpTitulo.setLayout(JpTituloLayout);
        JpTituloLayout.setHorizontalGroup(
            JpTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpTituloLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LbTitulo)
                .addGap(73, 73, 73))
        );
        JpTituloLayout.setVerticalGroup(
            JpTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpTituloLayout.createSequentialGroup()
                .addComponent(LbTitulo)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        JpDatos.setBackground(new java.awt.Color(227, 247, 174));
        JpDatos.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        TxtDni.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TxtDni.setText("345");
        TxtDni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtDniKeyTyped(evt);
            }
        });

        LbDni.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        LbDni.setText("DNI");

        javax.swing.GroupLayout JpDatosLayout = new javax.swing.GroupLayout(JpDatos);
        JpDatos.setLayout(JpDatosLayout);
        JpDatosLayout.setHorizontalGroup(
            JpDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LbDni)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 121, Short.MAX_VALUE)
                .addComponent(TxtDni, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(133, 133, 133))
        );
        JpDatosLayout.setVerticalGroup(
            JpDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpDatosLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(JpDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LbDni)
                    .addComponent(TxtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        JpSaludo.setBackground(new java.awt.Color(240, 230, 155));

        javax.swing.GroupLayout JpSaludoLayout = new javax.swing.GroupLayout(JpSaludo);
        JpSaludo.setLayout(JpSaludoLayout);
        JpSaludoLayout.setHorizontalGroup(
            JpSaludoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpSaludoLayout.createSequentialGroup()
                .addComponent(LbSaludo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(LbEspecialidad, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                .addContainerGap())
        );
        JpSaludoLayout.setVerticalGroup(
            JpSaludoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpSaludoLayout.createSequentialGroup()
                .addGroup(JpSaludoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(LbEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LbSaludo, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        LbCerrarSesion.setForeground(java.awt.Color.blue);
        LbCerrarSesion.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        LbCerrarSesion.setText("Cerrar sesión");
        LbCerrarSesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LbCerrarSesionMouseClicked(evt);
            }
        });
        LbCerrarSesion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                LbCerrarSesionKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout JpPpalLayout = new javax.swing.GroupLayout(JpPpal);
        JpPpal.setLayout(JpPpalLayout);
        JpPpalLayout.setHorizontalGroup(
            JpPpalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpPpalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JpPpalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JpTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(JpPpalLayout.createSequentialGroup()
                        .addComponent(JpSaludo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(46, 46, 46)
                        .addComponent(LbCerrarSesion)
                        .addGap(20, 20, 20))
                    .addComponent(JpDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JpBotones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        JpPpalLayout.setVerticalGroup(
            JpPpalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpPpalLayout.createSequentialGroup()
                .addGroup(JpPpalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(JpPpalLayout.createSequentialGroup()
                        .addComponent(LbCerrarSesion)
                        .addGap(20, 20, 20))
                    .addComponent(JpSaludo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JpTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(JpDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JpBotones, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void BtnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBuscarActionPerformed
        if (this.TxtDni.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese dni");
        }
        else {
           
            if (logica.buscarDni(Integer.parseInt(this.TxtDni.getText()), 1)==0) {
                FrmConsultarFicha consultarFicha = new FrmConsultarFicha(dni,Integer.parseInt(this.TxtDni.getText()));
                consultarFicha.setVisible(true);
                this.dispose();
            }
            else {
                this.TxtDni.setText(null);
            }
                    
        }
        
    }//GEN-LAST:event_BtnBuscarActionPerformed

    private void LbCerrarSesionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_LbCerrarSesionKeyTyped
       
    }//GEN-LAST:event_LbCerrarSesionKeyTyped

    private void LbCerrarSesionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LbCerrarSesionMouseClicked
         FrmLogin login = new FrmLogin();
        this.dispose();
        login.setVisible(true);
    }//GEN-LAST:event_LbCerrarSesionMouseClicked

    private void TxtDniKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtDniKeyTyped
        validacion.validarSoloNumero(evt, DOCUMENTO);
    }//GEN-LAST:event_TxtDniKeyTyped
    
    private void DatosComunes() {
        this.setLocationRelativeTo(null);
        this.setTitle("Buscar Paciente");
        this.setResizable(false);
        //System.out.println("dni: " + logicaLogueo.getDni());
        if (logica.buscarNombre(dni)) {
            this.LbSaludo.setText("HOLA, " + logica.getNombre());
            this.LbEspecialidad.setText(logica.getEspecialidad());
        }
        else {
            this.LbSaludo.setText("HOLA");
        }
       
    }
    
    private void ConfiguracionElementos() {
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnBuscar;
    private javax.swing.JPanel JpBotones;
    private javax.swing.JPanel JpDatos;
    private javax.swing.JPanel JpPpal;
    private javax.swing.JPanel JpSaludo;
    private javax.swing.JPanel JpTitulo;
    private javax.swing.JLabel LbCerrarSesion;
    private javax.swing.JLabel LbDni;
    private javax.swing.JLabel LbEspecialidad;
    private javax.swing.JLabel LbSaludo;
    private javax.swing.JLabel LbTitulo;
    private javax.swing.JTextField TxtDni;
    // End of variables declaration//GEN-END:variables
}
