import java.util.Scanner;

public class IfMy {
    public static void main(String[] args){
        try (Scanner console = new Scanner(System.in)) {
            int age = console.nextInt();
            if (age > 18)
                System.out.println("Можно купить");
            else
                System.out.println("Нельзя");
        }
    }
}
            