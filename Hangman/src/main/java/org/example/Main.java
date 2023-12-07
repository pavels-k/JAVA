package org.example;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.in;

public class Main {
    public static ArrayList<String> getWord() {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream("russian_nouns.txt");

        assert is != null;
        Scanner scanner = new Scanner(is);
        ArrayList<String> listWords = new ArrayList<>();
        while (scanner.hasNext()) {
            listWords.add(scanner.next());
        }
        scanner.close();
        return listWords;
    }

    public static void main(String[] args) {
        ArrayList<String> listWord = getWord();
        System.out.println(listWord.get(0));

        System.out.println("Введите команду:");
        Scanner scanner = new Scanner(in);
        int command = scanner.nextInt();

        while (command != 0) {
            switch (command) {
                case (1) -> System.out.println("Введи букву");
                case (3) -> System.out.println("Пропустить код");
                default -> {
                }
            }
            command = scanner.nextInt();
        }
    }
}