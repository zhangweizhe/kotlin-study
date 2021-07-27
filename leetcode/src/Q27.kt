fun main() {
    // https://leetcode-cn.com/problems/remove-element/
    println(removeElement1(intArrayOf(3,2,2,3), 3))
}

/**
 * 双指针
 * 移动规则如下：
 * 1.nums[right] != val，则left 和 right 同时向右移动一步，并把 nums[left] = nums[right]
 * 2.否则只有rihgt向右移动一步
 * left 指向将要赋值的元素，right 指向将要操作的元素
 */
fun removeElement1(nums: IntArray, `val`: Int): Int {
    var left = 0
    var right =0
    while (right < nums.size) {
        if (nums[right] != `val`) {
            nums[left] = nums[right]
            left++
        }
        right++
    }
    return left
}

fun removeElement(nums: IntArray, `val`: Int): Int {
    var p1 = 0
    var p2 = 0
    while (p1 < nums.size) {
        if (p2 == nums.size) {
            break
        }
        if (nums[p1] != `val`) {
            p1++
        }else {
            p2 = p1 + 1
            while (p2 < nums.size) {
                if (nums[p2] != `val`) {
                    val tmp = nums[p2]
                    nums[p2] = nums[p1]
                    nums[p1] = tmp
                    break
                }else{
                    p2++
                }
            }
        }
    }
    var ret = 0;
    for (i in nums) {
        if (i != `val`) {
            ret++
        }else{
            break
        }
    }

    println(nums.contentToString())
    return ret
}