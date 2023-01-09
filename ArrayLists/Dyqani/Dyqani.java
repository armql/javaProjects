package ArrayLists.Dyqani;
import java.util.*;

public class Dyqani {
    private String emri;
    private ArrayList <Pajisja> lista;

    public Dyqani(String emri) {
        this.emri=emri;
        lista = new ArrayList <Pajisja>();
    }

    public boolean ekziston() {
        for (Pajisja p : lista) {
            if (lista.equals(p)) {
                return true;
            }
        }
        return false;
    }

    public void shtoPajisje(Pajisja p) throws PajisjaException{
        if (p == null) {
            throw new PajisjaException("Pajisja eshte null");
            }
        if (ekziston()) {
            throw new PajisjaException("Pajisja ekziston");
        }
        lista.add(p);
    }

    public void shtypMaterialin(String materiali) {


        Iterator it = lista.iterator();

        while (it.hasNext()) {
            Object m = it.next();

            if (m instanceof MulliriKafes) {
                MulliriKafes mk = (MulliriKafes)m;
                if (mk.getMateriali().equals(materiali)) {
                    System.out.println(mk);
                }
            }
        }
    }

    public void shtypBaterite(boolean kaBateri) {

        Iterator it = lista.iterator();

        while (it.hasNext()) {
            Object m = it.next();

            if (m instanceof PajisjaElektrike) {
                PajisjaElektrike pE = (PajisjaElektrike)m;
                if (pE.kaBateri() == kaBateri) {
                    System.out.println(pE);
                }
            }
        }
    }

    public Pajisja[] ktheProdhuesit(String prodhuesi) throws PajisjaException {
        List<Pajisja> pajisjetMeProdhuesin = new ArrayList<>();

        Iterator it = lista.iterator();
        while (it.hasNext()) {

            Object obj = it.next();
            
            if (obj instanceof Pajisja) {
                Pajisja p = (Pajisja) obj;
                if (p.getProdhuesi().equals(prodhuesi)) {
                    pajisjetMeProdhuesin.add(p);
                }
            }
        }
        
        if (pajisjetMeProdhuesin.isEmpty()) {
            throw new PajisjaException("Nuk eshte ndonje pajisje me emrin " + prodhuesi);
        }
        
        return pajisjetMeProdhuesin.toArray(new Pajisja[0]);
    }

    public void fshijPajisjen() {
        
        Iterator it = lista.iterator();

        while (it.hasNext()) {
            Object m = it.next();

            if (m instanceof Pajisja) {
                Pajisja p = (Pajisja)m;
                if (p.equals(p)) {
                    it.remove();
                }
            }
        }
    }

    public void printLista() {
        Iterator<Pajisja> it = lista.iterator();

        while (it.hasNext()) {
            for (int i = 0; i < lista.size(); i++) {
                System.out.println(i + ". " + it.next() + "\n");
            }
        }
    }

    public static void main(String[] args) {
        try {
            Dyqani d = new Dyqani("Aresmus");

            Enelaresja e1 = new Enelaresja("001", "Acer", 200, 'C', 8);
            Enelaresja e2 = new Enelaresja("002", "Benelo", 250, 'E', 2);
            Enelaresja e3 = new Enelaresja("003", "LIRE", 500, 'A', 2);
            Enelaresja e4 = new Enelaresja("004", "Benelo", 500, 'A', 2);
        
            MP3Player m1 = new MP3Player("010", "Apple", 80, 'A', 1024);
            MP3Player m2 = new MP3Player("011", "Apple Resp", 80, 'A', 2048);
            MP3Player m3 = new MP3Player("012", "Apple", 120, 'A', 1024);
            MP3Player m4 = new MP3Player("013", "Criter", 120, 'A', 512);
            MP3Player m5 = new MP3Player("013", "Lesna", 120, 'A', 256);
        
            MulliriKafes mk1 = new MulliriKafes("110", "Ceyton", "Wood");
            MulliriKafes mk2 = new MulliriKafes("111", "Alba", "Metal");
            MulliriKafes mk3 = new MulliriKafes("112", "RSI", "Copper");
            MulliriKafes mk4 = new MulliriKafes("113", "Ceyton", "Metal");
            
            d.shtoPajisje(e1);
            d.shtoPajisje(e2);
            d.shtoPajisje(e3);
            d.shtoPajisje(e4);
            d.shtoPajisje(m1);
            d.shtoPajisje(m2);
            d.shtoPajisje(m3);
            d.shtoPajisje(m4);
            d.shtoPajisje(m5);
            d.shtoPajisje(mk1);
            d.shtoPajisje(mk2);
            d.shtoPajisje(mk3);
            d.shtoPajisje(mk4);

            System.out.println("Printohet lista:");
            d.printLista();

            System.out.println("");
            System.out.println("Metoda shtypMaterialin:");
            d.shtypMaterialin("Metal");
            
            System.out.println("");
            System.out.println("Metoda kaBateri:");
            d.shtypBaterite(true);
            
            System.out.println("");
            System.out.println("Metoda ktheProdhuesit:");
            Pajisja[] temp1 = d.ktheProdhuesit("Apple");
            for (Pajisja a : temp1){
                System.out.println(a.toString());
            }
            
        } catch (Exception e) {
            // TODO: handle exception
        }
    }


}
