package offer

fun main() {
    // 剑指 Offer 53 - I. 在排序数组中查找数字 I
    // https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/
    println(search(intArrayOf(5,7,7,8,8,10), 8))
}

fun search(nums: IntArray, target: Int): Int {

    var left = 0
    var right = nums.size - 1
    var mid = 0
    while (left < right) {
        mid = (left + right) / 2
        if (nums[mid] > target) {
            right = mid - 1
        }else if (nums[mid] < target) {
            left = mid + 1
        }else {
            break
        }
    }
    var count = 0
    for (i in left..right) {
        if (nums[i] == target) {
            count++
        }
    }
    return count
}