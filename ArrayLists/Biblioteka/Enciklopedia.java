package ArrayLists.Biblioteka;

public class Enciklopedia extends Libri implements Botohet{
    private int nrAutoreve;

    public Enciklopedia(int isbn, String titulli, int vitiPublikimit, int nrAutoreve) throws LibriException {
        super(isbn, titulli, vitiPublikimit);
        if(nrAutoreve < 0) {
            throw new LibriException("Nr i Autoreve eshte gabim.");
        }
        this.nrAutoreve = nrAutoreve;
    }
    
    public int getNrAutoreve() {
        return nrAutoreve;
    }public void setNrAutoreve(int nrAutoreve) throws LibriException{
        if(nrAutoreve < 0) {
            throw new LibriException("Nr i Autoreve eshte gabim.");
        }
        this.nrAutoreve = nrAutoreve;
    }

    @Override
    public boolean kaDetyra() {
        return true;
    }

    @Override
    public boolean kaKopertina() {
        return true;
    }

    @Override
    public String toString() {
        return "Enciklopedia " + super.toString() + " ka " + nrAutoreve + " autore.";
    }

}
