package backtrack;

import java.util.*;

public class LC131 {
    public boolean judgeReversal(String s) {
        int len = s.length();
        // left, right时刻同步变化，所以写在for条件里面
        for (int left = 0, right = len - 1;left <= right ; left++, right--) {
            if (s.charAt(left) != s.charAt(right))
                return false;
        }

        return true;
    }

    private List<String> path;
    private List<List<String>> result;

    public void partHelper(String s, int startIndex) { // before, not included
        if (startIndex >= s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {
            String subStr = s.substring(startIndex, i + 1); // [startIndex, i + 1)
            path.add(subStr);
            if (judgeReversal(subStr))
                partHelper(s, i + 1);
            path.remove(path.size() - 1);
        }
    }

    public List<List<String>> partition(String s) {
        path = new ArrayList<>();
        result = new ArrayList<>();
        partHelper(s, 0);

        return result;
    }
}
