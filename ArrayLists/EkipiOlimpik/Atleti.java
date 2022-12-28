package ArrayLists.EkipiOlimpik;

public abstract class Atleti extends Sportisti {
    private int nrMedaljeve;

    public Atleti(String id, String emri, int mosha, char gjinia, int nrMedaljeve) throws SportistiException {
        super(id, emri, mosha, gjinia);
        if (nrMedaljeve < 0) {
            throw new SportistiException("Duhet të jetë numër pozitiv.");
        }
        this.nrMedaljeve = nrMedaljeve;
    }

    public int getNrMedaljeve() {
        return nrMedaljeve;
    }
    public void setNrMedaljeve(int nrMedaljeve) throws SportistiException {
        if (nrMedaljeve < 0) {
            throw new SportistiException("Duhet të jetë numër pozitiv.");
        }
        this.nrMedaljeve = nrMedaljeve;
    }

    @Override
    public String toString() {
        return super.toString() + " me " + nrMedaljeve + " medalje.";
    }

}
