package aula_16_classes

import kotlin.random.Random

class Person(val name: String = "Desconhecido", val lastName: String, val age: Int) {
    val fullName: String = "$name $lastName"
    private val password: String = name + Random.nextInt(100);

    private fun usePassword() {
        println(password)
    }

    fun work() {
        usePassword()
        println("$name is working")
    }
}

fun main() {
    val jose = Person(name = "José", lastName = "Silva", age = 35)
    val maria = Person(name = "maria", lastName = "Rodrigues", age = 27)
    println(jose)
    jose.work()
    maria.work()

    println(jose.fullName)
    println(maria.fullName)
}