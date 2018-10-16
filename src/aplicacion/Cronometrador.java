package aplicacion;

import java.util.concurrent.Semaphore;
import javax.swing.JTextField;

public class Cronometrador extends Thread {

    private Semaphore semContMutEx;//Semaforo para establecer exclusion mutua entre el cronometrador y el gerente
    private int cont;//contador
    private int duracionDia;//tiempo en segundos que dura un dia en el programa
    private int diasDespacho;//cantidad de dias entre despachos
    private JTextField statusCTextField;//TextField donde se muestra el status del cronometrador
    private JTextField diasDespachoTextField;//TextField donde se muestra los dias que faltan para el despacho
    private long tiempoTrabajo;//tiempo que tarda el cronometrador en disminuir el contador en milisegundos para poder hacer el primer thread.sleep
    private long tiempoDescanso;//tiempo que duerme el cronometrador al dia

    public Cronometrador(Semaphore semContMutEx, int cont, int duracionDia, int diasDespacho, JTextField statusCTextField, JTextField diasDespachoTextField) {
        this.semContMutEx = semContMutEx;
        this.cont = cont;
        this.duracionDia = duracionDia;
        this.diasDespacho = diasDespacho;
        this.statusCTextField = statusCTextField;
        this.diasDespachoTextField = diasDespachoTextField;

    }

    public void run() {

        this.tiempoTrabajo = (long) (((1.5 * this.duracionDia) / 24) * 1000);
        this.tiempoDescanso = (long) ((this.duracionDia * 1000) - this.tiempoTrabajo);

        while (true) {
            try {
                this.semContMutEx.acquire(1);
                this.statusCTextField.setText("Trabajando");
                Thread.sleep(this.tiempoTrabajo);
                this.cont--;
                if (this.cont < 0) {
                    this.cont = this.diasDespacho;
                }
                this.diasDespachoTextField.setText(Integer.toString(this.cont));
                this.semContMutEx.release(1);
                this.statusCTextField.setText("Durmiendo");
                Thread.sleep(this.tiempoDescanso);

            } catch (Exception e) {
                this.statusCTextField.setText("Exception");
            }
        }

    }

}
