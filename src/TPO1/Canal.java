package TPO1;


import java.util.LinkedList;
import java.util.List;


public class Canal implements Observado {


    private final List<Observador> suscriptoresCanal;           //Creamos una lista para guardar los suscriptores del canal

    public Canal() {
        suscriptoresCanal = new LinkedList<>();
    }

    public void suscribirse(Observador s) {                     //Suscribirse implica añardir el suscriptor a la lista del canal

        suscriptoresCanal.add(s);

    }

    public void desuscribirse(Observador s) {

        suscriptoresCanal.remove(s);
    }


    public void subirVideo(String título){
        System.out.println(  "\n");
        System.out.println("[---------- Nuevo video en el canal, " + título + ", deja tu calificación ----------]");
        this.notificar();

    }





    public void notificar() {

        for (Observador o : suscriptoresCanal) {
            o.actualizar();
        }


    }


}
