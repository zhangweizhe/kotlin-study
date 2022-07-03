package bytedance;

import java.util.Arrays;

public class Q31 {
    public static void main(String[] args) {
        // 31. 下一个排列
        // https://leetcode.cn/problems/next-permutation/
        Q31 q31 = new Q31();
        int[] nums = new int[]{1,2,3};
        q31.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));

        int[] preNums = new int[]{7,6,4,1,2,3,5};
        q31.prevPermutation(preNums);
        System.out.println(Arrays.toString(preNums));
    }

    public void nextPermutation(int[] nums) {
        // 从右到左，找第一个递增的区间[i, i+1]
        /**
         * 为什么找递增的？
         * 因为要找下一个排列，肯定比当前排列大，所以要在左边找一个小的数，在右边找一个大的数，二者交换，所以递增
         */
        int i = nums.length - 2;
        while (i >= 0) {
            if (nums[i] >= nums[i+1]) {
                i--;
            }else {
                break;
            }
        }
        // 从右到左，在 [i+1, end] 区间中，找比 [i] 大，但是大得最少的
        int j = nums.length - 1;
        int minGreater = -1;
        if (i >= 0) {
            while (j > i) {
                if (nums[j] > nums[i] && (minGreater == -1 || nums[j] < nums[minGreater])) {
                    minGreater = j;
                }
                j--;
            }
            // 交换 i 和 minGreater 的位置
            int tmp = nums[i];
            nums[i] = nums[minGreater];
            nums[minGreater] = tmp;
        }
        // 此时 [i+1, end] 是递减的
        // 反转 [i+1, end]
        reverse(nums, i + 1, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }

    public void prevPermutation(int[] nums) {
        // 124653214
        // 从右到左，找第一个递减的区间[i,i+1]
        /**
         * 为什么找递减的？
         * 因为要在左边找一个大的数，在右边找一个小的数，所以递减
         */
        int i = nums.length - 2;
        while (i >= 0) {
            if (nums[i] < nums[i+1]) {
                i--;
            }else {
                break;
            }
        }
        // 此时 [i,i+1] 是递减的，[i+1, end] 是递增的
        if (i >= 0) {
            int j = nums.length - 1;
            // 在 [i+1, end] 区间中，找一个比 nums[i] 小、并且小的最少的数
            while (j >= i+1 && nums[j] > nums[i]) {
                j--;
            }
            // 交换 i j
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
        // 反转[i+1, end]
        reverse(nums, i+1, nums.length-1);
    }
}
