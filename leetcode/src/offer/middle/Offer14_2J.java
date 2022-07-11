package offer.middle;

public class Offer14_2J {

    public static void main(String[] args) {
        System.out.println(cuttingRope(120));
    }

    public static int cuttingRope(int n) {
        if (n == 2 || n == 3) {
            return n-1;
        }
        int ropeNums = n / 3;
        int remain = n % 3;
        long result = 1;
        int p = 1000000007;
        while(ropeNums > 1) {
            result = (result * 3) % p;
            ropeNums--;
        }
        if (remain == 0) {
            result = result * 3 % p;
        }else if (remain == 1) {
            result = result * 4 % p;
        }else if (remain == 2) {
            result = result * 2 * 3 % p;
        }
        return (int)result;
    }
}
