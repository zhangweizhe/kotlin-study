package offer.middle

fun main() {
    // 剑指 Offer 66. 构建乘积数组
    // https://leetcode.cn/problems/gou-jian-cheng-ji-shu-zu-lcof/
    println(constructArr1(intArrayOf(1,2,3,4,5)).contentToString())
}

fun constructArr(a: IntArray): IntArray {
    if (a.isEmpty()) {
        return IntArray(0)
    }
    // 对于一个索引i，可以用 i 左侧数字的乘积，乘以 i 右侧数字的乘积，即可得到结果
    // 定义两个数组 L R，L[i] 表示 i 左侧数字的乘积，R[i] 表示 i 右侧数字的乘积
    // 可知 L[0] = 1，因为 0 号元素左边没有数字，且 L[i] = L[i-1] * a[i-1]
    // R[a.size - 1] = 1，因为最后一个元素右边没有数字，且 R[i] = R[i+1] * R[i]
    // 可以根据上面的递推公式，填充 L 和 R
    val L = IntArray(a.size)
    L[0] = 1
    val R = IntArray(a.size)
    R[a.size - 1] = 1
    // 填充L数组
    for (i in 1 until a.size) {
        L[i] = L[i-1] * a[i-1]
    }
    // 填充R数组
    for (i in a.size-2 downTo 0) {
        R[i] = R[i+1] * a[i+1]
    }
    // 使用 L 作为结果集合返回
    for (i in L.indices) {
        L[i] *= R[i]
    }
    return L
}

// 优化空间复杂度，只有一个辅助数组，也作为结果数组返回
fun constructArr1(a: IntArray): IntArray {
    if (a.isEmpty()) {
        return IntArray(0)
    }
    // 对于一个索引i，可以用 i 左侧数字的乘积，乘以 i 右侧数字的乘积，即可得到结果
    // 定义两个数组 L R，L[i] 表示 i 左侧数字的乘积，R[i] 表示 i 右侧数字的乘积
    // 可知 L[0] = 1，因为 0 号元素左边没有数字，且 L[i] = L[i-1] * a[i-1]
    // R[a.size - 1] = 1，因为最后一个元素右边没有数字，且 R[i] = R[i+1] * R[i]
    // 可以根据上面的递推公式，填充 L 和 R
    val L = IntArray(a.size)
    L[0] = 1
    var R = 1
    // 填充L数组
    for (i in 1 until a.size) {
        L[i] = L[i-1] * a[i-1]
    }
    // 填充R数组
    for (i in a.size-1 downTo 0) {
        L[i] *= R
        R *= a[i]
    }
    return L
}