import java.util.Scanner;

public class numeroFjalen{

	public static void main(String [] args) {
		
		Scanner sc = new Scanner(System.in);
	
		System.out.println("Shtype nje numer se paku 10");
		int num = sc.nextInt();
	
		while(num < 10) {
			System.out.println("Shtype nje numer perseri se paku 10");
			num = sc.nextInt();
		}
	
		String [] vargu = new String[num];
		for(int i=0; i<vargu.length; i++) {
			vargu[i] = sc.nextLine();
			System.out.println("Shtype nje fjale/fjali pozita:" + i);
		}
		
		System.out.println("Total fjale/fjali jane " + num);
		System.out.println("Total fjale/fjali qe plotesojn kushtin jane " + numeroFjalen(vargu) + " fjale/fjali");
		
	}
	
	
	
	public static int numeroFjalen(String [] vargu) {
		int ctK = 0;
		
		for(int i=0; i<vargu.length; i++) {

			
			if(vargu[i].length() <= 4 && vargu[i].length() >= 8) {
				
				if(vargu[i].contains("a") || vargu[i].contains("e")
				|| vargu[i].contains("i") || vargu[i].contains("o")
				|| vargu[i].contains("u") || vargu[i].contains("y")) {
					// Keto jane zanore
				}else {
					// Nuk jane zanore plotesohet kushti
					ctK++;
				}
				
			}
			
			
		}
		
		return ctK;
		
	}
	
}