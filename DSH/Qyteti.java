package DSH;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Random;

public class Qyteti {
    private Hoteli h;
    private ArrayList<Klienti> klientet;

    public Qyteti(Hoteli h) {
        this.h = h;
        klientet = new ArrayList<Klienti>();
    }

    class Rezervimi extends Thread{
        private Hoteli hotel;
        private Klienti klienti;

        public Rezervimi(Hoteli hotel, Klienti klienti) {
            this.hotel=hotel;
            this.klienti=klienti;
        }

        @Override
        public void run(){
            Random rd = new Random();

            while(true) {
                try {
                    Hapesira hapsirat = hotel.rezervoHapsiren(klienti);
                    
                    if (hapsirat == null) {
                        return;
                    }

                    Thread.sleep(rd.nextInt(1250) + 250);
                    System.out.println(klienti + "\nRezervoi hapsiren " + hapsirat + " \n");
                    h.faturo();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void lexoHapsirat() throws IOException,RezervimiException {
        String line = "";

        
        String filePath = "DSH\\hapsirat.txt";
        FileReader fr = new FileReader(filePath);
        BufferedReader br = new BufferedReader(fr);

        while ((line = br.readLine()) != null) {
            String[] pjeset = line.split(";");

            if(pjeset.length >= 5) {
                String tipi = pjeset[0];
                int nr = Integer.parseInt(pjeset[1]);
                String pershkrimi = pjeset[2];
                double cmimi = Double.parseDouble(pjeset[3]);

                if(tipi.equals("DhomaStandarde")) {
                    Boolean kaTV = Boolean.parseBoolean(pjeset[4]);
                    DhomaStandarde dstandard;
                    h.shtoHapesiren(
                        dstandard = new DhomaStandarde(nr, pershkrimi, cmimi, kaTV)
                    );
                    System.out.println(dstandard);
                }
                if (tipi.equals("DhomaVIP")) {
                    Boolean kaGjakuzi = Boolean.parseBoolean(pjeset[4]);
                    DhomaVIP dvip;
                    h.shtoHapesiren(
                        dvip = new DhomaVIP(nr, pershkrimi, cmimi, kaGjakuzi)
                    );
                    System.out.println(dvip);
                }
                if(tipi.equals("Restorant")) {
                    int kapaciteti = Integer.parseInt(pjeset[4]);
                    Restoranti r;
                    h.shtoHapesiren(
                        r = new Restoranti(nr, pershkrimi, cmimi, kapaciteti)
                    );
                    System.out.println(r);
                }
                if(tipi.equals("SallaPerKonferenca")){
                    int kapaciteti = Integer.parseInt(pjeset[4]);
                    SallaPerKonferenca k;
                    
                    h.shtoHapesiren(
                        k = new SallaPerKonferenca(nr, pershkrimi, cmimi, kapaciteti)
                    );
                    System.out.println(k);
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
        String line = "";

        String fileKlienti = "DSH\\klientet.txt";

        FileReader frk = new FileReader(fileKlienti);
        BufferedReader brk = new BufferedReader(frk);


        while ((line = brk.readLine()) != null) {
            String[] pjeset = line.split(";");

            if (pjeset.length >= 3) {

                String tipi = pjeset[0];
                String emri = pjeset[1];
                char gjinia = pjeset[2].charAt(0);
                int mosha = Integer.parseInt(pjeset[3]);
            
                if (tipi.equals("Klienti")) {
                    Klienti k = new Klienti(emri, gjinia, mosha);
                    System.out.println(k);
                    shtoKlientin(k);
                }
            }

        }
        brk.close();
    }

    public void filloRezervimet() {
        for (Klienti k : klientet) {
            Rezervimi r = new Rezervimi(h, k);
            r.start();
            
        }
    }

    public static void main(String[] args) {
        Hoteli h = new Hoteli("Taliko");
        Qyteti Gilani = new Qyteti(h);
        try {
            //testing without hapsirat.txt
            DhomaStandarde d1 = new DhomaStandarde(20, "Beige Room no.1", 39.90, true);
            DhomaStandarde d2 = new DhomaStandarde(21, "Beige Room no.2", 39.90, true);
            DhomaStandarde d3 = new DhomaStandarde(23, "Blue Room no.3", 39.90, true);
            DhomaStandarde d4 = new DhomaStandarde(24, "Beige Room no.4", 39.90, true);
            DhomaStandarde d5 = new DhomaStandarde(25, "Rouge Room no.5", 39.90, true);

            //testing without hapsirat.txt
            DhomaVIP dv1 = new DhomaVIP(11, "Talikos Croc's Finest ISTANBUL", 120.50, true);
            DhomaVIP dv2 = new DhomaVIP(12, "Talikos Croc's Finest LASVEGAS", 120.50, true);
            DhomaVIP dv3 = new DhomaVIP(13, "Talikos Croc's Finest TOKYO", 120.50, true);
            DhomaVIP dv4 = new DhomaVIP(14, "Talikos Croc's Finest RIO", 120.50, true);

            //testing without hapsirat.txt
            SallaPerKonferenca s1 = new SallaPerKonferenca(5, "Taliko's Exotic Conference Room", 90, 40);
            SallaPerKonferenca s2 = new SallaPerKonferenca(6, "Taliko's Elegant Conference Room", 80, 60);

            //testing without hapsirat.txt
            Restoranti rs1 = new Restoranti(2, "Taliko's Bar", 15, 120);
            Restoranti rs2 = new Restoranti(3, "Taliko's Restaurant", 20, 4000);
            Restoranti rs3 = new Restoranti(4, "Taliko's Night Club", 20, 4000);

            // Testing if it works without klientet.txt
            Klienti k1 = new Klienti("Third", 'M', 24);
            Klienti k2 = new Klienti("Six", 'M', 32);
            Klienti k3 = new Klienti("Five", 'F', 26);
            Klienti k4 = new Klienti("Ten", 'M', 39);
            
            h.shtoHapesiren(d1);
            h.shtoHapesiren(d2);
            h.shtoHapesiren(d3);
            h.shtoHapesiren(d4);
            h.shtoHapesiren(d5);

            h.shtoHapesiren(dv1);
            h.shtoHapesiren(dv2);
            h.shtoHapesiren(dv3);
            h.shtoHapesiren(dv4);

            h.shtoHapesiren(s1);
            h.shtoHapesiren(s2);

            h.shtoHapesiren(rs1);
            h.shtoHapesiren(rs2);
            h.shtoHapesiren(rs3);


            Gilani.shtoKlientin(k1);
            Gilani.shtoKlientin(k2);
            Gilani.shtoKlientin(k3);
            Gilani.shtoKlientin(k4);

            System.out.println("--------------------lexohenHapsirat--------------------");
            Gilani.lexoHapsirat();
            System.out.println("");
            System.out.println("---lexohenKlientet---");
            Gilani.lexoKlientet();

            System.out.println("-------------------------------------------------------------------------------------------------");
            System.out.println("Fillojne Rezervimet!\n");
            Gilani.filloRezervimet();

        }catch (IOException e ) {
            e.printStackTrace();
        }catch (RezervimiException e ) {
            e.printStackTrace();
        }
    }
}
