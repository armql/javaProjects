package ArrayLists.reTestEO;

public abstract class Sportisti {
    private int id;
    private String emri;
    private int vitiLindjes;
    private char gjinia;

    public abstract boolean garonIndividualisht();

    public Sportisti(int id, String emri, int vitiLindjes, char gjinia) throws SportistiException{
        if(id < 0) {
            throw new SportistiException("Nuk pranohet numri negativ");
        }
        this.id=id;
        if (emri == null || emri.trim().isEmpty()) {
            throw new SportistiException("Emri eshte null ose i zbrazet");
        }
        this.emri=emri;
        if (vitiLindjes <= 2004) {
            throw new SportistiException("vitiLindjes duhet te jete 18+");
        }
        this.vitiLindjes=vitiLindjes;
        this.gjinia=gjinia;
    }

    public int getID() {
        return id;
    }

    public String getEmri() {
        return emri;
    }public void setEmri(String emri) throws SportistiException{
        if (emri == null || emri.trim().isEmpty()) {
            throw new SportistiException("Emri eshte null ose i zbrazet");
        }
        this.emri=emri;
    }

    public int getvitiLindjes() {
        return vitiLindjes;
    }public void setvitiLindjes(int vitiLindjes) throws SportistiException{
        if (vitiLindjes <= 2004) {
            throw new SportistiException("vitiLindjes duhet te jete 18+");
        }
        this.vitiLindjes=vitiLindjes;
    }

    public char getGjinia() {
        return gjinia;
    }public void setGjinia(char gjinia) {
        this.gjinia=gjinia;
    }

    public boolean equals(Object o) {
        if (o instanceof Sportisti) {
            Sportisti s = (Sportisti)o;
            return s.getID() == id;
        }else {
            return false;
        }
    }

    public String toString() {
        char gj;
        gj = gjinia;
        if (gj == 'F' || gj == 'f') {
            System.out.println(" Femer ");
        }
        if (gj == 'M' || gj == 'm') {
            System.out.println(" Femer ");
        }else {
            System.out.println(" NUK GJINDET NE SISTEM ");
        }
        int mosha = vitiLindjes - 2023;
        return id + " : " + emri + " " + mosha + " vjec. "; 
    }

}