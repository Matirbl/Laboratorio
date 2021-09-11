package TPO1;


import java.util.LinkedList;
import java.util.List;


public class Canal implements Observado {


    private final List<Observador> suscriptoresCanal;

    public Canal() {
        suscriptoresCanal = new LinkedList<>();
    }

    public void suscribirse(Observador s) {

        suscriptoresCanal.add(s);

    }

    public void desuscribirse(Observador s) {

        suscriptoresCanal.remove(s);
    }


    public void notificar() {

        for (Observador o : suscriptoresCanal) {
            o.actualizar();

        }


    }


}
