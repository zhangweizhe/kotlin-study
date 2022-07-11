package bytedance;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q103 {
    public static void main(String[] args) {
        // 103. 二叉树的锯齿形层序遍历
        // https://leetcode.cn/problems/binary-tree-zigzag-level-order-traversal/
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        if (root != null) {
            linkedList.add(root);
        }
        boolean toRight = true;
        while (!linkedList.isEmpty()) {
            int size = linkedList.size();
            LinkedList<Integer> oneRow = new LinkedList<>();
            for (int i=0; i<size; i++) {
                TreeNode poll = linkedList.poll();
                if (poll.left != null) {
                    linkedList.add(poll.left);
                }
                if (poll.right != null) {
                    linkedList.add(poll.right);
                }
                if (toRight) {
                    oneRow.add(poll.val);
                }else {
                    oneRow.addFirst(poll.val);
                }
            }
            result.add(oneRow);
            toRight = !toRight;
        }
        return result;
    }
}
