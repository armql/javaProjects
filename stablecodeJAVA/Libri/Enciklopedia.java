package Libri;

public class Enciklopedia extends Libri{

    private int nrAutoreve;

    
    
    public Enciklopedia(String isbn, String titulli, int vitiPublikimit, int nrAutoreve) {
        super(isbn, titulli, vitiPublikimit);
        this.nrAutoreve = nrAutoreve;
    }
    
    public int getNrAutoreve() {
        return nrAutoreve;
    }public void setNrAutoreve(int nrAutoreve) {
        this.nrAutoreve = nrAutoreve;
    }

    @Override
    public boolean kaDetyra() {
        return false;
    }

    @Override
    public String toString() {
        return "Enciklopedia " + getIsbn() + " : " + getTitulli() + " - " 
        + getVitiPublikimit() + " ka " + getNrAutoreve() + " autore"; 
    }

}
