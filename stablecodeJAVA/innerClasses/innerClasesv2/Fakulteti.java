package innerClasses.innerClasesv2;

import StafAkademik.Mesimdhenesi;

public class Fakulteti {
    private String drejtimi;
    private Mesimdhenesi[] mesimdhenesit;
    private static int numriM;
    private int index;

    public Fakulteti(String drejtimi) {
        this.drejtimi = drejtimi;
    }

    static {
        numriM = 25;
    }

    {
        Fakulteti.Vizituesi viz = new Fakulteti.Vizituesi("Arlind", 2002, 10);
        mesimdhenesit = new Mesimdhenesi[numriM];
        shtoMesimdhenesi(viz);
    }

    public class Tutori extends Mesimdhenesi {
        int vitiStudimeve;

        public Tutori(String emri, int vitiLindjes, int vitiStudimeve) {
            super(emri, vitiLindjes, "Tutorime");
            this.vitiStudimeve = vitiStudimeve;
        }

        public int getVitiStudimeve() {
            return vitiStudimeve;
        }

        public void setVitiStudimeve(int vitiStudimeve) {
            this.vitiStudimeve = vitiStudimeve;
        }

        public boolean mentoron() {
            return false;
        }

        @Override
        public String toString() {
            return "Tutori i vitit " + vitiStudimeve + " : " + super.toString();
        }
    }

    public static class Vizituesi extends Mesimdhenesi {
        private int numriOreve;

        public Vizituesi(String emri, int vitiLindjes, int numriOreve) {
            super(emri, vitiLindjes, "te Ndryshëm");
            this.numriOreve = numriOreve;
        }

        public boolean mentoron() {
            return true;
        }

        @Override
        public String toString() {
            return "Mesimdhenesi vizitues " + super.toString() + " me " + numriOreve + " ore";
        }
    }

    public boolean egziston(Mesimdhenesi m) {
        for (int i = 0; i < index; i++) {
            if (mesimdhenesit[i].equals(m)) {
                return true;
            }
        }
        return false;
    }

    public void shtoNjeMesimdhenes(String emri, int vitiLindjes, String angazhimi, boolean mentoron) {
        Mesimdhenesi m = new Mesimdhenesi(emri, vitiLindjes, angazhimi) {
            public boolean mentoron() {
                return mentoron;
            }
        };
        shtoMesimdhenesi(m);
    }

    public void shtoMesimdhenesi(Mesimdhenesi m) {
        if (m == null) {
            System.out.println("Nuk mund te shtohet sepse eshte null.");
            return;
        }
        if (index == mesimdhenesit.length) {
            System.out.println("Mesimdhenesi nuk mund te shtohet pasi vargu eshte mbushur");
        }
        if (egziston(m)) {
            System.out.println("Mesimdhenesi tashme egziston.");
        }
        mesimdhenesit[index++] = m;
    }


    public void shtypSipasEmrit(String emri) {
        for (int i = 0; i < index; i++) {
            if (mesimdhenesit[i].getEmri().equals(emri)) {
                System.out.println(mesimdhenesit[i]);
            }
        }
    }

    public int fshijSipasEmrit(String emri) {
        int count = 0;

        for (int i = 0; i < index; i++) {
            count++;
            if (mesimdhenesit[i].equals(emri)) {

                for (int j = i; j < index; j++) {
                    mesimdhenesit[j] = mesimdhenesit[j + 1];
                }

                mesimdhenesit[--index] = null;
                i--;
            }
        }
        return count;
    }

    public boolean fshijSipasVitiLindjes(int vitiLindjes) {

        for (int i = 0; i < index; i++) {
            if (mesimdhenesit[i].getVitiLindjes() == vitiLindjes) {

                for (int j = i; j < index; j++) {
                    mesimdhenesit[j] = mesimdhenesit[j + 1];
                }

                mesimdhenesit[--index] = null;
                i--;
                return true;
            }
        }
        return false;
    }

   

    public static void main(String[] args) {
        Fakulteti f = new Fakulteti("UBT");

        Profesori p1 = new Profesori("Albin Kurti", 1975, "Dr Honor Kauza");
        Profesori p2 = new Profesori("Blerim Kurti", 1980, "Profesor");
        Profesori p3 = new Profesori("Trim Kurti", 2002, "Profesor");

        Asistenti a1 = new Asistenti("Dion Kuka", 1994, "Ushtrime Konceptuale");
        Asistenti a2 = new Asistenti("Elton Aliu", 1995, "Ushtrime");
        Asistenti a3 = new Asistenti("Behar", 1995, "Ushtrime");

    }

}
