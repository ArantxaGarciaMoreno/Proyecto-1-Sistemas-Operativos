package aplicacion;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;


public class Productor extends Thread {
    //almacenes
    private Almacen almacenProd;//Almacen de baterias
    
    

     //Semaforos
    private Semaphore pMutex;//semaforo de exclusion mutua
    private Semaphore semaProd;//semaforo de produccion
    private Semaphore semaEns;//semaforo del consumidor
   
    
    //otros
    private boolean fired;//boolean para saber si un productor ha sido despedido
    private String producto;//nombre de la parte del celular que produce
    private int cantP=0;//cantidad de producto total
    private JTextField cantProd;
   // Tiempos
     private double duracionDia;
     private long tiempoPro;//tiempo que controlara el sleep
     private long diasQTarda;//dias que tarda en producir 1 unidad
     
    

    public Productor(Almacen almacenProd, Semaphore pMutex, Semaphore semaProd, Semaphore semaEns, boolean fired, String producto, JTextField cantProd, double duracionDia, long diasQTarda) {
        this.almacenProd = almacenProd;
        this.pMutex = pMutex;
        this.semaProd = semaProd;
        this.semaEns = semaEns;
        this.fired = fired;
        this.producto = producto;
        this.cantProd = cantProd;
        this.duracionDia = duracionDia;
       // this.tiempoPro = tiempoPro;
        this.diasQTarda = diasQTarda;
    }
    
     public void producir(int apuntadorProd) {
        if(this.almacenProd.getAlmacen()[apuntadorProd]==0){
        this.almacenProd.getAlmacen()[apuntadorProd] = 1;
        this.almacenProd.setApuntadorEns((apuntadorProd + 1) % this.almacenProd.getSize());}
        this.cantProd.setText(Integer.toString(this.getCant()));
        
    }
    public boolean isFired() {
        return fired;
    }

    public void setFired(boolean fired) {
        this.fired = fired;
    }
     public int getCant(){//retorna la cantidad de producto producido
         for(int i=0; i< almacenProd.getSize(); i++){
             
                if(this.almacenProd.getAlmacen()[i]==1){
                  return  cantP++;
                }             
         }
          return cantP;
     }
    @Override
    public void run() {
       
        this.tiempoPro = (long) (this.duracionDia *this.diasQTarda* 1000);
 
       
        while (!this.fired) {
            try {
              this.semaProd.acquire(1);//revisa si tiene espacio para producir
              this.pMutex.acquire(1);//pide el espacio exclusivo para producir
              this.producir(this.almacenProd.getApuntadorPro()); //entra a la seccion critica y produce
              Thread.sleep(tiempoPro);
              this.semaProd.release(1);//sale del area de produccion
              this.semaEns.release(1);//le avisa al ensamblador que ya salio del area de produccion y puede tomar un producto
               
            } catch (Exception e) {
               
                this.cantProd.setText("Exception");

            }

        
    }

    }

}
