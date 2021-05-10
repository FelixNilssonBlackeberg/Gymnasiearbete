package gymnasiearbete;
import java.util.Scanner;
// Beskriv här vad programmet gör
public class SIS {

    public static void main(String[] args) {
        //Startvärden
        /*Scanner sc = new Scanner(System.in);
        System.out.print("Skriv S(0): ");
        double s = sc.nextDouble();
        System.out.print("Skriv I(0): ");
        double i = sc.nextDouble();
        System.out.print("Skriv β: ");
        double b = sc.nextDouble();
        System.out.print("Skriv γ: ");
        double y = sc.nextDouble();
        double n = s + i;
        System.out.print("Skriv antal dagar du vill kolla: ");
        int dagar = sc.nextInt();*/
        
        double s = 2383265;
        double i = 4;
        double b = 0.415;
        double y = 0.143;
        double n = s + i;
        int dagar = 70;
        //-------------

        double s_prim;

        double i_prim;
        
        double blirsjuka_prim;
        
        double i_tot = 0;

        double dör_prim = 0;
        
        double döda = 0;

        for (int x = 1; x <= dagar; x++) {
            s_prim = ((-b) * i * s)/n + y*i;
            
            blirsjuka_prim = ((b) * i * s)/n;

            i_prim = ((double)(b * i * s))/n - (y * i);
            
            dör_prim = (y*i) * 0.006;


            s = (s + s_prim - dör_prim);
            i = (i + i_prim);
            i_tot = (i_tot + blirsjuka_prim);
            döda = döda + dör_prim;

            System.out.println("Utskrift---------------------- " + "DAG " + x);
            System.out.println("S': " + s_prim);
            System.out.println("I': " + i_prim);

            System.out.println("S: " + s + " I: " + i + " I Totalt: " + i_tot + " Döda: " + döda);
            System.out.println();
        }
    }

}
