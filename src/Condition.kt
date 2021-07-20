
fun main() {

    // if...else
    val a = 0
    if (a !in 0..3) {
        println("婴儿")
    }else if (a in 3..12) {
        println("少儿")
    }else {
        println("未知")
    }

    // when
    val job = "教师"
    val jobEn = when(job) {
        "教师" -> "teacher"
        "工程师" -> "Enginner"
        "歌手" -> "Singer"
        else -> "未知"
    }
    println(jobEn)
}