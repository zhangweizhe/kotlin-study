package bytedance;

public class Q70 {

    public static void main(String[] args) {
        // 70. 爬楼梯
        // https://leetcode.cn/problems/climbing-stairs/
        System.out.println(climbStairs1(3));
    }
    public static int climbStairs(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[0] = 1;
        for (int i=2; i<=n; i++) {
            dp[i] = dp[i-2] + dp[i-1];
        }
        return dp[n];
    }

    public static int climbStairs1(int n) {
        // 空间优化，因为 dp[i] 只和 dp[i-2] 和 dp[i-1] 有关
        // 所以用两个变量来保存 dp[i-2]、dp[i-1]
        int a = 1;//dp[i-2]
        int b = 1;//dp[i-1]
        for (int i=2; i<=n; i++) {
            // tmp 是 dp[i]
            int tmp = a+b;
            a = b;
            b = tmp;
        }
        return b;
    }
}
