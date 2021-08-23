package array

fun main() {
    // 217. 存在重复元素
    // https://leetcode-cn.com/problems/contains-duplicate/

}

fun containsDuplicate(nums: IntArray): Boolean {
    val hashSetOf:MutableSet<Int> = HashSet(nums.size)
    for (num in nums) {
        val contains = hashSetOf.contains(num)
        if (contains) {
            return true
        }
        hashSetOf.add(num)
    }
    return false
}