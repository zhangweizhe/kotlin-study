package bytedance;

import java.util.HashMap;
import java.util.Map;

public class Q3 {
    public static void main(String[] args) {
        // 3. 无重复字符的最长子串
        // https://leetcode.cn/problems/longest-substring-without-repeating-characters/
    }

    public int lengthOfLongestSubstring(String s) {
        int left = -1;
        int right = 0;
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (right < s.length()) {
            if (map.containsKey(s.charAt(right))) {
                int repeatIndex = map.get(s.charAt(right));
                if (repeatIndex > left) {
                    // 重复字符的索引大 > left，才需要更新 left，否则不用更新
                    // 比如 abba 这个字符串，当遍历到第二个b（索引为2）时，left更新为1（第一个b的索引）
                    // 接着继续遍历第二个a，此时 map 中存储的 'a' 的索引是 0
                    // 此时 Left 就不能更新为0，维持原值就行
                    left = repeatIndex;
                }
            }
            map.put(s.charAt(right), right);
            max = Math.max(max, right - left);
            right++;
        }
        return max;
    }
}
