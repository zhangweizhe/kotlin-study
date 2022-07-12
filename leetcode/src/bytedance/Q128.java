package bytedance;

import java.util.HashSet;
import java.util.Set;

public class Q128 {
    public static void main(String[] args) {
        // 128. 最长连续序列
        // https://leetcode.cn/problems/longest-consecutive-sequence/
        Q128 q128 = new Q128();
        System.out.println(q128.longestConsecutive(new int[]{2,4,5,7,4,3}));
    }

    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>(nums.length);
        for (int i : nums) {
            set.add(i);
        }
        int longestLength = 1;
        for (int currentNum : set) {
            if (set.contains(currentNum-1)) {
                // 当前数字的前驱数字，存在set中，当前数字可以不用检查
                // 比如对于 2 3 4 6，先遍历currentNum=2，可得最长连续序列234；
                // 当遍历到currentNum=3时，就无需再计算以3为起点的最长连续序列了，因为肯定比234序列短
                // 这样，数组中的每个数，都只会进入内循环一次，时间复杂度就是O(n)
                continue;
            }
            int tmpCurrent = currentNum;
            int tmpLongest = 1;
            while (set.contains(tmpCurrent+1)) {
                tmpCurrent++;
                tmpLongest++;
            }
            longestLength = Math.max(longestLength, tmpLongest);
        }
        return longestLength;
    }
}
