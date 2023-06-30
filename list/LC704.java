package list;

// 二分法查找有序数组内元素
public class LC704 {
    public static int search(int[] nums, int target) {
        // 避免target小于nums[0]，大于nums[nums.length-1]时参与运算
        if (target < nums[0] || target > nums[nums.length - 1]) {
            return -1;
        }

        // 定义区间范围
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            // 中间位置
            int mid = left + (right -left) / 2; // 避免大数相加导致溢出
            if(nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                left = mid + 1;
            else if (nums[mid] > target)
                right = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 3, 4, 5};
        int target = 0;

        System.out.println(search(nums, target));
    }
}
