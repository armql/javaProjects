package innerclassesushtrime;

public class Enciklopedia extends Libri {
    private int nrAutoreve;

    public Enciklopedia(String isbn, String titulli, int vitiPublikimit, int nrAutoreve) {
        super(isbn, titulli, vitiPublikimit);
        this.nrAutoreve = nrAutoreve;
    }

    
    public boolean kaDetyra() {
        return false;
    }

    public int getNrAutoreve() {
        return nrAutoreve;
    }public void setNrAutoreve(int nrAutoreve) {
        this.nrAutoreve = nrAutoreve;
    }

    public String toString() {
        return "Enciklopedia " + super.toString() + " ka " + nrAutoreve;
    }
    
}
