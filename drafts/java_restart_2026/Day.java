import jdk.jfr.ValueDescriptor;

import static java.lang.Math.round;


public class Day {

    public static class VideoEntry {
        String date;
        String[] tag;
        String description;
        int rating;

        VideoEntry(String date, String[] tag, String description, int rating) {
            this.date = date;
            this.tag = tag;
            this.description = description;
            this.rating = rating;
        }

    }

    static void printCurrentPercent(int year, int day, int month) {
        double current_percent = round((30.0 * month + day) * 10000 / year) / 100.0;
        System.out.println("Текущий прогресс = " + current_percent + "%");

        for (int i = 1; i < 5; i++) {
            System.out.println("счетчик равен = " + i);
        }
        if (current_percent > 40 && current_percent <= 95) {
            System.out.println("Good result");
        } else if (current_percent > 95) {
            System.out.println("done");
        } else {
            System.out.println("Старайся больше");
        }
    }

    static void printFromArray(String[] array) {
        System.out.println();
        for (String iter : array) {
            if (iter.length() > 5) {
                System.out.println(iter);
            }
        }
    }

    public static void main(String[] args) {

        System.out.println("YOUUUU");

        int year = 365;
        int day = 15;
        int month = 5;

        printCurrentPercent(year, day, month);


        String[] tags = {"city", "football", "work", "friends", "travel"};

        printFromArray(tags);


        VideoEntry object = new VideoEntry("2026-05-19", tags, "Something here", 100);


        System.out.println();

        System.out.println(object.date);
        System.out.println(object.rating);
        System.out.println(object.tag[0]);
        System.out.println(object.description);

    }
}
