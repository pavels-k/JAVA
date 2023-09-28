import java.util.*;


public class Main {


    public static void main(String[] args) {
        System.out.println(canJump(new int[]{8, 2, 4, 4, 4, 9, 5, 2, 5, 8, 8, 0, 8, 6, 9, 1, 1, 6, 3, 5, 1, 2, 6, 6, 0, 4, 8, 6, 0, 3, 2, 8, 7, 6, 5, 1, 7, 0, 3, 4, 8, 3, 5, 9, 0, 4, 0, 1, 0, 5, 9, 2, 0, 7, 0, 2, 1, 0, 8, 2, 5, 1, 2, 3, 9, 7, 4, 7, 0, 0, 1, 8, 5, 6, 7, 5, 1, 9, 9, 3, 5, 0, 7, 5}));
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
    public static int jump(int[] nums) {
        int countJump = -1;
        int minimumJump = Integer.MAX_VALUE;
        Set<Integer> indexJumped = new HashSet<Integer>();
        return jumpFrom(nums, 0, minimumJump, countJump, indexJumped);
    }
    */

    public static boolean canJump(int[] nums) {
        Deque<Integer> index_queue = new LinkedList<>();
        ArrayList<Integer> searched_index = new ArrayList<>();
        index_queue.add(0);
        int purpose = nums.length - 1;
        int index;
        ArrayList<Integer> toSort = new ArrayList<>();
        while (!index_queue.isEmpty()) {
            index = index_queue.pop(); // извлечение
            if (nums[index] + index < purpose) {
                searched_index.add(index);
                for (int i = nums[index]; i > 0; i--) {
                    if (!searched_index.contains(index + i)) {
                        //index_queue.add(index + i); // добавление
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
}










