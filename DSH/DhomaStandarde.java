package DSH;

public class DhomaStandarde extends Hapesira implements Monitorohet{
    private boolean kaTV;

    public DhomaStandarde(int nr, String pershkrimi, double cmimi, boolean kaTV) throws RezervimiException {
        super(nr, pershkrimi, cmimi);
        this.kaTV = kaTV;
    }

    public boolean getkaTV() {
        return kaTV;
    }public void setKaTV(boolean kaTV) {
        this.kaTV = kaTV;
    }

    @Override
    public boolean kaWifi() {
        return false;
    }

    @Override
    public String getMonitorimi() {
        return "Kamerat";
    }

    @Override
    public String toString() {
        return "Dhoma Standarde " + super.toString() + (kaTV? " ka TV." : " nuk ka TV.");
    }

}
