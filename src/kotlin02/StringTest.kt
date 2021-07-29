package kotlin02

fun main() {

    val name = "Lebron James"
    val indexOf = name.indexOf(' ')
    var firstName = name.substring(0, indexOf)
    var lastName = name.substring(indexOf until  name.length)
    println("first name is $firstName , last name is $lastName")

    // 解构声明，把一个对象赋值给多个变量
    val (fn:String, ln:String) = name.split(' ')
    println("fn is $fn, ln is $ln")
}