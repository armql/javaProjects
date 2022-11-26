package Automjeti;

public abstract class UtilityVehicle extends Automjeti {
    
    public UtilityVehicle(String nrShasise, String prodhuesi, int vitiProdhimit) {
        super(nrShasise, prodhuesi, vitiProdhimit);
    }

    public abstract boolean eshte4x4();

    @Override
    public String toString() {
        return "Utility Vehicle " + super.toString() + " :" + (eshte4x4()? " eshte4x4 " : " nuk eshte4x4");
    }

}
