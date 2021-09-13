package TPO1;

import java.util.concurrent.Callable;

public class Suscriptor implements Observador, Callable<Integer> {

    private String nombre;
    private String estado;
    private String estados []= {"Conectado", "Desconectado"};

    public Suscriptor(String nombre) {

        this.nombre = nombre;
        this.estado = estados[(int)(Math.random() * 2)];
    }

    @Override
    public void actualizar() {
        if(estado == "Desconectado"){                                       //El estado lo pusimos para que sea útil el patrón observer, es decir, para que avise
                                                                            //a aquellos usuarios que están desconectados que se subió un nuevo video
        System.out.println( nombre + " está ingresando a ver el video");
        this.estado= "Conectado";
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        } else {
            System.out.println( nombre + " viendo el video");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.estado = estados[(int)(Math.random() * 2)];

    }

    @Override
    public Integer call() throws Exception {

        int calificacion = (int) (Math.random() * 10) + 1;  //Retorna un número aleatorio entre 1 y 10
        return calificacion ;
     }
}
