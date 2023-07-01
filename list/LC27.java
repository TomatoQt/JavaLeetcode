package list;

// 移除数组内元素
public class LC27 {
    public static int removeElement(int[] nums, int val) {
        int slowIndex = 0;

        for (int fastIndex = 0; fastIndex < nums.length; fastIndex++) {
            if (nums[fastIndex] != val) {
                nums[slowIndex] = nums[fastIndex];
                slowIndex++;
            }
        }

        return slowIndex;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
        int val = 2;

        int newLength = removeElement(nums, val);

        System.out.format("list length: %d\n", newLength);

        for (int i = 0; i < newLength; i++) {
            System.out.println(nums[i]);
        }
    }
}
