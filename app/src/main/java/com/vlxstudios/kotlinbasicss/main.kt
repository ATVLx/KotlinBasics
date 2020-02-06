package com.vlxstudios.kotlinbasicss

class vlx(val firstname: String = "Peter", val lastName: String = "Parker") {
    var a: String
    var b: String
    var c: String
    var d: String
    lateinit var random: String

    init {
        // this block usually used to initialize the values if we declare inside the class
        //it is also known as a constructor/acts as a constructor
        // a class can have more than init{} blocks
        // now we initialize the values decalred inside the class
        a = firstname
        b = lastName

        println("first init block")
    }

    init {
        //this is second init in which
        c = firstname
        d = lastName
        println("Second init block")
    }

    // or we can do write a constructor keyword like this

    constructor(): this("Peter","Parker") {
     println("Secondary Constructor")
     println("$a $b   <- this is called from secondary constructor")
    // this is refered to a secondary constructor
    //this constructor is only processed after completing all init functions
}
}


class Person(val firstName:String, val lastName:String){
    var nickName: String? = null

    set(value){
        field = value
        println("the New Nickname is $field")
    }
    get(){
        println("The Returned value is $field")
        return field
    }

    fun printInfo(){
        val nickNameToPrint = nickName?:"No Nick Name"
        println("$firstName $nickNameToPrint $lastName")
    }
}