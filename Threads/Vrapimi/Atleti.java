package Threads.Vrapimi;

public abstract class Atleti extends Thread{
    private int nrRendor;
    private String emri;
    private char gjinia;
    private int mosha;
    public int distanca = 0;
    public int gjatesiaEPistes;

    public abstract void garo();

    public Atleti (int nrRendor, String emri, char gjinia,int mosha, int distanca, int gjatesiaEPistes) throws AtletiException{
        if (nrRendor < 0) {
            throw new AtletiException("Numri eshte gabim");
        }
        this.nrRendor=nrRendor;
        if (emri == null || emri.trim().isEmpty()) {
            throw new AtletiException("Emri eshte i zbrazet ose null");
        }
        this.emri=emri;
        if (mosha < 0) {
            throw new AtletiException("Mosha eshte gabim");
        }
        this.gjinia=gjinia;
        if (distanca < 0) {
            throw new AtletiException("Distanca eshte null");
        }
        this.distanca=distanca;
        if (gjatesiaEPistes < 0) {
            throw new AtletiException("Pista eshte gabim");
        }
        this.gjatesiaEPistes=gjatesiaEPistes;
    }

    public int getNrRendor() {
        return nrRendor;
    }

    public String getEmri() {
        return emri;
    }public void setEmri(String emri)  throws AtletiException{
        if (emri == null || emri.trim().isEmpty()) {
            throw new AtletiException("Emri eshte i zbrazet ose null");
        }
        this.emri=emri;
    }

    public char getGjinia() {
        return gjinia;
    }public void setGjinia(char gjinia) {
        this.gjinia = gjinia;
    }

    public int getDistanca() {
        return distanca;
    }public void setDistanca(int distanca) throws AtletiException{
        if (distanca < 0) {
            throw new AtletiException("Distanca eshte null");
        }
        this.distanca=distanca;
    }

    public int getGjatesiaEPistes() {
        return gjatesiaEPistes;
    }public void setGjatesiaEPistes(int gjatesiaEPistes) throws AtletiException{
        if (gjatesiaEPistes < 0) {
            throw new AtletiException("Pista eshte gabim");
        }
        this.gjatesiaEPistes=gjatesiaEPistes;
    }

    public String toString() {
        return nrRendor + " : " + emri 
        + ((gjinia == 'M') ? " Mashkull " : (gjinia == 'F') ? " Femer " : " Nuk gjindet ne sistem ")
        + mosha + " vjec";
    }
    
    public boolean equals(Object o){
        if (o instanceof Atleti) {
            Atleti a = (Atleti)o;
            return a.getNrRendor() == nrRendor;
        }else {
            return false;
        }
    }
}
