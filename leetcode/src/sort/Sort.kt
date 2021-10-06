package sort

import kotlin.random.Random

fun main() {

    /**
     * 有序度：数组中具有有序关系的元素对的个数
     * 满有序度：数组在排序的情况下，有序度是 n*(n-1)/2，就是满有序度
     * 逆序度：满有序度 - 有序度
     * 排序的过程，就是减少逆序度，增加有序度的过程
     */
//    val array = intArrayOf(2,5,3,9,1,0,6,7)

    val array = IntArray(20000) {
        java.util.Random().nextInt(10000)
    }

//    println("before sort ${array.contentToString()}")

    time("bubbleSort1") {
        bubbleSort1(array.copyOf())
    }

    time("bubbleSort2") {
        bubbleSort2(array.copyOf())
    }

    time("insertSort") {
        insertSort(array.copyOf())
    }

//    println("after sort ${array.contentToString()}")
}

/**
 * 冒泡排序
 * 最好时间复杂度O(n)
 * 最坏时间复杂度O(n*n)
 * 平均时间复杂度O(n*n)（看比较次数）
 * 空间复杂度O(1)（原地操作）
 * 稳定的排序算法，因为如果相邻的两个元素是有序的，就不需要再交换位置
 */
private fun bubbleSort1(array: IntArray) {


    val length = array.size

    for (i in 0 until length) {
        for (j in 0 until length - i - 1) {
            if (array[j] > array[j+1]) {
                array[j] = array[j] + array[j+1]
                array[j+1] = array[j] - array[j+1]
                array[j] = array[j] - array[j+1]
            }
        }
    }

//    println(array.contentToString())
}


/**
 * 冒泡排序
 */
private fun bubbleSort2(array: IntArray) {


    val length = array.size

    var hasSwap = false

    for (i in 0 until length) {
        hasSwap = false
        for (j in 0 until length - i - 1) {
            if (array[j] > array[j+1]) {
                array[j] = array[j] + array[j+1]
                array[j+1] = array[j] - array[j+1]
                array[j] = array[j] - array[j+1]
                hasSwap = true
            }
        }
        if (!hasSwap) {
            break
        }
    }

//    println(array.contentToString())
}

private fun insertSort(array: IntArray) {
    val length = array.size

    for (i in 1 until length) {
        val value = array[i]
        var j = i - 1
        while (j >= 0) {
            if (value < array[j]) {
                array[j+1] = array[j]
            }else {
                break
            }
            j--
        }
        array[j+1] = value
    }

//    println(array.contentToString())
}

private fun time(funName: String, runnable: Runnable) {
    val start = System.currentTimeMillis()
    runnable.run()
    println("$funName spend ${System.currentTimeMillis() - start}")
}