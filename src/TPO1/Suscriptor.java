package TPO1;

import java.util.concurrent.Callable;
import java.util.concurrent.Semaphore;

public class Suscriptor implements Observador, Callable<Integer> {

    private String nombre;
    private String estado;
    private String estados[] = {"Conectado", "Desconectado"};
    private Semaphore aviso = new Semaphore(0);

    public Suscriptor(String nombre) {
        this.nombre = nombre;
        this.estado = estados[(int) (Math.random() * 2)];
    }

    @Override
    public void actualizar() {
        aviso.release();
    }

    public void verVideo() {
        if (estado == "Desconectado") {
            System.out.println(nombre + " está ingresando a ver el video");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println(nombre + " viendo el video");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.estado = estados[(int) (Math.random() * 2)];

    }



    @Override
    public Integer call() throws Exception {
        aviso.acquire();
        verVideo();
        int calificacion = (int) (Math.random() * 10) + 1;  //Retorna un número aleatorio entre 1 y 10
        return calificacion ;
     }
}
