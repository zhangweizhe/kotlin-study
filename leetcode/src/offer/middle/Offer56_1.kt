package offer.middle

fun main() {
    // 剑指 Offer 56 - I. 数组中数字出现的次数
    // https://leetcode.cn/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof/
    println(singleNumbers(intArrayOf(1,2,10,4,1,4,3,3)).contentToString())
}

fun singleNumbers(nums: IntArray): IntArray {
    // [1,2,10,4,1,4,3,3]，结果是2，10
    // 设两个不同的数为 x y，遍历 nums，每次执行异或操作，最终结果 z 就是 x ^ y 的值
    // 因为其他的数是有重复的，两个相同的数异或，结果是0，就抵消了
    // 例子中，x=2(0010)，y=10(1010)，z = x^y = (1000)
    var z = 0
    for (i in nums) {
        z = z.xor(i)
    }
    // 找到 z 低位的第一个1，x y 在这一位上的数肯定是不一样的，因为异或结果是1
    // 初始化 m = 1，当 m&z == 0 时，将 m 左移一位，循环直到 m&z != 0
    // 例子中，经过计算，m = (1000)
    var m = 1
    while (m.and(z) == 0) {
        m = m.shl(1)
    }
    // 遍历数组，每个元素和 m 做与&运算，根据结果是否为0，可将数组分为两个自数组
    // 子数组中，每个元素再和 m 异或，最终两个自数组的结果就是 x y
    var x = 0
    var y = 0
    for (i in nums) {
        if (i.and(m) == 0) {
            x = x.xor(i)
        }else {
            y = y.xor(i)
        }
    }
    return intArrayOf(x, y)
}