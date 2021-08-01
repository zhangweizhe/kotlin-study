package kotlin02

import kotlin.math.roundToInt

fun main() {
    // 数字类型的安全转换函数
//    var num1:Int = "8.93".toInt()// 抛异常
    var num2:Int? = "4.32".toIntOrNull()
    println(num2) // null

    // double 转 int
    // 直接丢弃小数部分
    println(3.4567.toInt()) // 3

    // 四舍五入
    println(3.4415.roundToInt()) //3
    println(3.56.roundToInt()) //4

    // 保留n位小数
    println("%.2f".format(5.6122)) // 5.61
    println("%.2f".format(5.6172)) // 5.62
}