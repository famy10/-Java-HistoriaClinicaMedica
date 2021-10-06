
package Formulario.Medico;

//import Formulario.Tabla.TablaMedico;
import bd.LogicaBD;
import java.awt.Color;
import java.awt.Dimension;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class FrmConsultarFicha extends javax.swing.JFrame {
    
    TablaMedico t = new TablaMedico();
    //CONSTANTES DE BASE DE DATOS
    final int CTE_LOGIN = 20;
    
   
    
    String [][] filas = {};
    String [] columnas = {"Enfermedades", "Consultar ", "Fecha" };
    DefaultTableModel ModeloTabla = new DefaultTableModel(filas, columnas);
    
    javax.swing.JLabel LbEspecialidad  = new javax.swing.JLabel();;
    javax.swing.JButton BtnVer = new javax.swing.JButton();
    
    LogicaBD logica = new LogicaBD();
    private int dniMedico;
    private int dniPaciente;
    private java.sql.Date sqlFecha;

  
    public FrmConsultarFicha(int nroMedico, int nroPaciente) {
        initComponents();
        dniMedico=nroMedico;
        dniPaciente=nroPaciente;
        // t.ver_tabla(Tabla);
        //t.ver_tabla(Tabla);
        DatosComunes();
        ConfiguracionElementos();
        JpDatos.setEnabled(true);
    }
    
    private void cargarDatos() {
        if (logica.buscarLegajo(dniPaciente)) {
            //System.out.println(logica.getEspecialidad());
            //System.out.println(dniMedico);
           // logica.ConsultarHistoria(logica.getLegajo(), logica.getEspecialidad(), dniMedico);
             t.ver_tabla(Tabla,logica.getLegajo(), logica.getEspecialidad(), dniMedico);
        }
        
        
       
        //System.out.println(logica.getFechaSql());
    }
    

    
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
        this.setTitle("Consultar Ficha Médica");
        this.setResizable(false);
        if (logica.ConsultarPaciente(dniPaciente)) {
            CargarCabecera();
        }
        if (logica.buscarNombre(dniMedico)) {
            this.LbSaludo.setText("HOLA, " + logica.getNombre());
            this.LbEspecialidad2.setText(logica.getEspecialidad());
        }
        else {
            this.LbSaludo.setText("HOLA");
        }
        cargarDatos();
    }
    
    private void ConfiguracionElementos() {
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SpHistoriaClinica = new javax.swing.JScrollPane();
        TableHistoria = new javax.swing.JTable();
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
        LbDatosPersonales = new javax.swing.JLabel();
        JpBotones = new javax.swing.JPanel();
        BtnCrear = new javax.swing.JButton();
        BtnAtras = new javax.swing.JButton();
        JpSubtitulo = new javax.swing.JPanel();
        LbEnfeermedad = new javax.swing.JLabel();
        JpDatos = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla = new javax.swing.JTable();
        JpSaludo = new javax.swing.JPanel();
        LbSaludo = new javax.swing.JLabel();
        LbCerrarSesion = new javax.swing.JLabel();
        LbEspecialidad2 = new javax.swing.JLabel();

        TableHistoria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "", "", ""
            }
        ));
        TableHistoria.setRowHeight(35);
        SpHistoriaClinica.setViewportView(TableHistoria);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 102, 102));

        JpPpal.setBackground(new java.awt.Color(240, 230, 155));

        JpTitulo.setBackground(new java.awt.Color(240, 230, 155));

        LbTitulo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        LbTitulo.setForeground(new java.awt.Color(255, 0, 0));
        LbTitulo.setText("FICHA MEDICA");

        javax.swing.GroupLayout JpTituloLayout = new javax.swing.GroupLayout(JpTitulo);
        JpTitulo.setLayout(JpTituloLayout);
        JpTituloLayout.setHorizontalGroup(
            JpTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpTituloLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LbTitulo)
                .addGap(170, 170, 170))
        );
        JpTituloLayout.setVerticalGroup(
            JpTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LbTitulo, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        JpDatosPersonales.setBackground(new java.awt.Color(240, 230, 155));

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

        LbDatosPersonales.setForeground(java.awt.Color.blue);
        LbDatosPersonales.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        LbDatosPersonales.setText("Datos Personales");
        LbDatosPersonales.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LbDatosPersonalesMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout JpDatosPersonalesLayout = new javax.swing.GroupLayout(JpDatosPersonales);
        JpDatosPersonales.setLayout(JpDatosPersonalesLayout);
        JpDatosPersonalesLayout.setHorizontalGroup(
            JpDatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpDatosPersonalesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JpDatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TextApellido, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                    .addComponent(TxtNombre))
                .addGroup(JpDatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JpDatosPersonalesLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(TxtSexo, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(JpDatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TxtCelular, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtTelefono, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(JpDatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TxtLegajo, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                            .addComponent(TxtDni)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpDatosPersonalesLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(LbDatosPersonales, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        JpDatosPersonalesLayout.setVerticalGroup(
            JpDatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpDatosPersonalesLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(TxtSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                            .addComponent(TxtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(LbDatosPersonales))))
        );

        JpBotones.setBackground(new java.awt.Color(240, 230, 155));

        BtnCrear.setText("CREAR NUEVA FICHA MÉDICA");
        BtnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCrearActionPerformed(evt);
            }
        });

        BtnAtras.setText("ATRAS");
        BtnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAtrasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JpBotonesLayout = new javax.swing.GroupLayout(JpBotones);
        JpBotones.setLayout(JpBotonesLayout);
        JpBotonesLayout.setHorizontalGroup(
            JpBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpBotonesLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(BtnCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BtnAtras)
                .addGap(99, 99, 99))
        );
        JpBotonesLayout.setVerticalGroup(
            JpBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(BtnCrear)
                .addComponent(BtnAtras))
        );

        JpSubtitulo.setBackground(new java.awt.Color(240, 230, 155));

        LbEnfeermedad.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        LbEnfeermedad.setForeground(java.awt.Color.red);
        LbEnfeermedad.setText("ENFERMEDADES");

        javax.swing.GroupLayout JpSubtituloLayout = new javax.swing.GroupLayout(JpSubtitulo);
        JpSubtitulo.setLayout(JpSubtituloLayout);
        JpSubtituloLayout.setHorizontalGroup(
            JpSubtituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpSubtituloLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(LbEnfeermedad, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        JpSubtituloLayout.setVerticalGroup(
            JpSubtituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpSubtituloLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(LbEnfeermedad))
        );

        JpDatos.setBackground(new java.awt.Color(240, 230, 155));

        jScrollPane1.setBackground(new java.awt.Color(240, 230, 155));

        Tabla.setBackground(new java.awt.Color(240, 230, 155));
        Tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "", ""
            }
        ));
        Tabla.setRowHeight(35);
        Tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Tabla);

        javax.swing.GroupLayout JpDatosLayout = new javax.swing.GroupLayout(JpDatos);
        JpDatos.setLayout(JpDatosLayout);
        JpDatosLayout.setHorizontalGroup(
            JpDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpDatosLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
                .addContainerGap())
        );
        JpDatosLayout.setVerticalGroup(
            JpDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
        );

        JpSaludo.setBackground(new java.awt.Color(240, 230, 155));

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

        javax.swing.GroupLayout JpSaludoLayout = new javax.swing.GroupLayout(JpSaludo);
        JpSaludo.setLayout(JpSaludoLayout);
        JpSaludoLayout.setHorizontalGroup(
            JpSaludoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpSaludoLayout.createSequentialGroup()
                .addComponent(LbSaludo, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(117, 117, 117)
                .addComponent(LbEspecialidad2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LbCerrarSesion)
                .addContainerGap())
        );
        JpSaludoLayout.setVerticalGroup(
            JpSaludoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LbSaludo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(JpSaludoLayout.createSequentialGroup()
                .addGroup(JpSaludoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(LbEspecialidad2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LbCerrarSesion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout JpPpalLayout = new javax.swing.GroupLayout(JpPpal);
        JpPpal.setLayout(JpPpalLayout);
        JpPpalLayout.setHorizontalGroup(
            JpPpalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JpTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(JpDatosPersonales, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(JpBotones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(JpSubtitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(JpDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(JpSaludo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        JpPpalLayout.setVerticalGroup(
            JpPpalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpPpalLayout.createSequentialGroup()
                .addComponent(JpDatosPersonales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JpSaludo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(JpTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JpBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JpSubtitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JpDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(63, Short.MAX_VALUE))
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

     private void BtnVerActionPerformed(java.awt.event.ActionEvent evt) {                                         
        Prueba f = new Prueba();
        f.setVisible(true);
        this.dispose();
    }     
    
    private void TxtDniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtDniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtDniActionPerformed

    private void TxtCelularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtCelularActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtCelularActionPerformed

    
    
    private void BtnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCrearActionPerformed
        final int formularioHicha = 501;
        FrmRegistrarFicha registrarFicha = new FrmRegistrarFicha(formularioHicha,dniMedico,0,this.dniPaciente,"a", "b", sqlFecha);
        registrarFicha.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BtnCrearActionPerformed

    private void BtnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAtrasActionPerformed
        FrmBuscarPaciente buscarPaciente = new FrmBuscarPaciente(dniMedico); //pongo un 1 pa q no tire error, empece trabajar con nro en form paciente
        buscarPaciente.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BtnAtrasActionPerformed

    private void LbCerrarSesionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LbCerrarSesionMouseClicked
        FrmLogin login = new FrmLogin();
        this.dispose();
        login.setVisible(true);
    }//GEN-LAST:event_LbCerrarSesionMouseClicked

    private void LbCerrarSesionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_LbCerrarSesionKeyTyped

    }//GEN-LAST:event_LbCerrarSesionKeyTyped

    private java.sql.Date ConvertirASql(java.util.Date FechaDelFormulario)  
   {

	java.sql.Date SqlFechaConvertida = new java.sql.Date(FechaDelFormulario.getTime()); 
        return SqlFechaConvertida;
      }
    private void TablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaMouseClicked
        int column = Tabla.getColumnModel().getColumnIndexAtX(evt.getX()); //posicion X donde hago clic
        int row = evt.getY()/Tabla.getRowHeight(); //posicion Y donde hago clic
        
        if (row < Tabla.getRowCount() && row >= 0 && column < Tabla.getColumnCount() && column >= 0) {
            Object value = Tabla.getValueAt(row, column); //obtiene coordenada X , Y
            if (value instanceof JButton) {  //si la coordenada es un boton
                ((JButton)value).doClick(); //si hace clic en dicho boton
                JButton boton = (JButton) value; //devielvo el boton donde hice clic
                
               int filita = Tabla.getSelectedRow();
               String enfermedad = Tabla.getValueAt(filita, 0).toString();
               
               SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    // sqlFecha 
                    System.out.println(formato.parse(Tabla.getValueAt(filita, 3).toString()));
                     Date fecha = formato.parse(Tabla.getValueAt(filita, 3).toString());
                     sqlFecha= ConvertirASql(fecha);
                } catch (ParseException ex) {
                    Logger.getLogger(FrmConsultarFicha.class.getName()).log(Level.SEVERE, null, ex);
                }
              

                ConsultarEnfermedad c = new ConsultarEnfermedad(dniMedico, logica.getLegajo(),dniPaciente, enfermedad, logica.getApyn(), sqlFecha);
                c.setVisible(true);
                this.dispose();
            }
        }
    }//GEN-LAST:event_TablaMouseClicked

    private void LbDatosPersonalesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LbDatosPersonalesMouseClicked
        // TODO add your handling code here:
        final int formularioHicha = 501;
        
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date fecha = formato.parse("2020-10-10");
            java.sql.Date sqlFecha2 = ConvertirASql(fecha);
            FrmRegistrar frm = new FrmRegistrar(formularioHicha, dniMedico,dniPaciente,0,"e","a",sqlFecha2);
            frm.setVisible(true);
            this.dispose();
        } catch (ParseException ex) {
            Logger.getLogger(FrmConsultarFicha.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_LbDatosPersonalesMouseClicked
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAtras;
    private javax.swing.JButton BtnCrear;
    private javax.swing.JPanel JpBotones;
    private javax.swing.JPanel JpDatos;
    private javax.swing.JPanel JpDatosPersonales;
    private javax.swing.JPanel JpPpal;
    private javax.swing.JPanel JpSaludo;
    private javax.swing.JPanel JpSubtitulo;
    private javax.swing.JPanel JpTitulo;
    private javax.swing.JLabel LbCerrarSesion;
    private javax.swing.JLabel LbDatosPersonales;
    private javax.swing.JLabel LbEnfeermedad;
    private javax.swing.JLabel LbEspecialidad2;
    private javax.swing.JLabel LbSaludo;
    private javax.swing.JLabel LbTitulo;
    private javax.swing.JScrollPane SpHistoriaClinica;
    private javax.swing.JTable Tabla;
    private javax.swing.JTable TableHistoria;
    private javax.swing.JTextField TextApellido;
    private javax.swing.JTextField TxtCelular;
    private javax.swing.JTextField TxtDni;
    private javax.swing.JTextField TxtLegajo;
    private javax.swing.JTextField TxtNombre;
    private javax.swing.JTextField TxtSexo;
    private javax.swing.JTextField TxtTelefono;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
