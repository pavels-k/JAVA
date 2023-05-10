import java.util.Scanner;

/*
Максимальное из N чисел
*/

public class Jr {
    public static int[] array;

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner console = new Scanner(System.in);
        int N  = console.nextInt();
        array = new int[N];
        for(int i=0; i<array.length; i++){
            array[N] = console.nextInt();
        }
        int max = array[0];
        for(int i=1; i<array.length; i++){
            if(max>array[i]){
                max = array[i];
            }
        System.out.println(max);
        }
    }   
}