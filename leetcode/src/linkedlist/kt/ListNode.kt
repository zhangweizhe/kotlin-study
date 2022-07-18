package linkedlist.kt

class ListNode(open var `val`: Int) {
      constructor( `val`: Int,  nextP: ListNode?) : this(`val`) {
            this.next = nextP
      }
      open  var next: ListNode? = null
}