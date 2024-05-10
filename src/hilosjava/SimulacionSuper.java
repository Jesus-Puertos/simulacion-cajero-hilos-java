package hilosjava;

public class SimulacionSuper {
    public static void main(String [] args){
        int[] preciosProducto1 = {10,5,10};
        int[] preciosProducto2 = {1,1,1,1,1,1,1};
        int[] tiemposCliente1 = {3,5,2};
        int[] tiemposCliente2 = {2,4,4,3,5,1,2};

        Cliente cli1 = new Cliente(tiemposCliente1, preciosProducto1);
        Cliente cli2 = new Cliente(tiemposCliente2, preciosProducto2);



        Thread hiloC1 = new Thread (new Cajero(cli1,1));
        Thread hiloC2 = new Thread (new Cajero(cli2,2));

        hiloC1.start();
        hiloC2.start();

    }

}


