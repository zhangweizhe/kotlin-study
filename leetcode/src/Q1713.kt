fun main() {
    // https://leetcode-cn.com/problems/minimum-operations-to-make-a-subsequence/
    val minOperations = minOperations(intArrayOf(16,7,20,11,15,13,10,14,6,8), intArrayOf(11,14,15,7,5,5,6,10,11,6))
    println(minOperations)
    println(minOperations(intArrayOf(5,1,3), intArrayOf(9,4,2,3,4)))
}

fun minOperations(target: IntArray, arr: IntArray): Int {
    var tIndex = 0
    var aIndex = 0
    var minIndex = 0
    var result = 0

    while (tIndex < target.size) {
        while (aIndex < arr.size) {
            if (target[tIndex] == arr[aIndex]) {
                minIndex = aIndex
                break
            }
            aIndex++
        }
        if (minIndex == arr.size-1) {
            result += (target.size - tIndex - 2)
            break
        }
        if (aIndex == arr.size) {
            result++
            aIndex = minIndex + 1
        }
        tIndex++
    }
    return result
}