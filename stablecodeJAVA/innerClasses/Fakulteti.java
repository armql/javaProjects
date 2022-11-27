package innerClasses;

public class Fakulteti {
    private String drejtimi;
    private Mesimdhenesi [] mesimdhenesit;
    private int index;
    private static int numriM;

    public Fakulteti(String d){
        drejtimi = d;
    }

    static {
        numriM=25;
    }

    
    {
        Fakulteti.Vizituesi viz = new Fakulteti.Vizituesi("Arlind", 2002, 10);
        mesimdhenesit = new Mesimdhenesi[numriM];
    }

    public class Tutori extends Mesimdhenesi{
        private int vitiStudimeve;

        public boolean mentoron() {
            return false;
        }

        public Tutori(String emri, int vitiLindjes, int vitiStudimeve) {
            super(emri, vitiLindjes, "Tutorime");
            this.vitiStudimeve = vitiStudimeve;
        }

        public int getVitiStudimeve() {
            return vitiStudimeve;
        }public void setVitiStudimeve(int vitiStudimeve){
            this.vitiStudimeve=vitiStudimeve;
        }

        public String toString() {
            return "Tutori i vitit " + vitiStudimeve + super.toString(); 
        }

    }

    public static class Vizituesi extends Mesimdhenesi {
        private int numriOreve;
        
        public Vizituesi(String emri, int vitiLindjes, int numriOreve) {
            super(emri, vitiLindjes, "me angazhim te ndryshem");
            this.numriOreve = numriOreve;
        }
        
        public boolean mentoron() {
            return true;
        }

        public int getNumriOreve() {
            return numriOreve;
        }public void setNumriOreve(int numriOreve) {
            this.numriOreve=numriOreve;
        }

    }

    public void shtoMesimdhenesi(Mesimdhenesi m) {
        if(m == null) {
            System.out.println("Ky mesimdhenes eshte NULL.");
            return;
        }
        if(index == mesimdhenesit.length) {
            System.out.println("Ky mesimdhenes nuk mund te shtohet vargu eshte mbushur");
            return;
        }

        for (int i = 0; i < index; i++) {
            if(mesimdhenesit[i].equals(m)) {
                System.out.println("Mesimdhenesi egziston ne varg.");
                return;
            }
        }
    }

    public Mesimdhenesi avgVitiLindjes() {
        int count=0;
        double sum=0;

        for (int i = 0; i < index; i++) {
            sum=sum + mesimdhenesit[i].getVitiLindjes();
            count++;
        }

        double mes=(double)sum/count;
        Mesimdhenesi m = null;
        for (int i = 0; i < index; i++) {
            if(m == null || mesimdhenesit[i].getVitiLindjes() <= mes && mesimdhenesit[i].getVitiLindjes() <= m.getVitiLindjes()) {
                m = mesimdhenesit[i];
            }
        }

        return m;
    }

    public static void main(String[] args) {
        Fakulteti f = new Fakulteti("kkk");
    }

}
