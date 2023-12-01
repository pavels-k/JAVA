import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class App {

    public static void main(String[] args) {

        PrintStream out = System.out;
        out.println(Integer.toBinaryString(25));


        Map<String, String> books = new HashMap<>();
        books.put("Война и мир", "Лев Толстой");
        books.put("Преступление и наказание", "Федор Достоевский");
        books.put("Философия Java", "Брюс Эккель");
        books.put("Братья Карамазовы", "Федор Достоевский");
        books.put("Властелин Колец", "Джон Толкин");
        books.forEach((a,b) -> out.println("Название книги: " + a + ". Автор: " + b));

        try
        {
            int d = 2/0;
        }
        catch(Exception except)
        {
            System.out.println("Перехватили исключение");
//            throw except;
        }
        File file = new File("dakl");

        try{
            Scanner scanner = new Scanner(file);
            System.out.println("После Scanner");
        } catch (FileNotFoundException e) {
            System.out.println("Ошибочка))");
        }
        System.out.println("ыыы");
    }

    // new class
    public static class Pair {
        int x, y;

        public void swap() {
            int xor = x ^ y;
            x = xor & y;
            y = xor & x;
        }
    }
}


