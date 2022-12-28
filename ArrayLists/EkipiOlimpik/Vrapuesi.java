package ArrayLists.EkipiOlimpik;

public class Vrapuesi extends Atleti implements Rekuizita{
    private int distanca;
    
    public Vrapuesi(String id, String emri, int mosha, char gjinia, int nrMedaljeve, int distanca)
        throws SportistiException {
        super(id, emri, mosha, gjinia, nrMedaljeve);
        if(distanca < 0) {
            throw new SportistiException("Distanca duhet të jetë numër pozitiv.");
        }
        this.distanca = distanca;
    }

    public int getDistanca() {
        return distanca;
    }public void setDistanca(int distanca) throws SportistiException{
        if(distanca < 0) {
            throw new SportistiException("Distanca duhet të jetë numër pozitiv.");
        }
        this.distanca = distanca;
    }

    @Override
    public boolean garonIndividualisht() {
        return true;
    }

    @Override
    public String getRekuizita() {
        return null;
    }

    @Override
    public String toString() {
        return "Vrapuesi i distances " + distanca + "m - " + super.toString();
    }

}
