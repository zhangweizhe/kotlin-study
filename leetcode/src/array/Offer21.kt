package array

fun main() {
    // 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
    // https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/
    println(exchange1(intArrayOf(1,3,2,4,5,6)).contentToString())
}

private fun exchange(nums: IntArray): IntArray {

    val ret = IntArray(nums.size)

    var left = 0
    var right = nums.size - 1

    for (i in nums) {
        if (i % 2 == 0) {
            ret[right--] = i
        }else {
            ret[left++] = i
        }
    }
    return ret
}
private fun exchange1(nums: IntArray): IntArray {

    var left = 0
    var right = nums.size - 1
    val size = nums.size

    while (left < right) {
        while (left < size && nums[left] % 2 != 0) {
            left++
        }
        while (right >= 0 && nums[right] % 2 == 0) {
            right--
        }
        if (left < right) {
            val tmp = nums[left]
            nums[left] = nums[right]
            nums[right] = tmp
            left++
            right--
        }
    }
    return nums
}

fun exchange2(nums: IntArray): IntArray {

    var left = 0
    var right = nums.size - 1
    var p = 0

    while (left < right) {
        while (nums[left] % 2 == 1 && left < right) {
            left++
        }
        while (nums[right] % 2 == 0 && left < right) {
            right--
        }
        val tmp = nums[left]
        nums[left] = nums[right]
        nums[right] = tmp
    }
    return nums

}