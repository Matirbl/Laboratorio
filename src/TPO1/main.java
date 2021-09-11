package TPO1;

import CallableExample.Chilo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class main {


    public static void main(String[] args) {


        Canal youtube1 = new Canal();

        Suscriptor[] suscriptores = new Suscriptor[10];

        ExecutorService executor = Executors.newFixedThreadPool(suscriptores.length);

        for (int i = 0; i < suscriptores.length; i++) {

            suscriptores[i] = new Suscriptor(" suscriptor " + i);
            youtube1.suscribirse(suscriptores[i]);
        }


        Future<String>[] tareas= new Future[suscriptores.length];

        for (int j = 0; j <tareas.length; j++) {

            tareas[j]  = executor.submit(suscriptores[j]);

        }


    }
}
