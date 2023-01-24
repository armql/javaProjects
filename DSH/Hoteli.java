package DSH;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.locks.*;

public class Hoteli {
    private String emriHotelit;
    public ReentrantLock radha = new ReentrantLock();
    public Vector<Hapesira> lista;

    // HASHTABLE[KLIENTI (klienti)key*, hapesirat arraylist per iterim]
    public Hashtable<Klienti, ArrayList<Hapesira>> klienti, hapesirat;

    // konstruktori pranon 
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
            Iterator<Hapesira> it = lista.iterator();
            while(it.hasNext()) {
                // iterohet lista
                Hapesira h = it.next();
                ArrayList<Hapesira> hapesirateRezervuara;
                if (klienti.containsKey(k)) {
                    hapesirateRezervuara = klienti.get(k);
                    if (hapesirateRezervuara.contains(h)) {
                        //Nese hapesira tashme eshte e rezervuar kthen exception
                        throw new RezervimiException("Hapesira e rezervuar.");
                    }
                } else {
                    hapesirateRezervuara = new ArrayList<Hapesira>();
                }
                // Nese Hapesira nuk eshte e rezervuar nga klienti e fshin nga lista...
                it.remove();
                // Prej listes kalon ne hapesir te rezervuar per klientin hashtable[]
                hapesirateRezervuara.add(h);
                klienti.put(k, hapesirateRezervuara);
                return h;
            }
            // Nese nuk ka hapesira te lira atehere e kthen null;
            return null;
        }
        finally{
            radha.unlock();
        }
    }

    public void regjistroHapsiren(Klienti k, Hapesira h) throws RezervimiException {
        radha.lock();
        try{

            // inicializohet arraylist hapesira temp
            ArrayList<Hapesira> temp;
            // thirret klienti nese ka si key* nga hashtable(k, h)
            if(klienti.containsKey(k)) {
                
                temp = klienti.get(k);
                if(temp.contains(h)){
                    throw new RezervimiException("Hapesira ekziston");
                }
            }
                // nese hapesira nuk eshte rezervuar ende rezervo hapesiren specifike me klientin specifik 
                temp = klienti.get(k);
                temp.add(h);
                klienti.put(k, temp);
        }
        finally{
            radha.unlock();
        }
    }

    public void faturo() throws RezervimiException,IOException {
        try {
            for(Klienti k : klienti.keySet()){
                double total = 0;
                String line = "------------------------------------------------------------------------\n";

                ArrayList<Hapesira> hapsirat = klienti.get(k);

                String filePath = "DSH\\fatura\\" + k.getEmri() + ".txt";
                FileWriter fw = new FileWriter(filePath);

                fw.write("Klienti: " + k.getEmri() + " " + k.getGjinia() + " " + k.getMosha() + " vjec.\n");
                fw.write(line);
                fw.write("Numri i hapesirave te rezervuara " + hapsirat.size() + "\n");
                fw.write(line);
            
                for(Hapesira h : hapsirat) {
                    fw.write(h.toString() + "\n");
                    total += h.getCmimi();
                }

                fw.write(line);
                fw.write("Totali: " + total + "EUR\n");
                fw.close();
            }

        }catch (IOException e) {
            System.out.println(e);
        }
    }
}
