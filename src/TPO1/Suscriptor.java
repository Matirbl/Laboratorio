package TPO1;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.Semaphore;

public class Suscriptor implements Observador, Callable<Integer> {
    private String nombre;
    private boolean viendo;
    private Semaphore aviso = new Semaphore(0);

    public Suscriptor(String nombre) {
        this.nombre = nombre;
        this.viendo = (new Random()).nextBoolean();
    }

    @Override
    public void actualizar() {
        aviso.release();
    }

    public void verVideo() {
        if (!viendo) {
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
        this.viendo = obtenerEstadoNuevo();

    }

    public boolean obtenerEstadoNuevo() {
        return (new Random()).nextBoolean();
    }

    public int calificarVideo() {
        //Retorna un número aleatorio entre 1 y 10
        return (int) (Math.random() * 10) + 1;
    }

    @Override
    public Integer call() throws Exception {
        aviso.acquire();
        verVideo();
        return calificarVideo();
    }
}
