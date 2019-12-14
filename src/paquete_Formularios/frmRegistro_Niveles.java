
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
import paquete_Clases.Nivel;

public class frmRegistro_Niveles extends javax.swing.JInternalFrame {

    TableRowSorter trs;
    
    Nivel objeto_Nivel = new Nivel();
    
    DefaultTableModel modelo_Nivel = new DefaultTableModel();
    
    private void agregar_Columnas_Tabla_Nivel(){
        modelo_Nivel.addColumn("Código");
        modelo_Nivel.addColumn("Fecha De Creación");
        modelo_Nivel.addColumn("Nivel");
        tblNivel.setModel(modelo_Nivel);
    }
    
    private void registrar_Nivel(){
        
        int valor = JOptionPane.showConfirmDialog(this, "¿Desea registrar un nuevo nivel?", "Mensaje", JOptionPane.YES_NO_OPTION);
        if(valor == JOptionPane.YES_OPTION){
            txtNivel.setEnabled(true);
            btnLimpiar.setEnabled(true);
            btnCancelar.setEnabled(true);
            btnGuardar_Datos.setEnabled(true);
        }

    }
    private void guardar_Datos_Nivel(){
        
        int valor = JOptionPane.showConfirmDialog(this, "¿Está seguro que desea registrar una nueva área?", "Mensaje", JOptionPane.YES_NO_OPTION);
        if(valor == JOptionPane.YES_OPTION){
            
            grabar_Datos_De_Controles_En_Fichero_Niveles();
            
            txtNivel.setText(null);
            txtNivel.setEnabled(false);    
            btnLimpiar.setEnabled(false);
            btnCancelar.setEnabled(false);
            btnGuardar_Datos.setEnabled(false);
            
            btnModificar_Nivel.setEnabled(true);
            btnRegistrar_Nivel.setEnabled(true);
            btnEliminar_Nivel.setEnabled(true);
        }           
    }
    private void grabar_Datos_De_Controles_En_Fichero_Niveles(){
          
        FileWriter fw=null;
        PrintWriter pw=null;
        
        try{
            
            fw = new FileWriter("src\\paquete_Ficheros\\Niveles.txt", true);
            pw = new PrintWriter(fw);

            objeto_Nivel.setNivel_Asistente(txtNivel.getText());
            
            pw.println(objeto_Nivel.codigo_Nivel() + ";" + objeto_Nivel.fecha_Nivel() + ";" + objeto_Nivel.getNivel_Asistente());
 
            pw.close();
            
            cargar_Datos_De_Controles_En_Tabla_Nivel();
        
        }catch(Exception ex){
            
            JOptionPane.showMessageDialog(null, ex.getMessage());    
        }
    }
    private void cargar_Datos_De_Controles_En_Tabla_Nivel(){
        
        Object [] fila = new Object[3];
        
        fila[0] = objeto_Nivel.codigo_Nivel();
        fila[1] = objeto_Nivel.fecha_Nivel();
        fila[2] = objeto_Nivel.getNivel_Asistente();
 
        modelo_Nivel.addRow(fila); 
    }  
    
    private void modificar_Nivel(){
        
        int seleccion = tblNivel.getSelectedRow();
        
        if(seleccion == 0 || seleccion == 1 || seleccion == 2 || seleccion == 3 || seleccion == 4 || seleccion == 5 || seleccion ==  6 || seleccion == 7 || seleccion == 8 || seleccion == 9 || seleccion == 10){
            
            int valor = JOptionPane.showConfirmDialog(this, "¿Está seguro que lo desea modificar?", "Mensaje", JOptionPane.YES_NO_OPTION);
            
            if(valor == JOptionPane.YES_OPTION){
                
                txtNivel.setText(String.valueOf(tblNivel.getValueAt(seleccion, 2)));
                txtNivel.setEnabled(true);
                btnLimpiar.setEnabled(true);
                btnCancelar.setEnabled(true);
                btnGuardar_Datos.setEnabled(true);
            
                btnModificar_Nivel.setEnabled(false);
                btnEliminar_Nivel.setEnabled(false);
                btnRegistrar_Nivel.setEnabled(false);
            
                eliminar_Fichero_Niveles();
                crear_Fichero_Niveles();
                modelo_Nivel.removeRow(seleccion);   
                mostrar_Registros_De_Tabla_Nivel_En_Fichero_Niveles();
            }
            
        }else{
            JOptionPane.showMessageDialog(null, "¡No ha seleccionado un nivel!");
        }

    }
    
    private void eliminar_Nivel(){
        
        int seleccion = tblNivel.getSelectedRow();
            
        if(seleccion == 0 || seleccion == 1 || seleccion == 2 || seleccion == 3 || seleccion == 4 || seleccion == 5 || seleccion ==  6 || seleccion == 7 || seleccion == 8 || seleccion == 9 || seleccion == 10){       
         
            int valor = JOptionPane.showConfirmDialog(this, "¿Está seguro que lo desea eliminar?", "Mensaje", JOptionPane.YES_NO_OPTION);
          
            if(valor == JOptionPane.YES_OPTION){
              
                eliminar_Fichero_Niveles();
                crear_Fichero_Niveles();
                modelo_Nivel.removeRow(seleccion);   
                mostrar_Registros_De_Tabla_Nivel_En_Fichero_Niveles();
            }
            
        }else{            
            JOptionPane.showMessageDialog(null, "¡No ha seleccionado un nivel!");
        }
    }
    private void eliminar_Fichero_Niveles(){   
        File archivo = new File("src/paquete_Ficheros/Niveles.txt");        
        archivo.delete();
    }
    private void crear_Fichero_Niveles(){
        
        FileWriter fw=null;
        PrintWriter pw=null;
        
        try{
         
            fw = new FileWriter("src\\paquete_Ficheros\\Niveles.txt", true);
            pw = new PrintWriter(fw);
        
        }catch(Exception ex){
            
            JOptionPane.showMessageDialog(null, ex.getMessage());    
        }
    } 
    private void mostrar_Registros_De_Tabla_Nivel_En_Fichero_Niveles(){
        
        FileWriter fw=null;
        PrintWriter pw=null;
        
        try{
         
            fw = new FileWriter("src\\paquete_Ficheros\\Niveles.txt", true);
            pw = new PrintWriter(fw);
        
            for(int i=0; i<tblNivel.getRowCount(); i++){
            
            pw.println(String.valueOf(tblNivel.getValueAt(i, 0)) + ";" +
                    String.valueOf(tblNivel.getValueAt(i, 1)) + ";" +
                    String.valueOf(tblNivel.getValueAt(i, 2)));          
            }
        
            pw.close();
        
        }catch(Exception ex){
            
            JOptionPane.showMessageDialog(null, ex.getMessage());    
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
    
    private void cerrar(){  
        int valor = JOptionPane.showConfirmDialog(this, "¿Está seguro que lo desea cerrar?", "Mensaje", JOptionPane.YES_NO_OPTION);
        if(valor == JOptionPane.YES_OPTION){
            this.setVisible(false);
        }      
    }
    
    private void limpiar_Codigo_Nivel(){
        txtNivel.setText(null);
    }
    
    private void limpiar(){
        txtNivel.setText(null);
    }
    
    private void cancelar(){
        int valor = JOptionPane.showConfirmDialog(this, "¿Está seguro que lo desea cancelar?", "Mensaje", JOptionPane.YES_NO_OPTION);
        if(valor == JOptionPane.YES_OPTION){
            txtNivel.setText(null);
            txtNivel.setEnabled(false);
            btnLimpiar.setEnabled(false);
            btnCancelar.setEnabled(false);
            btnGuardar_Datos.setEnabled(false);
            
            btnModificar_Nivel.setEnabled(true);
            btnModificar_Nivel.setEnabled(true);
            btnRegistrar_Nivel.setEnabled(true);
            btnEliminar_Nivel.setEnabled(true);
        } 
    }
    
    public frmRegistro_Niveles() {
        initComponents();
        
        agregar_Columnas_Tabla_Nivel();
        
        txtNivel.setEnabled(false);
        
        mostrar_Registro_De_Fichero_Niveles_En_Tabla_Nivel();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblNivel = new javax.swing.JTable();
        btnEliminar_Nivel = new javax.swing.JButton();
        btnModificar_Nivel = new javax.swing.JButton();
        btnRegistrar_Nivel = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        txtNivel = new javax.swing.JTextField();
        btnGuardar_Datos = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtBuscador_Codigo_Nivel = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        tblNivel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblNivel);

        btnEliminar_Nivel.setText("Eliminar Nivel");
        btnEliminar_Nivel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminar_NivelActionPerformed(evt);
            }
        });

        btnModificar_Nivel.setText("Modificar Nivel");
        btnModificar_Nivel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificar_NivelActionPerformed(evt);
            }
        });

        btnRegistrar_Nivel.setText("Registrar Nivel");
        btnRegistrar_Nivel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrar_NivelActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos"));

        jLabel30.setText("Nivel:");

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
                    .addComponent(txtNivel, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(txtNivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpiar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar_Datos)
                    .addComponent(btnCancelar)))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtro"));

        jLabel1.setText("Nivel:");

        txtBuscador_Codigo_Nivel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscador_Codigo_NivelKeyTyped(evt);
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
                .addComponent(txtBuscador_Codigo_Nivel, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtBuscador_Codigo_Nivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jButton1.setText("Limpiar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton6.setText("Cerrar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 545, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnModificar_Nivel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnEliminar_Nivel))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButton6))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnRegistrar_Nivel)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnEliminar_Nivel)
                            .addComponent(btnModificar_Nivel)
                            .addComponent(jButton1)))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRegistrar_Nivel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
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

    //jButton [Registrar Nivel]
    private void btnRegistrar_NivelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrar_NivelActionPerformed
        registrar_Nivel();
    }//GEN-LAST:event_btnRegistrar_NivelActionPerformed

    //jButton [Modificar Nivel]
    private void btnModificar_NivelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificar_NivelActionPerformed
        modificar_Nivel();
    }//GEN-LAST:event_btnModificar_NivelActionPerformed

    //jButton [Eliminar Nivel]
    private void btnEliminar_NivelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminar_NivelActionPerformed
        eliminar_Nivel();
    }//GEN-LAST:event_btnEliminar_NivelActionPerformed

    //jButton [Guardar Datos]
    private void btnGuardar_DatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardar_DatosActionPerformed
        
        if(txtNivel.getText().trim().isEmpty()){

            JOptionPane.showMessageDialog(null, "No ha llenado el nivel.");

        }else{
            guardar_Datos_Nivel();
        }
    }//GEN-LAST:event_btnGuardar_DatosActionPerformed

    private void txtBuscador_Codigo_NivelKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscador_Codigo_NivelKeyTyped
        txtBuscador_Codigo_Nivel.addKeyListener(new KeyAdapter() {
            
            @Override
            public void keyReleased(KeyEvent ke) {
                
                trs.setRowFilter(RowFilter.regexFilter("(?i)" + txtBuscador_Codigo_Nivel.getText(), 2));
            }
        });
        
        trs = new TableRowSorter(modelo_Nivel);
        
        tblNivel.setRowSorter(trs);
    }//GEN-LAST:event_txtBuscador_Codigo_NivelKeyTyped

    //JButton [Cerrar]
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        cerrar();
    }//GEN-LAST:event_jButton6ActionPerformed

    //JButton [Limpiar] del buscador por codigo de nivel
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        limpiar_Codigo_Nivel();
    }//GEN-LAST:event_jButton1ActionPerformed

    //JButton [Limpiar]
    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiar();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    //JButton [Cancelar]
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        cancelar();
    }//GEN-LAST:event_btnCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar_Nivel;
    private javax.swing.JButton btnGuardar_Datos;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnModificar_Nivel;
    private javax.swing.JButton btnRegistrar_Nivel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblNivel;
    private javax.swing.JTextField txtBuscador_Codigo_Nivel;
    private javax.swing.JTextField txtNivel;
    // End of variables declaration//GEN-END:variables
}
