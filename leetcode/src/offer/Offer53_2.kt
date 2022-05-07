package offer

fun main() {
    // 剑指 Offer 53 - II. 0～n-1中缺失的数字
    // https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof/
    println(missingNumber(intArrayOf(0,1,2,3)))
}

fun missingNumber(nums: IntArray): Int {

    var left = 0
    var right = nums.size - 1
    var mid = 0
    while (left <= right) {
        mid = (left + right)/2
        // nums[mid] 只会大于等于 mid，不会小于 mid
        if (nums[mid] == mid) {
            left = mid + 1
        }else {
            // nums[mid] > mid
            right = mid - 1
        }
    }
    return left
}