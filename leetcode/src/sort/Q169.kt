package sort

fun main() {
    // 169. 多数元素
    // https://leetcode-cn.com/problems/majority-element/
    println(majorityElement2(intArrayOf(2,2,1,1,1,2,2)))
}

/**
 * 排序法，排序后的数组，nums[n/2] 一定是众数
 * 时间复杂度由排序算法决定
 */
fun majorityElement1(nums: IntArray): Int {

    // 使用快速排序
    quickSort(nums, 0, nums.size - 1)
    return nums[nums.size/2]
}

/**
 * 快速排序
 */
private fun quickSort(nums: IntArray, start: Int, end: Int) {
    if (start >= end) {
        return
    }
    // 分区
    val pivot = nums[end]
    var i = start
    for (j in start until end) {
        if (nums[j] < pivot) {
            val tmp = nums[j]
            nums[j] = nums[i]
            nums[i] = tmp
            i++
        }
    }
    nums[end] = nums[i]
    nums[i] = pivot

    // 分区完成，继续对左右分区执行快排
    quickSort(nums, start, i - 1)
    quickSort(nums, i + 1, end)
}

/**
 * 投票法
 */
fun majorityElement2(nums: IntArray): Int {

    var result = 0
    // 遍历数组，sum 为 0 时，把遍历到的元素 i 赋给 result；sum 不为 0 时，如果 i == result，则 sum++，否则 sum--
    // 遍历完成后，result 即是众数（关键条件：众数出现次数大于 n/2）
    var sum = 0

    for (i in nums) {
        if (sum == 0) {
            result = i
        }
        if (result == i) {
            sum++
        }else {
            sum--
        }
    }
    return result
}