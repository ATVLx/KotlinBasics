package com.vlxstudios.kotlinbasicss

fun main()    {
    println("Hello world!")
    sum(5,7)
    println("sum " +sum(5,7))
    sum2(5,6,7)
}
//fun refers to function
//fun main() is the entry point

fun sum(a: Int, b: Int) = a + b  // getting values and immediate returning it with answer.

fun sum2(a:Int,b:Int,c:Int) : Unit{   // unit is something which doesnt returns any value just like void in C# else if dont write "unit" it will still consider void.

    println("Sum2 is ${a+b+c}")
    println("Sum3 is ${a+b+c}")
}