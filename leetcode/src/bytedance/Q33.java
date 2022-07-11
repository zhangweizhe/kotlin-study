package bytedance;

public class Q33 {

    public static void main(String[] args) {
        // 33. 搜索旋转排序数组
        // https://leetcode.cn/problems/search-in-rotated-sorted-array/
        Q33 q33 = new Q33();
        System.out.println(q33.search(new int[]{5,1,3}, 3));
    }

    public int search(int[] nums, int target) {
        // 前提：数组从从中间切开，分为两部分，肯定有一部分是递增的
        int left = 0;
        int right = nums.length - 1;
        int mid = (left + right)/2;
        while (left <= right) {
            mid = (left + right)/2;
            if (nums[mid] == target) {
                return mid;
            }
            // 比较 left mid right 的值，看左右两边，哪边是递增的
            if (nums[left] <= nums[mid]) {
                // 左边是递增的
                if (nums[left] <= target && target < nums[mid]) {
                    // target 位于左边区间，在左边找
                    right = mid - 1;
                }else {
                    left = mid + 1;
                }
            }else if (nums[right] >= nums[mid]) {
                // 右边是递增的
                if (nums[mid] < target && target <= nums[right]) {
                    // target 位于右边区间，在右边找
                    left = mid + 1;
                }else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    public int search1(int[] nums, int target) {
        // 把数组一分为二，一定有一边是递增的（左边界<=右边界）
        // 判断 target 是否在递增区间内，如果在的话，就在递增区间内，执行二分查找
        // 如果 target 不在递增区间内，就在另一个区间中，继续执行一分二的操作
        int left = 0;
        int right = nums.length - 1;
        // 循环条件是 left<=right，不能是 left<right，当 left==right 时，nums[left] 可能就是我们要找的 target
        int mid;
        while (left <= right) {
            mid = (left + right)/2;
            if (target == nums[mid]) {
                return mid;
            }

            if (nums[left] <= nums[mid]) {// 左边是有序的（递增的）
                if (nums[left] <= target && target < nums[mid]) {// target 落于左边的递增区间
                    right = mid-1;
                }else {
                    // target 在右边区间
                    left = mid+1;
                }
            }else if (nums[mid] <= nums[right]) {// 右边边是有序的（递增的）
                if (nums[mid] < target && target <= nums[right]) { // target 位于右边的递增区间
                    left = mid + 1;
                }else {
                    // target 在左边区间
                    right = mid-1;
                }
            }
        }
        return -1;
    }
}
