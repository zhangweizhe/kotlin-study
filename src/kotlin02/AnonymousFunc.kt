package kotlin02

/**
 * 匿名函数
 */
fun main() {
    val count = "banana".count()
    val countA = "banana".count { letter -> letter == 'a' }

    println(count) //6
    println(countA) //3

    // 声明一个变量af，变量类型是匿名函数
    // 没有入参，返回值是String
    val af:() -> String
    // 给 af 赋值
    af = {
        val name = "Bob"
        // 匿名函数不需要return 关键字，会直接把函数体的最后一行代码作为返回值
        // 所以匿名函数的最后一行表达式的类型，必须和返回值一致
        "Hello $name"
    }
    println(af) //() -> kotlin.String // 打印的是变量类型
    println(af()) //Hello Bob // 打印变量的值

    // 声明一个变量af1，变量类型是匿名函数
    // 入参是String 和 Int，返回值是String
    val af1 : (String, Int) -> String
    // 给af1赋值
    af1 = { s: String, i: Int ->
        "append result $s, $i"
    }

    println(af1("hello", 5)) //append result hello, 5

    // it 关键字，如果匿名函数只有一个入参，定义函数时，可以不写参数名
    val af2 : (String) -> String = {
        "Hello $it"
    }

    println(af2("Alice")) //Hello Alice

    // 匿名函数类型推断，包括返回类型推断是参数类型推断
    // 返回类型推断
    // 声明的时候不需要显式写上返回值类型
    val af3  = {
        "Hello everyone"
    }
    println(af3()) //Hello everyone

    // 参数类型推断
    // 声明函数的时候，不需要显式写明参数的类型，在定义的时候再写明
    val af4 = {name:String, year:Int ->
        "Hello $name from $year"
    }
    println(af4("Jack", 2020)) //Hello Jack from 2020


    // 函数作为另一个函数的参数
    val getDiscount1 = {goodsName: String, hour: Int->
        val year = 2021
        "${year}年双十一，${goodsName}促销还有 ${hour} 小时"
    }

    showOnBoard("游戏机", getDiscount1, 7.8f) //2021年双十一，游戏机促销还有 4 小时

    //2022年双十一，笔记本电脑促销还有 8 分钟
    showOnBoard("笔记本电脑", { gn:String, hour: Int ->
        "2022年双十一，${gn}促销还有 $hour 分钟"
    }, 6.5f)

    // 如果函数作为最后一个参数，调用时作为参数的函数体，写在()之外
    //2022年双十一，显卡促销还有 21 分钟
    showOnBoard("显卡") { gn:String, hour: Int ->
        "2022年双十一，${gn}促销还有 $hour 分钟"
    }
}

fun showOnBoard(goodsName: String, getDiscount: (String, Int) -> String, discount:Float) {
    val hour = (1..24).shuffled().last()
    println(getDiscount(goodsName,  hour))
}

fun showOnBoard(goodsName: String, getDiscount: (String, Int) -> String) {
    val hour = (1..24).shuffled().last()
    println(getDiscount(goodsName,  hour))
}