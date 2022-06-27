package bytedance;

public class Q7 {

    public static void main(String[] args) {
        Q7 q7 = new Q7();
        System.out.println(q7.reverse(Integer.MAX_VALUE));
    }

    public int reverse(int x) {
        int result = 0;
        while (x != 0) {
            // 提前用 Integer.MIN 和 Integer.MAX 除以 10 来判断是否越界
            if (result < Integer.MIN_VALUE / 10 || result > Integer.MAX_VALUE / 10) {
                return 0;
            }
            int tmp = x % 10;
            result = result * 10 + tmp;
            x = x / 10;
        }
        return result;
    }
}
