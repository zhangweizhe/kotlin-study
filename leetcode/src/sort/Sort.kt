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
        java.util.Random().nextInt(15000)
    }

//    println("before sort ${array.contentToString()}")

    time("bubbleSort1", Runnable {
        bubbleSort1(array.copyOf())
    })

    time("bubbleSort2", Runnable {
        bubbleSort2(array.copyOf())
    })

    time("insertSort", Runnable {
        insertSort(array.copyOf())
    })

    time("selectSort", Runnable {
        selectSort(array.copyOf())
    })

    time("shellSort", Runnable {
        shellSort(array.copyOf())
    })

    time("mergeSort", Runnable {
        mergeSort(intArrayOf(6,5,47,2,0,9))
    })
//    println("after sort ${array.contentToString()}")
}

/**
 * 冒泡排序
 * 最好时间复杂度O(n)
 * 最坏时间复杂度O(n*n)
 * 平均时间复杂度O(n*n)（根据比较次数）
 * 空间复杂度O(1)（原地操作）
 * 稳定的排序算法，因为如果相邻的两个元素是有序的，就不需要再交换位置
 */
private fun bubbleSort1(array: IntArray) {

    val length = array.size

    var swapCount = 0

    for (i in 0 until length) {
        for (j in 0 until length - i - 1) {
            if (array[j] > array[j+1]) {
                swapCount++
                val tmp = array[j]
                array[j] = array[j+1]
                array[j+1] = tmp
            }
        }
    }
    println("bubble sort swap count $swapCount")

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
                val tmp = array[j]
                array[j] = array[j+1]
                array[j+1] = tmp
                hasSwap = true
            }
        }
        if (!hasSwap) {
            break
        }
    }

//    println(array.contentToString())
}

/**
 * 插入排序
 * 最好时间复杂度O(n)
 * 最坏时间复杂度O(n*n)
 * 平均时间复杂度O(n*n)（根据比较次数）
 * 空间复杂度O(1)（原地操作）
 * 稳定的排序算法，因为如果相邻的两个元素是有序的，就不需要再交换位置
 * 插入排序优于冒泡排序的原因：冒泡排序每次交换数据，需要进行3次赋值操作，而插入排序只需要将数据往后移动一次，即进行1次赋值操作
 */
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

/**
 * 选择排序
 * 和插入排序一样，分为左右两个部分，左边是已排序的，右边是未排序的；
 * 每次遍历数组，记录下数值最小的数的下标，然后放到左边已排序数组的最右边；
 * 和冒泡排序不同的是，冒泡每次发现更小的数，都要交换两个数的位置，而选择排序排序只是更新 minIndex，遍历结束后，再交换 i 和 minIndex 位置上的数据，所以交换操作的次数会少很多
 * 实验数据：
 * bubble sort swap count 25106213
 * select sort swap count 9708
 * 所以选择排序会优于冒泡排序
 */
private fun selectSort(array: IntArray) {
    val length = array.size

    var swapCount = 0

    for (i in 0 until length) {
        var minIndex = i
        for (j in i until length) {
            if (array[i] > array[j]) {
                minIndex = j
            }
        }
        if (minIndex != i) {
            swapCount++
            val tmp = array[i]
            array[i] = array[minIndex]
            array[minIndex] = tmp
        }
    }
    println("select sort swap count $swapCount")

//    println(array.contentToString())
}

/**
 * 希尔排序
 */
private fun shellSort(array: IntArray) {

    val length = array.size
    var gap = length / 2

    while (gap >= 1) {
        for (i in gap until length) {
            val tmp = array[i]
            var j = i - gap
            while (j >= 0 && array[j] > tmp) {
                array[j+gap] = array[j]
                j -= gap
            }
            array[j+gap] = tmp
        }
        gap /= 2
    }

//    println(array.contentToString())
}

private fun mergeSort(array: IntArray) {
    mergeSortHelper(array, 0, array.size - 1)
    println(array.contentToString())
}

private fun mergeSortHelper(array: IntArray, start: Int, end: Int) {
    if (start >= end) {
        return
    }
    // 将数组从中间一分为二
    val mid = (end + start) / 2
    // 左右两个数组分别执行归并排序
    mergeSortHelper(array, start, mid)
    mergeSortHelper(array, mid+1, end)

    // 经过上面两次递归调用，array[start, mid] 和 array[mid+1, end] 已经是有序数组
    // 将 array[start, mid] 和 array[mid+1, end] 合并到 tmp 数组中
    val tmp = IntArray(end - start + 1)
    // 定义两个指针，分别指向左右两部分的第一个元素
    var leftIndex = start
    var rightIndex = mid + 1
    // 指向 tmp 数组元素的指针
    var k = 0

    // 合并两个有序数组为一个有序数组
    while (leftIndex <= mid && rightIndex <= end) {
        if (array[leftIndex] <= array[rightIndex]) {
            tmp[k++] = array[leftIndex++]
        }else {
            tmp[k++] = array[rightIndex++]
        }
    }

    // 合并剩下的部分
    while (leftIndex <= mid) {
        tmp[k++] = array[leftIndex++]
    }
    while (rightIndex <= end) {
        tmp[k++] = array[rightIndex++]
    }

    // 把合并结果复制回原数组中
    for (i in tmp.indices) {
        array[start+i] = tmp[i]
    }
}

private fun time(funName: String, runnable: Runnable) {
    val start = System.currentTimeMillis()
    runnable.run()
    println("$funName spend ${System.currentTimeMillis() - start}")
}