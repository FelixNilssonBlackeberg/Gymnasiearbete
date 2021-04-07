package gymnasiearbete;
import java.util.Scanner;
// Beskriv här vad programmet gör
public class SIR {

    public static void main(String[] args) {
        //Startvärden
        Scanner sc = new Scanner(System.in);
        System.out.print("Skriv S(0): ");
        double s = sc.nextDouble();
        System.out.print("Skriv I(0): ");
        double i = sc.nextDouble();
        System.out.print("Skriv R(0): ");
        double r = sc.nextDouble();
        System.out.print("Skriv β: ");
        double b = sc.nextDouble();
        System.out.print("Skriv γ: ");
        double y = sc.nextDouble();
        double n = s + i + r;
        System.out.print("Skriv antal dagar du vill kolla: ");
        int dagar = sc.nextInt();
        //-------------

        double s_minskning;

        double i_prim = 0;

        double r_okning;
        

        for (int x = 1; x <= dagar; x++) {
            s_minskning = ((-b) * i * s)/n;

            i_prim = ((double)(b * i * s))/n - (y * i);

            r_okning = (y * i);

            s = (s + s_minskning);
            i = (i + i_prim);
            r = (r + r_okning);

            System.out.println("Utskrift---------------------- " + "DAG " + x);
            System.out.println("S': " + s_minskning);
            System.out.println("I': " + i_prim);
            System.out.println("R': " + r_okning);

            System.out.println("S: " + s + " I: " + i + " R: " + r + " I Totalt: " + (n-s));
            System.out.println();
        }
    }

}
