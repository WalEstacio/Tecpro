
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
import paquete_Clases.Ticket;

public class frmRegistro_Tickets extends javax.swing.JInternalFrame {

    TableRowSorter trs;
    TableRowSorter trs_2;
    TableRowSorter trs_3;
    TableRowSorter trs_4;
    TableRowSorter trs_5;
    TableRowSorter trs_6; 
    TableRowSorter trs_7;
    TableRowSorter trs_8;
    TableRowSorter trs_9;
    TableRowSorter trs_10;
    TableRowSorter trs_11;
    TableRowSorter trs_12; 
    TableRowSorter trs_13;
    TableRowSorter trs_14;
    TableRowSorter trs_15;
    TableRowSorter trs_16;
    TableRowSorter trs_17;
    TableRowSorter trs_18; 
    TableRowSorter trs_19;
    TableRowSorter trs_20;
    TableRowSorter trs_21;
    TableRowSorter trs_22;
    TableRowSorter trs_23;
    TableRowSorter trs_24;
    
    Ticket objeto_Ticket = new Ticket();
    
    DefaultTableModel modelo_Ticket = new DefaultTableModel();
    DefaultTableModel modelo_Usuario = new DefaultTableModel();
    DefaultTableModel modelo_Asistente = new DefaultTableModel();
    DefaultTableModel modelo_Prioridad = new DefaultTableModel();
    DefaultTableModel modelo_Estado = new DefaultTableModel();
    
    private void agregar_Columnas_Tabla_Ticket(){
        modelo_Ticket.addColumn("Código"); //0
        modelo_Ticket.addColumn("Fecha De Creación Del Ticket"); 
        modelo_Ticket.addColumn("Nombres Y Apellidos Del Usuario");
        modelo_Ticket.addColumn("Correo Electrónico Del Usuario");
        modelo_Ticket.addColumn("Telefono Del Usuario");
        modelo_Ticket.addColumn("Área Del Usuario");
        modelo_Ticket.addColumn("Prioridad Del Usuario"); 
        modelo_Ticket.addColumn("Asunto Del Usuario");
        modelo_Ticket.addColumn("Observacion Del Usuario");
        modelo_Ticket.addColumn("Fecha De La Creación De La Observación Del Asistente");
        modelo_Ticket.addColumn("Nombres Y Apellidos Del Asistente");
        modelo_Ticket.addColumn("Correo Del Asistente");
        modelo_Ticket.addColumn("Teléfono Del Asistente");
        modelo_Ticket.addColumn("Área Del Asistente");
        modelo_Ticket.addColumn("Nivel Del Asistente");
        modelo_Ticket.addColumn("Observacion Del Asistente"); 
        modelo_Ticket.addColumn("Estado");
        tblTicket.setModel(modelo_Ticket);
    }
    private void agregar_Columnas_Tabla_Usuario(){
        modelo_Usuario.addColumn("Código");
        modelo_Usuario.addColumn("Fecha De Creación");
        modelo_Usuario.addColumn("Nombres Y Apellidos");
        modelo_Usuario.addColumn("Correo Electrónico");
        modelo_Usuario.addColumn("Teléfono");
        modelo_Usuario.addColumn("Área");
        tblUsuario.setModel(modelo_Usuario);
    }
    private void agregar_Columnas_Tabla_Asistente(){
        modelo_Asistente.addColumn("Código");
        modelo_Asistente.addColumn("Fecha");
        modelo_Asistente.addColumn("Nombres Y Apellidos");
        modelo_Asistente.addColumn("Correo Electrónico");
        modelo_Asistente.addColumn("Teléfono");
        modelo_Asistente.addColumn("Área");
        modelo_Asistente.addColumn("Nivel");
        tblAsistente.setModel(modelo_Asistente);
    }
    private void agregar_Columnas_Tabla_Prioridad(){
        modelo_Prioridad.addColumn("Código");
        modelo_Prioridad.addColumn("Fecha De Creación");
        modelo_Prioridad.addColumn("Prioridad");
        tblPrioridad.setModel(modelo_Prioridad);
    }
    private void agregar_Columnas_Tabla_Estado(){
        modelo_Estado.addColumn("Código");
        modelo_Estado.addColumn("Fecha De Creación");
        modelo_Estado.addColumn("Estado");
        tblEstado.setModel(modelo_Estado);
    }
    
    private void registrar_Ticket(){
        
        int valor = JOptionPane.showConfirmDialog(this, "¿Desea registrar un nuevo ticket?", "Mensaje", JOptionPane.YES_NO_OPTION);
        if(valor == JOptionPane.YES_OPTION){
            
            txtNombres_Y_Apellidos_Usuario.setEnabled(true);
            txtCorreo_Usuario.setEnabled(true);
            txtTelefono_Usuario.setEnabled(true);
            txtArea_Usuario.setEnabled(true);
            txtPrioridad_Usuario.setEnabled(true);
            txtAsunto_Usuario.setEnabled(true);
            txtObservacion_Usuario.setEnabled(true);
            txtNombres_Y_Apellidos_Asistente.setEnabled(true);
            txtCorreo_Asistente.setEnabled(true);
            txtTelefono_Asistente.setEnabled(true);
            txtArea_Asistente.setEnabled(true);        
            txtNivel_Asistente.setEnabled(true);
            txtEstado_Ticket.setEnabled(true);
            txtObservacion_Asistente.setEnabled(true);
            
            jTabbedPane1.setEnabledAt(1, true);
            jTabbedPane1.setEnabledAt(0, false);
            jTabbedPane1.setSelectedIndex(1);
        }
    }
    private void guardar_Datos_Ticket(){
        txtNombres_Y_Apellidos_Usuario.setEnabled(false);
        txtCorreo_Usuario.setEnabled(false);
        txtTelefono_Usuario.setEnabled(false);
        txtArea_Usuario.setEnabled(false);
        txtPrioridad_Usuario.setEnabled(false);
        txtAsunto_Usuario.setEnabled(false);
        txtObservacion_Usuario.setEnabled(false);
        txtNombres_Y_Apellidos_Asistente.setEnabled(false);
        txtCorreo_Asistente.setEnabled(false);
        txtTelefono_Asistente.setEnabled(false);
        txtArea_Asistente.setEnabled(false);        
        txtNivel_Asistente.setEnabled(false);
        txtEstado_Ticket.setEnabled(false);
        txtObservacion_Asistente.setEnabled(false);
        jTabbedPane1.setEnabledAt(1, false);
        grabar_Datos_De_Controles_En_Fichero_Tickets();
                
    }
    private void grabar_Datos_De_Controles_En_Fichero_Tickets(){
          
        FileWriter fw=null;
        PrintWriter pw=null;
        
        try{
            
            fw = new FileWriter("src\\paquete_Ficheros\\Tickets.txt", true);
            pw = new PrintWriter(fw);
            
            objeto_Ticket.setNombres_Y_Apellidos_Usuario(txtNombres_Y_Apellidos_Usuario.getText());
            objeto_Ticket.setCorreo_Usuario(txtCorreo_Usuario.getText());
            objeto_Ticket.setTelefono_Usuario(txtTelefono_Usuario.getText());
            objeto_Ticket.setArea_Usuario(txtArea_Usuario.getText());
            objeto_Ticket.setPrioridad_Usuario(txtPrioridad_Usuario.getText());
            objeto_Ticket.setAsunto_Usuario(txtAsunto_Usuario.getText());
            objeto_Ticket.setObservacion_Usuario(txtObservacion_Usuario.getText());
            objeto_Ticket.setNombres_Y_Apellidos_Asistente(txtNombres_Y_Apellidos_Asistente.getText());
            objeto_Ticket.setCorreo_Asistente(txtCorreo_Asistente.getText());
            objeto_Ticket.setTelefono_Asistente(txtTelefono_Asistente.getText());
            objeto_Ticket.setArea_Asistente(txtArea_Asistente.getText());     
            objeto_Ticket.setNivel_Asistente(txtNivel_Asistente.getText());
            objeto_Ticket.setEstado_Ticket(txtEstado_Ticket.getText());
            objeto_Ticket.setObservacion_Asistente(txtObservacion_Asistente.getText());
            
            
            pw.println(objeto_Ticket.codigo_Ticket() + ";" + 
                    objeto_Ticket.fecha_Ticket() + ";" +
                    objeto_Ticket.getNombres_Y_Apellidos_Usuario() + ";" +
                    objeto_Ticket.getCorreo_Usuario() + ";" +
                    objeto_Ticket.getTelefono_Usuario() + ";" +
                    objeto_Ticket.getArea_Usuario() + ";" +
                    objeto_Ticket.getPrioridad_Usuario() + ";" +
                    objeto_Ticket.getAsunto_Usuario() + ";" +
                    objeto_Ticket.getObservacion_Usuario() + ";" +
                    objeto_Ticket.fecha_Creacion_Observacion_Asistente() + ";" +
                    objeto_Ticket.getNombres_Y_Apellidos_Asistente() + ";" +
                    objeto_Ticket.getCorreo_Asistente() + ";" +
                    objeto_Ticket.getTelefono_Asistente() + ";" +
                    objeto_Ticket.getArea_Asistente() + ";" +
                    objeto_Ticket.getNivel_Asistente() + ";" +
                    objeto_Ticket.getEstado_Ticket() + ";" +
                    objeto_Ticket.getObservacion_Asistente());
 
            pw.close();
            
            cargar_Datos_De_Controles_En_Tabla_Ticket();
        
        }catch(Exception ex){
            
            JOptionPane.showMessageDialog(null, ex.getMessage());    
        }
    }
    private void cargar_Datos_De_Controles_En_Tabla_Ticket(){
        
        Object [] fila = new Object[17];
        
        fila[0] = objeto_Ticket.codigo_Ticket();
        fila[1] = objeto_Ticket.fecha_Ticket();
        fila[2] = objeto_Ticket.getNombres_Y_Apellidos_Usuario();
        fila[3] = objeto_Ticket.getCorreo_Usuario();
        fila[4] = objeto_Ticket.getTelefono_Usuario();
        fila[5] = objeto_Ticket.getArea_Usuario();
        fila[6] = objeto_Ticket.getPrioridad_Usuario();
        fila[7] = objeto_Ticket.getAsunto_Usuario();
        fila[8] = objeto_Ticket.getObservacion_Usuario();
        fila[9] = objeto_Ticket.fecha_Creacion_Observacion_Asistente();
        fila[10] = objeto_Ticket.getNombres_Y_Apellidos_Asistente();
        fila[11] = objeto_Ticket.getCorreo_Asistente();
        fila[12] = objeto_Ticket.getTelefono_Asistente();
        fila[13] = objeto_Ticket.getArea_Asistente();
        fila[14] = objeto_Ticket.getNivel_Asistente();
        fila[15] = objeto_Ticket.getEstado_Ticket();
        fila[16] = objeto_Ticket.getObservacion_Asistente();
        
        modelo_Ticket.addRow(fila); 
    }  
    
    private void modificar_Ticket(){
        
        int seleccion = tblTicket.getSelectedRow();
        
        if(seleccion == 0 || seleccion == 1 || seleccion == 2 || seleccion == 3 || seleccion == 4 || seleccion == 5 || seleccion ==  6 || seleccion == 7 || seleccion == 8 || seleccion == 9 || seleccion == 10){
            
            int valor = JOptionPane.showConfirmDialog(this, "¿Está seguro que lo desea modificar?", "Mensaje", JOptionPane.YES_NO_OPTION);
            
            if(valor == JOptionPane.YES_OPTION){
                
           
                txtCodigo_Ticket.setText(String.valueOf(tblTicket.getValueAt(seleccion, 0)));
                txtNombres_Y_Apellidos_Usuario.setText(String.valueOf(tblTicket.getValueAt(seleccion, 2)));
                txtCorreo_Usuario.setText(String.valueOf(tblTicket.getValueAt(seleccion, 3)));
                txtTelefono_Usuario.setText(String.valueOf(tblTicket.getValueAt(seleccion, 4)));
                txtArea_Usuario.setText(String.valueOf(tblTicket.getValueAt(seleccion, 5)));
                txtPrioridad_Usuario.setText(String.valueOf(tblTicket.getValueAt(seleccion, 6)));
                txtAsunto_Usuario.setText(String.valueOf(tblTicket.getValueAt(seleccion, 7)));
                txtObservacion_Usuario.setText(String.valueOf(tblTicket.getValueAt(seleccion, 8)));
                txtNombres_Y_Apellidos_Asistente.setText(String.valueOf(tblTicket.getValueAt(seleccion, 10)));
                txtCorreo_Asistente.setText(String.valueOf(tblTicket.getValueAt(seleccion, 11)));
                txtTelefono_Asistente.setText(String.valueOf(tblTicket.getValueAt(seleccion, 12)));
                txtArea_Asistente.setText(String.valueOf(tblTicket.getValueAt(seleccion, 13)));
                txtNivel_Asistente.setText(String.valueOf(tblTicket.getValueAt(seleccion, 14)));
                txtObservacion_Asistente.setText(String.valueOf(tblTicket.getValueAt(seleccion, 15)));
                txtEstado_Ticket.setText(String.valueOf(tblTicket.getValueAt(seleccion, 16)));
        
                jTabbedPane1.setSelectedIndex(1);
        
                etiqueta_Codigo.setVisible(true);
                btnSiguiente_Paso_1.setVisible(true);
       
                eliminar_Fichero_Tickets();
                crear_Fichero_Tickets();
                modelo_Usuario.removeRow(seleccion);
                mostrar_Registros_De_Tabla_Ticket_En_Fichero_Tickets();
        
            }
            
            
        }else{
            
            JOptionPane.showMessageDialog(null, "¡No ha seleccionado un usuario!");
        }
    }
    private void guardar_Datos_Ticket_Modificados(){
        txtNombres_Y_Apellidos_Usuario.setEditable(false);
        txtCorreo_Usuario.setEditable(false);
        txtTelefono_Usuario.setEditable(false);
        txtArea_Usuario.setEditable(false);
        txtPrioridad_Usuario.setEditable(false);
        txtAsunto_Usuario.setEditable(false);
        txtObservacion_Usuario.setEditable(false);
        txtNombres_Y_Apellidos_Asistente.setEditable(false);
        txtCorreo_Asistente.setEditable(false);
        txtTelefono_Asistente.setEditable(false);
        txtArea_Asistente.setEditable(false);        
        txtNivel_Asistente.setEditable(false);
        txtEstado_Ticket.setEditable(false);
        txtObservacion_Asistente.setEditable(false);
        jTabbedPane1.setEnabledAt(1, false);
        grabar_Datos_Modificados_De_Controles_En_Fichero_Tickets();        
    }
    private void grabar_Datos_Modificados_De_Controles_En_Fichero_Tickets(){
        FileWriter fw=null;
        PrintWriter pw=null;
        
        try{
            
            fw = new FileWriter("src\\paquete_Ficheros\\Tickets.txt", true);
            pw = new PrintWriter(fw);
            
            objeto_Ticket.setNombres_Y_Apellidos_Usuario(txtNombres_Y_Apellidos_Usuario.getText());
            objeto_Ticket.setCorreo_Usuario(txtCorreo_Usuario.getText());
            objeto_Ticket.setTelefono_Usuario(txtTelefono_Usuario.getText());
            objeto_Ticket.setArea_Usuario(txtArea_Usuario.getText());
            objeto_Ticket.setPrioridad_Usuario(txtPrioridad_Usuario.getText());
            objeto_Ticket.setAsunto_Usuario(txtAsunto_Usuario.getText());
            objeto_Ticket.setObservacion_Usuario(txtObservacion_Usuario.getText());
            objeto_Ticket.setNombres_Y_Apellidos_Asistente(txtNombres_Y_Apellidos_Asistente.getText());
            objeto_Ticket.setCorreo_Asistente(txtCorreo_Asistente.getText());
            objeto_Ticket.setTelefono_Asistente(txtTelefono_Asistente.getText());
            objeto_Ticket.setArea_Asistente(txtArea_Asistente.getText());     
            objeto_Ticket.setNivel_Asistente(txtNivel_Asistente.getText());
            objeto_Ticket.setEstado_Ticket(txtEstado_Ticket.getText());
            objeto_Ticket.setObservacion_Asistente(txtObservacion_Asistente.getText());
            
            
            pw.println(txtCodigo_Ticket.getText() + ";" + 
                    objeto_Ticket.fecha_Ticket() + ";" +
                    objeto_Ticket.getNombres_Y_Apellidos_Usuario() + ";" +
                    objeto_Ticket.getCorreo_Usuario() + ";" +
                    objeto_Ticket.getTelefono_Usuario() + ";" +
                    objeto_Ticket.getArea_Usuario() + ";" +
                    objeto_Ticket.getPrioridad_Usuario() + ";" +
                    objeto_Ticket.getAsunto_Usuario() + ";" +
                    objeto_Ticket.getObservacion_Usuario() + ";" +
                    objeto_Ticket.fecha_Creacion_Observacion_Asistente() + ";" +
                    objeto_Ticket.getNombres_Y_Apellidos_Asistente() + ";" +
                    objeto_Ticket.getCorreo_Asistente() + ";" +
                    objeto_Ticket.getTelefono_Asistente() + ";" +
                    objeto_Ticket.getArea_Asistente() + ";" +
                    objeto_Ticket.getNivel_Asistente() + ";" +
                    objeto_Ticket.getEstado_Ticket() + ";" +
                    objeto_Ticket.getObservacion_Asistente());
 
            pw.close();
            
            cargar_Datos_Modificados_De_Controles_En_Tabla_Ticket();
        
        }catch(Exception ex){
            
            JOptionPane.showMessageDialog(null, ex.getMessage());    
        }
        
    }
    private void cargar_Datos_Modificados_De_Controles_En_Tabla_Ticket(){
        
        Object [] fila = new Object[17];
        
        fila[0] = txtCodigo_Ticket.getText();
        fila[1] = objeto_Ticket.fecha_Ticket();
        fila[2] = objeto_Ticket.getNombres_Y_Apellidos_Usuario();
        fila[3] = objeto_Ticket.getCorreo_Usuario();
        fila[4] = objeto_Ticket.getTelefono_Usuario();
        fila[5] = objeto_Ticket.getArea_Usuario();
        fila[6] = objeto_Ticket.getPrioridad_Usuario();
        fila[7] = objeto_Ticket.getAsunto_Usuario();
        fila[8] = objeto_Ticket.getObservacion_Usuario();
        fila[9] = objeto_Ticket.fecha_Creacion_Observacion_Asistente();
        fila[10] = objeto_Ticket.getNombres_Y_Apellidos_Asistente();
        fila[11] = objeto_Ticket.getCorreo_Asistente();
        fila[12] = objeto_Ticket.getTelefono_Asistente();
        fila[13] = objeto_Ticket.getArea_Asistente();
        fila[14] = objeto_Ticket.getNivel_Asistente();
        fila[15] = objeto_Ticket.getEstado_Ticket();
        fila[16] = objeto_Ticket.getObservacion_Asistente();
        
        modelo_Ticket.addRow(fila); 
    }
    
    private void eliminar_Ticket(){
        
        int seleccion = tblTicket.getSelectedRow();
        
        if(seleccion == 0 || seleccion == 1 || seleccion == 2 || seleccion == 3 || seleccion == 4 || seleccion == 5 || seleccion ==  6 || seleccion == 7 || seleccion == 8 || seleccion == 9 || seleccion == 10){       
         
            int valor = JOptionPane.showConfirmDialog(this, "¿Está seguro que lo desea eliminar?", "Mensaje", JOptionPane.YES_NO_OPTION);
          
            if(valor == JOptionPane.YES_OPTION){
        
        
        eliminar_Fichero_Tickets();
        crear_Fichero_Tickets();
        modelo_Ticket.removeRow(seleccion);
        mostrar_Registros_De_Tabla_Ticket_En_Fichero_Tickets();
        
        
         }
            
        }else{            
            JOptionPane.showMessageDialog(null, "¡No ha seleccionado un usuario!");
        }
    }
    private void eliminar_Fichero_Tickets(){   
        File archivo = new File("src/paquete_Ficheros/Tickets.txt");        
        archivo.delete();
    }
    private void crear_Fichero_Tickets(){
        
        FileWriter fw=null;
        PrintWriter pw=null;
        
        try{
         
            fw = new FileWriter("src\\paquete_Ficheros\\Tickets.txt", true);
            pw = new PrintWriter(fw);
        
        }catch(Exception ex){
            
            JOptionPane.showMessageDialog(null, ex.getMessage());    
        }
    } 
    private void mostrar_Registros_De_Tabla_Ticket_En_Fichero_Tickets(){
        
        FileWriter fw=null;
        PrintWriter pw=null;
        
        try{
         
            fw = new FileWriter("src\\paquete_Ficheros\\Tickets.txt", true);
            pw = new PrintWriter(fw);
        
            for(int i=0; i<tblTicket.getRowCount(); i++){
            
            pw.println(String.valueOf(tblTicket.getValueAt(i, 0)) + ";" +
                    String.valueOf(tblTicket.getValueAt(i, 1)) + ";" +
                    String.valueOf(tblTicket.getValueAt(i, 2)) + ";" +
                    String.valueOf(tblTicket.getValueAt(i, 3)) + ";" +
                    String.valueOf(tblTicket.getValueAt(i, 4)) + ";" +
                    String.valueOf(tblTicket.getValueAt(i, 5)) + ";" +
                    String.valueOf(tblTicket.getValueAt(i, 6)) + ";" +
                    String.valueOf(tblTicket.getValueAt(i, 7)) + ";" +
                    String.valueOf(tblTicket.getValueAt(i, 8)) + ";" +
                    String.valueOf(tblTicket.getValueAt(i, 9)) + ";" +
                    String.valueOf(tblTicket.getValueAt(i, 10)) + ";" +
                    String.valueOf(tblTicket.getValueAt(i, 11)) + ";" +
                    String.valueOf(tblTicket.getValueAt(i, 12)) + ";" +
                    String.valueOf(tblTicket.getValueAt(i, 13)) + ";" +
                    String.valueOf(tblTicket.getValueAt(i, 14)) + ";" +
                    String.valueOf(tblTicket.getValueAt(i, 15)) + ";" +
                    String.valueOf(tblTicket.getValueAt(i, 16)));          
            }
        
            pw.close();
        
        }catch(Exception ex){
            
            JOptionPane.showMessageDialog(null, ex.getMessage());    
        }   
    }
    
    private void mostrar_Registro_De_Fichero_Tickets_En_Tabla_Ticket(){
        
        try{
            File archivo = new File("src/paquete_Ficheros/Tickets.txt");
            
            if(archivo.exists()){
                
                FileReader reader = new FileReader(archivo);
                BufferedReader br = new BufferedReader(reader);
                
                String linea;
                
                while((linea = br.readLine()) != null){
                
                StringTokenizer token = new StringTokenizer(linea, ";");
                
                String codigo_Ticket = token.nextToken().trim();
                String fecha_Ticket = token.nextToken().trim();
                String nombres_Y_Apellidos_Usuario = token.nextToken().trim();
                String correo_Usuario = token.nextToken().trim();
                String telefono_Usuario = token.nextToken().trim();
                String area_Usuario = token.nextToken().trim();
                String prioridad_Usuario = token.nextToken().trim();
                String asunto_Incidencia = token.nextToken().trim();
                String observacion_Usuario = token.nextToken().trim();
                String fecha_Observacion_Asistente = token.nextToken().trim();
                String nombres_Y_Apellidos_Asistente = token.nextToken().trim();
                String correo_Asistente = token.nextToken().trim();
                String telefono_Asistente = token.nextToken().trim();
                String area_Asistente = token.nextToken().trim();
                String nivel_Asistente = token.nextToken().trim();       
                String estado_Ticket =token.nextToken().trim();
                String observacion_Asistente = token.nextToken().trim();
                
                Object[] obj = new Object[]{
                    
                    codigo_Ticket, fecha_Ticket, nombres_Y_Apellidos_Usuario, correo_Usuario, 
                    telefono_Usuario, area_Usuario, prioridad_Usuario, asunto_Incidencia, observacion_Usuario, 
                    fecha_Observacion_Asistente, nombres_Y_Apellidos_Asistente, correo_Asistente, telefono_Asistente,
                    area_Asistente, nivel_Asistente, estado_Ticket, observacion_Asistente
                };
                        
                modelo_Ticket.addRow(obj);
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
    
    private void elegir_Usuario(){
        
        int seleccion = tblUsuario.getSelectedRow();
        
        if(seleccion == 0 || seleccion == 1 || seleccion == 2 || seleccion == 3 || seleccion == 4 || seleccion == 5 || seleccion ==  6 || seleccion == 7 || seleccion == 8 || seleccion == 9 || seleccion == 10){
            
            int valor = JOptionPane.showConfirmDialog(this, "¿Está seguro que lo desea elegir?", "Mensaje", JOptionPane.YES_NO_OPTION);
            
            if(valor == JOptionPane.YES_OPTION){
                
                txtNombres_Y_Apellidos_Usuario.setText(String.valueOf(tblUsuario.getValueAt(seleccion, 2)));
                txtCorreo_Usuario.setText(String.valueOf(tblUsuario.getValueAt(seleccion, 3)));
                txtTelefono_Usuario.setText(String.valueOf(tblUsuario.getValueAt(seleccion, 4)));
                txtArea_Usuario.setText(String.valueOf(tblUsuario.getValueAt(seleccion, 5)));
            }     
            
        }else{
            JOptionPane.showMessageDialog(null, "¡No ha seleccionado un usuario!");
        }
            
    }
    private void elegir_Asistente(){
        int seleccion = tblAsistente.getSelectedRow();
        txtNombres_Y_Apellidos_Asistente.setText(String.valueOf(tblAsistente.getValueAt(seleccion, 2)));
        txtCorreo_Asistente.setText(String.valueOf(tblAsistente.getValueAt(seleccion, 3)));
        txtTelefono_Asistente.setText(String.valueOf(tblAsistente.getValueAt(seleccion, 4)));
        txtArea_Asistente.setText(String.valueOf(tblAsistente.getValueAt(seleccion, 5)));
        txtNivel_Asistente.setText(String.valueOf(tblAsistente.getValueAt(seleccion, 6)));
        
    }
    private void elegir_Prioridad(){
        int seleccion = tblPrioridad.getSelectedRow();
        txtPrioridad_Usuario.setText(String.valueOf(tblPrioridad.getValueAt(seleccion, 2)));
    }
    private void elegir_Estado(){
        int seleccion = tblEstado.getSelectedRow();
        txtEstado_Ticket.setText(String.valueOf(tblEstado.getValueAt(seleccion, 2)));        
    }
    
    private void cancelar_Paso_1(){
        
        int valor = JOptionPane.showConfirmDialog(this, "¿Está seguro que lo desea cancelar?", "Mensaje", JOptionPane.YES_NO_OPTION);
        if(valor == JOptionPane.YES_OPTION){
        jTabbedPane1.setEnabledAt(1, false);
        jTabbedPane1.setEnabledAt(0, true);
        jTabbedPane1.setSelectedIndex(0);
        }
    }
    
    private void limpiar_Paso_1(){
        txtNombres_Y_Apellidos_Usuario.setText(null);
        txtCorreo_Usuario.setText(null);
        txtTelefono_Usuario.setText(null);
        txtArea_Usuario.setText(null);
        txtPrioridad_Usuario.setText(null);
        txtAsunto_Usuario.setText(null);
        txtEstado_Ticket.setText(null);
        txtObservacion_Usuario.setText(null);
    }
    
    private void limpiar_Paso_2(){
        txtNombres_Y_Apellidos_Asistente.setText("FALTA COMPLETAR");
        txtCorreo_Asistente.setText("FALTA COMPLETAR");
        txtTelefono_Asistente.setText("FALTA COMPLETAR");
        txtArea_Asistente.setText("FALTA COMPLETAR");
        txtNivel_Asistente.setText("FALTA COMPLETAR");
        txtObservacion_Asistente.setText("FALTA COMPLETAR");
    }
    
    private void siguiente_Paso_1(){
        
        
            jTabbedPane2.setSelectedIndex(1);
            jTabbedPane2.setEnabledAt(0,false);
            jTabbedPane2.setEnabledAt(1,true);            
              
    }
    
    private void limpiar_Buscadores(){
        txtBuscador_Fecha_Ticket.setText(null);
        txtBuscador_Codigo_Ticket.setText(null);
        txtBuscador_Nombres_Y_Apellidos_Usuario.setText(null);
        txtBuscador_Correo_Usuario.setText(null);
        txtBuscador_Telefono_Usuario.setText(null);
        txtBuscador_Area_Usuario.setText(null);
        txtBuscador_Prioridad_Usuario.setText(null);
        txtBuscador_Asunto_Usuario.setText(null);
        txtBuscador_Fecha_Observacion_Asistente.setText(null);
        txtBuscador_Nombres_Y_Apellidos_Asistente.setText(null);
        txtBuscador_Correo_Asistente.setText(null);
        txtBuscador_Telefono_Asistente.setText(null);
        txtBuscador_Area_Asistente.setText(null);
        txtBuscador_Nivel_Asistente.setText(null);
        txtBuscador_Estado_Ticket.setText(null);
    }
    
    private void atras_Paso_2(){
        
        jTabbedPane2.setSelectedIndex(0);
    }
    
    public frmRegistro_Tickets() {
        
        initComponents();
        
        agregar_Columnas_Tabla_Ticket();
        agregar_Columnas_Tabla_Usuario();
        agregar_Columnas_Tabla_Asistente();
        agregar_Columnas_Tabla_Prioridad();
        agregar_Columnas_Tabla_Estado();
        
        txtNombres_Y_Apellidos_Usuario.setEnabled(false);
        txtCorreo_Usuario.setEnabled(false);
        txtTelefono_Usuario.setEnabled(false);
        txtArea_Usuario.setEnabled(false);
        txtPrioridad_Usuario.setEnabled(false);
        txtAsunto_Usuario.setEnabled(false);
        txtObservacion_Usuario.setEnabled(false);
        txtNombres_Y_Apellidos_Asistente.setEnabled(false);
        txtCorreo_Asistente.setEnabled(false);
        txtTelefono_Asistente.setEnabled(false);
        txtArea_Asistente.setEnabled(false);        
        txtNivel_Asistente.setEnabled(false);
        txtEstado_Ticket.setEnabled(false);
        txtObservacion_Asistente.setEnabled(false);       
        
        jTabbedPane1.setEnabledAt(1, false);
        jTabbedPane2.setEnabledAt(1, false);
  
        txtNombres_Y_Apellidos_Asistente.setEditable(false);
        txtCorreo_Asistente.setEditable(false);
        txtTelefono_Asistente.setEditable(false);
        txtArea_Asistente.setEditable(false);
        txtNivel_Asistente.setEditable(false);
        txtNombres_Y_Apellidos_Usuario.setEditable(false);
        txtCorreo_Usuario.setEditable(false);
        txtTelefono_Usuario.setEditable(false);
        txtArea_Usuario.setEditable(false);
        txtPrioridad_Usuario.setEditable(false);
        txtEstado_Ticket.setEditable(false);
        
        etiqueta_Codigo.setVisible(false);
        txtCodigo_Ticket.setVisible(false);
        
        btnGuardar_Datos_Modificados.setVisible(false);
        
        mostrar_Registro_De_Fichero_Tickets_En_Tabla_Ticket();
        mostrar_Registro_De_Fichero_Usuarios_En_Tabla_Usuario();
        mostrar_Registro_De_Fichero_Asistentes_En_Tabla_Asistente();
        mostrar_Registro_De_Fichero_Prioridades_En_Tabla_Prioridad();
        mostrar_Registro_De_Fichero_Estados_En_Tabla_Estado();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTicket = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtBuscador_Fecha_Ticket = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtBuscador_Nombres_Y_Apellidos_Usuario = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtBuscador_Correo_Usuario = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        txtBuscador_Telefono_Usuario = new javax.swing.JTextField();
        txtBuscador_Area_Usuario = new javax.swing.JTextField();
        txtBuscador_Prioridad_Usuario = new javax.swing.JTextField();
        txtBuscador_Asunto_Usuario = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        txtBuscador_Codigo_Ticket = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        txtBuscador_Fecha_Observacion_Asistente = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        txtBuscador_Nombres_Y_Apellidos_Asistente = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        txtBuscador_Correo_Asistente = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        txtBuscador_Telefono_Asistente = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        txtBuscador_Area_Asistente = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        txtBuscador_Nivel_Asistente = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        txtBuscador_Estado_Ticket = new javax.swing.JTextField();
        jButton13 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane11 = new javax.swing.JScrollPane();
        tblUsuario = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        txtNombres_Y_Apellidos_Usuario = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtCorreo_Usuario = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtTelefono_Usuario = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtArea_Usuario = new javax.swing.JTextField();
        btnSiguiente_Paso_1 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        txtObservacion_Usuario = new javax.swing.JTextArea();
        jLabel20 = new javax.swing.JLabel();
        jButton16 = new javax.swing.JButton();
        etiqueta_Codigo = new javax.swing.JLabel();
        txtCodigo_Ticket = new javax.swing.JTextField();
        jPanel13 = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        txtBuscador_Codigo_Usuario_2 = new javax.swing.JTextField();
        txtBuscador_Nombres_Y_Apellidos_Usuario_2 = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        txtBuscador_Correo_Usuario_2 = new javax.swing.JTextField();
        txtBuscador_Telefono_Usuario_2 = new javax.swing.JTextField();
        txtBuscador_Area_Usuario_2 = new javax.swing.JTextField();
        jButton14 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        txtAsunto_Usuario = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane13 = new javax.swing.JScrollPane();
        tblEstado = new javax.swing.JTable();
        jButton8 = new javax.swing.JButton();
        txtEstado_Ticket = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane12 = new javax.swing.JScrollPane();
        tblPrioridad = new javax.swing.JTable();
        jButton7 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        txtPrioridad_Usuario = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        tblAsistente = new javax.swing.JTable();
        jButton6 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        txtNombres_Y_Apellidos_Asistente = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtCorreo_Asistente = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtTelefono_Asistente = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtArea_Asistente = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtNivel_Asistente = new javax.swing.JTextField();
        jButton15 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        txtObservacion_Asistente = new javax.swing.JTextArea();
        btnGuardar_Datos = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        btnGuardar_Datos_Modificados = new javax.swing.JButton();

        tblTicket.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblTicket);

        jButton1.setText("Modificar Ticket");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Eliminar Ticket");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Registrar Ticket");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtros"));

        jLabel1.setText("Código:");

        txtBuscador_Fecha_Ticket.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscador_Fecha_TicketKeyTyped(evt);
            }
        });

        jLabel3.setText("Nombres Y Apellidos Del Usuario:");

        txtBuscador_Nombres_Y_Apellidos_Usuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscador_Nombres_Y_Apellidos_UsuarioKeyTyped(evt);
            }
        });

        jLabel5.setText("Correo Electrónico Del Usuario:");

        txtBuscador_Correo_Usuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscador_Correo_UsuarioKeyTyped(evt);
            }
        });

        jLabel22.setText("Teléfono Del Usuario:");

        jLabel23.setText("Área Del Usuario:");

        jLabel24.setText("Fecha De La Creación De La Observación Del Asistente:");

        jLabel25.setText("Prioridad Del Usuario:");

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

        txtBuscador_Prioridad_Usuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscador_Prioridad_UsuarioKeyTyped(evt);
            }
        });

        txtBuscador_Asunto_Usuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscador_Asunto_UsuarioKeyTyped(evt);
            }
        });

        jLabel26.setText("Fecha De La Creación Del Ticket:");

        txtBuscador_Codigo_Ticket.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscador_Codigo_TicketKeyTyped(evt);
            }
        });

        jLabel27.setText("Asunto Del Usuario:");

        txtBuscador_Fecha_Observacion_Asistente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscador_Fecha_Observacion_AsistenteKeyTyped(evt);
            }
        });

        jLabel28.setText("Nombres Y Apellidos Del Asistente:");

        txtBuscador_Nombres_Y_Apellidos_Asistente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscador_Nombres_Y_Apellidos_AsistenteKeyTyped(evt);
            }
        });

        jLabel29.setText("Correo Electrónico Del Asistente:");

        txtBuscador_Correo_Asistente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscador_Correo_AsistenteKeyTyped(evt);
            }
        });

        jLabel30.setText("Teléfono Del Asistente:");

        txtBuscador_Telefono_Asistente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscador_Telefono_AsistenteKeyTyped(evt);
            }
        });

        jLabel31.setText("Área Del Asistente:");

        txtBuscador_Area_Asistente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscador_Area_AsistenteKeyTyped(evt);
            }
        });

        jLabel32.setText("Nivel Del Asistente:");

        txtBuscador_Nivel_Asistente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscador_Nivel_AsistenteKeyTyped(evt);
            }
        });

        jLabel33.setText("Estado Del Ticket:");

        txtBuscador_Estado_Ticket.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscador_Estado_TicketKeyTyped(evt);
            }
        });

        jButton13.setText("Limpiar");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtBuscador_Nombres_Y_Apellidos_Usuario)
                    .addComponent(jLabel5)
                    .addComponent(txtBuscador_Correo_Usuario)
                    .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addComponent(txtBuscador_Codigo_Ticket))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(txtBuscador_Telefono_Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 24, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtBuscador_Area_Usuario, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtBuscador_Prioridad_Usuario, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                                    .addComponent(txtBuscador_Fecha_Ticket, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jLabel22))
                        .addGap(27, 27, 27)))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscador_Fecha_Observacion_Asistente))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel27)
                            .addComponent(txtBuscador_Asunto_Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(52, 52, 52)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(txtBuscador_Telefono_Asistente, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtBuscador_Estado_Ticket, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel30)
                                .addGap(40, 40, 40)
                                .addComponent(jLabel33))))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel28)
                            .addComponent(txtBuscador_Nombres_Y_Apellidos_Asistente, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel29)
                            .addComponent(txtBuscador_Correo_Asistente, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtBuscador_Nivel_Asistente, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel32)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(txtBuscador_Area_Asistente, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton13))
                            .addComponent(jLabel31))))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscador_Fecha_Ticket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26)
                    .addComponent(jLabel24)
                    .addComponent(txtBuscador_Fecha_Observacion_Asistente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(jLabel1)
                    .addComponent(jLabel27)
                    .addComponent(jLabel30)
                    .addComponent(jLabel33))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscador_Asunto_Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBuscador_Telefono_Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBuscador_Codigo_Ticket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBuscador_Telefono_Asistente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBuscador_Estado_Ticket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(jLabel3)
                    .addComponent(jLabel28)
                    .addComponent(jLabel31))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscador_Area_Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBuscador_Nombres_Y_Apellidos_Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBuscador_Nombres_Y_Apellidos_Asistente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBuscador_Area_Asistente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(jLabel5)
                    .addComponent(jLabel29)
                    .addComponent(jLabel32))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscador_Prioridad_Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBuscador_Correo_Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBuscador_Correo_Asistente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBuscador_Nivel_Asistente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jButton19.setText("Cerrar");
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(0, 331, Short.MAX_VALUE)
                                .addComponent(jButton19))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jButton3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton1)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton19)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton3)
                        .addComponent(jButton1)
                        .addComponent(jButton2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81))
        );

        jTabbedPane1.addTab("Registro Y Mantenimiento De Tickets", jPanel3);

        jLabel2.setText("Eliga un usuario:");

        tblUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane11.setViewportView(tblUsuario);

        jLabel8.setText("Nombres Y Apellidos Del Usuario:");

        jButton5.setText("Elegir Usuario");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel9.setText("Correo Electrónico Del Usuario:");

        jLabel10.setText("Teléfono Del Usuario:");

        jLabel11.setText("Área Del Usuario:");

        btnSiguiente_Paso_1.setText("Siguiente");
        btnSiguiente_Paso_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguiente_Paso_1ActionPerformed(evt);
            }
        });

        jButton11.setText("Limpiar");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        txtObservacion_Usuario.setColumns(20);
        txtObservacion_Usuario.setRows(5);
        jScrollPane6.setViewportView(txtObservacion_Usuario);

        jLabel20.setText("Observación Del Usuario:");

        jButton16.setText("Cancelar");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        etiqueta_Codigo.setText("Código:");

        txtCodigo_Ticket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigo_TicketActionPerformed(evt);
            }
        });

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtros"));

        jLabel39.setText("Código Del Usuario:");

        jLabel40.setText("Nombres Y Apellidos Del Usuario:");

        txtBuscador_Codigo_Usuario_2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscador_Codigo_Usuario_2KeyTyped(evt);
            }
        });

        txtBuscador_Nombres_Y_Apellidos_Usuario_2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscador_Nombres_Y_Apellidos_Usuario_2KeyTyped(evt);
            }
        });

        jLabel41.setText("Correo Electrónico Del Usuario:");

        jLabel42.setText("Teléfono Del Usuario:");

        jLabel43.setText("Área Del Usuario:");

        txtBuscador_Correo_Usuario_2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscador_Correo_Usuario_2KeyTyped(evt);
            }
        });

        txtBuscador_Telefono_Usuario_2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscador_Telefono_Usuario_2KeyTyped(evt);
            }
        });

        txtBuscador_Area_Usuario_2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscador_Area_Usuario_2KeyTyped(evt);
            }
        });

        jButton14.setText("Limpiar");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel39)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtBuscador_Codigo_Usuario_2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel41)
                    .addComponent(jLabel40))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtBuscador_Nombres_Y_Apellidos_Usuario_2, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                    .addComponent(txtBuscador_Correo_Usuario_2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel42)
                    .addComponent(jLabel43))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtBuscador_Area_Usuario_2, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                    .addComponent(txtBuscador_Telefono_Usuario_2))
                .addGap(123, 123, 123))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39)
                    .addComponent(txtBuscador_Codigo_Usuario_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBuscador_Telefono_Usuario_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel42)
                    .addComponent(txtBuscador_Nombres_Y_Apellidos_Usuario_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel40))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43)
                    .addComponent(txtBuscador_Area_Usuario_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBuscador_Correo_Usuario_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel41)
                    .addComponent(jButton14))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel13.setText("Asunto:");

        txtAsunto_Usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAsunto_UsuarioActionPerformed(evt);
            }
        });

        jLabel6.setText("Eliga un  estado:");

        tblEstado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane13.setViewportView(tblEstado);

        jButton8.setText("Elegir Estado");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jLabel19.setText("Estado:");

        jLabel7.setText("Eliga un  prioridad:");

        tblPrioridad.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane12.setViewportView(tblPrioridad);

        jButton7.setText("Elegir Prioridad");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel12.setText("Prioridad:");

        txtPrioridad_Usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrioridad_UsuarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, 929, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton16)
                        .addGap(48, 48, 48))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtTelefono_Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel11)
                                .addComponent(jLabel8)
                                .addComponent(jButton11))
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addGap(279, 279, 279)
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jButton8, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                            .addGap(333, 333, 333)
                                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel6)))))
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addGap(375, 375, 375)
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jButton5)
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 544, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel7)
                                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jButton7)
                                                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                            .addComponent(btnSiguiente_Paso_1)
                            .addGap(38, 38, 38))
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtArea_Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel12)
                                                .addComponent(jLabel13))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtPrioridad_Usuario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtAsunto_Usuario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGap(22, 22, 22)
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                            .addComponent(jLabel19)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtEstado_Ticket, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jLabel20)))
                                .addComponent(txtNombres_Y_Apellidos_Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel9)
                                .addComponent(txtCorreo_Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel10)
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addComponent(etiqueta_Codigo)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtCodigo_Ticket, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addContainerGap()))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jButton16)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiqueta_Codigo)
                    .addComponent(txtCodigo_Ticket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(16, 16, 16)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNombres_Y_Apellidos_Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCorreo_Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTelefono_Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(txtArea_Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel12)
                                    .addComponent(txtPrioridad_Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel13)
                                    .addComponent(txtAsunto_Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel19)
                                    .addComponent(txtEstado_Ticket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton11)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton8)
                                .addComponent(btnSiguiente_Paso_1))
                            .addComponent(jButton7))
                        .addGap(101, 101, 101))))
        );

        jTabbedPane2.addTab("Paso 1", jPanel5);

        jLabel4.setText("Eliga un asistente:");

        tblAsistente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane9.setViewportView(tblAsistente);

        jButton6.setText("Elegir Asistente");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel14.setText("Nombres Y Apellidos Del Asistente:");

        txtNombres_Y_Apellidos_Asistente.setText("FALTA COMPLETAR");

        jLabel15.setText("Correo Electrónico Del Asistente:");

        txtCorreo_Asistente.setText("FALTA COMPLETAR");

        jLabel16.setText("Teléfono Del Asistente:");

        txtTelefono_Asistente.setText("FALTA COMPLETAR");

        jLabel17.setText("Área Del Asistente:");

        txtArea_Asistente.setText("FALTA COMPLETAR");

        jLabel18.setText("Nivel Del Asistente:");

        txtNivel_Asistente.setText("FALTA COMPLETAR");

        jButton15.setText("Atrás");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jButton10.setText("Limpiar");

        jButton17.setText("Cancelar");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        jLabel21.setText("Observación Del Asistente:");

        txtObservacion_Asistente.setColumns(20);
        txtObservacion_Asistente.setRows(5);
        txtObservacion_Asistente.setText("FALTA COMPLETAR");
        jScrollPane10.setViewportView(txtObservacion_Asistente);

        btnGuardar_Datos.setText("Guardar Datos");
        btnGuardar_Datos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardar_DatosActionPerformed(evt);
            }
        });

        jButton18.setText("Limpiar");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        btnGuardar_Datos_Modificados.setText("Guardar Datos Modificados");
        btnGuardar_Datos_Modificados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardar_Datos_ModificadosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16)
                            .addComponent(jLabel18)
                            .addComponent(jLabel21)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jButton15)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                .addGap(0, 285, Short.MAX_VALUE)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(721, 721, 721))
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jButton6)
                                            .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButton10))
                                        .addGap(106, 106, 106)
                                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnGuardar_Datos_Modificados)
                                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(btnGuardar_Datos)
                                                .addComponent(jButton17))))))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtTelefono_Asistente, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtCorreo_Asistente, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtNombres_Y_Apellidos_Asistente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                                        .addComponent(txtArea_Asistente, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtNivel_Asistente, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jButton18)
                                        .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton10)
                    .addComponent(jButton17))
                .addGap(66, 66, 66)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtNombres_Y_Apellidos_Asistente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(22, 22, 22)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(txtCorreo_Asistente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTelefono_Asistente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(txtArea_Asistente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(txtNivel_Asistente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21)
                            .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton6)
                            .addComponent(btnGuardar_Datos))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGuardar_Datos_Modificados)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton18)
                    .addComponent(jButton15))
                .addGap(47, 47, 47))
        );

        jTabbedPane2.addTab("Paso 2", jPanel7);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );

        jTabbedPane1.addTab("Registrar Ticket", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //jButton [Registrar Ticket]
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        registrar_Ticket();
    }//GEN-LAST:event_jButton3ActionPerformed

    //jButton [Guardar Datos]
    private void btnGuardar_DatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardar_DatosActionPerformed
        
        if(txtNombres_Y_Apellidos_Usuario.getText().trim().isEmpty() && txtCorreo_Usuario.getText().trim().isEmpty() && txtTelefono_Usuario.getText().trim().isEmpty() && txtArea_Usuario.getText().trim().isEmpty() && 
                txtPrioridad_Usuario.getText().trim().isEmpty() && txtAsunto_Usuario.getText().trim().isEmpty() && txtObservacion_Usuario.getText().trim().isEmpty() && 
                txtEstado_Ticket.getText().trim().isEmpty() && txtNombres_Y_Apellidos_Asistente.getText().trim().isEmpty() && txtCorreo_Asistente.getText().trim().isEmpty() && txtTelefono_Asistente.getText().trim().isEmpty() && 
                txtArea_Asistente.getText().trim().isEmpty() && txtNivel_Asistente.getText().trim().isEmpty() && txtObservacion_Asistente.getText().trim().isEmpty()){

            JOptionPane.showMessageDialog(null, "¡No ha llenado ningún  dato!");

        }else if(txtNombres_Y_Apellidos_Usuario.getText().trim().isEmpty()){

            JOptionPane.showMessageDialog(null, "Le falta llenar los nombres y apellidos del usuario.");

        }else if(txtCorreo_Usuario.getText().trim().isEmpty()){

            JOptionPane.showMessageDialog(null, "Le falta llenar el correo del usuario.");

        }else if(txtTelefono_Usuario.getText().trim().isEmpty()){

            JOptionPane.showMessageDialog(null, "Le falta llenar el teléfono del usuario.");
        
        }else if(txtArea_Usuario.getText().trim().isEmpty()){

            JOptionPane.showMessageDialog(null, "Le falta llenar el área del usuario.");
        
        }else if(txtPrioridad_Usuario.getText().trim().isEmpty()){

            JOptionPane.showMessageDialog(null, "Le falta llenar la prioridad del usuario.");

        }else if(txtAsunto_Usuario.getText().trim().isEmpty()){

            JOptionPane.showMessageDialog(null, "Le falta llenar el asunto del usuario.");

        }else if(txtObservacion_Usuario.getText().trim().isEmpty()){

            JOptionPane.showMessageDialog(null, "Le falta llenar la observacion del usuario.");
        
        }else if(txtEstado_Ticket.getText().trim().isEmpty()){

            JOptionPane.showMessageDialog(null, "Le falta llenar el estado del ticket.");    
            
        }else if(txtNombres_Y_Apellidos_Asistente.getText().trim().isEmpty()){

            JOptionPane.showMessageDialog(null, "Le falta llenar los nombres y apellidos del asistente.");

        }else if(txtCorreo_Asistente.getText().trim().isEmpty()){

            JOptionPane.showMessageDialog(null, "Le falta llenar el correo del asistente.");

        }else if(txtTelefono_Asistente.getText().trim().isEmpty()){

            JOptionPane.showMessageDialog(null, "Le falta llenar el teléfono del asistente.");
        
        }else if(txtArea_Asistente.getText().trim().isEmpty()){

            JOptionPane.showMessageDialog(null, "Le falta llenar el área del asistente.");
        
        }else if(txtNivel_Asistente.getText().trim().isEmpty()){
            
            JOptionPane.showMessageDialog(null, "Le falta llenar el nivel del asistente.");
            
        }else if(txtObservacion_Asistente.getText().trim().isEmpty()){
            
            JOptionPane.showMessageDialog(null, "Le falta llenar la observación del asistente.");
        }else{
            
            guardar_Datos_Ticket();
            jTabbedPane1.setEnabledAt(1, true);
            jTabbedPane1.setSelectedIndex(0);
        }      
    }//GEN-LAST:event_btnGuardar_DatosActionPerformed

    //jButton [Modificar Ticket]
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        modificar_Ticket();
        btnGuardar_Datos_Modificados.setVisible(true);
        etiqueta_Codigo.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    //jButton [Eliminar Ticket]
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        eliminar_Ticket();
    }//GEN-LAST:event_jButton2ActionPerformed

    //jButton [Elegir Usuario]
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        elegir_Usuario();
    }//GEN-LAST:event_jButton5ActionPerformed

    //jButton [Elegir Asistente]
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        elegir_Asistente();
    }//GEN-LAST:event_jButton6ActionPerformed

    //jButton [Elegir Prioridad]
    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        elegir_Prioridad();
    }//GEN-LAST:event_jButton7ActionPerformed

    //jButton [Elegir Estado]
    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        elegir_Estado();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void txtPrioridad_UsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrioridad_UsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrioridad_UsuarioActionPerformed

    //JButton [Limpiar] del paso 1
    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        limpiar_Paso_1();
    }//GEN-LAST:event_jButton11ActionPerformed

    //JButton [Cancelar] del paso 1
    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        cancelar_Paso_1();
        btnGuardar_Datos_Modificados.setVisible(false);
    }//GEN-LAST:event_jButton16ActionPerformed

    //JButton [Cancelar] del paso 2
    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        cancelar_Paso_1();
        btnGuardar_Datos_Modificados.setVisible(false);
    }//GEN-LAST:event_jButton17ActionPerformed

    //JButton [Siguiente] del paso 1
    private void btnSiguiente_Paso_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguiente_Paso_1ActionPerformed
        siguiente_Paso_1();
    }//GEN-LAST:event_btnSiguiente_Paso_1ActionPerformed

    private void txtCodigo_TicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigo_TicketActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigo_TicketActionPerformed

    private void txtAsunto_UsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAsunto_UsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAsunto_UsuarioActionPerformed

    //JButton [Limpiar] de los buscadores
    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        limpiar_Buscadores();
    }//GEN-LAST:event_jButton13ActionPerformed

    //BUSCADORES
    private void txtBuscador_Estado_TicketKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscador_Estado_TicketKeyTyped
        txtBuscador_Estado_Ticket.addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent ke) {

                trs_15.setRowFilter(RowFilter.regexFilter("(?i)" + txtBuscador_Estado_Ticket.getText(), 16));
            }
        });

        trs_15 = new TableRowSorter(modelo_Ticket);

        tblTicket.setRowSorter(trs_15);
    }//GEN-LAST:event_txtBuscador_Estado_TicketKeyTyped

    private void txtBuscador_Nivel_AsistenteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscador_Nivel_AsistenteKeyTyped
        txtBuscador_Nivel_Asistente.addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent ke) {

                trs_14.setRowFilter(RowFilter.regexFilter("(?i)" + txtBuscador_Nivel_Asistente.getText(), 14));
            }
        });

        trs_14 = new TableRowSorter(modelo_Ticket);

        tblTicket.setRowSorter(trs_14);
    }//GEN-LAST:event_txtBuscador_Nivel_AsistenteKeyTyped

    private void txtBuscador_Area_AsistenteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscador_Area_AsistenteKeyTyped
        txtBuscador_Area_Asistente.addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent ke) {

                trs_13.setRowFilter(RowFilter.regexFilter("(?i)" + txtBuscador_Area_Asistente.getText(), 13));
            }
        });

        trs_13 = new TableRowSorter(modelo_Ticket);

        tblTicket.setRowSorter(trs_13);
    }//GEN-LAST:event_txtBuscador_Area_AsistenteKeyTyped

    private void txtBuscador_Telefono_AsistenteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscador_Telefono_AsistenteKeyTyped
        txtBuscador_Telefono_Asistente.addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent ke) {

                trs_12.setRowFilter(RowFilter.regexFilter("(?i)" + txtBuscador_Telefono_Asistente.getText(), 12));
            }
        });

        trs_12 = new TableRowSorter(modelo_Ticket);

        tblTicket.setRowSorter(trs_12);
    }//GEN-LAST:event_txtBuscador_Telefono_AsistenteKeyTyped

    private void txtBuscador_Correo_AsistenteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscador_Correo_AsistenteKeyTyped
        txtBuscador_Correo_Asistente.addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent ke) {

                trs_11.setRowFilter(RowFilter.regexFilter("(?i)" + txtBuscador_Correo_Asistente.getText(), 11));
            }
        });

        trs_11 = new TableRowSorter(modelo_Ticket);

        tblTicket.setRowSorter(trs_11);
    }//GEN-LAST:event_txtBuscador_Correo_AsistenteKeyTyped

    private void txtBuscador_Nombres_Y_Apellidos_AsistenteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscador_Nombres_Y_Apellidos_AsistenteKeyTyped
        txtBuscador_Nombres_Y_Apellidos_Asistente.addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent ke) {

                trs_10.setRowFilter(RowFilter.regexFilter("(?i)" + txtBuscador_Nombres_Y_Apellidos_Asistente.getText(), 10));
            }
        });

        trs_10 = new TableRowSorter(modelo_Ticket);

        tblTicket.setRowSorter(trs_10);
    }//GEN-LAST:event_txtBuscador_Nombres_Y_Apellidos_AsistenteKeyTyped

    private void txtBuscador_Fecha_Observacion_AsistenteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscador_Fecha_Observacion_AsistenteKeyTyped
        txtBuscador_Fecha_Observacion_Asistente.addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent ke) {

                trs_9.setRowFilter(RowFilter.regexFilter("(?i)" + txtBuscador_Fecha_Observacion_Asistente.getText(), 9));
            }
        });

        trs_9 = new TableRowSorter(modelo_Ticket);

        tblTicket.setRowSorter(trs_9);
    }//GEN-LAST:event_txtBuscador_Fecha_Observacion_AsistenteKeyTyped

    private void txtBuscador_Codigo_TicketKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscador_Codigo_TicketKeyTyped
        txtBuscador_Codigo_Ticket.addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent ke) {

                trs.setRowFilter(RowFilter.regexFilter("(?i)" + txtBuscador_Codigo_Ticket.getText(), 0));
            }
        });

        trs = new TableRowSorter(modelo_Ticket);

        tblTicket.setRowSorter(trs);
    }//GEN-LAST:event_txtBuscador_Codigo_TicketKeyTyped

    private void txtBuscador_Asunto_UsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscador_Asunto_UsuarioKeyTyped
        txtBuscador_Asunto_Usuario.addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent ke) {

                trs_8.setRowFilter(RowFilter.regexFilter("(?i)" + txtBuscador_Asunto_Usuario.getText(), 7));
            }
        });

        trs_8 = new TableRowSorter(modelo_Ticket);

        tblTicket.setRowSorter(trs_8);
    }//GEN-LAST:event_txtBuscador_Asunto_UsuarioKeyTyped

    private void txtBuscador_Prioridad_UsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscador_Prioridad_UsuarioKeyTyped
        txtBuscador_Prioridad_Usuario.addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent ke) {

                trs_7.setRowFilter(RowFilter.regexFilter("(?i)" + txtBuscador_Prioridad_Usuario.getText(), 6));
            }
        });

        trs_7 = new TableRowSorter(modelo_Ticket);

        tblTicket.setRowSorter(trs_7);
    }//GEN-LAST:event_txtBuscador_Prioridad_UsuarioKeyTyped

    private void txtBuscador_Area_UsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscador_Area_UsuarioKeyTyped
        txtBuscador_Area_Usuario.addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent ke) {

                trs_6.setRowFilter(RowFilter.regexFilter("(?i)" + txtBuscador_Area_Usuario.getText(), 5));
            }
        });

        trs_6 = new TableRowSorter(modelo_Ticket);

        tblTicket.setRowSorter(trs_6);
    }//GEN-LAST:event_txtBuscador_Area_UsuarioKeyTyped

    private void txtBuscador_Telefono_UsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscador_Telefono_UsuarioKeyTyped
        txtBuscador_Telefono_Usuario.addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent ke) {

                trs_5.setRowFilter(RowFilter.regexFilter("(?i)" + txtBuscador_Correo_Usuario.getText(), 4));
            }
        });

        trs_5 = new TableRowSorter(modelo_Ticket);

        tblTicket.setRowSorter(trs_5);
    }//GEN-LAST:event_txtBuscador_Telefono_UsuarioKeyTyped

    private void txtBuscador_Correo_UsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscador_Correo_UsuarioKeyTyped
        txtBuscador_Correo_Usuario.addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent ke) {

                trs_4.setRowFilter(RowFilter.regexFilter("(?i)" + txtBuscador_Correo_Usuario.getText(), 3));
            }
        });

        trs_4 = new TableRowSorter(modelo_Ticket);

        tblTicket.setRowSorter(trs_4);
    }//GEN-LAST:event_txtBuscador_Correo_UsuarioKeyTyped

    private void txtBuscador_Nombres_Y_Apellidos_UsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscador_Nombres_Y_Apellidos_UsuarioKeyTyped
        txtBuscador_Nombres_Y_Apellidos_Usuario.addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent ke) {

                trs_3.setRowFilter(RowFilter.regexFilter("(?i)" + txtBuscador_Nombres_Y_Apellidos_Usuario.getText(), 2));
            }
        });

        trs_3 = new TableRowSorter(modelo_Ticket);

        tblTicket.setRowSorter(trs_3);
    }//GEN-LAST:event_txtBuscador_Nombres_Y_Apellidos_UsuarioKeyTyped

    private void txtBuscador_Fecha_TicketKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscador_Fecha_TicketKeyTyped
        txtBuscador_Fecha_Ticket.addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent ke) {

                trs_2.setRowFilter(RowFilter.regexFilter("(?i)" + txtBuscador_Fecha_Ticket.getText(), 1));
            }
        });

        trs_2 = new TableRowSorter(modelo_Ticket);

        tblTicket.setRowSorter(trs_2);
    }//GEN-LAST:event_txtBuscador_Fecha_TicketKeyTyped

    private void txtBuscador_Area_Usuario_2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscador_Area_Usuario_2KeyTyped
        txtBuscador_Area_Usuario_2.addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent ke) {

                trs_20.setRowFilter(RowFilter.regexFilter("(?i)" + txtBuscador_Area_Usuario_2.getText(), 5));
            }
        });

        trs_20 = new TableRowSorter(modelo_Usuario);

        tblUsuario.setRowSorter(trs_20);
    }//GEN-LAST:event_txtBuscador_Area_Usuario_2KeyTyped

    private void txtBuscador_Telefono_Usuario_2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscador_Telefono_Usuario_2KeyTyped
        txtBuscador_Telefono_Usuario_2.addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent ke) {

                trs_19.setRowFilter(RowFilter.regexFilter("(?i)" + txtBuscador_Telefono_Usuario_2.getText(), 4));
            }
        });

        trs_19 = new TableRowSorter(modelo_Usuario);

        tblUsuario.setRowSorter(trs_19);
    }//GEN-LAST:event_txtBuscador_Telefono_Usuario_2KeyTyped

    private void txtBuscador_Correo_Usuario_2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscador_Correo_Usuario_2KeyTyped
        txtBuscador_Correo_Usuario_2.addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent ke) {

                trs_18.setRowFilter(RowFilter.regexFilter("(?i)" + txtBuscador_Correo_Usuario_2.getText(), 3));
            }
        });

        trs_18 = new TableRowSorter(modelo_Usuario);

        tblUsuario.setRowSorter(trs_18);
    }//GEN-LAST:event_txtBuscador_Correo_Usuario_2KeyTyped

    private void txtBuscador_Nombres_Y_Apellidos_Usuario_2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscador_Nombres_Y_Apellidos_Usuario_2KeyTyped
        txtBuscador_Nombres_Y_Apellidos_Usuario_2.addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent ke) {

                trs_17.setRowFilter(RowFilter.regexFilter("(?i)" + txtBuscador_Nombres_Y_Apellidos_Usuario_2.getText(), 2));
            }
        });

        trs_17 = new TableRowSorter(modelo_Usuario);

        tblUsuario.setRowSorter(trs_17);
    }//GEN-LAST:event_txtBuscador_Nombres_Y_Apellidos_Usuario_2KeyTyped

    private void txtBuscador_Codigo_Usuario_2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscador_Codigo_Usuario_2KeyTyped
        txtBuscador_Codigo_Usuario_2.addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent ke) {

                trs_16.setRowFilter(RowFilter.regexFilter("(?i)" + txtBuscador_Codigo_Usuario_2.getText(), 0));
            }
        });

        trs_16 = new TableRowSorter(modelo_Usuario);

        tblUsuario.setRowSorter(trs_16);
    }//GEN-LAST:event_txtBuscador_Codigo_Usuario_2KeyTyped
    //BUSCADORES
    
    //JButton [Cerrar]
    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        int valor = JOptionPane.showConfirmDialog(this, "¿Está seguro que lo desea cerrar?", "Mensaje", JOptionPane.YES_NO_OPTION);
        if(valor == JOptionPane.YES_OPTION){
            this.setVisible(false);
        }
    }//GEN-LAST:event_jButton19ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        atras_Paso_2();
    }//GEN-LAST:event_jButton15ActionPerformed

    //JButton [Limpiar] del paso 2
    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        limpiar_Paso_2();
    }//GEN-LAST:event_jButton18ActionPerformed

    //JButton [Guardar Datos Modificados]
    private void btnGuardar_Datos_ModificadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardar_Datos_ModificadosActionPerformed
        guardar_Datos_Ticket_Modificados();
        btnGuardar_Datos_Modificados.setVisible(false);
    }//GEN-LAST:event_btnGuardar_Datos_ModificadosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar_Datos;
    private javax.swing.JButton btnGuardar_Datos_Modificados;
    private javax.swing.JButton btnSiguiente_Paso_1;
    private javax.swing.JLabel etiqueta_Codigo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable tblAsistente;
    private javax.swing.JTable tblEstado;
    private javax.swing.JTable tblPrioridad;
    private javax.swing.JTable tblTicket;
    private javax.swing.JTable tblUsuario;
    private javax.swing.JTextField txtArea_Asistente;
    private javax.swing.JTextField txtArea_Usuario;
    private javax.swing.JTextField txtAsunto_Usuario;
    private javax.swing.JTextField txtBuscador_Area_Asistente;
    private javax.swing.JTextField txtBuscador_Area_Usuario;
    private javax.swing.JTextField txtBuscador_Area_Usuario1;
    private javax.swing.JTextField txtBuscador_Area_Usuario_2;
    private javax.swing.JTextField txtBuscador_Asunto_Usuario;
    private javax.swing.JTextField txtBuscador_Codigo_Ticket;
    private javax.swing.JTextField txtBuscador_Codigo_Usuario;
    private javax.swing.JTextField txtBuscador_Codigo_Usuario_2;
    private javax.swing.JTextField txtBuscador_Correo_Asistente;
    private javax.swing.JTextField txtBuscador_Correo_Usuario;
    private javax.swing.JTextField txtBuscador_Correo_Usuario1;
    private javax.swing.JTextField txtBuscador_Correo_Usuario_2;
    private javax.swing.JTextField txtBuscador_Estado_Ticket;
    private javax.swing.JTextField txtBuscador_Fecha_Observacion_Asistente;
    private javax.swing.JTextField txtBuscador_Fecha_Ticket;
    private javax.swing.JTextField txtBuscador_Nivel_Asistente;
    private javax.swing.JTextField txtBuscador_Nombres_Y_Apellidos_Asistente;
    private javax.swing.JTextField txtBuscador_Nombres_Y_Apellidos_Usuario;
    private javax.swing.JTextField txtBuscador_Nombres_Y_Apellidos_Usuario1;
    private javax.swing.JTextField txtBuscador_Nombres_Y_Apellidos_Usuario_2;
    private javax.swing.JTextField txtBuscador_Prioridad_Usuario;
    private javax.swing.JTextField txtBuscador_Telefono_Asistente;
    private javax.swing.JTextField txtBuscador_Telefono_Usuario;
    private javax.swing.JTextField txtBuscador_Telefono_Usuario1;
    private javax.swing.JTextField txtBuscador_Telefono_Usuario_2;
    private javax.swing.JTextField txtCodigo_Ticket;
    private javax.swing.JTextField txtCorreo_Asistente;
    private javax.swing.JTextField txtCorreo_Usuario;
    private javax.swing.JTextField txtEstado_Ticket;
    private javax.swing.JTextField txtNivel_Asistente;
    private javax.swing.JTextField txtNombres_Y_Apellidos_Asistente;
    private javax.swing.JTextField txtNombres_Y_Apellidos_Usuario;
    private javax.swing.JTextArea txtObservacion_Asistente;
    private javax.swing.JTextArea txtObservacion_Usuario;
    private javax.swing.JTextField txtPrioridad_Usuario;
    private javax.swing.JTextField txtTelefono_Asistente;
    private javax.swing.JTextField txtTelefono_Usuario;
    // End of variables declaration//GEN-END:variables
}
