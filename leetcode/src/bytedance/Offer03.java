package bytedance;

public class Offer03 {
    public static void main(String[] args) {
        // 剑指 Offer 03. 数组中重复的数字
        // https://leetcode.cn/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
        System.out.println(findRepeatNumber(new int[]{2, 3, 1, 0, 2, 5, 3}));
    }
    public static int findRepeatNumber(int[] nums) {
        int i=0;
        while (i < nums.length) {
            while (i < nums.length && nums[i] == i) {
                i++;
            }
            if (nums[i] == nums[nums[i]]) {
                return nums[i];
            }
            int tmp = nums[i];
            nums[i] = nums[nums[i]];
            nums[tmp] = tmp;
        }
        return -1;
    }
}
