package aplicacion;

import java.util.concurrent.Semaphore;
import javax.swing.JTextField;

public class Ensamblador extends Thread {

    //Almacenes
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
    //Otros
    private int duracionDia;
    private long tiempoEnsamblaje;//Tiempo que tarda un ensamblador en ensamblar un celular
    private boolean fired;//Variable para determinar si el ensamblador esta despedido o no
    private int cantCelulares;//Cantidad de celulares ensamblados disponibles en la fabrica en el momento
    private JTextField cantCelularesTextField;//TextField en el que se muestran la cantidad de celulares ensamblados disponibles para despachar 

    public Ensamblador(Semaphore semBatPro, Semaphore semBatEns, Semaphore semBatMutEx, Semaphore semPanPro, Semaphore semPanEns, Semaphore semPanMutEx, Semaphore semCabPro, Semaphore semCabEns, Semaphore semCabMutEx, Almacen almacenBat, Almacen almacenPan, Almacen almacenCab, boolean fired, int duracionDia, int cantCelulares, JTextField cantCelularesTextField) {
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
        this.duracionDia = duracionDia;
        this.cantCelulares = cantCelulares;
        this.cantCelularesTextField = cantCelularesTextField;

    }

    public void tomarBateria(int apuntadorEns) {
        this.almacenBat.getAlmacen()[apuntadorEns] = 0;
        this.almacenBat.setApuntadorEns((apuntadorEns + 1) % this.almacenBat.getSize());
    }

    public void tomarPantalla(int apuntadorEns) {
        this.almacenPan.getAlmacen()[apuntadorEns] = 0;
        this.almacenPan.setApuntadorEns((apuntadorEns + 1) % this.almacenPan.getSize());
    }

    public void tomarCable(int apuntadorEns) {
        this.almacenCab.getAlmacen()[apuntadorEns] = 0;
        this.almacenCab.setApuntadorEns((apuntadorEns + 1) % this.almacenCab.getSize());
    }

    public boolean isFired() {
        return fired;
    }

    public void setFired(boolean fired) {
        this.fired = fired;
    }

    public void run() {
        this.tiempoEnsamblaje = this.duracionDia * 2000;
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
    }

}
