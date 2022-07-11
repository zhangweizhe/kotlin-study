package offer.middle

fun main() {
    // 剑指 Offer 13. 机器人的运动范围
    // https://leetcode.cn/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/
}

fun movingCount(m: Int, n: Int, k: Int): Int {

    val visited = HashSet<RobotPair>()
    help(visited, m, n, k, 0, 0)
    return visited.size
}

private fun help(visited: MutableSet<RobotPair>, m: Int, n: Int, k: Int, i: Int, j: Int) {
    if (i < 0 || i >= m) {
        // 横坐标越界
        return
    }
    if (j < 0 || j >= n) {
        return
    }
    val sumI = sum(i)
    if (sumI > k || sumI + sum(j) > k) {
        // 数位和大于0
        return
    }
    // 已经遍历过
    val robotPair = RobotPair(i, j)
    if (visited.contains(robotPair)) {
        return
    }
    // 当前格子是可以移动到的
    visited.add(robotPair)
    // 只需向右和向下查找
    // 参考题解动画，可运动范围，会随着 k 的增大，逐渐向右、向下扩展
    // https://leetcode.cn/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/solution/ji-qi-ren-de-yun-dong-fan-wei-by-leetcode-solution/
    help(visited, m, n, k, i+1, j)
    help(visited, m, n, k, i, j+1)

}

class RobotPair(val x:Int, val y:Int) {
    override fun equals(other: Any?): Boolean {
        if (other !is RobotPair) {
            return false
        }
        return other.x == x && other.y == y
    }

    override fun hashCode(): Int {
        var result = x
        result = 31 * result + y
        return result
    }
}

private fun sum(x: Int): Int {
    var ret = 0
    var tmp = x
    while (tmp != 0) {
        ret += tmp % 10
        tmp /= 10
    }
    return ret
}