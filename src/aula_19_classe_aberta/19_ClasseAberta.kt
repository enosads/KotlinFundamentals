package aula_19_classe_aberta

open class Animal(val name: String) {
    open val age: Int = 0
    open fun sound() = println("$name Animal sound")
}

class Dog(override val age: Int) : Animal(name = "Cachorro") {
    override fun sound() = println("$name: AU")
}

fun main() {
    val dog = Dog(age = 5)
    dog.sound()
    println(dog.age)
}