package CallableExample;

import java.util.concurrent.Callable;

/**
 *
 * @author Mati
 */
public class Chilo implements Callable<String> {

    public String call() throws Exception {
        return "Hilo Callable";
    }

}
