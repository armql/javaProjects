public class Automjeti {
    
    private String nrShasise;
    private String prodhuesi;
    private int vitiProdhimit;

    public String getNrShasise() {
        return nrShasise;
    }

    public void setProdhuesi(String prodhuesi) {
        this.prodhuesi=prodhuesi;
    }public String getProdhuesi() {
        return prodhuesi;
    }

    public void setVitiProdhimit (int vitiProdhimit) {
        this.vitiProdhimit=vitiProdhimit;
    }public int getVitiProdhimit() {
        return vitiProdhimit;
    }

    public Automjeti(String nrShasise, String prodhuesi, int vitiProdhimit) {
        this.nrShasise = nrShasise;
        this.prodhuesi = prodhuesi;
        this.vitiProdhimit = vitiProdhimit;
    }

    public String toString() {
        return nrShasise + " : " + prodhuesi + " - " + vitiProdhimit;
    }

    public boolean equals(Object o) {
        if (o instanceof Automjeti) {
            Automjeti a = (Automjeti)o;
            return a.getNrShasise().equals(nrShasise);
        }else {
            return false;
        }
    }
     
    
}
