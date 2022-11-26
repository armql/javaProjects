package Publikimi;

public class Enciklopedia extends Libri {
    private int nrAutoreve;

    public Enciklopedia(String isbn, String titulli, int vitiPublikimit, int nrFaqeve, int nrAutoreve) {
        super(isbn, titulli, vitiPublikimit, nrFaqeve);
        this.nrAutoreve = nrAutoreve;
    }

    
    @Override
    public boolean kaDetyra() {
        return false;
    }


    public int getNrAutoreve() {
        return nrAutoreve;
    }public void setNrAutoreve(int nrAutoreve) {
        this.nrAutoreve=nrAutoreve;
    }

    public String toString() {
        return "Enciklopedia " + super.toString() + " faqe ka " + nrAutoreve + " autore.";
    }

}
