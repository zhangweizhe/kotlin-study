package offer

fun main() {
    // 剑指 Offer II 006. 排序数组中两个数字之和
    // https://leetcode-cn.com/problems/kLl5u1/

    println(twoSum1(intArrayOf(1,2,4,6,10), 8).contentToString())
}

fun twoSum(numbers: IntArray, target: Int): IntArray {

    for (i in numbers.indices) {
        for (j in (i+1) until numbers.size) {
            if (numbers[i] + numbers[j] == target) {
                return intArrayOf(i, j)
            }
        }
    }

    return intArrayOf(0,0)
}

fun twoSum1(numbers: IntArray, target: Int): IntArray {

    var left = 0
    var right = numbers.size - 1

    while (left < right) {
        if (numbers[left] + numbers[right] == target) {
            return intArrayOf(left, right)
        }else if (numbers[left] + numbers[right] > target) {
            right--
        }else {
            left++
        }
    }

    return intArrayOf(left, right)
}