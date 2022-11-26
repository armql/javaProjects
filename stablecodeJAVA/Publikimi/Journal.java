package Publikimi;

public class Journal extends Publikimi {
    private int nrVolumit;
    
    public Journal(String isbn,String titulli,int vitiPublikimit,int nrVolumit) {
        super(isbn, titulli, vitiPublikimit);
        this.nrVolumit=nrVolumit;
    }
    
    public int getNrVolumit() {
        return nrVolumit;
    }public void setNrVolumit(int nrVolumit) {
        this.nrVolumit=nrVolumit;
    }

    public boolean eshteDigjitale(){
        return true;
    }

    @Override
    public String toString() {
        return "Journal " + super.toString() + " : " + nrVolumit;
    }

}
