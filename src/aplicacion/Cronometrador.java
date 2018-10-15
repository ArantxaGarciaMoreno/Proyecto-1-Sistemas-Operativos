package aplicacion;

import java.util.concurrent.Semaphore;
import javax.swing.JTextField;

public class Cronometrador extends Thread {
    private Semaphore semContMutEx;//Semaforo para establecer exclusividad mutua entre el cronometrador y el gerente
    private int cont;//contador
    private int duracionDia;//tiempo en segundos que dura un dia en el programa
    private int diasDespacho;//cantidad de dias entre despachos
    private JTextField statusCTextField;//TextField donde se muestra el status del cronometrador
    private JTextField diasDespachoTextField;//TextField donde se muestra los dias que faltan para el despacho

}
