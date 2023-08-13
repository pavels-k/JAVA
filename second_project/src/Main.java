import javax.print.DocFlavor;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        int a = 2;
        int b = 3;
        int min = a < b ? a : b;
        System.out.println(min);

        String s1 = "Привет";
        String s2 = "ПРИВЕТ";
        String s3 = s1.toUpperCase();

        System.out.println(s1.equals(s2));
        System.out.println(s2.equals(s3));
        System.out.println(s1.equalsIgnoreCase(s2));
        printer("dwa", 4);
    }
    public static void  printer(String s, int n){
        StringBuilder result = new StringBuilder(s);
        for(int i = 0; i < n; i++){
            result.append(" ").append(s);
        }
        System.out.println(result);
    }
}