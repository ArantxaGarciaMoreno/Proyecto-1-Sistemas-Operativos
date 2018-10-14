package aplicacion;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Productor extends Thread {

    private Almacen almacen;//buffer
    private Semaphore semPro;//semaforo para saber si hay espacio en el almacen
    private Semaphore semEns;//semaforo para saber si hay algo en el almacen
    private Semaphore semMutEx;//semaforo de exclusividad mutua
    private int tiempoProduccion;//tiempo que tarda en producir 1 unidad
    private boolean fired;//boolean para saber si un productor ha sido despedido
    private String producto;//nombre de la parte del celular que produce

    public Productor(Almacen a, Semaphore sP, Semaphore sE, Semaphore sMutEx, int tP, boolean fired, String product) {
        this.almacen = a;
        this.semPro = sP;
        this.semEns = sE;
        this.semMutEx = sMutEx;
        this.tiempoProduccion = tP;
        this.fired = fired;
        this.producto = product;

    }

    @Override
    public void run() {
        while (true) {
            try {
                semPro.acquire();
                semMutEx.acquire();
                //almacen.setVec(apuntaP, val);
                //apuntaP = (apuntaP + 1) % almacen.getSize();
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
