package queue

import java.util.*

fun main() {
    // 剑指 Offer II 041. 滑动窗口的平均值
    // https://leetcode-cn.com/problems/qIsx9U/
    val movingAverage = MovingAverage(3)
    println(movingAverage.next(1))
    println(movingAverage.next(10))
    println(movingAverage.next(3))
    println(movingAverage.next(5))
}

class MovingAverage(size: Int) {

    /** Initialize your data structure here. */
    private val mSize = size
    private val queue = LinkedList<Int>()
    private var sum = 0

    fun next(`val`: Int): Double {
        if (queue.size == mSize) {
            sum -= queue.poll()
        }
        queue.offer(`val`)
        sum += `val`
        return sum * 1.0 / queue.size

    }

}