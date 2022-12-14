package Sportisti;

public abstract class Atleti extends Sportisti {
    private int nrMedaljeve;

    public Atleti(int id, String emri, int mosha, char gjinia, int nrMedaljeve) throws SportistiException{
        super(id, emri, mosha, gjinia);
        this.nrMedaljeve=nrMedaljeve;
    }

    public int getNrMedaljeve() {
        return nrMedaljeve;
    }public void setNrMedaljeve() {
        this.nrMedaljeve=nrMedaljeve;
    }

    public String toString() {
        return super.toString() + " me " + nrMedaljeve + " medalje "; 
    }
    
}
