import com.sun.xml.internal.fastinfoset.util.StringArray
import java.time.LocalTime
import java.util.concurrent.*

fun main() {
//
//    val array = listOf(1,2,3,4,7)
//
//
//    array.sortedWith(Comparator { o1, o2 ->
//        o1 - o2
//    })
//
//    array.map {
//
//    }
//
//    val map = array.map {
//        it * 2
//    }
//
//    println(map)
//
//    val fold:String = array.fold("init") { acc, i ->
//        println(acc)
//        println(i)
//        println("-----")
//        "$acc, $i"
//    }
//
//    println(fold)
//
//    println("123".doubleLength())
//    val states = arrayOf("starting", "Doing Task 1", "Doing Task 2", "Ending")
//    repeat(3) {
//        Thread {
//            println("${Thread.currentThread()} has started\n")
//            for (i in states) {
//                println("${Thread.currentThread()} - $i\n")
//                Thread.sleep(50)
//            }
//        }.start()
//    }

    val threadPoolExecutor = ThreadPoolExecutor(
            0,
            4,
            10,
            TimeUnit.SECONDS, LinkedTransferQueue<Runnable>())

    for (i in 0..20) {
        threadPoolExecutor.execute {
            println("${LocalTime.now()} execute $i")
            Thread.sleep(500)
        }
    }
}

fun String.doubleLength(): Int {
    return length * 2
}

private fun doubleLength1(input: String): Int {
    return input.length * 2
}