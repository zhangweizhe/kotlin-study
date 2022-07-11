package bytedance;

public class Q8 {
    public static void main(String[] args) {
        // 8. 字符串转换整数 (atoi)
        // https://leetcode.cn/problems/string-to-integer-atoi/
        Q8 q8 = new Q8();
        System.out.println(q8.myAtoi("2147483648"));
    }

    public int myAtoi(String s) {
        if (s == null || s.equals("")) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int result = 0;
        int flag = 1;
        int i = 0;
        // 删除前导空格
        while (i < chars.length && chars[i] == ' ') {
            i++;
        }
        // 全是空格的场景
        if (i == chars.length) {
            return 0;
        }
        // 符号位判断
        if (chars[i] == '-') {
            flag = -1;
            i++;
        }else if (chars[i] == '+') {
            i++;
        }
        for (; i<chars.length; i++) {
            char c = chars[i];
            if (c < '0' || c > '9'){
                break;
            }else {
                int digi = c - '0';
                // 当 result == Integer.MIN / 10 || result == Integer.MAX / 10 时，要考虑最后一位的大小
                if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE/10 && digi >=8)) {
                    return Integer.MIN_VALUE;
                }else if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE/10 && digi>=7)) {
                    return Integer.MAX_VALUE;
                }else {
                    result = result * 10 + (digi) * flag;
                }
            }
        }
        return result;
    }
}
