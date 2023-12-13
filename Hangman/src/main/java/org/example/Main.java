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


    public static void printGame(){
        System.out.println("Введите команду:");
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
                    StringBuilder word = new StringBuilder(listWord.get(randIndex));

                    String currentStateString = copies("_", word.length());
                    StringBuilder currentState = new StringBuilder(currentStateString);
                    System.out.println(word);
                    StringBuilder stepHangman = new StringBuilder(copies("_", 5));
                    int countMistake = 0;
                    // Написать условие работы цикла
                    while (currentState.toString().contains("_")) {
                        System.out.println("Загаданное слово:");
                        System.out.println(currentState);
                        System.out.println("Введи букву:");

                        char c = scanner.next().charAt(0);

                        String letter = String.valueOf(c);
                        System.out.println(letter);

                        if (word.toString().contains(String.valueOf(c))) {
                            int indexToReplace = word.indexOf(letter);
                            while (indexToReplace >= 0) {

                                System.out.println(indexToReplace);
                                currentState.setCharAt(indexToReplace, c);
                                word.setCharAt(indexToReplace, '_');
                                System.out.println(word);

                                indexToReplace = word.indexOf(letter, indexToReplace + 1);
                            }

                        } else {
                            System.out.println("Состояние виселицы:");
                            stepHangman.setCharAt(countMistake, 'x');
                            countMistake++;
                        }

                    }
                }

                case (3) -> System.out.println("Пропустить код");
                default -> {
                }
            }
            printGame();
            command = scanner.nextInt();
        }
    }
}