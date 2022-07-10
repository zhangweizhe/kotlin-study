package bytedance;

public class Q14 {

    public static void main(String[] args) {
        // 14. 最长公共前缀
        // https://leetcode.cn/problems/longest-common-prefix/
        System.out.println(longestCommonPrefix1(new String[]{"a"}));
    }

    /**
     * 每个字符串一行一行往下排，形成一张表，对这张表执行纵向遍历
     * 就是第一列、第二列、第三列这样遍历
     * https://leetcode.cn/problems/longest-common-prefix/solution/zui-chang-gong-gong-qian-zhui-by-leetcode-solution/
     * https://assets.leetcode-cn.com/solution-static/14/14_fig2.png
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {
        int i = 0;
        Character c = null;
        StringBuilder sb = new StringBuilder();
        while (true) {
            for (int j=0; j<strs.length; j++) {
                String s = strs[j];
                if (i == s.length()) {
                    return sb.toString();
                }
                char c1 = s.charAt(i);
                if (c == null) {
                    c = c1;
                    // strs.length == 1 && strs[0].length() == 1 的场景
                    if (j == strs.length - 1) {
                        sb.append(c1);
                    }
                }else if (c == c1){
                    if (j == strs.length - 1) {
                        sb.append(c1);
                        c = null;
                    }
                }else {
                    return sb.toString();
                }
            }
            i++;
        }
    }

    public static String longestCommonPrefix1(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        // 以第一个字符串为基准，每个字符串都和基准字符串比较
        String baseStr = strs[0];
        int count = strs.length;
        for (int i=0; i<baseStr.length(); i++) {
            for (int j=0; j<count; j++) {
                if (i == strs[j].length()) {
                    // 第 j 个字符串，比基准字符串短
                    return strs[j].substring(0, i);
                }else if (strs[j].charAt(i) != baseStr.charAt(i)) {
                    // 第 j 个字符串的第i个字符，和基准字符串的不一样
                    return strs[j].substring(0, i);
                }
            }
        }
        return baseStr;
    }
}
