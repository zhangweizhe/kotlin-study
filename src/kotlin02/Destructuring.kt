package kotlin02

fun main() {
    // 解构声明，把一个对象赋值给多个变量
    val name = "Mike Jordan"
    val (firstName, lastName) = name.split(' ')
    println("first name is $firstName, last name is $lastName") //first name is Mike, last name is Jordan

    var book:Book = Book("HelloWorld", 5.2f)
    val (bookName, bookPrice) = book
    println("book name is $bookName, price is $bookPrice") //book name is HelloWorld, price is 5.2

    val computer = Computer("mac", 8000f)
    val (brand, price, cpu) = computer
    println("brand is $brand, price is $price, cpu is $cpu") //brand is mac, price is 8000.0, cpu is intel
}

// 关键字data，表示这个类的变量是可以解构声明的
data class Book(var name:String, var price:Float)

class Computer(var brand:String, var price:Float) {

    val cpu = "intel"

    // 被data修饰的class，在编译时会自动添加 operator fun componentN() 方法
    // 手动添加 componentN() 方法，也能实现解构声明
    operator fun component1():String {
        return brand
    }
    operator fun component2():Float {
        return price
    }
    operator fun component3():String {
        return cpu
    }
}