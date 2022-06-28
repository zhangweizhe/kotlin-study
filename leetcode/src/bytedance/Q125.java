package bytedance;

public class Q125 {

    public static void main(String[] args) {
        // 215. 数组中的第K个最大元素
        // https://leetcode.cn/problems/kth-largest-element-in-an-array/
        Q125 q125 = new Q125();
        System.out.println(q125.findKthLargest(new int[]{3,2,1,5,6,4}, 2));
    }

    public int findKthLargest(int[] nums, int k) {
        return quickSearch(nums, 0, nums.length - 1, k);
    }

    private int quickSearch(int[] nums, int left, int right, int k) {
        int i = quickSort(nums, left, right);
        // 注意比较的是 i 和 k-1
        if (i == k-1) {
            return nums[i];
        }else if (i > k - 1) {
            return quickSearch(nums, left, i-1, k);
        }else {
            return quickSearch(nums, i+1, right, k);
        }
    }

    // 从大到小排序
    private int quickSort(int[] nums, int left, int right) {
        if (left > right) {
            return left;
        }
        int pivotValue = nums[right];
        int j = left;
        for (int i=left; i<right; i++) {
            if (nums[i] > pivotValue) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                j++;
            }
        }
        nums[right] = nums[j];
        nums[j] = pivotValue;
        return j;
    }
}
