package linkedlist

fun main() {
    // 138. 复制带随机指针的链表
    // https://leetcode-cn.com/problems/copy-list-with-random-pointer/
}

fun copyRandomList(node: Node1?): Node1? {

    val map:MutableMap<Node1, Node1> = HashMap()
    var cur = node
    while (cur != null) {
        map[cur] = Node1(cur.`val`)
        cur = cur.next
    }
    cur = node
    while (cur != null) {
        map[cur]?.next = map[cur.next]
        map[cur]?.random = map[cur.random]
        cur = cur.next
    }
    return map[node]
}

class Node1(var `val`:Int) {
    var next: Node1? = null
    var random: Node1? = null
}