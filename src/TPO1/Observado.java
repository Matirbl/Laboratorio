package TPO1;

import java.util.LinkedList;
import java.util.List;

public abstract class Observado {

    List<Observador> observadores;

    public Observado() {                                //Constructor

        observadores = new LinkedList<>();              //Creamos la lista de objetos observadores de nuestro objeto observable.
    }

    public void enlazar(Observador o) {                 //Añadimos un nuevo objeto observador la lista.

        observadores.add(o);
    }

    public void desEnlazar(Observador o) {              //Eliminamos un objeto observador de la lista.

        observadores.remove(o);
    }

    public void notificar() {                           //Notificamos a todos los observadores de algún cambio.
        for (Observador o : observadores) {
            o.actualizar();
        }
    }

}