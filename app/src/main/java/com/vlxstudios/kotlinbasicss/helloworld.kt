package com.vlxstudios.kotlinbasicss
 // ? is reffered to nullable
//eg:- var i : String? = null
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
    val interestingProgrammin = arrayOf("Kotlin","C#","C++")
    sayhello("hi", *interestingProgrammin) //why we add star ? becasue star is a spread operator. it breakes the array into values and pass it to the non array(non Primitive variable) arguement eg : just a string
    println(arguementOrderchanger( Name= "Vishal",greeting = "Hello")) // unordered argument  in kotlin technique
    println(arguementOrderchanger()) // we can even give zero arguement because we provided it default paramaeters
    println(arguementOrderchanger( Name= "Vishal",greeting = "Hello"))

    val vishal = vlx()
   /* println("Check Range please enter min:")
    var a = readLine()!!.toInt()
    println("Entered value is $a for min please enter the max: ")
    var b = readLine() !!.toInt()
    println("Entered value for min $a and max: $b. please enter the value to check if it fits in range")
    var c = readLine()!!.toInt()

    println("Range check ( min:$a,max:$b, your value:$c)" + CheckRange(a, b, c))*/




}

//fun refers to function
//fun main() is the entry point


fun CheckRange(min: Int, max: Int, value: Int): String {    // range check
    if (value in min..max) {
        return "fits in range"
    } else {
        return "doesn't Fits in range"
    }
}


    fun sayhello(s:String,vararg greet:String){  //what is vararg ? it is a keyword in kotlin which represent the variable number of arguements
        greet.forEach { itemtoGreet ->
            println("$s $itemtoGreet")
        }
    }


 fun arguementOrderchanger(greeting:String="hello",Name:String="Vishal"): String{
     println("this is arguement order changing facility in Kotlin you can see the details below by changing the order of arguements in main function")
     return "$greeting $Name"

 }
