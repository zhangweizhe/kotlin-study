package sort

fun main() {
    // 268. 丢失的数字
    // https://leetcode-cn.com/problems/missing-number/
    println(missingNumber1(intArrayOf(9,6,4,2,3,5,7,0,1)))
}

private fun missingNumber(nums: IntArray): Int {

    val n = nums.size

    nums.sort()

    var i = 0
    while (i < n-1) {
        if (nums[i+1] - nums[i] > 1) {
            return nums[i+1] - 1
        }
        i++
    }
    return if (nums[0] == 0) {
        // 缺少最后一个数，即n
        n
    }else {
        // 缺少第一个数，即0
        0
    }

}

private fun missingNumber1(nums: IntArray): Int {
    var sum = 0
    val n = nums.size
    for (i in 1..n) {
        sum += i
        sum -= nums[i-1]
    }
    return sum
}
