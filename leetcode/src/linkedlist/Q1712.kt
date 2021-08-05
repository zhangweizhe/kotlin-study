package linkedlist

fun main() {
    // 面试题 17.12. BiNode
    // https://leetcode-cn.com/problems/binode-lcci/

}
var head:TreeNode? = null
var prev:TreeNode? = null

/**
 * 中序遍历，用prev保存上一次访问到的节点
 * 把当前节点作为上一节点prev的右节点，prev.right = cur
 * 更新prev节点，prev = cur
 * 当前节点左节点置null，否则可能出现环
 */
fun convertBiNode(root: TreeNode?): TreeNode? {
    if (root == null) {
        return null
    }
    convertBiNode(root.left)
    if (head == null) {
        head = root
    }else{
        prev?.right = root
    }
    prev = root
    root.left = null
    convertBiNode(root.right)
    return head
}
