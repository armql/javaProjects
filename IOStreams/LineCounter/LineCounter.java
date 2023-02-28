package IOStreams.LineCounter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class LineCounter {
    private String filePath;
    private FileReader fr;
    private BufferedReader br;

    public LineCounter(String filePath) throws IOException{
        this.filePath=filePath;
        
        fr = new FileReader(filePath);
        br = new BufferedReader(fr);
    }

    public int countLines() throws IOException{
        String line = "";
        int count = 0;
        int nr_rreshtave = 0;

        while ((line = br.readLine()) != null) {
            nr_rreshtave++;
            if (line.length() % 2 == 0 && line.contains("SHK2")) {
                count++;
            }
        }

        FileWriter fw = new FileWriter("C:\\Users\\Halit\\OneDrive - ubt-uni.net\\javaProjects\\IOStreams\\LineCounter\\shk2.out");
        fw.write("Kemi " + nr_rreshtave + " rreshta, dhe " + count + " qe plotesojn kushtin.");
        return count;
    }

    public void closeAll() throws IOException{
        if (fr != null) {
            fr.close();
        }
        if (br != null) {
            br.close();
        }
    }

    public static void main(String[] args) throws IOException{
        LineCounter l = null;
        try {
            l = new LineCounter("C:\\Users\\Halit\\OneDrive - ubt-uni.net\\javaProjects\\IOStreams\\LineCounter\\shk2.txt");
            l.countLines();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        finally {
            if (l != null) {
                l.closeAll();
            }
        }
    }
}
