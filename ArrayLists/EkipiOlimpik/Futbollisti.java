package ArrayLists.EkipiOlimpik;

public class Futbollisti extends Sportisti implements Rekuizita{
    private int numri;

    public Futbollisti(String id, String emri, int mosha, char gjinia, int numri) throws MesimdhenesiException {
        super(id, emri, mosha, gjinia);
        if(numri < 0) {
            throw new MesimdhenesiException(" Nuk gjindet ne Sistem. ");
        }
        this.numri = numri;
    }

    public int getNumri() {
        return numri;
    }public void setNumri(int numri) throws MesimdhenesiException{
        if(numri < 0) {

        }
        this.numri=numri;
    }

    @Override
    public String getRekuizita() {
        return "top";
    }

    public boolean garonIndividualisht() {
        return false;
    }

    @Override
    public String toString() {
        return "Futbollisti " + super.toString() + " - nr:" + numri; 
    }


}
