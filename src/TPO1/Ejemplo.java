package TPO1;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Ejemplo {


    public static void main(String[] args) throws ExecutionException, InterruptedException {


        Canal canalYouTube = new Canal();

        Suscriptor[] suscriptores = new Suscriptor[10];

        ExecutorService executor = Executors.newFixedThreadPool(suscriptores.length);

        for (int i = 0; i < suscriptores.length; i++) {

            suscriptores[i] = new Suscriptor(" suscriptor " + i);
            canalYouTube.enlazar(suscriptores[i]);
        }

        canalYouTube.subirVideo(" Aprendiendo executor service");


        Future[] calificaciones= new Future[suscriptores.length];     // Calificaciones son las tereas asignadas a cada hilo Suscriptor

        for (int j = 0; j <calificaciones.length; j++) {
            calificaciones[j]  = executor.submit(suscriptores[j]);
        }


        for (int k = 0; k < calificaciones.length; k++) {
            System.out.println("El usuario " + k + " calificó el video con una puntuación de : " + calificaciones[k].get());

        }
        executor.shutdown();
    }
}
