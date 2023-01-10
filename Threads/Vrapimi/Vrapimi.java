package Threads.Vrapimi;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

public class Vrapimi {
    int gjatesiaEPistes;
    private Vector<Atleti> lista;

    public Vrapimi (int gjatesiaEPistes) throws AtletiException{
        if (gjatesiaEPistes < 100) {
            throw new AtletiException("GjatesiaePistes eshte gabim");
        }
        this.gjatesiaEPistes=gjatesiaEPistes;
        lista = new Vector<Atleti>();
    }

    public void shtoAtletin(Atleti a) {
        if (lista.contains(a)) {
            System.out.println("Atleti gjindet ne list");
        }
        lista.add(a);
    }

    public void shtypAtletet() {
        Enumeration en = lista.elements();

        while (en.hasMoreElements()) {
            System.out.println(en.nextElement());
        }
    }

    public void filloGaren() {
        
        Iterator it = lista.iterator();

        while(it.hasNext()) {
            Object m = it.next();
            if (m instanceof Atleti) {
                Atleti a = (Atleti)m;
                if (a instanceof Vrapuesi) {
                    Vrapuesi v = (Vrapuesi)a;
                    if (v.getNrMedaljeve() < 3) {
                        v.setPriority(Thread.MAX_PRIORITY);
                    }
                }
                a.start();
            }
            
        }

    }

    public static void main(String[] args) {
        Vrapimi v = null;
        try {
            v = new Vrapimi(800);
            
            Vrapuesi v1 = new Vrapuesi(1, "Beni", 'M', 22, 0, 120, 1);
            Vrapuesi v2 = new Vrapuesi(2, "Loyan", 'F', 18, 0, 110, 3);
            Vrapuesi v3 = new Vrapuesi(3, "Rian", 'M', 20, 0, 115, 3);
            Vrapuesi v4 = new Vrapuesi(4, "Ava", 'F', 25, 0, 110, 3);
            Vrapuesi v5 = new Vrapuesi(5, "Roy", 'M', 27, 0, 100, 3);
            Vrapuesi v6 = new Vrapuesi(6, "Liam", 'M', 25, 0, 100, 3);
            Vrapuesi v7 = new Vrapuesi(7, "Idk", 'M', 21, 0, 150, 3);
            Vrapuesi v8 = new Vrapuesi(8, "Reas", 'M', 22, 0, 180, 3);
            
            v.shtoAtletin(v1);
            v.shtoAtletin(v2);
            v.shtoAtletin(v3);
            v.shtoAtletin(v4);
            v.shtoAtletin(v5);
            v.shtoAtletin(v6);
            v.shtoAtletin(v7);
            v.shtoAtletin(v8);

            v.shtypAtletet();

            System.out.println("FILLON GARA");
            v.filloGaren();


        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
