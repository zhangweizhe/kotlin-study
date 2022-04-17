fun main() {

    val lruCache = LRUCache(2)
    lruCache.put(1,1)
    lruCache.put(2,2)
    lruCache.get(1)
    lruCache.put(3,3)
    lruCache.get(2)
    lruCache.put(4,4)
    lruCache.get(1)
    lruCache.get(3)
    lruCache.get(4)
}

class LRUCache(capacity: Int) {

    val cacheMap = hashMapOf<Int, DLinkNode>()

    val head = DLinkNode(null, null, -1, -1)
    val tail = DLinkNode(null, null, -1, -1)
    val mCapacity = capacity
    init {
        head.next = tail
        tail.prev = head
    }

    fun get(key: Int): Int {
        val node = cacheMap[key] ?: return -1
        moveToHead(node)
        println(node.value)
        return node.value
    }

    fun put(key: Int, value: Int) {
        val node = cacheMap[key]
        if (node == null) {
            val dLinkNode = DLinkNode(null, null, key, value)
            addToHead(dLinkNode)
        }else {
            node.value = value
            moveToHead(node)
        }
    }

    fun moveToHead(node: DLinkNode) {
        removeNode(node)
        addToHead(node)
    }

    fun removeNode(node: DLinkNode) {
        node.prev?.next = node.next
        node.next?.prev = node.prev
        cacheMap.remove(node.key)
    }

    fun addToHead(node: DLinkNode) {
        if (cacheMap.size == mCapacity) {
            // 满了，移除队尾
            removeNode(tail.prev!!)
        }
        node.next = head.next
        head.next?.prev = node
        head.next = node
        node.prev = head
        cacheMap[node.key] = node
    }

}

data class DLinkNode(
        var prev: DLinkNode?,
        var next: DLinkNode?,
        val key: Int,
        var value: Int
)