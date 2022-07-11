package bytedance;

import java.util.Arrays;

public class Q5 {

    public static void main(String[] args) {
        // 5. 最长回文子串
        // https://leetcode.cn/problems/longest-palindromic-substring/
        Q5 q5 = new Q5();
        System.out.println(q5.longestPalindrome("cbbd"));
    }

    public String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }
        // 从中心向外扩散
        char[] chars = s.toCharArray();
        int maxLength = 0;
        int[] maxRange = new int[2];
        for (int i=0; i<chars.length; i++) {
            int[] range1 = help(chars, i, i);
            int length1 = range1[1] - range1[0] + 1;
            int[] range2 = help(chars, i, i+1);
            int length2 = range2[1] - range2[0] + 1;
            if (length1 > length2) {
                if (length1 > maxLength) {
                    maxRange = range1;
                    maxLength = length1;
                }
            }else {
                if (length2 > maxLength) {
                    maxRange = range2;
                    maxLength = length2;
                }
            }
        }
        return s.substring(maxRange[0], maxRange[1]+1);
    }

    /**
     * 以[centerLeft, centerRight]为中心向外扩散，查找最长回文，返回最长回文的开始索引和结束索引
     * 如果是 "abc"，centerLeft=0, centerRight=1, 则返回 {0,0}
     * @return
     */
    private int[] help(char[] chars, int centerLeft, int centerRight) {
        boolean enter = false;
        while (centerLeft >=0 && centerRight < chars.length) {
            if (chars[centerLeft] == chars[centerRight]) {
                centerLeft--;
                centerRight++;
                enter = true;
            }else {
                break;
            }
        }
        if (enter) {
            centerLeft++;
            centerRight--;
            return new int[]{centerLeft, centerRight};
        }else {
            return new int[]{0,0};
        }
    }
}
