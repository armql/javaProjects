package Publikimi;

public abstract class Libri extends Publikimi {
    private int nrFaqeve;

    public Libri(String isbn, String titulli, int vitiPublikimit,int nrFaqeve) {
        super(isbn, titulli, vitiPublikimit);
        this.nrFaqeve=nrFaqeve;
    }

    public int getNrFaqeve() {
        return nrFaqeve;
    }public void setNrFaqeve(int nrFaqeve) {
        this.nrFaqeve=nrFaqeve;
    }

    public boolean eshteDigjitale() {
        return false;
    }

    public abstract boolean kaDetyra();

    @Override
    public String toString() {
        return super.toString() + " me " + nrFaqeve + " faqe ";
    }

    
}
