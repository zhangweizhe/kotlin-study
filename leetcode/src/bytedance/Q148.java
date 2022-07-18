package bytedance;

import linkedlist.ListNode;

public class Q148 {
    public static void main(String[] args) {
        // 148. 排序链表
        // https://leetcode.cn/problems/sort-list/
        ListNode l5 = new ListNode(-1);
        ListNode l4 = new ListNode(5, l5);
        ListNode l3 = new ListNode(3, l4);
        ListNode l2 = new ListNode(4, l3);
        ListNode l1 = new ListNode(0, l2);

        Q148 q148 = new Q148();
        ListNode listNode = q148.sortList(l1);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
    public ListNode sortList(ListNode head) {

        // 1、计算链表长度length
        // 2、采用归并排序，从下向上归并
        // 3、定义子长度 subLength，初始值是1
        // 4、从链表头部开始，把相邻的两个长度为 subLength 的链表执行归并排序
        // 5、每次链表遍历结束后，就把 subLength*=2，循环执行第4步，直到 subLength >= length，退出循环，此时链表就是有序的

        // 1、计算链表长度 length
        int length = 0;
        ListNode cur = head;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        // 3、定义子长度 subLength，初始值是1
        ListNode fakeHead = new ListNode(-100, head);
        for (int subLength = 1; subLength < length; subLength *= 2) {
            // 当前这一组左右链表的前一个节点
            ListNode pairPrev = fakeHead;
            // 4、从链表头部开始，把相邻的两个长度为 subLength 的链表执行归并排序
            cur = fakeHead.next;
            while (cur != null) {
                // 4.1 取左边长度为 subLength 的子链表
                ListNode leftSubListHead = cur;
                // 4.2 向后走 subLength 步，取 rightSubListHead
                ListNode prev = null;
                for (int i=0; i<subLength && cur != null;) {
                    prev = cur;
                    cur = cur.next;
                    i++;
                }
                // 把左边链表最后一个节点，和右边链表的头节点断开
                prev.next = null;
                ListNode rightSubListHead = cur;
                for (int i=0; i<subLength && cur != null;) {
                    // cur 定位到下一组归并排序的子链表的头节点
                    prev = cur;
                    cur = cur.next;
                    i++;
                }
                // 把右边链表的最后一个节点，和下一组左右子链表的左链表的头节点断开
                prev.next = null;
                // 执行归并排序
                pairPrev.next = mergeSort(leftSubListHead, rightSubListHead);
                while (pairPrev.next != null) {
                    pairPrev = pairPrev.next;
                }
            }
        }
        return fakeHead.next;
    }

    private ListNode mergeSort(ListNode l1, ListNode l2) {
        ListNode c1 = l1;
        ListNode c2 = l2;
        ListNode fakeHead = new ListNode(-1);
        ListNode cur = fakeHead;
        while (c1 != null && c2 != null) {
            if (c1.val <= c2.val) {
                cur.next = c1;
                c1 = c1.next;
            }else {
                cur.next = c2;
                c2 = c2.next;
            }
            cur = cur.next;
        }
        if (c1 != null) {
            cur.next = c1;
        }
        if (c2 != null) {
            cur.next = c2;
        }
        return fakeHead.next;
    }
}
