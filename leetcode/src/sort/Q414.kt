package sort

fun main() {
    // 414. 第三大的数
    // https://leetcode-cn.com/problems/third-maximum-number/
    val intArrayOf = intArrayOf(1,2,-2147483648)
    println(thirdMax(intArrayOf))
}

fun thirdMax(nums: IntArray): Int {

    var a = Long.MIN_VALUE
    var b = Long.MIN_VALUE
    var c = Long.MIN_VALUE

    for (i in nums) {
        if (i > a) {
            c = b
            b = a
            a = i.toLong()
        }else if (i < a && i > b) {
            c = b
            b = i.toLong()
        }else if (i < b && i > c) {
            c = i.toLong()
        }
    }

    return if (c == Long.MIN_VALUE) {
        a.toInt()
    }else {
        c.toInt()
    }
}

private fun quickSort(nums: IntArray, start: Int, end: Int):Int {

    if (start >= end) {
        return end
    }

    val pivot = nums[end]

    var i = start
    for (j in start until end) {
        if (nums[j] < pivot) {
            val tmp = nums[i]
            nums[i] = nums[j]
            nums[j] = tmp
            i++
        }
    }
    nums[end] = nums[i]
    nums[i] = pivot
    val leftCenter = quickSort(nums, start, i-1)
    val rightCenter = quickSort(nums, i + 1, end)
    if (i == nums.size - 3) {
        println(pivot)
        return i
    }
    if (i > nums.size - 3) {
        return leftCenter
    }
    return rightCenter
}