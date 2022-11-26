package Publikimi;

public abstract class Publikimi {
    private String isbn;
    private String titulli;
    private int vitiPublikimit;

    public abstract boolean eshteDigjitale();

    public Publikimi(String isbn,String titulli,int vitiPublikimit) {
        this.isbn=isbn;
        this.titulli=titulli;
        this.vitiPublikimit=vitiPublikimit;
    }

    public String getIsbn(){
        return isbn;
    }

    public String getTitulli(){
        return titulli;
    }public void setTitulli(String titulli) {
        this.titulli=titulli;
    }

    public int getVitiPublikimit() {
        return vitiPublikimit;
    }public void setVitiPublikimit(int vitiPublikimit) {
        this.vitiPublikimit=vitiPublikimit;
    }

    public String toString() {
        return isbn + " : " + titulli + " - " + vitiPublikimit;
    }

    public boolean equals(Object o) {
        if(o instanceof Publikimi) {
            Publikimi p=(Publikimi)o;
            return p.getIsbn().equals(isbn);
        }else{
            return false;
        }
    }
}
