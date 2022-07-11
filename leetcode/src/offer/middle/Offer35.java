package offer.middle;

public class Offer35 {
    // 剑指 Offer 35. 复杂链表的复制
    // https://leetcode.cn/problems/fu-za-lian-biao-de-fu-zhi-lcof/
    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n1.random = n4;
        n2.random = n1;
        n3.random = null;
        n4.random = n3;
        Node node = copyRandomList(n1);
        while (node != null) {
            System.out.println(node);
            node = node.next;
        }
    }

    public static Node copyRandomList(Node head) {
        Node cur = head;
        // 1）每个节点后面复制一个新的副本节点
        // 如原来是 A->B->C->D
        // 复制后：A->A'->B->B'->C->C'->D->D'
        while (cur != null) {
            Node nodeNew = new Node(cur.val);
            nodeNew.next = cur.next;
            cur.next = nodeNew;
            cur = nodeNew.next;
        }
        cur = head;
        // 2）副本节点的 random 指向原始节点的random.next
        // A'.random -> A.random.next
        while (cur != null) {
            Node nodeNew = cur.next;
            nodeNew.random = cur.random != null ? cur.random.next : null;
            cur = nodeNew.next;
        }
        Node newHead = head != null ? head.next : null;
        cur = head;
        // 3）从 A->A'->B->B'->C->C'->D->D' 中挑出 A'->B'->C'->D'
        while (cur != null) {
            // 保存副本节点
            Node newNode = cur.next;
            // 1、先更新原始节点的 next 指针
            cur.next = cur.next.next;
            // 2、再更新副本节点的 next 指针，
            newNode.next = newNode.next.next;
            // 比如 cur=A, newNode=A'，如果 1 2 顺序调换，
            // 就变成 A'->B'->C->C'->...
            //        A->B'，即 A 和 A' 的 next 都指向 B'
            // 那么将没有指针指向 B，导致无法遍历到 B
            cur = cur.next;
        }
        return newHead;
    }

    private static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    ", next=" + (next != null ? next.val : null) +
                    ", random=" + (random != null ? random.val : null) +
                    '}';
        }
    }
}
