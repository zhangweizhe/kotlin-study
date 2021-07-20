
// 声明编译时常量
// const val，kotlin中，常量只能声明在函数之外
const val MAX = 3000000000
fun main() {
    // 声明变量
    // var[声明变量关键字] str[变量名] String[变量数据类型] =[赋值操作符] "Hello World"[赋值]
    var str:String = "Hello World"
    println(str)

    // 声明只读变量
    // kotlin 中区分只读变量和常量，只读变量并非绝对只读
    val valInt:Int = 5
    println(valInt)

    // 类型推断
    // kotlin编译器在编译时，可根据赋值的类型，推断出变量的类型，定义的时候不需要显式地生命数据类型
    val autoStr = "Hello"
    println(autoStr)

    // 引用类型
    // java中的数据类型分为引用类型和基本数据类型，kotlin中只有引用类型
    // 处于对高性能（基本数据类型存储在栈内存，读写更快）的需要，kotlin编译器会自动改为基本数据类型
    // 如定义为Int类型的数据，在字节码中会转为int
    // LOCALVARIABLE baseInt I
    val baseInt:Int = 20
}