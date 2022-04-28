package multithread

fun main() {
    val yieldTestRunnable = YieldTestRunnable()

    Thread(yieldTestRunnable, "a").start()
    Thread(yieldTestRunnable, "b").start()
}

class YieldTestRunnable : Runnable {
    override fun run() {
        println("${Thread.currentThread().name} 开始执行")
        // 让步，让出 CPU 资源，再重新竞争，重新竞争可能又是当前线程执行
        // 当前线程从运行状态变为就绪状态
        Thread.yield()
        println("${Thread.currentThread().name} 结束执行")
    }

}