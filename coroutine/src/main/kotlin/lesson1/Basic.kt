import kotlinx.coroutines.*
import java.lang.IndexOutOfBoundsException
import java.lang.NullPointerException
import java.text.SimpleDateFormat

suspend fun main() {
//    first()
//    second()
//    exception()
    awaitJoin()
//    withContextTest()
////    asyncTest()
//    supervisorScopeTest()
//    coroutineScopeTest()
}

fun first() = runBlocking {
    // launch{} 在 runBlocking 作用域内启动一个新协程
    val job = launch(Dispatchers.Default) {
        doWorld()
    }
    println("hello from ${Thread.currentThread().name}")
//    Thread.sleep(2000)
//    等价于 Thread.sleep(2000)
//    runBlocking {
//        delay(2000)
//    }
    // join()，等待，直到子协程结束
//    job.join()
}

private suspend fun doWorld() {
    delay(1000)
    println("world from ${Thread.currentThread().name}")
}

fun second() = runBlocking {
    launch {
        delay(200)
        println("Task from launch")
    }

    // coroutineScope{} 创建一个协程作用域，在所有已启动的子协程执行结束之前，都不会结束
    // coroutineScope{} 和 runBlocking{} 的区别：
    // coroutineScope 是挂起函数，会释放底层线程用于其他用途
    // runBlocking 是阻塞当前线程的
    coroutineScope {
        launch {
            delay(500)
            println("Task from nested launch")
        }

        delay(100)
        println("Task from coroutineScope")
    }

    println("coroutineScope is over")
}


fun exception() = runBlocking {
    val exceptionHandler = CoroutineExceptionHandler() {coroutineContext, throwable ->
        println("handle throwable in CoroutineExceptionHandler $throwable")
    }
    val launch = GlobalScope.launch(Dispatchers.Default + exceptionHandler) {
        println(coroutineContext[Job])
        println("throw exception from launch")
        throw IndexOutOfBoundsException()
    }
    launch.join()

    val async = GlobalScope.async {
        println("throw exception from async")
        throw NullPointerException()
    }
//
//    val await = async.await()
}

suspend fun awaitJoin() {

    val async = GlobalScope.async<Int> {
        throw IndexOutOfBoundsException("异常啦")
    }
    try {
        println(1)
        val result = async.await()
        println("async 运行结果：$result")
        println(2)
    }catch (e: Exception) {
        println("catch exception: ${e.localizedMessage}")
    }
}

suspend fun withContextTest() {
    coroutineScope {
        var start = System.currentTimeMillis()
        val w1 = withContext(Dispatchers.Default) {
            delay(1000)
            println("${now()} 1")
            "withContext return 1"
        }

        val w2 = withContext(Dispatchers.Default) {
            delay(1000)
            println("${now()} 2")
            "withContext return 2"
        }

        val cost = System.currentTimeMillis() - start
        println("${now()} task1 $w1, task2 $w2, $cost")

    }
}


suspend fun asyncTest() {
    coroutineScope {
        var start = System.currentTimeMillis()
        val w1 = async(Dispatchers.Default) {
            delay(1000)
            println("${now()} 3 ${Thread.currentThread().name}")
            "async return 3"
        }

        val w2 = async(Dispatchers.Default) {
            println("${now()} start delay 1000")
            delay(1000)
            println("${now()} end delay 1000")
            println("${now()} start delay 2000")
            delay(2000)
            println("${now()} end delay 2000")
            println("${now()} 4 ${Thread.currentThread().name}")
            "async return 4"
        }
        val cost = System.currentTimeMillis() - start
        println("${now()} task3 ${w1.await()}, task4 ${w2.await()}, $cost")

    }
}

const val format = "HH:mm:ss:SSS"
val sdf = SimpleDateFormat(format)

private fun now(): String {
    return sdf.format(System.currentTimeMillis())
}

private suspend fun supervisorScopeTest() {
    supervisorScope {
        launch {
            log("supervisorScope 子协程1")
            throw IndexOutOfBoundsException("supervisorScope 的子协程发生了异常")
        }
        launch {
            log("supervisorScope 子协程2")
        }
        log("supervisorScope 子协程3")
    }
}

private suspend fun coroutineScopeTest() {
    coroutineScope {
        launch {
            log("coroutineScope 子协程1")
            throw IndexOutOfBoundsException("coroutineScope 的子协程发生了异常")
        }
        launch {
            log("supervisorScope 子协程2")
        }
        log("supervisorScope 子协程3")
    }
}


private fun log(s:String) {
    println("${now()}::[${Thread.currentThread().name}] $s")
}