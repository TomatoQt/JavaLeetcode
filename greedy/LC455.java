package greedy;

import java.util.Arrays;

public class LC455 {
    public int findContentChildren(int[] g, int[] s) {
        // g 小孩胃口
        // s 饼干大小
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        int j = s.length - 1;
        // 遍历小孩
        for (int i = g.length - 1; i >= 0; i--) {
            if (j >= 0 && g[i] <= s[j]) {
                count++;
                j--;
            }
        }

        return count;
    }
}
