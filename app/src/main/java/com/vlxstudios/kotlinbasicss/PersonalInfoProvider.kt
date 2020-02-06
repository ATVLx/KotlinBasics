package com.vlxstudios.kotlinbasicss

interface PersonalInfoProvider {
    fun printInfo(person: Person)

}

 class BasicInfoProvider : PersonalInfoProvider{
     override fun printInfo(person: Person) {
        println("Basic Info")
     }


}
fun main(){
    val provider = BasicInfoProvider()
   // provider.printInfo()
}