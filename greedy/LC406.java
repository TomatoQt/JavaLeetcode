package greedy;

import java.util.*;

public class LC406 {
    public int[][] reconstructQueue(int[][] people) {
        Comparator<int[]> comp = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) { // 身高相同，让第二个数字小的在前
                    return Integer.compare(o1[1], o2[1]);
                } else
                    return Integer.compare(o2[0], o1[0]);
            }
        };

        PriorityQueue<int[]> pq = new PriorityQueue<>(comp);

        pq.addAll(Arrays.asList(people));

        List<int[]> list = new LinkedList<>();

        // 按照身高降序排列
        while (!pq.isEmpty()) {
            int[] item = pq.poll();
            list.add(item);
        }

        for (int[] item : list)
            System.out.println(item[0] + " " + item[1]);

        List<int[]> res = new LinkedList<>();

        // 用list去插入res
        for (int[] item : list)
            res.add(item[1], item);

        int[][] result = new int[res.size()][2];
        for (int i = 0; i < res.size(); i++)
            result[i] = res.get(i);

        return result;
    }
}
