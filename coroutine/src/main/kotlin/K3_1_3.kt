import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import java.lang.StringBuilder
import kotlin.coroutines.*

fun main() {

    callLaunchCoroutine()
}

/**
 * [receiver]作为协程体[block]的作用域，协程体可以直接调用作用域中的函数，如[ProducerScope.produce]
 */
fun <R, T> launchCoroutine(receiver: R, block: suspend R.() -> T) {
    block.startCoroutine(receiver, object : Continuation<T> {
        override fun resumeWith(result: Result<T>) {
            println("Coroutine End: $result")
        }

        override val context: CoroutineContext
            get() = EmptyCoroutineContext
    })
}

/**
 * 作用域
 */
class ProducerScope<T> {
    suspend fun produce(value: T) {
        println("ProducerScope.produce call: $value")
    }
}

fun callLaunchCoroutine() {
    // 作用域是ProducerScope<Int>()
    launchCoroutine(ProducerScope<Int>()) {
        println("In Coroutine")
        // 协程体内调用作用域中的函数
        produce(1024)
//        delay(1000)
        produce(2048)
        toString()
    }
}

/**
 * [RestrictsSuspension] 注解，表示协程体内无法调用外部的挂起函数，只能调用作用域中定义的挂起函数
 */
@RestrictsSuspension
class RestrictProducerScope<T> {
    suspend fun produce(value: T) {
        println("RestrictProducerScope.produce call: $value")
    }
}

fun callLaunchCoroutineRestrict() {
    // 作用域是ProducerScope<Int>()
    launchCoroutine(RestrictProducerScope<Int>()) {
        println("In Coroutine")
        // 协程体内调用作用域中的函数
        produce(1024) // 只能调用作用域内的挂起函数
//        delay(1000) // 报错！！不能调用外部的挂起函数
        produce(2048)
        toString()
    }
}

