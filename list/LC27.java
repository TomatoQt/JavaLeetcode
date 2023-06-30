package list;

// 移除数组内元素
public class LC27 {
    public static int removeElement(int[] nums, int val) {
        int left = 0, right = left;

        while (right < nums.length) {
            if (nums[right] != val) {
                nums[left] = nums[right];
                left++;
            }
            right++;
        }

        return left;
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
