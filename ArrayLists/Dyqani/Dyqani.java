package ArrayLists.Dyqani;
import java.util.*;

import ArrayLists.EkipiOlimpik.Sportisti;

public class Dyqani {
    private String emri;
    private ArrayList <Sportisti> lista;

    public Dyqani(String emri) {
        this.emri=emri;
        lista = new ArrayList <Sportisti>();
    }

    public boolean ekziston() {
        for (Sportisti s : lista) {
            if (s.getEmri().equals(emri)) {
                return true;
            }
        }
        return false;
    }

    public void shtoPajisje() {
        
    }
}
