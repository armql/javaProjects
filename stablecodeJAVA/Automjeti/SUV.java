package Automjeti;

public class SUV extends UtilityVehicle {
    private boolean eshteAllTerrain;

    public SUV(String nrShasise, String prodhuesi, int vitiProdhimit,boolean eshteAllTerrain) {
        super(nrShasise, prodhuesi, vitiProdhimit);
        this.eshteAllTerrain=eshteAllTerrain;
    }

    public boolean getEshteAllTerrain() {
        return eshteAllTerrain;
    }public void setEshteAllTerrain(boolean eshteAllTerrain) {
        this.eshteAllTerrain = eshteAllTerrain;
    }


    public boolean eshteAutomatik () {
        return false;
    }

    public boolean eshte4x4() {
        return true;
    }

    @Override
    public String toString() {
        return "Sport Utility Vehicle-SUV " + super.toString() + " dhe"+ (eshteAllTerrain? " Eshte All-Terrain " : " Nuk eshte All-Terrain ") ;
    }

    
    
}
