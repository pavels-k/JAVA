import java.util.ArrayList;
import java.util.Arrays;

import static java.lang.Math.round;


public class Day {

    enum Tag {
        CITY,
        FOOTBALL,
        WORK,
        FRIENDS,
        TRAVEL,
        SPORT
    }

    public static class DiaryEntry {
        String date;
        String description;
    }


    public static class PhotoEntry extends DiaryEntry {
        int iso;
        double shutter;
        int f;
    }


    public static class VideoEntry extends DiaryEntry {
        String date;
        Tag[] tags;
        String description;
        int rating;

        VideoEntry(String date, Tag[] tags, String description, int rating) {
            this.date = date;
            this.tags = tags;
            this.description = description;
            this.rating = rating;
        }

        void printInfo() {
            System.out.println(this.date);
            System.out.println(Arrays.toString(this.tags));
            System.out.println(this.description);
            System.out.println(this.rating);
        }
    }

    static void printByTag(ArrayList<VideoEntry> entries, Tag tag) {
        for (VideoEntry entry : entries) {
            for (Tag itemTag : entry.tags) {
                if (itemTag == tag) {
                    entry.printInfo();
                }
            }
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

    static void printFromArray(Tag[] array) {
        System.out.println();
        for (Tag iter : array) {
            if (iter.name().length() > 5) {
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


        Tag[] tags = {Tag.CITY, Tag.FOOTBALL, Tag.WORK, Tag.SPORT};
        // Или Tag[] tags = Tag.values();

        printFromArray(tags);


        ArrayList<VideoEntry> entries = new ArrayList<>();

        entries.add(new VideoEntry("2026-05-19", tags, "Something here", 100));
        System.out.println(entries.get(0).date);

        entries.get(0).printInfo();

        printByTag(entries, Tag.FOOTBALL);
    }
}
