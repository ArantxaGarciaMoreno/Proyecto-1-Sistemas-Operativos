package aplicacion;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/* Area de Productores
*
*/
public class Productor extends Thread{
    
     Almacen al;
    private Semaphore sProduct;//semaforo productor
    private Semaphore sConsum;//semaforo consumidor
    private Semaphore sMutex;//semaforo de exclusividad mutua
   // private Semaphore sI;//SEmaforo de impresion a consola (se ajustará a la interfaz)
    private int apuntaP;//apuntaodr de los productores
    private int val;

    public Productor(Almacen a, Semaphore sP, Semaphore sC, Semaphore sE, int apuntP, int val, Semaphore sI) {
        this.al = al;
        this.sProduct = sProduct;
        this.sConsum = sConsum;
        this.sMutex = sMutex;
        this.apuntaP=apuntP;
        this.val=val;

    }
    
    @Override
    public void run(){
        while(true){
        try {
            sProduct.acquire();
            sMutex.acquire();
            al.setVec(apuntaP, val);
            apuntaP=(apuntaP+1)%al.getSize();
            sConsum.release();
            sMutex.release();
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
