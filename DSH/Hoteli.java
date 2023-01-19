package DSH;

import java.util.*;
import java.util.concurrent.locks.*;

public class Hoteli {
    private String emri;
    public ReentrantLock radha = new ReentrantLock();
    public Vector<Hapesira> lista;
    public Hashtable<Klienti, ArrayList<Hapesira>> klienti, hapesirat;

    public Hoteli(String emri) {
        this.emri = emri;
        klienti = new Hashtable<Klienti, ArrayList<Hapesira>>();
        hapesirat = new Hashtable<Klienti, ArrayList<Hapesira>>();
        lista = new Vector<Hapesira>();
    }

    public void shtoHapesiren(Hapesira h) throws RezervimiException {
        if (h == null) {
            throw new RezervimiException("Hapesira nuk eshte inicializuar");
        }
        if(lista.contains(h)) {
            throw new RezervimiException("Hapesira egziston");
        }
        
        lista.add(h);
    }

    public boolean kaHapesira(Hapesira h) {
        if (lista.trimToSize().isEmpty()) {
            return true;
        }
        return false;
    }

    public void regjistroHapsiren(Klienti k, Hapesira h) throws RezervimiException {
        int count = 0;
        if (kaHapesira(h) == false) {
            return;
        }
        if (kaHapesira(h) == true) {
            count++;
        }

        
    }
}
