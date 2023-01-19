package DSH;

import java.util.ArrayList;
import java.util.Random;

public class Qyteti {
    Hoteli h;
    ArrayList<Klienti> klientet = new ArrayList<Klienti>();

    public Qyteti() {
        h = new Hoteli("Latilo");
    }

    class Rezervimi extends Thread{
        private Hoteli hotel;
        private Klienti klienti;

        public Rezervimi(Hoteli hotel, Klienti klienti) {
            this.hotel=hotel;
            this.klienti=klienti;
        }

        public void run() {
            Random rd = new Random();

            while(true) {
                try {
                    Hapesira h = hotel.rezervoHapsiren(klienti);
                    
                    if (h == null) {
                        return;
                    }

                    System.out.println(klienti + " rezervoi hapsiren " + h);
                    Thread.sleep(rd.nextInt(1250) + 250);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void lexoHapsirat() throws RezervimiException {
        try {
            
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
