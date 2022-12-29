package ArrayLists.EkipiOlimpik;

public abstract class Sportisti {
    private String id;
    private String emri;
    private int mosha;
    private char gjinia;

    public abstract boolean garonIndividualisht();

    public Sportisti (String id, String emri, int mosha, char gjinia) throws SportistiException{
        if(id == null || id.trim().isEmpty()) {
            throw new SportistiException("ID eshte i zbrazet ose null");
        }
        this.id=id;
        
        if(emri == null || emri.trim().isEmpty()) {
            throw new SportistiException("Emri eshte i zbrazet ose null");
        }
        this.emri=emri;
        
        if(mosha > 2004) {
            throw new SportistiException("Mosha duhet te jetë 18+");
        }
        this.mosha=mosha;
        
        this.gjinia=gjinia;
        
    }

    public String getID() {
        return id;
    }

    public String getEmri() {
        return emri;
    }public void setEmri(String emri) throws SportistiException{
        if(emri == null || emri.trim().isEmpty()) {
            throw new SportistiException("ID eshte i zbrazet ose null");
        }
        this.emri=emri;
    }

    public int getMosha() {
        return mosha;
    }public void setMosha(int mosha) throws SportistiException{
        if(mosha > 2004) {
            throw new SportistiException("Mosha duhet te jetë 18+");
        }
        this.mosha=mosha;
    }

    public char getGjinia() {
        return gjinia;
    }public void setGjinia(char gjinia) throws SportistiException {
        this.gjinia=gjinia;
    }
    
    public String toString() {
        int vjec = 2022 - mosha;
        return id + " : " + emri +
        (gjinia == 'F' ? ", Femër, " : gjinia == 'M' ? ", Mashkull " : ", Gjinia nuk është e definuar, ")
        + vjec + " vjec.";
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
