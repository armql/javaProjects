package innerclassesushtrime;

public abstract class Pajisja {
    private String nrSerik;
    private String prodhuesi;

    public Pajisja(String nrSerik, String prodhuesi) {
        this.nrSerik=nrSerik;
        this.prodhuesi=prodhuesi;
    }

    public String getNrSerik() {
        return nrSerik;
    }

    public String getProdhuesi() {
        return prodhuesi;
    }public void setProdhuesi(String prodhuesi) {
        this.prodhuesi=prodhuesi;
    }

    public boolean equals(Object o) {
        if (o instanceof Pajisja) {
            Pajisja p = (Pajisja)o;
            return p.getNrSerik().equals(nrSerik);
        }else {
            return false;
        }
    }

    public String toString() {
        return nrSerik + " : " + prodhuesi;
    }
    
}
