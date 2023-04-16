import java.util.Scanner;
import java.io.*;

public class My {
    public static void main(String[] args){
        double[] expenses = {100.50, 500.00, 10.00, 0.0, 40.60, 500.10, 200.00};
        

        Scanner scanner = new Scanner(System.in);
        String input = System.console().readLine();
        System.out.println("Расходы бла бла бла");

        // Объявляем перемнную
        int index = scanner.nextInt();

        // Объявим переменную
        double newExpense = scanner.nextDouble();

        // Заменим значение элемента
        expenses[index] = newExpense;
        System.out.println("За день с индексом " + index + " размер трат теперь " + expenses[index]);
    }
}
