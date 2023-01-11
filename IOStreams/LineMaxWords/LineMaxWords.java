package IOStreams.LineMaxWords;

import java.io.*;

public class LineMaxWords {
    private String filePath;
    private FileReader fr;
    private BufferedReader br;

    public LineMaxWords(String filePath) throws IOException{
        this.filePath=filePath;

        fr = new FileReader(filePath);
        br = new BufferedReader(fr);
    }

    public void findMaxWords() throws IOException{
        String line="";
        int max = 0;
        int rreshti_aktual = 0;
        int rreshti_kushti = 0;

        while ((line = br.readLine()) != null) {
            rreshti_aktual++;
            String [] fjalet = line.split(" ");

            if (fjalet.length > max) {
                max = fjalet.length;
                rreshti_kushti = rreshti_aktual;
            }
        }

        FileWriter fw = new FileWriter("shk2.txt\\shk2.out");
        fw.write("Fjalet me me se shumti fjale " + rreshti_kushti);
        fw.close();
    }


    public void closeAll() {
        try {
            if (fr != null) {
                fr.close();
            }
            if (br != null) {
                br.close();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        LineMaxWords l = null;
        try {
            l = new LineMaxWords("shk2.txt");
            l.findMaxWords();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        finally {
            if (l != null) {
                l.closeAll();
            }
        }
    }

}
