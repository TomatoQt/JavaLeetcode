package backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LC216 {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public void combineHelper(int k, int n, int start, int sum) {
        if (path.size() == k && sum == n) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i <= 9; i++) {
            path.add(i);
            combineHelper(k, n, i + 1, sum + i);
            path.removeLast();
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        combineHelper(k, n, 1, 0);
        return result;
    }
}
