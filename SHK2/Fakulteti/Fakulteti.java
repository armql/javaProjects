package SHK2.Fakulteti;

public class Fakulteti {
    private String drejtimi;
    private StafiAkademik [] lista;
    int index = 0;

    public Fakulteti (String drejtimi, int nrL) {
        this.drejtimi=drejtimi;
        lista = new StafiAkademik[nrL];
    }

    public void shtoStafi(StafiAkademik sa) throws MesimdhenesiException {
        if (sa == null) {
           throw new MesimdhenesiException("Lista nuk eshte inicializuar."); 
        }
        if (index == lista.length) {
            throw new MesimdhenesiException("Lista eshte e mbushur.");
        }
        for(int i = 0; i<index; i++) {
            if (lista[i].equals(sa)) {
                throw new MesimdhenesiException("Personi ekziston ne list tashme");
            }
        }
        lista[index++] = sa;
    }

    public StafiAkademik stafiIRregulltMeIRI() {
        StafiAkademik meIRi = null;
        int count = 0;
        for (int i = 0; i < index; i++) {
            if (lista[i].getIRregullt() == false) {
                if (meIRi == null || lista[i].getVitiLindjes() < meIRi.getVitiLindjes()) {
                count++;
                meIRi = lista[i];
                }
            }
        }

        if (count == 0) {
            System.out.println("Nuk ka me te ri me vit");
        }

        return meIRi;
    }

    public Mesimdhenesi[] mentoretEVitit(int vitiLindjes) {

        Mesimdhenesi[] m = null;
        int count=0;

        for (int i = 0; i < index; i++) {
            if (lista[i] instanceof Mesimdhenesi) {
                Mesimdhenesi tempM = (Mesimdhenesi)lista[i];
                if (tempM.mentoron() == false) {
                    if (tempM.getVitiLindjes() == vitiLindjes) {
                        count++;
                    }
                }
            }
        }
        
        if (count == 0) {
            System.out.println("Lista nuk ka asnje person me vitin " + vitiLindjes);
        }
        
        m = new Mesimdhenesi[count];
        int pozita = 0;
        
        for (int i = 0; i < index; i++) {
            if (lista[i] instanceof Mesimdhenesi) {
                Mesimdhenesi tempM = (Mesimdhenesi)lista[i];
                if (tempM.mentoron() == false) {
                    if (tempM.getVitiLindjes() == vitiLindjes) {
                        m[pozita++] = tempM;
                    }
                }
            }
        }

        return m;
    }

    public static void main(String[] args) {
        try {
            Fakulteti f = new Fakulteti("UBT", 15);
            
            Dekani d = new Dekani("EDMOND BABA", 1970, "dfea");

            Profesori p1 = new Profesori("Blerimi", 1992, true, "dr.s.z.Blerim Zylfiu");
            Asistenti a1 = new Asistenti("Dion", 1997, false, "JAVA2");
            Profesori p2 = new Profesori("Lavda", 1993, true, "dr.s.z.LAVDA");
            Asistenti a2 = new Asistenti("Elton", 1998, false, "JAVA2");
            Profesori p3 = new Profesori("Shkelqim", 1987, true, "dr.s.z.Shkelqim");
            Asistenti a3 = new Asistenti("Mirlinda", 1995, false, "ALGORITME");
            
            f.shtoStafi(d);
            System.out.println("sfeaf");
            f.shtoStafi(p1);
            f.shtoStafi(a1);
            f.shtoStafi(p2);
            f.shtoStafi(a2);
            f.shtoStafi(p3);
            f.shtoStafi(a3);

            System.out.println(
            f.stafiIRregulltMeIRI()
            );
            System.out.println("-----------");
            System.out.println(
            f.mentoretEVitit(1997)
            );
            System.out.println("-----------");
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
