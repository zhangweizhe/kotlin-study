package offer;

public class Offer68_2 {

    // 剑指 Offer 68 - II. 二叉树的最近公共祖先
    // https://leetcode.cn/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof/

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        // root 指向了 p 或者 q，此时 root 就是最近公共祖先
        if (root == p || root == q) return root;
        // 在左子树中找 p q 的最近公共祖先
        TreeNode leftLowestCommonAncestor = lowestCommonAncestor(root.left, p, q);
        // 在右子树中找 p q 的最近公共祖先
        TreeNode rightLowestCommonAncestor = lowestCommonAncestor(root.right, p, q);
        if (leftLowestCommonAncestor == null) {
            // 左子树找不到，肯定在右子树
            return rightLowestCommonAncestor;
        }else if (rightLowestCommonAncestor == null) {
            // 右子树找不到，肯定在左子树
            return leftLowestCommonAncestor;
        }
        // 左右子树都不为空，p q 分列 root 两侧，root 是最近公共祖先
        return root;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
}
