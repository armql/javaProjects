package SHK2.FileNumero;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileNumero {
    String fileIn;

    FileReader fr;
    BufferedReader br;

    public FileNumero(String fileIn) throws IOException {
        this.fileIn=fileIn;

    fr = new FileReader(fileIn);
    br = new BufferedReader(fr);
    }

    public int countRreshtat() throws IOException{
        String line = "";
        int count = 0;
        int nr_rreshtave = 0;

        while((line = br.readLine()) != null) {
            nr_rreshtave++;
            if(line.length() <= 5 && line.contains("UBT21")) {
                count++;
            }
        }

        FileWriter fw = new FileWriter("C:\\Users\\Halit\\OneDrive - ubt-uni.net\\javaProjects\\SHK2\\FileNumero\\fileName_out.txt");
        fw.write("Kemi " + nr_rreshtave + " rreshta, dhe " + count + " qe plotesojn kushtin.");
        fw.flush();
        return count;
    }

    public void closeAll() throws IOException {
        if (fr != null) {
            fr.close();
        }
        if (br != null) {
            br.close();
        }
    }
    public static void main(String[] args) throws IOException{
        FileNumero f = null;
        try {
            f = new FileNumero("C:\\Users\\Halit\\OneDrive - ubt-uni.net\\javaProjects\\SHK2\\FileNumero\\fileName_in.txt");
            
            f.countRreshtat();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        finally {
            if (f != null) {
                f.closeAll();
            }
        }
    }
}
