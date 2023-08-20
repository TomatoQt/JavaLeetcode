package Stack_Queue;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LC347 {
    /*Comparator接口说明:
     * 返回负数，形参中第一个参数排在前面；返回正数，形参中第二个参数排在前面
     * 对于队列：排在前面意味着往队头靠
     * 对于堆（使用PriorityQueue实现）：从队头到队尾按从小到大排就是最小堆（小顶堆），
     *                                从队头到队尾按从大到小排就是最大堆（大顶堆）--->队头元素相当于堆的根节点
     * */
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums)
            //key为数组元素值,val为对应出现次数
            map.put(num, map.getOrDefault(num, 0) + 1);

        //在优先队列中存储二元组(num,cnt),cnt表示元素值num在数组中的出现次数
        //出现次数按从队头到队尾的顺序是从小到大排,出现次数最低的在队头(相当于小顶堆)
        PriorityQueue<int[]> pq = new PriorityQueue<>((pair1, pair2) -> pair1[1] - pair2[1]);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (pq.size() < k) {
                pq.add(new int[]{entry.getKey(), entry.getValue()});
            } else {
                if (entry.getValue() > pq.peek()[1]) {
                    pq.poll();
                    pq.add(new int[]{entry.getKey(), entry.getValue()});
                }
            }
        }

        int[] ans = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            ans[i] = pq.poll()[0];
        }

        return ans;
    }
}
