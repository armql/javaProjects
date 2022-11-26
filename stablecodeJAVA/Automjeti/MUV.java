package Automjeti;

public class MUV extends UtilityVehicle {
    private boolean kaGPS;

    
    public MUV(String nrShasise, String prodhuesi, int vitiProdhimit, boolean kaGPS) {
        super(nrShasise, prodhuesi, vitiProdhimit);
        this.kaGPS = kaGPS;
    }
    
    public boolean isKaGPS() {
        return kaGPS;
    }public void setKaGPS(boolean kaGPS) {
        this.kaGPS = kaGPS;
    }

    @Override
    public boolean eshte4x4() {
        return false;
    }

    @Override
    public boolean eshteAutomatik() {
        return true;
    }

    @Override
    public String toString() {
        return "Multi Utility Vehicle-MUV " + super.toString() + " dhe" +  (kaGPS? " Ka GPS " : " Nuk ka GPS ");
    }
    
    
    
}
