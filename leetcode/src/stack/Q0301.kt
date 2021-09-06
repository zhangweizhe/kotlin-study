package stack

fun main() {
    // 面试题 03.01. 三合一
    // https://leetcode-cn.com/problems/three-in-one-lcci/

    val tripleInOne = TripleInOne(1)
    tripleInOne.push(0,1)
    tripleInOne.push(0, 2)
    println(tripleInOne.pop(0))
    println(tripleInOne.pop(0))
    println(tripleInOne.pop(0))
    println(tripleInOne.isEmpty(0))
}

class TripleInOne(stackSize: Int) {

    val size = stackSize

    val table = Array(3) {
        IntArray(stackSize)
    }

    val length = intArrayOf(0, 0, 0)

    fun push(stackNum: Int, value: Int) {
        if (length[stackNum] == size) {
            return
        }
        table[stackNum][length[stackNum]] = value
        length[stackNum]++
    }

    fun pop(stackNum: Int): Int {
        if (isEmpty(stackNum)) {
            return -1
        }
        val pop = table[stackNum][length[stackNum]-1]
        length[stackNum]--
        return pop
    }

    fun peek(stackNum: Int): Int {
        val i = length[stackNum]-1
        if (i < 0) {
            return -1
        }
        return table[stackNum][i]
    }

    fun isEmpty(stackNum: Int): Boolean {
        return length[stackNum] <= 0
    }

}