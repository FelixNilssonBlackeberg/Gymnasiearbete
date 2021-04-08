package gymnasiearbete;

import java.util.Scanner;

public class SEIR {

    public static void main(String[] args) {
        
        //Startvärden
       /* Scanner sc = new Scanner(System.in);
        System.out.print("Skriv S(0): ");
        double s = sc.nextDouble();
        System.out.print("Skriv E(0): ");
        double e = sc.nextDouble();
        System.out.print("Skriv I(0): ");
        double i = sc.nextDouble();
        System.out.print("Skriv R(0): ");
        double r = sc.nextDouble();
        System.out.print("Skriv β: ");
        double b = sc.nextDouble();
        System.out.print("Skriv γ: ");
        double y = sc.nextDouble();
        System.out.print("Skriv σ: ");
        double sigma = sc.nextDouble();
        double n = s + i + r + e;
        System.out.print("Skriv antal dagar du vill kolla: ");
        int dagar = sc.nextInt();*/
        double s = 2000000;
        double e = 0;
        double i = 5;
        double r = 0;
        double b = 0.4167;
        double y = 0.16666667;
        double sigma = 0.2;
        double n = s + e + i + r;
        int dagar = 100;
        
        //-------------
        
        double s_minskning;
        double i_prim = 0;
        double r_okning;
        double e_prim;
        
        for (int x = 1; x <= dagar; x++) 
        {
            s_minskning = ((-b) * i * s)/n;
            e_prim = ((double)(b* i * s)/n - (sigma*e));
            i_prim = ((double)(sigma*e)) - (y * i);
            r_okning = (y * i);
            
            s = (s + s_minskning);
            e = (e + e_prim);
            i = (i + i_prim);
            r = (r + r_okning);
            System.out.println("Utskrift---------------------- " + "DAG " + x);
            System.out.println("S': " + s_minskning);
            System.out.println("E: " + e_prim);
            System.out.println("I': " + i_prim);
            System.out.println("R': " + r_okning);
            System.out.println("S: " + s + " E: " + e + " I: " + i + " R: " + r + " I Totalt: " + (n-s));
        }
    }

}
