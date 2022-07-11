import kotlin.concurrent.thread
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

fun main() {

}

// 代码清单3-7 挂起函数
suspend fun suspendFunc01(a: Int) {
    return
}

suspend fun suspendFunc02(a: String, b: String) = suspendCoroutine<Int> {continuation ->
    // suspendCoroutine函数可以得到一个 SafeContinuation 实例
    // SafeContinuation类的作用，就是确保发生异步调用时才挂起，如suspendFunc03
    // 异步调用，挂起
    thread {
        continuation.resumeWith(Result.success(5))
    }
}

suspend fun suspendFunc03(a: String) = suspendCoroutine<Int> { continuation ->
    // 没有异步调用，不会挂起
    continuation.resume(100)
}