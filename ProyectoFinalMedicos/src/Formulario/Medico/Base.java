
package Formulario.Medico;

public class Base extends javax.swing.JFrame {
    
    public Base() {
        initComponents();
        DatosComunes();
        ConfiguracionElementos();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JpPpal = new javax.swing.JPanel();
        JpBotones = new javax.swing.JPanel();
        JpTitulo = new javax.swing.JPanel();
        LbTitulo = new javax.swing.JLabel();
        JpDatos = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 102, 102));

        JpPpal.setBackground(new java.awt.Color(240, 230, 155));

        JpBotones.setBackground(new java.awt.Color(227, 247, 174));
        JpBotones.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout JpBotonesLayout = new javax.swing.GroupLayout(JpBotones);
        JpBotones.setLayout(JpBotonesLayout);
        JpBotonesLayout.setHorizontalGroup(
            JpBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 368, Short.MAX_VALUE)
        );
        JpBotonesLayout.setVerticalGroup(
            JpBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 126, Short.MAX_VALUE)
        );

        JpTitulo.setBackground(new java.awt.Color(240, 230, 155));

        LbTitulo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        LbTitulo.setForeground(new java.awt.Color(255, 0, 0));
        LbTitulo.setText("TITULO");

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

        JpDatos.setBackground(new java.awt.Color(227, 247, 174));
        JpDatos.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Tamaño 18");

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout JpDatosLayout = new javax.swing.GroupLayout(JpDatos);
        JpDatos.setLayout(JpDatosLayout);
        JpDatosLayout.setHorizontalGroup(
            JpDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(94, 94, 94)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        JpDatosLayout.setVerticalGroup(
            JpDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpDatosLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(JpDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout JpPpalLayout = new javax.swing.GroupLayout(JpPpal);
        JpPpal.setLayout(JpPpalLayout);
        JpPpalLayout.setHorizontalGroup(
            JpPpalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JpTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(JpPpalLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(JpPpalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JpBotones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JpDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        JpPpalLayout.setVerticalGroup(
            JpPpalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpPpalLayout.createSequentialGroup()
                .addComponent(JpTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JpDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JpBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
    
    private void DatosComunes() {
        this.setLocationRelativeTo(null);
        this.setTitle("TITULO");
        this.setResizable(false);
    }
    
    private void ConfiguracionElementos() {
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JpBotones;
    private javax.swing.JPanel JpDatos;
    private javax.swing.JPanel JpPpal;
    private javax.swing.JPanel JpTitulo;
    private javax.swing.JLabel LbTitulo;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
