package bytedance;

public class Q69 {

    public static void main(String[] args) {
        // 69. x 的平方根
        // https://leetcode.cn/problems/sqrtx/
        Q69 q69 = new Q69();
        System.out.println(q69.mySqrt(9));
    }
    public int mySqrt(int x) {
        // 假设返回值为 ans，那么 ans*ans 肯定 <= x，所以可以通过二分查找法，查找 ans
        /**
         * x = 8
         * left=0, right=8, mid=4
         * mid*mid=16 > 8, right = mid-1=3
         * mid = (0+3)/2 = 1
         * mid*mid=1 < 8, left = mid+1=2, ans=mid=1
         * mid = (2+2)/2 = 2
         * mid*mid=4<8, left=mid+1=3, ans=mid=2
         * 退出循环，返回ans
         */
        int left = 0;
        int right = x;
        int ans = 0;
        while (left <= right) {
            // 如果写成 mid=(left+right)/2，left+right之后可能会越界
            int mid = left + (right-left)/2;
            // 注意转Long，避免mid*mid越界
            if ((long)mid * mid <= x) {
                left = mid + 1;
                ans = mid;
            }else {
                right = mid - 1;
            }
        }
        return ans;
    }

    public int add(int a, int b) {
        // 本为和
        int n = a^b;
        // 进位和
        int c = (a&b)<<1;

        while (c != 0) {
            int tmpN = n;
            n = n^c;
            c = (c&tmpN)<<1;
        }
        return n;
    }
}
