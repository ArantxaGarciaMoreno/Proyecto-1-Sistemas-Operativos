package aplicacion;

import java.util.concurrent.Semaphore;
import javax.swing.JTextField;

public class Fabrica {

    //Semaforos 
    private Semaphore semBatPro; //Semaforo para que el los productores de baterias sepan si hay o no espacio en el almacen de baterias 
    private Semaphore semBatEns; //Semaforo para que los ensambladores sepan si hay alguna bateria en el almacen para consumir
    private Semaphore semBatMutEx;//Semaforo para establecer la exclusividad mutua entre productor y ensamblador en el almacen de baterias
    private Semaphore semPanPro;//Semaforo para que los productores de pantallas sepan si hay espacio disponible en el almacen de pantallas
    private Semaphore semPanEns;//Semaforo para que los ensambladores sepan si hay pantallas en el almacen
    private Semaphore semPanMutEx;//Semaforo para establecer la exclusividad mutua entre productores de pantallas y ensambladores
    private Semaphore semCabPro;//Semaforo para que los productores de cables sepan si hay espacio en el almacen de cables
    private Semaphore semCabEns;//Semaforo para que los ensambladores sepan si hay cables en el almacen
    private Semaphore semCabMutEx;//Semaforo para estalecer la exclusividad mutua entre los productores de cables y los ensambladores en el almacen de cables
    private Semaphore semContMutEx;//Semaforo para establecer exclusividad mutua entre el cronometrador y el gerente
    //Almacenes
    private Almacen almacenBat;
    private Almacen almacenPan;
    private Almacen almacenCab;
    //Vectores de productores de cada tipo
    private Productor[] proBat;
    private Productor[] proPan;
    private Productor[] proCab;
    //Vector de ensambladores de la fabrica (consumidores)
    private Ensamblador ensambladores[];
    //JTextField de la interfaz que seran modificados a los largo de la simulacion
    private JTextField cantBTextField;
    private JTextField cantPTextField;
    private JTextField cantCTextField;
    private JTextField cantETextField;
    private JTextField cantPBTextField;
    private JTextField cantPCTextField;
    private JTextField cantPPTextField;
    private JTextField cantCelularesTextField;
    private JTextField diasDespachoTextField;
    private JTextField statusCTextField;
    private JTextField statusGTextField;

    public Fabrica(JTextField cantBTextField, JTextField cantPTextField, JTextField cantCTextField, JTextField cantETextField, JTextField cantPBTextField, JTextField cantPCTextField, JTextField cantPPTextField, JTextField cantCelularesTextField, JTextField diasDespachoTextField, JTextField statusCTextField, JTextField statusGTextField) {
        this.cantBTextField = cantBTextField;
        this.cantCTextField = cantCTextField;
        this.cantPTextField = cantPTextField;
        this.cantPBTextField = cantPBTextField;
        this.cantPPTextField = cantPPTextField;
        this.cantPCTextField = cantPCTextField;
        this.cantETextField = cantETextField;
        this.cantCelularesTextField = cantCelularesTextField;
        this.diasDespachoTextField = diasDespachoTextField;
        this.statusCTextField = statusCTextField;
        this.statusGTextField = statusGTextField;
    }

}
