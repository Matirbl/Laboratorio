package TPO1;

import java.util.concurrent.Callable;

public class Suscriptor implements Observador, Callable<String> {

    private String nombre;

    public Suscriptor(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void actualizar() {
        System.out.println();
    }


    @Override
    public String call() throws Exception {
        return null;
    }
}
