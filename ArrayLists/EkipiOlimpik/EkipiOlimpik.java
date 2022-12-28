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

    public void shtypSportistin(Sportisti s) throws SportistiException{
        if (s == null) {
            throw new SportistiException("Eshte null");
        }
        if (lista.contains(s)) {
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

    public Sportisti ktheIndividualet(boolean garonIndividualisht) {
        Sportisti[] s = null;
        int count;

        Iterator it = lista.iterator();
        
        while () {
            
        }
    }
}
