package kotlin02

fun main() {

    // 声明变量时，在类型后面加?，表示这个变量是可空的，可以赋值null
    var str:String? = "UnSafe"
    str = null

    // 如果不加?，赋值null时会报错
    var notNull:String = "noNull"
//    notNull = null // 报错

    // 安全调用操作符，调用可空变量的方法、变量时，需要加上?，否则会报错
    // str.length // 报错
    // 如果 str 是空的，则不会调用capitalize()函数
    println(str?.capitalize())

    str = null
    str = str?.let {
        if (it.isNotBlank()) {
            it.capitalize()
        }else{
            "apple"
        }
    }
    println(str) //null

    str = "apple"
    str = str?.let {
        if (it.isNotBlank()) {
            it.capitalize()
        }else{
            "apple"
        }
    }
    println(str) //Apple

    // 非空断言操作符 !!.，如果str是空的，则抛出空指针异常
    str = null
//    println(str!!.capitalize()) //Exception in thread "main" kotlin.KotlinNullPointerException

    // 空合并操作符 expressionA ?: expressionB，如果expressionA 不为 null，则返回 expressionA，否则返回 expressionB
    str = null
    println(str ?: "banana") //banana

    str = "apple"
    println(str ?: "banana") //apple
}