package greedy;

public class LC55 {
    public boolean canJump(int[] nums) {
        // 用于记录最大可达位置
        int coverLoc = -1;
        for (int i = 0; i < nums.length; i++) {
            // 不是第一次启动循环，遍历到了不可能到达的位置
            if (coverLoc != -1 && i > coverLoc)
                return false;
            // 先判定，再更新最大可达位置
            coverLoc = Math.max(coverLoc, i + nums[i]);
        }

        return true;
    }
}
