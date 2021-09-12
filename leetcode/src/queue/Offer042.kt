package queue

import java.util.*

fun main() {
    // 剑指 Offer II 042. 最近请求次数
    // https://leetcode-cn.com/problems/H8086Q/
    val recentCounter = RecentCounter()
    println(recentCounter.ping(1))
    println(recentCounter.ping(100))
    println(recentCounter.ping(3001))
    println(recentCounter.ping(3002))
    println(recentCounter.ping(3100))
}

class RecentCounter() {

    private val queue = LinkedList<Int>()

    fun ping(t: Int): Int {
        queue.offer(t)
        while (queue.isNotEmpty() && queue.peek() < t - 3000) {
            queue.poll()
        }
        return queue.size
    }

}