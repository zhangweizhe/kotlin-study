package offer

fun main() {
    // https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/
    // 剑指 Offer 42. 连续子数组的最大和

    println(maxSubArray1(intArrayOf(-2,1,-3,4,-1,2,1,-5,4)))
}

private fun maxSubArray(nums: IntArray): Int {

    val tmp = IntArray(nums.size)
    tmp[0] = nums[0]

    for (i in 1 until nums.size) {
        val t = tmp[i-1] + nums[i]
        tmp[i] = Math.max(t, nums[i])
    }

    var max = tmp[0]
    for (i in tmp) {
        if (max < i) {
            max = i
        }
    }

    return max
}


private fun maxSubArray1(nums: IntArray): Int {

    var pre = 0
    var max = nums[0]

    for (i in nums) {
        pre = Math.max(i, pre + i)
        max = Math.max(max, pre)
    }

    return max
}