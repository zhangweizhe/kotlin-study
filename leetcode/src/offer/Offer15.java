package offer;

public class Offer15 {

    public static void main(String[] args) {
        // 剑指 Offer 15. 二进制中1的个数
        System.out.println(hammingWeight1(-3));
    }

    /**
     * i 从 0 到 32，每次让 1 左移 i 位，得到一个数 m，用 m 和 n 按位与运算，
     * 如果运算结果不为0，说明 n 的二进制中，第 i 位是 1
     */
    public static int hammingWeight(int n) {
        int count = 0;
        int i = 0;
        while (i < 32) {
            if ((n & (1 << i)) != 0) {
                count++;
            }
            i++;
        }
        return count;
    }

    /**
     * n&(n-1) 的运算结果，相当于把 n 的最后一个 1 改为 0
     * 如 6&(6-1) = 4，6(110），4(100)
     * 重复 n&(n-1) 的操作，当 n 变为 0 时，操作次数就是 1 的个数了
     */
    public static int hammingWeight1(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n-1);
            count++;
        }
        return count;
    }
}
