package ArrayLists.reTestEO;

public class Futbollisti extends Sportisti implements Rekuizita{
    private int numri;

    public Futbollisti(int id, String emri, int vitiLindjes, char gjinia, int numri) throws SportistiException {
        super(id, emri, vitiLindjes, gjinia);
        if (numri < 0) {
            throw new SportistiException("Numri nuk duhet te jete negativ.");
        }
        this.numri = numri;
    }

    public int getNumri() {
        return numri;
    }public void setNumri() throws SportistiException{
        this.numri=numri;
    }

    @Override
    public String toString() {
        return "Futbollisti " + super.toString() + "nr:" + numri;
    }

    @Override
    public boolean garonIndividualisht() {
        return false;
    }

    @Override
    public String getRekuizita() {
        return " top ";
    }
}
