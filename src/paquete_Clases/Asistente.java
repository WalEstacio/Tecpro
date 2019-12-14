
package paquete_Clases;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Asistente extends Ticket{
        
    public Asistente() {
    }

    public Asistente(String nombres_Y_Apellidos_Usuario, String correo_Usuario, String telefono_Usuario, String area_Usuario, String prioridad, String asunto, String observacion_Usuario, String nombres_Y_Apellidos_Asistente, String correo_Asistente, String telefono_Asistente, String area_Asistente, String nivel_Asistente, String observacion_Asistente, String estado) {
        super(nombres_Y_Apellidos_Usuario, correo_Usuario, telefono_Usuario, area_Usuario, prioridad, asunto, observacion_Usuario, nombres_Y_Apellidos_Asistente, correo_Asistente, telefono_Asistente, area_Asistente, nivel_Asistente, observacion_Asistente, estado);
    }

    public String fecha_Asistente(){  
        Date fech = new Date();
        SimpleDateFormat formato_Fech = new SimpleDateFormat("dd/MM/YYYY");
        return formato_Fech.format(fech);
    }
    
    public String codigo_Asistente(){
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
