package linkedlist;

public class Q0207 {
    // 面试题 02.07. 链表相交
    // https://leetcode-cn.com/problems/intersection-of-two-linked-lists-lcci/

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA;
        ListNode pB = headB;
        while (pA != pB) {
            if (pA == null) {
                pA = headB;
            }else {
                pA = pA.next;
            }
            if (pB == null) {
                pB = headA;
            }else {
                pB = pB.next;
            }
        }
        return pA;
    }

}
