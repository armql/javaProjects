package innerclassesushtrime;

public class Biblioteka {
    private String emri;
    private Libri [] librat;
    private int index;
    private static int numriL;
    private boolean kaRegjistra = false;

    static{
        numriL = 150;
    }

    {
        librat = new Libri[numriL];

        Biblioteka.Fjalori f= new Biblioteka.Fjalori("11111","Shqip",2005,570);
        shtoLibrin(f);
    }

    public Biblioteka (String emri) {
        this.emri=emri;
    }

    public class Romani extends Libri {
        private String zhanri;

        public Romani(String isbn, String titulli, int vitiPublikimit, String zhanri) {
            super(isbn, titulli, vitiPublikimit)
            this.zhanri=zhanri;
        }

        
        public String getZhanri() {
            return zhanri;
        }public void setZhanri(String zhanri) {
            this.zhanri = zhanri;
        }

        public String toString() {
            return "Romani i zhanrit " + zhanri + " : " + super.toString();
        }


        @Override
        public boolean kaDetyra() {
            return false;
        }

    }

    public static class Fjalori extends Libri {
        private int nrFjalesh;

        public Fjalori(String isbn, String titulli, int vitiPublikimit, int nrFjalesh) {
            super(isbn,titulli,vitiPublikimit);
            this.nrFjalesh=nrFjalesh;
        }

        public int getNrFjalesh(){
            return nrFjalesh;
        }public void setNrFjalesh(int nrFjalesh) {
            this.nrFjalesh=nrFjalesh;
        }

        public boolean kaDetyra() {
            return false;
        }

        public String toString() {
            return "Fjalori " + super.toString() + " me " + nrFjalesh + " fjale";
        }

    }

    public boolean egziston(Libri l) {
        for (int i = 0; i < index; i++) {
            if (librat[i].equals(l)) {
                return true;
            }
        }
        return false;
    }

    public void shtoLibrin(Libri l) {
        if(l == null) {
            System.out.println("Libri qe kerkohet te shtohet eshte NULL");
            return;
        }
        if (index == librat.length) {
            System.out.println("Libri nuk mund te shtohet sepse Biblioteka eshte mbushur.");
            return;
        }
        if (egziston(l)) {
            System.out.println("Libri nuk mund te shtohet sepse egziston.");
            return;
        }
        librat[index++] = l;
    }

    public void shtoNjeLiber(String isbn,String titulli,boolean kaDetyra) {
        
        Libri l = new Libri(isbn, titulli,2022) {
            public boolean kaDetyra() {
                return kaDetyra;
            }
        };
        shtoLibrin(l);
    }

    public void shtoRegjistrin(String isbn, String titulli) {
        class Regjistri extends Libri {
                public Regjistri() {
                    super(isbn,titulli,2022);
                }

                @Override
                public boolean kaDetyra(){
                    return false;
                }

                public String toString() {
                    return "Regjistri " + super.toString();
                }
            
            }
            
            Regjistri regj = new Regjistri();
            if(kaRegjistra) {
                System.out.println("Ekziston Regjistri per: " + emri);
            }else {
                shtoLibrin(regj);
                kaRegjistra = true;
            }
            
        }
    
    }

    public Libri avgNumriFjaleve() {
        int count=0;
        double sum=0;

        for (int i = 0; i < index; i++) {
            if (librat[i] instanceof Fjalori) {
                Fjalori f = (Fjalori)librat[i];
                sum=sum + f.getNrFjalesh();
                count++;    
            }

        }

        double mes=(double)sum/count;
        Libri l = null;
        for (int i = 0; i < index; i++) {
            if(librat[i] instanceof Fjalori) {
                Fjalori f = (Fjalori)librat[i];
                if(l == null || f.getNrFjalesh() <= mes && f.getNrFjalesh() <= f.getNrFjalesh()) {
                    l = f;
                }
            }
        }

        return l;
    }

    public void shtypDetyra(boolean kaDetyra) {

        for (int i = 0; i < index; i++) {
            if (librat[i].kaDetyra() == kaDetyra) {
                System.out.println(librat[i]);
            }
        }

    }


    public static void main(String[] args) {
        Biblioteka
    }

}
