package bytedance

fun main() {
    // 1. 两数之和
    // https://leetcode.cn/problems/two-sum/
    println(twoSum(intArrayOf(2,7,11,15), 9).contentToString())
}

fun twoSum(nums: IntArray, target: Int): IntArray {

    val map = HashMap<Int, Int>()
    for (i in nums.indices) {
        val i1 = map[target - nums[i]]
        if (i1 != null) {
            return intArrayOf(i, i1)
        }else {
            map[nums[i]] = i
        }
    }
    return intArrayOf(0,0)
}