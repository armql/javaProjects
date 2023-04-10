import java.util.Scanner;

public class Ushtrimi3 {
	
	public static void main(String [] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Shtype nje numer perderisa nuk eshte se paku 15");
		int num = sc.nextInt();
		
		while(num > 15) {
		System.out.println("Shtype perseri nje numer perderisa nuk eshte se paku 15");
		num = sc.nextInt();
		}
		
		long [] vargu = new long[num];
		
		for(int i = 0; i<vargu.length; i++) {
			System.out.println("Shtype nje numer long per poziten: " + i);
			vargu[i] = sc.nextLong();
		}
		
		System.out.println("Total numra jane " + num);
		System.out.println(countNumbers(vargu) + "% e numrave jane mesatarisht me te vogel se 20");
		
	}
	
	public static double countNumbers(long [] vargu) {
		double ctK = 0;
		
		for(int i=0; i<vargu.length; i++) {
			
			if(vargu[i] < 20){
				ctK++;
			}
		}
		
		double mesatarja = ctK/vargu.length*100;
		
		return mesatarja;
	}
	
}