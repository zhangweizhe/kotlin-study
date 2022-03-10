package linkedlist;

public class Q160 {

    /**
     * 160. 相交链表
     * https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
     * @param args
     */
    public static void main(String[] args) {

    }

    private static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA = 0;
        int lengthB = 0;

        ListNode pA = headA;
        ListNode pB = headB;

        while (pA != null) {
            pA = pA.next;
            lengthA++;
        }

        while (pB != null) {
            pB = pB.next;
            lengthB++;
        }

        ListNode pLong;
        ListNode pShort;

        if (lengthA > lengthB) {
            pLong = headA;
            pShort = headB;
        }else {
            pLong = headB;
            pShort = headA;
        }


        int delta = Math.abs(lengthA - lengthB);
        while (delta > 0) {
            pLong = pLong.next;
            delta--;
        }

        while (pLong != null && pShort != null) {
            if (pLong == pShort) {
                return pLong;
            }else {
                pLong = pLong.next;
                pShort = pShort.next;
            }
        }

        return null;
    }



    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    private static ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
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

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) {
     *         val = x;
     *         next = null;
     *     }
     * }
     */
}
