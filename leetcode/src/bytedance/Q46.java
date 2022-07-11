package bytedance;

import java.util.*;

public class Q46 {

    public static void main(String[] args) {
        // 46. 全排列
        // https://leetcode.cn/problems/permutations/
        Q46 q46 = new Q46();
        System.out.println(q46.permute(new int[]{3,4,2,1}));
    }

    /**
     * https://www.bilibili.com/video/BV1cK4y1s7tN
     * https://api.bilibili.com/x/note/image?image_id=134680
     * https://api.bilibili.com/x/note/image?image_id=134679
     * 解题思路：
     * 假设数组是 2,3,4
     * 那么第一个位置，可以选择的数有 2 3 4
     * 固定了第一位后，就可以把剩下的数，固定到第二位（递归）
     *
     * 比如第一位固定了2，那剩下的数是 3 4，依次将 3 4 固定在第二位
     * 假设此时第一位固定了2，第二位固定了3，固定第三位时，发现固定的位数==数组长度，就可以将此时的数组，作为结果集的一个元素添加进去
     *
     * 上面假设的情况是第一位固定了2，那怎么依次将 3 4 都固定在第一位呢
     * 只需遍历 2 3 4，把每次遍历到的数，和第一个位的数交换，就能依次将 3 4 固定在第一位了
     * 也就是如果固定的是 x 位，就从 x 向后遍历，每次遍历到的数是 i，交换 x 和 i 的位置（循环）
     * 这样固定了 x 位后，就可以执行上面的递归过程，继续固定 x+1 位了
     *
     * 注意一点，当 x+1 位固定好了之后，要把 x 和 i 位置上的数，再换回来
     */
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        help1(nums, 0);
        return result;
    }

    /**
     * 固定 x 位上的数字
     * @param nums
     * @param x
     */
    private void help(int[] nums, int x) {
        if (nums.length - 1 == x) {
            List<Integer> oneList = new ArrayList<>();
            for (int i : nums) {
                oneList.add(i);
            }
            result.add(oneList);
            return;
        }
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i=x; i<nums.length; i++) {
            if (hashSet.contains(i)) {
                continue;
            }
            hashSet.add(i);
            // 交换 i 和 x 的位置后，执行递归
            swap(i, x, nums);
            // 递归求解固定 x 位后，[x+1, end] 的排列
            help(nums, x+1);
            // 把 i 和 x 的位置换回来
            swap(i, x, nums);
        }
    }

    private void swap(int i, int j, int[] nums) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private void help1(int[] nums, int x) {
        // 递归结束条件，x == nums.length - 1，也就是固定到最后一个位置了
        if (x == nums.length - 1) {
            List<Integer> list = new ArrayList<>(nums.length);
            for (int i : nums) {
                list.add(i);
            }
            result.add(list);
            return;
        }
        HashSet<Integer> hashSet = new HashSet<>();
        // 循环，依次把 [x,end] 位置上的元素，换到 x 位置上
        // 一次循环里面，只固定一个位置x，固定x后的固定下一位x+1，由递归 help1(x+1) 来做
        for (int i=x; i<nums.length; i++) {
            if (hashSet.contains(nums[i])) {
                // x 位置上，已经固定过 nums[i] 这个元素了，数值重复，要排除，否则结果中回出现重复的排列
                continue;
            }
            hashSet.add(nums[i]);
            // 把 nums[x] 换到 nums[i] 上
            swap(i, x, nums);
            // 固定了 x 位后，继续固定 x+1 位
            help1(nums, x+1);
            // 换回 nums[x] 和 nums[i]
            swap(i, x, nums);
        }
    }
}
