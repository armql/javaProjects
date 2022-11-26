package Libri;

public abstract class Libri {
    private String isbn;//readonly
    private String titulli;
    private int vitiPublikimit;
    
    public Libri(String isbn, String titulli, int vitiPublikimit) {
        this.isbn = isbn;
        this.titulli = titulli;
        this.vitiPublikimit = vitiPublikimit;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitulli() {
        return titulli;
    }public void setTitulli(String titulli) {
        this.titulli=titulli;
    }

    public int getVitiPublikimit() {
        return vitiPublikimit;
    }public void setVitiPublikimit(int vitiPublikimit) {
        this.vitiPublikimit=vitiPublikimit;
    }

    public abstract boolean kaDetyra();

    public String toString() {
        return isbn + " : " + titulli + " - " + vitiPublikimit;
    }

    public boolean equals(Object o) {
        Libri l =(Libri)o;
        if (o instanceof Libri) {
            return l.getIsbn().equals(isbn);
        }
        else {
            return false;
        }
    }


    
}
