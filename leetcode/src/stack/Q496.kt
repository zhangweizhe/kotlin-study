package stack

import java.util.*
import kotlin.collections.HashMap

fun main() {
    // 496. 下一个更大元素 I
    // https://leetcode-cn.com/problems/next-greater-element-i/

    println(nextGreaterElement1(intArrayOf(2,4), intArrayOf(1,2,3,4)).contentToString())
}

fun nextGreaterElement(nums1: IntArray, nums2: IntArray): IntArray {

    nums2.reverse()

    val ret = IntArray(nums1.size) {
        -1
    }


    for (i1 in nums1.indices) {
        for (i2 in nums2) {
            if (i2 > nums1[i1]) {
                ret[i1] = i2
            }else if (i2 == nums1[i1]) {
                break
            }
        }
    }

    return ret
}

/**
 * 单调栈，遍历 nums2，依次加入栈中；
 * 如果 i 小于等于栈顶元素，则将 i 加入栈中，此时从栈底到栈顶是递减的；
 * 如果 i 大于栈顶元素，则将栈中元素全部出栈，栈中元素的下一个最大值即为 i
 */
fun nextGreaterElement1(nums1: IntArray, nums2: IntArray): IntArray {

    val map = HashMap<Int, Int>(nums2.size)

    val stack = LinkedList<Int>()
    for (i in nums2) {
        while (stack.isNotEmpty() && i > stack.peek()) {
            map[stack.pop()] = i
        }
        stack.push(i)
    }

    val ret = IntArray(nums1.size)
    for (i in nums1.indices) {
        if (map.containsKey(nums1[i])) {
            ret[i] = map[nums1[i]]!!
        }else {
            ret[i] = -1
        }
    }
    return ret
}