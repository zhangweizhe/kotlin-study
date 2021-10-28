package sort

fun main() {
    // 414. 第三大的数
    // https://leetcode-cn.com/problems/third-maximum-number/
    val intArrayOf = intArrayOf(1,1,1)

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

fun thirdMax1(nums: IntArray): Int {

    val set:Set<Int> = HashSet<Int>(nums.toList())
    val setNums = set.toIntArray()

    if (setNums.size == 2) {
        return if (setNums[0] > setNums[1]) {
            setNums[0]
        }else {
            setNums[1]
        }
    }else if (setNums.size == 1) {
        return setNums[0]
    }

    val quickSort = quickSort(setNums, 0, setNums.size - 1)
    println("find index $quickSort")
    println("nums ${setNums.contentToString()}")
    println("find num ${setNums[quickSort]}")
    return setNums[quickSort]
}

private fun quickSort(nums: IntArray, start: Int, end: Int):Int {

    if (start >= end) {
        return end
    }

    val pivot = nums[end]

    var i = start
    for (j in start until end) {
        if (nums[j] > pivot) {
            val tmp = nums[i]
            nums[i] = nums[j]
            nums[j] = tmp
            i++
        }
    }
    nums[end] = nums[i]
    nums[i] = pivot
    if (i == 2) {
        println(pivot)
        return i
    }else if (i > 2) {
        return quickSort(nums, start, i-1)
    }else {
        return quickSort(nums, i+1, end)
    }
}