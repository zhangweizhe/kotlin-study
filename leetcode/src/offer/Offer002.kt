package offer

fun main() {
    // 剑指 Offer II 002. 二进制加法
    // https://leetcode-cn.com/problems/JFETK5/
    println(addBinary1("101111", "10"))
}

fun addBinary(a: String, b: String): String {
    var i = a.length - 1
    var j = b.length - 1

    var ret = ""
    var carry = 0

    while (i >= 0 && j >= 0) {
        val charA = a[i]
        val charB = b[j]
        if (charA == '1' && charB == '1') {
            if (carry == 1) {
                ret = "1$ret"
            }else {
                ret = "0$ret"
            }
            carry = 1
        }else if (charA == '1' || charB == '1'){
            if (carry == 1) {
                ret = "0$ret"
                carry = 1
            }else {
                ret = "1$ret"
                carry = 0
            }
        }else if (carry == 1) {
            ret = "1$ret"
            carry = 0
        }else {
            ret = "0$ret"
            carry = 0
        }
        i--
        j--
    }

    while (i >= 0) {
        val charA = a[i]
        if (charA == '1') {
            if (carry == 1) {
                ret = "0$ret"
                carry = 1
            }else {
                ret = "1$ret"
                carry = 0
            }
        }else {
            ret = "$carry$ret"
            carry = 0
        }
        i--
    }

    while (j >= 0) {
        val charB = b[j]
        if (charB == '1') {
            if (carry == 1) {
                ret = "0$ret"
                carry = 1
            }else {
                ret = "1$ret"
                carry = 0
            }
        }else {
            ret = "$carry$ret"
            carry = 0
        }
        j--
    }

    if (carry == 1) {
        ret = "1$ret"
    }

    return ret
}


fun addBinary1(a: String, b: String): String {
    val aLength = a.length
    val bLength = b.length

    var ret = ""
    var carry = 0

    val maxLength = Math.max(aLength, bLength)
    var k = 0

    while (k < maxLength) {
        val charA = if (k < aLength) {
            a[aLength - k - 1]
        }else {
            '0'
        }
        val charB = if (k < bLength) {
            b[bLength - k - 1]
        }else {
            '0'
        }

        val tmp = (charA - '0').xor(charB - '0').xor(carry)
        carry = if((charA - '0') + (charB - '0') + carry >= 2) {
            1
        }else {
            0
        }

        ret = "$tmp$ret"
        k++
    }

    if (carry == 1) {
        ret = "1$ret"
    }

    return ret
}