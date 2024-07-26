import org.apache.commons.lang3.StringUtils;

public class App {

    private static boolean isLeapYear(int year) {
        if ((year % 400 == 0) || ((year % 100 != 0) && (year % 4 == 0))) {
            return true;
        }
        return false;
    }

    public static String convertString(String word) {
        if (Character.isUpperCase(word.charAt(0))) {
            return StringUtils.reverse(word);
        }
        return word;
    }

    public static void main(String[] args) {
        System.out.println(isLeapYear(2016));
        System.out.println(isLeapYear(2023));
    }
}
