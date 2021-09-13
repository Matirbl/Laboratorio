package TPO1;

import java.util.LinkedList;
import java.util.List;

public abstract class Observado {


    List<Observador> observadores;


    public Observado(){
        observadores = new LinkedList<>();
    }

    public void enlazar(Observador o){
        observadores.add(o);
    }

    public void desEnlazar(Observador o){
        observadores.remove(o);
    }


    public void notificar() {

        for (Observador o : observadores) {
            o.actualizar();
    }
}


}