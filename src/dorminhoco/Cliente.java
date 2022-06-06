package dorminhoco;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 *
 * @author suporte
 */
public class Cliente implements Runnable {

    private final SalaEspera fila;
    private final Lock lock;
    private final Condition pode_dormir, corte_pronto;
    private volatile boolean done;

    public Cliente(SalaEspera fila, Lock lock, Condition pode_dormir, Condition corte_pronto) {
        this.fila = fila;
        this.lock = lock;
        this.pode_dormir = pode_dormir;
        this.corte_pronto = corte_pronto;
    }


    public void done() {
        done = true;
    }

    @Override
    public void run() {
        done = false;
        while (!done) {
            
        }
    }
}
