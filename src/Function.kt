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