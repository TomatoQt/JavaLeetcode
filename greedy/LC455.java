package greedy;

import java.util.Arrays;

public class LC455 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int satisfied = 0;
        int s_index = s.length - 1;
        for(int g_index = g.length - 1; g_index >= 0 && s_index >= 0; g_index--) {
            int cookieSize = s[s_index];
            if (cookieSize >= g[g_index]) {
                satisfied++;
                s_index--;
            }
        }

        return satisfied;
    }
}
