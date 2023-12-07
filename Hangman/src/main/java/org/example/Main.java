package org.example;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.in;

public class Main {
    public static void getWord() {
//            BufferedReader reader = new BufferedReader(new FileReader("russian_nouns.txt"));
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream("russian_nouns.txt");

        Scanner s = new Scanner(is);
        ArrayList<String> list = new ArrayList<String>();
        while (s.hasNext()) {
            list.add(s.next());
        }
        System.out.println(list.get(0));
        s.close();
    }

    public static void main(String[] args) {
        getWord();
        System.out.println("Введите команду:");
        Scanner scanner = new Scanner(in);
        int command = scanner.nextInt();

        while (command != 0) {
            switch (command) {
                case (0):
                    break;
                default:
                    break;

            }
            command = scanner.nextInt();
        }
    }
}