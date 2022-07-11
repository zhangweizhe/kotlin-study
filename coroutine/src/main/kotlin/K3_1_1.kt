import kotlin.coroutines.*

fun main() {
    code3_1()
}

private fun code3_1() {

    val continuation = suspend {
        println("In Coroutine.")
        5
    }.createCoroutine(object : Continuation<Int> {
        override val context: CoroutineContext
            get() = EmptyCoroutineContext

        override fun resumeWith(result: Result<Int>) {
            println("Coroutine End: $result")
        }

    })
    continuation.resume(Unit)
}

