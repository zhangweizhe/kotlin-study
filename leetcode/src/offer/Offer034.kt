package offer

fun main() {
    // https://leetcode-cn.com/problems/lwyVBB/
    // 剑指 Offer II 034. 外星语言是否排序
}

fun isAlienSorted(words: Array<String>, order: String): Boolean {

    words.sortWith(Comparator{a,b ->
        var ai = 0
        var bi = 0
        while (ai < a.length && bi < b.length) {
            var aOrder = order.indexOf(a[ai])
            var bOrder = order.indexOf(b[bi])
            if (aOrder < bOrder) {
                return@Comparator -1
            }else if (aOrder > bOrder){
                return@Comparator 1
            }
            ai++
            bi++
        }
        if (a.length < b.length) {
            return@Comparator -1
        }
        1
    })

}

class Offer034 {
}