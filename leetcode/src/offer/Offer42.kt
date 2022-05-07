package offer

fun main() {
    // https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/
    // 剑指 Offer 42. 连续子数组的最大和

    println(maxSubArray1(intArrayOf(1)))
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