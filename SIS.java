package gymnasiearbete;
import java.util.Scanner;
// Beskriv här vad programmet gör
public class SIS {

    public static void main(String[] args) {
        //Startvärden
        Scanner sc = new Scanner(System.in);
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
        int dagar = sc.nextInt();
        //-------------

        double s_prim;

        double i_prim = 0;


        for (int x = 1; x <= dagar; x++) {
            s_prim = ((-b) * i * s)/n + y*i;

            i_prim = ((double)(b * i * s))/n - (y * i);


            s = (s + s_prim);
            i = (i + i_prim);

            System.out.println("Utskrift---------------------- " + "DAG " + x);
            System.out.println("S': " + s_prim);
            System.out.println("I': " + i_prim);

            System.out.println(" S: " + s + " I: " + i);
            System.out.println();
        }
    }

}
