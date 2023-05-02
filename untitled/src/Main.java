import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        System.out.println("Hello and welcome!");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите число:");
        int age = scanner.nextInt();

        System.out.println("Ваш возраст: " + age);
        if (age >= 18 && age <= 65)
            System.out.println("Пора на работу");
        else
            System.out.println("Не пора на работу");
    }
}