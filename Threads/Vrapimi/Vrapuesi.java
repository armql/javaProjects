package Threads.Vrapimi;

import java.util.Random;

public class Vrapuesi extends Atleti{
    private int nrMedaljeve = 0;

    public Vrapuesi(int nrRendor, String emri, char gjinia, int mosha, int distanca, int gjatesiaEPistes,
            int nrMedaljeve) throws AtletiException {
        super(nrRendor, emri, gjinia, mosha, distanca, gjatesiaEPistes);
        if (nrMedaljeve < 0) {
            throw new AtletiException("NrMedaljeve min eshte 0");
        }
        this.nrMedaljeve = nrMedaljeve;
    }

    public int getNrMedaljeve() {
        return nrMedaljeve;
    }public void setNrMedaljeve(int nrMedaljeve) throws AtletiException{
        if (nrMedaljeve < 0) {
            throw new AtletiException("NrMedaljeve min eshte 0");
        }
        this.nrMedaljeve = nrMedaljeve;
    }

    public void garo() {
        distanca += 10;
    }

    public void run() {
        Random r = new Random();

        while (distanca < gjatesiaEPistes) {
            try {
                Thread.sleep(r.nextInt(300));
                garo();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            if (distanca == gjatesiaEPistes) {
                System.out.println("FINISHED " + toString());
            }
        }
    }

    public String toString() {
        return "Vrapuesi " + super.toString() + " me " + nrMedaljeve + " medalje," + " aktualisht ka arritur distancen" + distanca + "!";
    }

}
