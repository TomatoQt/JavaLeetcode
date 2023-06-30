package list;

// 有序数组平方
public class LC977 {
    public static int[] sortedSquares(int[] nums) {
        int len = nums.length;
        int left = 0, right = len - 1;

        int[] res = new int[len];
        int res_index = len - 1;

        while (left <= right && res_index >= 0) {
            int sq_left = nums[left] * nums[left];
            int sq_right = nums[right] * nums[right];

            // 选大的，写入res数组
            if (sq_left > sq_right) {
                res[res_index--] = sq_left;
                left++;
            } else {
                res[res_index--] = sq_right;
                right--;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-2,-1,0,3};

        int[] output = sortedSquares(nums);

        for (int i = 0; i < output.length; i++) {
            System.out.println(output[i]);
        }
    }
}
