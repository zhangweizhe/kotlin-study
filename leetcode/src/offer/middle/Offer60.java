package offer.middle;

import java.util.Arrays;

public class Offer60 {
    public static void main(String[] args) {
        // 剑指 Offer 60. n个骰子的点数
        // https://leetcode.cn/problems/nge-tou-zi-de-dian-shu-lcof/
        Offer60 offer60 = new Offer60();
        double[] doubles = offer60.dicesProbability(2);
        System.out.println(Arrays.toString(doubles));
    }

    public double[] dicesProbability(int n) {
        // 每个骰子可以摇出 1~6 六种情况，所以 n 个骰子，可以摇出 n^6 种排列情况
        // n 个骰子，摇出的最小和是 n （n 个 1），最大和是 n*6（n 个 6），所以可以摇出 n*6 - n + 1 种和，也就是 n*5+1
        // dp[i][j] 表示，i 个骰子，摇出和为 j 的概率
        // 对于 dp[i] 来说，dp[i] 的前 i 个数字都是不用的
        // 比如对于 dp[2]（两个骰子），dp[2][2]表示两个骰子，扔出和为2的概率，两个骰子肯定不存在和为0或者1的情况，所以dp[2][0]、dp[2][1] 都是不用的
        // 所以在声明数组时，dp[i] 的长度是 i*6+1，前面 i 个数字不用
        double[][] dp = new double[n+1][n*6+1];
        // dp[1][1] ~ dp[1][6] 都等于 1/6，即 1 个骰子，摇出 1、2、3、4、5、6 的概率都是 1/6
        Arrays.fill(dp[1], 1,7,1/6.0);
        // dp[2][j]，可以通过 dp[1] 计算得到，假设第二个骰子摇出的数字是 x，那么 dp[2][j] = sum(dp[1][j-x]/6)，x属于[1,6]
        // 所以可以得到递推公式：dp[i][j] = sum(dp[i-1][j-x]/6)，i属于[1,n]，j属于[i,6*i]，x属于[1,6]
        for (int i=1; i<=n; i++) {
            for (int j=i; j<=6*i; j++) {
                // 注意 j-x >= 0 的判断
                for (int x=1; x<=6 && j-x>=0; x++) {
                    dp[i][j] += dp[i-1][j-x]/6;
                }
            }
        }
        return Arrays.copyOfRange(dp[n], n, n*6+1);
    }

    public double[] dicesProbability1(int n) {
        // 每个骰子可以扔出 6 个数，所以 n 个骰子，可以扔出的数字排列有 6^n 种
        // n 个骰子，扔出的最小和是 n（n 个 1），最大和是 n*6（6 个 n），所以 n 个骰子，有 n*6 - n + 1，也就是 5*n+1 种和
        // 1）状态定义
        // 定义二维数组 dp，其中 dp[i][j] 表示，用 i 个骰子，扔出和为 j 的概率
        // 定义 dp 数组时，因为 dp[i][j] 表示的是 i 个骰子，和为 j 的概率，所以一维数组的长度是n+1（索引为0的元素用不上），二维数组的长度是 6*n+1（所以为 0 到 n 的元素用不上）
        double[][] dp = new double[n+1][6*n+1];

        // 2）初始值
        // 易知：对于 dp[1]（1 个骰子），dp[1][1] ~ dp[1][6] 都是 1/6，即 1 个骰子，扔出 1、2、3、4、5、6 的概率都是 1/6
        Arrays.fill(dp[1], 1, 7, 1/6.0);

        // 3）递推公式
        // 假设有 i 个骰子，第 i 个骰子扔出的数是 x，x 属于[1,6]，那么有 dp[i][j] = sum(dp[i-1][j-x]/6)
        // 骰子数量 i 的范围是[1,n]，求和 j 的范围是 [i, 6*i]，扔出一个骰子得到的数 x 的范围是 [1,6]，所以可以写出三层循环
        for (int i=1; i<=n; i++) {
            for (int j=i; j<=6*i; j++) {
                for (int x=1; x<=6 && j-x >= 0; x++) { // 因为求和结果 j 可能比扔出的数还小，所以这里要有 j-x>=0 的条件
                    dp[i][j] += dp[i-1][j-x]/6;
                }
            }
        }
        // [0,n-1] 的不要
        return Arrays.copyOfRange(dp[n], n, 6*n+1);
    }
}
