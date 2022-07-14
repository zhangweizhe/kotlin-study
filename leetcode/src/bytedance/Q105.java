package bytedance;

public class Q105 {
    public static void main(String[] args) {
        // 105. 从前序与中序遍历序列构造二叉树
        // https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return help(preorder, inorder, 0, 0, inorder.length-1);
    }

    private TreeNode help(int[] preorder, int[] inorder, int rootIndexInPre, int inorderStartIndex, int inorderEndIndex) {
        if (rootIndexInPre >= preorder.length) {
            return null;
        }
        if (inorderStartIndex > inorderEndIndex) {
            return null;
        }
        int rootVal = preorder[rootIndexInPre];
        // 在中序遍历中，找到根节点的位置
        int rootIndexInInorder = 0;
        for (int i=inorderStartIndex; i<=inorderEndIndex; i++) {
            if (inorder[i] == rootVal) {
                rootIndexInInorder = i;
                break;
            }
        }
        TreeNode root = new TreeNode(rootVal);
        root.left = help(preorder, inorder, rootIndexInPre + 1, inorderStartIndex, rootIndexInInorder-1);
        int leftChildrenCount = rootIndexInInorder - inorderStartIndex; //计算左子树的节点数量，由中序遍历的根节点位置，减去中序遍历的起始节点的位置
        root.right = help(preorder, inorder, rootIndexInPre + leftChildrenCount+1, rootIndexInInorder+1, inorderEndIndex);
        return root;
    }
}
