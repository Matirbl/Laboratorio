package TPO1;

import java.util.List;

public interface Observado {

    List<Observador> observadores = null;

    static void enlazar(Observador o){
        observadores.add(o);
    }

    static void desEnlazar(Observador o){
        observadores.remove(o);
    }


    static void notificar() {

        for (Observador o : observadores) {
            o.actualizar();
    }
}
}