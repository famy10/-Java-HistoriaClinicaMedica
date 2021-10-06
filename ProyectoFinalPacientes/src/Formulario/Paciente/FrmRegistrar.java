
package Formulario.Paciente;

import Validaciones.Vacio;
import Validaciones.Validacion;
import bd.LogicaBD;
import java.util.List;
import javax.swing.JOptionPane;

public class FrmRegistrar extends javax.swing.JFrame {
    //CONSTANTES    
    final int CONTRASENIA = -1;
    final int HORA = 24;
    final int MINUTOS = 60;
    
    final int COMBO_RESPUESTA_STRING = 100;
    final int COMBO_RESPUESTA_INT = -100;
    final int NOMBRE = 1;
    final int APELLIDO = 2;
    
    final int DOCUMENTO = 8;
    final int LEGAJO = 6;
    final int TELEFONO = 3;
    final int CELULAR = 4;
    
    final int LOCALIDAD = 10;
    final int DIRECCION = 11;
    
    boolean MENSAJE_CONTRASENIA=true;
    boolean MENSAJE_FECHA_CARACTER_ERRONEO=true;
    boolean MENSAJE_FECHA_COMPARACION=true;
    boolean MENSAJE_HORA=true;
    boolean MENSAJE_MINUTOS=true;
    boolean MENSAJE_ESPECIALIDAD_Y_DIAS=true;
    boolean MENSAJE_RESPUESTA=true;
    boolean MENSAJE_CONTRASENIA_2 = true;
            boolean MENSAJE_ANIO = true;
//VARIABLES FORMULARIO QUE ENLAZAN CON BD
    
    private String contrasenia;    
    private java.util.Date fechaSeleccionada;
    private java.sql.Date fechaSql;
    
    
    private int cantElemLista;
    
    private String matricula;
    
    private char[] arrayC ;
    private char[] arrayC_2 ;
    private String contrasenia_2;
    private String msj="";
    
    //OBJETOS
    private List<String> listaString;
    //OBJETOS PROPIOS
    private Validacion validacion = new Validacion();
    private Vacio vacio = new Vacio();
    private LogicaBD logica = new LogicaBD();
    private int opcionFormulario;
    
    private int dniPaciente;
    private int legajo;
    private String especialidad;
    private String enfermedad;
    private java.sql.Date fechaSql2;
    public FrmRegistrar(final int opcion, int dniPac, int leg, String esp, String enferm, java.sql.Date fecha) {
        initComponents();
        DatosComunes();
        ConfiguracionElementos(); 
        opcionFormulario = opcion;
        dniPaciente = dniPac;
        legajo = leg;
        especialidad= esp;
        enfermedad= enferm;
        fechaSql2 = fecha;
        if (opcion != 0) {
            this.BtnRegistrar.setText("MODIFICAR");
            ConsultarDatosPersonales();
        }
        //ListaEspecialidad.setModel(logica.Consultar("SELECT nombre FROM especialidad order by nombre;", CTE_ESPECIALIDAD)); //ListModel<String>
        
    }
    private void ConsultarDatosPersonales() {
        if (logica.ConsultarPacienteFull(dniPaciente)) {
                        
            this.TxtDoc.setText(String.valueOf(logica.getDni()));
            this.TxtLegajo.setText(String.valueOf(logica.getLegajo()));
            this.JPfPass.setText(logica.getContrasenia());
            this.JPfPass_2.setText(logica.getContrasenia());
            this.CbPregunta.setSelectedIndex(logica.getPregunta());
            this.TxtRespuesta.setText(logica.getRespuesta());
            this.TxtNombre.setText(logica.getNombre());
            this.TxtApellido.setText(logica.getApellido());
            
            if (logica.getSexo()=='M') {
                this.RbMasculino.setSelected(true);
            }
            else {
                this.RbFemenino.setSelected(true);
            }
            
            //FECHA NACIMIENTO: PROBAR
            this.JdcNacimiento.setDate(logica.getFechaSql());
       
            
            this.CbEstadoCivil.setSelectedIndex(logica.getEstadoCivil());
            
            this.TxtLocalidad.setText(logica.getLocalidad());
            this.TxtDireccion.setText(logica.getDireccion());
            this.TxtTel.setText(String.valueOf(logica.getTelefono()));
            this.TxtCelu.setText(String.valueOf(logica.getCelular()));
            
              if (logica.getObraSocial().equals("SI")) {
                this.RbSi.setSelected(true);
            }
            else {
                this.RbNo.setSelected(true);
            }
        }
        
    }
    private void cargarDatos() {
        logica.setDni(Integer.parseInt(this.TxtDoc.getText()));
        
        arrayC = this.JPfPass.getPassword();
        this.contrasenia = new String(arrayC);
        logica.setContrasenia(this.contrasenia);
        
        logica.setNombre(this.TxtNombre.getText().toUpperCase());
        logica.setApellido(this.TxtApellido.getText().toUpperCase());
        
        //SEXO
        if (RbMasculino.isSelected()) {
            //sexo = 'M';
            logica.setSexo('M');
        }
        else {
            //sexo = 'F';
            logica.setSexo('F');
        }
        
        //OBRA SOCIAL
        if (this.RbSi.isSelected()){
            //sexo = 'M';
            logica.setObraSocial("SI");
            
        }
        else {
            //sexo = 'F';
            logica.setObraSocial("NO");
        }
        logica.setPregunta(CbPregunta.getSelectedIndex());
        logica.setRespuesta(this.TxtRespuesta.getText());
        
        fechaSql = ConvertirAsql(fechaSeleccionada);
        logica.setFechaSql(fechaSql);
        System.out.println("fecha SQL: " + fechaSql);
        
       
                
//        fechaSql = ConvertirAsql(fecha);
        
        
        logica.setEstadoCivil(CbEstadoCivil.getSelectedIndex());
        
        logica.setLocalidad(this.TxtLocalidad.getText().toUpperCase());
        logica.setDireccion(this.TxtDireccion.getText().toUpperCase());
        
        if (!this.TxtTel.getText().isEmpty()) {
            logica.setTelefono(Integer.parseInt(this.TxtTel.getText()));                        
        }
        if (!this.TxtCelu.getText().isEmpty()) {
            logica.setCelular(Integer.parseInt(this.TxtCelu.getText()));
        }
        this.TxtTel.setText(null);
        this.TxtCelu.setText(null);
        
    }//FIN FUNCOIN CARGAR DATOS
    
        private boolean MenuValidaciones() {
        /*
    boolean MENSAJE_CONTRASENIA=true;
    boolean MENSAJE_FECHA_CARACTER_ERRONEO=true;
    boolean MENSAJE_FECHA_COMPARACION=true;
    boolean MENSAJE_HORA=true;
    boolean MENSAJE_MINUTOS=true;
    boolean MENSAJE_ESPECIALIDAD_Y_DIAS=true;
    boolean MENSAJE_RESPUESTA=true;
        */
        if (!vacio.vacio_8(TxtDoc.getText(), contrasenia, contrasenia_2, TxtRespuesta.getText(), TxtNombre.getText(), TxtApellido.getText(), TxtLocalidad.getText(), TxtDireccion.getText())) {
            JOptionPane.showMessageDialog(null, "Debe llenar los campos obligatorios.");
            return false;
        }
        else {
            if (!validacion.validarPassword(contrasenia, contrasenia_2)) {
                MENSAJE_CONTRASENIA = false;
            }
            
            if (!validacion.validoFecha(JdcNacimiento)) {
                MENSAJE_FECHA_CARACTER_ERRONEO=false;
            }
            else {
                fechaSeleccionada = JdcNacimiento.getDate();
                if (!validacion.CompararFechas(fechaSeleccionada)) {
                    MENSAJE_FECHA_COMPARACION=false;
                }
            }

            
            
            if (!validacion.validarTamanioMinimo(contrasenia, 8, CONTRASENIA)) {
                MENSAJE_CONTRASENIA_2=false;
            }
            final int COMBO_RESPUESTA_INT = -100;
            
            if (!validacion.validarTamanioMinimo(TxtRespuesta.getText(), 4, COMBO_RESPUESTA_INT)) {
                MENSAJE_ANIO=false;
            }
        
           
            
            if (!validacion.ValidarRespuestaComboBox(this.CbPregunta.getSelectedIndex(),this.TxtRespuesta.getText())) {
                this.TxtRespuesta.setText(null);
                MENSAJE_RESPUESTA=false;
            }
        }
        /*
    MENSAJE_CONTRASENIA=true;
    MENSAJE_FECHA_CARACTER_ERRONEO=true;
    MENSAJE_FECHA_COMPARACION=true;
    MENSAJE_HORA=true;
    MENSAJE_MINUTOS=true;
    MENSAJE_ESPECIALIDAD_Y_DIAS=true;
    MENSAJE_RESPUESTA=true;
        */
        if (!MENSAJE_CONTRASENIA || !MENSAJE_FECHA_CARACTER_ERRONEO || !MENSAJE_FECHA_COMPARACION ||
            !MENSAJE_HORA || !MENSAJE_MINUTOS || !MENSAJE_ESPECIALIDAD_Y_DIAS || !MENSAJE_RESPUESTA || !MENSAJE_CONTRASENIA_2 || !MENSAJE_ANIO   ) {
            MENSAJE_CONTRASENIA=true;
            MENSAJE_FECHA_CARACTER_ERRONEO=true;
            MENSAJE_FECHA_COMPARACION=true;
            MENSAJE_HORA=true;
            MENSAJE_MINUTOS=true;
            MENSAJE_ESPECIALIDAD_Y_DIAS=true;
            MENSAJE_RESPUESTA=true;
            MENSAJE_CONTRASENIA_2=true;
            MENSAJE_ANIO=true;
            return false;
        }
        return true;
    }//FIN MENU VALIDACIONES
    
    private void menuMensaje() {
        msj="Se ha registrado exitosamente como paciente";
    }    
        
    private void formuladio_paciente() {
        arrayC = this.JPfPass.getPassword();
        this.contrasenia = new String(arrayC);
        
        arrayC_2 = this.JPfPass_2.getPassword();
        this.contrasenia_2 = new String(arrayC_2);

        if (MenuValidaciones()) {
            boolean valor;
            cargarDatos();
            if (opcionFormulario != 0) {
                //actualizarPaciente(int doc, String pass, String nom, String ape, char sex, java.sql.Date fe,                                             String loc, String dire,                     int civil,                 int tel,              int celu,         int ask,          String rta, String obraSoc)
                logica.actualizarPaciente(logica.getLegajo(), contrasenia, logica.getNombre(), logica.getApellido(), logica.getSexo(), logica.getFechaSql(), logica.getLocalidad(), logica.getDireccion(), logica.getEstadoCivil(), logica.getTelefono(), logica.getCelular(), logica.getPregunta(), logica.getRespuesta(), logica.getObraSocial());
            }
            else {
                if (logica.buscarDni(Integer.parseInt(this.TxtDoc.getText()),0)==1) {
                    if (logica.insertarPaciente("INSERT INTO paciente (doc,contrasenia,nombre,apellido,sexo,feNacimiento,localidad,dire,civil,tel,cel,pregunta,respuesta,obraSocial) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?);")) {
                       this.TxtLegajo.setText(String.valueOf(logica.getLegajo()));                    
                    }
                }
            }
        }
    }
        
     private void DatosComunes() {
        this.setLocationRelativeTo(null);
        this.setTitle("REGISTRAR PACIENTE");
        this.LbTitulo.setText("REGISTRAR PACIENTE");
        this.setResizable(false);       
    }
    
    private void ConfiguracionElementos() {
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GrupoSexo = new javax.swing.ButtonGroup();
        ObraSocial = new javax.swing.ButtonGroup();
        JpPpal = new javax.swing.JPanel();
        JpTitulo = new javax.swing.JPanel();
        LbTitulo = new javax.swing.JLabel();
        JpFila_1 = new javax.swing.JPanel();
        LbDoc = new javax.swing.JLabel();
        TxtDoc = new javax.swing.JTextField();
        LbEleccion_1 = new javax.swing.JLabel();
        TxtLegajo = new javax.swing.JTextField();
        JpFila_2 = new javax.swing.JPanel();
        LbPass_2 = new javax.swing.JLabel();
        LbPass = new javax.swing.JLabel();
        JPfPass_2 = new javax.swing.JPasswordField();
        JPfPass = new javax.swing.JPasswordField();
        JpFila_3 = new javax.swing.JPanel();
        LbPregunta = new javax.swing.JLabel();
        LbRespuesta = new javax.swing.JLabel();
        JpFila_4 = new javax.swing.JPanel();
        CbPregunta = new javax.swing.JComboBox<>();
        TxtRespuesta = new javax.swing.JTextField();
        JpFila_5 = new javax.swing.JPanel();
        LbNombre = new javax.swing.JLabel();
        TxtNombre = new javax.swing.JTextField();
        LbApellido = new javax.swing.JLabel();
        TxtApellido = new javax.swing.JTextField();
        JpFila_8 = new javax.swing.JPanel();
        LbTel = new javax.swing.JLabel();
        TxtTel = new javax.swing.JTextField();
        LbCelu = new javax.swing.JLabel();
        TxtCelu = new javax.swing.JTextField();
        JpFila_7 = new javax.swing.JPanel();
        TxtLocalidad = new javax.swing.JTextField();
        LbLocalidad = new javax.swing.JLabel();
        LbDireccion = new javax.swing.JLabel();
        TxtDireccion = new javax.swing.JTextField();
        JpFila_6 = new javax.swing.JPanel();
        LbSexo = new javax.swing.JLabel();
        RbMasculino = new javax.swing.JRadioButton();
        RbFemenino = new javax.swing.JRadioButton();
        LbNacimiento = new javax.swing.JLabel();
        JdcNacimiento = new com.toedter.calendar.JDateChooser();
        LbEstadoCivil = new javax.swing.JLabel();
        CbEstadoCivil = new javax.swing.JComboBox<>();
        JpObraSocial = new javax.swing.JPanel();
        LbObraSocial = new javax.swing.JLabel();
        RbSi = new javax.swing.JRadioButton();
        RbNo = new javax.swing.JRadioButton();
        JpBotones = new javax.swing.JPanel();
        BtnVolver = new javax.swing.JButton();
        BtnRegistrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 102, 102));

        JpPpal.setBackground(new java.awt.Color(240, 230, 155));

        JpTitulo.setBackground(new java.awt.Color(240, 230, 155));

        LbTitulo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        LbTitulo.setForeground(new java.awt.Color(255, 0, 0));
        LbTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LbTitulo.setText("REGISTRAR");

        javax.swing.GroupLayout JpTituloLayout = new javax.swing.GroupLayout(JpTitulo);
        JpTitulo.setLayout(JpTituloLayout);
        JpTituloLayout.setHorizontalGroup(
            JpTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpTituloLayout.createSequentialGroup()
                .addGap(327, 327, 327)
                .addComponent(LbTitulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        JpTituloLayout.setVerticalGroup(
            JpTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LbTitulo, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        LbDoc.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        LbDoc.setText("Número Documento*");

        TxtDoc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TxtDoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtDocActionPerformed(evt);
            }
        });
        TxtDoc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtDocKeyTyped(evt);
            }
        });

        LbEleccion_1.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        LbEleccion_1.setText("Legajo");

        TxtLegajo.setEditable(false);
        TxtLegajo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout JpFila_1Layout = new javax.swing.GroupLayout(JpFila_1);
        JpFila_1.setLayout(JpFila_1Layout);
        JpFila_1Layout.setHorizontalGroup(
            JpFila_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpFila_1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LbDoc)
                .addGap(18, 18, 18)
                .addComponent(TxtDoc, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(92, 92, 92)
                .addComponent(LbEleccion_1)
                .addGap(18, 18, 18)
                .addComponent(TxtLegajo, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        JpFila_1Layout.setVerticalGroup(
            JpFila_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpFila_1Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addGroup(JpFila_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LbDoc)
                    .addComponent(TxtDoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LbEleccion_1)
                    .addComponent(TxtLegajo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        JpFila_2.setPreferredSize(new java.awt.Dimension(1048, 47));

        LbPass_2.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        LbPass_2.setText("Repetir contraseña*");

        LbPass.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        LbPass.setText("Contraseña*");

        JPfPass_2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JPfPass_2KeyTyped(evt);
            }
        });

        JPfPass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JPfPassKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JPfPassKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout JpFila_2Layout = new javax.swing.GroupLayout(JpFila_2);
        JpFila_2.setLayout(JpFila_2Layout);
        JpFila_2Layout.setHorizontalGroup(
            JpFila_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpFila_2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LbPass)
                .addGap(28, 28, 28)
                .addComponent(JPfPass, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(LbPass_2)
                .addGap(29, 29, 29)
                .addComponent(JPfPass_2)
                .addContainerGap())
        );
        JpFila_2Layout.setVerticalGroup(
            JpFila_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpFila_2Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(JpFila_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LbPass)
                    .addComponent(LbPass_2)
                    .addComponent(JPfPass_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JPfPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        JpFila_3.setMinimumSize(new java.awt.Dimension(100, 47));
        JpFila_3.setPreferredSize(new java.awt.Dimension(100, 47));

        LbPregunta.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        LbPregunta.setText("Pregunta para recuperar contraseña*");

        LbRespuesta.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        LbRespuesta.setText("Responda dicha pregunta*");

        javax.swing.GroupLayout JpFila_3Layout = new javax.swing.GroupLayout(JpFila_3);
        JpFila_3.setLayout(JpFila_3Layout);
        JpFila_3Layout.setHorizontalGroup(
            JpFila_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpFila_3Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(LbPregunta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LbRespuesta)
                .addGap(158, 158, 158))
        );
        JpFila_3Layout.setVerticalGroup(
            JpFila_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpFila_3Layout.createSequentialGroup()
                .addGroup(JpFila_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LbPregunta)
                    .addComponent(LbRespuesta))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        JpFila_4.setPreferredSize(new java.awt.Dimension(100, 47));

        CbPregunta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "El apellido de soltera de tu madre.", "El nombre de tu primera mascota.", "¿En qué año empezaste el colegio primario?", "¿En qué ciudad naciste?" }));
        CbPregunta.setPreferredSize(new java.awt.Dimension(232, 17));

        TxtRespuesta.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TxtRespuesta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtRespuestaActionPerformed(evt);
            }
        });
        TxtRespuesta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtRespuestaKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout JpFila_4Layout = new javax.swing.GroupLayout(JpFila_4);
        JpFila_4.setLayout(JpFila_4Layout);
        JpFila_4Layout.setHorizontalGroup(
            JpFila_4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpFila_4Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(CbPregunta, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(TxtRespuesta, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        JpFila_4Layout.setVerticalGroup(
            JpFila_4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpFila_4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(CbPregunta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(TxtRespuesta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        JpFila_5.setPreferredSize(new java.awt.Dimension(100, 47));

        LbNombre.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        LbNombre.setText("Nombre*");

        TxtNombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TxtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtNombreKeyTyped(evt);
            }
        });

        LbApellido.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        LbApellido.setText("Apellido*");

        TxtApellido.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TxtApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtApellidoKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout JpFila_5Layout = new javax.swing.GroupLayout(JpFila_5);
        JpFila_5.setLayout(JpFila_5Layout);
        JpFila_5Layout.setHorizontalGroup(
            JpFila_5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpFila_5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LbNombre)
                .addGap(18, 18, 18)
                .addComponent(TxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90)
                .addComponent(LbApellido)
                .addGap(18, 18, 18)
                .addComponent(TxtApellido)
                .addContainerGap())
        );
        JpFila_5Layout.setVerticalGroup(
            JpFila_5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpFila_5Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addGroup(JpFila_5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LbNombre)
                    .addComponent(TxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LbApellido)
                    .addComponent(TxtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        JpFila_8.setPreferredSize(new java.awt.Dimension(100, 47));

        LbTel.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        LbTel.setText("Teléfono");

        TxtTel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TxtTel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtTelKeyTyped(evt);
            }
        });

        LbCelu.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        LbCelu.setText("Celular");

        TxtCelu.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TxtCelu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtCeluKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout JpFila_8Layout = new javax.swing.GroupLayout(JpFila_8);
        JpFila_8.setLayout(JpFila_8Layout);
        JpFila_8Layout.setHorizontalGroup(
            JpFila_8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpFila_8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LbTel)
                .addGap(18, 18, 18)
                .addComponent(TxtTel, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(LbCelu)
                .addGap(18, 18, 18)
                .addComponent(TxtCelu)
                .addContainerGap())
        );
        JpFila_8Layout.setVerticalGroup(
            JpFila_8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpFila_8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JpFila_8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LbTel)
                    .addComponent(TxtTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LbCelu)
                    .addComponent(TxtCelu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        JpFila_7.setPreferredSize(new java.awt.Dimension(100, 47));

        TxtLocalidad.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TxtLocalidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtLocalidadKeyTyped(evt);
            }
        });

        LbLocalidad.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        LbLocalidad.setText("Localidad*");

        LbDireccion.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        LbDireccion.setText("Dirección*");

        TxtDireccion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TxtDireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtDireccionKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout JpFila_7Layout = new javax.swing.GroupLayout(JpFila_7);
        JpFila_7.setLayout(JpFila_7Layout);
        JpFila_7Layout.setHorizontalGroup(
            JpFila_7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpFila_7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LbLocalidad)
                .addGap(18, 18, 18)
                .addComponent(TxtLocalidad, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(LbDireccion)
                .addGap(18, 18, 18)
                .addComponent(TxtDireccion)
                .addContainerGap())
        );
        JpFila_7Layout.setVerticalGroup(
            JpFila_7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpFila_7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JpFila_7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LbLocalidad)
                    .addComponent(TxtLocalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LbDireccion)
                    .addComponent(TxtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        JpFila_6.setPreferredSize(new java.awt.Dimension(100, 47));

        LbSexo.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        LbSexo.setText("Sexo*");

        GrupoSexo.add(RbMasculino);
        RbMasculino.setSelected(true);
        RbMasculino.setText("Masculino");
        RbMasculino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RbMasculinoActionPerformed(evt);
            }
        });

        GrupoSexo.add(RbFemenino);
        RbFemenino.setText("Femenino");
        RbFemenino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RbFemeninoActionPerformed(evt);
            }
        });

        LbNacimiento.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        LbNacimiento.setText("Fecha de nacimiento*");

        LbEstadoCivil.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        LbEstadoCivil.setText("Estado civil");

        CbEstadoCivil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Elija estado civil", "Casado/a", "Divorciado/a", "Separado/a", "Soltero/a", "Viudo/a" }));

        javax.swing.GroupLayout JpFila_6Layout = new javax.swing.GroupLayout(JpFila_6);
        JpFila_6.setLayout(JpFila_6Layout);
        JpFila_6Layout.setHorizontalGroup(
            JpFila_6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpFila_6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LbSexo)
                .addGap(18, 18, 18)
                .addGroup(JpFila_6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(RbMasculino)
                    .addComponent(RbFemenino))
                .addGap(30, 30, 30)
                .addComponent(LbNacimiento)
                .addGap(18, 18, 18)
                .addComponent(JdcNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(LbEstadoCivil)
                .addGap(18, 18, 18)
                .addComponent(CbEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        JpFila_6Layout.setVerticalGroup(
            JpFila_6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpFila_6Layout.createSequentialGroup()
                .addComponent(RbMasculino)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1, Short.MAX_VALUE)
                .addComponent(RbFemenino))
            .addGroup(JpFila_6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JpFila_6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(JpFila_6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(LbEstadoCivil)
                        .addComponent(CbEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(JpFila_6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(JdcNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(LbSexo)
                        .addComponent(LbNacimiento)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        JpObraSocial.setPreferredSize(new java.awt.Dimension(100, 47));

        LbObraSocial.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        LbObraSocial.setText("Obra Social");

        ObraSocial.add(RbSi);
        RbSi.setText("SI");
        RbSi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RbSiActionPerformed(evt);
            }
        });

        ObraSocial.add(RbNo);
        RbNo.setSelected(true);
        RbNo.setText("NO");
        RbNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RbNoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JpObraSocialLayout = new javax.swing.GroupLayout(JpObraSocial);
        JpObraSocial.setLayout(JpObraSocialLayout);
        JpObraSocialLayout.setHorizontalGroup(
            JpObraSocialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpObraSocialLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LbObraSocial)
                .addGap(18, 18, 18)
                .addGroup(JpObraSocialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(RbSi)
                    .addComponent(RbNo))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        JpObraSocialLayout.setVerticalGroup(
            JpObraSocialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpObraSocialLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LbObraSocial)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(JpObraSocialLayout.createSequentialGroup()
                .addComponent(RbSi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1, Short.MAX_VALUE)
                .addComponent(RbNo))
        );

        BtnVolver.setText("VOLVER");
        BtnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnVolverActionPerformed(evt);
            }
        });

        BtnRegistrar.setText("REGISTRAR");
        BtnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRegistrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JpBotonesLayout = new javax.swing.GroupLayout(JpBotones);
        JpBotones.setLayout(JpBotonesLayout);
        JpBotonesLayout.setHorizontalGroup(
            JpBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpBotonesLayout.createSequentialGroup()
                .addComponent(BtnRegistrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addComponent(BtnVolver)
                .addGap(23, 23, 23))
        );
        JpBotonesLayout.setVerticalGroup(
            JpBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpBotonesLayout.createSequentialGroup()
                .addGroup(JpBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnRegistrar)
                    .addComponent(BtnVolver))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout JpPpalLayout = new javax.swing.GroupLayout(JpPpal);
        JpPpal.setLayout(JpPpalLayout);
        JpPpalLayout.setHorizontalGroup(
            JpPpalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JpTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(JpPpalLayout.createSequentialGroup()
                .addGroup(JpPpalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(JpFila_2, javax.swing.GroupLayout.DEFAULT_SIZE, 859, Short.MAX_VALUE)
                    .addComponent(JpFila_1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JpFila_3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 859, Short.MAX_VALUE)
                    .addComponent(JpFila_4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 859, Short.MAX_VALUE)
                    .addComponent(JpFila_5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 859, Short.MAX_VALUE)
                    .addComponent(JpFila_6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 859, Short.MAX_VALUE)
                    .addComponent(JpFila_7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 859, Short.MAX_VALUE)
                    .addComponent(JpFila_8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 859, Short.MAX_VALUE)
                    .addGroup(JpPpalLayout.createSequentialGroup()
                        .addGap(257, 257, 257)
                        .addComponent(JpObraSocial, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(JpPpalLayout.createSequentialGroup()
                        .addGap(207, 207, 207)
                        .addComponent(JpBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        JpPpalLayout.setVerticalGroup(
            JpPpalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpPpalLayout.createSequentialGroup()
                .addComponent(JpTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JpFila_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JpFila_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JpFila_3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JpFila_4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JpFila_5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JpFila_6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JpFila_7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JpFila_8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JpObraSocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(JpBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
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

    
    private void RbMasculinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RbMasculinoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RbMasculinoActionPerformed

    private void RbFemeninoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RbFemeninoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RbFemeninoActionPerformed

    private void RbSiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RbSiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RbSiActionPerformed

    private void RbNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RbNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RbNoActionPerformed

    private void BtnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnVolverActionPerformed
        //opcionFormulario
        switch (opcionFormulario) {
            case 500:
                FrmHistoriaClinica his = new FrmHistoriaClinica(dniPaciente);
                his.setVisible(true);
                break;
            case 501:       
                FrmConsultarEnfermedades consulta = new FrmConsultarEnfermedades(dniPaciente, legajo, especialidad);
                consulta.setVisible(true);
                break;
            case 502:               
                FrmEnfermedadParticular enfParticular = new FrmEnfermedadParticular(legajo, dniPaciente, enfermedad, fechaSql2, especialidad);
                enfParticular.setVisible(true);
                break;
            case 0:
                FrmLogin login = new FrmLogin();
                login.setVisible(true);
                break;
            default:
                throw new AssertionError();
        }
        
        this.dispose();
    }//GEN-LAST:event_BtnVolverActionPerformed

    private void BtnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRegistrarActionPerformed
           
//        /if (opcionFormulario != 0) {
//            
//        }
//        else {
            formuladio_paciente();
            validacion.informar();
        //}
        
            
        
         
        
        
    }//GEN-LAST:event_BtnRegistrarActionPerformed

    private void TxtRespuestaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtRespuestaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtRespuestaActionPerformed

    private void TxtDocKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtDocKeyTyped
        // TODO add your handling code here:
        validacion.validarSoloNumero(evt,DOCUMENTO);
        validacion.validarTamanioMaximo(this.TxtDoc.getText(), 10, evt, DOCUMENTO);
    }//GEN-LAST:event_TxtDocKeyTyped

    private void TxtRespuestaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtRespuestaKeyTyped
        // TODO add your handling code here:
        if (this.CbPregunta.getSelectedIndex()==2) {
            validacion.validarSoloNumero(evt,COMBO_RESPUESTA_INT);
            validacion.validarTamanioMaximo(this.TxtRespuesta.getText(), 4, evt, COMBO_RESPUESTA_INT);
            //validacion.validarTamanioMinimo(this.TxtRespuesta.getText(), 4, evt);
        }
        else {
            validacion.validarSoloLetras(evt, COMBO_RESPUESTA_STRING);
            validacion.validarTamanioMaximo(this.TxtRespuesta.getText(), 20, evt, COMBO_RESPUESTA_STRING);
        }
    }//GEN-LAST:event_TxtRespuestaKeyTyped

    private void TxtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtNombreKeyTyped
        validacion.validarSoloLetras(evt, NOMBRE);
        validacion.validarTamanioMaximo(this.TxtNombre.getText(), 45, evt, NOMBRE);
    }//GEN-LAST:event_TxtNombreKeyTyped

    private void TxtApellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtApellidoKeyTyped
        validacion.validarSoloLetras(evt, APELLIDO);
        validacion.validarTamanioMaximo(this.TxtApellido.getText(), 45, evt, APELLIDO);
    }//GEN-LAST:event_TxtApellidoKeyTyped

    private void TxtTelKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtTelKeyTyped
   
        validacion.validarSoloNumero(evt,TELEFONO);
        validacion.validarTamanioMaximo(this.TxtTel.getText(), 10, evt, TELEFONO);
    }//GEN-LAST:event_TxtTelKeyTyped

    private void TxtCeluKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtCeluKeyTyped
        validacion.validarSoloNumero(evt,CELULAR);
        validacion.validarTamanioMaximo(this.TxtCelu.getText(), 10, evt, CELULAR);
    }//GEN-LAST:event_TxtCeluKeyTyped

    private void JPfPassKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JPfPassKeyTyped
        
        validacion.validarLetrasyNumero(evt,CONTRASENIA);
        validacion.validarTamanioMaximo(JPfPass.getText(),20, evt,CONTRASENIA);
    }//GEN-LAST:event_JPfPassKeyTyped

    private void JPfPass_2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JPfPass_2KeyTyped
        validacion.validarLetrasyNumero(evt,CONTRASENIA);
    }//GEN-LAST:event_JPfPass_2KeyTyped

    private void JPfPassKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JPfPassKeyReleased
      
    }//GEN-LAST:event_JPfPassKeyReleased

    private void TxtDocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtDocActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtDocActionPerformed

    private void TxtLocalidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtLocalidadKeyTyped
        // TODO add your handling code here:
        validacion.validarTamanioMaximo(this.TxtLocalidad.getText(), 30, evt, this.LOCALIDAD);
    }//GEN-LAST:event_TxtLocalidadKeyTyped

    private void TxtDireccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtDireccionKeyTyped
        // TODO add your handling code here:
        validacion.validarTamanioMaximo(this.TxtDireccion.getText(), 45, evt, this.DIRECCION);
    }//GEN-LAST:event_TxtDireccionKeyTyped
    
private java.sql.Date ConvertirAsql(java.util.Date fecha) {
        java.sql.Date fechaSql = new java.sql.Date(fecha.getTime());
        return fechaSql;
          
    }   
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnRegistrar;
    private javax.swing.JButton BtnVolver;
    private javax.swing.JComboBox<String> CbEstadoCivil;
    private javax.swing.JComboBox<String> CbPregunta;
    private javax.swing.ButtonGroup GrupoSexo;
    private javax.swing.JPasswordField JPfPass;
    private javax.swing.JPasswordField JPfPass_2;
    private com.toedter.calendar.JDateChooser JdcNacimiento;
    private javax.swing.JPanel JpBotones;
    private javax.swing.JPanel JpFila_1;
    private javax.swing.JPanel JpFila_2;
    private javax.swing.JPanel JpFila_3;
    private javax.swing.JPanel JpFila_4;
    private javax.swing.JPanel JpFila_5;
    private javax.swing.JPanel JpFila_6;
    private javax.swing.JPanel JpFila_7;
    private javax.swing.JPanel JpFila_8;
    private javax.swing.JPanel JpObraSocial;
    private javax.swing.JPanel JpPpal;
    private javax.swing.JPanel JpTitulo;
    private javax.swing.JLabel LbApellido;
    private javax.swing.JLabel LbCelu;
    private javax.swing.JLabel LbDireccion;
    private javax.swing.JLabel LbDoc;
    private javax.swing.JLabel LbEleccion_1;
    private javax.swing.JLabel LbEstadoCivil;
    private javax.swing.JLabel LbLocalidad;
    private javax.swing.JLabel LbNacimiento;
    private javax.swing.JLabel LbNombre;
    private javax.swing.JLabel LbObraSocial;
    private javax.swing.JLabel LbPass;
    private javax.swing.JLabel LbPass_2;
    private javax.swing.JLabel LbPregunta;
    private javax.swing.JLabel LbRespuesta;
    private javax.swing.JLabel LbSexo;
    private javax.swing.JLabel LbTel;
    private javax.swing.JLabel LbTitulo;
    private javax.swing.ButtonGroup ObraSocial;
    private javax.swing.JRadioButton RbFemenino;
    private javax.swing.JRadioButton RbMasculino;
    private javax.swing.JRadioButton RbNo;
    private javax.swing.JRadioButton RbSi;
    private javax.swing.JTextField TxtApellido;
    private javax.swing.JTextField TxtCelu;
    private javax.swing.JTextField TxtDireccion;
    private javax.swing.JTextField TxtDoc;
    private javax.swing.JTextField TxtLegajo;
    private javax.swing.JTextField TxtLocalidad;
    private javax.swing.JTextField TxtNombre;
    private javax.swing.JTextField TxtRespuesta;
    private javax.swing.JTextField TxtTel;
    // End of variables declaration//GEN-END:variables
}
