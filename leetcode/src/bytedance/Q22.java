package bytedance;

import java.util.ArrayList;
import java.util.List;

public class Q22 {

    public static void main(String[] args) {
        // 22. 括号生成
        // https://leetcode.cn/problems/generate-parentheses/
        Q22 q22 = new Q22();
        System.out.println(q22.generateParenthesis(3));
    }

    private List<String> result = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        generate("", n, n);
        return result;
    }

    /**
     *
     * @param str
     * @param leftCount 剩余的左括号数量
     * @param rightCount 剩余的右括号数量
     */
    public void generate(String str, int leftCount, int rightCount) {
        if (leftCount < 0 || rightCount <0) {
            // 小于0，return
            return;
        }
        if (leftCount == 0 && rightCount == 0) {
            // 当剩余的左右括号数量都为0时，str就是一个有效的括号组号
            result.add(str);
            return;
        }
        if (leftCount == rightCount) {
            generate(str + "(", leftCount-1, rightCount);
        }else if (leftCount < rightCount) {
            // 剩余的左括号比较少，此时可以append左括号，也可以append右括号
            generate(str + "(", leftCount-1, rightCount);
            generate(str + ")", leftCount, rightCount-1);
        }
    }
}
