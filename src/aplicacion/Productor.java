package aplicacion;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/* Area de Productores
*
 */
public class Productor extends Thread {

    private Almacen almacen;
    private Semaphore semPro;//semaforo para saber si hay espacio en el almacen
    private Semaphore semEns;//semaforo para saber si hay algo en el almacen
    private Semaphore semMutEx;//semaforo de exclusividad mutua
    private int tiempoProduccion;//tiempo que tarda en producir
    private boolean fired;
    // private Semaphore sI;//SEmaforo de impresion a consola (se ajustará a la interfaz)
    private int apuntaP;//apuntador de los productores
    private int val;

    public Productor(Almacen a, Semaphore sP, Semaphore sC, Semaphore sE, int apuntP, int val, Semaphore sI) {
        this.almacen = almacen;
        this.semPro = semPro;
        this.semEns = semEns;
        this.semMutEx = semMutEx;
        this.apuntaP = apuntP;
        this.val = val;

    }

    @Override
    public void run() {
        while (true) {
            try {
                semPro.acquire();
                semMutEx.acquire();
                almacen.setVec(apuntaP, val);
                apuntaP = (apuntaP + 1) % almacen.getSize();
                semEns.release();
                semMutEx.release();
            } catch (InterruptedException ex) {
                Logger.getLogger(Productor.class.getName()).log(Level.SEVERE, null, ex);
            }
            /*
        
        
        Impresion a consola de la prepa:
        try {
             //   sI.acquire();
            } catch (InterruptedException ex) {
                Logger.getLogger(Productor.class.getName()).log(Level.SEVERE, null, ex);
            }
           //this.al.imprimir();
           // sI.release();*/
        }

    }

}
