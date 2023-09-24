package greedy;

import java.util.ArrayList;
import java.util.List;

public class LC763 {
    public List<Integer> partitionLabels(String s) {
        int[] hash = new int[27];
        hash[0] = 0;

        for (int i = 0; i < s.length(); i++)
            hash[s.charAt(i) - 'a'] = i;

        List<Integer> result = new ArrayList<>();

        int left = 0, right = 0;
        for (int i = 0; i < s.length(); i++) {
            right = Math.max(right, hash[s.charAt(i) - 'a']);
            if (i == right) {
                result.add(right - left + 1);
                left = i + 1;
            }
        }

        return result;
    }
}
