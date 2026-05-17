import static java.lang.Math.round;
import static java.lang.Math.tan;

public class Day {
    public static void main(String[] args) {
        System.out.println("YOUUUU");

        int year = 365;
        int day = 15;
        int month = 5;

        double current_percent = round((30.0 * month + day) * 10000 / year) / 100.0;
        System.out.println("Текущий прогресс = " + current_percent + "%");

        for (int i = 1; i < 5; i++) {
            System.out.println("счетчик равен = " + i);
        }
        if (current_percent > 40) {
            System.out.println("Good result");
        } else if (current_percent > 95) {
            System.out.println("done");
        } else {
            System.out.println("Старайся больше");
        }


        String[] tags = {"city", "football", "work", "friends", "travel"};


        System.out.println();
        for (String tag : tags) {
            if (tag.length() > 5) {
                System.out.println(tag);
            }
        }
    }

}
