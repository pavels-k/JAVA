package org.example;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
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
            String word = scanner.next();
            if (word.length() >= 5) {
                listWords.add(word);
            }
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
                    final int countTry = 7;
                    StringBuilder stepHangman = new StringBuilder(copies("o", countTry));
                    int countMistake = 0;
                    HashSet<String> usedLetters = new HashSet<>();

                    while (currentState.toString().contains("_") & (countMistake < countTry)) {
                        System.out.println("Загаданное слово:");
                        System.out.println(currentState);
                        System.out.println("\nВведите букву:");
                        char c = 's';
                        c = Character.toLowerCase(scanner.next().charAt(0)); // Character.toLowerCase(

                        while (!Character.UnicodeBlock.of(c).equals(Character.UnicodeBlock.CYRILLIC)
                                | usedLetters.contains(String.valueOf(c))) {
                            if (usedLetters.contains(String.valueOf(c))) {
                                System.out.println("\nЭта буква, уже использовалась! Введите другую:");
                            } else {
                                System.out.println("\nЭто не кириллица! Введите букву кириллицы: ");
                            }

                            c = Character.toLowerCase(scanner.next().charAt(0)); // Character.toLowerCase(
                        }

                        String letter = String.valueOf(c);
                        usedLetters.add(letter);
                        if (word.toString().contains(String.valueOf(c))) {
                            System.out.println("БИНГО!\n");

                            int indexToReplace = word.indexOf(letter);
                            while (indexToReplace >= 0) {

                                currentState.setCharAt(indexToReplace, c);
                                word.setCharAt(indexToReplace, '_');

                                indexToReplace = word.indexOf(letter, indexToReplace + 1);
                            }

                        } else {
                            System.out.println("МИМО!\n");

                            stepHangman.setCharAt(countMistake, 'x');

                            countMistake++;
                        }
                        System.out.println("Использованные буквы:");

                        System.out.println(usedLetters.toString());

                        System.out.println("\nСостояние виселицы:");

                        System.out.println(stepHangman);

                        System.out.println();
                    }
                    if (stepHangman.toString().contains("o")) {
                        System.out.println("Миссия выполнена!\n");
                    } else {
                        System.out.println("Потрачено!\n");
                        System.out.println("Ну а правильное слово: " + strartWord + "\n");

                    }
                }
            }
            printGame();
            command = scanner.nextInt();
        }
        scanner.close();
    }
}