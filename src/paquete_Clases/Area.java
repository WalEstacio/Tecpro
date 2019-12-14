
package paquete_Clases;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Area {

    private String area;
    
    public Area() {
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
    
    public String fecha_Area(){  
        Date fech = new Date();
        SimpleDateFormat formato_Fech = new SimpleDateFormat("dd/MM/YYYY");
        return formato_Fech.format(fech);
    }
    
    public String codigo_Area(){
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
