package finalizingEXCEINTE;

public class Fakulteti{
    private String drejtimi;
    private Mesimdhenesi [] mesimdhenesit;
    private int index;

    public Fakulteti(String drejtimi, int nrM) {
        this.drejtimi=drejtimi;
        mesimdhenesit = new Mesimdhenesi[nrM];
    }

    public void shtoMesimdhenesi(Mesimdhenesi m) {
        if(m == null) {
            System.out.println("Mesimdhenesi eshte NULL");
            return;
        }
        if(index == mesimdhenesit.length) {
            System.out.println("Vargu eshte i mbushur me Mesimdhenes");
            return;
        }
        for (int i = 0; i < index; i++) {
            if(mesimdhenesit[i].equals(m)) {
                System.out.println("Mesimdhenesi egziston ne varg");
                return;
            }
        }
        mesimdhenesit[index++] = m;
    }

    public void shtypAngazhimFusha(String angazhimi, String fushaStudimi) {
        
        for (int i = 0; i < index; i++) {
            if (mesimdhenesit[i] instanceof Angazhim) {
                Angazhim a = (Angazhim)mesimdhenesit[i];
                if(a.getAngazhimi() == angazhimi) {
                    if(a instanceof Mesimdhenesi) {
                        Mesimdhenesi m = (Mesimdhenesi)a;
                        if(m.getFushaEStudimit().equals(fushaStudimi)){
                            System.out.println(mesimdhenesit[i]);
                        }
                    }
                }
            }
        }

    }

    public Mesimdhenesi [] mentoriMeIVjeter(int vitiLindjes,boolean mentoron) {

        Mesimdhenesi[] m = null;
        int count = 0;
        for (int i = 0; i < index; i++) {
            if(mesimdhenesit[i].getVitiLindjes() > vitiLindjes) {
                if(mesimdhenesit[i] instanceof Angazhim) {
                    Angazhim a = (Angazhim)mesimdhenesit[i];
                    if (a.mentoron() == mentoron) {
                        count++;
                    }
                }
            }
        }

        if(count == 0) {
            System.out.println("Asnje mesimdhenes nuk e plotson kushtin.");
            return null;
        }

        m = new Mesimdhenesi[count];
        int pozita = 0;

        for (int i = 0; i < index; i++) {
            if(mesimdhenesit[i].getVitiLindjes() > vitiLindjes) {
                if(mesimdhenesit[i] instanceof Angazhim) {
                    Angazhim a = (Angazhim)mesimdhenesit[i];
                    if (a.mentoron() == mentoron) {
                        m[pozita++] = mesimdhenesit[i];
                    }
                }
            }
        }

        return m;

    }

    public void printLista() {
        for (int i = 0; i < mesimdhenesit.length; i++) {
            System.out.println(i + "." + mesimdhenesit[i]);
        }
    }

    public static void main (String[]args){
      try {
            Fakulteti f = new Fakulteti("Shkenca Kompjuterike", 15);

            Profesori p1 = new Profesori("Blerim Blerimi", 1987, "Shkenca Kompjuterike", "Profesor");
            Profesori p2 = new Profesori("Xhelali", 1972, "Shkenca Kompjuterike", "Profesor");
            Profesori p3 = new Profesori("Lavda", 1988, "Shkenca Kompjuterike", "Profesor");
            Profesori p4 = new Profesori("Ramiz", 1975, "Web dhe Inxhinieri", "Profesor");
            Profesori p5 = new Profesori("Ramiz", 2002, "Web dhe Inxhinieri", "Profesor");

            Asistenti a1 = new Asistenti("Dion Kuka", 1992, "Shkenca Kompjuterike", "Java2");
            Asistenti a2 = new Asistenti("Elton", 1991, "Shkenca Kompjuterike", "Java2");
            Asistenti a3 = new Asistenti("Rion", 1993, "Shkenca Kompjuterike", "Java2");
            Asistenti a4 = new Asistenti("Berat", 1990, "Rrjeta Kompjuterike", "Rrjeta Kompjuterike");

            f.shtoMesimdhenesi(p1);
            f.shtoMesimdhenesi(p2);
            f.shtoMesimdhenesi(p3);
            f.shtoMesimdhenesi(p4);
            f.shtoMesimdhenesi(p5);

            f.shtoMesimdhenesi(a1);
            f.shtoMesimdhenesi(a2);
            f.shtoMesimdhenesi(a3);
            f.shtoMesimdhenesi(a4);
        
            f.printLista();
            
            System.out.println("");
            System.out.println("Metoda mentoriMeIVjeter: ");
            System.out.println(f.mentoriMeIVjeter(1990,true));

            System.out.println("");
            System.out.println("Metoda shtypAngazhimFusha: ");
            f.shtypAngazhimFusha("Ushtrime", "Java2");

            
        } catch (MesimdhenesiException e) {
            System.out.println(e.getMessage());
        }
        
    }

}
