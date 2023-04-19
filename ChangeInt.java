import java.util.Scanner;

public class ChangeInt {
    public static void main(String[] args) {
        String a = "44";
        int x = Integer.parseInt(a);
        System.out.println(x);
        String name = "Rom";
        System.out.println(name);
        String name2 = name.toLowerCase();
        System.out.println(name2);

        Scanner console = new Scanner(System.in);
        String line = console.nextLine();
        int age = console.nextInt();
        System.out.println("Name: " + line);
        System.out.println("Age: " + age);

    }
}