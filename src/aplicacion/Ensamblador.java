package aplicacion;
import java.util.concurrent.Semaphore;
/* Area de consumidores
*
*/
public class Ensamblador extends Thread{
    
      //Almacenes
    
    private Almacen almBaterias;
    private Almacen almPantallas;
    private Almacen almCables;
    
    //semaforos mutex
    private Semaphore mutexBat;
    private Semaphore mutexPant;
    private Semaphore mutexCabl;
    
    //Semaforos productores
    
    private Semaphore semafBatP;
    private Semaphore semafPantP;
    private Semaphore semafCablP;
    
    //Semaforos consumidores
    
    private Semaphore semafBatC;
    private Semaphore semafPantC;
    private Semaphore semafCablC;
    
    
  
    
    

    
}
