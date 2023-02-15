package ArrayLists.Banka;

public abstract class LlogariaBankare {
    private long nrLlogarise; // readonly ; 16 digits
    private double bilanci;
    private String klienti;

    public LlogariaBankare (long nrLlogarise, double bilanci, String klienti) throws LlogariaException {
        if(nrLlogarise <= 99) {
            throw new LlogariaException("Numri i Llogaris duhet te jete 16 shifra!");
        }
        this.nrLlogarise=nrLlogarise;
        if (bilanci < 0) {
            throw new LlogariaException("Bilanci eshte negativ");
        }
        this.bilanci=bilanci;
        if (klienti == null || klienti.trim().isEmpty()) {
            throw new LlogariaException("Klienti nuk eshte inicializuar ose eshte null");
        }
        this.klienti=klienti;
    }

    

    public void depono(Double depono) throws LlogariaException {
            depono += bilanci;
            System.out.println("Shuma e deponuar eshte" + depono);
    }

    public void terhjek(double terhjek) throws LlogariaException {
        terhjek -= bilanci;
        System.out.println("Shuma e terhjekur eshte" + terhjek);
    }

    public long getNrLlogarise() {
        return nrLlogarise;
    }

    public double getBilanci() {
        return bilanci;
    }

    public String getKlienti() {
        return klienti;
    }public void setKlienti(String klienti) throws LlogariaException{
        if (klienti == null || klienti.trim().isEmpty()) {
            throw new LlogariaException("Klienti nuk eshte inicializuar ose eshte null");
        }
        this.klienti=klienti;
    }

    public boolean equals(LlogariaBankare l) {
        if (l.getNrLlogarise() == nrLlogarise) {
            return true;
        }else {
            return false;
        }
    }

    public String toString() {
        return nrLlogarise + " : " + klienti + " : " + bilanci;
    }

}
