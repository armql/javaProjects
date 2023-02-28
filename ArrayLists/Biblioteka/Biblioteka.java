package ArrayLists.Biblioteka;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class Biblioteka {
    private String emri;
    private ArrayList<Libri> lista;
    private String fileIn;
    private String fileOut;
    private FileReader fr;
    private BufferedReader br;
    private FileWriter fw;

    public Biblioteka(String emri,String fileIn,String fileOut) throws LibriException,IOException{
        if(emri == null || emri.trim().isEmpty()) {
            throw new LibriException("Libri nuk eshte inicializuar ose eshte i zbrazet.");
        }
        this.emri=emri;
        this.fileIn=fileIn;
        this.fileOut=fileOut;
        lista = new ArrayList<Libri>();
    
        FileReader fr = new FileReader(fileIn);
        BufferedReader br = new BufferedReader(fr);
        FileWriter fw = new FileWriter(fileOut);
    }

    public void shtoLibrin(Libri l) throws LibriException{
        if(l == null) {
            throw new LibriException("Libri nuk eshte inicializuar");
        }
        if (lista.contains(l)) {
            throw new LibriException("Libri ekziston ne list");
        }
        lista.add(l);
    }

    public void shtypSipasDrejtimit(String drejtimi) {
        
        Iterator<Libri> it = lista.iterator();

        while (it.hasNext()) {
            Libri l = it.next();
            if (l instanceof LibriShkollor) {
                LibriShkollor ls = (LibriShkollor)l;
                if (ls.getDrejtimi().equals(drejtimi)) {
                    System.out.println(ls);
                }
            }
        }

    }

    public void lexoLibrat() throws LibriException, IOException{
        String line = "";

        while ((line = br.readLine()) != null) {
            String [] fjalet = line.split(";");
            String type = fjalet[0]; // Libri Shkollor ose Enciklopedia
            int isbn = Integer.parseInt(fjalet[1]);
            String titulli = fjalet[2];
            int vitiPublikimit = Integer.parseInt(fjalet[3]);
            
            if(type.equals("LibriShkollor")) {
                String drejtimi = fjalet[4];

                LibriShkollor ls = new LibriShkollor(isbn, titulli, vitiPublikimit, drejtimi);
                shtoLibrin(ls);
            }else if (type.equals("Enciklopedia")) {
                int nrAutoreve = Integer.parseInt(fjalet[4]);

                Enciklopedia en = new Enciklopedia(isbn, titulli, vitiPublikimit, nrAutoreve);
                shtoLibrin(en);
            }

        }

    }

    public void shkruaj(String text) throws IOException {
        fw.write(text);
        fw.flush();
    }

    public void shkruajLibrat() throws IOException {
        String all = "";
        Iterator<Libri> it = lista.iterator();

        while (it.hasNext()) {
            Libri l = it.next();
            all += l.toString() + "\n";
        }

        shkruaj(all);
    }

    public void closeAll() throws IOException{
        try {
            if (fr != null) {
                fr.close();
            }
            if (br != null) {
                br.close();
            }
            
        } catch (Exception e) {
        System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) throws IOException{
        Biblioteka b = null;
        try {
            b = new Biblioteka("UBT Library", "C:\\Users\\Halit\\OneDrive - ubt-uni.net\\javaProjects\\ArrayLists\\Biblioteka\\shk2.txt", "C:\\Users\\Halit\\OneDrive - ubt-uni.net\\javaProjects\\ArrayLists\\Biblioteka\\shk2.out");

            System.out.println("Metoda lexoLibrat()");
            b.lexoLibrat();
            System.out.println("");
            System.out.println("Metoda shkruaj()");
            b.shkruaj("");
            System.out.println("");
            System.out.println("Metoda shkruajLibrat()");
            b.shkruajLibrat();

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
