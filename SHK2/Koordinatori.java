package SHK2;

public class Koordinatori extends Punetori {
    private int nrShofereve;

    public Koordinatori(String emri, int mosha, int nrShofereve) throws PunetoriException {
        super(emri, mosha);
        if (nrShofereve < 0) {
            throw new PunetoriException("Duhet te kemi nje vlere jo negative");
        }
        this.nrShofereve=nrShofereve;
    }

    @Override
    public boolean angazhimiFullTime() {
        return false;
    }

    public int getNrShofereve() {
        return nrShofereve;
    }

    @Override
    public String toString() {
        return super.toString() + " dhe numri i shofereve: " + nrShofereve;
    }
}
