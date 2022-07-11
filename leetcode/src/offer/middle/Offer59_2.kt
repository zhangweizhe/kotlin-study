package offer.middle

import java.util.*

fun main() {
    // 剑指 Offer 59 - II. 队列的最大值
    // https://leetcode.cn/problems/dui-lie-de-zui-da-zhi-lcof/
    val maxQueue = MaxQueue()
    println(maxQueue.max_value())
    println(maxQueue.pop_front())
    maxQueue.push_back(4)
    maxQueue.push_back(3)
    maxQueue.push_back(0)
    maxQueue.push_back(1)

    println(maxQueue.max_value())
    println(maxQueue.pop_front())
    println(maxQueue.max_value())
    println(maxQueue.pop_front())
    println(maxQueue.max_value())
    println(maxQueue.pop_front())
    println(maxQueue.max_value())
    println(maxQueue.pop_front())
}

class MaxQueue() {
    /**
     * 关键点：使用一个辅助队列，每次 push_back 的时候，都把辅助队列队尾比 push_back.value 小的元素弹出，维持辅助队列的单调递减；
     * 因为如果后入队列的一个元素x，比前面的元素大，那只要前面的元素还没出队列，那x就一定是最大的；
     * 根据队列先进先出的特点，前面那些小的元素，肯定比后面大的元素先出队列，所以前面小的元素是不会影响 max 值的了，所以可以把他们从辅助队列中弹出
     */

    private val queue = LinkedList<Int>()
    // 辅助队列，存储最大值
    private val helpQueue = LinkedList<Int>()

    fun max_value(): Int {
        if (helpQueue.isEmpty()) {
            return -1
        }
        return helpQueue.peek()
    }

    fun push_back(value: Int) {
        queue.offer(value)
        // 把辅助队列队尾比 value 小的元素，都弹出，保证辅助队列是单调递减的
        // 虽然这里有循环，但并不是每次 push_back 都要执行这个循环，分摊到 n 个数上的话，就是 O(1) 的时间复杂度
        while (helpQueue.isNotEmpty() && helpQueue.last < value) {
            helpQueue.pollLast()
        }
        helpQueue.offer(value)
    }

    fun pop_front(): Int {
        if (queue.isEmpty()) {
            return -1
        }
        val pop = queue.pop()
        if (pop == helpQueue.peek()) {
            helpQueue.pop()
        }
        return pop
    }

}