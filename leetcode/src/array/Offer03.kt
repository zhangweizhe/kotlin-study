package array

fun main() {
    // 剑指 Offer 03. 数组中重复的数字
    // https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
    println(findRepeatNumber(intArrayOf(2, 3, 1, 0, 2, 5, 3)))
}

fun findRepeatNumber(nums: IntArray): Int {

    val list = HashSet<Int>(nums.size)

    for (i in nums) {
        if (list.contains(i)) {
            return i
        }else {
            list.add(i)
        }
    }
    return -1
}