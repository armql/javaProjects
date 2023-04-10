import java.util.Scanner;

public class NumeroNumrat{
	public static void main(String [] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Shtype nje numer perderisa nuk eshte se paku 10");
		int num = sc.nextInt();
		
		while(num >= 10) {	
			System.out.println("Shtype perseri nje numer perderisa nuk eshte se paku 10");
			num = sc.nextInt();
		}
		
		String [] vargu = new String[num];
		for(int i = 0; i<vargu.length; i++) {
			vargu[i]=sc.nextLine();
			System.out.println("Shtype nje fjale/fjali pozita: " + i);
		}
		
		System.out.println("Jane gjithesej " + num + " fjale/fjali.");
		System.out.println("Jane gjithesej " + countNumrat(vargu) + " fjale/fjali. Qe plotesojne kushtin e kerkuar");
	}
	
	public static int countNumrat(String [] vargu) {
		int count = 0;
		int ctK = 0;
		
		for(String s : vargu) {
			
			for(int i = 0; i<s.length(); i++) {
				
				if(Character.isDigit(s.charAt(i))) {
					count++;
				}
				
				if(count == 2) {
					ctK++;
				}
				
			}
			
		}
		
		return ctK;
	}
}