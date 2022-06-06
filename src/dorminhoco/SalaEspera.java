package dorminhoco;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 *
 * @author suporte
 */
public class SalaEspera {
    
    private ConcurrentLinkedQueue<Cliente> fila;
    
    public SalaEspera() {
        fila = new ConcurrentLinkedQueue<>();
    }
    
    public boolean add(Cliente cliente) {
        return fila.add(cliente);
    }
    
    public Cliente get() {
        return fila.remove();
    }
    
    public boolean isEmpty() {
        return fila.isEmpty();
    }
}
