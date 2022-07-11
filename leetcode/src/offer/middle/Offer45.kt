package offer.middle

import java.lang.StringBuilder

fun main() {
    // 剑指 Offer 45. 把数组排成最小的数
    // https://leetcode.cn/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof/
    println(minNumber(intArrayOf(3,30,34,5,9)))
}

fun minNumber(nums: IntArray): String {
    mergeSort(nums, 0, nums.size - 1)
    val sb = StringBuilder()
    for (i in nums) {
        sb.append(i)
    }
    return sb.toString()
}

private fun mergeSort(nums: IntArray, start: Int, end: Int) {
    if (start >= end) {
        return
    }
    val mid = (start + end) / 2
    mergeSort(nums, start, mid)
    mergeSort(nums, mid+1, end)
    var leftIndex = start
    var rightIndex = mid + 1
    var k = 0
    val tmpArray = IntArray(end - start + 1)
    while (leftIndex <= mid && rightIndex <= end) {
        val leftNum = nums[leftIndex] //6
        val rightNum = nums[rightIndex] //35
        val m = leftNum.toString() + rightNum.toString() //635
        val n = rightNum.toString() + leftNum.toString() //356
        if (m > n) {
            tmpArray[k++] = rightNum
            rightIndex++
        }else {
            tmpArray[k++] = leftNum
            leftIndex++
        }
    }
    while (leftIndex <= mid) {
        tmpArray[k++] = nums[leftIndex++]
    }
    while (rightIndex <= end) {
        tmpArray[k++] = nums[rightIndex++]
    }
    // 放回原数组
    for (i in tmpArray.indices) {
        nums[start + i] = tmpArray[i]
    }
}