
package paquete_Clases;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Ticket{
    
    private String nombres_Y_Apellidos_Usuario;
    private String correo_Usuario;
    private String telefono_Usuario;
    private String area_Usuario;
    private String prioridad_Usuario;
    private String asunto_Usuario;
    private String observacion_Usuario;
    private String nombres_Y_Apellidos_Asistente;
    private String correo_Asistente;
    private String telefono_Asistente;
    private String area_Asistente;
    private String nivel_Asistente;
    private String observacion_Asistente;
    private String estado_Ticket;

    public Ticket() {
    }

    public Ticket(String nombres_Y_Apellidos_Usuario, String correo_Usuario, String telefono_Usuario, String area_Usuario, String prioridad_Usuario, String asunto_Usuario, String observacion_Usuario, String nombres_Y_Apellidos_Asistente, String correo_Asistente, String telefono_Asistente, String area_Asistente, String nivel_Asistente, String observacion_Asistente, String estado_Ticket) {
        this.nombres_Y_Apellidos_Usuario = nombres_Y_Apellidos_Usuario;
        this.correo_Usuario = correo_Usuario;
        this.telefono_Usuario = telefono_Usuario;
        this.area_Usuario = area_Usuario;
        this.prioridad_Usuario = prioridad_Usuario;
        this.asunto_Usuario = asunto_Usuario;
        this.observacion_Usuario = observacion_Usuario;
        this.nombres_Y_Apellidos_Asistente = nombres_Y_Apellidos_Asistente;
        this.correo_Asistente = correo_Asistente;
        this.telefono_Asistente = telefono_Asistente;
        this.area_Asistente = area_Asistente;
        this.nivel_Asistente = nivel_Asistente;
        this.observacion_Asistente = observacion_Asistente;
        this.estado_Ticket = estado_Ticket;
    }
        
    public String getNombres_Y_Apellidos_Usuario() {
        return nombres_Y_Apellidos_Usuario;
    }

    public void setNombres_Y_Apellidos_Usuario(String nombres_Y_Apellidos_Usuario) {
        this.nombres_Y_Apellidos_Usuario = nombres_Y_Apellidos_Usuario;
    }

    public String getCorreo_Usuario() {
        return correo_Usuario;
    }

    public void setCorreo_Usuario(String correo_Usuario) {
        this.correo_Usuario = correo_Usuario;
    }

    public String getTelefono_Usuario() {
        return telefono_Usuario;
    }

    public void setTelefono_Usuario(String telefono_Usuario) {
        this.telefono_Usuario = telefono_Usuario;
    }

    public String getArea_Usuario() {
        return area_Usuario;
    }

    public void setArea_Usuario(String area_Usuario) {
        this.area_Usuario = area_Usuario;
    }

    public String getPrioridad_Usuario() {
        return prioridad_Usuario;
    }

    public void setPrioridad_Usuario(String prioridad_Usuario) {
        this.prioridad_Usuario = prioridad_Usuario;
    }

    public String getAsunto_Usuario() {
        return asunto_Usuario;
    }

    public void setAsunto_Usuario(String asunto_Usuario) {
        this.asunto_Usuario = asunto_Usuario;
    }

    public String getObservacion_Usuario() {
        return observacion_Usuario;
    }

    public void setObservacion_Usuario(String observacion_Usuario) {
        this.observacion_Usuario = observacion_Usuario;
    }

    public String getNombres_Y_Apellidos_Asistente() {
        return nombres_Y_Apellidos_Asistente;
    }

    public void setNombres_Y_Apellidos_Asistente(String nombres_Y_Apellidos_Asistente) {
        this.nombres_Y_Apellidos_Asistente = nombres_Y_Apellidos_Asistente;
    }

    public String getCorreo_Asistente() {
        return correo_Asistente;
    }

    public void setCorreo_Asistente(String correo_Asistente) {
        this.correo_Asistente = correo_Asistente;
    }

    public String getTelefono_Asistente() {
        return telefono_Asistente;
    }

    public void setTelefono_Asistente(String telefono_Asistente) {
        this.telefono_Asistente = telefono_Asistente;
    }

    public String getArea_Asistente() {
        return area_Asistente;
    }

    public void setArea_Asistente(String area_Asistente) {
        this.area_Asistente = area_Asistente;
    }

    public String getNivel_Asistente() {
        return nivel_Asistente;
    }

    public void setNivel_Asistente(String nivel_Asistente) {
        this.nivel_Asistente = nivel_Asistente;
    }

    public String getObservacion_Asistente() {
        return observacion_Asistente;
    }

    public void setObservacion_Asistente(String observacion_Asistente) {
        this.observacion_Asistente = observacion_Asistente;
    }

    public String getEstado_Ticket() {
        return estado_Ticket;
    }

    public void setEstado_Ticket(String estado_Ticket) {
        this.estado_Ticket = estado_Ticket;
    }

    public String fecha_Ticket(){  
        Date fech = new Date();
        SimpleDateFormat formato_Fech = new SimpleDateFormat("dd/MM/YYYY");
        return formato_Fech.format(fech);
    }
    
    public String fecha_Creacion_Observacion_Asistente(){  
        Date fech = new Date();
        SimpleDateFormat formato_Fech = new SimpleDateFormat("dd/MM/YYYY");
        return formato_Fech.format(fech);
    }
    
    public String codigo_Ticket(){
        Random aleatorio = new Random();
        String alfa = "ABCDEFGHIJKLMNOPQRSTVWXYZ";
        String cadena = "";
        int numero;
        int forma;
        forma=(int)(aleatorio.nextDouble() * alfa.length()-1+0);
        numero=(int)(aleatorio.nextDouble() * 99+100);
        cadena=cadena+alfa.charAt(forma)+numero;
        return cadena;
    }
}
