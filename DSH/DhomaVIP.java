package DSH;

public class DhomaVIP extends Hapesira implements Monitorohet{
    private boolean kaGjakuzi;

    public DhomaVIP(int nr, String pershkrimi, double cmimi, boolean kaGjakuzi) throws RezervimiException {
        super(nr, pershkrimi, cmimi);
        this.kaGjakuzi = kaGjakuzi;
    }

    public boolean getKaGjakuzi() {
        return kaGjakuzi;
    }public void setKaGjakuzi(boolean kaGjakuzi) {
        this.kaGjakuzi = kaGjakuzi;
    }

    @Override
    public boolean kaWifi() {
        return true;
    }

    @Override
    public String getMonitorimi() {
        return "Sigurim Fizik";
    }

    @Override
    public String toString() {
        return "Dhoma VIP " + super.toString() + (kaGjakuzi? " ka Gjakuzi." : " nuk ka Gjakuzi.");
    }

}
