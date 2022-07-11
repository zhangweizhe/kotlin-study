package offer

fun main() {
    // 剑指 Offer 53 - I. 在排序数组中查找数字 I
    // https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/
    println(search(intArrayOf(5,7,7,8,8,10), 10))
}

fun search(nums: IntArray, target: Int): Int {

    val left = help(0, nums.size - 1, nums, target - 1)
    val right = help(left, nums.size - 1, nums, target)
    return (right - left)
}

private fun help(left: Int, right: Int, nums: IntArray, target: Int):Int {

    var l = left
    var r = right
    while (l <= r) {
        val m = (l + r)/2
        if (target >= nums[m]) {
            l = m + 1
        }else {
            r = m - 1
        }
    }
    return l
//
//    var i = 0
//    var j = nums.size - 1
//    while (i <= j) {
//
//    }
}