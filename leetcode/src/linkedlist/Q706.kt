package linkedlist

fun main() {
    // 706. 设计哈希映射
    // https://leetcode-cn.com/problems/design-hashmap/

    val myHashMap = MyHashMap()
    myHashMap.put(1, 1)
    println(myHashMap.get(1))
    myHashMap.put(1, 2)
    println(myHashMap.get(1))
    println(myHashMap.get(2))

    myHashMap.put(2, 5)
    println(myHashMap.get(2))

    myHashMap.remove(2)
    println(myHashMap.get(2))
}

const val BASE = 987

class MyHashMap() {

    /** Initialize your data structure here. */
    private val array: Array<Node?> = arrayOfNulls(BASE)

    /** value will always be non-negative. */
    fun put(key: Int, value: Int) {
        var index = key % BASE
        var head = array[index]
        if (head == null) {
            head = Node(Pair(key, value))
            array[index] = head
        }else {
            while (head != null) {
                if (head.value.first == key) {
                    head.value = Pair(key, value)
                    break
                }else if (head.next == null) {
                    // 最后一个节点
                    val node = Node(Pair(key, value))
                    head.next = node
                    break
                } else {
                    head = head.next
                }
            }
        }
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    fun get(key: Int): Int {
        var index = key % BASE
        var node = array[index]
        while (node != null) {
            if (node.value.first == key) {
                return node.value.second
            }else {
                node = node.next
            }
        }
        return -1
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    fun remove(key: Int) {
        var index = key % BASE
        var node = array[index]
        var prev:Node? = null
        while (node != null) {
            if (node.value.first == key) {
                if (prev == null) {
                    array[index] = node.next
                }else {
                    prev.next = node.next
                }
                break
            }else {
                prev = node
                node = node.next
            }
        }
    }

}

private class Node(var value: Pair<Int, Int>) {
    var next:Node? = null
}

