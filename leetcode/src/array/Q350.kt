package array

fun main() {
    // 350. 两个数组的交集 II
    // https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/
    println(intersect(intArrayOf(1,2,2,1), intArrayOf(2,2)).contentToString())
}

/**
 * 哈希法
 */
fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
    val list = ArrayList<Int>(nums1.size)
    for (i in nums1) {
        list.add(i)
    }
    val result = ArrayList<Int>(Math.min(nums2.size, nums1.size))
    for (i in nums2) {
        if (list.contains(i)) {
            result.add(i)
            list.remove(i)
        }
    }
    return result.toIntArray()
}

/**
 * 双指针法，数组需要排序
 * 定义两个指针分别指向两个数组的头结点
 * 如果两个指针指向的值不相等，则小指针右移一步；
 * 如果两个指针指向的值相等，则把值添加到结果集中，两个指针同时右移一步
 * 时间复杂度O(mlogm+nlogn)，排序的时间复杂度是 O(mlogm+nlogn)
 * 空间复杂度是O(min(m,n))
 */
fun intersect1(nums1: IntArray, nums2: IntArray): IntArray {
    nums1.sort()
    nums2.sort()
    var p1 = 0
    var p2 = 0
    val result = ArrayList<Int>(Math.min(nums1.size, nums2.size))
    while (p1 < nums1.size && p2 < nums2.size) {
        when {
            nums1[p1] == nums2[p2] -> {
                result.add(nums1[p1])
                p1++
                p2++
            }
            nums1[p1] < nums2[p2] -> {
                p1++
            }
            else -> {
                p2++
            }
        }
    }
    return result.toIntArray()
}