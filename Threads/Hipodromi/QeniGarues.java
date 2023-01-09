package Threads.Hipodromi;

public class QeniGarues extends KafshaGaruese implements Garon{

    public QeniGarues(int mosha, String emri, int pozitaStartuese) throws GaraException {
        super(mosha, emri, pozitaStartuese);
        if (mosha < 1  || mosha > 10) {
            throw new GaraException("Nuk mund te jene nen moshen 1 vjeqare dhe mbi 10 vjec.");
        }
    }

    public void setMosha(int mosha) throws GaraException{
        if (mosha <= 1  && mosha >= 10) {
            throw new GaraException("Nuk mund te jene nen moshen 1 vjeqare dhe mbi 10 vjec.");
        }
    }

    
}
