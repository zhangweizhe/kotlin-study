package bytedance;

public class Q9 {

    public static void main(String[] args) {
        // 9. 回文数
        // https://leetcode.cn/problems/palindrome-number/
        System.out.println(isPalindrome(12344321));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x == 0) {
            return true;
        }
        if (x % 10 == 0) {
            // 个位数为0，也不是回文
            return false;
        }
        int reverse = 0;
        while (x > reverse) {
            // 余数
            int tmp = x % 10;
            reverse = reverse * 10 + tmp;
            // x 不断除以10
            x = x / 10;
        }
        // x长度是奇数，如12321，经过上面计算，x = 12，reverse = 123，可以用 x == reverse / 10 判断是否为回文
        // x长度是偶数，如123321，经过上面计算，x=123，reverse = 123，可以用 x == reverse 判断是否为回文
        return x == reverse || x == reverse/10;
    }
}
