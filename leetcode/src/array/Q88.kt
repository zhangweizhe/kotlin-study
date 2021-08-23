package array

fun main() {
    // 88. 合并两个有序数组
    // https://leetcode-cn.com/problems/merge-sorted-array/
    val nums1 = intArrayOf(1, 2, 3, 0, 0, 0)
    merge(nums1, 3, intArrayOf(2,5,6), 3)
    println(nums1.contentToString())
}

fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
    val tmpArray = IntArray(nums1.size)

    var p1 = 0
    var p2 = 0
    var pT = 0
    while (p1 < m && p2 < n) {
        if (nums1[p1] < nums2[p2]) {
            tmpArray[pT++] = nums1[p1++]
        }else {
            tmpArray[pT++] = nums2[p2++]
        }
    }
    while (p1 < m) {
        tmpArray[pT++] = nums1[p1++]
    }
    while (p2 < n) {
        tmpArray[pT++] = nums2[p2++]
    }
    for ((index, num) in tmpArray.withIndex()) {
        nums1[index] = tmpArray[index]
    }
}