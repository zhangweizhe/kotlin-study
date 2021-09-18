package array

fun main() {
    // 剑指 Offer 11. 旋转数组的最小数字
    // https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/
    println(minArray2(intArrayOf(3,1,1)))
}

/**
 * 暴力解法，直接遍历整个数据，找到最小值
 */
fun minArray(numbers: IntArray): Int {

    var min = Int.MAX_VALUE
    for (i in numbers) {
        if (i < min) {
            min = i
        }
    }
    return min
}

/**
 * 利用递增旋转数组的特性，
 * 如果 numbers[i] < numbers[i-1]，则 numbers[i]就是最小值；
 * 如果 numbers[i] < numbers[i-1] 一直不成立，则是递增数组，第一个元素就是最小值
 */
fun minArray1(numbers: IntArray): Int {

    for (i in 1 until numbers.size) {
        if (numbers[i] < numbers[i-1]) {
            return numbers[i]
        }
    }
    return numbers[0]
}

/**
 * 二分法
 * 旋转后的数组分为左边有序数组和右边有序数组
 */
fun minArray2(numbers: IntArray): Int {

    var left = 0
    var right = numbers.size - 1
    var mid = (left + right)/2

    while (left < right) {
        if (numbers[mid] > numbers[right]) {
            // 最小值在右边的排序数组中，舍弃左边的
            left = mid + 1
        }else if (numbers[mid] < numbers[right]){
            // 最小值在左边的排序数组中，舍弃右边的
            right = mid
        }else {
            right--
        }
        mid = (left + right)/2
    }
    return numbers[left]
}