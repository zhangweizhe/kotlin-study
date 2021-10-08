package dp;

import java.util.ArrayList;
import java.util.List;

public class Q0806 {
    // 面试题 08.06. 汉诺塔问题
    // https://leetcode-cn.com/problems/hanota-lcci/
    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>();
        a.add(2);
        a.add(1);
        a.add(0);

        List<Integer> b = new ArrayList<>();
        List<Integer> c = new ArrayList<>();
        hanota(a, b, c);

        System.out.println("a:" + a);
        System.out.println("c:" + c);
    }

    public static void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        move(A.size(), A, B, C);
    }

    /**
     *
     * @param n
     * @param a 源柱子
     * @param b 过渡柱子
     * @param c 目标柱子
     */
    private static void move(int n, List<Integer> a, List<Integer> b, List<Integer> c) {
        if (n == 1) {
            c.add(a.remove(a.size() - 1));
        }else {
            // 把 a 柱子上，最上面 n-1 个盘子，从 a 移到 b（借助 c 柱子）
            move(n-1, a, c, b);
            // 把 a 柱子上，把最底下的盘子从 a 移到 c
            c.add(a.remove(a.size() - 1));
            // 把 b 柱子上的 n - 1 个盘子，移到 c（借助 a 柱子）
            move(n-1, b, a, c);
        }
    }
}

