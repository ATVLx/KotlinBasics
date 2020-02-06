package com.vlxstudios.kotlinbasicss

interface IdProvider {
    fun getId():String
}

class Entity private  constructor(val id:String){
    companion object Factory : IdProvider{
        override fun getId(): String {
            return "123"  // overridding the Interface function which has return type String
        }

        const val id = "id"
        fun create() = Entity(getId()) // a companion is an object scoped to an instance within/another class
    }
}
fun main(){
    val entity = Entity.Factory.create()
    entity.id;
    println("$entity :Entity")
}