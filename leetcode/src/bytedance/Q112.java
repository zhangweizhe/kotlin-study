package bytedance;

import java.util.Stack;

public class Q112 {

    public static void main(String[] args) {
        // 112. 路径总和
        // https://leetcode.cn/problems/path-sum/
    }

    /**
     * 迭代，使用先序遍历，定义一个节点栈，和一个 val 栈；
     * 节点栈用于先序遍历，val 栈用于存储该节点到根节点的和，两个栈同步pop、push
     * @param root
     * @param targetSum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        Stack<Integer> valStack = new Stack<>();
        valStack.push(root.val);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            Integer popVal = valStack.pop();
            if (popVal == targetSum && pop.left == null && pop.right == null) {
                return true;
            }
            if (pop.right != null) {
                stack.push(pop.right);
                valStack.push(popVal + pop.right.val);
            }
            if (pop.left != null) {
                stack.push(pop.left);
                valStack.push(popVal + pop.left.val);
            }
        }
        return false;
    }

    /**
     * 递归实现，注意是根节点到叶子节点，当满足 targetSum 时，还要判断当前节点是否是叶子节点
     * @param root
     * @param targetSum
     * @return
     */
    public boolean hasPathSum1(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            // 遍历到叶子节点了
            return root.val == targetSum;
        }
        return hasPathSum(root.left, targetSum-root.val) || hasPathSum(root.right, targetSum-root.val);
    }

}
