package kotlin02

fun main() {
    // 函数引用，把一个具名函数作为实参传递给另一个函数，使用::
    doPrint(::getTargetString)

    val returnFunVal = returnFun()
    println(returnFunVal("Bob", 10))
}

fun getTargetString():String {
    return "hello word"
}

private fun doPrint(getTargetString: ()->String) {
    println(getTargetString())
}

// 返回类型为函数的函数
// 没有入参，返回值类型为函数
// 返回的函数，入参是(String, Int)，返回值类型是String
fun returnFun(): (String, Int) -> String {
    val s1 = "你好"
    val num = 25
    return { name:String, age:Int ->
        "Name:$name s1:$s1 age:$age num:$num"
    }
}
