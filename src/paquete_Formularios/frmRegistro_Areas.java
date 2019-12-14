
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
import paquete_Clases.Area;

public class frmRegistro_Areas extends javax.swing.JInternalFrame {

    TableRowSorter trs;
    TableRowSorter trs_2;
    
    Area objeto_Area = new Area();
    
    DefaultTableModel modelo_Area = new DefaultTableModel();
    
    private void agregar_Columnas_Tabla_Area(){
        modelo_Area.addColumn("Código");
        modelo_Area.addColumn("Fecha De Creación");
        modelo_Area.addColumn("Área");
        tblArea.setModel(modelo_Area);
    }
    
    private void registrar_Area(){
        
        int valor = JOptionPane.showConfirmDialog(this, "¿Desea registrar una nueva área?", "Mensaje", JOptionPane.YES_NO_OPTION);
        if(valor == JOptionPane.YES_OPTION){
            txtArea.setEnabled(true);
            btnLimpiar.setEnabled(true);
            btnCancelar.setEnabled(true);
            btnGuardar_Datos.setEnabled(true);
        }
        
    }
    private void guardar_Datos_Area(){
        
        int valor = JOptionPane.showConfirmDialog(this, "¿Está seguro que desea registrar una nueva área?", "Mensaje", JOptionPane.YES_NO_OPTION);
        if(valor == JOptionPane.YES_OPTION){
            
            grabar_Datos_De_Controles_En_Fichero_Areas();
            
            txtArea.setText(null);
            txtArea.setEnabled(false);    
            btnLimpiar.setEnabled(false);
            btnCancelar.setEnabled(false);
            btnGuardar_Datos.setEnabled(false);
            
            btnModificar_Area.setEnabled(true);
            btnRegistrar_Area.setEnabled(true);
            btnEliminar_Area.setEnabled(true);
        }                 
    }
    private void grabar_Datos_De_Controles_En_Fichero_Areas(){
          
        FileWriter fw=null;
        PrintWriter pw=null;
        
        try{
            
            fw = new FileWriter("src\\paquete_Ficheros\\Areas.txt", true);
            pw = new PrintWriter(fw);

            objeto_Area.setArea(txtArea.getText());
            
            pw.println(objeto_Area.codigo_Area() + ";" + objeto_Area.fecha_Area() + ";" + objeto_Area.getArea());
 
            pw.close();
            
            cargar_Datos_De_Controles_En_Tabla_Area();
        
        }catch(Exception ex){
            
            JOptionPane.showMessageDialog(null, ex.getMessage());    
        }
    }
    private void cargar_Datos_De_Controles_En_Tabla_Area(){
        
        Object [] fila = new Object[3];
        
        fila[0] = objeto_Area.codigo_Area();
        fila[1] = objeto_Area.fecha_Area();
        fila[2] = objeto_Area.getArea();
 
        modelo_Area.addRow(fila); 
    }  
    
    private void modificar_Area(){
        
        int seleccion = tblArea.getSelectedRow();
        
        if(seleccion == 0 || seleccion == 1 || seleccion == 2 || seleccion == 3 || seleccion == 4 || seleccion == 5 || seleccion ==  6 || seleccion == 7 || seleccion == 8 || seleccion == 9 || seleccion == 10){
            
            int valor = JOptionPane.showConfirmDialog(this, "¿Está seguro que lo desea modificar?", "Mensaje", JOptionPane.YES_NO_OPTION);
            
            if(valor == JOptionPane.YES_OPTION){
                
                txtArea.setText(String.valueOf(tblArea.getValueAt(seleccion, 2)));
                txtArea.setEnabled(true);
                btnLimpiar.setEnabled(true);
                btnCancelar.setEnabled(true);
                btnGuardar_Datos.setEnabled(true);
            
                btnModificar_Area.setEnabled(false);
                btnEliminar_Area.setEnabled(false);
                btnRegistrar_Area.setEnabled(false);
            
                eliminar_Fichero_Areas();
                crear_Fichero_Areas();
                modelo_Area.removeRow(seleccion);   
                mostrar_Registros_De_Tabla_Area_En_Fichero_Areas();
            }
            
        }else{
            JOptionPane.showMessageDialog(null, "¡No ha seleccionado un área!");
        }
        
    }
    
    private void eliminar_Area(){
        
        int seleccion = tblArea.getSelectedRow();
            
        if(seleccion == 0 || seleccion == 1 || seleccion == 2 || seleccion == 3 || seleccion == 4 || seleccion == 5 || seleccion ==  6 || seleccion == 7 || seleccion == 8 || seleccion == 9 || seleccion == 10){       
         
            int valor = JOptionPane.showConfirmDialog(this, "¿Está seguro que lo desea eliminar?", "Mensaje", JOptionPane.YES_NO_OPTION);
          
            if(valor == JOptionPane.YES_OPTION){
              
                eliminar_Fichero_Areas();
                crear_Fichero_Areas();
                modelo_Area.removeRow(seleccion);   
                mostrar_Registros_De_Tabla_Area_En_Fichero_Areas();
            }
            
        }else{            
            JOptionPane.showMessageDialog(null, "¡No ha seleccionado un área!");
        }
       
    }
    private void eliminar_Fichero_Areas(){   
        File archivo = new File("src/paquete_Ficheros/Areas.txt");        
        archivo.delete();
    }
    private void crear_Fichero_Areas(){
        
        FileWriter fw=null;
        PrintWriter pw=null;
        
        try{
         
            fw = new FileWriter("src\\paquete_Ficheros\\Areas.txt", true);
            pw = new PrintWriter(fw);
        
        }catch(Exception ex){
            
            JOptionPane.showMessageDialog(null, ex.getMessage());    
        }
    } 
    private void mostrar_Registros_De_Tabla_Area_En_Fichero_Areas(){
        
        FileWriter fw=null;
        PrintWriter pw=null;
        
        try{
         
            fw = new FileWriter("src\\paquete_Ficheros\\Areas.txt", true);
            pw = new PrintWriter(fw);
        
            for(int i=0; i<tblArea.getRowCount(); i++){
            
            pw.println(String.valueOf(tblArea.getValueAt(i, 0)) + ";" +
                    String.valueOf(tblArea.getValueAt(i, 1)) + ";" +
                    String.valueOf(tblArea.getValueAt(i, 2)));          
            }
        
            pw.close();
        
        }catch(Exception ex){
            
            JOptionPane.showMessageDialog(null, ex.getMessage());    
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
    
    private void cerrar(){  
        int valor = JOptionPane.showConfirmDialog(this, "¿Está seguro que lo desea cerrar?", "Mensaje", JOptionPane.YES_NO_OPTION);
        if(valor == JOptionPane.YES_OPTION){
            this.setVisible(false);
        }      
    }
    
    private void cancelar(){
        int valor = JOptionPane.showConfirmDialog(this, "¿Está seguro que lo desea cancelar?", "Mensaje", JOptionPane.YES_NO_OPTION);
        if(valor == JOptionPane.YES_OPTION){
            txtArea.setText(null);
            txtArea.setEnabled(false);
            btnLimpiar.setEnabled(false);
            btnCancelar.setEnabled(false);
            btnGuardar_Datos.setEnabled(false);
            
            btnModificar_Area.setEnabled(true);
            btnModificar_Area.setEnabled(true);
            btnRegistrar_Area.setEnabled(true);
            btnEliminar_Area.setEnabled(true);
        }  
    }
    
    private void limpiar_Registrar_Area(){
        txtArea.setText(null);
    }
    
    private void buscador_Codigo(){
        txtBuscador_Codigo.addKeyListener(new KeyAdapter() {
            
            @Override
            public void keyReleased(KeyEvent ke) {
                
                trs.setRowFilter(RowFilter.regexFilter("(?i)" + txtBuscador_Codigo.getText(), 0));
            }
        });
        
        trs = new TableRowSorter(modelo_Area);
        
        tblArea.setRowSorter(trs);
    }
    
    private void buscador_Area(){
        txtBuscador_Area.addKeyListener(new KeyAdapter() {
            
            @Override
            public void keyReleased(KeyEvent ke) {
                
                trs_2.setRowFilter(RowFilter.regexFilter("(?i)" + txtBuscador_Area.getText(), 2));
            }
        });
        
        trs_2 = new TableRowSorter(modelo_Area);
        
        tblArea.setRowSorter(trs_2);
    }
    
    private void limpiar_Buscadores(){
        txtBuscador_Codigo.setText(null);
        txtBuscador_Area.setText(null);
    }
    
    public frmRegistro_Areas() {
        initComponents();
        
        agregar_Columnas_Tabla_Area();
        
        txtArea.setEnabled(false);
        btnLimpiar.setEnabled(false);
        btnCancelar.setEnabled(false);
        btnGuardar_Datos.setEnabled(false);
        
        mostrar_Registro_De_Fichero_Areas_En_Tabla_Area();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnEliminar_Area = new javax.swing.JButton();
        btnModificar_Area = new javax.swing.JButton();
        btnRegistrar_Area = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtBuscador_Codigo = new javax.swing.JTextField();
        txtBuscador_Area = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblArea = new javax.swing.JTable();
        jButton7 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        txtArea = new javax.swing.JTextField();
        btnGuardar_Datos = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();

        btnEliminar_Area.setText("Eliminar Área");
        btnEliminar_Area.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminar_AreaActionPerformed(evt);
            }
        });

        btnModificar_Area.setText("Modificar Área");
        btnModificar_Area.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificar_AreaActionPerformed(evt);
            }
        });

        btnRegistrar_Area.setText("Registrar Área");
        btnRegistrar_Area.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrar_AreaActionPerformed(evt);
            }
        });

        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtro"));

        jLabel1.setText("Código:");

        jLabel2.setText("Área:");

        txtBuscador_Codigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscador_CodigoActionPerformed(evt);
            }
        });
        txtBuscador_Codigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscador_CodigoKeyTyped(evt);
            }
        });

        txtBuscador_Area.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscador_AreaActionPerformed(evt);
            }
        });
        txtBuscador_Area.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscador_AreaKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscador_Codigo))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(21, 21, 21)
                        .addComponent(txtBuscador_Area, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtBuscador_Codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtBuscador_Area, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 19, Short.MAX_VALUE))
        );

        tblArea.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblArea);

        jButton7.setText("Limpiar");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Registrar Área"));

        jLabel30.setText("Área :");

        txtArea.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAreaKeyTyped(evt);
            }
        });

        btnGuardar_Datos.setText("Guardar Datos");
        btnGuardar_Datos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardar_DatosActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnLimpiar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel30)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGuardar_Datos))
                    .addComponent(txtArea, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(146, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(txtArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpiar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnGuardar_Datos))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 155, Short.MAX_VALUE)
                                .addComponent(btnModificar_Area)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEliminar_Area))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnCerrar))))
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnRegistrar_Area)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnCerrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnEliminar_Area)
                            .addComponent(btnModificar_Area)
                            .addComponent(jButton7))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnRegistrar_Area)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //jButton [Registrar Área]
    private void btnRegistrar_AreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrar_AreaActionPerformed
        registrar_Area();
    }//GEN-LAST:event_btnRegistrar_AreaActionPerformed

    //jButton [Guardar Datos]
    private void btnGuardar_DatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardar_DatosActionPerformed
        
        if(txtArea.getText().trim().isEmpty()){

            JOptionPane.showMessageDialog(null, "No ha llenado el área.");

        }else{
            guardar_Datos_Area();
        }
    }//GEN-LAST:event_btnGuardar_DatosActionPerformed

    //jButton [Eliminar Área]
    private void btnEliminar_AreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminar_AreaActionPerformed
        eliminar_Area();         
    }//GEN-LAST:event_btnEliminar_AreaActionPerformed

    //jButton [Modificar Área]
    private void btnModificar_AreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificar_AreaActionPerformed
        modificar_Area();    
    }//GEN-LAST:event_btnModificar_AreaActionPerformed

    //jButton [Cerrar]
    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        cerrar();
    }//GEN-LAST:event_btnCerrarActionPerformed

    //JButton [Cancelar]
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        cancelar();
    }//GEN-LAST:event_btnCancelarActionPerformed

    //JButton [Limpiar] de Registrar Área
    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiar_Registrar_Area();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void txtBuscador_CodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscador_CodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscador_CodigoActionPerformed

    //Buscador por código
    private void txtBuscador_CodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscador_CodigoKeyTyped
        buscador_Codigo();
    }//GEN-LAST:event_txtBuscador_CodigoKeyTyped

    private void txtBuscador_AreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscador_AreaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscador_AreaActionPerformed

    //Buscador por área
    private void txtBuscador_AreaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscador_AreaKeyTyped
        buscador_Area();
    }//GEN-LAST:event_txtBuscador_AreaKeyTyped

    private void txtAreaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAreaKeyTyped
        char validar = evt.getKeyChar();
        
        if(Character.isDigit(validar)){
            getToolkit().beep();
            evt.consume();
            
            JOptionPane.showMessageDialog(null, "Solo ingrese letras.");
        }
    }//GEN-LAST:event_txtAreaKeyTyped

    //JButton [Limpiar] de los buscadores
    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        limpiar_Buscadores();
    }//GEN-LAST:event_jButton7ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnEliminar_Area;
    private javax.swing.JButton btnGuardar_Datos;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnModificar_Area;
    private javax.swing.JButton btnRegistrar_Area;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblArea;
    private javax.swing.JTextField txtArea;
    private javax.swing.JTextField txtBuscador_Area;
    private javax.swing.JTextField txtBuscador_Codigo;
    // End of variables declaration//GEN-END:variables
}
