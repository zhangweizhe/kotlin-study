package array

fun main() {
    // 剑指 Offer 03. 数组中重复的数字
    // https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
    println(findRepeatNumber2(intArrayOf(2, 3, 1, 0, 2, 5, 3)))
}

fun findRepeatNumber(nums: IntArray): Int {

    val list = HashSet<Int>(nums.size)

    for (i in nums) {
        if (list.contains(i)) {
            return i
        }else {
            list.add(i)
        }
    }
    return -1
}


fun findRepeatNumber1(nums: IntArray): Int {

    var i = 0
    while (i < nums.size) {
        while (nums[i] == i) {
            i++
        }
        if (nums[i] == nums[nums[i]]) {
            return nums[i]
        }
        /**
         *注意不能写为：因为 nums[nums[i]] 是依赖 nums[i] 的，所以 nums[i] 要晚于 nums[nums[i]] 被修改
         * val tmp = nums[i]
         * nums[i] = nums[nums[i]]
         * nums[nums[i]] = tmp
         */
        val tmp = nums[nums[i]]
        nums[nums[i]] = nums[i]
        nums[i] = tmp
        i++
    }

    return -1
}


fun findRepeatNumber2(nums: IntArray): Int {

    var i = 0
    while (i < nums.size) {
        while (nums[i] == i) {
            i++
        }
        if (nums[i] == nums[nums[i]]) {
            return nums[i]
        }
        val tmp = nums[nums[i]]
        nums[nums[i]] = nums[i]
        nums[i] = tmp
    }
    return -1

}

