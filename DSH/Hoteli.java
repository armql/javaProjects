package DSH;

import java.util.*;
import java.util.concurrent.locks.*;

public class Hoteli {
    private String emri;
    private ReentrantLock radha = new ReentrantLock();
    private Vector<Hapesira> lista;
    private Hashtable<String,Integer, ArrayList<Hapesira>> Klienti, list;
    /**
     * @param emri
     * @param radha
     * @param lista
     * @param list
     */
    public Hoteli(String emri) {
        this.emri = emri;
    }

    
}
