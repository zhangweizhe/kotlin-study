package bytedance;


import linkedlist.Q0207;

public class Q2 {

    public static void main(String[] args) {
        // 2. 两数相加
        // https://leetcode.cn/problems/add-two-numbers/
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(1);
        ListNode cur = head;
        int add = 0;// 进位
        while (l1 != null && l2 != null) {
            int n = l1.val + l2.val + add;
            add = n / 10;
            n %= 10;
            ListNode newNode = new ListNode(n);
            cur.next = newNode;
            cur = newNode;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int n = l1.val + add;
            add = n/10;
            n %= 10;
            ListNode newNode = new ListNode(n);
            cur.next = newNode;
            cur = newNode;
            l1 = l1.next;
        }
        while (l2 != null) {
            int n = l2.val + add;
            add = n/10;
            n %= 10;
            ListNode newNode = new ListNode(n);
            cur.next = newNode;
            cur = newNode;
            l2 = l2.next;
        }
        if (add == 1) {
            cur.next = new ListNode(1);
        }
        return head.next;
    }

    private static class ListNode {
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
            next = null;
        }
    }
}
