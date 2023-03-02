package ArrayLists.Banka;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class Banka {
    private String emri;
    public ArrayList<LlogariaBankare> llogarit;
    String fileIn;
    String fileOut;

    FileReader fr;
    BufferedReader br;
    public Banka(String emri,String fileIn, String fileOut) throws LlogariaException, IOException {
        this.emri=emri;
        this.fileIn=fileIn;
        this.fileOut=fileOut;
        llogarit = new ArrayList<LlogariaBankare>();

        FileReader fr = new FileReader(fileIn);
        BufferedReader br = new BufferedReader(fr);
    }

    public void shtoLlogarine(LlogariaBankare l) throws LlogariaException{
        if (l == null) {
            throw new LlogariaException("Llogaria nuk eshte inicializuar.");
        }
        if (llogarit.contains(l)) {
            throw new LlogariaException("Llogaria ekziston ne list");
        }
        llogarit.add(l);
    }

    public void lexoLlogarite() throws LlogariaException,IOException {
        String line = "";

        while ((line = br.readLine()) != null) {
            String[] pjeset = line.split(";");

            if (pjeset.length >= 5) {    
                    String tipi = pjeset[0];
                    int nrLlogari = Integer.parseInt(pjeset[1]);
                    double bilanci = Double.parseDouble(pjeset[2]);
                    String klienti = pjeset[3];

                if (tipi.equals("LlogariaRrjedhese")) {
                    int mbiterheqja = Integer.parseInt(pjeset[4]);

                    LlogariaRrjedhese lr = new LlogariaRrjedhese(nrLlogari, bilanci, klienti, mbiterheqja);
                    shtoLlogarine(lr);
                    System.out.println(lr);
                }
                if (tipi.equals("LlogariKursyese")) {
                    double interesi = Double.parseDouble(pjeset[4]);

                    LlogariaKursyese lk = new LlogariaKursyese(nrLlogari, bilanci, klienti, interesi);
                    shtoLlogarine(lk);
                    System.out.println(lk);
                    }
            }

        }
        br.close();
    }

    public void shkruaj(String permbajtja) throws LlogariaException,IOException{
        FileWriter fw = new FileWriter(fileOut);
        fw.write(permbajtja);
    }

    public void shkruajLlogarite() throws LlogariaException,IOException{
        FileWriter fw = new FileWriter(fileOut);
        String lineS= ";";

        for (LlogariaBankare l : llogarit) {
            if (l instanceof LlogariaRrjedhese) {
                LlogariaRrjedhese lr = (LlogariaRrjedhese)l;
                fw.write("LlogariaRrjedhese" + lineS + lr.getNrLlogarise() + lineS
                + lr.getBilanci() + lineS + lr.getKlienti() + lineS + lr.getMbiterheqja());
                fw.close();
            }
            if (l instanceof LlogariaKursyese) {
                LlogariaKursyese lk = (LlogariaKursyese)l;
                fw.write("LlogariaKursyese" + lineS + lk.getNrLlogarise() + lineS
                + lk.getBilanci() + lineS + lk.getKlienti() + lineS + lk.getInteresi());
                fw.close();
            }
        }
        fw.close();
    }

    public LlogariaKursyese maxInteresi() throws LlogariaException{
        if (llogarit.isEmpty()) {
            throw new LlogariaException("Nuk ka asnje llogari.");
        }

        LlogariaKursyese lk = null;
        Iterator<LlogariaBankare> it = llogarit.iterator();
        while (it.hasNext()) {
            Object m  = it.next();
            if (m instanceof LlogariaKursyese) {
                LlogariaKursyese tempLK = (LlogariaKursyese)m;
                if (lk == null || lk.getInteresi() < tempLK.getInteresi()) {
                    lk = tempLK;
                }
            }
        }
        return lk;
    }

    public LlogariaRrjedhese firstMbiterheqja() throws LlogariaException{
        if (llogarit.isEmpty()) {
            throw new LlogariaException("Nuk ka asnje llogari");
        }

        LlogariaRrjedhese lr = null;
        Iterator<LlogariaBankare> it = llogarit.iterator();
        int maxTerheqja= 100;
        while (it.hasNext()) {
            Object m = it.next();

            if (m instanceof LlogariaRrjedhese) {
                LlogariaRrjedhese tempLR = (LlogariaRrjedhese)m;

                if (lr == null || lr.getMbiterheqja() < maxTerheqja) {
                    lr = tempLR;
                }
            }
        }
        return lr;
    }

    public LlogariaBankare maxBilanciKombetar() throws LlogariaException{
        if (llogarit.isEmpty()) {
            throw new LlogariaException("Nuk ka asnje llogari.");
        }

        LlogariaBankare lb = null;
        Iterator<LlogariaBankare> it = llogarit.iterator();

        while (it.hasNext()) {
            LlogariaBankare tempLB = it.next();
            if (tempLB instanceof Transferohet) {
                Transferohet lltr = (Transferohet)tempLB;
                if (lb == null || lltr.equals(" Ka transferta kombetare ")) {
                    if (lb == null || lb.getBilanci() > tempLB.getBilanci()) {
                        lb = tempLB;
                    }
                }
            }
        }
        return lb;
    }

    public void closeAll() throws IOException {
        if (fr != null) {
            fr.close();
        }
        if(br != null) {
            br.close();
        }
    }
    public static void main(String[] args) throws IOException {
        Banka b = null;
        try {
            b = new Banka(
                "XYZ",
                "ArrayLists\\Banka\\Llogarit\\llogaria.in",
                "ArrayLists\\Banka\\Llogarit\\banka.out"
            );

            b.lexoLlogarite();
            b.shkruajLlogarite();
        } catch (Exception e) {
            System.out.println(e);
        }
        finally {
            if (b != null) {
                b.closeAll();
            }
        }
    }
}
