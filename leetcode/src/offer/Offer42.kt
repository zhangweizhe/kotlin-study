package offer

fun main() {
    // https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/
    // 剑指 Offer 42. 连续子数组的最大和

    println(maxSubArray2(intArrayOf(1,2,3,-2,3,4)))
}

private fun maxSubArray(nums: IntArray): Int {

    val tmp = IntArray(nums.size)
    tmp[0] = nums[0]
    var max = nums[0]

    for (i in 1 until nums.size) {
        val t = tmp[i-1] + nums[i]
        tmp[i] = Math.max(t, nums[i])
        max = Math.max(tmp[i], max)
    }

    return max
}


private fun maxSubArray1(nums: IntArray): Int {

    var pre = nums[0]
    var max = nums[0]

    var index = 1
    while (index < nums.size) {
        val i = nums[index]
        if (pre < 0) {
            pre = i;
        }else {
            pre += i;
        }
//        pre = Math.max(i, pre + i)
        max = Math.max(max, pre)
        index++
    }

    return max
}

private fun maxSubArray2(nums: IntArray): Int {
    var pre = nums[0]
    var max = nums[0]

    for (i in 1 until nums.size) {
        if (pre < 0) {
            // 前面的和是负数，负增益，直接取当前的数
            pre = nums[i]
        }else {
            // 前面的最大和是非负数，累加到当前这个数上
            pre += nums[i]
        }
        max = Math.max(pre, max)
    }
    return max
}