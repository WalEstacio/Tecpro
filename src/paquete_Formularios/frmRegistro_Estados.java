
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
import paquete_Clases.Estado;

public class frmRegistro_Estados extends javax.swing.JInternalFrame {

    TableRowSorter trs;
    
    Estado objeto_Estado = new Estado();
    
    DefaultTableModel modelo_Estado = new DefaultTableModel();
    
    private void agregar_Columnas_Tabla_Estado(){
        modelo_Estado.addColumn("Código");
        modelo_Estado.addColumn("Fecha De Creación");
        modelo_Estado.addColumn("Estado");
        tblEstado.setModel(modelo_Estado);
    }
    
    private void registrar_Estado(){
        
        int valor = JOptionPane.showConfirmDialog(this, "¿Desea registrar una nueva área?", "Mensaje", JOptionPane.YES_NO_OPTION);
        if(valor == JOptionPane.YES_OPTION){
            txtEstado.setEnabled(true);
            btnLimpiar.setEnabled(true);
            btnCancelar.setEnabled(true);
            btnGuardar_Datos.setEnabled(true);
        }
    }
    private void guardar_Datos_Estado(){
        
        int valor = JOptionPane.showConfirmDialog(this, "¿Está seguro que desea registrar una nueva área?", "Mensaje", JOptionPane.YES_NO_OPTION);
        if(valor == JOptionPane.YES_OPTION){
            
            grabar_Datos_De_Controles_En_Fichero_Estados();
            
            txtEstado.setText(null);
            txtEstado.setEnabled(false);    
            btnLimpiar.setEnabled(false);
            btnCancelar.setEnabled(false);
            btnGuardar_Datos.setEnabled(false);
            
            btnModificar_Estado.setEnabled(true);
            btnRegistrar_Estado.setEnabled(true);
            btnEliminar_Estado.setEnabled(true);
        }      
    }
    private void grabar_Datos_De_Controles_En_Fichero_Estados(){
          
        FileWriter fw=null;
        PrintWriter pw=null;
        
        try{
            
            fw = new FileWriter("src\\paquete_Ficheros\\Estados.txt", true);
            pw = new PrintWriter(fw);

            objeto_Estado.setEstado_Ticket(txtEstado.getText());
            
            pw.println(objeto_Estado.codigo_Estado() + ";" + objeto_Estado.fecha_Estado() + ";" + objeto_Estado.getEstado_Ticket());
 
            pw.close();
            
            cargar_Datos_De_Controles_En_Tabla_Estado();
        
        }catch(Exception ex){
            
            JOptionPane.showMessageDialog(null, ex.getMessage());    
        }
    }
    private void cargar_Datos_De_Controles_En_Tabla_Estado(){
        
        Object [] fila = new Object[3];
        
        fila[0] = objeto_Estado.codigo_Estado();
        fila[1] = objeto_Estado.fecha_Estado();
        fila[2] = objeto_Estado.getEstado_Ticket();
 
        modelo_Estado.addRow(fila); 
    }  
    
    private void modificar_Estado(){
        
        int seleccion = tblEstado.getSelectedRow();
        
        if(seleccion == 0 || seleccion == 1 || seleccion == 2 || seleccion == 3 || seleccion == 4 || seleccion == 5 || seleccion ==  6 || seleccion == 7 || seleccion == 8 || seleccion == 9 || seleccion == 10){
            
            int valor = JOptionPane.showConfirmDialog(this, "¿Está seguro que lo desea modificar?", "Mensaje", JOptionPane.YES_NO_OPTION);
            
            if(valor == JOptionPane.YES_OPTION){
                
                txtEstado.setText(String.valueOf(tblEstado.getValueAt(seleccion, 2)));
                txtEstado.setEnabled(true);
                btnLimpiar.setEnabled(true);
                btnCancelar.setEnabled(true);
                btnGuardar_Datos.setEnabled(true);
            
                btnModificar_Estado.setEnabled(false);
                btnEliminar_Estado.setEnabled(false);
                btnRegistrar_Estado.setEnabled(false);
            
                eliminar_Fichero_Estados();
                crear_Fichero_Estados();
                modelo_Estado.removeRow(seleccion);   
                mostrar_Registros_De_Tabla_Estado_En_Fichero_Estados();
            }
            
        }else{
            JOptionPane.showMessageDialog(null, "¡No ha seleccionado un área!");
        }
 
    }
    
    private void eliminar_Estado(){
        
        int seleccion = tblEstado.getSelectedRow();
            
        if(seleccion == 0 || seleccion == 1 || seleccion == 2 || seleccion == 3 || seleccion == 4 || seleccion == 5 || seleccion ==  6 || seleccion == 7 || seleccion == 8 || seleccion == 9 || seleccion == 10){       
         
            int valor = JOptionPane.showConfirmDialog(this, "¿Está seguro que lo desea eliminar?", "Mensaje", JOptionPane.YES_NO_OPTION);
          
            if(valor == JOptionPane.YES_OPTION){
              
                eliminar_Fichero_Estados();
                crear_Fichero_Estados();
                modelo_Estado.removeRow(seleccion);   
                mostrar_Registros_De_Tabla_Estado_En_Fichero_Estados();
            }
            
        }else{            
            JOptionPane.showMessageDialog(null, "¡No ha seleccionado un área!");
        }
    }
    private void eliminar_Fichero_Estados(){   
        File archivo = new File("src/paquete_Ficheros/Estados.txt");        
        archivo.delete();
    }
    private void crear_Fichero_Estados(){
        
        FileWriter fw=null;
        PrintWriter pw=null;
        
        try{
         
            fw = new FileWriter("src\\paquete_Ficheros\\Estados.txt", true);
            pw = new PrintWriter(fw);
        
        }catch(Exception ex){
            
            JOptionPane.showMessageDialog(null, ex.getMessage());    
        }
    } 
    private void mostrar_Registros_De_Tabla_Estado_En_Fichero_Estados(){
        
        FileWriter fw=null;
        PrintWriter pw=null;
        
        try{
         
            fw = new FileWriter("src\\paquete_Ficheros\\Estados.txt", true);
            pw = new PrintWriter(fw);
        
            for(int i=0; i<tblEstado.getRowCount(); i++){
            
            pw.println(String.valueOf(tblEstado.getValueAt(i, 0)) + ";" +
                    String.valueOf(tblEstado.getValueAt(i, 1)) + ";" +
                    String.valueOf(tblEstado.getValueAt(i, 2)));          
            }
        
            pw.close();
        
        }catch(Exception ex){
            
            JOptionPane.showMessageDialog(null, ex.getMessage());    
        }   
    }
    
    private void mostrar_Registro_De_Fichero_Estados_En_Tabla_Estado(){
        
        try{
            File archivo = new File("src/paquete_Ficheros/Estados.txt");
            
            if(archivo.exists()){
                
                FileReader reader = new FileReader(archivo);
                BufferedReader br = new BufferedReader(reader);
                
                String linea;
                
                while((linea = br.readLine()) != null){
                
                StringTokenizer token = new StringTokenizer(linea, ";");
                
                String codigo = token.nextToken().trim();
                String fecha = token.nextToken().trim();
                String estado = token.nextToken().trim();
                
                Object[] obj = new Object[]{
                    
                    codigo, fecha, estado
                };
                        
                modelo_Estado.addRow(obj);
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
     
    private void cancelar(){
        int valor = JOptionPane.showConfirmDialog(this, "¿Está seguro que lo desea cancelar?", "Mensaje", JOptionPane.YES_NO_OPTION);
        if(valor == JOptionPane.YES_OPTION){
            txtEstado.setText(null);
            txtEstado.setEnabled(false);
            btnLimpiar.setEnabled(false);
            btnCancelar.setEnabled(false);
            btnGuardar_Datos.setEnabled(false);
            
            btnModificar_Estado.setEnabled(true);
            btnModificar_Estado.setEnabled(true);
            btnRegistrar_Estado.setEnabled(true);
            btnEliminar_Estado.setEnabled(true);
        } 
    }
    
    private void cerrar(){  
        int valor = JOptionPane.showConfirmDialog(this, "¿Está seguro que lo desea cerrar?", "Mensaje", JOptionPane.YES_NO_OPTION);
        if(valor == JOptionPane.YES_OPTION){
            this.setVisible(false);
        }      
    }
    
    private void limpiar_Buscador_Estado(){
        txtBuscador_Codigo_Estado.setText(null);
    }
    
    private void limpiar(){
        txtEstado.setText(null);
    }
    
    public frmRegistro_Estados() {
        initComponents();
        
        agregar_Columnas_Tabla_Estado();
        
        txtEstado.setEnabled(false);
        
        mostrar_Registro_De_Fichero_Estados_En_Tabla_Estado();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEstado = new javax.swing.JTable();
        btnModificar_Estado = new javax.swing.JButton();
        btnEliminar_Estado = new javax.swing.JButton();
        btnRegistrar_Estado = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtBuscador_Codigo_Estado = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        txtEstado = new javax.swing.JTextField();
        btnGuardar_Datos = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();

        tblEstado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblEstado);

        btnModificar_Estado.setText("Modificar Estado");
        btnModificar_Estado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificar_EstadoActionPerformed(evt);
            }
        });

        btnEliminar_Estado.setText("Eliminar Estado");
        btnEliminar_Estado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminar_EstadoActionPerformed(evt);
            }
        });

        btnRegistrar_Estado.setText("Registrar Estado");
        btnRegistrar_Estado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrar_EstadoActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtro"));

        jLabel1.setText("Estado:");

        txtBuscador_Codigo_Estado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscador_Codigo_EstadoKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtBuscador_Codigo_Estado, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtBuscador_Codigo_Estado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jButton1.setText("Limpiar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos"));

        jLabel30.setText("Estado:");

        txtEstado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEstadoKeyTyped(evt);
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
                    .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButton8))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnRegistrar_Estado)
                        .addGap(173, 173, 173)
                        .addComponent(btnModificar_Estado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar_Estado))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrar_Estado)
                    .addComponent(btnModificar_Estado)
                    .addComponent(btnEliminar_Estado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //jButton [Registrar Estado]
    private void btnRegistrar_EstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrar_EstadoActionPerformed
        registrar_Estado();
    }//GEN-LAST:event_btnRegistrar_EstadoActionPerformed

    //jButton [Guardar Datos]
    private void btnGuardar_DatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardar_DatosActionPerformed

        if(txtEstado.getText().trim().isEmpty()){

            JOptionPane.showMessageDialog(null, "No ha llenado el estado.");

        }else{
            guardar_Datos_Estado();
        }
    }//GEN-LAST:event_btnGuardar_DatosActionPerformed

    //jButton [Modificar Estado]
    private void btnModificar_EstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificar_EstadoActionPerformed
        modificar_Estado();
    }//GEN-LAST:event_btnModificar_EstadoActionPerformed

    //jButton [Eliminar Estado]
    private void btnEliminar_EstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminar_EstadoActionPerformed
        eliminar_Estado();
    }//GEN-LAST:event_btnEliminar_EstadoActionPerformed

    private void txtBuscador_Codigo_EstadoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscador_Codigo_EstadoKeyTyped
        txtBuscador_Codigo_Estado.addKeyListener(new KeyAdapter() {
            
            @Override
            public void keyReleased(KeyEvent ke) {
                
                trs.setRowFilter(RowFilter.regexFilter("(?i)" + txtBuscador_Codigo_Estado.getText(), 2));
            }
        });
        
        trs = new TableRowSorter(modelo_Estado);
        
        tblEstado.setRowSorter(trs);
    }//GEN-LAST:event_txtBuscador_Codigo_EstadoKeyTyped

    //JButton [Cerrar]
    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        cerrar();
    }//GEN-LAST:event_jButton8ActionPerformed

    //JButton [Limpiar] del buscador por estado
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        limpiar_Buscador_Estado();
    }//GEN-LAST:event_jButton1ActionPerformed

    //JButton [Limpiar]
    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiar();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    //JButton [Cancelar]
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        cancelar();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtEstadoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEstadoKeyTyped
        char validar = evt.getKeyChar();
        
        if(Character.isDigit(validar)){
            getToolkit().beep();
            evt.consume();
            
            JOptionPane.showMessageDialog(null, "Solo ingrese letras.");
        }
    }//GEN-LAST:event_txtEstadoKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar_Estado;
    private javax.swing.JButton btnGuardar_Datos;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnModificar_Estado;
    private javax.swing.JButton btnRegistrar_Estado;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblEstado;
    private javax.swing.JTextField txtBuscador_Codigo_Estado;
    private javax.swing.JTextField txtEstado;
    // End of variables declaration//GEN-END:variables
}
