package Pajisja;

public abstract class Pajisja {
    private String numriSerik;
    private String prodhuesi;
    
    public Pajisja(String numriSerik, String prodhuesi) {
        this.numriSerik = numriSerik;
        this.prodhuesi = prodhuesi;
    }

    public String getNumriSerik() {
        return numriSerik;
    }

    public String getProdhuesi() {
        return prodhuesi;
    }public void setProdhuesi(String prodhuesi) {
        this.prodhuesi = prodhuesi;
    }

    public boolean equals(Object o) {
        if(o instanceof Pajisja) {
            Pajisja p=(Pajisja)o;
            return p.getNumriSerik().equals(numriSerik);
        }else {
            return false;
        }
    }

    public String toString() {
        return numriSerik + " : " + prodhuesi;
    }
}
