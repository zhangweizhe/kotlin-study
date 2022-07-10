package bytedance;

import linkedlist.ListNode;

public class Offer24 {
    public static void main(String[] args) {
        // 剑指 Offer 24. 反转链表
        // https://leetcode.cn/problems/fan-zhuan-lian-biao-lcof/
    }
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;

    }
}
