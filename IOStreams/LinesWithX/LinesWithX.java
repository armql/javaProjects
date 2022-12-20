package IOStreams.LinesWithX;

import java.io.*;

public class LinesWithX {
    private String filePath;
	private FileReader fr = null; 
	private BufferedReader br = null;
	
    public LinesWithX(String filePath) throws IOException{
        this.filePath=filePath;
        fr = new FileReader(filePath);
        br = new BufferedReader(fr);
    }

    public int countLines() throws IOException{
        String line = "";
        int count = 0;
        
        while ((line = br.readLine()) != null) {
            if (line.contains("X")) {
                count++;
            }
        }
        
        FileWriter fw = new FileWriter("shk2.txt\shk2.out");
        fw.write(count + "Rreshta qe plotesojne kushtin");
        fw.close();
    
        return count;
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

    public static void main(String[] args) throws IOException{
        try {
            LinesWithX l = new LinesWithX("shk2.txt");

        int count = l.countLines();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }finally{
            if (l != null) {
                l.closeAll();
            }
        }
    }

}
