package aplicacion;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Productor extends Thread {
    //almacenes
    private Almacen almacenBat;//Almacen de baterias
    private Almacen almacenPan;//Almacen de pantallas
    private Almacen almacenCab;//Almacen de cables de conexion
    

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
    
    //otros
    private boolean fired;//boolean para saber si un productor ha sido despedido
    private String producto;//nombre de la parte del celular que produce
    
   // Tiempos
     private double duracionDia;
     private long tiempoProBat;//tiempo que tarda en producir 1 unidad de baterias
     private long tiempoProPan;//tiempo que tarda en producir 1 unidad de baterias  
     private long tiempoProCab;//tiempo que tarda en producir 1 unidad de baterias
   
    public void producitBateria(int apuntadorEns) {
        this.almacenBat.getAlmacen()[apuntadorEns] = 1;
        this.almacenBat.setApuntadorEns((apuntadorEns + 1) % this.almacenBat.getSize());
    }
    public void producitPantalla(int apuntadorEns) {
        this.almacenBat.getAlmacen()[apuntadorEns] = 1;
        this.almacenBat.setApuntadorEns((apuntadorEns + 1) % this.almacenBat.getSize());
    }
    public void producitCable(int apuntadorEns) {
        this.almacenBat.getAlmacen()[apuntadorEns] = 1;
        this.almacenBat.setApuntadorEns((apuntadorEns + 1) % this.almacenBat.getSize());
    }
/*
    @Override
    public void run() {
       
        this.tiempoProBat = (long) (this.duracionDia * 1000);
        this.tiempoProPan = (long) (this.duracionDia * 2000);
        this.tiempoProCab = (long) (this.duracionDia * 1000);
        
       
        while (!this.fired) {
            try {
                this.semBatEns.acquire(1);
                this.semPanEns.acquire(1);
                this.semCabEns.acquire(2);
                this.semBatMutEx.acquire(1);
                this.tomarBateria(this.almacenBat.getApuntadorEns());
                this.semBatMutEx.release(1);
                this.semPanMutEx.acquire(1);
                this.tomarPantalla(this.almacenPan.getApuntadorEns());
                this.semPanMutEx.release(1);
                this.semCabMutEx.acquire(1);
                this.tomarCable(this.almacenCab.getApuntadorEns());
                this.tomarCable(this.almacenCab.getApuntadorEns());
                Thread.sleep(this.tiempoEnsamblaje);
                this.cantCelulares++;
                this.cantCelularesTextField.setText(Integer.toString(this.cantCelulares));
                this.semCabMutEx.release(1);
                this.semCabPro.release(2);
                this.semPanPro.release(1);
                this.semBatPro.release(1);
            } catch (Exception e) {
                this.cantCelularesTextField.setText("Exception");

            }

        
    }

    }*/

}
