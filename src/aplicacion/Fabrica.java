package aplicacion;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import java.util.Scanner;
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
    private Ensamblador[] ensambladores;
    //Variables globales importantes
    private int cantCelulares;//cantidad de celulares ensamblados en cualquier momento
    private int cont;//dias para el despacho en cualquier momento
    private int cantProBat;//cantidad de productores de baterias en cualquier momento
    private int cantProPan;//cantidad de productores de pantallas en cualquier momento
    private int cantProCab;//cantidad de productores de cables en cualquier momento
    private int cantEns;//cantidad de ensambladores en la fabrica en cualquir momento
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
    // valores que se leen desde el archivo de texto 
    private double tiempo;
    private int cantDias;

    private int capMaxAlBat;
    private int capMaxAlPant;
    private int capMaxAlCabl;

    private int cantIniPBat;
    private int cantIniPPant;
    private int cantIniPCabl;

    private int cantMaxPBat;
    private int cantMaxPPant;
    private int cantMaxPCabl;

    private int cantIniEns;
    private int cantMaxEns;

    private Scanner sc;

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
        try {
            this.Leer();
        } catch (Exception e) {
            System.out.println("File not found");
        }
        this.almacenBat = new Almacen(this.capMaxAlBat);
        this.almacenPan = new Almacen(this.capMaxAlPant);
        this.almacenCab = new Almacen(this.capMaxAlCabl);
        this.proBat = new Productor[this.cantMaxPBat];
        this.proPan = new Productor[this.cantMaxPPant];
        this.proCab = new Productor[this.cantMaxPCabl];
    }

    // Algoritmo de lectura de TXT 
    //NOTA IMPORTANTE: cambiar la direccion del archivo de texto segun la pc***************
    public void Leer() throws FileNotFoundException {

        sc = new Scanner(new File("C:\\Users\\Aran_\\Documents\\NetBeansProjects\\PRO1SOArantxaGarcia_SabrinaGarcia\\src\\aplicacion\\datos.txt"));

        String linea = sc.nextLine();
        String basura;
        this.tiempo = parseDouble(linea.substring(46, 48).trim());
        linea = sc.nextLine();
        System.out.println(this.tiempo);

        this.cantDias = parseInt(linea.substring(46, 48).trim());
        linea = sc.nextLine();
        System.out.println(this.cantDias);

        this.capMaxAlBat = parseInt(linea.substring(46, 48).trim());
        linea = sc.nextLine();
        System.out.println(this.capMaxAlBat);

        this.capMaxAlPant = parseInt(linea.substring(46, 48).trim());
        linea = sc.nextLine();
        System.out.println(this.capMaxAlPant);

        this.capMaxAlCabl = parseInt(linea.substring(46, 48).trim());
        linea = sc.nextLine();
        System.out.println(this.capMaxAlCabl);

        this.cantIniPBat = parseInt(linea.substring(46, 48).trim());
        linea = sc.nextLine();
        System.out.println(this.cantIniPBat);

        this.cantIniPPant = parseInt(linea.substring(46, 48).trim());
        linea = sc.nextLine();
        System.out.println(this.cantIniPPant);

        this.cantIniPCabl = parseInt(linea.substring(46, 48).trim());
        linea = sc.nextLine();
        System.out.println(this.cantIniPCabl);

        this.cantMaxPBat = parseInt(linea.substring(46, 48).trim());
        linea = sc.nextLine();
        System.out.println(this.cantMaxPBat);

        this.cantMaxPPant = parseInt(linea.substring(46, 48).trim());
        linea = sc.nextLine();
        System.out.println(this.cantMaxPPant);

        this.cantMaxPCabl = parseInt(linea.substring(46, 48).trim());
        linea = sc.nextLine();
        System.out.println(this.cantMaxPCabl);

        this.cantIniEns = parseInt(linea.substring(46, 48).trim());
        linea = sc.nextLine();
        System.out.println(this.cantIniEns);

        this.cantMaxEns = parseInt(linea.substring(46, 48).trim());

        System.out.println(this.cantMaxEns);

    }
}
