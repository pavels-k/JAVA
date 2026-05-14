import java.util.Scanner;

public class ScannerMy {
    public static void main(String[] args){
        try (Scanner console = new Scanner(System.in)) {
            String name = console.nextLine();
            int age = console.nextInt();
            System.out.println(name + age);
        }
    }
}
