import com.sun.xml.internal.fastinfoset.util.StringArray

fun main() {

    val array = intArrayOf(1,2,3,4,7)

    val map = array.map {
        it * 2
    }

    println(map)

    val fold:String = array.fold("init") { acc, i ->
        println(acc)
        println(i)
        println("-----")
        "$acc, $i"
    }

    println(fold)

    println("123".doubleLength())
}

fun String.doubleLength():Int {
    return length * 2
}

private fun doubleLength1(input:String):Int {
    return input.length * 2
}