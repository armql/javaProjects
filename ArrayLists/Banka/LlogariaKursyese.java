package ArrayLists.Banka;

public class LlogariaKursyese extends LlogariaBankare implements Transferohet {
    private double interesi = 0.03;

    public LlogariaKursyese(int nrLlogarise, double bilanci, String klienti, double interesi) throws LlogariaException {
        super(nrLlogarise, bilanci, klienti);
        this.interesi = interesi;
    }

    public double getInteresi() {
        return interesi;
    }public void setInteresi(double interesi) {
        this.interesi = interesi;
    }

    @Override
    public String llojiTransferit() {
        return " Ka transferta kombetare ";
    }

    @Override
    public String toString() {
        return "Llogaria Kursyese " + super.toString() + " - me norme interesi: " + interesi;
    }
}
