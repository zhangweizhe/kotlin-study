package kotlin02

// 标准函数库
fun main() {
    // apply 最终返回调用者对象，花括号中可以直接调用该对象的方法
    var sb = StringBuilder().apply {
        // this:StringBuilder
        append("hello")
        append(" ")
        append("world")
    }
    println(sb) // hello world


    // let 返回lambda体的最后一行
    var email = "qwe@qq.com"
    var isValid = email.let {
        it.contains("@")
    }
    println("$email is valid: $isValid") // qwe@qq.com is valid: true

    // run，既有apply作用域的特性，又有let返回lambda体的最后一行的特性
    var runSb = StringBuilder().run {
        append("like ")
        append("let ")
        append("and ")
        append("apply")
        // 返回
        toString() + length
    }
    println(runSb) //like let and apply18

    // run 函数也能传入函数引用
    "test"
            .run(::checkLength)
            .run(::getToastStr)
            .run(::doPrint) // pass

}

fun checkLength(userName:String):Boolean {
    return userName.length > 5
}

fun getToastStr(overLong:Boolean):String {
    if (overLong) {
        return "userName too long"
    }else {
        return "pass"
    }
}

private fun doPrint(content:String) {
    println(content)
}