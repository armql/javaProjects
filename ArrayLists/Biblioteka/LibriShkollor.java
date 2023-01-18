package ArrayLists.Biblioteka;

public class LibriShkollor extends Libri implements Botohet {
    private String drejtimi;

    public LibriShkollor(int isbn, String titulli, int vitiPublikimit, String drejtimi) throws LibriException {
        super(isbn, titulli, vitiPublikimit);
        if(drejtimi == null || drejtimi.trim().isEmpty()) {
            throw new LibriException("Drejtimi nuk eshte inicializuar ose eshte i zbrazet.");
        }
        this.drejtimi = drejtimi;
    }

    public String getDrejtimi() {
        return drejtimi;
    }public void setDrejtimi(String drejtimi) throws LibriException{
        if(drejtimi == null || drejtimi.trim().isEmpty()) {
            throw new LibriException("Drejtimi nuk eshte inicializuar ose eshte i zbrazet.");
        }
        this.drejtimi = drejtimi;
    }

    @Override
    public boolean kaDetyra() {
        return true;
    }

    @Override
    public boolean eshteMeNgjyra() {
        return false;
    }

    @Override
    public boolean kaKopertina() {
        return false;
    }

    @Override
    public String toString() {
        return "Libri Shkollor " + super.toString() + " : " + drejtimi;
    }


}
