import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        System.out.println(jump(new int[]{4,1,8,1,0,1}));
    }

    public static int jumpFrom(int[] nums, int index, int minimumJump, int countJump, Set<Integer> indexJumped) {
        countJump = countJump + 1;
        if (index >= nums.length - 1) {
            return Math.min(countJump, minimumJump);
        } else {
            for (int i = 1; i <= nums[index]; i++) {
                if (!indexJumped.contains(index + i)) {
                    minimumJump = jumpFrom(nums, index + i, minimumJump, countJump, indexJumped);
                }
            }
            indexJumped.add(index);
        }
        return minimumJump;
    } // [2,3,1,1,4]

    public static int jump(int[] nums) {
        int countJump = -1;
        int minimumJump = Integer.MAX_VALUE;
        Set<Integer> indexJumped = new HashSet<Integer>();
        return jumpFrom(nums, 0, minimumJump, countJump, indexJumped);
    }
}
