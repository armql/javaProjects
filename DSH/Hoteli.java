package DSH;

import java.util.*;
import java.util.concurrent.locks.*;

public class Hoteli {
    private String emri;
    private ReentrantLock radha = new ReentrantLock();
    private Vector<Hapesira> lista;
    private Hashtable<Klienti, ArrayList<Hapesira>> klienti, list;

    public Hoteli(String emri) {
        this.emri = emri;
    }

    public void shtoHapesiren(){
        
    }
}
