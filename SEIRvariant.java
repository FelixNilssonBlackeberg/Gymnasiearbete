package gymnasiearbete;

public class SEIRvariant {

    public static void main(String[] args) {
        
        //Startvärden
        double s = 2000000;
        double e = 5;
        double i = 5;
        double r = 0;
        double b = 0.4167;
        double y = 0.16666667;
        double a = 0.2;
        double my = 0.006;
        double n = s + e + i + r;
        int dagar = 50;
        //-------------
        
        double s_minskning;
        double i_prim = 0;
        double r_okning;
        double e_prim;
        
        for (int x = 1; x <= dagar; x++) 
        {
            s_minskning = (my * n) - (my * s) - (b * i * s)/n;
            e_prim = ((double)(b* i * s)/n - ((my + a)*e));
            i_prim = (a * e) - ((y + my)*i);
            r_okning = (y * i) - (my * r);
            
            s = (s + s_minskning);
            e = (e + e_prim);
            i = (i + i_prim);
            r = (r + r_okning);
            System.out.println("Utskrift---------------------- " + "DAG " + x);
            System.out.println("S': " + s_minskning);
            System.out.println("E: " + e_prim);
            System.out.println("I': " + i_prim);
            System.out.println("R': " + r_okning);
            System.out.println(" S: " + s + " E: " + e + " I: " + i + " R: " + r);
        }
    }
    
}
