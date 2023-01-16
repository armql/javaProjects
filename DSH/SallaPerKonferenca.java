package DSH;

public class SallaPerKonferenca extends Hapesira implements Monitorohet{
    private int kapaciteti;

    public SallaPerKonferenca(int nr, String pershkrimi, double cmimi, int kapaciteti) throws RezervimiException {
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
        return "Kamerat";
    }

    @Override
    public String toString() {
        return "SallaPerKonferenca " + super.toString() + " me Kapacitet " + kapaciteti;
    }

}
