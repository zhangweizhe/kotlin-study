package offer

fun main() {
    // 剑指 Offer 40. 最小的k个数
    // https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/

    println(getLeastNumbers(intArrayOf(0,1,2,1), 1).contentToString())
}

fun getLeastNumbers(arr: IntArray, k: Int): IntArray {

    quickSort(arr, 0, arr.size - 1)

    val ret = IntArray(k)

    for (i in 0 until k) {
        ret[i] = arr[i]
    }
    return ret
}

private fun quickSort(arr:IntArray, start:Int, end:Int) {

    if (start > end) {
        return
    }

    val pivot = arr[end]

    var i = start

    for (j in start..end) {
        if (arr[j] < pivot) {
            val tmp = arr[j]
            arr[j] = arr[i]
            arr[i] = tmp
            i++
        }
    }
    arr[end] = arr[i]
    arr[i] = pivot

    quickSort(arr, start, i - 1)
    quickSort(arr, i + 1, end)
}