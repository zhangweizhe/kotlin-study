package linkedlist;

public class Q61 {

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, 5};
    }

    private static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = head;
        ListNode prev = null;
        int length = 0;
        while (p != null) {
            prev = p;
            p = p.next;
            length++;
        }
        k = k % length;
        if (k == 0) {
            return head;
        }
        prev.next = head;
        p = head;
        k = length - k;
        while (k > 0) {
            prev = p;
            p = p.next;
            k--;
        }
        prev.next = null;
        return p;
    }


    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
