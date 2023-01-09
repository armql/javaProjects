package Threads.Hipodromi;

import java.util.Random;

public class QeniGarues extends KafshaGaruese implements Garon{
    int distanca = 0;

    public QeniGarues(int mosha, String emri, int pozitaStartuese) throws GaraException {
        super(mosha, emri, pozitaStartuese);
        if (mosha < 1  || mosha > 10) {
            throw new GaraException("Nuk mund te jene nen moshen 1 vjeqare dhe mbi 10 vjec.");
        }
    }

    @Override
    public void vrapon() {
        distanca = distanca + 10;
    }

    public void run() {
        Random r = new Random();

        while(distanca < GJATESIA_E_PISTES) {
            try {
                Thread.sleep(r.nextInt(2000));
                vrapon();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            if (distanca == GJATESIA_E_PISTES) {
                System.out.println("Finished");
            }
        }
    }

    public String toString() {
        return "Qeni Garues " + super.toString() + " Vrapoi " + distanca + " metra";
    }

}
