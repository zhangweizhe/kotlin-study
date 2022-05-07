package offer

fun main() {
    // 剑指 Offer 57 - II. 和为s的连续正数序列
    // https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/
    println(findContinuousSequence(15).contentDeepToString())
}

fun findContinuousSequence(target: Int): Array<IntArray> {
    // 滑动窗口左边界
    var left = 1
    // 滑动窗口右边界
    var right = 2
    var sum = left + right
    val result = mutableListOf<IntArray>()
    while(left < right) {
        if (sum == target) {
            val tmp = IntArray(right - left + 1)
            var i = 0
            for (num in left..right) {
                tmp[i++] = num
            }
            result.add(tmp)
            sum -= left
            // 左边界右移一步
            left++
        }else if (sum < target) {
            // 右边界右移
            right++
            sum += right
        }else {
            sum -= left
            // sum > target，左边界右移
            left++
        }
    }
    return result.toTypedArray()
}