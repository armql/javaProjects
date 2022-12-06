package innerClasses.innerClasesv2;

public abstract class Automjeti {

    private String nrShasise;
    private String prodhuesi;
    private int vitiProdhimit;

    public abstract boolean eshteAutomatik();

    public Automjeti(String nrShasise, String prodhuesi, int vitiProdhimit) {
        this.nrShasise=nrShasise;
        this.prodhuesi=prodhuesi;
        this.vitiProdhimit=vitiProdhimit;
    }

    public String getNrShasise() {
        return nrShasise;
    }

    public String getProdhuesi() {
        return prodhuesi;
    }public void setProdhuesi(String prodhuesi) {
        this.prodhuesi = prodhuesi;
    }

    public int getVitiProdhimit() {
        return vitiProdhimit;
    }public void setVitiProdhimit(int vitiProdhimit) {
        this.vitiProdhimit = vitiProdhimit;
    }

    public boolean equals(Object o) {
        if (o instanceof Automjeti) {
            Automjeti a = (Automjeti)o;
            return a.getNrShasise().equals(nrShasise);
        }else {
            return false;
        }
    }

    public String toString() {
        return nrShasise + " : " + prodhuesi + " - " + vitiProdhimit;
    }

}
