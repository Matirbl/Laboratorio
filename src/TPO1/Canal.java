package TPO1;



public class Canal extends Observado {

    public void subirVideo(String título){
        System.out.println(  "\n");
        System.out.println("[---------- Nuevo video en el canal, " + título + ", deja tu calificación ----------]");
        notificar();    //Llamamos al método notificar dentro de la Clase abstracta Observado.

    }




    }


