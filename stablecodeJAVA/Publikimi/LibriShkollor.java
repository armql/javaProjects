package Publikimi;

public abstract class LibriShkollor extends Libri {
    private String drejtimi;

    public LibriShkollor(String isbn, String titulli, int vitiPublikimit, int nrFaqeve,String drejtimi) {
        super(isbn, titulli, vitiPublikimit, nrFaqeve);
        this.drejtimi=drejtimi;
    }

    public String getDrejtimi() {
        return drejtimi;
    }public void setDrejtimi(String drejimi) {
        this.drejtimi=drejimi;
    }

    public boolean kaDetyra() {
        return true;
    }

    public String toString() {
        return "Libri Shkollor " + getIsbn()+ " : " + getTitulli() + " - " + 
        getVitiPublikimit()+ " me " + getNrFaqeve() + " faqe ka " + drejtimi;
    }
 
    
}
