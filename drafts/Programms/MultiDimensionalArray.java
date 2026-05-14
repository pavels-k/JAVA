import java.util.Scanner;

/* 
Создаем двумерный массив
*/

public class MultiDimensionalArray {
    public static int[][] multiArray;

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int n = console.nextInt();

        multiArray = new int[n][];
        for (int i = 0; i < multiArray.length; i++) {
            int m = console.nextInt();

            multiArray[i] = new int[m];
        }
    }
}
