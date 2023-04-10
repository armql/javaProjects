import java.util.Scanner;

public class MaxNumber {

	public static void main(String [] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Shtype nje numer qe nuk eshte se paku 15");
		int num = sc.nextInt();
		
		while(num > 15) {
			System.out.println("Shtype perseri nje numer qe nuk eshte se paku 15");
			num = sc.nextInt();
		}
		
		
		int [] vargu = new int[num];
		for(int i = 0; i<vargu.length; i++) {
			System.out.println("Shtype nje numer 32bit per poziten:" + i);
			vargu[i] = sc.nextInt();
		}
	
		System.out.println("Total numra jane" + num );
		System.out.println(firstMax(vargu) + " eshte numri i pare me i madhe se mesatarja.");
		
	}
	
	public static int firstMax(int [] vargu) {
		int sum = 0;
		
		for(int i = 0; i<vargu.length; i++) {
			sum += vargu[i];
		}
		
		int mesatarja = sum/vargu.length;
		
		for(int i = 0; i<vargu.length; i++) {
			if(vargu[i] > mesatarja) {
				return vargu[i];
			}
		}
		
		return 0;
	}
	
}