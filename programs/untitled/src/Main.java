import java.util.*;

public class Main {

    public static void main(String[] args) {

        System.out.println("Hello!");

        System.out.println(jump(new int[]{2, 3, 1, 0, 0, 1, 4}));
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

    /*
     * public static int jump(int[] nums) {
     * int countJump = -1;
     * int minimumJump = Integer.MAX_VALUE;
     * Set<Integer> indexJumped = new HashSet<Integer>();
     * return jumpFrom(nums, 0, minimumJump, countJump, indexJumped);
     * }
     */

    public static boolean canJump(int[] nums) {
        Deque<Integer> index_queue = new LinkedList<>();
        ArrayList<Integer> searched_index = new ArrayList<>();
        index_queue.add(0);
        int purpose = nums.length - 1;
        int index;

        HashMap<Integer, Integer> dict = new HashMap<>();

        ArrayList<Integer> toSort = new ArrayList<>();
        while (!index_queue.isEmpty()) {
            index = index_queue.pop(); // извлечение
            if (nums[index] + index < purpose) {
                searched_index.add(index);
                for (int i = nums[index]; i > 0; i--) {
                    if (!searched_index.contains(index + i)) {
                        // index_queue.add(index + i); // добавление
                        toSort.add(index + i);
                    }
                }
                Collections.sort(toSort);
                for (int j = toSort.size() - 1; j >= 0; j--) {
                    index_queue.add(toSort.get(j));
                }
                toSort.clear();
            } else {
                return true;
            }
        }
        return false;
    }

    public static int jump(int[] nums) {
        int ans = 0;
        int end = 0;
        int farthest = 0;
        // Implicit BFS
        for (int i = 0; i < nums.length - 1; ++i) {
            farthest = Math.max(farthest, i + nums[i]);
            if (farthest >= nums.length - 1) {
                ++ans;
                break;
            }
            if (i == end) {   // Visited all the items on the current level
                ++ans;          // Increment the level
                end = farthest; // Make the queue size for the next level
            }
        }
        return ans;
    }X
}
