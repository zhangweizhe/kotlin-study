package queue

import java.util.*

fun main() {
    // 1700. 无法吃午餐的学生数量
    // https://leetcode-cn.com/problems/number-of-students-unable-to-eat-lunch/
    println(countStudents1(intArrayOf(1,1,1,0,0,1), intArrayOf(1,0,0,0,1,1)))
}

fun countStudents(students: IntArray, sandwiches: IntArray): Int {

    val stuQueue = LinkedList<Int>()
    val sandStack = Stack<Int>()

    for (s in students) {
        stuQueue.offer(s)
    }
    for (s in sandwiches.reversedArray()) {
        sandStack.push(s)
    }

    var remainStuCount = students.size

    var loopCount = 0

    while (remainStuCount != loopCount-1 && stuQueue.isNotEmpty() && sandStack.isNotEmpty()) {
        if (stuQueue.peek() == sandStack.peek()) {
            stuQueue.poll()
            sandStack.pop()
            loopCount = 0
            remainStuCount--
        }else {
            loopCount++
            stuQueue.offer(stuQueue.poll())
        }
    }

    return remainStuCount
}

/**
 * 统计两种学生的数量
 * 遍历三明治数组，如果当前的三明治没有学生喜欢了，退出遍历，剩下的学生数量即是无法吃午餐的学生数量
 */
fun countStudents1(students: IntArray, sandwiches: IntArray): Int {

    val stuLike = IntArray(2)
    for (i in students) {
        stuLike[i]++
    }

    for (s in sandwiches) {
        if (stuLike[s] > 0) {
            stuLike[s]--
        }else {
            break
        }
    }
    return stuLike[0] + stuLike[1]
}