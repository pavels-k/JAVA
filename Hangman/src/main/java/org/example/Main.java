package org.example;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

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

    public static void printGame() {
        System.out.println("Введите команду:\n");
        System.out.println("1 - Начать игру");
        System.out.println("0 - Выйти из игры");
    }

    // toDo: Нужно доделать условие проигрыша и состояние виселицы
    public static void main(String[] args) {
        ArrayList<String> listWord = getWord();

        printGame();

        String os = System.getProperty("os.name");
        String encoding;
        if (os.equals("Mac OS X"))
            encoding = "UTF-8";
        else
            encoding = "866";
        Scanner scanner = new Scanner(System.in, encoding);

        int command = scanner.nextInt();

        while (command != 0) {
            switch (command) {
                case (1) -> {
                    Random rand = new Random();
                    int randIndex = rand.nextInt(listWord.size());
                    String strartWord = listWord.get(randIndex);
                    StringBuilder word = new StringBuilder(strartWord);

                    String currentStateString = copies("_", word.length());
                    StringBuilder currentState = new StringBuilder(currentStateString);
                    StringBuilder stepHangman = new StringBuilder(copies("o", 5));
                    int countMistake = 0;
                    // Написать условие работы цикла
                    while (currentState.toString().contains("_") & (countMistake < 5)) {
                        System.out.println("Загаданное слово:");
                        System.out.println(currentState);
                        System.out.println("\nВведите букву:");

                        char c = scanner.next().charAt(0);

                        String letter = String.valueOf(c);

                        if (word.toString().contains(String.valueOf(c))) {
                            System.out.println("БИНГО!\n");

                            int indexToReplace = word.indexOf(letter);
                            while (indexToReplace >= 0) {

                                currentState.setCharAt(indexToReplace, c);
                                word.setCharAt(indexToReplace, '_');
                                // System.out.println(word);

                                indexToReplace = word.indexOf(letter, indexToReplace + 1);
                            }

                        } else {
                            System.out.println("МИМО!\n");

                            stepHangman.setCharAt(countMistake, 'x');

                            countMistake++;
                        }
                        System.out.println("Состояние виселицы:");

                        System.out.println(stepHangman);

                        System.out.println();
                    }
                    if (stepHangman.toString().contains("o")) {
                        System.out.println("Вы выжили!\n");
                    } else {
                        System.out.println("Вы сдохли!\n");
                        System.out.println("Ну а правильное слово: " + strartWord + "\n");

                    }
                }

                case (3) -> System.out.println("Пропустить код");
                default -> {
                }
            }
            printGame();
            command = scanner.nextInt();
        }
        scanner.close();
    }
}