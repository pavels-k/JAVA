import java.util.Scanner;

class Praktikum {
    public static void main(String[] args) {
        double[] expenses = {100.50, 500.00, 10.00, 0.0, 40.60, 500.10, 200.00};

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Расходы за неделю хранятся под индексами от 0 (пн) до 6 (вс).");
            System.out.println("Введите индекс дня, траты за который вы хотите отредактировать:");

            // Объявите переменную, которая будет хранить индекс выбранного элемента
            int index = scanner.nextInt();

            System.out.println("Введите новую сумму трат за этот день:");
            // Объявите переменную, в которой будет сохранено новое значение трат за выбранный день
            double newExpense = scanner.nextDouble();

            // Замените значение элемента с нужным индексом на новое
            expenses[index] = newExpense;
            System.out.println("За день с индексом " + index + " размер трат теперь " + expenses[index]);
        }
    }
}