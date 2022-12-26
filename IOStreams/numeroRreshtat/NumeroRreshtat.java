import java.io.*;

public class NumeroRreshtat{
	String fileIn;
	String fileOut;
	FileReader fr = null;
	BufferedReader br = null;
	FileWriter fw = null;
	BufferedWriter bw = null;
	
	public NumeroRreshtat(String fi, String fo) throws IOException{
		if(fi == null || fi.trim().isEmpty()){
			throw new IOException ("File input error");
		}
		if(fo == null || fo.trim().isEmpty()){
			throw new IOException ("File output error");
		}
		fileIn = fi;
		fileOut = fo;
		fr = new FileReader(fileIn);
		br = new BufferedReader(fr);
		fw = new FileWriter(fileOut);
		bw = new BufferedWriter(fw);	
	}
	
	public int numero(String txt) throws IOException{
		int count = 0;
		String line = null;
		while((line = br.readLine()) != null){
			if(line.startsWith(txt)){
				count++;
			}
		}
		return count;	
	}
	
	public void numeroRreshtat(String txt) throws IOException{
		//Numri i rreshtave ne file-in <emri_i_input_file-it> 
		//qe fillojne me tekstin <teksti> eshte: <nr_rreshtave> 
		bw.write("Numri i rreshtave ne file-in " +
		fileIn + " qe fillojne me tekstin " + txt 
		+ " eshte : " + numero(txt));
		bw.close();
	}

	public void mbylliResurset(){
		try{
		if(fr != null){
			fr.close();
		}
		if(br != null){
			br.close();
		}
		if(fw != null){
			fw.close();
		}
		if(bw != null){
			bw.close();
		}
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public static void main(String[]args){
		NumeroRreshtat nr = null;
		
		try{
			nr = new NumeroRreshtat("shk2.txt","shk2.out");
			nr.numeroRreshtat("UBT");
		}
		catch(Exception e){
			System.out.println(e);
		}
		finally{
			if(nr != null){
				nr.mbylliResurset();
			}
		}
		
		
	}
	
	
	
	
	
	
	
}