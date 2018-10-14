package aplicacion;

public class Almacen {

    int[] vecAlmacen;
    int size;
    int apuntadorPro = 0;
    int apuntadorEns = 0;

    public Almacen(int size) {
        this.size = size;
        this.vecAlmacen = new int[size];
        for (int i = 0; i < this.size; i++) {
            this.vecAlmacen[i] = 0;
        }

    }

    public int getVecAlmacen(int i) {
        return vecAlmacen[i];
    }

    public int getSize() {
        return size;
    }

    public int[] getVecAlmacen() {
        return vecAlmacen;
    }

    public void setVec(int i, int val) {
        this.vecAlmacen[i] = val;
    }

    public void vaciar() {
        for (int i = 0; i < size; i++) {
            vecAlmacen[i] = 0;
        }

    }
}
