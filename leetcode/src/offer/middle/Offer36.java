package offer.middle;

public class Offer36 {
    // 剑指 Offer 36. 二叉搜索树与双向链表
    // https://cheleetcode.cn/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/
    public static void main(String[] args) {
        Offer36 offer36 = new Offer36();

        Node n1 = new Node(4);
        Node n2 = new Node(2);
        Node n3 = new Node(5);
        n1.left = n2;
        n1.right = n3;
        Node n4 = new Node(1);
        Node n5 = new Node(3);
        n2.left = n4;
        n2.right = n5;

        Node node = offer36.treeToDoublyList(n1);

        System.out.println(node.val);
    }

    private Node pre = null;
    private Node head = null;

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        help(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    public void help(Node root) {
        if (root == null) {
            return;
        }
        help(root.left);
        if (pre != null) {
            pre.right = root;
            root.left = pre;
        }else {
            head = root;
        }
        pre = root;
        help(root.right);
    }

    static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }
}
