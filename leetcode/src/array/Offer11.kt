package array

fun main() {
    // 剑指 Offer 11. 旋转数组的最小数字
    // https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/
//    println(minArray3(intArrayOf(3,1,1)))

//    println(maxArray(intArrayOf(4,5,6,1,2,3)))
//    println(maxArray(intArrayOf(1,2,3,4,5,6)))
//    println(maxArray(intArrayOf(3,3,3,3,3,3)))
    println(maxArray(intArrayOf(6,5,4,3,2,1)))
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
           // 旋转点在右半数组，舍弃左半数组，mid 也是可以舍弃的，因为它肯定不是最小的
           left = mid+1
       }else if (numbers[mid] < numbers[right]) {
           // 旋转点在左半数组，舍弃右半数组，mid 不能舍弃，因为它可能是最小的
           right = mid
       }else {
           // right 一点点往左边移动
           right--
       }
        mid = (left + right)/2
    }
    return numbers[left]
}

/**
 * 用 right 和 mid 比较，而不是 left 和 mid 比较，
 * 是考虑当 mid > left，无法确定 mid 在哪个排序数组里面
 * 比如 left = 0, mid = 2, right = 4
 * 对于 1,2,3,4,5 这个数组，旋转点在0，nums[mid] > nums[left]，mid 在右边排序数组（只有右数组）
 * 对于 3,4,5,1,2 这个数组，旋转点在3，nums[mid] > nums[left]，mid 在左边排序数组
 */
fun minArray3(numbers: IntArray): Int {
    // 重点：寻找旋转点（或者说两个有序数组的交界点）
    var left = 0
    var right = numbers.size - 1
    var mid = (left + right)/2

    while (left < right) {
        if (numbers[mid] > numbers[right]) {
            // left ~ mid 是有序的，交界点在右边数组
            // numbers[mid] 大于 numbers[right]，所以 numbers[mid] 肯定不会是最小值，可以舍弃，所以 left = mid + 1
            left = mid + 1
        }else if (numbers[mid] < numbers[right]) {
            // mid ~ right 是有序的，交界点在左边数组
            // numbers[mid] 可能是最小的，所以不能舍弃
            right = mid
        }else {
            // numbers[mid] == numbers[right]，right 只能一点点往左边移动
            right--
        }
        mid = (left + right)/2
    }
    return numbers[left]
}

fun maxArray(numbers: IntArray): Int {

    var left = 0
    var right = numbers.size - 1
    var mid = (left + right) / 2

    while (left < right) {
        if (numbers[mid] > numbers[left]) {
            // left~mid 是有序的，交界点在右边数组
            left = mid
        }else if (numbers[mid] < numbers[left]) {
            // mid~right 是有序的，交界点在左边数组
            right = mid - 1
        }else {
            left++
        }
        mid = (left + right)/2
    }
    return numbers[right]
}