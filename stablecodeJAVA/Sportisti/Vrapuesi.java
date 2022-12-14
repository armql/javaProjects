package Sportisti;

public class Vrapuesi extends Atleti implements Rekuizita{
    private int distanca;

    public Vrapuesi(int id, String emri, int mosha, char gjinia, int distanca) throws SportistiException{
        super(id, emri, mosha, gjinia, distanca);
        if(distanca == 0) {
            throw new SportistiException("Distanca eshte 0");
        }
        this.distanca=distanca;
    }

    public int getDistanca() {
        return distanca;
    }public void setDistanca() throws SportistiException {
        if(distanca == 0) {
            throw new SportistiException("Distanca eshte 0");
        }
        this.distanca=distanca;
    }

    @Override
    public boolean garonIndividualisht() {
        return true;
    }

    @Override
    public String getRekuizita() {
        return null;
    }

    public String toString() {
        return "Vrapuesi i Distances " + distanca + "m" + " - " + super.toString();
    }

}
