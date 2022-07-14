package bytedance;

public class Q55 {
    public static void main(String[] args) {
        // 55. 跳跃游戏
        // https://leetcode.cn/problems/jump-game/
        Q55 q55 = new Q55();
        System.out.println(q55.canJump(new int[]{3,2,1,0,4}));
    }
    public boolean canJump(int[] nums) {
        if (nums.length == 0) {
            return true;
        }
        // jumps[i] 表示，在 i 位置时，最远可以跳到的位置
        int[] jumps = new int[nums.length];
        for (int i=0; i<nums.length; i++) {
            jumps[i] = nums[i] + i;
        }
        // 当前所在的位置
        int curIndex = 0;
        // 最远可以到达的位置
        int maxJump = nums[0];
        while (curIndex < nums.length && curIndex <= maxJump) {
            if (jumps[curIndex] > maxJump) {
                // 当前位置所能到达的最远位置，比 maxJump 还大，更新 maxJump
                maxJump = jumps[curIndex];
            }
            curIndex++;
        }
        if (curIndex == nums.length) {
            return true;
        }
        return false;
    }
}
