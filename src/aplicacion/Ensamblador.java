package aplicacion;

import java.util.concurrent.Semaphore;

/* Area de consumidores
*
 */
public class Ensamblador extends Thread {

    //Almacenes
    private Almacen almacenBat;
    private Almacen almacenPan;
    private Almacen almacenCab;
    //Semaforos
    private Semaphore semBatPro; //Semaforo para que el los productores de baterias sepan si hay o no espacio en el almacen de baterias 
    private Semaphore semBatEns; //Semaforo para que los ensambladores sepan si hay alguna bateria en el almacen para consumir
    private Semaphore semBatMutEx;//Semaforo para establecer la exclusividad mutua entre productor y ensamblador en el almacen de baterias
    private Semaphore semPanPro;//Semaforo para que los productores de pantallas sepan si hay espacio disponible en el almacen de pantallas
    private Semaphore semPanEns;//Semaforo para que los ensambladores sepan si hay pantallas en el almacen
    private Semaphore semPanMutEx;//Semaforo para establecer la exclusividad mutua entre productores de pantallas y ensambladores
    private Semaphore semCabPro;//Semaforo para que los productores de cables sepan si hay espacio en el almacen de cables
    private Semaphore semCabEns;//Semaforo para que los ensambladores sepan si hay cables en el almacen
    private Semaphore semCabMutEx;//Semaforo de exclusion mutua en el almacen de cables
    //Otros
    private int tiempoEnsamblaje;//Tiempo que tarda un ensamblador en ensamblar un celular
    private boolean fired;//Variable para determinar si el ensamblador esta despedido o no

    public Ensamblador(Semaphore semBatPro, Semaphore semBatEns, Semaphore semBatMutEx, Semaphore semPanPro, Semaphore semPanEns, Semaphore semPanMutEx, Semaphore semCabPro, Semaphore semCabEns, Semaphore semCabMutEx, Almacen almacenBat, Almacen almacenPan, Almacen almacenCab, boolean fired) {
        this.semBatEns = semBatEns;
        this.semBatMutEx = semBatMutEx;
        this.semBatPro = semBatPro;
        this.semCabEns = semCabEns;
        this.semCabMutEx = semCabMutEx;
        this.semCabPro = semCabPro;
        this.semPanEns = semPanEns;
        this.semPanMutEx = semPanMutEx;
        this.semPanPro = semPanPro;
        this.almacenBat = almacenBat;
        this.almacenPan = almacenPan;
        this.almacenCab = almacenCab;
        this.fired = fired;
    }

}
