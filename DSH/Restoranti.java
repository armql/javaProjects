package DSH;

public class Restoranti extends Hapesira implements Monitorohet{
    private int kapaciteti;

    public Restoranti(int nr, String pershkrimi, double cmimi, int kapaciteti) throws RezervimiException {
        super(nr, pershkrimi, cmimi);
        this.kapaciteti = kapaciteti;
    }

    public int getKapaciteti() {
        return kapaciteti;
    }public void setKapaciteti(int kapaciteti) {
        this.kapaciteti = kapaciteti;
    }

    @Override
    public boolean kaWifi() {
        return true;
    }

    @Override
    public String getMonitorimi() {
        return "Sigurim fizik";
    }

    @Override
    public String toString() {
        return "Restoranti " + super.toString() + " me Kapacitet " + kapaciteti;
    }

}
