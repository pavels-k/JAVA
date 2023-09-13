import java.util.Scanner;
import java.util.Arrays;
import java.time.LocalDate;
import org.apache.commons.lang3.StringUtils;
import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {

        System.out.println(lengthOfLongestSubstring("~^!@^#$^%%^$^#^&|^|"));

    }

    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLength = 0;
        int[] charIndex = new int[128];
        Arrays.fill(charIndex, -1);
        int left = 0;

        for (int right = 0; right < n; right++) {
            if (charIndex[s.charAt(right)] >= left) {
                left = charIndex[s.charAt(right)] + 1;
            }

            charIndex[s.charAt(right)] = right;
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}