package stack;

import java.util.Stack;

public class Q155 {

    // 155. 最小栈
    // https://leetcode-cn.com/problems/min-stack/

    public static void main(String[] args) {
        MinStack1 minStack = new MinStack1();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());;  // --> 返回 -3.
        minStack.pop();
        minStack.top();     // --> 返回 0.
        System.out.println(minStack.getMin());;  // --> 返回 -2.

    }

}
class MinStack1 {

    /** initialize your data structure here. */

    public MinStack1() {

    }

    private int minVal = Integer.MAX_VALUE;
    private Node head = new Node();

    public void push(int val) {
        Node newNode = new Node();
        newNode.val = val;
        newNode.next = head.next;
        head.next = newNode;
        if (minVal > val) {
            minVal = val;
        }
    }

    public void pop() {
        if (head.next == null) {
            return;
        }
        int popVal = head.next.val;
        head.next = head.next.next;
        if (popVal == minVal) {
            Node cur = head.next;
            minVal = Integer.MAX_VALUE;
            while (cur != null) {
                if (cur.val < minVal) {
                    minVal = cur.val;
                }
                cur = cur.next;
            }
        }
    }

    public int top() {
        if (head.next == null) {
            return 0;
        }
        return head.next.val;
    }

    public int getMin() {
        return minVal;
    }
}

class Node {
    public int val;
    public Node next;
}

/**
 * 双栈法
 */
class MinStack2 {

    /** initialize your data structure here. */

    public MinStack2() {

    }

    private Stack<Integer> valStack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public void push(int val) {
        valStack.push(val);
        if (minStack.isEmpty()) {
            minStack.push(val);
        }else {
            minStack.push(Math.min(val, minStack.peek()));
        }
    }

    public void pop() {
        if (!valStack.isEmpty()) {
            valStack.pop();
            minStack.pop();
        }
    }

    public int top() {
        if (!valStack.isEmpty()) {
            return valStack.peek();
        }
        return 0;
    }

    public int getMin() {
        if (!minStack.isEmpty()) {
            return minStack.peek();
        }
        return 0;
    }
}

