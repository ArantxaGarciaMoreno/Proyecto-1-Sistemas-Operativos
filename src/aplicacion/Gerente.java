package aplicacion;
import java.util.concurrent.Semaphore;
import java.util.Random;
import javax.swing.JTextField;


public class Gerente extends Thread{
    
    private Semaphore semContMutEx;//Semaforo para establecer exclusion mutua entre el cronometrador y el gerente
    private int cont;//contador***seccion critica¿?
    private int diasDespacho;//cantidad de dias entre despachos ***Seccion critica que lee el gerente
    private long tiempoDescanso;// tiempo de descanso del gerente
    private JTextField statusCTextField;//TextField donde se muestra el status del gerente
    
    private long rango;
    private int duracionDia;
    private long tiempoTrabajo;//tiempo que tarda el cronometrador en disminuir el contador en milisegundos para poder hacer el primer thread.sleep
    private Almacen almacen;
    
    private int diasAux; //auxiliar que guarda los dias de despacho iniciales
    
    public Gerente(Semaphore semContMutEx, int cont, int diasDespacho, long tiempoDescanso, JTextField statusCTextField, long rango, int duracionDia, long tiempoTrabajo, Almacen almacen) {
        this.semContMutEx = semContMutEx;
        this.cont = cont;
        this.diasDespacho = diasDespacho;
       this.diasAux = diasDespacho;
        this.tiempoDescanso = tiempoDescanso;
        this.statusCTextField = statusCTextField;
        this.rango = rango;
        this.duracionDia = duracionDia;
        this.tiempoTrabajo = tiempoTrabajo;
        this.almacen = almacen;
        
        
        
    }
    
    
    
    public void run() {
        
        
        this.rango = (long) ((Math.random()* 12) + 6);//rango de descanso del gerente entre 6 y 18h
        this.tiempoDescanso = (long) (((rango * this.duracionDia) / 24) * 1000);
        this.tiempoTrabajo = (long) ((this.duracionDia * 1000) - this.tiempoDescanso);//Tiempo que dura en la seccion crítica
           

        
        

        while (true) {
            try {
                this.semContMutEx.acquire();
                
                if(this.cont ==0){//condicion de entrada a la seccion critica
                
                    almacen.vaciar();
                    this.diasDespacho = diasAux;
                    this.cont = this.diasDespacho;
                    this.statusCTextField.setText("Despachando");
                    Thread.sleep(this.tiempoTrabajo); 
                    this.semContMutEx.release();
                
                }else{
                this.semContMutEx.release();
                
                Thread.sleep(this.tiempoDescanso);
                this.statusCTextField.setText("Durmiendo");
                } 
                    
                    
            } catch (Exception e) {
                this.statusCTextField.setText("Excepcion");
            }
        }

    }

    
}
