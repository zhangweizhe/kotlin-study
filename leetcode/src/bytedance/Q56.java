package bytedance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Q56 {

    public static void main(String[] args) {
        // 56. 合并区间
        // https://leetcode.cn/problems/merge-intervals/
        int[][] intervals = new int[][]{
                new int[]{1,3},
                new int[]{2,6},
                new int[]{8,10},
                new int[]{15,18}
        };
        String deepToString = Arrays.deepToString(merge(intervals));
        System.out.println(deepToString);
    }

    public static int[][] merge(int[][] intervals) {
        // 根据区间左端点排序，从小到大
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });
        // 存储结果区间
        List<int[]> result = new ArrayList<>();
        // node[0]：左端点；node[1]：右端点
        // 遍历每一个区间，如果当前区间 current 的左端点，比结果集 result 最后一个区间 last 的右端点还小（小于或等于），
        // 说明 current 和 last 是重叠的，last 可以合并到 current 中
        // 至于合并后的区间的右端点 last[1]，即 last 新的右端点，取 last[1] 和 current[1] 的最大值
        // 如果 current[0] > last[1]，说明 current 和 last 不重叠，把 current 放到结果集中
        for (int[] current : intervals) {
            if (!result.isEmpty()) {
                int[] last = result.get(result.size() - 1);
                if (current[0] <= last[1]) {
                    // 取较大的右端点
                    last[1] = Math.max(last[1], current[1]);
                } else {
                    result.add(current);
                }
            } else {
                result.add(current);
            }
        }
        return result.toArray(new int[][]{});
    }
}
