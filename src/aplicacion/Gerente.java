package aplicacion;
import java.util.concurrent.Semaphore;
import java.util.Random;
import javax.swing.JTextField;


public class Gerente extends Thread{
    
    private Semaphore semContMutEx;//Semaforo para establecer exclusion mutua entre el cronometrador y el gerente
    private int cont;//contador***seccion critica¿?
  
    private long tiempoDescanso;// tiempo de descanso del gerente
    private JTextField statusGTextField;//TextField donde se muestra el status del gerente
    
    private long rango;
    private int duracionDia;
    private long tiempoTrabajo;//tiempo que tarda el cronometrador en disminuir el contador en milisegundos para poder hacer el primer thread.sleep
    private int cantCelulares;
    

    
    public Gerente(Semaphore semContMutEx, int cont, long tiempoDescanso, JTextField statusGTextField, long rango, int duracionDia, long tiempoTrabajo, int cantCelulares) {
        this.semContMutEx = semContMutEx;
        this.cont = cont;
      
        this.tiempoDescanso = tiempoDescanso;
        this.statusGTextField = statusGTextField;
        this.rango = rango;
        this.duracionDia = duracionDia;
        this.tiempoTrabajo = tiempoTrabajo;
        this.cantCelulares = cantCelulares;
        
        
        
    }
    
    
    
    public void run() {
        
        
        this.rango = (long) ((Math.random()* 12) + 6);//rango de descanso del gerente entre 6 y 18h
        this.tiempoDescanso = (long) (((rango * this.duracionDia) / 24) * 1000);
        this.tiempoTrabajo = (long) ((this.duracionDia * 1000) - this.tiempoDescanso);//Tiempo que dura en la seccion crítica
           

        
        

        while (true) {
            try {
                this.semContMutEx.acquire();
                
                if(this.cont ==0){//condicion de entrada a la seccion critica
                
                    this.statusGTextField.setText("Despachando");
                    Thread.sleep(this.tiempoTrabajo); 
                    
                    this.cantCelulares = 0;
                  
                  
                    
                  
                    this.semContMutEx.release();
                
                }else{
                this.semContMutEx.release();
                
                Thread.sleep(this.tiempoDescanso);
                this.statusGTextField.setText("Durmiendo");
                } 
                    
                    
            } catch (Exception e) {
                this.statusGTextField.setText("Excepcion");
            }
        }

    }

    
}
