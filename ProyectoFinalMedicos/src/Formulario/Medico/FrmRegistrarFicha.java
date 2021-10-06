
package Formulario.Medico;

import Validaciones.Validacion;
import bd.LogicaBD;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Calendar;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class FrmRegistrarFicha extends javax.swing.JFrame {

    //CONSTANTES DE BASE DE DATOS
    final int CTE_LOGIN = 20;
    
    final int DOCUMENTO = 8;
    final int LEGAJO = 6;
    
    final int FICHA_MEDICA = 500;
    final int ENFERMEDAD = 501;    
    final int GENERICO = 503;
    
    final int ESPECIALIDAD = 21;
    final int MEDICO = 22;
    
    
    //VARIABLES PROPIAS DEL FORMULARIO
    private LocalDate FechaActual = LocalDate.now();
   
    //VARIABLES UTILES PARA LA BD
    
    
    private String descripAntecPaciente;
    private int antecFliar;
    private String descripAntecFliar;
    
    private String subjetivo;
    private String objetivo;
    private String analisis;
    private String tratamFarmac;
    private String tratamNOfarmac;
    private String alarma;
    
    private int legajo;

    Validacion validacion = new Validacion();
    
    
    
    
    LogicaBD logica = new LogicaBD();
    
    private int dniMedico;
    private int dniPaciente;
    private int  LegajoPaciente;
    
    private java.sql.Date fechaSql;
    private String enfermedad;
    private String apyn;
   
    public FrmRegistrarFicha(final int opcion, int nroMedico, int leg, int nroPaciente, String enferm, String apn, java.sql.Date fe) {
        initComponents();
        dniMedico=nroMedico;
        dniPaciente=nroPaciente;
        LegajoPaciente = leg;
        enfermedad = enferm;
        apyn = apn;
        fechaSql = fe;
        if (opcion == 501) {
            this.BtnLastFichaConsultada.setVisible(false);
        }
        else {
            this.BtnLastFichaConsultada.setVisible(true);
        }
        DatosComunes();
        ConfiguracionElementos();
    }
    
    public int getLegajo() {
        return legajo;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    public String getSubjetivo() {
        return subjetivo;
    }

    public void setSubjetivo(String subjetivo) {
        this.subjetivo = subjetivo;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public String getAnalisis() {
        return analisis;
    }

    public void setAnalisis(String analisis) {
        this.analisis = analisis;
    }

    public String getTratamFarmac() {
        return tratamFarmac;
    }

    public void setTratamFarmac(String tratamFarmac) {
        this.tratamFarmac = tratamFarmac;
    }

    public String getTratamNOfarmac() {
        return tratamNOfarmac;
    }

    public void setTratamNOfarmac(String tratamNOfarmac) {
        this.tratamNOfarmac = tratamNOfarmac;
    }

    public String getAlarma() {
        return alarma;
    }

    public void setAlarma(String alarma) {
        this.alarma = alarma;
    }
    
    public String getDescripAntecPaciente() {
        return descripAntecPaciente;
    }

    public void setDescripAntecPaciente(String descripAntecPaciente) {
        this.descripAntecPaciente = descripAntecPaciente;
    }

    public String getDescripAntecFliar() {
        return descripAntecFliar;
    }

    public void setDescripAntecFliar(String descripAntecFliar) {
        this.descripAntecFliar = descripAntecFliar;
    }

    public Date getFechaSql() {
        return fechaSql;
    }

    public void setFechaSql(Date fechaSql) {
        this.fechaSql = fechaSql;
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

    public int getAntecFliar() {
        return antecFliar;
    }

    public void setAntecFliar(int antecFliar) {
        this.antecFliar = antecFliar;
    }
    
    private void cargarDatos() {
         
         //this.setFechaSql(java.sql.Date.valueOf(FechaActual));
         logica.setFechaSql(java.sql.Date.valueOf(FechaActual)); //1
         
         logica.setEnfermedad(this.TxtEnfermedad.getText());  //2
         
         if (logica.BuscarApyn(dniMedico)) {
            
            logica.setApyn(logica.getNombre() + " " + logica.getApellido()); //3
             
            
            logica.setDescripAntecPaciente(this.TaAntecedentePaciente.getText()); //4
            if (RbNinguno.isSelected()) {
                logica.setAntecFliar(0);        //5
            }
            else if (RbHereditario.isSelected()) {
                logica.setAntecFliar(1);        //5
            }
            else {
                logica.setAntecFliar(2);        //5
            }
            
            logica.setDescripAntecFliar(this.TaAntecedenteFliar.getText()); //6
            
            logica.setSubjetivo(this.TaSubjetivo.getText());    //7
            logica.setObjetivo(this.TaObjetivo.getText());      //8
            logica.setAnalisis(this.TaAnalisis.getText());      //9
            logica.setTratamFarmac(this.TxtTratamiento.getText());      //10
            logica.setTratamNOfarmac(this.TaTratamientoNO.getText());   //11
            logica.setAlarma(this.TaAlarma.getText());        //12
            logica.setDni(this.dniMedico);      //13
            
            if (logica.buscarLegajo(this.dniPaciente)) {
                logica.setLegajo(logica.getLegajo());   //14
            }
            
            logica.setEspecialidad(this.LbEspecialidad.getText());  //15
            
            String cad;
            cad="INSERT INTO fichamedica (feAtención,enfermedad,medico,descAntecPaciente,antecFliar,DescAntecFliar, subjetiva,objetiva,analisis,trataFarm,trataNoFarm,alarma,Medico_doc,Paciente_legajo,Especilidad) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
            logica.registrarFicha(cad);
         }
         
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GrupoAntecedentes = new javax.swing.ButtonGroup();
        ScrollPrincipal = new javax.swing.JScrollPane();
        JpPpal = new javax.swing.JPanel();
        JpTitulo = new javax.swing.JPanel();
        LbTitulo = new javax.swing.JLabel();
        LbSaludo = new javax.swing.JLabel();
        LbCerrarSesion = new javax.swing.JLabel();
        LbEspecialidad = new javax.swing.JLabel();
        JpDatosPersonales = new javax.swing.JPanel();
        TextApellido = new javax.swing.JTextField();
        TxtNombre = new javax.swing.JTextField();
        TxtSexo = new javax.swing.JTextField();
        TxtTelefono = new javax.swing.JTextField();
        TxtCelular = new javax.swing.JTextField();
        TxtLegajo = new javax.swing.JTextField();
        TxtDni = new javax.swing.JTextField();
        JpAntecedentes = new javax.swing.JPanel();
        LbAntecedentePaciente = new javax.swing.JLabel();
        JpAntecedentesFamiliares = new javax.swing.JPanel();
        LbAntecedenteFamiliar = new javax.swing.JLabel();
        RbNinguno = new javax.swing.JRadioButton();
        RbHereditario = new javax.swing.JRadioButton();
        RbAdquirido = new javax.swing.JRadioButton();
        ScrollAntecedentePaciente = new javax.swing.JScrollPane();
        TaAntecedentePaciente = new javax.swing.JTextArea();
        ScrollAntecedenteFliar = new javax.swing.JScrollPane();
        TaAntecedenteFliar = new javax.swing.JTextArea();
        JpMotivo = new javax.swing.JPanel();
        LbMotivo = new javax.swing.JLabel();
        LbSubjetivo = new javax.swing.JLabel();
        LbObjetivo = new javax.swing.JLabel();
        LbAnalisis = new javax.swing.JLabel();
        ScrollSubjetivo = new javax.swing.JScrollPane();
        TaSubjetivo = new javax.swing.JTextArea();
        ScrollObjetivo = new javax.swing.JScrollPane();
        TaObjetivo = new javax.swing.JTextArea();
        ScrollAnalisis = new javax.swing.JScrollPane();
        TaAnalisis = new javax.swing.JTextArea();
        JpTratamiento = new javax.swing.JPanel();
        LbDiagnostico = new javax.swing.JLabel();
        LbTratamiento = new javax.swing.JLabel();
        TxtTratamiento = new javax.swing.JTextField();
        LbTratamientoNO = new javax.swing.JLabel();
        ScrollAlarma = new javax.swing.JScrollPane();
        TaAlarma = new javax.swing.JTextArea();
        LbAlarma = new javax.swing.JLabel();
        ScrollTratamientoNO = new javax.swing.JScrollPane();
        TaTratamientoNO = new javax.swing.JTextArea();
        LbSubtitTratamiento = new javax.swing.JLabel();
        JpBotonesInferior = new javax.swing.JPanel();
        TxtEnfermedad = new javax.swing.JTextField();
        BtnRegistrarFicha = new javax.swing.JButton();
        BtnListaPatalogias = new javax.swing.JButton();
        BtnAtras1 = new javax.swing.JButton();
        BtnLastFichaConsultada = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 102, 102));

        JpPpal.setBackground(new java.awt.Color(240, 230, 155));
        JpPpal.setAutoscrolls(true);
        JpPpal.setPreferredSize(new java.awt.Dimension(1063, 882));

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
                .addComponent(LbSaludo, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(102, 102, 102)
                .addComponent(LbTitulo)
                .addGap(90, 90, 90)
                .addComponent(LbEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
                .addComponent(LbCerrarSesion)
                .addGap(231, 231, 231))
        );
        JpTituloLayout.setVerticalGroup(
            JpTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpTituloLayout.createSequentialGroup()
                .addComponent(LbTitulo)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(LbSaludo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(LbCerrarSesion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(LbEspecialidad, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        javax.swing.GroupLayout JpDatosPersonalesLayout = new javax.swing.GroupLayout(JpDatosPersonales);
        JpDatosPersonales.setLayout(JpDatosPersonalesLayout);
        JpDatosPersonalesLayout.setHorizontalGroup(
            JpDatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpDatosPersonalesLayout.createSequentialGroup()
                .addContainerGap(113, Short.MAX_VALUE)
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
                .addGap(194, 194, 194))
        );
        JpDatosPersonalesLayout.setVerticalGroup(
            JpDatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpDatosPersonalesLayout.createSequentialGroup()
                .addGroup(JpDatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpDatosPersonalesLayout.createSequentialGroup()
                        .addContainerGap(13, Short.MAX_VALUE)
                        .addComponent(TextApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(JpDatosPersonalesLayout.createSequentialGroup()
                        .addGroup(JpDatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(JpDatosPersonalesLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(JpDatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(TxtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TxtLegajo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(JpDatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(TxtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TxtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(JpDatosPersonalesLayout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(TxtSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        LbAntecedentePaciente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        LbAntecedentePaciente.setText("Antecedentes del paciente");

        JpAntecedentesFamiliares.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.gray, null));

        LbAntecedenteFamiliar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        LbAntecedenteFamiliar.setText("Antecedentes familiares:");

        GrupoAntecedentes.add(RbNinguno);
        RbNinguno.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        RbNinguno.setSelected(true);
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        TaAntecedentePaciente.setColumns(20);
        TaAntecedentePaciente.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        TaAntecedentePaciente.setRows(5);
        TaAntecedentePaciente.setText("ninguno");
        TaAntecedentePaciente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TaAntecedentePacienteKeyTyped(evt);
            }
        });
        ScrollAntecedentePaciente.setViewportView(TaAntecedentePaciente);

        TaAntecedenteFliar.setColumns(20);
        TaAntecedenteFliar.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        TaAntecedenteFliar.setRows(5);
        TaAntecedenteFliar.setText("ninguno");
        TaAntecedenteFliar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TaAntecedenteFliarKeyTyped(evt);
            }
        });
        ScrollAntecedenteFliar.setViewportView(TaAntecedenteFliar);

        javax.swing.GroupLayout JpAntecedentesLayout = new javax.swing.GroupLayout(JpAntecedentes);
        JpAntecedentes.setLayout(JpAntecedentesLayout);
        JpAntecedentesLayout.setHorizontalGroup(
            JpAntecedentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpAntecedentesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JpAntecedentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JpAntecedentesLayout.createSequentialGroup()
                        .addComponent(ScrollAntecedentePaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                        .addComponent(JpAntecedentesFamiliares, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(ScrollAntecedenteFliar, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45))
                    .addGroup(JpAntecedentesLayout.createSequentialGroup()
                        .addComponent(LbAntecedentePaciente)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        JpAntecedentesLayout.setVerticalGroup(
            JpAntecedentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpAntecedentesLayout.createSequentialGroup()
                .addComponent(LbAntecedentePaciente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(JpAntecedentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ScrollAntecedentePaciente)
                    .addComponent(ScrollAntecedenteFliar)
                    .addComponent(JpAntecedentesFamiliares, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(34, 34, 34))
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

        TaSubjetivo.setColumns(20);
        TaSubjetivo.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        TaSubjetivo.setRows(5);
        TaSubjetivo.setText("picazón en los dedes de los pies.");
        TaSubjetivo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TaSubjetivoKeyTyped(evt);
            }
        });
        ScrollSubjetivo.setViewportView(TaSubjetivo);

        TaObjetivo.setColumns(20);
        TaObjetivo.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        TaObjetivo.setRows(5);
        TaObjetivo.setText("epimertis");
        TaObjetivo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TaObjetivoKeyTyped(evt);
            }
        });
        ScrollObjetivo.setViewportView(TaObjetivo);

        TaAnalisis.setColumns(20);
        TaAnalisis.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        TaAnalisis.setRows(5);
        TaAnalisis.setText("laboratorio e imágen");
        TaAnalisis.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TaAnalisisKeyTyped(evt);
            }
        });
        ScrollAnalisis.setViewportView(TaAnalisis);

        javax.swing.GroupLayout JpMotivoLayout = new javax.swing.GroupLayout(JpMotivo);
        JpMotivo.setLayout(JpMotivoLayout);
        JpMotivoLayout.setHorizontalGroup(
            JpMotivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpMotivoLayout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addComponent(LbSubjetivo)
                .addGap(315, 315, 315)
                .addComponent(LbObjetivo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LbAnalisis)
                .addGap(134, 134, 134))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpMotivoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JpMotivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(JpMotivoLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(LbMotivo)
                        .addGap(476, 476, 476))
                    .addGroup(JpMotivoLayout.createSequentialGroup()
                        .addComponent(ScrollSubjetivo, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ScrollObjetivo, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                        .addComponent(ScrollAnalisis, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24))))
        );
        JpMotivoLayout.setVerticalGroup(
            JpMotivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpMotivoLayout.createSequentialGroup()
                .addComponent(LbMotivo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JpMotivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LbSubjetivo)
                    .addComponent(LbObjetivo)
                    .addComponent(LbAnalisis))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JpMotivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JpMotivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(ScrollObjetivo, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(ScrollSubjetivo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(ScrollAnalisis, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        LbDiagnostico.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        LbDiagnostico.setText("Diagnóstico presuntivo");

        LbTratamiento.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        LbTratamiento.setText("Tratamiento farmacológico y dosis");

        TxtTratamiento.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TxtTratamiento.setText("empecid");
        TxtTratamiento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtTratamientoKeyTyped(evt);
            }
        });

        LbTratamientoNO.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        LbTratamientoNO.setText("Tratamiento no farmacológico");

        TaAlarma.setColumns(20);
        TaAlarma.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        TaAlarma.setRows(5);
        TaAlarma.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TaAlarmaKeyTyped(evt);
            }
        });
        ScrollAlarma.setViewportView(TaAlarma);

        LbAlarma.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        LbAlarma.setText("Pauta de alarma");

        TaTratamientoNO.setColumns(20);
        TaTratamientoNO.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        TaTratamientoNO.setRows(5);
        TaTratamientoNO.setText("No racarse los dedos para evitar la propagación del hongo.");
        TaTratamientoNO.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TaTratamientoNOKeyTyped(evt);
            }
        });
        ScrollTratamientoNO.setViewportView(TaTratamientoNO);

        LbSubtitTratamiento.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        LbSubtitTratamiento.setForeground(java.awt.Color.red);
        LbSubtitTratamiento.setText("Diagnóstico y tratamiento");

        javax.swing.GroupLayout JpBotonesInferiorLayout = new javax.swing.GroupLayout(JpBotonesInferior);
        JpBotonesInferior.setLayout(JpBotonesInferiorLayout);
        JpBotonesInferiorLayout.setHorizontalGroup(
            JpBotonesInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1038, Short.MAX_VALUE)
        );
        JpBotonesInferiorLayout.setVerticalGroup(
            JpBotonesInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );

        TxtEnfermedad.setText("acné");
        TxtEnfermedad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtEnfermedadKeyTyped(evt);
            }
        });

        BtnRegistrarFicha.setText("REGISTRAR FICHA MÉDICA");
        BtnRegistrarFicha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRegistrarFichaActionPerformed(evt);
            }
        });

        BtnListaPatalogias.setText("LISTA DE PATALOGIAS");
        BtnListaPatalogias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnListaPatalogiasActionPerformed(evt);
            }
        });

        BtnAtras1.setText("ATRAS");
        BtnAtras1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAtras1ActionPerformed(evt);
            }
        });

        BtnLastFichaConsultada.setText("ULTIMA FICHA CONSULTADA");
        BtnLastFichaConsultada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnLastFichaConsultadaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JpTratamientoLayout = new javax.swing.GroupLayout(JpTratamiento);
        JpTratamiento.setLayout(JpTratamientoLayout);
        JpTratamientoLayout.setHorizontalGroup(
            JpTratamientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpTratamientoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LbSubtitTratamiento)
                .addGap(405, 405, 405))
            .addGroup(JpTratamientoLayout.createSequentialGroup()
                .addGroup(JpTratamientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JpTratamientoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(JpTratamientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JpBotonesInferior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(JpTratamientoLayout.createSequentialGroup()
                                .addComponent(LbTratamientoNO)
                                .addGap(361, 361, 361)
                                .addComponent(LbAlarma))
                            .addGroup(JpTratamientoLayout.createSequentialGroup()
                                .addGroup(JpTratamientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(ScrollTratamientoNO, javax.swing.GroupLayout.DEFAULT_SIZE, 512, Short.MAX_VALUE)
                                    .addComponent(LbDiagnostico, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TxtEnfermedad))
                                .addGroup(JpTratamientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(JpTratamientoLayout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(LbTratamiento))
                                    .addGroup(JpTratamientoLayout.createSequentialGroup()
                                        .addGap(32, 32, 32)
                                        .addComponent(ScrollAlarma, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpTratamientoLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(TxtTratamiento, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(JpTratamientoLayout.createSequentialGroup()
                        .addGap(201, 201, 201)
                        .addComponent(BtnLastFichaConsultada)
                        .addGap(42, 42, 42)
                        .addComponent(BtnRegistrarFicha)
                        .addGap(66, 66, 66)
                        .addComponent(BtnListaPatalogias)
                        .addGap(44, 44, 44)
                        .addComponent(BtnAtras1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        JpTratamientoLayout.setVerticalGroup(
            JpTratamientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpTratamientoLayout.createSequentialGroup()
                .addComponent(LbSubtitTratamiento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(JpTratamientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LbDiagnostico, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(LbTratamiento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JpTratamientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtTratamiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtEnfermedad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(JpTratamientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LbTratamientoNO)
                    .addComponent(LbAlarma))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JpTratamientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JpTratamientoLayout.createSequentialGroup()
                        .addGroup(JpTratamientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ScrollTratamientoNO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ScrollAlarma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(JpTratamientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(JpTratamientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(BtnRegistrarFicha)
                                .addComponent(BtnListaPatalogias))
                            .addComponent(BtnLastFichaConsultada))
                        .addGap(24, 24, 24)
                        .addComponent(JpBotonesInferior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(BtnAtras1))
                .addGap(77, 77, 77))
        );

        javax.swing.GroupLayout JpPpalLayout = new javax.swing.GroupLayout(JpPpal);
        JpPpal.setLayout(JpPpalLayout);
        JpPpalLayout.setHorizontalGroup(
            JpPpalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpPpalLayout.createSequentialGroup()
                .addGroup(JpPpalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JpTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JpDatosPersonales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JpAntecedentes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(JpPpalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JpPpalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JpTratamiento, javax.swing.GroupLayout.PREFERRED_SIZE, 1029, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JpMotivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        JpPpalLayout.setVerticalGroup(
            JpPpalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpPpalLayout.createSequentialGroup()
                .addComponent(JpDatosPersonales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JpTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addComponent(JpAntecedentes, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JpMotivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JpTratamiento, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(129, Short.MAX_VALUE))
        );

        ScrollPrincipal.setViewportView(JpPpal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ScrollPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 1063, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ScrollPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 771, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TxtDniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtDniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtDniActionPerformed

    private void TxtCelularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtCelularActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtCelularActionPerformed

    private void BtnListaPatalogiasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnListaPatalogiasActionPerformed
        FrmConsultarFicha consultarFicha = new FrmConsultarFicha(dniMedico,this.dniPaciente);
        consultarFicha.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BtnListaPatalogiasActionPerformed

    private void RbNingunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RbNingunoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RbNingunoActionPerformed

    private void RbHereditarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RbHereditarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RbHereditarioActionPerformed

    private void RbAdquiridoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RbAdquiridoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RbAdquiridoActionPerformed

    private void BtnRegistrarFichaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRegistrarFichaActionPerformed
        cargarDatos();
    }//GEN-LAST:event_BtnRegistrarFichaActionPerformed

    private void LbCerrarSesionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LbCerrarSesionMouseClicked
        FrmLogin login = new FrmLogin();
        this.dispose();
        login.setVisible(true);
    }//GEN-LAST:event_LbCerrarSesionMouseClicked

    private void LbCerrarSesionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_LbCerrarSesionKeyTyped

    }//GEN-LAST:event_LbCerrarSesionKeyTyped

    private void TaAntecedentePacienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TaAntecedentePacienteKeyTyped
        // TODO add your handling code here:
        validacion.validarTamanioMaximo(this.TaAntecedentePaciente.getText(), 300, evt, this.GENERICO);
    }//GEN-LAST:event_TaAntecedentePacienteKeyTyped

    private void TaAntecedenteFliarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TaAntecedenteFliarKeyTyped
        // TODO add your handling code here:
        validacion.validarTamanioMaximo(this.TaAntecedenteFliar.getText(), 300, evt, this.GENERICO);
    }//GEN-LAST:event_TaAntecedenteFliarKeyTyped

    private void TaSubjetivoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TaSubjetivoKeyTyped
        // TODO add your handling code here:
        validacion.validarTamanioMaximo(this.TaSubjetivo.getText(), 300, evt, this.GENERICO);
    }//GEN-LAST:event_TaSubjetivoKeyTyped

    private void TaAnalisisKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TaAnalisisKeyTyped
        // TODO add your handling code here:
        validacion.validarTamanioMaximo(this.TaAnalisis.getText(), 300, evt, this.GENERICO);
    }//GEN-LAST:event_TaAnalisisKeyTyped

    private void TaObjetivoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TaObjetivoKeyTyped
        // TODO add your handling code here:
        validacion.validarTamanioMaximo(this.TaObjetivo.getText(), 300, evt, this.GENERICO);
    }//GEN-LAST:event_TaObjetivoKeyTyped

    private void TxtEnfermedadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtEnfermedadKeyTyped
        // TODO add your handling code here:
        validacion.validarTamanioMaximo(this.TxtEnfermedad.getText(), 45, evt, this.ENFERMEDAD);
    }//GEN-LAST:event_TxtEnfermedadKeyTyped

    private void TxtTratamientoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtTratamientoKeyTyped
        // TODO add your handling code here:
        validacion.validarTamanioMaximo(this.TxtTratamiento.getText(), 300, evt, this.GENERICO);
    }//GEN-LAST:event_TxtTratamientoKeyTyped

    private void TaTratamientoNOKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TaTratamientoNOKeyTyped
        // TODO add your handling code here:
        validacion.validarTamanioMaximo(this.TaTratamientoNO.getText(), 300, evt, this.GENERICO);
    }//GEN-LAST:event_TaTratamientoNOKeyTyped

    private void TaAlarmaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TaAlarmaKeyTyped
        // TODO add your handling code here:
        validacion.validarTamanioMaximo(this.TaAlarma.getText(), 300, evt, this.GENERICO);
    }//GEN-LAST:event_TaAlarmaKeyTyped

    private void BtnAtras1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAtras1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnAtras1ActionPerformed

    private void BtnLastFichaConsultadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLastFichaConsultadaActionPerformed
        // TODO add your handling code here:
        ConsultarEnfermedad c = new ConsultarEnfermedad(dniMedico, LegajoPaciente, dniPaciente, enfermedad, apyn, fechaSql );
        c.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BtnLastFichaConsultadaActionPerformed
    
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
        this.setTitle("Registrar Ficha Médica");
        this.setResizable(false);
        if (logica.ConsultarPaciente(dniPaciente)) {
            CargarCabecera();
        }
        if (logica.buscarNombre(dniMedico)) {
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
    private javax.swing.JButton BtnAtras1;
    private javax.swing.JButton BtnLastFichaConsultada;
    private javax.swing.JButton BtnListaPatalogias;
    private javax.swing.JButton BtnRegistrarFicha;
    private javax.swing.ButtonGroup GrupoAntecedentes;
    private javax.swing.JPanel JpAntecedentes;
    private javax.swing.JPanel JpAntecedentesFamiliares;
    private javax.swing.JPanel JpBotonesInferior;
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
    private javax.swing.JLabel LbEspecialidad;
    private javax.swing.JLabel LbMotivo;
    private javax.swing.JLabel LbObjetivo;
    private javax.swing.JLabel LbSaludo;
    private javax.swing.JLabel LbSubjetivo;
    private javax.swing.JLabel LbSubtitTratamiento;
    private javax.swing.JLabel LbTitulo;
    private javax.swing.JLabel LbTratamiento;
    private javax.swing.JLabel LbTratamientoNO;
    private javax.swing.JRadioButton RbAdquirido;
    private javax.swing.JRadioButton RbHereditario;
    private javax.swing.JRadioButton RbNinguno;
    private javax.swing.JScrollPane ScrollAlarma;
    private javax.swing.JScrollPane ScrollAnalisis;
    private javax.swing.JScrollPane ScrollAntecedenteFliar;
    private javax.swing.JScrollPane ScrollAntecedentePaciente;
    private javax.swing.JScrollPane ScrollObjetivo;
    private javax.swing.JScrollPane ScrollPrincipal;
    private javax.swing.JScrollPane ScrollSubjetivo;
    private javax.swing.JScrollPane ScrollTratamientoNO;
    private javax.swing.JTextArea TaAlarma;
    private javax.swing.JTextArea TaAnalisis;
    private javax.swing.JTextArea TaAntecedenteFliar;
    private javax.swing.JTextArea TaAntecedentePaciente;
    private javax.swing.JTextArea TaObjetivo;
    private javax.swing.JTextArea TaSubjetivo;
    private javax.swing.JTextArea TaTratamientoNO;
    private javax.swing.JTextField TextApellido;
    private javax.swing.JTextField TxtCelular;
    private javax.swing.JTextField TxtDni;
    private javax.swing.JTextField TxtEnfermedad;
    private javax.swing.JTextField TxtLegajo;
    private javax.swing.JTextField TxtNombre;
    private javax.swing.JTextField TxtSexo;
    private javax.swing.JTextField TxtTelefono;
    private javax.swing.JTextField TxtTratamiento;
    // End of variables declaration//GEN-END:variables

    public JTextArea getTaAlarma() {
        return TaAlarma;
    }

    public JTextArea getTaAnalisis() {
        return TaAnalisis;
    }

    public JTextArea getTaAntecedenteFliar() {
        return TaAntecedenteFliar;
    }

    public JTextArea getTaAntecedentePaciente() {
        return TaAntecedentePaciente;
    }

    public JTextArea getTaObjetivo() {
        return TaObjetivo;
    }

    public JTextArea getTaSubjetivo() {
        return TaSubjetivo;
    }

    public JTextArea getTaTratamientoNO() {
        return TaTratamientoNO;
    }

    public JTextField getTxtTratamiento() {
        return TxtTratamiento;
    }
}
