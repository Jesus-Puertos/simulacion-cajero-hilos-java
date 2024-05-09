package hilosjava;

public class Cliente {
    private int []tiemposProductos;

    public Cliente (int [] tiemposProductos){
        this.tiemposProductos = tiemposProductos;

    }
    public int[]getTiempoProductos(){
        return tiemposProductos;
    }

}
