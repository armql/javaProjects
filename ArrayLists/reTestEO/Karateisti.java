package ArrayLists.reTestEO;

public class Karateisti extends Sportisti implements Rekuizita {
    private String stili;

    public Karateisti(int id, String emri, int vitiLindjes, char gjinia, String stili) throws SportistiException {
        super(id, emri, vitiLindjes, gjinia);
        if(stili == null || stili.trim().isEmpty()) {
            throw new SportistiException("Stili eshte null ose i zbrazet. ");
        }
        this.stili = stili;
    }

    public String getStili() {
        return stili;
    }public void setStili(String stili) throws SportistiException {
        if(stili == null || stili.trim().isEmpty()) {
            throw new SportistiException("Stili eshte null ose i zbrazet. ");
        }
        this.stili = stili;
    }

    @Override
    public boolean garonIndividualisht() {
        return true;
    }

    @Override
    public String toString() {
        return "Karateisti me stil " + stili + " " + super.toString();
    }


}
