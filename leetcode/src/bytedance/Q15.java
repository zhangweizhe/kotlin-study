package bytedance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Q15 {

    public static void main(String[] args) {
        // 15. 三数之和
        // https://leetcode.cn/problems/3sum/
        System.out.println(threeSum(new int[]{0,0,0,0}));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i=0; i<nums.length - 1; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum < 0) {
                    left++;
                }else if (sum > 0) {
                    right--;
                }else {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    result.add(list);
                    // 找到一组解后，要跳过重复 left right 重复的数字
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left-1])left++;
                    while (left < right && nums[right] == nums[right+1])right--;
                }
            }
        }
        return result;
    }
}
