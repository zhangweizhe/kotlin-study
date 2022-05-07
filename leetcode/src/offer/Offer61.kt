package offer

fun main() {
    // 剑指 Offer 61. 扑克牌中的顺子
    // https://leetcode-cn.com/problems/bu-ke-pai-zhong-de-shun-zi-lcof/

    println(isStraight1(intArrayOf(1,2,5,0,3)))
}

/**
 * 排序，遍历排序后的数组
 * 计算 0 的数量 zeroCount
 * 遍历到非0元素时：1）如果 nums[i] == nums[i+1]，则 return false
 * 2）如果 nums[i+1] - nums[i] > 1，
 * 说明相邻的两个数不是连续的，中间的间隙需要 zeroCount 来补，所以执行 zeroCount -= (nums[i+1] - nums[i] - 1)
 * 最后如果 zeroCount >= 0，表示 0 的个数足够补充间隙，return true，否则 return false
 */
fun isStraight(nums: IntArray): Boolean {

    nums.sort()

    var zeroCount = 0
    for (i in 0 until (nums.size - 1)) {
        if (nums[i] == 0) {
            zeroCount++
        }else if (nums[i+1] - nums[i] > 1){
            zeroCount -= (nums[i+1] - nums[i] - 1)
        }else if (nums[i+1] == nums[i]) {
            return false
        }
    }
    return zeroCount >= 0
}

/**
 * 组成顺子的充分条件是：
 * 1）nums 中没有重复的数字（非0）
 * 2）数组最大值 - 最小值 < 5
 */
fun isStraight1(nums: IntArray): Boolean {

    nums.sort()

    // 第一个非0元素的下标，即是非0的最小元素
    var firstNoZeroIndex = 0

    for (i in 0 until (nums.size - 1)) {
        if (nums[i] == 0) {
            firstNoZeroIndex++
        }else {
            if (nums[i] == nums[i+1]) {
                // 非0的重复元素
                return false
            }
        }
    }
    return nums[4] - nums[firstNoZeroIndex] < 5
}