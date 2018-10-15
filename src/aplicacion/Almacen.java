package aplicacion;

public class Almacen {

    private int[] almacen;
    private int size;
    private int apuntadorPro = 0;
    private int apuntadorEns = 0;

    public Almacen(int size) {
        this.size = size;
        this.almacen = new int[size];
        this.vaciar();

        }

    public int getApuntadorPro() {
        return apuntadorPro;
    }

    public void setApuntadorPro(int apuntadorPro) {
        this.apuntadorPro = apuntadorPro;
    }

    public int getApuntadorEns() {
        return apuntadorEns;
    }

    public void setApuntadorEns(int apuntadorEns) {
        this.apuntadorEns = apuntadorEns;
    }

    public int getPieza(int i) {
        return almacen[i];
    }

    public int getSize() {
        return size;
    }

    public int[] getAlmacen() {
        return almacen;
    }

    public void setPieza(int i, int val) {
        this.almacen[i] = val;
    }

    public void vaciar() {
        for (int i = 0; i < this.size; i++) {
            this.almacen[i] = 0;
        }

    }
}
