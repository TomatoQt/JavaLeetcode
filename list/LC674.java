package list;

public class LC674 {
    public int findLengthOfLCIS(int[] nums) {
        // 数组只有1个元素，不好处理，提前筛除
        if (nums.length == 1)
            return 1;

        int left = 0, right = left + 1;
        int maxL = 1;

        // 一次遍历找到结果
        // 用right作为终止条件
        while (right < nums.length) {
            // 比上一个数大，说明连续递增，视情况更新maxL
            if (nums[right] > nums[right - 1])
                maxL = Math.max(maxL, right - left + 1);
            // 不如上一个数大或相等，调整子序列
            else
                left = right;
            right++;
        }

        return maxL;
    }
}
