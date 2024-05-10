package hilosjava;

public class Cliente {
    private int []tiemposProductos;
    private int []preciosProductos;


    public Cliente (int [] tiemposProductos,int [] preciosProductos){
        this.tiemposProductos = tiemposProductos;
        this.preciosProductos = preciosProductos;


    }
    public int[]getTiempoProductos(){
        return tiemposProductos;
    }

    public int[]getPreciosProductos(){
        return preciosProductos;
    }

}
