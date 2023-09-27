package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC56 {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1)
            return intervals;

        Arrays.sort(intervals, (o1, o2) -> Integer.compare(o1[0], o2[0]));

        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] cur = intervals[i];
            int[] pre = res.get(res.size() - 1);
            if (cur[0] <= pre[1])
                pre[1] = Math.max(pre[1], cur[1]);
            else
                res.add(cur);
        }

        return res.toArray(new int[res.size()][]);
    }
}
