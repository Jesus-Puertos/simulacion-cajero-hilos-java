package hilosjava;

public class Cajero implements Runnable {
    private static int contadorProductos = 0;
    private static int totalDinero = 0;
    private static int totalCaja1 = 0;
    private static  int totalCaja2 = 0;


    private Precio precios;
    private Cliente cliente;
    private int nCajero;

    public Cajero(Cliente cliente, int nCajero, Precio precios) {
        this.cliente = cliente;
        this.nCajero = nCajero;
        this.precios = precios;
    }

    @Override
    public void run() {
        int totalTiempo = 0;
        int[] tiempoProductos = cliente.getTiempoProductos();
        int [] precioProductos = precios.getPrecioProductos();

        for (int i = 0; i < tiempoProductos.length; i++) {
            int tiempoProducto = tiempoProductos[i];
            totalTiempo += tiempoProducto;
            System.out.println("cajero " + nCajero + " escaneando producto " + tiempoProducto);
            synchronized (Cajero.class) {
                contadorProductos += 1;
            }

            int precioProducto = precioProductos[i];
            System.out.println("cajero " + nCajero + " cobrando $" + precioProducto + " del producto " + tiempoProducto);
            synchronized (Cajero.class) {
                totalDinero += precioProducto;
                    if (nCajero == 1) {
                        totalCaja1 += precioProducto;
                    }else{
                        totalCaja2 += precioProducto;
                    }
            }




            try {
                Thread.sleep(tiempoProducto * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }



        }


        System.out.println("El cajero " + nCajero + " Termino: Productos totales en general " + contadorProductos);
        System.out.println("El cajero " + nCajero + " Termino: Dinero total en general es de $" + totalDinero);
        System.out.println("Tiempo total del cajero " + nCajero + " es " + totalTiempo + " s");
        System.out.println("La caja numero 1 recolecto: $" + totalCaja1);
        System.out.println("La caja numero 2 recolecto: $" + totalCaja2);
    }
}