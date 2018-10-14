package aplicacion;

public class Almacen {

    private int[] almacen;
    private int size;
    private int apuntadorPro = 0;
    private int apuntadorEns = 0;

    public Almacen(int size) {
        this.size = size;
        this.almacen = new int[size];
        for (int i = 0; i < this.size; i++) {
            this.almacen[i] = 0;
        }

    }

    public int getVecAlmacen(int i) {
        return almacen[i];
    }

    public int getSize() {
        return size;
    }

    public int[] getVecAlmacen() {
        return almacen;
    }

    public void setVec(int i, int val) {
        this.almacen[i] = val;
    }

    public void vaciar() {
        for (int i = 0; i < size; i++) {
            almacen[i] = 0;
        }

    }
}
