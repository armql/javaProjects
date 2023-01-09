package Threads.Hipodromi;

import java.util.Random;

public class KaliGarues extends KafshaGaruese implements Garon{
    private int distanca = 0;

    public KaliGarues(int mosha, String emri, int pozitaStartuese) throws GaraException {
        super(mosha, emri, pozitaStartuese);
        if (mosha < 2 || mosha > 10) {
            throw new GaraException("Mosha eshte dhene gabim");
        }
    }

    @Override
    public void vrapon() {
        distanca += 10;
    }

    public void run() {
        Random r = new Random();

        while (distanca < GJATESIA_E_PISTES) {
            try {
                Thread.sleep(r.nextInt(2000));
                vrapon();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            if (distanca == GJATESIA_E_PISTES) {
                System.out.println("FINISHED");
            }
        }
    }

    public String toString() {
        return "Kali Garues " + super.toString() + " vrapoi " + distanca + "metra";
    }

}
