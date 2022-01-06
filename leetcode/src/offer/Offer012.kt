package offer

fun main() {
    // https://leetcode-cn.com/problems/tvdfij/
    // 剑指 Offer II 012. 左右两边子数组的和相等

    println(pivotIndex1(intArrayOf(1,7,3,6,5,6)))
}

private fun pivotIndex(nums: IntArray): Int {

    val leftSums = IntArray(nums.size)
    val rightSums = IntArray(nums.size)

    leftSums[0] = nums[0]
    rightSums[nums.size - 1] = nums[nums.size - 1]

    for (i in 1 until nums.size) {
        leftSums[i] = leftSums[i-1] + nums[i]
        rightSums[nums.size - i - 1] = rightSums[nums.size - i] + nums[nums.size - i - 1]
    }

    for (i in nums.indices) {
        if (leftSums[i] == rightSums[i]) {
            return i
        }
    }

    return -1
}

private fun pivotIndex1(nums: IntArray): Int {

    val total = nums.sum()

    var sum = 0

    for (i in nums.indices) {
        if (2 * sum + nums[i] == total) {
            return i
        }
        sum += nums[i]
    }

    return -1
}