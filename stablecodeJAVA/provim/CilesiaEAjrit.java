package provim;




import java.util.Scanner;

public class CilesiaEAjrit {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        System.out.println("Shtype cilesin e ajrit:");
        int ICA = sc.nextInt(); 

        if(ICA == 0) {
            System.out.println("Keni shtypur gabim.");
        }
        else if(ICA > 0 && ICA < 50) {
            System.out.println("Indeksi i ulet.");
        }
        else if(ICA > 51 && ICA < 74) {
            System.out.println("Indeksi i moderuar.");
        }
        else if(ICA > 75 && ICA < 100) {
            System.out.println("Indeksi i larte");
        }
        else {
            System.out.print("Indeksi shume i larte.");
        }
        
    }

}
