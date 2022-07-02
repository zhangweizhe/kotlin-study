package bytedance;

public class Q14 {

    public static void main(String[] args) {
        // 14. 最长公共前缀
        // https://leetcode.cn/problems/longest-common-prefix/
        System.out.println(longestCommonPrefix(new String[]{"a"}));
    }

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
}
