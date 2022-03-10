package offer;

public class Offer101 {

    /**
     * 剑指 Offer II 101. 分割等和子集
     * https://leetcode-cn.com/problems/NUPfPr/
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(canPartition1(new int[]{1,5,11,5}));
    }

    public static boolean canPartition(int[] nums) {

        int sum = 0;

        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 != 0) {
            return false;
        }

        // dp[i][j] = x，表示当背包容量为 j 时，从前 i 个物品中任选 n (0<=n<=i) 个，若 x 为 true，则刚好填满，若为 false，则不能恰好填满
        boolean[][] dp = new boolean[nums.length+1][sum/2+1];
        // 背包容量为 0 时，0 个物品恰好装满
        dp[0][0] = true;
        for (int i=1; i<=nums.length; i++) {
            // 当前物品重量
            int currentValue = nums[i-1];
            for (int j=1; j<=sum/2; j++) {
                if (j < currentValue) {
                    // 当前物品大于背包容量，装不下，所以是否能刚好装满，只与【容量为 j 时，前 i-1 个物品能否装满】有关
                    dp[i][j] = dp[i-1][j];
                }else {
                    // 当前物品小于等于背包容量，可以装下当前物品，
                    // 与【容量为 j 时，前 i-1 个物品能否装满】或者【容量为 j-currentValue 时，前 i-1 个物品能否装满】有关
                    dp[i][j] = dp[i-1][j-currentValue] || dp[i-1][j];
                }
            }
        }
        return dp[nums.length][sum/2];
    }

    public static boolean canPartition1(int[] nums) {

        int sum = 0;

        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 != 0) {
            return false;
        }

        boolean[] dp = new boolean[sum/2+1];
        dp[0] = true;

        for (int i=1; i<=nums.length; i++) {
            int currentValue = nums[i-1];
            for (int j=sum/2; j>=1; j--) {
                if (j < currentValue) {
                    dp[j] = dp[j];
                }else {
                    dp[j] = dp[j - currentValue] || dp[j];
                }
            }
        }
        return dp[sum/2];
    }
}
