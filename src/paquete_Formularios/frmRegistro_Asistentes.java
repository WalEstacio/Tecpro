
package paquete_Formularios;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import paquete_Clases.Asistente;

public class frmRegistro_Asistentes extends javax.swing.JInternalFrame {
    
    TableRowSorter trs;
    TableRowSorter trs_2;
    TableRowSorter trs_3;
    TableRowSorter trs_4;
    TableRowSorter trs_5;
    TableRowSorter trs_6;    
    TableRowSorter trs_7;
    TableRowSorter trs_8;
    
    Asistente objeto_Asistente = new Asistente();
    
    DefaultTableModel modelo_Asistente = new DefaultTableModel();
    DefaultTableModel modelo_Area = new DefaultTableModel();
    DefaultTableModel modelo_Nivel = new DefaultTableModel();
    
    private void agregar_Columnas_Tabla_Asistente(){
        modelo_Asistente.addColumn("Código");
        modelo_Asistente.addColumn("Fecha"); //1
        modelo_Asistente.addColumn("Nombres Y Apellidos");
        modelo_Asistente.addColumn("Correo Electrónico");
        modelo_Asistente.addColumn("Teléfono");
        modelo_Asistente.addColumn("Área");
        modelo_Asistente.addColumn("Nivel");
        tblAsistente.setModel(modelo_Asistente);
    }
    private void agregar_Columnas_Tabla_Area(){
        modelo_Area.addColumn("Código");
        modelo_Area.addColumn("Fecha De Creación");
        modelo_Area.addColumn("Área");
        tblArea.setModel(modelo_Area);
    }
    private void agregar_Columnas_Tabla_Nivel(){
        modelo_Nivel.addColumn("Código");
        modelo_Nivel.addColumn("Fecha De Creación");
        modelo_Nivel.addColumn("Nivel");
        tblNivel.setModel(modelo_Nivel);
    }
    
    private void registrar_Asistente(){
        
        int valor = JOptionPane.showConfirmDialog(this, "¿Desea registrar un nuevo asistente?", "Mensaje", JOptionPane.YES_NO_OPTION);
        if(valor == JOptionPane.YES_OPTION){
            btnRegistrar_Asistente.setEnabled(false);
            txtNombres_Y_Apellidos_Asistente.setEnabled(true);
            txtCorreo_Asistente.setEnabled(true);
            txtTelefono_Asistente.setEnabled(true);
            txtArea_Asistente.setEnabled(true);
            txtNivel_Asistente.setEnabled(true);
            btnElegir_Area.setEnabled(true);
            btnElegir_Nivel.setEnabled(true);
            btnCancelar.setEnabled(true);
            txtBuscador_Area.setEnabled(true);
            txtBuscador_Nivel.setEnabled(true);
            btnLimpiar.setEnabled(true);
            btnGuardar_Datos.setEnabled(true);
        }  
    }
    private void guardar_Datos_Asistente(){
        grabar_Datos_De_Controles_En_Fichero_Asistentes();
        txtNombres_Y_Apellidos_Asistente.setEnabled(false);
        txtCorreo_Asistente.setEnabled(false);
        txtTelefono_Asistente.setEnabled(false);
        txtArea_Asistente.setEnabled(false);
        txtNivel_Asistente.setEnabled(false);
        btnElegir_Nivel.setEnabled(false);
        btnCancelar.setEnabled(false);
        btnElegir_Area.setEnabled(false);
        btnLimpiar.setEnabled(false);
        btnRegistrar_Asistente.setEnabled(true);
        btnGuardar_Datos.setEnabled(false);
        txtBuscador_Area.setEnabled(false);
        txtBuscador_Nivel.setEnabled(false);
        txtNombres_Y_Apellidos_Asistente.setText(null);
        txtCorreo_Asistente.setText(null);
        txtTelefono_Asistente.setText(null);
        txtArea_Asistente.setText(null);
        txtNivel_Asistente.setText(null);                
    }
    private void grabar_Datos_De_Controles_En_Fichero_Asistentes(){
          
        FileWriter fw=null;
        PrintWriter pw=null;
        
        try{
            
            fw = new FileWriter("src\\paquete_Ficheros\\Asistentes.txt", true);
            pw = new PrintWriter(fw);

            objeto_Asistente.setNombres_Y_Apellidos_Asistente(txtNombres_Y_Apellidos_Asistente.getText());
            objeto_Asistente.setCorreo_Asistente(txtCorreo_Asistente.getText());
            objeto_Asistente.setTelefono_Asistente(txtTelefono_Asistente.getText());
            objeto_Asistente.setArea_Asistente(txtArea_Asistente.getText());
            objeto_Asistente.setNivel_Asistente(txtNivel_Asistente.getText());
            
            pw.println(objeto_Asistente.codigo_Asistente() + ";" + objeto_Asistente.fecha_Asistente() + ";" + objeto_Asistente.getNombres_Y_Apellidos_Asistente() + ";" +
            objeto_Asistente.getCorreo_Asistente() + ";" + objeto_Asistente.getTelefono_Asistente() + ";" + objeto_Asistente.getArea_Asistente() + ";" + objeto_Asistente.getNivel_Asistente());
 
            pw.close();
            
            cargar_Datos_De_Controles_En_Tabla_Asistente();
        
        }catch(Exception ex){
            
            JOptionPane.showMessageDialog(null, ex.getMessage());    
        }
    }
    private void cargar_Datos_De_Controles_En_Tabla_Asistente(){
        
        Object [] fila = new Object[7];
        
        fila[0] = objeto_Asistente.codigo_Asistente();
        fila[1] = objeto_Asistente.fecha_Asistente();
        fila[2] = objeto_Asistente.getNombres_Y_Apellidos_Asistente();
        fila[3] = objeto_Asistente.getCorreo_Asistente();
        fila[4] = objeto_Asistente.getTelefono_Asistente();
        fila[5] = objeto_Asistente.getArea_Asistente();
        fila[6] = objeto_Asistente.getNivel_Asistente();
 
        modelo_Asistente.addRow(fila); 
    }  
    
    private void eliminar_Asistente(){
        
        int seleccion = tblAsistente.getSelectedRow();
        
        if(seleccion == 0 || seleccion == 1 || seleccion == 2 || seleccion == 3 || seleccion == 4 || seleccion == 5 || seleccion ==  6 || seleccion == 7 || seleccion == 8 || seleccion == 9 || seleccion == 10){       
         
            int valor = JOptionPane.showConfirmDialog(this, "¿Está seguro que lo desea eliminar?", "Mensaje", JOptionPane.YES_NO_OPTION);
          
            if(valor == JOptionPane.YES_OPTION){
              
                eliminar_Fichero_Asistentes();
                crear_Fichero_Asistentes();
                modelo_Asistente.removeRow(seleccion);   
                mostrar_Registros_De_Tabla_Asistente_En_Fichero_Asistentes();
            }
            
        }else{            
            JOptionPane.showMessageDialog(null, "¡No ha seleccionado un asistente!");
        }
    }
    private void eliminar_Fichero_Asistentes(){   
        File archivo = new File("src/paquete_Ficheros/Asistentes.txt");        
        archivo.delete();
    }
    private void crear_Fichero_Asistentes(){
        
        FileWriter fw=null;
        PrintWriter pw=null;
        
        try{
         
            fw = new FileWriter("src\\paquete_Ficheros\\Asistentes.txt", true);
            pw = new PrintWriter(fw);
        
        }catch(Exception ex){
            
            JOptionPane.showMessageDialog(null, ex.getMessage());    
        }
    } 
    private void mostrar_Registros_De_Tabla_Asistente_En_Fichero_Asistentes(){
        
        FileWriter fw=null;
        PrintWriter pw=null;
        
        try{
         
            fw = new FileWriter("src\\paquete_Ficheros\\Asistentes.txt", true);
            pw = new PrintWriter(fw);
        
            for(int i=0; i<tblAsistente.getRowCount(); i++){
            
            pw.println(String.valueOf(tblAsistente.getValueAt(i, 0)) + ";" +
                    String.valueOf(tblAsistente.getValueAt(i, 1)) + ";" +
                    String.valueOf(tblAsistente.getValueAt(i, 2)) + ";" +
                    String.valueOf(tblAsistente.getValueAt(i, 3)) + ";" +
                    String.valueOf(tblAsistente.getValueAt(i, 4)) + ";" +
                    String.valueOf(tblAsistente.getValueAt(i, 5)) + ";" +
                    String.valueOf(tblAsistente.getValueAt(i, 6)));          
            }
        
            pw.close();
        
        }catch(Exception ex){
            
            JOptionPane.showMessageDialog(null, ex.getMessage());    
        }   
    }
    
    private void mostrar_Registro_De_Fichero_Asistentes_En_Tabla_Asistente(){
        
        try{
            File archivo = new File("src/paquete_Ficheros/Asistentes.txt");
            
            if(archivo.exists()){
                
                FileReader reader = new FileReader(archivo);
                BufferedReader br = new BufferedReader(reader);
                
                String linea;
                
                while((linea = br.readLine()) != null){
                
                StringTokenizer token = new StringTokenizer(linea, ";");
                
                String codigo_Asistente = token.nextToken().trim();
                String fecha_Asistente = token.nextToken().trim();
                String nombres_Y_Apellidos_Asistente = token.nextToken().trim();
                String correo_Asistente = token.nextToken().trim();
                String telefono_Asistente = token.nextToken().trim();
                String area_Asistente = token.nextToken().trim();
                String nivel_Asistente = token.nextToken().trim();
                
                Object[] obj = new Object[]{
                    
                    codigo_Asistente, fecha_Asistente, nombres_Y_Apellidos_Asistente, correo_Asistente, telefono_Asistente, area_Asistente, nivel_Asistente
                };
                        
                modelo_Asistente.addRow(obj);
            }
                
            br.close();
            }
            else
                JOptionPane.showMessageDialog(null, "No se encuentra el archivo: " + archivo.getName());
        }
        catch (IOException ex) {
            System.out.println("Error al leer el archivo: " + ex.getMessage());
        }
    }
    private void mostrar_Registro_De_Fichero_Areas_En_Tabla_Area(){
        
        try{
            File archivo = new File("src/paquete_Ficheros/Areas.txt");
            
            if(archivo.exists()){
                
                FileReader reader = new FileReader(archivo);
                BufferedReader br = new BufferedReader(reader);
                
                String linea;
                
                while((linea = br.readLine()) != null){
                
                StringTokenizer token = new StringTokenizer(linea, ";");
                
                String codigo = token.nextToken().trim();
                String fecha = token.nextToken().trim();
                String area = token.nextToken().trim();
                
                Object[] obj = new Object[]{
                    
                    codigo, fecha, area
                };
                        
                modelo_Area.addRow(obj);
            }
                
            br.close();
            }
            else
                JOptionPane.showMessageDialog(null, "No se encuentra el archivo: " + archivo.getName());
        }
        catch (IOException ex) {
            System.out.println("Error al leer el archivo: " + ex.getMessage());
        }
    }
    private void mostrar_Registro_De_Fichero_Niveles_En_Tabla_Nivel(){
        
        try{
            File archivo = new File("src/paquete_Ficheros/Niveles.txt");
            
            if(archivo.exists()){
                
                FileReader reader = new FileReader(archivo);
                BufferedReader br = new BufferedReader(reader);
                
                String linea;
                
                while((linea = br.readLine()) != null){
                
                StringTokenizer token = new StringTokenizer(linea, ";");
                
                String codigo = token.nextToken().trim();
                String fecha = token.nextToken().trim();
                String nivel = token.nextToken().trim();
                
                Object[] obj = new Object[]{
                    
                    codigo, fecha, nivel
                };
                        
                modelo_Nivel.addRow(obj);
            }
                
            br.close();
            }
            else
                JOptionPane.showMessageDialog(null, "No se encuentra el archivo: " + archivo.getName());
        }
        catch (IOException ex) {
            System.out.println("Error al leer el archivo: " + ex.getMessage());
        }
    }
    
    private void elegir_Area(){
        
        int seleccion = tblArea.getSelectedRow();
        
        if(seleccion == 0 || seleccion == 1 || seleccion == 2 || seleccion == 3 || seleccion == 4 || seleccion == 5 || seleccion ==  6 || seleccion == 7 || seleccion == 8 || seleccion == 9 || seleccion == 10){
            
            int valor = JOptionPane.showConfirmDialog(this, "¿Está seguro que lo desea elegir?", "Mensaje", JOptionPane.YES_NO_OPTION);
            
            if(valor == JOptionPane.YES_OPTION){
                
                txtArea_Asistente.setText(String.valueOf(tblArea.getValueAt(seleccion, 2)));
            }
            
        }else{
            JOptionPane.showMessageDialog(null, "¡No ha seleccionado un área!");
        }      
        
    }
    private void elegir_Nivel(){
        
        int seleccion = tblNivel.getSelectedRow();
        
        if(seleccion == 0 || seleccion == 1 || seleccion == 2 || seleccion == 3 || seleccion == 4 || seleccion == 5 || seleccion ==  6 || seleccion == 7 || seleccion == 8 || seleccion == 9 || seleccion == 10){
            
            int valor = JOptionPane.showConfirmDialog(this, "¿Está seguro que lo desea elegir?", "Mensaje", JOptionPane.YES_NO_OPTION);
            
            if(valor == JOptionPane.YES_OPTION){
                
                txtNivel_Asistente.setText(String.valueOf(tblNivel.getValueAt(seleccion, 2)));
            }
            
        }else{
            JOptionPane.showMessageDialog(null, "¡No ha seleccionado un área!");
        }   

    }
    
    private void limpiar_Buscadores(){
        txtBuscador_Codigo.setText(null);
        txtBuscador_Nombres_Y_Apellidos_Asistente.setText(null);
        txtBuscador_Correo_Asistente.setText(null);
        txtBuscador_Telefono_Asistente.setText(null);
        txtBuscador_Area_Asistente.setText(null);
        txtBuscador_Nivel_Asistente.setText(null);
    }
    
    private void limpiar(){
        txtNombres_Y_Apellidos_Asistente.setText(null);
        txtCorreo_Asistente.setText(null);
        txtTelefono_Asistente.setText(null);
        txtArea_Asistente.setText(null);
        txtNivel_Asistente.setText(null);
    }
    
    private void limpiar_Dos_Ultimos_Buscadores(){
        txtBuscador_Area.setText(null);
        txtBuscador_Nivel.setText(null);
    }
    
    private void cerrar(){  
        int valor = JOptionPane.showConfirmDialog(this, "¿Está seguro que lo desea cerrar?", "Mensaje", JOptionPane.YES_NO_OPTION);
        if(valor == JOptionPane.YES_OPTION){
            this.setVisible(false);
        }      
    }
    
    private void modificar_Asistente(){
        
        int seleccion = tblAsistente.getSelectedRow();
        
        if(seleccion == 0 || seleccion == 1 || seleccion == 2 || seleccion == 3 || seleccion == 4 || seleccion == 5 || seleccion ==  6 || seleccion == 7 || seleccion == 8 || seleccion == 9 || seleccion == 10){
            
            int valor = JOptionPane.showConfirmDialog(this, "¿Está seguro que lo desea modificar?", "Mensaje", JOptionPane.YES_NO_OPTION);
            
            if(valor == JOptionPane.YES_OPTION){
                
                txtNombres_Y_Apellidos_Asistente.setText(String.valueOf(tblAsistente.getValueAt(seleccion, 2)));
                txtCorreo_Asistente.setText(String.valueOf(tblAsistente.getValueAt(seleccion, 3)));
                txtTelefono_Asistente.setText(String.valueOf(tblAsistente.getValueAt(seleccion, 4)));
                txtArea_Asistente.setText(String.valueOf(tblAsistente.getValueAt(seleccion, 5)));
                txtNivel_Asistente.setText(String.valueOf(tblAsistente.getValueAt(seleccion, 6)));
                
                btnModificar_Asistente.setEnabled(false);
                btnEliminar_Asistente.setEnabled(false);
                
                txtNombres_Y_Apellidos_Asistente.setEnabled(true);
                txtCorreo_Asistente.setEnabled(true);
                txtTelefono_Asistente.setEnabled(true);
                txtArea_Asistente.setEnabled(true);
                txtNivel_Asistente.setEnabled(true);
                
                btnElegir_Area.setEnabled(true);
                btnElegir_Nivel.setEnabled(true);
                btnGuardar_Datos.setEnabled(true);
        
                modelo_Asistente.removeRow(seleccion);   
                mostrar_Registros_De_Tabla_Asistente_En_Fichero_Asistentes();
            }
            
        }else{
            JOptionPane.showMessageDialog(null, "¡No ha seleccionado un asistente!");
        }
        
    }
    
    private void cancelar(){
        int valor = JOptionPane.showConfirmDialog(this, "¿Está seguro que lo desea cancelar?", "Mensaje", JOptionPane.YES_NO_OPTION);
        if(valor == JOptionPane.YES_OPTION){
            txtNombres_Y_Apellidos_Asistente.setText(null);
            txtCorreo_Asistente.setText(null);
            txtTelefono_Asistente.setText(null);
            txtArea_Asistente.setText(null);
            txtNivel_Asistente.setText(null);
            txtBuscador_Area.setEnabled(false);
            txtBuscador_Nivel.setEnabled(false);
            
            txtNombres_Y_Apellidos_Asistente.setEnabled(false);
            txtCorreo_Asistente.setEnabled(false);
            txtTelefono_Asistente.setEnabled(false);
            txtArea_Asistente.setEnabled(false);
            txtNivel_Asistente.setEnabled(false);
            btnElegir_Area.setEnabled(false);
            btnElegir_Nivel.setEnabled(false);
            btnGuardar_Datos.setEnabled(false);
            
            btnModificar_Asistente.setEnabled(true);
            btnRegistrar_Asistente.setEnabled(true);
            btnEliminar_Asistente.setEnabled(true);
            btnLimpiar.setEnabled(false);
        }  
    }
    
    public frmRegistro_Asistentes() {
        initComponents();
        
        agregar_Columnas_Tabla_Asistente();
        agregar_Columnas_Tabla_Area();
        agregar_Columnas_Tabla_Nivel();
        
        txtNombres_Y_Apellidos_Asistente.setEnabled(false);
        txtCorreo_Asistente.setEnabled(false);
        txtTelefono_Asistente.setEnabled(false);
        txtArea_Asistente.setEnabled(false);
        txtNivel_Asistente.setEnabled(false);
        
        txtArea_Asistente.setEditable(false);
        txtNivel_Asistente.setEditable(false);
        
        txtBuscador_Area.setEnabled(false);
        txtBuscador_Nivel.setEnabled(false);
        
        btnElegir_Area.setEnabled(false);
        btnElegir_Nivel.setEnabled(false);
        btnGuardar_Datos.setEnabled(false);
        btnCancelar.setEnabled(false);
        btnLimpiar.setEnabled(false);
        
        mostrar_Registro_De_Fichero_Asistentes_En_Tabla_Asistente();
        mostrar_Registro_De_Fichero_Areas_En_Tabla_Area();
        mostrar_Registro_De_Fichero_Niveles_En_Tabla_Nivel();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAsistente = new javax.swing.JTable();
        btnEliminar_Asistente = new javax.swing.JButton();
        btnModificar_Asistente = new javax.swing.JButton();
        btnRegistrar_Asistente = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        txtNombres_Y_Apellidos_Asistente = new javax.swing.JTextField();
        txtCorreo_Asistente = new javax.swing.JTextField();
        txtTelefono_Asistente = new javax.swing.JTextField();
        jScrollPane11 = new javax.swing.JScrollPane();
        tblArea = new javax.swing.JTable();
        txtArea_Asistente = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        btnElegir_Area = new javax.swing.JButton();
        btnGuardar_Datos = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblNivel = new javax.swing.JTable();
        btnElegir_Nivel = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtNivel_Asistente = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtBuscador_Area = new javax.swing.JTextField();
        txtBuscador_Nivel = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtBuscador_Codigo = new javax.swing.JTextField();
        txtBuscador_Correo_Asistente = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtBuscador_Telefono_Asistente = new javax.swing.JTextField();
        txtBuscador_Nombres_Y_Apellidos_Asistente = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtBuscador_Area_Asistente = new javax.swing.JTextField();
        txtBuscador_Nivel_Asistente = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();

        tblAsistente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblAsistente);

        btnEliminar_Asistente.setText("Eliminar Asistente");
        btnEliminar_Asistente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminar_AsistenteActionPerformed(evt);
            }
        });

        btnModificar_Asistente.setText("Modificar Asistente");
        btnModificar_Asistente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificar_AsistenteActionPerformed(evt);
            }
        });

        btnRegistrar_Asistente.setText("Registrar Asistente");
        btnRegistrar_Asistente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrar_AsistenteActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Del Asistente De Soporte Técnico"));

        jLabel21.setText("Nombres Y Apellidos Del Asistente De Soporte Técnico:");

        jLabel22.setText("Correo Electrónico Del Asistente De Soporte Técnico:");

        jLabel23.setText("Teléfono Del Asistente De Soporte Técnico:");

        jLabel24.setText("Área Del Asistente De Soporte Técnico:");

        txtNombres_Y_Apellidos_Asistente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombres_Y_Apellidos_AsistenteKeyTyped(evt);
            }
        });

        txtCorreo_Asistente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCorreo_AsistenteKeyTyped(evt);
            }
        });

        txtTelefono_Asistente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefono_AsistenteKeyTyped(evt);
            }
        });

        tblArea.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane11.setViewportView(tblArea);

        txtArea_Asistente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtArea_AsistenteKeyTyped(evt);
            }
        });

        jLabel25.setText("Elija un área:");

        btnElegir_Area.setText("Elegir Area");
        btnElegir_Area.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnElegir_AreaActionPerformed(evt);
            }
        });

        btnGuardar_Datos.setText("Guardar Datos");
        btnGuardar_Datos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardar_DatosActionPerformed(evt);
            }
        });

        jLabel26.setText("Elija un nivel:");

        tblNivel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tblNivel);

        btnElegir_Nivel.setText("Elegir Nivel");
        btnElegir_Nivel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnElegir_NivelActionPerformed(evt);
            }
        });

        jLabel1.setText("Nivel Del Asistente De Soporte Técnico:");

        txtNivel_Asistente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNivel_AsistenteKeyTyped(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        jLabel8.setText("Área:");

        txtBuscador_Area.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscador_AreaKeyTyped(evt);
            }
        });

        txtBuscador_Nivel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscador_NivelKeyTyped(evt);
            }
        });

        jLabel9.setText("Nivel:");

        jButton1.setText("Limpiar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21)
                    .addComponent(jLabel22)
                    .addComponent(jLabel23)
                    .addComponent(jLabel24)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTelefono_Asistente, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                    .addComponent(txtCorreo_Asistente, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                    .addComponent(txtArea_Asistente, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                    .addComponent(txtNombres_Y_Apellidos_Asistente, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                    .addComponent(txtNivel_Asistente))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel25)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(btnLimpiar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnElegir_Area))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtBuscador_Area, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnElegir_Nivel)
                            .addComponent(btnGuardar_Datos))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel26)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel9)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtBuscador_Nivel, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCancelar)
                            .addContainerGap())
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel21)
                                    .addComponent(txtNombres_Y_Apellidos_Asistente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(btnCancelar))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtBuscador_Area, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(txtBuscador_Nivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel25)
                            .addComponent(jLabel26))
                        .addGap(9, 9, 9)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(txtCorreo_Asistente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23)
                            .addComponent(txtTelefono_Asistente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtArea_Asistente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel24))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNivel_Asistente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(btnLimpiar))
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                            .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(7, 7, 7)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnElegir_Area)
                            .addComponent(btnElegir_Nivel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGuardar_Datos))))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("Filtros")));

        jLabel2.setText("Código:");

        jLabel3.setText("Nombres Y Apellidos Del Asistente:");

        txtBuscador_Codigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscador_CodigoKeyTyped(evt);
            }
        });

        txtBuscador_Correo_Asistente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscador_Correo_AsistenteKeyTyped(evt);
            }
        });

        jLabel4.setText("Correo Electrónico Del Asistente:");

        jLabel5.setText("Teléfono Del Asistente:");

        txtBuscador_Telefono_Asistente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscador_Telefono_AsistenteKeyTyped(evt);
            }
        });

        txtBuscador_Nombres_Y_Apellidos_Asistente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscador_Nombres_Y_Apellidos_AsistenteKeyTyped(evt);
            }
        });

        jLabel6.setText("Área Del Asistente:");

        jLabel7.setText("Nivel Del Asistente:");

        txtBuscador_Area_Asistente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscador_Area_AsistenteKeyTyped(evt);
            }
        });

        txtBuscador_Nivel_Asistente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscador_Nivel_AsistenteKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtBuscador_Nombres_Y_Apellidos_Asistente)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtBuscador_Codigo))
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtBuscador_Telefono_Asistente, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                    .addComponent(txtBuscador_Correo_Asistente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscador_Area_Asistente, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscador_Nivel_Asistente)))
                .addGap(54, 54, 54))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtBuscador_Codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtBuscador_Correo_Asistente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtBuscador_Area_Asistente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(txtBuscador_Telefono_Asistente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtBuscador_Nivel_Asistente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtBuscador_Nombres_Y_Apellidos_Asistente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jButton6.setText("Limpiar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton8.setText("Cerrar");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btnModificar_Asistente)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnEliminar_Asistente))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jButton6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton8))))
                            .addComponent(btnRegistrar_Asistente))
                        .addGap(0, 24, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton6)
                            .addComponent(jButton8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnEliminar_Asistente)
                            .addComponent(btnModificar_Asistente)))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRegistrar_Asistente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //jButton [Elegir Area]
    private void btnElegir_AreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnElegir_AreaActionPerformed
        elegir_Area();
    }//GEN-LAST:event_btnElegir_AreaActionPerformed

    //jButton [Registrar Asistente]
    private void btnRegistrar_AsistenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrar_AsistenteActionPerformed
        registrar_Asistente();
    }//GEN-LAST:event_btnRegistrar_AsistenteActionPerformed

    //jButton [Guardar Datos]
    private void btnGuardar_DatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardar_DatosActionPerformed
        
        
        if(txtNombres_Y_Apellidos_Asistente.getText().trim().isEmpty() && txtCorreo_Asistente.getText().trim().isEmpty() && txtTelefono_Asistente.getText().trim().isEmpty() && txtArea_Asistente.getText().trim().isEmpty() && txtNivel_Asistente.getText().trim().isEmpty()){

            JOptionPane.showMessageDialog(null, "¡No ha llenado ningún  dato!");
            
        }else if(txtNombres_Y_Apellidos_Asistente.getText().trim().isEmpty()){

            JOptionPane.showMessageDialog(null, "Le falta llenar sus nombres y apellidos.");

        }else if(txtCorreo_Asistente.getText().trim().isEmpty()){

            JOptionPane.showMessageDialog(null, "Le falta llenar su correo.");

        }else if(txtTelefono_Asistente.getText().trim().isEmpty()){

            JOptionPane.showMessageDialog(null, "Le falta llenar su teléfono.");
        
        }else if(txtArea_Asistente.getText().trim().isEmpty()){

            JOptionPane.showMessageDialog(null, "Le falta llenar su área.");
        
        }else if(txtNivel_Asistente.getText().trim().isEmpty()){
            
            JOptionPane.showMessageDialog(null, "Le falta llenar su nivel.");
            
        }else{
            
            guardar_Datos_Asistente();
        }
    }//GEN-LAST:event_btnGuardar_DatosActionPerformed

    //jButton [Modificar Asistente]
    private void btnModificar_AsistenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificar_AsistenteActionPerformed
        modificar_Asistente();
    }//GEN-LAST:event_btnModificar_AsistenteActionPerformed

    //jButton [Eliminar Asistente]
    private void btnEliminar_AsistenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminar_AsistenteActionPerformed
        eliminar_Asistente();
    }//GEN-LAST:event_btnEliminar_AsistenteActionPerformed

    //jButton [Elegir Nivel]
    private void btnElegir_NivelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnElegir_NivelActionPerformed
        elegir_Nivel();
    }//GEN-LAST:event_btnElegir_NivelActionPerformed

    //JButton [Limpiar]
    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiar();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void txtBuscador_CodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscador_CodigoKeyTyped
        txtBuscador_Codigo.addKeyListener(new KeyAdapter() {
            
            @Override
            public void keyReleased(KeyEvent ke) {
                
                trs.setRowFilter(RowFilter.regexFilter("(?i)" + txtBuscador_Codigo.getText(), 0));
            }
        });
        
        trs = new TableRowSorter(modelo_Asistente);
        
        tblAsistente.setRowSorter(trs);
    }//GEN-LAST:event_txtBuscador_CodigoKeyTyped

    private void txtBuscador_Nombres_Y_Apellidos_AsistenteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscador_Nombres_Y_Apellidos_AsistenteKeyTyped
        txtBuscador_Nombres_Y_Apellidos_Asistente.addKeyListener(new KeyAdapter() {
            
            @Override
            public void keyReleased(KeyEvent ke) {
                
                trs_2.setRowFilter(RowFilter.regexFilter("(?i)" + txtBuscador_Nombres_Y_Apellidos_Asistente.getText(), 2));
            }
        });
        
        trs_2 = new TableRowSorter(modelo_Asistente);
        
        tblAsistente.setRowSorter(trs_2);
    }//GEN-LAST:event_txtBuscador_Nombres_Y_Apellidos_AsistenteKeyTyped

    private void txtBuscador_Correo_AsistenteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscador_Correo_AsistenteKeyTyped
        txtBuscador_Correo_Asistente.addKeyListener(new KeyAdapter() {
            
            @Override
            public void keyReleased(KeyEvent ke) {
                
                trs_3.setRowFilter(RowFilter.regexFilter("(?i)" + txtBuscador_Correo_Asistente.getText(), 3));
            }
        });
        
        trs_3 = new TableRowSorter(modelo_Asistente);
        
        tblAsistente.setRowSorter(trs_3);
    }//GEN-LAST:event_txtBuscador_Correo_AsistenteKeyTyped

    private void txtBuscador_Telefono_AsistenteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscador_Telefono_AsistenteKeyTyped
        txtBuscador_Telefono_Asistente.addKeyListener(new KeyAdapter() {
            
            @Override
            public void keyReleased(KeyEvent ke) {
                
                trs_4.setRowFilter(RowFilter.regexFilter("(?i)" + txtBuscador_Telefono_Asistente.getText(), 4));
            }
        });
        
        trs_4 = new TableRowSorter(modelo_Asistente);
        
        tblAsistente.setRowSorter(trs_4);
    }//GEN-LAST:event_txtBuscador_Telefono_AsistenteKeyTyped

    private void txtBuscador_Area_AsistenteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscador_Area_AsistenteKeyTyped
        txtBuscador_Area_Asistente.addKeyListener(new KeyAdapter() {
            
            @Override
            public void keyReleased(KeyEvent ke) {
                
                trs_5.setRowFilter(RowFilter.regexFilter("(?i)" + txtBuscador_Area_Asistente.getText(), 5));
            }
        });
        
        trs_5 = new TableRowSorter(modelo_Asistente);
        
        tblAsistente.setRowSorter(trs_5);
    }//GEN-LAST:event_txtBuscador_Area_AsistenteKeyTyped

    private void txtBuscador_Nivel_AsistenteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscador_Nivel_AsistenteKeyTyped
        txtBuscador_Nivel_Asistente.addKeyListener(new KeyAdapter() {
            
            @Override
            public void keyReleased(KeyEvent ke) {
                
                trs_6.setRowFilter(RowFilter.regexFilter("(?i)" + txtBuscador_Nivel_Asistente.getText(), 6));
            }
        });
        
        trs_6 = new TableRowSorter(modelo_Asistente);
        
        tblAsistente.setRowSorter(trs_6);
    }//GEN-LAST:event_txtBuscador_Nivel_AsistenteKeyTyped

    private void txtBuscador_AreaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscador_AreaKeyTyped
        txtBuscador_Area.addKeyListener(new KeyAdapter() {
            
            @Override
            public void keyReleased(KeyEvent ke) {
                
                trs_7.setRowFilter(RowFilter.regexFilter("(?i)" + txtBuscador_Area.getText(), 2));
            }
        });
        
        trs_7 = new TableRowSorter(modelo_Area);
        
        tblArea.setRowSorter(trs_7);
    }//GEN-LAST:event_txtBuscador_AreaKeyTyped

    private void txtBuscador_NivelKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscador_NivelKeyTyped
        txtBuscador_Nivel.addKeyListener(new KeyAdapter() {
            
            @Override
            public void keyReleased(KeyEvent ke) {
                
                trs_8.setRowFilter(RowFilter.regexFilter("(?i)" + txtBuscador_Nivel.getText(), 2));
            }
        });
        
        trs_8 = new TableRowSorter(modelo_Nivel);
        
        tblNivel.setRowSorter(trs_8);
    }//GEN-LAST:event_txtBuscador_NivelKeyTyped

    //JButton [Limpiar] de los buscadores
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        limpiar_Buscadores();
    }//GEN-LAST:event_jButton6ActionPerformed

    //JButton [Cerrar]
    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        cerrar();
    }//GEN-LAST:event_jButton8ActionPerformed

    //JButton [Cancelar]
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        cancelar();
    }//GEN-LAST:event_btnCancelarActionPerformed

    //JButton [Limpiar] de los dos útlimos buscadores
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        limpiar_Dos_Ultimos_Buscadores();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtNombres_Y_Apellidos_AsistenteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombres_Y_Apellidos_AsistenteKeyTyped
        char validar = evt.getKeyChar();
        
        if(Character.isDigit(validar)){
            getToolkit().beep();
            evt.consume();
            
            JOptionPane.showMessageDialog(null, "Solo ingrese letras.");
        }
    }//GEN-LAST:event_txtNombres_Y_Apellidos_AsistenteKeyTyped

    private void txtCorreo_AsistenteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCorreo_AsistenteKeyTyped
       
    }//GEN-LAST:event_txtCorreo_AsistenteKeyTyped

    private void txtTelefono_AsistenteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefono_AsistenteKeyTyped
        char validar_2 = evt.getKeyChar();
        
        if(Character.isLetter(validar_2)){
            getToolkit().beep();
            evt.consume();
            
            JOptionPane.showMessageDialog(null, "Solo ingrese numeros.");
        }
    }//GEN-LAST:event_txtTelefono_AsistenteKeyTyped

    private void txtArea_AsistenteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtArea_AsistenteKeyTyped
        char validar = evt.getKeyChar();
        
        if(Character.isDigit(validar)){
            getToolkit().beep();
            evt.consume();
            
            JOptionPane.showMessageDialog(null, "Solo ingrese letras.");
        }
    }//GEN-LAST:event_txtArea_AsistenteKeyTyped

    private void txtNivel_AsistenteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNivel_AsistenteKeyTyped
        
    }//GEN-LAST:event_txtNivel_AsistenteKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnElegir_Area;
    private javax.swing.JButton btnElegir_Nivel;
    private javax.swing.JButton btnEliminar_Asistente;
    private javax.swing.JButton btnGuardar_Datos;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnModificar_Asistente;
    private javax.swing.JButton btnRegistrar_Asistente;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblArea;
    private javax.swing.JTable tblAsistente;
    private javax.swing.JTable tblNivel;
    private javax.swing.JTextField txtArea_Asistente;
    private javax.swing.JTextField txtBuscador_Area;
    private javax.swing.JTextField txtBuscador_Area_Asistente;
    private javax.swing.JTextField txtBuscador_Codigo;
    private javax.swing.JTextField txtBuscador_Correo_Asistente;
    private javax.swing.JTextField txtBuscador_Nivel;
    private javax.swing.JTextField txtBuscador_Nivel_Asistente;
    private javax.swing.JTextField txtBuscador_Nombres_Y_Apellidos_Asistente;
    private javax.swing.JTextField txtBuscador_Telefono_Asistente;
    private javax.swing.JTextField txtCorreo_Asistente;
    private javax.swing.JTextField txtNivel_Asistente;
    private javax.swing.JTextField txtNombres_Y_Apellidos_Asistente;
    private javax.swing.JTextField txtTelefono_Asistente;
    // End of variables declaration//GEN-END:variables
}
