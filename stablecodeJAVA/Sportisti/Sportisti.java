package Sportisti;

public abstract class Sportisti {
    private int id;
    private String emri;
    private int mosha;
    private char gjinia;
    
    public abstract boolean garonIndividualisht();

    public Sportisti(int id, String emri, int mosha, char gjinia) throws SportistiException {
        
        if(emri == null || emri.equals("")) {
            throw new SportistiException("Emri nuk eshte inicializuar ose eshte i zbrazet");
        }
        if(mosha < 2004) {
            throw new SportistiException("Mosha duhet te jete 18+");
        }

        this.id=id;
        this.emri=emri;
        this.mosha=mosha;
        this.gjinia=gjinia;
    }

    public int getId() {
        return id;
    }

    public String getEmri() {
        return emri;
    }public void setEmri(String emri) throws SportistiException{
        if(emri == null || emri.equals("")) {
          throw new SportistiException("Emri nuk eshte inicializuar ose eshte i zbrazet");
        }
        this.emri=emri;
    }
    
    public int getMosha() {
        return mosha;
    }public void setMosha(int mosha) throws SportistiException {
        if(mosha < 2004) {
            throw new SportistiException("Mosha duhet te jete 18+");
        }
        this.mosha=mosha;
    }

    public char getGjinia() {
        return gjinia;
    }public void setGjinia(char gjinia) {
        this.gjinia=gjinia;
    }

    public String toString() {
        char gj;
        gj=gjinia;
        if(gj == 'f' || gj == 'F') {
            System.out.println(" Femer ");
        }else if(gj == 'm' || gj == 'M') {
            System.out.println(" Mashkull ");
        }else {
            System.out.println("Nuk gjindet ne sistem");
        }
        return id + " : " + emri + gj + mosha + " vjec";
    }

    public boolean equals(Object o) {
        if(o instanceof Sportisti) {
            Sportisti s = (Sportisti)o;
            return s.getId() == id;
        }
        return false;
    }
}
