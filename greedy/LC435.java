package greedy;

import java.util.Arrays;

public class LC435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> Integer.compare(o1[0], o2[0]));

        int count = 0;

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < intervals[i - 1][1]) {
                count++;
                intervals[i][1] = Math.min(intervals[i][1], intervals[i - 1][1]);
            }
        }

        return count;
    }
}
