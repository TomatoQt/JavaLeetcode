package greedy;

public class LC376 {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length == 1)
            return 1;
        if (nums.length == 2 && nums[0] != nums[1])
            return 2;

        int preDiff = 0;
        int curDiff = 0;
        int result = 1;
        for (int i = 0; i + 1 < nums.length; i++) {
            if (nums[i] == nums[i + 1])
                continue;
            curDiff = nums[i + 1] - nums[i];
            if (preDiff >= 0 && curDiff < 0 || preDiff <= 0 && curDiff > 0)
                result++;
            preDiff = curDiff;
        }

        return result;
    }
}
