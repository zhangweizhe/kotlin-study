package queue

import java.util.*

fun main() {
    // 面试题 03.06. 动物收容所
    // https://leetcode-cn.com/problems/animal-shelter-lcci/
}

class AnimalShelf() {

    private val dogQ = LinkedList<IntArray>()
    private val catQ = LinkedList<IntArray>()
    private val cat = 0

    fun enqueue(animal: IntArray) {
        val type = animal[1]
        if (type == cat) {
            catQ.offer(animal)
        }else {
            dogQ.offer(animal)
        }
    }

    fun dequeueAny(): IntArray {
        if (dogQ.isEmpty() && catQ.isEmpty()) {
            return intArrayOf(-1, -1)
        }
        if (dogQ.isEmpty()) {
            return catQ.poll()
        }
        if (catQ.isEmpty()) {
            return dogQ.poll()
        }
        return if (dogQ.peek()[0] < catQ.peek()[0]) {
            dogQ.poll()
        }else {
            catQ.poll()
        }
    }

    fun dequeueDog(): IntArray {
        if (dogQ.isEmpty()) {
            return intArrayOf(-1, -1)
        }
        return dogQ.poll()
    }

    fun dequeueCat(): IntArray {
        if (catQ.isEmpty()) {
            return intArrayOf(-1, -1)
        }
        return catQ.poll()
    }

}