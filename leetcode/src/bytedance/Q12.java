package bytedance;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class Q12 {

    public static void main(String[] args) {
        // 12. 整数转罗马数字
        // https://leetcode.cn/problems/integer-to-roman/
        System.out.println(intToRoman(123123));
    }

    public static String intToRoman(int num) {
        Map<Integer, String> map = new LinkedHashMap<>();
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");

        StringBuilder sb = new StringBuilder();
        Set<Map.Entry<Integer, String>> entries = map.entrySet();
        for (Map.Entry<Integer, String> entry : entries) {
            Integer key = entry.getKey();
            while (num >= key) {
                sb.append(entry.getValue());
                num -= key;
            }
            if (num == 0) {
                break;
            }
        }
        return sb.toString();
    }
}
