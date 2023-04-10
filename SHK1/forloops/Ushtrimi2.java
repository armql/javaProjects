import java.util.Scanner;

public class Ushtrimi2 {
	
	public static void main(String [] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Shtype nje numer perdersia nuk eshte se paku 10");
		int num = sc.nextInt();
		
		while(num < 10) {
			System.out.println("Shtype nje numer perdersia nuk eshte se paku 10");
			num = sc.nextInt();
		}
		
		String [] vargu = new String[num];
		
		for(int i = 0; i<vargu.length; i++) {
			vargu[i] = sc.nextLine();
			System.out.println("Shtype nje fjale/fjali per poziten:" + i);
		}
		
		System.out.println("Ne kemi total fjale/fjali ; " + num);
		System.out.println("Ne kemi fjale/fjali qe plotesojne kushtin ; " + findWord(vargu));
		
	}
	
	
	public static double findWord(String [] vargu) {
		int sum = 0; 
		int count = 0;
		
		for(int i = 0; i<vargu.length; i++) {
			
			if(vargu[i].toUpperCase().startsWith("A")&& vargu[i].toUpperCase().endsWith("E")) {
				count++;
				
				sum += vargu[i].length();
			}
		}
		
		return (double)sum/(double)count;
	}
	
}