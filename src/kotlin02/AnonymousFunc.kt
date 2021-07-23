package kotlin02

/**
 * 匿名函数
 */
fun main() {
    val count = "banana".count()
    val countA = "banana".count { letter -> letter == 'a' }

    println(count) //6
    println(countA) //3

    // 声明一个变量af，变量类型是匿名函数
    // 没有入参，返回值是String
    val af:() -> String
    // 给 af 赋值
    af = {
        val name = "Bob"
        // 匿名函数不需要return 关键字，会直接把函数体的最后一行代码作为返回值
        // 所以匿名函数的最后一行表达式的类型，必须和返回值一致
        "Hello $name"
    }
    println(af) //() -> kotlin.String // 打印的是变量类型
    println(af()) //Hello Bob // 打印变量的值

    // 声明一个变量af1，变量类型是匿名函数
    // 入参是String 和 Int，返回值是String
    val af1 : (String, Int) -> String
    // 给af1赋值
    af1 = { s: String, i: Int ->
        "append result $s, $i"
    }

    println(af1("hello", 5)) //append result hello, 5
}