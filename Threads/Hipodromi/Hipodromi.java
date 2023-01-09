package Threads.Hipodromi;

import java.util.Enumeration;
import java.util.Vector;

public class Hipodromi {
    private String emri;
    private Vector<KafshaGaruese> lista;
    
    public Hipodromi (String emri) {
        this.emri=emri;

        lista = new Vector<KafshaGaruese>();
    }

    public void shtoKafsha(KafshaGaruese kg) throws GaraException{
        if (lista.contains(kg)) {
            throw new GaraException("Objekti ekziston");
        }
        lista.add(kg);
    }

    public void shtypKafshet() {

        Enumeration<KafshaGaruese> en = lista.elements();

        while(en.hasMoreElements()) {
            System.out.println(en.nextElement());
        }
    }

    public void filloGaren() {
        Enumeration<KafshaGaruese> en = lista.elements();

        while (en.hasMoreElements()) {
            KafshaGaruese kg = en.nextElement();

            if (kg instanceof KaliGarues) {
                kg.setPriority(Thread.MAX_PRIORITY);
            }
            kg.start();
        }
    }


    public static void main(String[] args) {
        Hipodromi h = null;
        try {
            h = new Hipodromi("Sedi");

            QeniGarues q1 = new QeniGarues(4, "Ben", 1);
            QeniGarues q2 = new QeniGarues(7, "Zane", 2);
            QeniGarues q3 = new QeniGarues(8, "Lime",3);
        
            KaliGarues k1 = new KaliGarues(5, "Riley", 4);
            KaliGarues k2 = new KaliGarues(6, "Baltimore", 5);
            KaliGarues k3 = new KaliGarues(8, "Black", 6);
        
            h.shtoKafsha(q1);
            h.shtoKafsha(q2);
            h.shtoKafsha(q3);

            h.shtoKafsha(k1);
            h.shtoKafsha(k2);
            h.shtoKafsha(k3);


            System.out.println("Kafshet garuese:");
            h.shtypKafshet();
            
            System.out.println("");
            System.out.println("Fillo Garen");
            h.filloGaren();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
