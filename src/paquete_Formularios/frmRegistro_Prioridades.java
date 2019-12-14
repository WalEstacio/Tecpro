
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
import paquete_Clases.Prioridad;

public class frmRegistro_Prioridades extends javax.swing.JInternalFrame {

    TableRowSorter trs;
    
    Prioridad objeto_Prioridad = new Prioridad();
    
    DefaultTableModel modelo_Prioridad = new DefaultTableModel();
    
    private void agregar_Columnas_Tabla_Prioridad(){
        modelo_Prioridad.addColumn("Código");
        modelo_Prioridad.addColumn("Fecha De Creación");
        modelo_Prioridad.addColumn("Prioridad");
        tblPrioridad.setModel(modelo_Prioridad);
    }
    
    private void registrar_Prioridad(){
        
        int valor = JOptionPane.showConfirmDialog(this, "¿Desea registrar una nueva prioridad?", "Mensaje", JOptionPane.YES_NO_OPTION);
        if(valor == JOptionPane.YES_OPTION){
            txtPrioridad.setEnabled(true);
            btnLimpiar.setEnabled(true);
            btnCancelar.setEnabled(true);
            btnGuardar_Datos.setEnabled(true);
        }
    }
    private void guardar_Datos_Prioridad(){
        
        int valor = JOptionPane.showConfirmDialog(this, "¿Está seguro que desea registrar una nueva prioridad?", "Mensaje", JOptionPane.YES_NO_OPTION);
        if(valor == JOptionPane.YES_OPTION){
            
            grabar_Datos_De_Controles_En_Fichero_Prioridades();
            
            txtPrioridad.setText(null);
            txtPrioridad.setEnabled(false);    
            btnLimpiar.setEnabled(false);
            btnCancelar.setEnabled(false);
            btnGuardar_Datos.setEnabled(false);
            
            btnModificar_Prioridad.setEnabled(true);
            btnRegistrar_Prioridad.setEnabled(true);
            btnEliminar_Prioridad.setEnabled(true);
        }            
    }
    private void grabar_Datos_De_Controles_En_Fichero_Prioridades(){
          
        FileWriter fw=null;
        PrintWriter pw=null;
        
        try{
            
            fw = new FileWriter("src\\paquete_Ficheros\\Prioridades.txt", true);
            pw = new PrintWriter(fw);

            objeto_Prioridad.setPrioridad_Usuario(txtPrioridad.getText());
            
            pw.println(objeto_Prioridad.codigo_Prioridad() + ";" + objeto_Prioridad.fecha_Prioridad() + ";" + objeto_Prioridad.getPrioridad_Usuario());
 
            pw.close();
            
            cargar_Datos_De_Controles_En_Tabla_Prioridad();
        
        }catch(Exception ex){
            
            JOptionPane.showMessageDialog(null, ex.getMessage());    
        }
    }
    private void cargar_Datos_De_Controles_En_Tabla_Prioridad(){
        
        Object [] fila = new Object[3];
        
        fila[0] = objeto_Prioridad.codigo_Prioridad();
        fila[1] = objeto_Prioridad.fecha_Prioridad();
        fila[2] = objeto_Prioridad.getPrioridad_Usuario();
 
        modelo_Prioridad.addRow(fila); 
    }  
    
    private void modificar_Prioridad(){
        
        int seleccion = tblPrioridad.getSelectedRow();
        
        if(seleccion == 0 || seleccion == 1 || seleccion == 2 || seleccion == 3 || seleccion == 4 || seleccion == 5 || seleccion ==  6 || seleccion == 7 || seleccion == 8 || seleccion == 9 || seleccion == 10){
            
            int valor = JOptionPane.showConfirmDialog(this, "¿Está seguro que lo desea modificar?", "Mensaje", JOptionPane.YES_NO_OPTION);
            
            if(valor == JOptionPane.YES_OPTION){
                
                txtPrioridad.setText(String.valueOf(tblPrioridad.getValueAt(seleccion, 2)));
                txtPrioridad.setEnabled(true);
                btnLimpiar.setEnabled(true);
                btnCancelar.setEnabled(true);
                btnGuardar_Datos.setEnabled(true);
            
                btnModificar_Prioridad.setEnabled(false);
                btnEliminar_Prioridad.setEnabled(false);
                btnRegistrar_Prioridad.setEnabled(false);
            
                eliminar_Fichero_Prioridades();
                crear_Fichero_Prioridades();
                modelo_Prioridad.removeRow(seleccion);   
                mostrar_Registros_De_Tabla_Prioridad_En_Fichero_Prioridades();
            }
            
        }else{
            JOptionPane.showMessageDialog(null, "¡No ha seleccionado una prioridad!");
        }
    }
    
    private void eliminar_Prioridad(){
        
        int seleccion = tblPrioridad.getSelectedRow();
            
        if(seleccion == 0 || seleccion == 1 || seleccion == 2 || seleccion == 3 || seleccion == 4 || seleccion == 5 || seleccion ==  6 || seleccion == 7 || seleccion == 8 || seleccion == 9 || seleccion == 10){       
         
            int valor = JOptionPane.showConfirmDialog(this, "¿Está seguro que lo desea eliminar?", "Mensaje", JOptionPane.YES_NO_OPTION);
          
            if(valor == JOptionPane.YES_OPTION){
              
                eliminar_Fichero_Prioridades();
                crear_Fichero_Prioridades();
                modelo_Prioridad.removeRow(seleccion);   
                mostrar_Registros_De_Tabla_Prioridad_En_Fichero_Prioridades();
            }
            
        }else{            
            JOptionPane.showMessageDialog(null, "¡No ha seleccionado una prioridad!");
        }
    }
    private void eliminar_Fichero_Prioridades(){   
        File archivo = new File("src/paquete_Ficheros/Prioridades.txt");        
        archivo.delete();
    }
    private void crear_Fichero_Prioridades(){
        
        FileWriter fw=null;
        PrintWriter pw=null;
        
        try{
         
            fw = new FileWriter("src\\paquete_Ficheros\\Prioridades.txt", true);
            pw = new PrintWriter(fw);
        
        }catch(Exception ex){
            
            JOptionPane.showMessageDialog(null, ex.getMessage());    
        }
    } 
    private void mostrar_Registros_De_Tabla_Prioridad_En_Fichero_Prioridades(){
        
        FileWriter fw=null;
        PrintWriter pw=null;
        
        try{
         
            fw = new FileWriter("src\\paquete_Ficheros\\Prioridades.txt", true);
            pw = new PrintWriter(fw);
        
            for(int i=0; i<tblPrioridad.getRowCount(); i++){
            
            pw.println(String.valueOf(tblPrioridad.getValueAt(i, 0)) + ";" +
                    String.valueOf(tblPrioridad.getValueAt(i, 1)) + ";" +
                    String.valueOf(tblPrioridad.getValueAt(i, 2)));          
            }
        
            pw.close();
        
        }catch(Exception ex){
            
            JOptionPane.showMessageDialog(null, ex.getMessage());    
        }   
    }
    
    private void mostrar_Registro_De_Fichero_Prioridades_En_Tabla_Prioridad(){
        
        try{
            File archivo = new File("src/paquete_Ficheros/Prioridades.txt");
            
            if(archivo.exists()){
                
                FileReader reader = new FileReader(archivo);
                BufferedReader br = new BufferedReader(reader);
                
                String linea;
                
                while((linea = br.readLine()) != null){
                
                StringTokenizer token = new StringTokenizer(linea, ";");
                
                String codigo = token.nextToken().trim();
                String fecha = token.nextToken().trim();
                String prioridad = token.nextToken().trim();
                
                Object[] obj = new Object[]{
                    
                    codigo, fecha, prioridad
                };
                        
                modelo_Prioridad.addRow(obj);
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
    
    private void limpiar_Buscador_Codigo_Prioridad(){
        txtBuscador_Codigo_Prioridad.setText(null);
    }
    
    private void limpiar(){
        txtPrioridad.setText(null);
    }
    
    private void cancelar(){
        int valor = JOptionPane.showConfirmDialog(this, "¿Está seguro que lo desea cancelar?", "Mensaje", JOptionPane.YES_NO_OPTION);
        if(valor == JOptionPane.YES_OPTION){
            txtPrioridad.setText(null);
            txtPrioridad.setEnabled(false);
            btnLimpiar.setEnabled(false);
            btnCancelar.setEnabled(false);
            btnGuardar_Datos.setEnabled(false);
            
            btnModificar_Prioridad.setEnabled(true);
            btnModificar_Prioridad.setEnabled(true);
            btnRegistrar_Prioridad.setEnabled(true);
            btnEliminar_Prioridad.setEnabled(true);
        } 
    }
    
    private void cerrar(){
        int valor = JOptionPane.showConfirmDialog(this, "¿Está seguro que lo desea cerrar?", "Mensaje", JOptionPane.YES_NO_OPTION);
        if(valor == JOptionPane.YES_OPTION){
            this.setVisible(false);
        }   
    }
    
    public frmRegistro_Prioridades() {
        initComponents();
        
        agregar_Columnas_Tabla_Prioridad();
        
        txtPrioridad.setEnabled(false);
        
        mostrar_Registro_De_Fichero_Prioridades_En_Tabla_Prioridad();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPrioridad = new javax.swing.JTable();
        btnModificar_Prioridad = new javax.swing.JButton();
        btnEliminar_Prioridad = new javax.swing.JButton();
        btnRegistrar_Prioridad = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtBuscador_Codigo_Prioridad = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        txtPrioridad = new javax.swing.JTextField();
        btnGuardar_Datos = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();

        tblPrioridad.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblPrioridad);

        btnModificar_Prioridad.setText("Modificar Prioridad");
        btnModificar_Prioridad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificar_PrioridadActionPerformed(evt);
            }
        });

        btnEliminar_Prioridad.setText("Eliminar Prioridad");
        btnEliminar_Prioridad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminar_PrioridadActionPerformed(evt);
            }
        });

        btnRegistrar_Prioridad.setText("Registrar Prioridad");
        btnRegistrar_Prioridad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrar_PrioridadActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtro"));

        jLabel1.setText("Prioridad:");

        txtBuscador_Codigo_Prioridad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscador_Codigo_PrioridadKeyTyped(evt);
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
                .addComponent(txtBuscador_Codigo_Prioridad, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtBuscador_Codigo_Prioridad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton1.setText("Limpiar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos"));

        jLabel30.setText("Prioridad:");

        txtPrioridad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrioridadKeyTyped(evt);
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
                .addComponent(jLabel30)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGuardar_Datos))
                    .addComponent(txtPrioridad, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLimpiar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(txtPrioridad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpiar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar_Datos)
                    .addComponent(btnCancelar)))
        );

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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 12, Short.MAX_VALUE)
                                .addComponent(btnModificar_Prioridad)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEliminar_Prioridad))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnRegistrar_Prioridad)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton8)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 16, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnEliminar_Prioridad)
                            .addComponent(btnModificar_Prioridad)))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnRegistrar_Prioridad)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton8))
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
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //jButton [Registrar Prioridad]
    private void btnRegistrar_PrioridadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrar_PrioridadActionPerformed
        registrar_Prioridad();
    }//GEN-LAST:event_btnRegistrar_PrioridadActionPerformed

    //jButton [Guardar Datos]
    private void btnGuardar_DatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardar_DatosActionPerformed
        
        if(txtPrioridad.getText().trim().isEmpty()){

            JOptionPane.showMessageDialog(null, "No ha llenado la prioridad.");

        }else{
            guardar_Datos_Prioridad();
        }
    }//GEN-LAST:event_btnGuardar_DatosActionPerformed

    //jButton [Modificar Prioridad]
    private void btnModificar_PrioridadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificar_PrioridadActionPerformed
        modificar_Prioridad();
    }//GEN-LAST:event_btnModificar_PrioridadActionPerformed

    //jButton [Eliminar Prioridad]
    private void btnEliminar_PrioridadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminar_PrioridadActionPerformed
        eliminar_Prioridad();
    }//GEN-LAST:event_btnEliminar_PrioridadActionPerformed

    private void txtBuscador_Codigo_PrioridadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscador_Codigo_PrioridadKeyTyped
        txtBuscador_Codigo_Prioridad.addKeyListener(new KeyAdapter() {
            
            @Override
            public void keyReleased(KeyEvent ke) {
                
                trs.setRowFilter(RowFilter.regexFilter("(?i)" + txtBuscador_Codigo_Prioridad.getText(), 2));
            }
        });
        
        trs = new TableRowSorter(modelo_Prioridad);
        
        tblPrioridad.setRowSorter(trs);
    }//GEN-LAST:event_txtBuscador_Codigo_PrioridadKeyTyped

    //JButton [Limpiar]
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        limpiar_Buscador_Codigo_Prioridad();
    }//GEN-LAST:event_jButton1ActionPerformed

    //JButton [Limpiar]
    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiar();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    //JButton [Cancelar]
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        cancelar();
    }//GEN-LAST:event_btnCancelarActionPerformed

    //JButton [Cerrar]
    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        cerrar();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void txtPrioridadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrioridadKeyTyped
        char validar = evt.getKeyChar();
        
        if(Character.isDigit(validar)){
            getToolkit().beep();
            evt.consume();
            
            JOptionPane.showMessageDialog(null, "Solo ingrese letras.");
        }
    }//GEN-LAST:event_txtPrioridadKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar_Prioridad;
    private javax.swing.JButton btnGuardar_Datos;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnModificar_Prioridad;
    private javax.swing.JButton btnRegistrar_Prioridad;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPrioridad;
    private javax.swing.JTextField txtBuscador_Codigo_Prioridad;
    private javax.swing.JTextField txtPrioridad;
    // End of variables declaration//GEN-END:variables
}
