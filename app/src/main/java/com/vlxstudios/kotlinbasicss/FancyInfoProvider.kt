package com.vlxstudios.kotlinbasicss

class FancyInfoProvider : BasicInfoProvider() {
    override fun getSessionId(): String {
        return super.getSessionId()
    }

    override val sessionIdPrefix: String
        get() = "Fancy Session"

    override val providerInfo: String
        get() = "Fancy Info Provider"

    override fun printInfo(person: Person) {
        super.printInfo(person)
        println("Fancy info")
    }
}