package bytedance;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q199 {

    public static void main(String[] args) {
        // 199. 二叉树的右视图
        // https://leetcode.cn/problems/binary-tree-right-side-view/
    }

    public List<Integer> rightSideView(TreeNode root) {
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        if (root != null) {
            linkedList.add(root);
        }
        List<Integer> result = new ArrayList<>();
        while (!linkedList.isEmpty()) {
            int size = linkedList.size();
            for (int i=0; i<size; i++) {
                TreeNode poll = linkedList.poll();
                if (poll.left != null) {
                    linkedList.add(poll.left);
                }
                if (poll.right != null) {
                    linkedList.add(poll.right);
                }
                if (i == size - 1) {
                    result.add(poll.val);
                }
            }
        }
        return result;
    }

}
