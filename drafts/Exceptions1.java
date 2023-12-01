import java.util.Scanner;

public class Exceptions1 {
    public static void main(String[] args) throws ScannerExceprion {
        Scanner scanner = new Scanner(System.in);
        while(true){
            int i = Integer.parseInt(scanner.nextLine());
            if (i != 0){
                throw new ScannerExceprion("ыыыыы4");
            }
        }

    }
}
