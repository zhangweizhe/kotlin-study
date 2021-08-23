package kotlin02

import java.io.File

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

    // with，和run差不多
    val lengthTest = with("test string") {
        val l = length
        println(l) // 11
        l > 3
    }
    println(lengthTest) //true

    // also，和 apply 几乎一样，不同点在于lambda中的上下文context的表示方式
    // also是以入参的方式it来表示的，而 apply 是以 this 来表示的
    "Jack".also {
        println("my name is ${it}, ") // my name is Jack,
    }
            .also {
                println("the first letter is ${it[0]}") // the first letter is J
            }

    // takeIf，takeIf 中的lambda返回true时，则返回调用者自己，否则返回Null
    "Mike".takeIf {
        it.contains("M")
    }.also {
        println("my name is $it") // my name is Mike
    }
    "Mike".takeIf {
        it.contains("m")
    }.also {
        println("my name is $it") // my name is null
    }

    // takeUnless，与takeIf相反，takeUnless 中的lambda返回 false 时，则返回调用者自己，否则返回Null
    "Holiday".takeUnless {
        it.contains("e")
    }.also {
        println("my name is $it") // my name is Holiday
    }
    "Holiday".takeUnless {
        it.contains("a")
    }.also {
        println("my name is $it") // my name is null
    }
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