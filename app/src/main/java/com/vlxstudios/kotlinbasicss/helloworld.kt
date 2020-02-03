package com.vlxstudios.kotlinbasicss

val i: Int = 0
fun main() {
    println("Hello world!") // basic println
    // sum(5, 7)
    println("sum " + sum(5, 7)) // this is return function
    sum2(5, 6, 7) //this is void function
    println("max " + maxOf(5, 7)) // this is expression conditions
    printProductofnumer("5", "7")

    println("String Length: " + CheckStringLen("Vishal"))
    loopCheck() // for loop or foreach
    whileCheck() // while loop
    println("Check Object " + DescribeObjTrype("")) //switch statement
   // println("got From another KT file"+addition(5,7))
    var emp = employee(14,"Vishal")
    emp.showData()
    println("Check Range please enter min:")
    var a = readLine()!!.toInt()
    println("Entered value is $a for min please enter the max: ")
    var b = readLine() !!.toInt()
    println("Entered value for min $a and max: $b. please enter the value to check if it fits in range")
    var c = readLine()!!.toInt()

    println("Range check ( min:$a,max:$b, your value:$c)" + CheckRange(a, b, c))




}

//fun refers to function
//fun main() is the entry point

fun sum(a: Int, b: Int) = a + b  // getting values and immediate returning it with answer.

fun sum2(
    a: Int,
    b: Int,
    c: Int
): Unit {   // unit is something which doesnt returns any value just like void in C# else if dont write "unit" it will still consider void.

    println("Sum2 is ${a + b + c}")

}

fun maxOf(a: Int, b: Int) = if (a > b) a else b // expression conditions

fun parseInt(str: String) = if (str.toInt() == str.toInt()) str.toInt() else if (str.toInt() !is Int) null else null


fun printProductofnumer(arg1: String, arg2: String) {
    var x = parseInt(arg1)
    var y = parseInt(arg2)

    if (x != null && y != null) {
        println("Product is " + x * y);
    } else {
        println("$x or $y is not a number")
    }


}

fun CheckStringLen(str: String): Int? {
    if (str is String) {
        return str.length
    }
    return null
}

fun loopCheck() {
    val items = listOf<String>("Apple", "Banana", "Kiwi")
    for (item in items) {
        println("for Loop items " + item)
    }
}

fun whileCheck() {
    val items = listOf<String>("Apple", "Banana", "Kiwi")
    var index = 0
    while (index < items.size) {
        println("while loop items " + items[index])
        index++
    }
}

fun DescribeObjTrype(obj: Any): String =
    when (obj) {
        1 -> "one"
        "Hello" -> "Greeting"
        is Long -> "Long"
        !is String -> "Not a String"
        else -> "Unknown Object type"
    }

fun CheckRange(min: Int, max: Int, value: Int): String {
    if (value in min..max) {
        return "fits in range"
    } else {
        return "doesn't Fits in range"
    }
}