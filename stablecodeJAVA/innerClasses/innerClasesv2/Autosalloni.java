package innerClasses.innerClasesv2;

public class Autosalloni {
    private String emri;
    private Automjeti [] automjetet;
    private static int numriA;
    private int index;

    static {
        numriA = 250;
    }

    {
        automjetet = new Automjeti[numriA];
        Autosalloni.Coupe cop = new Autosalloni.Coupe("341", "Belsch", 2020, 2);
    }

    public Autosalloni(String emri) {
        this.emri=emri;
    }

    public class Minibusi extends Automjeti {
        private int numriDyerve;

        public Minibusi(String nrShasise, String prodhuesi, int vitiProdhimit, int numriDyerve) {
            super(nrShasise, prodhuesi, vitiProdhimit);
            this.numriDyerve = numriDyerve;
        }

        public boolean eshteAutomatik() {
            return true;
        }

        @Override
        public String toString() {
            return "Minibusi " + super.toString() + " : " + numriDyerve;
        }

    }

    public static class Coupe extends Automjeti{
        private int numriUlseve;

        public Coupe(String nrShasise, String prodhuesi, int vitiProdhimit,int numriUlseve) {
            super(nrShasise, prodhuesi, vitiProdhimit);
            this.numriUlseve=numriUlseve;
        }

        public int getNumriUlseve() {
            return numriUlseve;
        }public void setNumriUlseve(int numriUlseve) {
            this.numriUlseve = numriUlseve;
        }

        public boolean eshteAutomatik() {
            return false;
        }

        public String toString() {
            return "Coupe " + super.toString() + " - me " + numriUlseve  + " ulese";
        }

    }

    public void shtoAutomjetin(Automjeti a) {
        if(a == null) {
            System.out.println("Automjeti eshte NULL");
            return;
        }
        if (index == automjetet.length) {
            System.out.println("Autosalloni eshte mbushur me automjete");
            return;
        }
        for (int i = 0; i < index; i++) {
            if (automjetet[i].equals(a)) {
                System.out.println("Automjeti egziston ne autosallon");
                return;
            }
        }
        automjetet[index++] = a;
    }

    public void shtoNjeAutomjet(String nrShasise, String prodhuesi, int vitiProdhimit, boolean eshteAutomatik) {
        Automjeti a = new Automjeti(nrShasise, prodhuesi, vitiProdhimit) {
            public boolean eshteAutomatik() {
                return eshteAutomatik;
            }
        };
        shtoAutomjetin(a);
    }





}
