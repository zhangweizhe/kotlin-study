package bytedance;

public class Q198 {

    public static void main(String[] args) {
        // 198. 打家劫舍
        // https://leetcode.cn/problems/house-robber/
        System.out.println(rob(new int[]{2,7,9,3,1}));
    }

    public static int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        // dp[i] 表示前i+1个房间，能偷得的最大金额，假设有n个房间，则 dp[n-1] 就表示 n 个房间，能偷到的最大金额
        int[] dp = new int[nums.length];
        // 一个房间，那这个房间的金额就是最大金额
        dp[0] = nums[0];
        // 两个房间，取金额较大的那个
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i=2; i<nums.length; i++) {
            // 对于房间i，可以偷，可以不偷
            // 1）偷：则 dp[i] = dp[i-2] + nums[i]
            // 2）不偷：则 dp[i] = dp[i-1]
            // 取两种情况的最大值，就可以得到前 i 个房间，能偷得的最大金额
            dp[i] = Math.max(dp[i-2]+nums[i], dp[i-1]);
        }
        return dp[nums.length-1];
    }

    /**
     * 空间优化版本，先写dp[]数组版本，再做空间优化
     * @param nums
     * @return
     */
    public static int rob1(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        // dp[i] 表示前i+1个房间，能偷得的最大金额，假设有n个房间，则 dp[n-1] 就表示 n 个房间，能偷到的最大金额
        int[] dp = new int[nums.length];
        // 一个房间，那这个房间的金额就是最大金额
        int a = nums[0];
        // 两个房间，取金额较大的那个
        int b = Math.max(nums[0], nums[1]);
        for (int i=2; i<nums.length; i++) {
            // 对于房间i，可以偷，可以不偷
            // 1）偷：则 dp[i] = dp[i-2] + nums[i]
            // 2）不偷：则 dp[i] = dp[i-1]
            // 取两种情况的最大值，就可以得到前 i 个房间，能偷得的最大金额
            int c = Math.max(a+nums[i], b);
            a = b;
            b = c;
//            dp[i] = Math.max(dp[i-2]+nums[i], dp[i-1]);
        }
        return b;
    }
}
