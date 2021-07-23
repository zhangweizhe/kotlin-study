import java.lang.Exception

fun main() {
    println(add(3, 5))

    // 编译失败
    //Type mismatch.
    //Required:
    //Int
    //Found:
    //String
//     defaultParam("Nihao")

    //b="Nihao" 具名参数，调用函数时给实参附上形参
    defaultParam(b="Nihao")
    // 使用具名参数时，可以改变入参的顺序
    defaultParam(b="hello", a=6)

    println(unitTest()) //kotlin.Unit

//    nothingTest()

    `$$##特殊函数名123`()
}

/**
 * 方法的定义
 * 访问修饰符 关键字fun 函数名(参数1:类型, 参数2:类型) : 返回值 {
 *      方法体
 * }
 */
private fun add(a:Int, b:Int) : String {
    return "sum is ${a + b}"
}

/**
 * 方法参数默认值
 * 定义方法时，可以给参数赋一个默认值，然后调用时可以不传这个参数
 */
private fun defaultParam( a:Int = 3, b:String) {
    println("$a, $b")
}

/**
 * 没有返回值的函数，函数返回类型是Unit类型
 * Unit类型是为了解决现在语言的一个重要特征，泛型
 */
fun unitTest():Unit {
    println("unit function invoked")
}

//
//fun nothingTest():Nothing {
//    println("before throw")
//    throw Exception("nothing test invoked")
//    println("after throw")
//}

/**
 * 函数名可以用反引号括起来，里面可以包含特殊字符，中文等
 * 如果 kotlin 调用 java 的函数，而函数名正好是 Kotlin 中的关键字，
 * 比如java中定义了一个函数，函数名是when，这时可以这样调用，JavaClass.`when`()
 */
fun `$$##特殊函数名123`() {
    println("\$\$##特殊函数名123 被调用")
}