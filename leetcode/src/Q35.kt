fun main() {
    // https://leetcode-cn.com/problems/search-insert-position/
    //println(searchInsert(intArrayOf(3,5,7,9,10), 8))
    println(binSearch1(intArrayOf(1), 1))
}

fun searchInsert(nums: IntArray, target: Int): Int {
    return binSearch(nums, target, 0, nums.size - 1)
}

fun binSearch(nums: IntArray, target: Int, start: Int, end: Int):Int {
    if (start >= end) {
        if (nums[start] >= target) {
            return start
        }else{
            return start + 1
        }
    }
    var center = (start + end) / 2
    if (target == nums[center]) {
        return center
    }
    if (target < nums[center]) {
        return binSearch(nums, target, start, center - 1)
    }else {
        return binSearch(nums, target, center + 1, end)
    }
}

fun binSearch1(nums: IntArray, target: Int):Int {
    val n = nums.size
    var left = 0
    var right = n - 1
    while (left <= right) {
        var mid = (left + right) / 2
        when {
            nums[mid] == target -> {
                return mid
            }
            nums[mid] > target -> {
                right = mid - 1
            }
            else -> {
                left = mid + 1
            }
        }
    }
    println("left: $left, right: $right")
    return -1
}