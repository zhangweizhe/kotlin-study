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

    val replace = name.replace(Regex("[aeiou]")) {
        when (it.value) {
            "a" -> "1"
            "e" -> "2"
            "i" -> "3"
            "o" -> "4"
            "u" -> "5"
            else -> it.value
        }
    }
    println(replace) //L2br4n J1m2s

    // ==比较两个字符串的内容，===比较的是两个字符串是否指向同一地址
    var s1 = "Mike"
    var s2 = "Mike"
    println(s1 == s2) // true
    println(s1 === s2) // true，由于字符串常量池

    var s3 = "mike".capitalize()
    println(s1 == s3) // true
    println(s1 === s3) // false

    // 字符串遍历
    s1.forEach {
        print("$it *") //M *i *k *e *
    }
}