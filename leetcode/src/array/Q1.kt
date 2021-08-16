package array

import java.util.*
import kotlin.collections.HashMap

fun main() {
    // 1. 两数之和
    // https://leetcode-cn.com/problems/two-sum/
    println(twoSum(intArrayOf(2, 7, 11, 15), 9).contentToString())
}

fun twoSum(nums: IntArray, target: Int): IntArray {
    val map = HashMap<Int, Int>(nums.size)
    for ((i, num) in nums.withIndex()) {
        if (map.containsKey(target - num)) {
            return intArrayOf(i, map[target - num]!!)
        }else {
            map[num] = i
        }
    }
    return intArrayOf(0,0)
}