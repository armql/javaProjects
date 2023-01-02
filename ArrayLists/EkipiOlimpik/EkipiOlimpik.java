package ArrayLists.EkipiOlimpik;

import java.util.*;
import java.io.*;

public class EkipiOlimpik<ArrayLists> {
    private String emri;

    ArrayList <Sportisti> lista;

    public EkipiOlimpik(String emri) {
        this.emri = emri;
        lista = new ArrayList<Sportisti>();
    }


    public boolean ekziston() {
        for (Sportisti s : lista) {
            if (s.getEmri().equals(emri)) {
              return true;
            }
          }
          return false;
    }

    public void shtoSportistin(Sportisti s) throws SportistiException{
        if (s == null) {
            throw new SportistiException("Eshte null");
        }
        if (ekziston()) {
            throw new SportistiException("Ekziston");
        }
        lista.add(s);
    }

    public void shtypDistancen(int distanca) {

        Iterator it = lista.iterator();

        while(it.hasNext()){
            Object m = it.next();
            if (m instanceof Vrapuesi) {
                Vrapuesi a = (Vrapuesi)m;
                if (a.getDistanca() == distanca) {
                    System.out.println(a);
                }
            }
        }
    }

    public void shtypEmri(String emri) {

        Iterator it = lista.iterator();

        while(it.hasNext()) {
            Object m = it.next();

            if (m instanceof Sportisti) {
                Sportisti s = (Sportisti)m;
                if (s.getEmri().equals(emri)) {
                    System.out.println(s);
                }
            }
        }
    }

    public Sportisti[] ktheIndividualet(boolean garonIndividualisht) throws SportistiException{
        Sportisti[] sp = null;
        int count = 0;

        Iterator it = lista.iterator();
        
        while (it.hasNext()) {
            Object m = it.next();
            
            if (m instanceof Sportisti) {
                Sportisti sTest = (Sportisti)m;
            
                if (sTest.getEmri() != null) {
                    System.out.println("Emri eshte null");
                }
                if (sTest.garonIndividualisht() == garonIndividualisht) {
                    count++;
                }
            }
        }
    
        sp = new Sportisti[count];
        int pozita = 0;

        while(it.hasNext()) {
            Object m = it.next();

            if (m instanceof Sportisti) {
                Sportisti s = (Sportisti)m;

                if (s.garonIndividualisht() == garonIndividualisht) {
                    sp[pozita++] = s;
                }
            }
        }

        return sp;
    }

    public int fshijSportistin(int mosha) throws SportistiException{
        int count = 0;

        Iterator it = lista.iterator();

        if (mosha <= 0) {
            throw new SportistiException("Mosha eshte gabim shtyp perseri");
        }
        
        int age = 2022 - mosha;

        while(it.hasNext()) {
            Object m = it.next();
            if (m instanceof Sportisti) {
                Sportisti s = (Sportisti)m;

                if (s.getMosha() <= age) {
                    count++;
                    it.remove();
                    System.out.println("Fshihet: "+ count + "." + s);
                }
            }
        }

        return count;
    }

    public void printLista() {
        Iterator<Sportisti> it = lista.iterator();

        while (it.hasNext()) {
            for (int i = 0; i < lista.size(); i++) {
                System.out.println(i + ". " + it.next());
            }
        }
    }
    
    public static void main(String[] args) {
        try {
           EkipiOlimpik e = new EkipiOlimpik("Kosova Team");

            Futbollisti f1 = new Futbollisti("S001", "Raqip", 2001, 'M', 69);
            Futbollisti f2 = new Futbollisti("S002", "Demaq", 1995, 'M', 21);
            Futbollisti f3 = new Futbollisti("S003", "Sahit", 1992, 'M', 24);
            Futbollisti f4 = new Futbollisti("S004", "Sabit", 1986, 'M', 24);
            Futbollisti f5 = new Futbollisti("S004", "Ramize", 2000, 'F', 24);
            Futbollisti f6 = new Futbollisti("S004", "Sabile", 1992, 'F', 24);
            Futbollisti f7 = new Futbollisti("S004", "Remzie", 1995, 'F', 24);
        
            Karateisti k1 = new Karateisti("F010", "Diart", 2002, 'M', "Judo");
            Karateisti k2 = new Karateisti("F011", "Leart", 2000, 'M', "Karate");
            Karateisti k3 = new Karateisti("F012", "Lian", 1990, 'M', "Judo");

            Vrapuesi v1 = new Vrapuesi("B020", "Rain", 1994, 'M', 10, 400);
            Vrapuesi v2 = new Vrapuesi("B021", "Rain", 1984, 'M', 10, 80);
            Vrapuesi v3 = new Vrapuesi("B022", "Lian", 2000, 'M', 2, 150);
            Vrapuesi v4 = new Vrapuesi("B023", "Nire", 2001, 'F', 10, 600);
            Vrapuesi v5 = new Vrapuesi("B024", "Leon", 1990, 'F', 10, 200);
            
            e.shtoSportistin(f1);
            e.shtoSportistin(f2);
            e.shtoSportistin(f3);
            e.shtoSportistin(f4);
            e.shtoSportistin(f5);
            e.shtoSportistin(f6);
            e.shtoSportistin(f7);

            e.shtoSportistin(k1);
            e.shtoSportistin(k2);
            e.shtoSportistin(k3);
            
            e.shtoSportistin(v1);
            e.shtoSportistin(v2);
            e.shtoSportistin(v3);
            e.shtoSportistin(v4);
            e.shtoSportistin(v5);

            System.out.println("Printohet lista:");
            e.printLista();
            System.out.println("");
            System.out.println("shtypDistancen");
            e.shtypDistancen(200);
            System.out.println("");
            System.out.println("shtypEmri");
            e.shtypEmri("Lian");
            System.out.println("");
            System.out.println("fshijSportisti - Mosha");
            e.fshijSportistin(30);

            System.out.println("");
            System.out.println("Lista pas Fshirjes");
            e.printLista();
            
        } catch (SportistiException s) {
            s.getMessage();
        }
    }
}
