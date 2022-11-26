package Libri;

public class LibriShkollor extends Libri {
    private String drejtimi;

    
    public String getDrejtimi() {
        return drejtimi;
    }public void setDrejtimi(String drejtimi) {
        this.drejtimi = drejtimi;
    }

    public LibriShkollor(String isbn, String titulli, int vitiPublikimit, String drejtimi) {
        super(isbn, titulli, vitiPublikimit);
        this.drejtimi = drejtimi;
    }

    @Override
    public boolean kaDetyra() {
     return true;   
    }

    @Override
    public String toString() {
        return "Libri Shkollor " + getIsbn() + " : " + getTitulli() + " - "
        + getVitiPublikimit() + " : " + getDrejtimi();
    }



}
