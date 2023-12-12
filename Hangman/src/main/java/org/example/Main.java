package org.example;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import static java.lang.System.in;

public class Main {
    public static ArrayList<String> getWord() {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream("russian_nouns.txt");

        assert is != null;
        Scanner scanner = new Scanner(is, "UTF-8");
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

        System.out.println("1 - Начать игру");
        System.out.println("0 - Выйти из игры");
        Scanner scanner = new Scanner(in);
        int command = scanner.nextInt();

        while (command != 0) {
            switch (command) {
                case (1) -> {
                    Random rand = new Random();
                    int randIndex = rand.nextInt(listWord.size());
                    String word = listWord.get(randIndex);

                    String currentStateString = copies("_", word.length());
                    StringBuilder currentState = new StringBuilder(currentStateString);
                    System.out.println(word);
                    // Написать условие работы цикла
                    while (currentState.toString().contains("_")) {
                        System.out.println("Состояние виселицы:");
                        System.out.println(currentState);
                        System.out.println("Введи букву:");
                        char c = scanner.next().charAt(0);
                        String letter = String.valueOf(c);
                        System.out.println(letter);
                        if (word.contains(String.valueOf(c))) {
                            int indexToReplace = currentState.indexOf(letter);
                            System.out.println(indexToReplace);
                            currentState.setCharAt(indexToReplace, c);
                            System.out.println();
                        }
                    }
                }

                case (3) -> System.out.println("Пропустить код");
                default -> {
                }
            }
            System.out.println("Введите команду:");
            command = scanner.nextInt();
        }
    }

    public static String copies(String s, int n) {
        StringBuilder sb = new StringBuilder();
        if (n > 0) {
            int i = 0;
            while (i < n) {
                sb.append(s);
                i++;
            }
        }
        return sb.toString();
    }
}