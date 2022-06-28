package bytedance;

public class Q11 {

    public static void main(String[] args) {
        // 11. 盛最多水的容器
        // https://leetcode.cn/problems/container-with-most-water/
        System.out.println(maxArea1(new int[]{1,8,6,2,5,4,8,3,7}));
    }

    /**
     * 暴力解法，超时
     */
    public static int maxArea(int[] height) {
        int max = 0;
        for (int i=0; i<height.length; i++) {
            for (int j=0; j<height.length; j++) {
                int min = Math.min(height[i], height[j]);
                int tmpMax = min * Math.abs(i-j);
                max = Math.max(tmpMax, max);
            }
        }
        return max;
    }
    public static int maxArea1(int[] height) {
        // 初始化 left right 两个指针，分别指向两边
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        while (left < right) {
            // 两个指针指向的高度中，取较小的一个
            int minHeight = Math.min(height[left], height[right]);
            // 计算当前两个指针构成的范围的水容量
            int tmpMax = Math.abs(left - right) * minHeight;
            max = Math.max(tmpMax, max);
            // 短板向内移动，min(height[left], height[right]) 有可能变大，容量可能变大
            // 如果是长板向内移动，min(height[left], height[right]) 有可能变小或不变，那容量一定变小（left, right 距离变小了）
            // 所以每次都是短板向内移动
            if (height[left] > height[right]) {
                right--;
            }else {
                left++;
            }
        }
        return max;
    }
}
