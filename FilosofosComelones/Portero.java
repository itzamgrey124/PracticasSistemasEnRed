// Clase pasiva: Recurso compartido
package filosofos;

import utilidades.Log;
import vistas.Clase10Control;

public class Portero_del_Comedor {
    private int comensal = 4; // Es el número de comensales total de filósofos menos 1
    
    /**
     * Monitor para coger un comensal de los 4 y poder seguir el proceso de ejecución de los filósofos.
     * 
     * @param id_f ID del fiósofo
     * @param log Clase Log para escribir el log en la interface gráfica
     * @throws InterruptedException Posibles errores
     */
    public synchronized void cogerComensal(int id_f, Log log) throws InterruptedException{
        while(comensal==0){ // Si no hay comensales libres toca esperar
            this.wait();
        } 
        System.out.println("El Filósofo " + (id_f+1) + " es el comensal " + comensal);
        // Siempre se valora si el log es distinto a null, si lo es se ecribe en la interface gráfica:
        if (Clase10Control.getjTextArea_Log()!=null) log.escribirLog(" El Filósofo " + (id_f+1) + " es el comensal " + comensal);
        comensal--; // Conteo de comensales
    }
    
    /**
     * Monitor para soltar un comensal de los 4 y poder seguir el proceso de ejecución de los filósofos.
     * 
  /
    public synchronized void soltarComensal(int id_f, Log log) throws InterruptedException{
        comensal++; // Conteo de comensales
        System.out.println("El Filósofo " + (id_f+1) + " ya NO es el comensal " + comensal);
        // Siempre se valora si el log es distinto a null, si lo es se ecribe en la interface gráfica:
        if (Clase10Control.getjTextArea_Log()!=null) log.escribirLog(" El Filósofo " + (id_f+1) + " ya NO es el comensal " + comensal);
        this.notify(); // Notificación al siguiente de que hay comensal disponible.
    }
}
