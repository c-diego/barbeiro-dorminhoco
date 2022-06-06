package dorminhoco;

import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
/**
 *
 * @author suporte
 */
public class Barbeiro implements Runnable {

    private final SalaEspera fila;
    private final Lock lock;
    private final Condition pode_dormir, corte_pronto;
    private volatile boolean done;

    public Barbeiro(SalaEspera fila, Lock lock, Condition pode_dormir, Condition corte_pronto) {
        this.fila = fila;
        this.lock = lock;
        this.pode_dormir = pode_dormir;
        this.corte_pronto = corte_pronto;
    }

    public void trabalhar() {
        lock.lock();
        try {
            while (fila.isEmpty()) {
                try {
                    pode_dormir.await();
                } catch (InterruptedException ex) {}
            }
            
            Random rand = new Random();
            int milis = rand.nextInt(10) + 1;
            
            try {
                Thread.sleep(milis);
            } catch (InterruptedException ex) {}
            
            corte_pronto.signal();
            
        } finally {
            lock.unlock();
        }
    }
    
    public void done() {
        done = true;
    }

    @Override
    public void run() {
        done = false;
        while (!done) {
            trabalhar();
        }
    }
}
