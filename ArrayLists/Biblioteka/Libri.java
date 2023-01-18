package ArrayLists.Biblioteka;

public abstract class Libri {
    private int isbn;
    private String titulli;
    private int vitiPublikimit;

    public abstract boolean kaDetyra();

    public Libri(int isbn, String titulli, int vitiPublikimit) throws LibriException{
        if(isbn < 0) {
            throw new LibriException("Libri eshte numer negativ.");
        }
        this.isbn=isbn;
        if(titulli == null || titulli.trim().isEmpty()) {
            throw new LibriException("Titulli eshte i zbrazet ose nuk eshte inicializuar.");
        }
        this.titulli=titulli;
        if(vitiPublikimit < 0) {
            throw new LibriException("Libri eshte numer negativ.");
        }
        this.vitiPublikimit=vitiPublikimit;
    }

    
    public int getIsbn() {
        return isbn;
    }
    
    public String getTitulli() {
        return titulli;
    }public void setTitulli(String titulli) throws LibriException{
        if(titulli == null || titulli.trim().isEmpty()){
            throw new LibriException("Libri nuk eshte inicializuar ose eshte i zbrazet.");
        }
        this.titulli = titulli;
    }
    
    public int getVitiPublikimit() {
        return vitiPublikimit;
    }public void setVitiPublikimit(int vitiPublikimit) throws LibriException{
        if(vitiPublikimit < 0){
            throw new LibriException("Libri eshte numer negativ.");
        }
        this.vitiPublikimit = vitiPublikimit;
    }

    public String toString() {
        return isbn + " : " + titulli + " - " + vitiPublikimit;
    }

}
