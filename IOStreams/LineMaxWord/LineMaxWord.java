package IOStreams.LineMaxWord;

import java.io.*;

public class LineMaxWord {
    private String filePath;
    
    private FileReader fr;
    private BufferedReader br;

    public LineMaxWord (String filePath) throws IOException {
        this.filePath=filePath;

        fr = new FileReader(filePath);
        br = new BufferedReader(fr);
    }

    public void findMaxWord() throws IOException{
        String line ="";
        String longestWord = "";

        while ((line = br.readLine()) != null) {
            String [] fjalet = line.split(" ");

            for (int i = 0; i < fjalet.length; i++) {
                if (longestWord == null || fjalet[i].length() > longestWord.length()) {
                    longestWord = fjalet[i];
                }
            }
        }
        
        FileWriter fw = new FileWriter("shk2.txt\\shk2.out");
        fw.write("Fjala me e gjate: " + longestWord);
        fw.close();
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
        LineMaxWord l = null;
        try {
            l = new LineMaxWord("shk2.txt");
            l.findMaxWord();
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
