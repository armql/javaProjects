package DSH;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Qyteti {
    Hoteli h;
    ArrayList<Klienti> klientet = new ArrayList<Klienti>();

    FileReader fr;
    BufferedReader br;
    String filePath = "hapsirat.txt";

    public Qyteti(String filePath) throws RezervimiException,IOException{
        h = new Hoteli("Latilo");
        this.filePath=filePath;

        FileReader fr = new FileReader(filePath);
        BufferedReader br = new BufferedReader(fr);
    }

    class Rezervimi extends Thread{
        private Hoteli hotel;
        private Klienti klienti;

        public Rezervimi(Hoteli hotel, Klienti klienti) {
            this.hotel=hotel;
            this.klienti=klienti;
        }

        public void run(){
            Random rd = new Random();

            while(true) {
                try {
                    Hapesira hap = hotel.rezervoHapsiren(klienti);
                    
                    if (hap == null) {
                        return;
                    }

                    System.out.println(klienti + " rezervoi hapsiren " + hap);
                    Thread.sleep(rd.nextInt(1250) + 250);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void lexoHapsirat() throws IOException,RezervimiException {
        String line = "";
        while ((line = br.readLine()) != null) {
            String[] pjeset = line.split(";");

            if(pjeset.length == 5) {
                String tipi = pjeset[0];
                int nr = Integer.parseInt(pjeset[1]);
                String pershkrimi = pjeset[2];
                double cmimi = Double.parseDouble(pjeset[3]);
                String atributi = pjeset[4];
                if(tipi.equals("DhomaStandarde")) {
                    h.shtoHapesiren(new DhomaStandarde(nr, pershkrimi, cmimi, false));
                }
                if (tipi.equals("DhomaVIP")) {
                    h.shtoHapesiren(new DhomaVIP(nr, pershkrimi, cmimi, false));
                }
                if(tipi.equals("Restorant")) {
                    h.shtoHapesiren(new Restoranti(nr, pershkrimi, cmimi, nr));
                }
                if(tipi.equals("SallaPerKonferenca")){
                    h.shtoHapesiren(new SallaPerKonferenca(nr, pershkrimi, cmimi, nr));
                }
            }
        }
        br.close();
    }

    public void shtoKlientin(Klienti k) throws RezervimiException{
        if(k == null) {
            throw new RezervimiException("Klienti nuk eshte inicializuar");
        }
        if (klientet.contains(k)) {
            throw new RezervimiException("Klienti ekziston ne list");
        }
        klientet.add(k);
    }

    public void lexoKlientet() throws RezervimiException,IOException{
        String fileKlienti = "klientet.txt";

        FileReader frk = new FileReader(fileKlienti);
        BufferedReader brk = new BufferedReader(frk);

        String line = "";

        while ((line = brk.readLine()) != null) {
            String[] pjeset = line.split(";");

            if (pjeset.length < 53) {
                
                String emri = pjeset[0];
                char gjinia = pjeset[1].charAt(0);
                int mosha = Integer.parseInt(pjeset[2]);
            
                Klienti k = new Klienti(emri, mosha, gjinia);
                shtoKlientin(k);

            }

        }
        br.close();

    }
}
