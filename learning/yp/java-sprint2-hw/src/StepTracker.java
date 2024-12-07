import java.util.Scanner;

class StepTracker {
    Scanner scanner;
    MonthData[] monthToData = new MonthData[12];
    Converter converter;
    int goalByStepsPerDay = 10000;

    StepTracker(Scanner scan) {
        scanner = scan;

        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    void addNewNumberStepsPerDay() {
        System.out.println("Введите номер месяца:");
        int month = scanner.nextInt();
        if (month < 1 | month > 12) {
            System.out.println("Номер вводимого месяца должен быть от 1 до 12 включительно");
            return;
        }

        System.out.println("Введите день от 1 до 30 (включительно)");
        int day = scanner.nextInt();
        if (day < 1 | day > 30) {
            System.out.println("Номер вводимого дня должен быть от 1 до 30 включительно");
            return;
        }

        System.out.println("Введите количество шагов");
        int step = scanner.nextInt();
        if (step < 1) {
            System.out.println("Количество шагов должно быть положительным числом");
            return;
        }
        MonthData monthData = monthToData[month - 1];
        monthData.days[day - 1] += step;
    }

    void changeStepGoal() {
        System.out.println("Введите новую цель по шагам за день:");
        int goalByStepsPerDayNew = scanner.nextInt();
        if (goalByStepsPerDayNew <= 0) {
            System.out.println("Цель по шагам должна быть больше 0");
            return;
        }
        goalByStepsPerDay = goalByStepsPerDayNew;
    }

    void printStatistic() {
        converter = new Converter();

        System.out.println("Введите число месяца");
        // ввод и проверка номера месяца
        int month = scanner.nextInt();
        if (month < 1 | month > 12) {
            System.out.println("Номер вводимого месяца должен быть от 1 до 12 включительно");
            return;
        }
        MonthData monthData = monthToData[month - 1]; // получение соответствующего месяца

        // вывод общей статистики по дням
        int sumSteps = monthData.sumStepsFromMonth(); // получение суммы шагов за месяц
        monthData.printDaysAndStepsFromMonth();

        // вывод суммы шагов за месяц
        System.out.println("Сумма шагов за месяц: " + sumSteps);

        // вывод максимального пройденного количества шагов за месяц
        int maxSteps = monthData.maxSteps();
        System.out.println("Максимальное количество шагов за месяц: " + maxSteps);

        // вывод среднего пройденного количества шагов за месяц
        System.out.println("Среднее количество шагов за месяц: " + sumSteps / monthData.days.length);

        // вывод пройденной за месяц дистанции в километрах
        System.out.println("Пройденная за месяц дистанция в километрах: " + converter.convertToKm(sumSteps));

        // вывод количества сожжённых килокалорий за месяц
        System.out.println("Количество сожжённых килокалорий за месяц: "
                + converter.convertStepsToKilocalories(sumSteps));

        // вывод лучшей серии
        System.out.println("Лучшая серия в днях: " + monthData.bestSeries(goalByStepsPerDay));

        System.out.println(); // дополнительный перенос строки
    }
}