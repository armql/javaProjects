package DSH;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.Buffer;
import java.util.*;
import java.util.concurrent.locks.*;

public class Hoteli {
    private String emriHotelit;
    public ReentrantLock radha = new ReentrantLock();
    public Vector<Hapesira> lista;
    public Hashtable<Klienti, ArrayList<Hapesira>> klienti, hapesirat;

    public Hoteli(String emriHotelit) {
        this.emriHotelit = emriHotelit;
        klienti = new Hashtable<Klienti, ArrayList<Hapesira>>();
        hapesirat = new Hashtable<Klienti, ArrayList<Hapesira>>();
        lista = new Vector<Hapesira>();
    }

    public String getEmriHotelit() {
        return emriHotelit;
    }

    public void shtoHapesiren(Hapesira h) throws RezervimiException {
        if (h == null) {
            throw new RezervimiException("Hapesira nuk eshte inicializuar");
        }
        if(lista.contains(h)) {
            throw new RezervimiException("Hapesira ekziston");
        }
        lista.add(h);
    }

    public boolean kaHapesira(Hapesira h) {
        if (lista.isEmpty()) {
            return true;
        }
        return false;
    }

    public Hapesira rezervoHapsiren(Klienti k) throws RezervimiException{
        radha.lock();
        try{
            if(lista.isEmpty()) {
                throw new RezervimiException("Nuk ka ndonje hapesire ne hotel.");
            }
        
            Iterator<Hapesira> it = lista.iterator();

            while(it.hasNext()) {
                Hapesira h = it.next();

                if (klienti.containsKey(h) == false) {
                    it.remove();

                    ArrayList<Hapesira> temp = new ArrayList<Hapesira>();
                    temp.add(h);
                    klienti.put(k, temp);
                    return h;
                }
            }
            return null;
        }
        finally{
            radha.unlock();
        }
    }

    public void regjistroHapsiren(Klienti k, Hapesira h) throws RezervimiException {
        radha.lock();
        try{

            ArrayList<Hapesira> temp;
            if(klienti.containsKey(k)) {
                temp = klienti.get(k);
                temp.add(h);
                klienti.put(k, temp);
            }else {
                temp = new ArrayList<Hapesira>();
                temp.add(h);
                klienti.put(k, temp);
            }

        }
        finally{
            radha.unlock();
        }
    }

    public void faturo() throws RezervimiException,IOException {
        for(Klienti k : klienti.keySet()){
            ArrayList<Hapesira> hapsirat = klienti.get(k);
            String emri = k.getEmri() + ".txt";
            FileWriter fw = new FileWriter(emri);
            fw.write("Klienti: " + k.getEmri() + " " + k.getGjinia() + " " + k.getMosha() + " vjec\n");
            fw.write("------------------------------------------------------------------------\n");
            fw.write("Numri i hapesirave te rezervuara" + hapsirat.size() + "\n");
            fw.write("------------------------------------------------------------------------\n");
            double total = 0;
            for(Hapesira h : hapsirat) {
                fw.write(h.toString() + "\n");
                total = total + h.getCmimi();
            }
            fw.write("------------------------------------------------------------------------\n");
            fw.write("Totali: " + total + "\n");
            fw.close();
        }
    }
}
