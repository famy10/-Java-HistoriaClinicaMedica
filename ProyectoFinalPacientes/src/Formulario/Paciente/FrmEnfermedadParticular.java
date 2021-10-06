
package Formulario.Paciente;

import bd.LogicaBD;

public class FrmEnfermedadParticular extends javax.swing.JFrame {

    
    
    private int dniMedico;
    private int LegajoPaciente;
    private int dniPaciente;
    private String enfermedad;
    private String apyn;
    private java.sql.Date fechaSql;
    private String especialidad;
    
    LogicaBD logica = new LogicaBD();
    
    public FrmEnfermedadParticular(int leg, int nroPaciente, String enferme, java.sql.Date sqlfecha, String esp) {
        initComponents();
        
        LegajoPaciente=leg;
        dniPaciente=nroPaciente;
        this.enfermedad=enferme;
        especialidad = esp;
        this.fechaSql=sqlfecha;
       
        DatosComunes();
        ConfiguracionElementos();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GrupoAntecedentes = new javax.swing.ButtonGroup();
        JpPpal = new javax.swing.JPanel();
        JpTitulo = new javax.swing.JPanel();
        LbTitulo = new javax.swing.JLabel();
        LbCerrarSesion = new javax.swing.JLabel();
        LbSaludo = new javax.swing.JLabel();
        JpDatosPersonales = new javax.swing.JPanel();
        TextApellido = new javax.swing.JTextField();
        TxtNombre = new javax.swing.JTextField();
        TxtSexo = new javax.swing.JTextField();
        TxtTelefono = new javax.swing.JTextField();
        TxtCelular = new javax.swing.JTextField();
        TxtLegajo = new javax.swing.JTextField();
        TxtDni = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        JpBotonesSuperior = new javax.swing.JPanel();
        BtnAtras = new javax.swing.JButton();
        JpAntecedentes = new javax.swing.JPanel();
        LbAntecedentePaciente = new javax.swing.JLabel();
        JpAntecedentesFamiliares = new javax.swing.JPanel();
        LbAntecedenteFamiliar = new javax.swing.JLabel();
        RbNinguno = new javax.swing.JRadioButton();
        RbHereditario = new javax.swing.JRadioButton();
        RbAdquirido = new javax.swing.JRadioButton();
        TxtAntecedentePaciente = new javax.swing.JTextField();
        TxtAntecedenteFliar = new javax.swing.JTextField();
        JpMotivo = new javax.swing.JPanel();
        LbMotivo = new javax.swing.JLabel();
        LbSubjetivo = new javax.swing.JLabel();
        LbObjetivo = new javax.swing.JLabel();
        LbAnalisis = new javax.swing.JLabel();
        TxtSubjetivo = new javax.swing.JTextField();
        TxtObjetivo = new javax.swing.JTextField();
        TxtAnalisis = new javax.swing.JTextField();
        JpTratamiento = new javax.swing.JPanel();
        LbDiagnostico = new javax.swing.JLabel();
        LbTratamiento = new javax.swing.JLabel();
        TxtTratamiento = new javax.swing.JTextField();
        LbTratamientoNO = new javax.swing.JLabel();
        LbAlarma = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        TxtDiagnostico = new javax.swing.JTextField();
        TxtTratamientoNO = new javax.swing.JTextField();
        TxtAlarma = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 102, 102));

        JpPpal.setBackground(new java.awt.Color(240, 230, 155));

        JpTitulo.setBackground(new java.awt.Color(240, 230, 155));

        LbTitulo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        LbTitulo.setForeground(new java.awt.Color(255, 0, 0));
        LbTitulo.setText("FICHA MEDICA");

        LbCerrarSesion.setForeground(java.awt.Color.blue);
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

        javax.swing.GroupLayout JpTituloLayout = new javax.swing.GroupLayout(JpTitulo);
        JpTitulo.setLayout(JpTituloLayout);
        JpTituloLayout.setHorizontalGroup(
            JpTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LbSaludo, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LbTitulo)
                .addGap(343, 343, 343)
                .addComponent(LbCerrarSesion)
                .addContainerGap())
        );
        JpTituloLayout.setVerticalGroup(
            JpTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LbSaludo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(JpTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(LbTitulo)
                .addComponent(LbCerrarSesion, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
        );

        TextApellido.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        TxtNombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        TxtSexo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        TxtTelefono.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        TxtCelular.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TxtCelular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtCelularActionPerformed(evt);
            }
        });

        TxtLegajo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        TxtDni.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
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
            .addGroup(JpDatosPersonalesLayout.createSequentialGroup()
                .addContainerGap(182, Short.MAX_VALUE)
                .addGroup(JpDatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TextApellido)
                    .addComponent(TxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(TxtSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(JpDatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TxtTelefono, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(JpDatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TxtLegajo, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                    .addComponent(TxtDni))
                .addGap(80, 80, 80)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        JpDatosPersonalesLayout.setVerticalGroup(
            JpDatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpDatosPersonalesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JpDatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JpDatosPersonalesLayout.createSequentialGroup()
                        .addGroup(JpDatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TxtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtLegajo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(JpDatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TxtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpDatosPersonalesLayout.createSequentialGroup()
                        .addGap(0, 2, Short.MAX_VALUE)
                        .addGroup(JpDatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpDatosPersonalesLayout.createSequentialGroup()
                                .addComponent(TextApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpDatosPersonalesLayout.createSequentialGroup()
                                .addComponent(TxtSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28))
                            .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );

        BtnAtras.setText("ATRAS");
        BtnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAtrasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JpBotonesSuperiorLayout = new javax.swing.GroupLayout(JpBotonesSuperior);
        JpBotonesSuperior.setLayout(JpBotonesSuperiorLayout);
        JpBotonesSuperiorLayout.setHorizontalGroup(
            JpBotonesSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpBotonesSuperiorLayout.createSequentialGroup()
                .addGap(613, 613, 613)
                .addComponent(BtnAtras)
                .addContainerGap(435, Short.MAX_VALUE))
        );
        JpBotonesSuperiorLayout.setVerticalGroup(
            JpBotonesSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BtnAtras)
        );

        LbAntecedentePaciente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        LbAntecedentePaciente.setText("Antecedentes del paciente");

        JpAntecedentesFamiliares.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.gray, null));

        LbAntecedenteFamiliar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        LbAntecedenteFamiliar.setText("Antecedentes familiares:");

        GrupoAntecedentes.add(RbNinguno);
        RbNinguno.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        RbNinguno.setText("Ninguno");
        RbNinguno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RbNingunoActionPerformed(evt);
            }
        });

        GrupoAntecedentes.add(RbHereditario);
        RbHereditario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        RbHereditario.setText("Hereditario");
        RbHereditario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RbHereditarioActionPerformed(evt);
            }
        });

        GrupoAntecedentes.add(RbAdquirido);
        RbAdquirido.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        RbAdquirido.setText("Adquirido");
        RbAdquirido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RbAdquiridoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JpAntecedentesFamiliaresLayout = new javax.swing.GroupLayout(JpAntecedentesFamiliares);
        JpAntecedentesFamiliares.setLayout(JpAntecedentesFamiliaresLayout);
        JpAntecedentesFamiliaresLayout.setHorizontalGroup(
            JpAntecedentesFamiliaresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpAntecedentesFamiliaresLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JpAntecedentesFamiliaresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(RbAdquirido)
                    .addComponent(RbHereditario)
                    .addComponent(RbNinguno)
                    .addComponent(LbAntecedenteFamiliar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        JpAntecedentesFamiliaresLayout.setVerticalGroup(
            JpAntecedentesFamiliaresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpAntecedentesFamiliaresLayout.createSequentialGroup()
                .addComponent(LbAntecedenteFamiliar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RbNinguno)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RbHereditario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RbAdquirido)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout JpAntecedentesLayout = new javax.swing.GroupLayout(JpAntecedentes);
        JpAntecedentes.setLayout(JpAntecedentesLayout);
        JpAntecedentesLayout.setHorizontalGroup(
            JpAntecedentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpAntecedentesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JpAntecedentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JpAntecedentesLayout.createSequentialGroup()
                        .addComponent(LbAntecedentePaciente)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(TxtAntecedentePaciente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JpAntecedentesFamiliares, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TxtAntecedenteFliar, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        JpAntecedentesLayout.setVerticalGroup(
            JpAntecedentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpAntecedentesLayout.createSequentialGroup()
                .addGroup(JpAntecedentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JpAntecedentesLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(JpAntecedentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(JpAntecedentesLayout.createSequentialGroup()
                                .addComponent(LbAntecedentePaciente)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TxtAntecedentePaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(JpAntecedentesFamiliares, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(JpAntecedentesLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(TxtAntecedenteFliar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        LbMotivo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        LbMotivo.setForeground(java.awt.Color.red);
        LbMotivo.setText("Motivo de la consulta");

        LbSubjetivo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        LbSubjetivo.setText("Subjetiva");

        LbObjetivo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        LbObjetivo.setText("Objetiva");

        LbAnalisis.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        LbAnalisis.setText("Análisis");

        TxtAnalisis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtAnalisisActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JpMotivoLayout = new javax.swing.GroupLayout(JpMotivo);
        JpMotivo.setLayout(JpMotivoLayout);
        JpMotivoLayout.setHorizontalGroup(
            JpMotivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpMotivoLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(JpMotivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JpMotivoLayout.createSequentialGroup()
                        .addGap(389, 389, 389)
                        .addComponent(LbMotivo)
                        .addGap(140, 140, 140))
                    .addGroup(JpMotivoLayout.createSequentialGroup()
                        .addGroup(JpMotivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(JpMotivoLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(LbAnalisis))
                            .addComponent(LbObjetivo)
                            .addComponent(LbSubjetivo))
                        .addGap(81, 81, 81)
                        .addGroup(JpMotivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TxtSubjetivo)
                            .addComponent(TxtObjetivo)
                            .addComponent(TxtAnalisis))
                        .addGap(31, 31, 31))))
        );
        JpMotivoLayout.setVerticalGroup(
            JpMotivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpMotivoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LbMotivo)
                .addGap(18, 18, 18)
                .addGroup(JpMotivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LbSubjetivo)
                    .addComponent(TxtSubjetivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(JpMotivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LbObjetivo)
                    .addComponent(TxtObjetivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(JpMotivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LbAnalisis)
                    .addComponent(TxtAnalisis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        LbDiagnostico.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        LbDiagnostico.setText("Diagnóstico presuntivo");

        LbTratamiento.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        LbTratamiento.setText("Tratamiento farmacológico y dosis");

        TxtTratamiento.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        LbTratamientoNO.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        LbTratamientoNO.setText("Tratamiento no farmacológico");

        LbAlarma.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        LbAlarma.setText("Pauta de alarma");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(java.awt.Color.red);
        jLabel1.setText("Diagnóstico y tratamiento");

        javax.swing.GroupLayout JpTratamientoLayout = new javax.swing.GroupLayout(JpTratamiento);
        JpTratamiento.setLayout(JpTratamientoLayout);
        JpTratamientoLayout.setHorizontalGroup(
            JpTratamientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpTratamientoLayout.createSequentialGroup()
                .addGroup(JpTratamientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JpTratamientoLayout.createSequentialGroup()
                        .addGap(432, 432, 432)
                        .addComponent(jLabel1))
                    .addGroup(JpTratamientoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(JpTratamientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LbTratamiento)
                            .addComponent(LbTratamientoNO)
                            .addComponent(LbAlarma)
                            .addComponent(LbDiagnostico))
                        .addGap(18, 18, 18)
                        .addGroup(JpTratamientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TxtAlarma, javax.swing.GroupLayout.DEFAULT_SIZE, 816, Short.MAX_VALUE)
                            .addComponent(TxtTratamientoNO)
                            .addComponent(TxtTratamiento)
                            .addComponent(TxtDiagnostico))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        JpTratamientoLayout.setVerticalGroup(
            JpTratamientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpTratamientoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(JpTratamientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LbDiagnostico, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(TxtDiagnostico, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(JpTratamientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LbTratamiento)
                    .addComponent(TxtTratamiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(JpTratamientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LbTratamientoNO)
                    .addComponent(TxtTratamientoNO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(JpTratamientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(LbAlarma)
                    .addComponent(TxtAlarma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout JpPpalLayout = new javax.swing.GroupLayout(JpPpal);
        JpPpal.setLayout(JpPpalLayout);
        JpPpalLayout.setHorizontalGroup(
            JpPpalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JpTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(JpDatosPersonales, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(JpBotonesSuperior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(JpAntecedentes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(JpPpalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JpPpalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JpMotivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JpTratamiento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        JpPpalLayout.setVerticalGroup(
            JpPpalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpPpalLayout.createSequentialGroup()
                .addComponent(JpDatosPersonales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JpTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JpBotonesSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JpAntecedentes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(JpMotivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JpTratamiento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(75, 75, 75))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JpPpal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JpPpal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TxtDniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtDniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtDniActionPerformed

    private void TxtCelularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtCelularActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtCelularActionPerformed

    private void BtnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAtrasActionPerformed
        FrmConsultarEnfermedades consultarFicha = new FrmConsultarEnfermedades(dniPaciente,LegajoPaciente,especialidad);
        consultarFicha.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BtnAtrasActionPerformed

    private void RbNingunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RbNingunoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RbNingunoActionPerformed

    private void RbHereditarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RbHereditarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RbHereditarioActionPerformed

    private void RbAdquiridoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RbAdquiridoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RbAdquiridoActionPerformed

    private void TxtAnalisisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtAnalisisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtAnalisisActionPerformed

    private void LbCerrarSesionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LbCerrarSesionMouseClicked
        FrmLogin login = new FrmLogin();
        this.dispose();
        login.setVisible(true);
    }//GEN-LAST:event_LbCerrarSesionMouseClicked

    private void LbCerrarSesionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_LbCerrarSesionKeyTyped

    }//GEN-LAST:event_LbCerrarSesionKeyTyped

    private void jTextField1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField1MouseClicked
        final int formularioEnfermedadParticular = 502;         
        FrmRegistrar reg = new FrmRegistrar(formularioEnfermedadParticular, dniPaciente, LegajoPaciente,  especialidad, this.enfermedad, this.fechaSql);
        reg.setVisible(true);
        this.dispose();
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
        this.setTitle("Consulta");
        this.setResizable(false);
        if (logica.ConsultarPaciente(dniPaciente)) {
            CargarCabecera();
        }
         if (logica.buscarNombre(dniMedico)) {
            this.LbSaludo.setText("HOLA, " + logica.getNombre());
           
        }
        else {
            this.LbSaludo.setText("HOLA");
        }
         System.out.println("LegajoPaciente " + LegajoPaciente );
        System.out.println("enfermedad " + enfermedad);
        System.out.println("fechaSql " + fechaSql);
        if (logica.ConsultarEnfermedad(LegajoPaciente, enfermedad, fechaSql)) {
            this.TxtAntecedentePaciente.setText(logica.getDescripAntecPaciente());
            
            switch (logica.getAntecFliar()) {
                case 0: this.RbNinguno.setSelected(true); break;
                case 1: this.RbHereditario.setSelected(true); break;    
                case 2: this.RbAdquirido.setSelected(true); break;                    
                default:
                    throw new AssertionError();
            }
            
            this.TxtAntecedenteFliar.setText(logica.getDescripAntecFliar());
            
            this.TxtSubjetivo.setText(logica.getSubjetivo());
            this.TxtObjetivo.setText(logica.getObjetivo());
            this.TxtAnalisis.setText(logica.getAnalisis());
            
            this.TxtDiagnostico.setText(logica.getEnfermedad());
            this.TxtTratamiento.setText(logica.getTratamFarmac());
            this.TxtTratamientoNO.setText(logica.getTratamNOfarmac());
            this.TxtAlarma.setText(logica.getAlarma());
        }
    }
    
    private void ConfiguracionElementos() {
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAtras;
    private javax.swing.ButtonGroup GrupoAntecedentes;
    private javax.swing.JPanel JpAntecedentes;
    private javax.swing.JPanel JpAntecedentesFamiliares;
    private javax.swing.JPanel JpBotonesSuperior;
    private javax.swing.JPanel JpDatosPersonales;
    private javax.swing.JPanel JpMotivo;
    private javax.swing.JPanel JpPpal;
    private javax.swing.JPanel JpTitulo;
    private javax.swing.JPanel JpTratamiento;
    private javax.swing.JLabel LbAlarma;
    private javax.swing.JLabel LbAnalisis;
    private javax.swing.JLabel LbAntecedenteFamiliar;
    private javax.swing.JLabel LbAntecedentePaciente;
    private javax.swing.JLabel LbCerrarSesion;
    private javax.swing.JLabel LbDiagnostico;
    private javax.swing.JLabel LbMotivo;
    private javax.swing.JLabel LbObjetivo;
    private javax.swing.JLabel LbSaludo;
    private javax.swing.JLabel LbSubjetivo;
    private javax.swing.JLabel LbTitulo;
    private javax.swing.JLabel LbTratamiento;
    private javax.swing.JLabel LbTratamientoNO;
    private javax.swing.JRadioButton RbAdquirido;
    private javax.swing.JRadioButton RbHereditario;
    private javax.swing.JRadioButton RbNinguno;
    private javax.swing.JTextField TextApellido;
    private javax.swing.JTextField TxtAlarma;
    private javax.swing.JTextField TxtAnalisis;
    private javax.swing.JTextField TxtAntecedenteFliar;
    private javax.swing.JTextField TxtAntecedentePaciente;
    private javax.swing.JTextField TxtCelular;
    private javax.swing.JTextField TxtDiagnostico;
    private javax.swing.JTextField TxtDni;
    private javax.swing.JTextField TxtLegajo;
    private javax.swing.JTextField TxtNombre;
    private javax.swing.JTextField TxtObjetivo;
    private javax.swing.JTextField TxtSexo;
    private javax.swing.JTextField TxtSubjetivo;
    private javax.swing.JTextField TxtTelefono;
    private javax.swing.JTextField TxtTratamiento;
    private javax.swing.JTextField TxtTratamientoNO;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
