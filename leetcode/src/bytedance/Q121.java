package bytedance;

public class Q121 {

    public static void main(String[] args) {
        // 121. 买卖股票的最佳时机
        // https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/
    }

    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int minPrices = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i : prices) {
            if (i < minPrices) {
                minPrices = i;
            }else {
                int delta = i - minPrices;
                if (delta > maxProfit) {
                    maxProfit = delta;
                }
            }
        }
        return maxProfit;
    }
}
