package bytedance;

public class Q45 {
    public static void main(String[] args) {
        // 45. 跳跃游戏 II
        // https://leetcode.cn/problems/jump-game-ii/
        Q45 q45 = new Q45();
        System.out.println(q45.jump(new int[]{2,3,1,1,4}));
    }

    /**
     * 在本次所能跳到的最远距离内，寻找下一次能跳到的最远距离
     * 当走到本次可以跳到的最远位置时，步数+1，进入下一次跳远，更新本次能跳到的最大距离
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        int stepCount = 0;
        // 本次所能跳到的最远距离
        int curMaxEnd = 0;
        // 下一次能跳到的最远距离
        int nextMaxEnd = 0;
        /**
         * 为什么迭代到 nums.length-1？
         * 当迭代到倒数第二个数时，有两种情况
         * 1）倒数第二个数，刚好是本次可以跳到的最远位置，那么再跳一步（i++）就可以到最后一个位置了
         * 2）倒数第二个数，不是本次可以跳到的最远位置，即 curMaxEnd >= nums.length-1，本次能跳到的最大距离，已经可以覆盖最后一个数了，当前跳跃次数已经够了
         */
        for (int i=0; i<nums.length-1; i++) {
            if (i + nums[i] > nextMaxEnd) {
                nextMaxEnd = i+nums[i];
            }
            if (i == curMaxEnd) {// 当走到本次可以跳到的最远位置时，
                // 步数+1
                stepCount++;
                // 进入下一次跳远，更新本次能跳到的最大距离
                curMaxEnd = nextMaxEnd;
            }
        }
        return stepCount;
    }
}
