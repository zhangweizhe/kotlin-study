package offer.middle

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashSet

fun main() {
    // 剑指 Offer 38. 字符串的排列
    // https://leetcode.cn/problems/zi-fu-chuan-de-pai-lie-lcof/
    println(permutation("1234567").contentToString())

}

fun permutation(s: String): Array<String> {
    if (s == "") {
        return arrayOf("")
    }
    val chars = s.toCharArray()
    Arrays.sort(chars)
    val resultList = ArrayList<String>()
    dfs(chars.size, resultList, "", String(chars))
    val result = Array<String>(resultList.size) {
        resultList[it]
    }
    return result
}

private fun dfs(charsSize: Int, resultList: MutableList<String>, curr: String, remain: String) {
    if (curr.length == charsSize) {
        resultList.add(curr)
        return
    }
    for (i in remain.indices) {
        if (i > 0 && remain[i-1] == remain[i]){
            continue
        }
        dfs(charsSize, resultList, curr + remain[i], remain.removeRange(i, i+1))
    }
}

private class Solution {

    private val resultList = ArrayList<String>()
    lateinit var chars:CharArray
    var charsSize = 0

    fun permutation(s: String): Array<String> {
        chars = s.toCharArray()
        charsSize = chars.size
        backtrack(0)
        val array = Array<String>(resultList.size) {
            resultList[it]
        }
        return array
    }

    /**
     * 固定第  [x] 位上的字符
     */
    private fun backtrack(x: Int) {
        if (x == charsSize - 1) {
            resultList.add(String(chars))
            return
        }
        // 记录 x 位置上已经固定过的字符
        val set = HashSet<Char>()
        for (i in x until charsSize) {
            if (set.contains(chars[i])) {
                // x 位置上已经固定过这个字符了
                continue
            }
            set.add(chars[i])
            // 把 i 位置的值交换到 x 的位置上，也就是将 chars[i] 固定在 x 位置
            // i==x 时，可以不执行交换
            swap(i, x)
            // 对交换后的 chars 数组继续执行递归，固定的位置是 x 的一下，也就是 x+1
            backtrack(x+1)
            // 恢复原数组，也就是恢复 x i 的位置，交换回来
            swap(i, x)
        }
    }

    private fun backtrack1(x: Int) {
        if (x == charsSize - 1) {
            resultList.add(String(chars))
            return
        }
        val set = HashSet<Char>()
        for (i in x until charsSize) {
            if (set.contains(chars[i])) {
                continue
            }
            set.add(chars[i])
            swap(i, x)
            backtrack1(x+1)
            swap(i, x)
        }
    }

    private fun swap(x:Int, y:Int) {
        val tmp = chars[x]
        chars[x] = chars[y]
        chars[y] = tmp
    }
}

