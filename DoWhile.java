import java.util.Scanner;

public class DoWhile {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String s;
        do{
            s = console.nextLine();
        } while(!s.equals("exit"));
        double a = -5.9;
        System.out.println((int)(a));
    }
    

}