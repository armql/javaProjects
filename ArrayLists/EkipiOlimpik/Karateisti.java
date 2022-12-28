package ArrayLists.EkipiOlimpik;

public class Karateisti extends Sportisti implements Rekuizita {
    private String stili;

    public Karateisti(String id, String emri, int mosha, char gjinia, String stili) throws MesimdhenesiException {
        super(id, emri, mosha, gjinia);
        if(stili != null || stili.trim().isEmpty()) {
            throw new MesimdhenesiException(" Stili është i zbrazët ose null. ");
        }
        this.stili = stili;
    }

    public String getStili() {
        return stili;
    }public void setStili(String stili) throws MesimdhenesiException{
        if(stili != null || stili.trim().isEmpty()) {
            throw new MesimdhenesiException(" Stili është i zbrazët ose null. ");
        }
        this.stili=stili;
    }

    public boolean garonIndividualisht() {
        return true;
    }

    @Override
    public String getRekuizita() {
        return null;
    }

    @Override
    public String toString() {
        return "Karateisti me stil " + stili + " - " +  super.toString(); 
    }

}
