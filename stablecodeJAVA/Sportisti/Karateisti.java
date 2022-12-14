package Sportisti;

public class Karateisti extends Sportisti implements Rekuizita {
    private String stili;

    public Karateisti(int id, String emri, int mosha, char gjinia, int numri) throws SportistiException{
        super(id, emri, mosha, gjinia);
       
        if (stili == null || stili.equals("")) {
            throw new SportistiException("Stili nuk eshte inicializuar ose eshte i zbrazet");
        }
        this.stili=stili;
    }

    public String getStili() {
        return stili;
    }public void setStili(String stili) throws SportistiException {
        if (stili == null || stili.equals("")) {
            throw new SportistiException("Stili nuk eshte inicializuar ose eshte i zbrazet");
        }
        this.stili=stili;
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
        return "Karateisti me stil " + stili + " - " + super.toString();
    }

}
