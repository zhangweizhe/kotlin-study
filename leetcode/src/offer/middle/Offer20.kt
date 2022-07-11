package offer.middle

fun main() {
    // 剑指 Offer 20. 表示数值的字符串
    // https://leetcode.cn/problems/biao-shi-shu-zhi-de-zi-fu-chuan-lcof/
    println(isNumber("  -12.3e1"))
}

fun isNumber(s: String): Boolean {

    val transferMap = HashMap<State, MutableMap<CharType, State>>()

    val initialMap = HashMap<CharType, State>().apply {
        this[CharType.BLANK] = State.INITIAL
        this[CharType.SIGN] = State.INT_SIGN
        this[CharType.INT] = State.INT
        this[CharType.DOT] = State.DOT_WITHOUT_INT
    }
    transferMap[State.INITIAL] = initialMap

    val intSignMap = HashMap<CharType, State>().apply {
        this[CharType.INT] = State.INT
        this[CharType.DOT] = State.DOT_WITHOUT_INT
    }
    transferMap[State.INT_SIGN] = intSignMap

    val intMap = HashMap<CharType, State>().apply {
        this[CharType.INT] = State.INT
        this[CharType.DOT] = State.DOT
        this[CharType.EXP] = State.EXP
        this[CharType.BLANK] = State.END
    }
    transferMap[State.INT] = intMap

    val dotMap = HashMap<CharType, State>().apply {
        this[CharType.INT] = State.FRACTION
        this[CharType.EXP] = State.EXP
        this[CharType.BLANK] = State.END
    }
    transferMap[State.DOT] = dotMap

    val dotWithoutIntMap = HashMap<CharType, State>().apply {
        this[CharType.INT] = State.FRACTION
    }
    transferMap[State.DOT_WITHOUT_INT] = dotWithoutIntMap

    val fractionMap = mutableMapOf(
            CharType.BLANK to State.END,
            CharType.INT to State.FRACTION,
            CharType.EXP to State.EXP
    )
    transferMap[State.FRACTION] = fractionMap

    val expMap = mutableMapOf(
            CharType.SIGN to State.EXP_SIGN,
            CharType.INT to State.EXP_INT
    )
    transferMap[State.EXP] = expMap

    val expSignMap = mutableMapOf(
            CharType.INT to State.EXP_INT
    )
    transferMap[State.EXP_SIGN] = expSignMap

    val expIntMap = mutableMapOf(
            CharType.INT to State.EXP_INT,
            CharType.BLANK to State.END
    )
    transferMap[State.EXP_INT] = expIntMap

    val endMap = mutableMapOf(
            CharType.BLANK to State.END
    )
    transferMap[State.END] = endMap

    var state = State.INITIAL
    for (c in s) {
        val toCharType = toCharType(c)
        val stateMap = transferMap[state]
        val nextState = stateMap?.get(toCharType)
        if (nextState == null) {
            return false
        }else {
            state = nextState
        }
    }
    return state.isReceive
}

private fun toCharType(c: Char): CharType {
    return when (c) {
        ' ' -> CharType.BLANK
        '+','-' -> CharType.SIGN
        in '0'..'9' -> CharType.INT
        '.' -> CharType.DOT
        'e', 'E' -> CharType.EXP
        else -> CharType.ILLEGAL
    }
}

enum class State(val isReceive:Boolean){
    /**
     * 初始状态
     */
    INITIAL(false),

    /**
     * 符号位，[+-]
     */
    INT_SIGN(false),

    /**
     * 整数，接受状态
     */
    INT(true),

    /**
     * 小数点，左边有整数，接受状态
     */
    DOT(true),

    /**
     * 小数点，左边没有整数
     */
    DOT_WITHOUT_INT(false),

    /**
     * 小数，接受状态
     */
    FRACTION(true),

    /**
     * 指数符号 [eE]
     */
    EXP(false),

    /**
     * 指数符号 [+-]
     */
    EXP_SIGN(false),

    /**
     * 指数数值，接受状态
     */
    EXP_INT(true),

    /**
     * 末尾的空格，接受状态
     */
    END(true)
}

enum class CharType {
    BLANK,
    SIGN,
    INT,
    DOT,
    EXP,
    ILLEGAL
}