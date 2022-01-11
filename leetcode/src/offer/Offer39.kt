package offer

fun main() {
    // https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/
    // 剑指 Offer 39. 数组中出现次数超过一半的数字
    println(majorityElement1(intArrayOf(1, 2, 3, 2, 2, 2, 5, 4, 2)))

}

private fun majorityElement(nums: IntArray): Int {

    val map = HashMap<Int, Int>()

    for (i in nums) {
        var count:Int? = map[i]
        if (count != null) {
            count += 1
        }else {
            count = 1
        }
        if (count > nums.size/2) {
            return i
        }
        map[i] = count
    }

    return 0
}


private fun majorityElement1(nums: IntArray): Int {

    var sum = 0
    var candidate = 0

    for (i in nums) {
        if (sum == 0) {
            candidate = i
        }else if (candidate == i) {
            sum++
        }else if (candidate != i) {
            sum--
        }
    }

    return candidate
}