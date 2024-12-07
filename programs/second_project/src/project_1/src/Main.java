import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static String readFileContentsOrNull(String path) {
        try {
            return Files.readString(Path.of(path));
        } catch (IOException e) {
            System.out.println("Невозможно считать файл");
            return null;
        }
    }

    public static ArrayList<String> data = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final String dir = System.getProperty("user.dir");


        System.out.println("Введите команду:");
        int userInput;
        do {
            userInput = scanner.nextInt();
            switch (userInput) {
                case 1 -> {
                    for (int i = 1; i <= 3; i++) {
                        String fileContents = readFileContentsOrNull(dir + "\\src\\data\\m.20210" + i + ".csv");
                        assert fileContents != null;
                        data.add(fileContents);
                    }
                }
                case 4 -> {
                    System.out.println(data.get(1));
                    for (String datum : data) {
                        String[] lines = datum.split("\\n");
                        for (String line : lines) {
                            String[] lineContents = line.split(",");
                            System.out.println(Arrays.toString(lineContents));
                        }
//                        System.out.println(Arrays.toString(lines));
                        System.out.println(lines[0]);
                        break;
                    }
                }
            }
        } while (userInput != 9);
    }
}












