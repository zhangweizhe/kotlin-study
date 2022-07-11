package tree;

import linkedlist.TreeNode;

import java.util.Stack;

public class TreePractice {

    public static void main(String[] args) {

        /**
         *      9
         *    8   7
         *   6   5 4
         */

        TreeNode root = new TreeNode(9);
        root.setLeft(new TreeNode(8));
        root.setRight(new TreeNode(7));
        root.getLeft().setLeft(new TreeNode(6));
        root.getRight().setLeft(new TreeNode(5));
        root.getRight().setRight(new TreeNode(4));
        System.out.println(preOrder(root));
        System.out.println(midOrder(root));
        System.out.println(postOrder(root));
    }

    private static String preOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();

        if (root != null) {
            stack.push(root);
        }

        StringBuilder sb = new StringBuilder();

        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            sb.append(pop.getVal()).append(",");
            if (pop.getRight() != null) {
                stack.push(pop.getRight());
            }
            if (pop.getLeft() != null) {
                stack.push(pop.getLeft());
            }
        }

        return sb.toString();
    }

    private static String midOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();

        TreeNode cur = root;
        while (cur != null) {
            stack.push(cur);
            cur = cur.getLeft();
        }

        StringBuilder sb = new StringBuilder();

        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            sb.append(pop.getVal()).append(",");
            if (pop.getRight() != null) {
                cur = pop.getRight();
                while (cur != null) {
                    stack.push(cur);
                    cur = cur.getLeft();
                }
            }
        }
        return sb.toString();
    }

    private static String postOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();

        TreeNode cur = root;
        while (cur != null) {
            stack.push(cur);
            cur = cur.getLeft();
        }

        TreeNode prev = null;

        StringBuilder sb = new StringBuilder();

        while (!stack.isEmpty()) {
            TreeNode peek = stack.peek();
            if (peek.getRight() == null || peek.getRight() == prev) {
                // 没有右子树，或者右子树已经遍历过
                TreeNode pop = stack.pop();
                sb.append(pop.getVal()).append(",");
                prev = pop;
            }else {
                // 有右子树，还没遍历
                cur = peek.getRight();
                while (cur != null) {
                    stack.push(cur);
                    cur = cur.getLeft();
                }
            }
        }
        return sb.toString();
    }
}
