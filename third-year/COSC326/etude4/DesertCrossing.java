import java.sql.Array;
import java.util.ArrayList;

public class DesertCrossing {
    static double d = 3226; //distance between start and end
    static double x = 0; //current distance (x = 0 at start, x = d at end)
    static double c = 1680; //distance vehicle can travel with full tank
    static int denom = 3; //fraction denominator
    static int s = 1; //stop number
    static ArrayList<Stop> stops = new ArrayList<Stop>();

    public static void main(String[] args){
        System.out.println("Start. d = " + d);
        drive();
    }

    public static void drive(){
        if (d <= 0) return;
        if (s == 1) {
            d -= c;// * (1/(double)denom);
            System.out.println("Fuel cache = " + s + " d = " + d);
            //stops.add(new Stop(s, d, c * (s / (double) denom)));
            s++;
        }else {
            d -= c * (1/(double)denom);
            System.out.println("Fuel cache = " + s + " d = " + d);
            //stops.add(new Stop(s, d, c * (s / (double) denom)));
            denom++;
            s++;
        }
        drive();
    }
}