package CallableExample;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

    /**
     *
     * @author Mati
     */
    public class HilosApp {

        public static void main(String[] args) throws Exception {
            ExecutorService executor = Executors.newFixedThreadPool(2);
            Future<String> task1 = executor.submit(new Chilo());
            Future<?> task2= executor.submit(new Chilo());


            while (!task1.isDone() && !task2.isDone()){
            }
            System.out.println(task1.get());
            System.out.println(task2.get());
        }
    }

