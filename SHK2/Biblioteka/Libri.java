package SHK2.Biblioteka;

public abstract class Libri {
    private String isbn;
    private String titulli;
    private int vitiPublikimit;
    public abstract boolean kaDetyra();

    public Libri(String isbn, String titulli, int vitiPublikimit) throws LibriException {
        if (isbn == null || isbn.trim().isEmpty()) {
            throw new LibriException("Isbn nuk eshte inicializuar ose eshte i zbrazet.");
        }
        if (titulli == null || titulli.trim().isEmpty()) {
            throw new LibriException("Titulli nuk eshte inicializuar ose eshte i zbrazet.");
        }
        if (vitiPublikimit < 0) {
            throw new LibriException("Numri eshte i zbrazet.");
        }
        this.isbn=isbn;
        this.titulli=titulli;
        this.vitiPublikimit=vitiPublikimit;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitulli() {
        return titulli;
    }public void setTitulli(String titulli) throws LibriException {
        if (titulli == null || titulli.trim().isEmpty()) {
            throw new LibriException("Titulli nuk eshte inicializuar ose eshte i zbrazet.");
        }
        this.titulli=titulli;
    }

    public int getVitiPublikimit() {
        return vitiPublikimit;
    }public void setVitiPublikimit(int vitiPublikimit) throws LibriException {
        if (vitiPublikimit < 0) {
            throw new LibriException("Numri eshte i zbrazet.");
        }
        this.vitiPublikimit=vitiPublikimit;
    }

    public boolean equals(Libri l) {
        if (l.getIsbn().equals(isbn)) {
            return true;
        }
        return false;
    }

    public String toString() {
        return isbn + " : " + titulli + " - " + vitiPublikimit;
    }
}
