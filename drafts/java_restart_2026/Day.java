public class Day {
    public static void main(String[] args) {
        System.out.println("YOUUUU");

        int year = 365;
        int day = 15;
        int month = 5;

        double current_percent = round((30.0 * month + day) * 100 / year, 2);
        System.out.println("Текущий прогресс = " + current_percent + "%");


        for (int i = 1; i < 5; i++) {
            System.out.println("счетчик равен = " + i);
        }
    }

    public static double round(double value, int places) {
        if (places < 0) {
            throw new IllegalArgumentException("places must be non-negative");
        }
        long factor = (long) Math.pow(10, places);
        return Math.round(value * factor) / (double) factor;
    }
}
