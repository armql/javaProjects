package SHK2.Biblioteka;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class Biblioteka {
    private String emri;
    private ArrayList<Libri> lista;

    String fileIn;
    String fileOut;
    FileReader fr;
    BufferedReader br;
    FileWriter fw;

    public Biblioteka(String emri, String fileIn, String fileOut) throws IOException {
        this.emri=emri;
        this.fileIn=fileIn;
        this.fileOut=fileOut;
    
        lista = new ArrayList<Libri>();
        fr = new FileReader(fileIn);
        br = new BufferedReader(fr);
        fw = new FileWriter(fileOut);
    }

    public void shtoLibri(Libri l) throws LibriException{
        if (l == null) {
            throw new LibriException("Libri nuk eshte inicializuar.");
        }
        if (lista.contains(l)) {
            throw new LibriException("Libri gjindet tashme ne list");
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

    public void lexoLibrat() throws LibriException, IOException {
        String line = "";

        while ((line = br.readLine()) != null) {
            String [] fjalet = line.split(";");
            String type = fjalet[0];
            String isbn = fjalet[1];
            String titulli = fjalet[2];
            int vitiPublikimit = Integer.parseInt(fjalet[3]);

            if (type.equals("LibriShkollor")) {
                String drejtimi = fjalet[4];

                LibriShkollor l = new LibriShkollor(isbn, titulli, vitiPublikimit, drejtimi);
                shtoLibri(l);
            }else if (type.equals("Enciklopedia")) {
                int nrAutoreve = Integer.parseInt(fjalet[4]);

                Enciklopedia en = new Enciklopedia(isbn, titulli, vitiPublikimit, nrAutoreve);
                shtoLibri(en);
            }
        }
    }

    public void shkruaj(String tekst) throws IOException {
        fw.write(tekst);
        fw.flush();
    }

    public void shkruajLibrat() throws LibriException,IOException {
        String librat = "";

        Iterator<Libri> it = lista.iterator();

        while (it.hasNext()) {
            Libri l = it.next();
            if (l instanceof LibriShkollor) {
                LibriShkollor ls = (LibriShkollor)l;
                librat += "Libri Shkollor;" +  ls.getIsbn() + ";" + ls.getTitulli() + ";" + ls.getVitiPublikimit() + ";" + ls.getDrejtimi() + "\n";
            }
            if (l instanceof Enciklopedia) {
                Enciklopedia en = (Enciklopedia)l;
                librat += "Enciklopedia;" + en.getIsbn() + ";" + en.getTitulli() + ";" + en.getVitiPublikimit() + ";" + en.getNrAutoreve() + "\n";
            }
        }
        shkruaj(librat);
    }

    public void closeAll() throws IOException {
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
            b = new Biblioteka("-UBT Library-", "C:\\Users\\Halit\\OneDrive - ubt-uni.net\\javaProjects\\SHK2\\Biblioteka\\shk2.txt", "C:\\Users\\Halit\\OneDrive - ubt-uni.net\\javaProjects\\SHK2\\Biblioteka\\shk2.out");

            LibriShkollor l1 = new LibriShkollor("2311", "Lagotas Blue Whale", 1993, "Anatomi");
            LibriShkollor l2 = new LibriShkollor("1442", "Rhys Star Machine", 2014, "Science");
            
            Enciklopedia e1 = new Enciklopedia("55124A", "Lita", 2022, 1);
            Enciklopedia e2 = new Enciklopedia("53424A", "Taliko", 2009, 4);
            b.shtoLibri(l1);
            b.shtoLibri(l2);
            b.shtoLibri(e1);
            b.shtoLibri(e2);

            System.out.println("Metoda lexoLibrat()");
            b.lexoLibrat();
            System.out.println("");
            System.out.println("Metoda shkruaj()");
            b.shkruaj("te\n");
            System.out.println("");
            System.out.println("Metoda shkruajLibrat()");
            b.shkruajLibrat();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        finally {
            if (b != null) {
                b.closeAll();
            }
        }
    }
}
