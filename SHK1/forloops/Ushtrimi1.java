import java.util.Scanner;

public class Ushtrimi1 {
	   
	public static void main(String [] args) {

		// Initializing my Scanner
		Scanner sc = new Scanner(System.in);
	
		// Giving a label and after that is input [int] 
		System.out.println("Shtype nje numer se paku 5");
		int num = sc.nextInt();
	
		// while num kushti se paku 5 [0,1,2,3,4,5]
		while(num >= 5) {
			System.out.println("Shtype nje numer perseri se paku 5");
			num = sc.nextInt();
		}
	
		int [] vargu = new int[num];
		for(int i = 0; i<vargu.length; i++) {
			System.out.println("Shtype nje numer per poziten:" + i);
			vargu[i] = sc.nextInt();
		}
	
		// Output and results printed
		System.out.println("Jane shtypur gjithesej " + num + " numra, prej te cileve " + calculateNumbers(vargu) +  "% plotesojne kushtin");
		
	}

	// Method calculateNumbers condition in perqindje<>% so double data-type  
	public static double calculateNumbers(int [] vargu) {
		// counter initialized
		int count=0;
		
		// imitates the array with the for loop again
		for(int i = 0; i<vargu.length; i++) {
			
			//the condition is called here if the number is pair
			if(vargu[i] % 2 != 0){
				count++;
			}
			
		}
		
		// Call the average on double
		// The vargu.length is multiplied for 100 for a 100% - 50% result 
		double mesatarja = count/vargu.length*100;
		
		// return average
		return mesatarja;
		
	}
}

