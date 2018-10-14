package aplicacion;



public class Almacen {
    int[] vecAlmacen;
    int size;
    
    public Almacen(int size){
        this.size=size;
        vecAlmacen = new int[size];
        
       
    }

    public int getVecAlmacen(int i) {
        return vecAlmacen[i];
    }

    public int getSize() {
        return size;
    }

 public void setVec(int i, int val) {
        this.vecAlmacen[i] = val;
    }
    
    //comrpobar si es necesario 
    public void vaciar(){
        for(int i=0; i<size; i++){
           vecAlmacen[i]=0;
        }
 
    }
}
