
package bd;

import Formulario.Medico.FrmRegistrar;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.ListModel;

public class LogicaBD {
    Conexion con = new Conexion();
    private PreparedStatement ps; 
    private ResultSet rs; //pa CONSULTA
    private int registro;
    
    private DefaultListModel modelListEspecialidad;
    
    //CONSTANTES DE BASE DE DATOS
    //final int CTE_LOGIN = 20;
    final int CTE_ESPECIALIDAD = 21;
    final int CTE_MEDICO = 22;
    
    
    //VARIABLES DE BD.TABLA MEDICO
    private int nroFicha;

    public int getNroFicha() {
        return nroFicha;
    }

    public void setNroFicha(int nroFicha) {
        this.nroFicha = nroFicha;
    }
    private int dni;
    private String contrasenia;
    private String nombre;
    private String apellido;
    private char sexo; 
    private int pregunta;
    private String respuesta;
    private java.sql.Date fechaSql;    
    private String localidad;
    private String direccion;
    private int estadoCivil;
    private int telefono;
    private int celular;
    private int BdNroEspecialidad;
    int marca_dniRepetido;
     private int legajo;
     private  String especialidad;
     private int idEspecialidad;
     
     
     
     private String enfermedad;
     private String apyn;
     private String descripAntecPaciente;
     private int antecFliar;
     private String descripAntecFliar;
     private String subjetivo;
     private String objetivo;
     private String analisis;
     private String tratamFarmac;
     private String tratamNOfarmac;
     private  String alarma;

     /*
     fecha-->mas arriba
     dni-->arriba de todo(int)
     legajo-->mas ariba (int)
     especialidad-> mas arriba (String)
     */
     
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

    public String getDescripAntecPaciente() {
        return descripAntecPaciente;
    }

    public void setDescripAntecPaciente(String descripAntecPaciente) {
        this.descripAntecPaciente = descripAntecPaciente;
    }

    public int getAntecFliar() {
        return antecFliar;
    }

    public void setAntecFliar(int antecFliar) {
        this.antecFliar = antecFliar;
    }

    public String getDescripAntecFliar() {
        return descripAntecFliar;
    }

    public void setDescripAntecFliar(String descripAntecFliar) {
        this.descripAntecFliar = descripAntecFliar;
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
     
    
     
    public int getIdEspecialidad() {
        return idEspecialidad;
    }

    public void setIdEspecialidad(int idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public int getLegajo() {
        return legajo;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    
    
    public int getMarca_dniRepetido() {
        return marca_dniRepetido;
    }

    public void setMarca_dniRepetido(int marca_dniRepetido) {
        this.marca_dniRepetido = marca_dniRepetido;
    }
    
    public int getBdNroEspecialidad() {
        return BdNroEspecialidad;
    }

    public void setBdNroEspecialidad(int BdNroEspecialidad) {
        this.BdNroEspecialidad = BdNroEspecialidad;
    }

    public List<String> getListaString() {
        return listaString;
    }

    public void setListaString(List<String> listaString) {
        this.listaString = listaString;
    }
    private List<String> listaString;
    
    private int cantElemLista;
    
    private String matricula;
    
   

    

    

    public ResultSet getRs() {
        return rs;
    }

    public void setRs(ResultSet rs) {
        this.rs = rs;
    }

    public DefaultListModel getModelListEspecialidad() {
        return modelListEspecialidad;
    }

    public void setModelListEspecialidad(DefaultListModel modelListEspecialidad) {
        this.modelListEspecialidad = modelListEspecialidad;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public java.sql.Date getFechaSql() {
        return fechaSql;
    }

    public void setFechaSql(java.sql.Date fechaSql) {
        this.fechaSql = fechaSql;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(int estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    public int getPregunta() {
        return pregunta;
    }

    public void setPregunta(int pregunta) {
        this.pregunta = pregunta;
    }

    public int getCantElemLista() {
        return cantElemLista;
    }

    public void setCantElemLista(int cantElemLista) {
        this.cantElemLista = cantElemLista;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    
    private boolean buscarEntero(String Str_sql, String cad, int opcion ) {
        //"SELECT idEspecialidad FROM especialidad where nombre = "
         //SELECT idEspecialidad FROM especialidad where nombre = '"+  +"';        
        String Str_busq = Str_sql + " '"+ cad +"'; ";
        //System.out.println(Str_busq);
        try {
            ps = con.conectar().prepareStatement(Str_busq);
            rs = ps.executeQuery();
            if (rs.next()) {
               this.setBdNroEspecialidad(rs.getInt(1));
                //this.setCodCiudad(reg.getInt(1));
                ps.close();
                return true;
            }
            else {
                JOptionPane.showMessageDialog(null, "La especialidad no se encuentra en nuestra base de datos");
                return false;
            }
        }
        catch (Exception ex) {
            switch (opcion) {
                case 21:
                    JOptionPane.showMessageDialog(null, "Error al realizar la busqueda de especialidad" + ex);
                    break;
                default:
                    throw new AssertionError();
            }            
        }
        return true;
    }
    
    private boolean buscarEntero(String Str_sql, int numero, int opcion ) {
        // SELECT doc FROM medico where doc = '"+  +"';
        //"SELECT doc FROM medico where doc =  "
        String Str_busq = Str_sql + " '"+ numero +"'; ";
        try {
            switch (opcion) {
                case 22:
                    ps = con.conectar().prepareStatement(Str_busq);
                    rs = ps.executeQuery();
                    if (rs.next()) {
                        
                        //this.setDni(rs.getInt(1));
                        JOptionPane.showMessageDialog(null, "El dni ya se encuentra registrado en nuestra base de datps. Pruebe con uno nuevo");
                        ps.close();
                        return true;
                    }                       
                    break;
                default:
                    throw new AssertionError();
            }
        }
        catch (Exception ex) {
            switch (opcion) {
                case 22:
                    JOptionPane.showMessageDialog(null, "Error al realizar la busqueda del dni en nuestra base de datos" + ex);
                    break;
                default:
                    throw new AssertionError();
            }
        }
        return false;
    }
    
    
    
    private boolean menuMensajeDeError(int opcion, SQLException ex) {
        boolean var=true;
        switch (opcion) {
            case 22:    //CTE_MEDICO
                JOptionPane.showMessageDialog(null,  "Error al intentar registrar un profesinal de la salud. " + ex);
                System.out.println(ex);
                var=false;
                break;
                
            case 21:    //CTE_ESPECIALIDAD
                JOptionPane.showMessageDialog(null,  "Error al intentar registrar la especialidad del médico. " + ex);
                System.out.println(ex);
                var=false;
                break;    
            default:
                throw new AssertionError();
        }
        return var;
    }
    
    private boolean EstadoPOSITIVOdeAlta(int opcion, int registro) {
        if (registro > 0) {
            switch (opcion) {
                case 22: JOptionPane.showMessageDialog(null, "Registro del médico guardado exitosamente"); break;
                case 21: JOptionPane.showMessageDialog(null, "Se creó el enlace médico con especialidad exitosamente"); break;
                default:
                    throw new AssertionError();
            }
        } 
        else {
            JOptionPane.showMessageDialog(null, "No lo pudo grabar");
            return false;
        }
        return true;
    }
    
    private boolean AltaMedico(int opcion, String Str_sql) {
        try {
            ps = con.conectar().prepareStatement(Str_sql);
            ps.setInt(1, this.getDni());
            ps.setString(2, this.getContrasenia());
            ps.setString(3, this.getNombre());
            ps.setString(4, this.getApellido());
            ps.setString(5, String.valueOf(this.getSexo()));
            ps.setDate(6, this.getFechaSql());
            ps.setString(7, this.getLocalidad());
            ps.setString(8, this.getDireccion());
            ps.setInt(9, this.getEstadoCivil());
            ps.setInt(10, this.getTelefono());
            ps.setInt(11, this.getCelular());
            ps.setInt(12, this.getPregunta());
            ps.setString(13, this.getRespuesta());
            ps.setString(14, this.getMatricula());
            registro = ps.executeUpdate();
            
            //EstadoPOSITIVOdeAlta(CTE_MEDICO, registro);
            if (EstadoPOSITIVOdeAlta(CTE_MEDICO, registro)) {
                ps.close();
                return true;
            }
        } catch (SQLException ex) {
            //Logger.getLogger(LogicaBD.class.getName()).log(Level.SEVERE, null, ex);
           // menuMensaje(opcion, ex);
            if (menuMensajeDeError(opcion, ex))
            { 
                return true;
            }
            else { 
                return false;
            }
        }
        return true;
    }
    
    private boolean AltaMedicoEspecialidad(int opcion, String Str_sql) {
        try {
            ps = con.conectar().prepareStatement(Str_sql);
            ps.setInt(1, this.getBdNroEspecialidad());                            
            ps.setInt(2, this.getDni());
            registro = ps.executeUpdate();
            
            if (EstadoPOSITIVOdeAlta(CTE_ESPECIALIDAD , registro)) {
                ps.close();
                return true;
            }
        }
        catch (SQLException ex) {
            if (menuMensajeDeError(opcion, ex))
            { 
                return true;
            }
            else { 
                return false;
            }
        }
        return true;
    }
    
    public boolean MenuAlta(String Str_sql, int opcion) {
       // boolean var=true;
        switch (opcion) {
            case 22:
                if (!buscarEntero("SELECT doc FROM medico where doc =  ", this.getDni(),CTE_MEDICO)) {
                    //marca_dniRepetido =1;   
                    //AltaMedico(opcion, Str_sql);
                    if (!AltaMedico(opcion, Str_sql)) {
                        return false;
                    }
                }
                else {
                    return false;
                }
                break;
            case 21:
                for (int i = 0; i < this.getCantElemLista(); i++) {
                    if (buscarEntero("SELECT idEspecialidad FROM especialidad where nombre = ", this.getListaString().get(i),CTE_ESPECIALIDAD)) {
                        if (!AltaMedicoEspecialidad(opcion, Str_sql)) {
                            return false; 
                        }
                    }    
                }
                
                break;
            default:
                throw new AssertionError();
        }
        return true;
    }

    public DefaultListModel Consultar(String Str_sql, int opcion) {
        
        try {
            ps = con.conectar().prepareStatement(Str_sql);           
            rs = ps.executeQuery();
            switch (opcion) {
                case 21:
                    modelListEspecialidad = new DefaultListModel();
                    while(rs.next()==true){ 
                     modelListEspecialidad.addElement(rs.getString(1));   
                    }                     
                    break;
                default:
                    throw new AssertionError();
            }
        }
        catch (SQLException ex) {
            switch (opcion) {
                case 21:
                    JOptionPane.showMessageDialog(null, "Error al consultar la especialidad" + ex);
                    break;
                default:
                    throw new AssertionError();
            }
        }
        return modelListEspecialidad;
    }
    
    
     
    public int buscarDni(int doc, int opcion) {
        String str_sql="select doc from paciente where doc = '"+ doc +"';";
         try {
            con = new Conexion();
            ps = con.conectar().prepareStatement(str_sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                if (opcion==0) {
                    JOptionPane.showMessageDialog(null,"Ud ya se encuentra registrado como paciente.");
                }
                       
                return 0;
            }
            else {
                if(opcion == 1)
                JOptionPane.showMessageDialog(null,"DNI inexistente");
                return 1;
            }
         
        }
        catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "Error con la base de datos al intentar buscar el DNI. Intente mas tarde.");
            return -1;
        }
    }
    
     public int buscarMedico(int doc) {
        String str_sql="SELECT doc FROM medico where doc = '"+ doc +"';";
         try {
            con = new Conexion();
            ps = con.conectar().prepareStatement(str_sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                
                    JOptionPane.showMessageDialog(null,"El dni ya se encuentra registrado en nuestra base de datos.");
                
                       
                return 0;
            }
            else {
                
               // JOptionPane.showMessageDialog(null,"DNI inexistente");
                return 1;
            }
         
        }
        catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "Error con la base de datos al intentar buscar el DNI. Intente mas tarde.");
            return -1;
        }
    }
    public boolean ConsultarMedico(int dni) {
        String Str_sql="SELECT * FROM medico where doc = '"+ dni +"';";
        try {
            ps = con.conectar().prepareStatement(Str_sql);
            rs = ps.executeQuery();
            if (rs.next()) {
               //this.setNombre(rs.getNString(1));
               
               this.setDni(Integer.parseInt(rs.getString(1)));
               this.setContrasenia(rs.getString(2));
               
               this.setNombre(rs.getString(3));
               this.setApellido(rs.getString(4));
                              
               this.setSexo(rs.getString(5).charAt(0));
               this.setFechaSql(java.sql.Date.valueOf(rs.getString(6)));
               
               this.setLocalidad(rs.getString(7));
               this.setDireccion(rs.getString(8));
               
               this.setEstadoCivil(Integer.parseInt(rs.getString(9)));
               
               this.setTelefono(Integer.parseInt(rs.getString(10)));
               this.setCelular(Integer.parseInt(rs.getString(11)));
               
               this.setPregunta(Integer.parseInt(rs.getString(12)));
               this.setRespuesta(rs.getString(13));
               
               this.setMatricula(rs.getString(14));
               this.setIdEspecialidad(Integer.parseInt(rs.getString(15)));
               ps.close();               
            }
            else {
                JOptionPane.showMessageDialog(null, "No se encuentra el medico, intente en otro momento");
            }            
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al intentar acceder a los datos del medico");             
            return false;    
        }
        return true;         
    }
     public boolean ConsultarPaciente(int dni) {
        
         String Str_sql="select apellido, nombre , sexo, cel, tel, legajo, doc  from paciente where doc = '"+ dni +"';";
        try {
            ps = con.conectar().prepareStatement(Str_sql);
            rs = ps.executeQuery();
            if (rs.next()) {
               //this.setNombre(rs.getNString(1));
                
               this.setApellido(rs.getString(1));
               this.setNombre(rs.getString(2));               
               this.setSexo(rs.getString(3).charAt(0));
               this.setCelular(Integer.parseInt(rs.getString(4)));
               this.setTelefono(Integer.parseInt(rs.getString(5)));
               this.setLegajo(Integer.parseInt(rs.getString(6)));
               this.setDni(Integer.parseInt(rs.getString(7)));
//this.setFechaSql(rs.getString(4));
               ps.close();               
            }
            else {
                JOptionPane.showMessageDialog(null, "No se encuentra el dni, intente en otro momento");
            }            
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al intentar acceder a los datos del paciente");             
            return false;    
        }
        return true;  
    }
     
    public boolean BuscarApyn(int dni) {
        
        
        String Str_sql="select nombre, apellido from medico where doc = '"+ dni +"';";
        try {
            ps = con.conectar().prepareStatement(Str_sql);
            rs = ps.executeQuery();
            if (rs.next()) {
               this.setNombre(rs.getString(1)); 
               this.setApellido(rs.getString(2));                             
               ps.close();
               
            }
            else {
                JOptionPane.showMessageDialog(null, "No se encuentra el apellido, intente en otro momento");
                return false;
            }
            
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al intentar acceder a los datos del médico");             
            return false;    
        }
        return true;  
    } 
    
    public boolean buscarLegajo(int dni) {
        String str_sql="select legajo from paciente where doc = '"+ dni +"';";
         try {
            con = new Conexion();
            ps = con.conectar().prepareStatement(str_sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                
                this.setLegajo(Integer.parseInt(rs.getString(1)));
                //menuMensaje(this.getLegajo());
                return true;
            }
            else {
                JOptionPane.showMessageDialog(null,"Lo siento! No se pudo consultar su legajo, intente mas tarde.");
                return false;
            }
         
        }
        catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "Error con la base de datos al intentar buscar el legajo. Intente mas tarde.");
            return false;
        }
    }
    
    public boolean buscarNombre(int dni) {
        String Str_sql="select nombre, especialidad_idEspecialidad from medico where doc = '"+ dni +"';";
        try {
            ps = con.conectar().prepareStatement(Str_sql);
            rs = ps.executeQuery();
            if (rs.next()) {
               this.setNombre(rs.getString(1));
               this.setIdEspecialidad(Integer.parseInt(rs.getString(2)));
               buscarStringEspecialidad(Integer.parseInt(rs.getString(2)));
                ps.close();
               
            }
            
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al intentar acceder al nombre");             
            return false;    
        }
        return true;  
    }
    
    public void buscarStringEspecialidad(int id) {
        String str_sql="SELECT nombre FROM especialidad where idEspecialidad = '"+ id +"';";
        try {
            con = new Conexion();
            ps = con.conectar().prepareStatement(str_sql);
            rs = ps.executeQuery();
            if (rs.next()) {
               // this.setIdEspecialidad(Integer.parseInt(rs.getString(1))); //int
               this.setEspecialidad(rs.getString(1));
            }
            else {
               
                
            }
         
        }
        catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "Error con la base de datos al intentar buscar la especialidad. Intente mas tarde.");
            
        }
         
    }
    
    public boolean buscarEspecialidad(String especialidad ) {
        String str_sql="SELECT idEspecialidad FROM especialidad where nombre = '"+ especialidad +"';";
         try {
            con = new Conexion();
            ps = con.conectar().prepareStatement(str_sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                this.setIdEspecialidad(Integer.parseInt(rs.getString(1))); //int
            }
            else {
               
                return false;
            }
         
        }
        catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "Error con la base de datos al intentar buscar la especialidad. Intente mas tarde.");
            return false;
        }
         return true;
    }
    
    public void insertarMedico(String Str_sql) {
        try {
            ps = con.conectar().prepareStatement(Str_sql);
            
            ps.setInt(1, this.getDni());
            ps.setString(2, this.getContrasenia());
            ps.setString(3, this.getNombre());
            ps.setString(4, this.getApellido());
            ps.setString(5, String.valueOf(this.getSexo()));
            ps.setDate(6, this.getFechaSql());
            ps.setString(7, this.getLocalidad());
            ps.setString(8, this.getDireccion());
            ps.setInt(9, this.getEstadoCivil());
            ps.setInt(10, this.getTelefono());
            ps.setInt(11, this.getCelular());
            ps.setInt(12, this.getPregunta());
            ps.setString(13, this.getRespuesta());
            ps.setString(14, this.getMatricula());
            //System.out.println("desde func: " + this.getIdEspecialidad());
            ps.setInt(15, this.getIdEspecialidad());
            registro = ps.executeUpdate();
            
             if (registro > 0) {
                JOptionPane.showMessageDialog(null, "Se registró exitosamente el personal medico en nuestra base de datos");
                ps.close();

            } else {
                JOptionPane.showMessageDialog(null, "No se pudo registrar personal medico, intente mas tarde");
               
            }
            
        }
        catch (SQLException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, "Error en la base de datos al intentar registrar medico, intente mas tarde. " + ex);
        }
        
    }    
    
    public void registrarFicha(String Str_sql) {
        try {
            ps = con.conectar().prepareStatement(Str_sql);
            
            ps.setDate(1, this.getFechaSql());
            
            ps.setString(2, this.getEnfermedad());
            ps.setString(3, this.getApyn());
            ps.setString(4, this.getDescripAntecPaciente() );
            
            ps.setInt(5, this.getAntecFliar());
            
            ps.setString(6, this.getDescripAntecFliar());
            ps.setString(7, this.getSubjetivo());
            ps.setString(8, this.getObjetivo());
            ps.setString(9, this.getAnalisis());
            ps.setString(10, this.getTratamFarmac());
            ps.setString(11, this.getTratamNOfarmac());
            ps.setString(12, this.getAlarma());
            
            ps.setInt(13, this.getDni());
            ps.setInt(14, this.getLegajo());
            
            ps.setString(15, this.getEspecialidad());
            
            registro = ps.executeUpdate();
            
             if (registro > 0) {
                JOptionPane.showMessageDialog(null, "Se registró exitosamente la ficha médica");
                ps.close();

            } else {
                JOptionPane.showMessageDialog(null, "No se pudo registrar la ficha médica, intente mas tarde");
               
            }
        }
        catch (Exception ex) {
             System.out.println(ex);
            JOptionPane.showMessageDialog(null, "Error en la base de datos al intentar registrar la ficha mécia, intente mas tarde. " + ex);
        }
    }
//logica.ConsultarHistoria(logica.getLegajo(), logica.getEspecialidad(), dniMedico);
   public boolean ConsultarHistoria(int legajo, String especialidad, int dniMedico ) {
        String str_sql="SELECT enfermedad, medico, feAtención FROM fichamedica where Paciente_legajo = '"+ legajo +"' and Especilidad = '"+ especialidad +"' and Medico_doc = '"+ dniMedico +"';";
         try {
            con = new Conexion();
            ps = con.conectar().prepareStatement(str_sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                //this.setIdEspecialidad(Integer.parseInt(rs.getString(1))); //int
                this.setEnfermedad(rs.getString(1));
                this.setApyn(rs.getString(2));                
                this.setFechaSql(java.sql.Date.valueOf(rs.getString(3)));
                
            }
            else {
               
                return false;
            }
         
        }
        catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "Error con la base de datos al intentar buscar la especialidad. Intente mas tarde.");
            return false;
        }
         return true;
    }
   
   public boolean ConsultarEnfermedad(int legajo, String enfermedad, java.sql.Date feAtencion ) {
//       System.out.println(legajo);
//       System.out.println(enfermedad);
//       System.out.println(feAtencion);
       String str_sql="SELECT * FROM fichamedica where Paciente_legajo = '"+ legajo +"' and enfermedad = '"+ enfermedad +"' and feAtención = '"+ feAtencion +"';";
         try {
            con = new Conexion();
            ps = con.conectar().prepareStatement(str_sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                System.out.println("entre");
               this.setFechaSql(java.sql.Date.valueOf(rs.getString(2)));
               this.setEnfermedad(rs.getString(3));               
               this.setApyn(rs.getString(4));
               
               this.setDescripAntecPaciente(rs.getString(5));               
               this.setAntecFliar(Integer.parseInt(rs.getString(6)));
               this.setDescripAntecFliar(rs.getString(7));
               
               this.setSubjetivo(rs.getString(8));
               this.setObjetivo(rs.getString(9));
               this.setAnalisis(rs.getString(10));
               
               this.setTratamFarmac(rs.getString(11));
               this.setTratamNOfarmac(rs.getString(12));
               this.setAlarma(rs.getString(13));                             
                
            }
            else {
               JOptionPane.showMessageDialog(null, "No se pudo consultar la ficha clinica del paciente. Intente mas tarde");
                return false;
            }
         
        }
        catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "Error con la base de datos al intentar buscar la ficha clinica del paciente.");
            return false;
        }
         return true;
    }
   
    public boolean ConsultarIdFicha(int legajo, String enfermedad, java.sql.Date feAtencion ) {
//       System.out.println(legajo);
//       System.out.println(enfermedad);
//       System.out.println(feAtencion);
       String str_sql="SELECT idFichaMedica FROM fichamedica where Paciente_legajo = '"+ legajo +"' and enfermedad = '"+ enfermedad +"' and feAtención = '"+ feAtencion +"';";
         try { 
            con = new Conexion();
            ps = con.conectar().prepareStatement(str_sql);
            rs = ps.executeQuery();
            if (rs.next()) {
               // System.out.println("entre");
               this.setNroFicha(Integer.parseInt(rs.getString(1)));
              // this.setAntecFliar(Integer.parseInt(rs.getString(6)));
                
            }
            else {
               JOptionPane.showMessageDialog(null, "No se pudo consultar la ficha clinica del paciente. Intente mas tarde");
                return false;
            }
         
        }
        catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "Error con la base de datos al intentar buscar la ficha clinica del paciente.");
            return false;
        }
         return true;
    }
    public void actualizarMedico(int doc, String pass, String nom, String ape, char sex, java.sql.Date fe, String loc, String dire, int civil, int tel, int celu, int ask, String rta, String matriccula, int id) {
        System.out.println("NOM: " + nom);
                  //  public void actualizarMedico(int doc, String pass, String nom, String ape, char sex, java.sql.Date fe, String loc,                                          String dire, int civil, int tel,                                                        int celu, int ask, String rta, String matriccula, String id)    
        String Str_sql="UPDATE medico SET  contrasenia = '"+ pass +"' , nombre = '"+ nom +"' , apellido = '"+ ape +"', sexo = '"+ sex +"' , feNacimiento = '"+ fe +"' , localidad = '"+ loc +"' , dire = '"+ dire +"' , civil = '"+ civil +"', tel = '"+ tel +"', cel = '"+ celu +"' , pregunta = '"+ ask +"', respuesta = '"+ rta +"', matricula = '"+ matriccula +"', especialidad_idEspecialidad = '"+ id +"'  WHERE doc = '"+ doc +"';"; 
        try {
            ps = con.conectar().prepareStatement(Str_sql);
            registro = ps.executeUpdate();
             if (registro > 0) {
                JOptionPane.showMessageDialog(null, "Se actualizó exitosamente el médico en nuestra base de datos");
                ps.close();

            } else {
                JOptionPane.showMessageDialog(null, "No se pudo actualizar los datos del médico, intente mas tarde");
               
            }
            
        } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al intentar acceder a la bd para actualizar médico" + ex);     
                System.out.println(ex);
        }            
    }
    
    public void actualizarFicha(java.sql.Date fe, String enfermedad, String medico, String descAntecPaciente, int antecFliar, String DescAntecFliar, String sub, String obj, String ana, String trat, String noTrat, String alarma, int idFicha) {
        //System.out.println("NOM: " + nom);
          // void actualizarFicha(java.sql.Date fe, String enfermedad, String medico,                                                       String descAntecPaciente, int antecFliar,                           String DescAntecFliar,                              String sub, String obj, String ana,                                 String trat, String noTrat,                                 String alarma,       int medicoDoc,                         int leg,        String esp)     
        String Str_sql="UPDATE fichamedica SET  feAtención = '"+ fe +"', enfermedad = '"+ enfermedad +"', medico = '"+ medico +"', descAntecPaciente = '"+ descAntecPaciente +"', antecFliar = '"+ antecFliar +"', DescAntecFliar = '"+ DescAntecFliar +"', subjetiva = '"+ sub +"', objetiva = '"+ obj +"', analisis = '"+ ana +"', trataFarm = '"+ trat +"', trataNoFarm = '"+ noTrat +"', alarma = '"+ alarma +"' WHERE idFichaMedica = '"+ idFicha +"';"; 
        try {
            ps = con.conectar().prepareStatement(Str_sql);
            registro = ps.executeUpdate();
             if (registro > 0) {
                JOptionPane.showMessageDialog(null, "Se actualizó exitosamente la ficha médica en nuestra base de datos");
                ps.close();

            } else {
                JOptionPane.showMessageDialog(null, "No se pudo actualizar los datos de la ficha médica, intente mas tarde");
                
            }
            
        } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al intentar acceder a la bd para actualizar la ficha médica" + ex);     
                System.out.println(ex);
        }            
    }
}

