package ArrayLists.EkipiOlimpik;

public abstract class Sportisti {
    private String id;
    private String emri;
    private int mosha;
    private char gjinia;

    public abstract boolean garonIndividualisht();

    public Sportisti (String id, String emri, int mosha, char gjinia) throws SportistiException{
        if(id != null || id.trim().isEmpty()) {
            throw new SportistiException("ID eshte i zbrazet ose null");
        }
        this.id=id;
        
        if(emri != null || emri.trim().isEmpty()) {
            throw new SportistiException("ID eshte i zbrazet ose null");
        }
        this.emri=emri;
        
        if(mosha <= 2004) {
            throw new SportistiException("Mosha duhet te jetë 18+");
        }
        this.mosha=mosha;
        
        if(gjinia == 'F' || gjinia == 'M') {
            throw new SportistiException("Mosha duhet te jetë 18+");
        }
        this.gjinia=gjinia;
        
    }

    public String getID() {
        return id;
    }

    public String getEmri() {
        return emri;
    }public void setEmri(String emri) throws SportistiException{
        if(emri != null || emri.trim().isEmpty()) {
            throw new SportistiException("ID eshte i zbrazet ose null");
        }
        this.emri=emri;
    }

    public int getMosha() {
        return mosha;
    }public void setMosha(int mosha) throws SportistiException{
        if(mosha <= 2004) {
            throw new SportistiException("Mosha duhet te jetë 18+");
        }
        this.mosha=mosha;
    }

    public char getGjinia() {
        return gjinia;
    }public void setGjinia(char gjinia) throws SportistiException {
        if(gjinia == 'F' || gjinia == 'M') {
            throw new SportistiException("Mosha duhet te jetë 18+");
        }
        this.gjinia=gjinia;
    }
    
    public String toString() {
        char gj;
        gj = gjinia;
        if (gj == 'f' || gj == 'F') {
            System.out.println(" Femër, ");
        }
        else if (gj == 'm' || gj == 'M') {
            System.out.println(" Mashkull, ");
        }else {
            System.out.println(" Nuk gjendet në sistem. ");
        }
        return id + " : " + emri + gj + mosha + " vjec.";
    }

    public boolean equals(Object o) {
        if (o instanceof Sportisti) {
            Sportisti s = (Sportisti)o;
            return s.getID().equals(id);
        }else {
            return false;
        }
    }
}
