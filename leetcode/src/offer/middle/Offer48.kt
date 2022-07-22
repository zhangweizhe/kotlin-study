package offer.middle

fun main() {
    // 剑指 Offer 48. 最长不含重复字符的子字符串
    // https://leetcode.cn/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof/
    println(lengthOfLongestSubstring("abba"))
}

fun lengthOfLongestSubstring(s: String): Int {
    // 滑动窗口，左开右闭，所以 left 初始化为 -1
    var left = -1
    val map = HashMap<Char, Int>()
    var max = 0
    var right = 0
    while (right < s.length) {
        if (map.containsKey(s[right])) {
            // 左边界要取 (原左边界left, 重复字符出现的位置map[s[right]]) 中的最大值，因为重复字符可能出现在【原左边界】左边
            // 比如 abba，当遍历到第二个 b 时，左边界 left 更新为 1；
            // 接着遍历到第二个 a，此时 map['a'] 是 0，重复字符的位置在左边界的左边
            left = Math.max(left, map[s[right]]!!)
        }
        // 更新字符对应的索引，不管是否重复
        // 如果重复了，可以理解为更新为最新（最大）的索引
        map[s[right]] = right
        max = Math.max(max, right - left)
        right++
    }
    return max
}