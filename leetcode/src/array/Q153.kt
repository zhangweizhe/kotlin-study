package array

fun main() {
    // 153. 寻找旋转排序数组中的最小值
    // https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
    println(findMin(intArrayOf(2,3,4,0,1)))
}

private fun findMin(nums: IntArray): Int {

    var left = 0
    var right = nums.size - 1
    var mid = (left + right)/2
    while (left < right) {
        if (nums[mid] > nums[right]) {
            left = mid + 1
        }else if (nums[mid] < nums[right]) {
            right = mid
        }else {
            right--
        }
        mid = (left + right)/2
    }
    return nums[left]
}