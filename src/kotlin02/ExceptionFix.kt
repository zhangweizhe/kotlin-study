package kotlin02

import java.lang.IllegalStateException

fun main() {
    // try catch 异常
    var num:Int? = null
    try {
        checkNull(num)
        num!!.plus(1)
    }catch (e:Exception) {
        println(e)
    }
}

private fun checkNull(num:Int?) {
    num ?: throw UnskilledException()
}

// 自定义异常
class UnskilledException : IllegalStateException("不熟练异常")