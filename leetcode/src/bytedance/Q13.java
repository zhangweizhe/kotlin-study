package bytedance;

import java.util.HashMap;
import java.util.Map;

public class Q13 {

    public static void main(String[] args) {
        // 13. 罗马数字转整数
        // https://leetcode.cn/problems/roman-to-integer/
        System.out.println(romanToInt("MCMXCIV"));

    }

    public static int romanToInt(String s) {
        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);

        int result = 0;
        int i=0;
        while (i < s.length() - 1) {
            String substring = s.substring(i, i + 2);
            Integer integer = map.get(substring);
            if (integer != null) {
                result += integer;
                i += 2;
            }else {
                String substring1 = s.substring(i, i + 1);
                Integer integer1 = map.get(substring1);
                if (integer1 != null) {
                    result += integer1;
                    i++;
                }
            }
        }
        String substring = s.substring(i);
        Integer integer = map.get(substring);
        if (integer != null) {
            result += integer;
        }
        return result;
    }
}
