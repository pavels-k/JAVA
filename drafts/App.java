import org.apache.commons.lang3.StringUtils;

public class App {

    private static boolean isLeapYear(int year) {
        if ((year % 400 == 0) || ((year % 100 != 0) && (year % 4 == 0))) {
            return true;
        }
        return false;
    }

    public static String convertString(String word) {
        if (word.length() == 0) {
            return word;
        } else if (Character.isUpperCase(word.charAt(0))) {
            return word;
        }
        return StringUtils.reverse(word);
    }

    public static String getNumberExplanation(Integer number) {
        switch (number) {
            case 666:
                return "devil number";
            case 42:
                return "answer for everything";
            case 7:
                return "prime number";
            default:
                return "just number";
        }
    }

    public static void printNumbers(Integer number) {
        while (number > 0) {
            System.out.println(number);
            number -= 1;
        }
        System.out.println("finished!");
    }

    public static String joinNumbersFromRange(int start, int finish) {
        // BEGIN (write your solution here)
        int i = start;
        String result = "";
        while (i <= finish) {
            result += i;
            i += 1;
        }
        return result;
        // END
    }


    public static void main(String[] args) {

        //        printNumbers(4);
        System.out.println(joinNumbersFromRange(1, 2));

    }
}
