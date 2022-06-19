package offer.middle

fun main() {
    // 剑指 Offer 56 - II. 数组中数字出现的次数 II
    // https://leetcode.cn/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-ii-lcof/
    println(singleNumber1(intArrayOf(1,1,1,-3,-2,-3,-3)))
}

fun singleNumber(nums: IntArray): Int {

    // 计算 nums 各个数字，在各个位上1的数量
    // 如果某一位上1的数量，不能被3整除，说明这一位上的1就是来自那个只出现一次的数字
    var result = 0
    for (i in 0..31) {
        var oneCount = 0
        for (j in nums) {
            oneCount += (j.ushr(i).and(1))
        }
        if (oneCount % 3 != 0) {
            // i 位上的 1，来自只出现一次的数字，通过把1左移i位，恢复到 result 上
            result = result.or(1.shl(i))
        }
    }
    return result
}

fun singleNumber1(nums: IntArray): Int {
    // 计算 nums 各个数字，在各个位上1的数量
    // 如果某一位上1的数量，不能被3整除，说明这一位上的1就是来自那个只出现一次的数字
    var res = 0
    for (i in 0..31) {
        var oneCount = 0
        val shl = 1.shl(i)
        for (n in nums) {
            if (n.and(shl) != 0) {
                oneCount++
            }
        }
        if (oneCount % 3 != 0) {
            res = res.or(shl)
        }
    }
    return res
}