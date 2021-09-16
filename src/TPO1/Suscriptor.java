package TPO1;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.Semaphore;

public class Suscriptor implements Observador, Callable<Integer> {
    private String nombre;
    private boolean viendo;
    private Semaphore aviso = new Semaphore(0);         //Semaforo utilizado para simular concurrencia al momento de notificar a los suscriptores


    public Suscriptor(String nombre) {
        this.nombre = nombre;
        this.viendo = (new Random()).nextBoolean();            //Simulamos que un usuario podía no estar conectado esperando el video, por lo que la
    }                                                          //notificación iba a ser de utilidad.

    @Override
    public void actualizar() {                                 //El canal me notificó que se subió un video.

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
        return (int) (Math.random() * 10) + 1;                 //Retorna un número aleatorio entre 1 y 10 que representa
    }                                                          //la calificación que le pusieron al video

    @Override
    public Integer call() throws Exception {
        aviso.acquire();
        verVideo();
        return calificarVideo();
    }
}
