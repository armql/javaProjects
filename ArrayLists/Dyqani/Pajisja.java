package ArrayLists.Dyqani;

public abstract class Pajisja {
    private String numriSerik;
    private String prodhuesi;

    public Pajisja(String numriSerik, String prodhuesi) throws PajisjaException{
        if (numriSerik == null || numriSerik.trim().isEmpty()) {
            throw new PajisjaException("Numri Serik eshte null ose i zbrazet.");
        }
        this.numriSerik=numriSerik;
        if (prodhuesi == null || prodhuesi.trim().isEmpty()) {
            throw new PajisjaException("Prodhuesi eshte null ose i zbrazet.");
        }
        this.prodhuesi=prodhuesi;
    }

    public String getNumriSerik() {
        return numriSerik;
    }public void setNumriSerik(String numriSerik) throws PajisjaException{
        if (numriSerik == null || numriSerik.trim().isEmpty()) {
            throw new PajisjaException("Numri Serik eshte null ose i zbrazet.");
        }
        this.numriSerik = numriSerik;
    }

    public String getProdhuesi() {
        return prodhuesi;
    }public void setProdhuesi(String prodhuesi) throws PajisjaException{
        if (prodhuesi == null || prodhuesi.trim().isEmpty()) {
            throw new PajisjaException("Prodhuesi eshte null ose i zbrazet.");
        }
        this.prodhuesi = prodhuesi;
    }
    
    public String toString() {
        return numriSerik + " : " + prodhuesi;
    }

    public boolean equals(Object o) {
        if (o instanceof Pajisja) {
            Pajisja p = (Pajisja)o;
            return p.getNumriSerik().equals(numriSerik);
        }else {
            return false;
        }
    }
    
}
