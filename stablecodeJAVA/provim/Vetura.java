package provim;

public class Vetura {
    private String nrTargave;//readonly
    private String modeli;
    private int vitiProdhimit;

    public Vetura(String nrTargave, String modeli, int vitiProdhimit) {
        this.nrTargave=nrTargave;
        this.modeli=modeli;
        this.vitiProdhimit=vitiProdhimit;
    }

    public String getNrTargave(){
        return nrTargave;
    }

    public String getModeli() {
        return modeli;
    }public void setModeli(String modeli) {
        this.modeli=modeli;
    }

    public int getVitiProdhimit() {
        return vitiProdhimit;
    }public void setVitiProdhimit(int vitiProdhimit) {
        this.vitiProdhimit=vitiProdhimit;
    }

    public String toString() {
        return modeli + " - " +  vitiProdhimit + " : " + nrTargave;
    }

    public boolean equals(Object o) {
        if(o instanceof Vetura) {
            Vetura v =(Vetura)o;
            return v.getNrTargave().equals(nrTargave);
        }else {
            return false;
        }
    }

}
