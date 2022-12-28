package ArrayLists.EkipiOlimpik;

public abstract class Atleti extends Sportisti {
    private int nrMedaljeve;

    public Atleti(String id, String emri, int mosha, char gjinia, int nrMedaljeve) throws MesimdhenesiException {
        super(id, emri, mosha, gjinia);
        if (nrMedaljeve < 0) {
            throw new MesimdhenesiException("Duhet të jetë numër pozitiv.");
        }
        this.nrMedaljeve = nrMedaljeve;
    }

    public int getNrMedaljeve() {
        return nrMedaljeve;
    }
    public void setNrMedaljeve(int nrMedaljeve) throws MesimdhenesiException {
        if (nrMedaljeve < 0) {
            throw new MesimdhenesiException("Duhet të jetë numër pozitiv.");
        }
        this.nrMedaljeve = nrMedaljeve;
    }


    

}
