package SHK2.Biblioteka;

public class Enciklopedia extends Libri implements Botohet {
    private int nrAutoreve;

    public Enciklopedia(String isbn, String titulli, int vitiPublikimit, int nrAutoreve) throws LibriException {
        super(isbn, titulli, vitiPublikimit);
        if (nrAutoreve < 0) {
            throw new LibriException("Nr i autoreve duhet te jete numer jo negativ.");
        }
        this.nrAutoreve=nrAutoreve;
    }

    public int getNrAutoreve() {
        return nrAutoreve;
    }public void setNrAutoreve(int nrAutoreve) throws LibriException {
        if (nrAutoreve < 0) {
            throw new LibriException("Nr i autoreve duhet te jete numer jo negativ.");
        }
        this.nrAutoreve=nrAutoreve;
    }

    public boolean kaKopertina() {
        return true;
    }

    public boolean kaDetyra() {
        return false;
    }

    @Override
    public String toString() {
        return "Enciklopedia " + super.toString() + " ka " + nrAutoreve + " autore.";
    }
}
