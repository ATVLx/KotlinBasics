package com.vlxstudios.kotlinbasicss

interface PersonalInfoProvider
{
    val providerInfo:String

    fun printInfo(person: Person)
    {
        println(providerInfo)
        person.printInfo()
    }

}

interface SessionInfoProvider{
    fun getSessionId():String{
        return "Vishal"
    }
}

open class BasicInfoProvider : PersonalInfoProvider, SessionInfoProvider{

   override val providerInfo:String
     get() = "basicInfoProvider"

protected open val sessionIdPrefix = "Session"

     override fun printInfo(person: Person) { // overrides session Funtion
         super.printInfo(person)
         println("Additional Print Statement")
     }

    override fun getSessionId(): String { // overrides session function
         return sessionIdPrefix
     }

}
fun main(){
    val provider = FancyInfoProvider()
  provider.printInfo(Person()) // person() is an empty instance of a Person Class
  //  provider.getSessionId()
    checkTypes(provider)
}

fun checkTypes(infoProvider: PersonalInfoProvider){
    if(infoProvider is SessionInfoProvider){
        println("it is a session info provider")
        println(infoProvider.getSessionId())

    }
    else{
        println("it is not a session info provider")

    }
}