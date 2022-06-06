package offer.middle

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashSet

fun main() {
    // 剑指 Offer 38. 字符串的排列
    // https://leetcode.cn/problems/zi-fu-chuan-de-pai-lie-lcof/
    println(permutation("suvyls").contentToString())

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