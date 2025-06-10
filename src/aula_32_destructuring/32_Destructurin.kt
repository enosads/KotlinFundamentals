package aula_32_destructuring

data class Person(val name: String, val lastName: String, val age: Int)

class Animal(val name: String, val age: Int){
    operator fun component1() = name
}

fun main() {
    val (name, lastName, age) = Person("Enos", "Andrade", 29)
    val (a, b) = Pair<String, String>("a", "b")
    val (c,d, e) = Triple<Int, Boolean, Double>(10, false, 5.0)


    val (animalName,  ) = Animal("Cachorro", 5)
}