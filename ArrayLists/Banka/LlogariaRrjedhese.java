package ArrayLists.Banka;

public class LlogariaRrjedhese extends LlogariaBankare implements Transferohet{
    private double mbiterheqja;

    public LlogariaRrjedhese(long nrLlogarise, double bilanci, String klienti, double mbiterheqja)
            throws LlogariaException {
        super(nrLlogarise, bilanci, klienti);
        if (mbiterheqja < 0) {
            throw new LlogariaException("Mbiterheqja eshte zero ose numer negativ");
        }
        this.mbiterheqja = mbiterheqja;
    }

    public double getMbiterheqja() {
        return mbiterheqja;
    }public void setMbiterheqja(double mbiterheqja) {
        this.mbiterheqja = mbiterheqja;
    }

    @Override
    public String llojiTransferit() {
        return " Ka transferta nderkombetare ";
    }

    @Override
    public String toString() {
        return "Llogaria Rrjedhse" + super.toString() + " : " + mbiterheqja;
    }

}
