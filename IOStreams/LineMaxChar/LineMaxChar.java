package IOStreams.LineMaxChar;

import java.io.*;

public class LineMaxChar {
    private String filePath;

    private FileReader fr;
    private BufferedReader br; 

    public LineMaxChar(String filePath) throws IOException{
        this.filePath=filePath;
        FileReader fr = new FileReader(filePath);
        BufferedReader br = new BufferedReader(fr);
    }

    public void findMaxChar() throws IOException{
        String line= "";
        String longestLine = "";
        int rreshti_aktual = 0;
        int rreshti_kushti = 0;

        while ((line = br.readLine()) != null) {
            rreshti_aktual++;

            if (longestLine == null || line.length() > longestLine.length()) {
                rreshti_kushti = rreshti_aktual;
                longestLine=line;
            }

        }

        FileWriter fw = new FileWriter("ubt.txt\shk2.out");
        fw.write("Fjalia me e gjate ndodhet te rreshti " + rreshti_kushti);
        fw.close();    }

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

    public static void main(String[] args) throws IOException{
        LineMaxChar l = null;

        try {
            l = new LineMaxChar("ubt.txt");
            l.findMaxChar();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        finally {
            if (l != null ) {
                l.closeAll();
            }
        }
    }

}
