package greedy;

public class LC45 {
    public int jump(int[] nums) {
        if (nums.length == 1) return 0;
        int curEnd = 0; // 当前可达
        int nextEnd = 0; // 下一步可达
        int result = 0; // 记录结果

        for (int i = 0; i < nums.length; i++) {
            nextEnd = Math.max(nextEnd, i + nums[i]);
            if (i == curEnd) { // 走到当前可达的极限
                result++; // 必须走一步
                curEnd = nextEnd; // 更新curEnd
                if (nextEnd >= nums.length - 1) break;
            }
        }

        return result;
    }
}
