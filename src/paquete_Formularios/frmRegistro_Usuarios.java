
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
import paquete_Clases.Usuario;

public class frmRegistro_Usuarios extends javax.swing.JInternalFrame {

    TableRowSorter trs;
    TableRowSorter trs_2;
    TableRowSorter trs_3;
    TableRowSorter trs_4;
    TableRowSorter trs_5;
    TableRowSorter trs_6;  
    
    Usuario objeto_Usuario = new Usuario();
    
    DefaultTableModel modelo_Usuario = new DefaultTableModel();
    DefaultTableModel modelo_Area = new DefaultTableModel();
    
    private void agregar_Columnas_Tabla_Usuario(){
        modelo_Usuario.addColumn("Código");
        modelo_Usuario.addColumn("Fecha De Creación"); //1
        modelo_Usuario.addColumn("Nombres Y Apellidos");
        modelo_Usuario.addColumn("Correo Electrónico");
        modelo_Usuario.addColumn("Teléfono");
        modelo_Usuario.addColumn("Área");
        tblUsuario.setModel(modelo_Usuario);
    }
    private void agregar_Columnas_Tabla_Area(){
        modelo_Area.addColumn("Código");
        modelo_Area.addColumn("Fecha De Creación");
        modelo_Area.addColumn("Área");
        tblArea.setModel(modelo_Area);
    }
    
    private void registrar_Usuario(){
        
        int valor = JOptionPane.showConfirmDialog(this, "¿Desea registrar un nuevo usuario?", "Mensaje", JOptionPane.YES_NO_OPTION);
        if(valor == JOptionPane.YES_OPTION){
            btnRegistrar_Usuario.setEnabled(false);
            txtNombres_Y_Apellidos_Usuario.setEnabled(true);
            txtCorreo_Usuario.setEnabled(true);
            txtTelefono_Usuario.setEnabled(true);
            txtArea_Usuario.setEnabled(true);
            btnElegir_Area.setEnabled(true);
            btnCancelar.setEnabled(true);
            txtBuscador_Area.setEnabled(true);
            btnLimpiar.setEnabled(true);
            btnGuardar_Datos.setEnabled(true);
        } 
        
    }
    private void guardar_Datos_Usuario(){
        grabar_Datos_De_Controles_En_Fichero_Usuarios();  
        txtNombres_Y_Apellidos_Usuario.setEnabled(false);
        txtCorreo_Usuario.setEnabled(false);
        txtTelefono_Usuario.setEnabled(false);
        txtArea_Usuario.setEnabled(false);
        btnGuardar_Datos.setEnabled(false);
        btnRegistrar_Usuario.setEnabled(true);
        btnCancelar.setEnabled(false);
        btnElegir_Area.setEnabled(false);
        btnLimpiar.setEnabled(false);
        txtBuscador_Area.setEnabled(false);
        txtNombres_Y_Apellidos_Usuario.setText(null);
        txtCorreo_Usuario.setText(null);
        txtTelefono_Usuario.setText(null);
        txtArea_Usuario.setText(null);              
    }
    private void grabar_Datos_De_Controles_En_Fichero_Usuarios(){
          
        FileWriter fw=null;
        PrintWriter pw=null;
        
        try{
            
            fw = new FileWriter("src\\paquete_Ficheros\\Usuarios.txt", true);
            pw = new PrintWriter(fw);

            objeto_Usuario.setNombres_Y_Apellidos_Usuario(txtNombres_Y_Apellidos_Usuario.getText());
            objeto_Usuario.setCorreo_Usuario(txtCorreo_Usuario.getText());
            objeto_Usuario.setTelefono_Usuario(txtTelefono_Usuario.getText());
            objeto_Usuario.setArea_Usuario(txtArea_Usuario.getText());
            
            pw.println(objeto_Usuario.codigo_Usuario() + ";" + objeto_Usuario.fecha_Usuario() + ";" + objeto_Usuario.getNombres_Y_Apellidos_Usuario() + ";" +
            objeto_Usuario.getCorreo_Usuario() + ";" + objeto_Usuario.getTelefono_Usuario() + ";" + objeto_Usuario.getArea_Usuario());
 
            pw.close();
            
            cargar_Datos_De_Controles_En_Tabla_Usuario();
        
        }catch(Exception ex){
            
            JOptionPane.showMessageDialog(null, ex.getMessage());    
        }
    }
    private void cargar_Datos_De_Controles_En_Tabla_Usuario(){
        
        Object [] fila = new Object[6];
        
        fila[0] = objeto_Usuario.codigo_Usuario();
        fila[1] = objeto_Usuario.fecha_Usuario();
        fila[2] = objeto_Usuario.getNombres_Y_Apellidos_Usuario();
        fila[3] = objeto_Usuario.getCorreo_Usuario();
        fila[4] = objeto_Usuario.getTelefono_Usuario();
        fila[5] = objeto_Usuario.getArea_Usuario();
 
        modelo_Usuario.addRow(fila); 
    }  
    
    private void modificar_Usuario(){
            
        int seleccion = tblUsuario.getSelectedRow();
        
        if(seleccion == 0 || seleccion == 1 || seleccion == 2 || seleccion == 3 || seleccion == 4 || seleccion == 5 || seleccion ==  6 || seleccion == 7 || seleccion == 8 || seleccion == 9 || seleccion == 10){
            
            int valor = JOptionPane.showConfirmDialog(this, "¿Está seguro que lo desea modificar?", "Mensaje", JOptionPane.YES_NO_OPTION);
            
            if(valor == JOptionPane.YES_OPTION){
                
                txtNombres_Y_Apellidos_Usuario.setText(String.valueOf(tblUsuario.getValueAt(seleccion, 2)));
                txtCorreo_Usuario.setText(String.valueOf(tblUsuario.getValueAt(seleccion, 3)));
                txtTelefono_Usuario.setText(String.valueOf(tblUsuario.getValueAt(seleccion, 4)));
                txtArea_Usuario.setText(String.valueOf(tblUsuario.getValueAt(seleccion, 5)));
                
                btnModificar_Usuario.setEnabled(false);
                btnEliminar_Usuario.setEnabled(false);
                
                txtNombres_Y_Apellidos_Usuario.setEnabled(true);
                txtCorreo_Usuario.setEnabled(true);
                txtTelefono_Usuario.setEnabled(true);
                txtArea_Usuario.setEnabled(true);
                
                btnElegir_Area.setEnabled(true);
                btnGuardar_Datos.setEnabled(true);
        
                modelo_Area.removeRow(seleccion);   
                mostrar_Registros_De_Tabla_Usuario_En_Fichero_Usuarios();
            }
            
        }else{
            JOptionPane.showMessageDialog(null, "¡No ha seleccionado un usuario!");
        }
          
    }
    
    private void eliminar_Usuario(){
        
        int seleccion = tblUsuario.getSelectedRow();
        
        if(seleccion == 0 || seleccion == 1 || seleccion == 2 || seleccion == 3 || seleccion == 4 || seleccion == 5 || seleccion ==  6 || seleccion == 7 || seleccion == 8 || seleccion == 9 || seleccion == 10){       
         
            int valor = JOptionPane.showConfirmDialog(this, "¿Está seguro que lo desea eliminar?", "Mensaje", JOptionPane.YES_NO_OPTION);
          
            if(valor == JOptionPane.YES_OPTION){
              
                eliminar_Fichero_Usuarios();
                crear_Fichero_Usuarios();
                modelo_Usuario.removeRow(seleccion);   
                mostrar_Registros_De_Tabla_Usuario_En_Fichero_Usuarios();
            }
            
        }else{            
            JOptionPane.showMessageDialog(null, "¡No ha seleccionado un usuario!");
        }
    }
    private void eliminar_Fichero_Usuarios(){   
        File archivo = new File("src/paquete_Ficheros/Usuarios.txt");        
        archivo.delete();
    }
    private void crear_Fichero_Usuarios(){
        
        FileWriter fw=null;
        PrintWriter pw=null;
        
        try{
         
            fw = new FileWriter("src\\paquete_Ficheros\\Usuarios.txt", true);
            pw = new PrintWriter(fw);
        
        }catch(Exception ex){
            
            JOptionPane.showMessageDialog(null, ex.getMessage());    
        }
    } 
    private void mostrar_Registros_De_Tabla_Usuario_En_Fichero_Usuarios(){
        
        FileWriter fw=null;
        PrintWriter pw=null;
        
        try{
         
            fw = new FileWriter("src\\paquete_Ficheros\\Usuarios.txt", true);
            pw = new PrintWriter(fw);
        
            for(int i=0; i<tblUsuario.getRowCount(); i++){
            
            pw.println(String.valueOf(tblUsuario.getValueAt(i, 0)) + ";" +
                    String.valueOf(tblUsuario.getValueAt(i, 1)) + ";" +
                    String.valueOf(tblUsuario.getValueAt(i, 2)) + ";" +
                    String.valueOf(tblUsuario.getValueAt(i, 3)) + ";" +
                    String.valueOf(tblUsuario.getValueAt(i, 4)) + ";" +
                    String.valueOf(tblUsuario.getValueAt(i, 5)));          
            }
        
            pw.close();
        
        }catch(Exception ex){
            
            JOptionPane.showMessageDialog(null, ex.getMessage());    
        }   
    }
    
    private void mostrar_Registro_De_Fichero_Usuarios_En_Tabla_Usuario(){
        
        try{
            File archivo = new File("src/paquete_Ficheros/Usuarios.txt");
            
            if(archivo.exists()){
                
                FileReader reader = new FileReader(archivo);
                BufferedReader br = new BufferedReader(reader);
                
                String linea;
                
                while((linea = br.readLine()) != null){
                
                StringTokenizer token = new StringTokenizer(linea, ";");
                
                String codigo_Usuario = token.nextToken().trim();
                String fecha_Usuario = token.nextToken().trim();
                String nombres_Y_Apellidos_Usuario = token.nextToken().trim();
                String correo_Usuario = token.nextToken().trim();
                String telefono_Usuario = token.nextToken().trim();
                String area_Usuario = token.nextToken().trim();
                
                Object[] obj = new Object[]{
                    
                    codigo_Usuario, fecha_Usuario, nombres_Y_Apellidos_Usuario, correo_Usuario, telefono_Usuario, area_Usuario
                };
                        
                modelo_Usuario.addRow(obj);
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
                String area_Usuario = token.nextToken().trim();
                
                Object[] obj = new Object[]{
                    
                    codigo, fecha, area_Usuario
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
    
    private void elegir_Area(){
        
        int seleccion = tblArea.getSelectedRow();
        
        if(seleccion == 0 || seleccion == 1 || seleccion == 2 || seleccion == 3 || seleccion == 4 || seleccion == 5 || seleccion ==  6 || seleccion == 7 || seleccion == 8 || seleccion == 9 || seleccion == 10){
            
            int valor = JOptionPane.showConfirmDialog(this, "¿Está seguro que lo desea elegir?", "Mensaje", JOptionPane.YES_NO_OPTION);
            
            if(valor == JOptionPane.YES_OPTION){
                
                txtArea_Usuario.setText(String.valueOf(tblArea.getValueAt(seleccion, 2)));
            }
            
        }else{
            JOptionPane.showMessageDialog(null, "¡No ha seleccionado un área!");
        }
    }
    
    private void cancelar(){
        int valor = JOptionPane.showConfirmDialog(this, "¿Está seguro que lo desea cancelar?", "Mensaje", JOptionPane.YES_NO_OPTION);
        if(valor == JOptionPane.YES_OPTION){
            txtNombres_Y_Apellidos_Usuario.setText(null);
            txtCorreo_Usuario.setText(null);
            txtTelefono_Usuario.setText(null);
            txtArea_Usuario.setText(null);
            txtBuscador_Area.setEnabled(false);
            
            txtNombres_Y_Apellidos_Usuario.setEnabled(false);
            txtCorreo_Usuario.setEnabled(false);
            txtTelefono_Usuario.setEnabled(false);
            txtArea_Usuario.setEnabled(false);
            btnElegir_Area.setEnabled(false);
            btnGuardar_Datos.setEnabled(false);
            
            btnModificar_Usuario.setEnabled(true);
            btnRegistrar_Usuario.setEnabled(true);
            btnEliminar_Usuario.setEnabled(true);
            btnLimpiar.setEnabled(false);
        }  
    }
    
    private void limpiar_Buscadores(){
        txtBuscador_Codigo_Usuario.setText(null);
        txtBuscador_Nombres_Y_Apellidos_Usuario.setText(null);
        txtBuscador_Correo_Usuario.setText(null);
        txtBuscador_Telefono_Usuario.setText(null);
        txtBuscador_Area_Usuario.setText(null);
    }
    
    private void limpiar(){
        txtNombres_Y_Apellidos_Usuario.setText(null);
        txtCorreo_Usuario.setText(null);
        txtTelefono_Usuario.setText(null);
        txtArea_Usuario.setText(null);
    }
    
    private void limpiar_Ultimo_Buscador(){
        txtBuscador_Area.setText(null);
    }
    
    private void cerrar(){  
        int valor = JOptionPane.showConfirmDialog(this, "¿Está seguro que lo desea cerrar?", "Mensaje", JOptionPane.YES_NO_OPTION);
        if(valor == JOptionPane.YES_OPTION){
            this.setVisible(false);
        }      
    }
    
    public frmRegistro_Usuarios() {
        initComponents();
        
        agregar_Columnas_Tabla_Usuario();
        agregar_Columnas_Tabla_Area();
        
        txtNombres_Y_Apellidos_Usuario.setEnabled(false);
        txtCorreo_Usuario.setEnabled(false);
        txtTelefono_Usuario.setEnabled(false);
        txtArea_Usuario.setEnabled(false);
        
        txtArea_Usuario.setEditable(false);
        
        txtBuscador_Area.setEnabled(false);
        
        btnElegir_Area.setEnabled(false);
        btnGuardar_Datos.setEnabled(false);
        btnCancelar.setEnabled(false);
        btnLimpiar.setEnabled(false);
        
        mostrar_Registro_De_Fichero_Usuarios_En_Tabla_Usuario();
        mostrar_Registro_De_Fichero_Areas_En_Tabla_Area();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUsuario = new javax.swing.JTable();
        btnEliminar_Usuario = new javax.swing.JButton();
        btnModificar_Usuario = new javax.swing.JButton();
        btnRegistrar_Usuario = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        txtNombres_Y_Apellidos_Usuario = new javax.swing.JTextField();
        txtCorreo_Usuario = new javax.swing.JTextField();
        txtTelefono_Usuario = new javax.swing.JTextField();
        jScrollPane11 = new javax.swing.JScrollPane();
        tblArea = new javax.swing.JTable();
        txtArea_Usuario = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        btnElegir_Area = new javax.swing.JButton();
        btnGuardar_Datos = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtBuscador_Area = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtBuscador_Codigo_Usuario = new javax.swing.JTextField();
        txtBuscador_Nombres_Y_Apellidos_Usuario = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtBuscador_Correo_Usuario = new javax.swing.JTextField();
        txtBuscador_Telefono_Usuario = new javax.swing.JTextField();
        txtBuscador_Area_Usuario = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();

        tblUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblUsuario);

        btnEliminar_Usuario.setText("Eliminar Usuario");
        btnEliminar_Usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminar_UsuarioActionPerformed(evt);
            }
        });

        btnModificar_Usuario.setText("Modificar Usuario");
        btnModificar_Usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificar_UsuarioActionPerformed(evt);
            }
        });

        btnRegistrar_Usuario.setText("Registrar Usuario");
        btnRegistrar_Usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrar_UsuarioActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Del Usuario"));

        jLabel21.setText("Nombres Y Apellidos Del Usuario:");

        jLabel22.setText("Correo Electrónico Del Usuario:");

        jLabel23.setText("Teléfono Del Usuario:");

        jLabel24.setText("Área Del Usuario:");

        txtNombres_Y_Apellidos_Usuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombres_Y_Apellidos_UsuarioKeyTyped(evt);
            }
        });

        txtCorreo_Usuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCorreo_UsuarioKeyTyped(evt);
            }
        });

        txtTelefono_Usuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefono_UsuarioKeyTyped(evt);
            }
        });

        tblArea.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane11.setViewportView(tblArea);

        txtArea_Usuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtArea_UsuarioKeyTyped(evt);
            }
        });

        jLabel25.setText("Elija un área:");

        btnElegir_Area.setText("Elegir Área");
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

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtro"));

        jLabel6.setText("Área:");

        txtBuscador_Area.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscador_AreaKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBuscador_Area, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtBuscador_Area, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

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
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLimpiar))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21)
                            .addComponent(jLabel22)
                            .addComponent(jLabel23)
                            .addComponent(jLabel24))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTelefono_Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCorreo_Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtArea_Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombres_Y_Apellidos_Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnElegir_Area)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGuardar_Datos)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel25)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButton1)))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 750, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(txtNombres_Y_Apellidos_Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel25)))
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(txtCorreo_Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23)
                            .addComponent(txtTelefono_Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(txtArea_Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnLimpiar)
                        .addComponent(btnElegir_Area)
                        .addComponent(btnGuardar_Datos))
                    .addComponent(btnCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtros"));

        jLabel1.setText("Código:");

        jLabel2.setText("Nombres Y Apellidos Del Usuario:");

        txtBuscador_Codigo_Usuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscador_Codigo_UsuarioKeyTyped(evt);
            }
        });

        txtBuscador_Nombres_Y_Apellidos_Usuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscador_Nombres_Y_Apellidos_UsuarioKeyTyped(evt);
            }
        });

        jLabel3.setText("Correo Electrónico Del Usuario:");

        jLabel4.setText("Teléfono Del Usuario:");

        jLabel5.setText("Área Del Usuario:");

        txtBuscador_Correo_Usuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscador_Correo_UsuarioKeyTyped(evt);
            }
        });

        txtBuscador_Telefono_Usuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscador_Telefono_UsuarioKeyTyped(evt);
            }
        });

        txtBuscador_Area_Usuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscador_Area_UsuarioKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBuscador_Codigo_Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtBuscador_Nombres_Y_Apellidos_Usuario, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                    .addComponent(txtBuscador_Correo_Usuario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtBuscador_Area_Usuario, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                    .addComponent(txtBuscador_Telefono_Usuario))
                .addGap(63, 63, 63))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtBuscador_Codigo_Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBuscador_Telefono_Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtBuscador_Nombres_Y_Apellidos_Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtBuscador_Area_Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBuscador_Correo_Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton7.setText("Cerrar");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("Limpiar");
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
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnModificar_Usuario)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEliminar_Usuario))
                            .addComponent(jButton7)
                            .addComponent(jButton8, javax.swing.GroupLayout.Alignment.LEADING)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnRegistrar_Usuario)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jButton7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnEliminar_Usuario)
                            .addComponent(btnModificar_Usuario))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRegistrar_Usuario)
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

    //jButton [Elegir Área]
    private void btnElegir_AreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnElegir_AreaActionPerformed
        elegir_Area();
    }//GEN-LAST:event_btnElegir_AreaActionPerformed

    //jButton [Registrar Usuario]
    private void btnRegistrar_UsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrar_UsuarioActionPerformed
        registrar_Usuario();
    }//GEN-LAST:event_btnRegistrar_UsuarioActionPerformed

    //jButton [Guardar Datos]
    private void btnGuardar_DatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardar_DatosActionPerformed
        if(txtNombres_Y_Apellidos_Usuario.getText().trim().isEmpty() && txtCorreo_Usuario.getText().trim().isEmpty() && txtTelefono_Usuario.getText().trim().isEmpty() && txtArea_Usuario.getText().trim().isEmpty()){

            JOptionPane.showMessageDialog(null, "¡No ha llenado ningún  dato!");

        }else if(txtNombres_Y_Apellidos_Usuario.getText().trim().isEmpty()){

            JOptionPane.showMessageDialog(null, "Le falta llenar sus nombres y apellidos.");

        }else if(txtCorreo_Usuario.getText().trim().isEmpty()){

            JOptionPane.showMessageDialog(null, "Le falta llenar su correo.");

        }else if(txtTelefono_Usuario.getText().trim().isEmpty()){

            JOptionPane.showMessageDialog(null, "Le falta llenar su teléfono.");
        
        }else if(txtArea_Usuario.getText().trim().isEmpty()){

            JOptionPane.showMessageDialog(null, "Le falta llenar su área.");
            
        }else{
            
            guardar_Datos_Usuario();
        }    
            
    }//GEN-LAST:event_btnGuardar_DatosActionPerformed

    //jButton [Modificar Usuario]
    private void btnModificar_UsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificar_UsuarioActionPerformed
        modificar_Usuario();
    }//GEN-LAST:event_btnModificar_UsuarioActionPerformed

    //jButton [Eliminar Usuario]
    private void btnEliminar_UsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminar_UsuarioActionPerformed
        eliminar_Usuario();
    }//GEN-LAST:event_btnEliminar_UsuarioActionPerformed

    private void txtBuscador_Codigo_UsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscador_Codigo_UsuarioKeyTyped
        txtBuscador_Codigo_Usuario.addKeyListener(new KeyAdapter() {
            
            @Override
            public void keyReleased(KeyEvent ke) {
                
                trs.setRowFilter(RowFilter.regexFilter("(?i)" + txtBuscador_Codigo_Usuario.getText(), 0));
            }
        });
        
        trs = new TableRowSorter(modelo_Usuario);
        
        tblUsuario.setRowSorter(trs);
    }//GEN-LAST:event_txtBuscador_Codigo_UsuarioKeyTyped

    private void txtBuscador_Nombres_Y_Apellidos_UsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscador_Nombres_Y_Apellidos_UsuarioKeyTyped
        txtBuscador_Nombres_Y_Apellidos_Usuario.addKeyListener(new KeyAdapter() {
            
            @Override
            public void keyReleased(KeyEvent ke) {
                
                trs_2.setRowFilter(RowFilter.regexFilter("(?i)" + txtBuscador_Nombres_Y_Apellidos_Usuario.getText(), 2));
            }
        });
        
        trs_2 = new TableRowSorter(modelo_Usuario);
        
        tblUsuario.setRowSorter(trs_2);
    }//GEN-LAST:event_txtBuscador_Nombres_Y_Apellidos_UsuarioKeyTyped

    private void txtBuscador_Correo_UsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscador_Correo_UsuarioKeyTyped
        txtBuscador_Correo_Usuario.addKeyListener(new KeyAdapter() {
            
            @Override
            public void keyReleased(KeyEvent ke) {
                
                trs_3.setRowFilter(RowFilter.regexFilter("(?i)" + txtBuscador_Correo_Usuario.getText(), 3));
            }
        });
        
        trs_3 = new TableRowSorter(modelo_Usuario);
        
        tblUsuario.setRowSorter(trs_3);
    }//GEN-LAST:event_txtBuscador_Correo_UsuarioKeyTyped

    private void txtBuscador_Telefono_UsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscador_Telefono_UsuarioKeyTyped
        txtBuscador_Correo_Usuario.addKeyListener(new KeyAdapter() {
            
            @Override
            public void keyReleased(KeyEvent ke) {
                
                trs_4.setRowFilter(RowFilter.regexFilter("(?i)" + txtBuscador_Correo_Usuario.getText(), 4));
            }
        });
        
        trs_4 = new TableRowSorter(modelo_Usuario);
        
        tblUsuario.setRowSorter(trs_4);
    }//GEN-LAST:event_txtBuscador_Telefono_UsuarioKeyTyped

    private void txtBuscador_Area_UsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscador_Area_UsuarioKeyTyped
        txtBuscador_Area_Usuario.addKeyListener(new KeyAdapter() {
            
            @Override
            public void keyReleased(KeyEvent ke) {
                
                trs_5.setRowFilter(RowFilter.regexFilter("(?i)" + txtBuscador_Area_Usuario.getText(), 5));
            }
        });
        
        trs_5 = new TableRowSorter(modelo_Usuario);
        
        tblUsuario.setRowSorter(trs_5);
    }//GEN-LAST:event_txtBuscador_Area_UsuarioKeyTyped

    private void txtBuscador_AreaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscador_AreaKeyTyped
        txtBuscador_Area.addKeyListener(new KeyAdapter() {
            
            @Override
            public void keyReleased(KeyEvent ke) {
                
                trs_6.setRowFilter(RowFilter.regexFilter("(?i)" + txtBuscador_Area.getText(), 2));
            }
        });
        
        trs_6 = new TableRowSorter(modelo_Usuario);
        
        tblUsuario.setRowSorter(trs_6);
    }//GEN-LAST:event_txtBuscador_AreaKeyTyped

    //JButton [Limpiar] de los buscadores
    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        limpiar_Buscadores();
    }//GEN-LAST:event_jButton8ActionPerformed

    //JButton [Cancelar]
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        cancelar();
    }//GEN-LAST:event_btnCancelarActionPerformed

    //JButton [Limpiar]
    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiar();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    //JButton [Cerrar]
    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        cerrar();
    }//GEN-LAST:event_jButton7ActionPerformed

    //JButton [Limpiar] del último buscador
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        limpiar_Ultimo_Buscador();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtNombres_Y_Apellidos_UsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombres_Y_Apellidos_UsuarioKeyTyped
        char validar = evt.getKeyChar();
        
        if(Character.isDigit(validar)){
            getToolkit().beep();
            evt.consume();
            
            JOptionPane.showMessageDialog(null, "Solo ingrese letras.");
        }
    }//GEN-LAST:event_txtNombres_Y_Apellidos_UsuarioKeyTyped

    private void txtCorreo_UsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCorreo_UsuarioKeyTyped

    }//GEN-LAST:event_txtCorreo_UsuarioKeyTyped

    private void txtTelefono_UsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefono_UsuarioKeyTyped
        char validar_2 = evt.getKeyChar();
        
        if(Character.isLetter(validar_2)){
            getToolkit().beep();
            evt.consume();
            
            JOptionPane.showMessageDialog(null, "Solo ingrese numeros.");
        }
    }//GEN-LAST:event_txtTelefono_UsuarioKeyTyped

    private void txtArea_UsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtArea_UsuarioKeyTyped
        char validar = evt.getKeyChar();
        
        if(Character.isDigit(validar)){
            getToolkit().beep();
            evt.consume();
            
            JOptionPane.showMessageDialog(null, "Solo ingrese letras.");
        }
    }//GEN-LAST:event_txtArea_UsuarioKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnElegir_Area;
    private javax.swing.JButton btnEliminar_Usuario;
    private javax.swing.JButton btnGuardar_Datos;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnModificar_Usuario;
    private javax.swing.JButton btnRegistrar_Usuario;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JTable tblArea;
    private javax.swing.JTable tblUsuario;
    private javax.swing.JTextField txtArea_Usuario;
    private javax.swing.JTextField txtBuscador_Area;
    private javax.swing.JTextField txtBuscador_Area_Usuario;
    private javax.swing.JTextField txtBuscador_Codigo_Usuario;
    private javax.swing.JTextField txtBuscador_Correo_Usuario;
    private javax.swing.JTextField txtBuscador_Nombres_Y_Apellidos_Usuario;
    private javax.swing.JTextField txtBuscador_Telefono_Usuario;
    private javax.swing.JTextField txtCorreo_Usuario;
    private javax.swing.JTextField txtNombres_Y_Apellidos_Usuario;
    private javax.swing.JTextField txtTelefono_Usuario;
    // End of variables declaration//GEN-END:variables
}
