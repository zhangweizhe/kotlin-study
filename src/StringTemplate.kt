fun main() {
    // string 模板
    // 模板支持在双引号内，通过$符号直接使用变量
    // 也可以使用 ${表达式} 在双引号内嵌入表达式
    val boy = "jack"
    val girl = "rose"
    println("$boy love $girl") //jack love rose
    // 如果就是要显示 $变量名，$前面加反斜杠\转义
    println("$boy love \$girl") //jack love $girl

    // 嵌入表达式
    println("Hello ${1+1}") //Hello 2

    val fine = true
    println("I'm ${if (fine) "fine" else "bad"}") //I'm fine
}