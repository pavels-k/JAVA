import java.util.Scanner;
import java.lang.Math;

public class WhileApp {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int max = 0;
        while (console.hasNextInt()) {
            int x = console.nextInt();
            if (x > max)
                max = x;
        }
        System.out.println(max);
        int m = (int) Math.round(4.1);
        System.out.println(m);
        System.out.println(Math.max(Double.NaN, 3));
        double b = 0.000000001;
        System.out.println(b);
    }
}