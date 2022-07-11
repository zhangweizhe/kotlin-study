package offer;

import linkedlist.TreeNode;

public class Offer68 {

    public static void main(String[] args) {
        // 剑指 Offer 68 - I. 二叉搜索树的最近公共祖先
        // https://leetcode.cn/problems/er-cha-sou-suo-shu-de-zui-jin-gong-gong-zu-xian-lcof/


    }

    private static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (p.getVal() < root.getVal() && q.getVal() < root.getVal()) {
                // p q 都在 root 左子树
                root = root.getLeft();
            }else if (p.getVal() > root.getVal() && q.getVal() > root.getVal()) {
                // p q 都在 root 右子树
                root = root.getRight();
            }else {
                // p q 不同侧，此时的 root 就是最近公共祖先
                break;
            }
        }
        return root;
    }
}
