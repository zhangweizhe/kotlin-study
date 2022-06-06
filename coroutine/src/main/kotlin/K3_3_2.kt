import kotlin.coroutines.AbstractCoroutineContextElement
import kotlin.coroutines.CoroutineContext

fun main() {

}

/**
 * 代码清单3-13 协程名的实现
 */
class CoroutineName(val name: String): AbstractCoroutineContextElement(Key) {
    companion object Key: CoroutineContext.Key<CoroutineName>
}

/**
 * 代码清单3-14 协程异常处理器的实现
 */
class CoroutineExceptionHandler(
        val onErrorAction: (Throwable) -> Unit
): AbstractCoroutineContextElement(Key) {
    companion object Key: CoroutineContext.Key<CoroutineExceptionHandler>

    fun onError(error: Throwable) {
        error.printStackTrace()
        onErrorAction(error)
    }
}

val myCoroutineContent = CoroutineName("co-01") + CoroutineExceptionHandler {
    println("catch exception in CoroutineExceptionHandler: \n + $it")
}