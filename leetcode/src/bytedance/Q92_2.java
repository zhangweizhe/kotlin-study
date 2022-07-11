package bytedance;

import linkedlist.ListNode;

public class Q92_2 {
    public static void main(String[] args) {
        // 92. 反转链表 II
        // https://leetcode.cn/problems/reverse-linked-list-ii/
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
        l1.next.next = null;
        ListNode listNode = reverseBetween(l1, 1, 2);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode prev = null;
        ListNode fakeHead = new ListNode(-1, head);
        ListNode cur = head;
        ListNode beforeLeft = null;
        ListNode leftNode = null;
        // 记录 current 指针指向的节点的索引，从1开始的
        int count = 1;
        // 找到 left 所在的节点
        while (cur != null) {
            if (count == left) {
                leftNode = cur;
                beforeLeft = prev;
                break;
            }
            prev = cur;
            cur = cur.next;
            count++;
        }
        prev = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
            if (count == right) {
                break;
            }
            count++;
        }
        if (beforeLeft != null) {
            beforeLeft.next = prev;
        }else {
            fakeHead.next = prev;
        }
        if (leftNode != null) {
            leftNode.next = cur;
        }
        return fakeHead.next;
    }
}
