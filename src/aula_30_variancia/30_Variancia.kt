package aula_30_variancia

open class Animal(val name: String)

class Dog : Animal(name = "Cachorro")
class Cat : Animal(name = "Gato")
class Bird : Animal(name = "Pássaro")


// contravariance = in (consumidores)
class Feeder<in T : Animal> {
    fun feed(animal: T) {
        println("O ${animal.name} foi alimentado")
    }
}

// covariance = out (produtores)

open class Drink(val name: String)

class Juice: Drink(name = "Suco")
class Soda: Drink(name = "Refrigerante")
class Coffee: Drink(name = "Café")

class Cup<out T: Drink>(val drink: T, val amount: Int)

fun serveDrink(cup: Cup<Drink>) {
    println("Serviu um ${cup.drink.name} com ${cup.amount} ml")
}

fun main() {
    val catFeeder = Feeder<Cat>()
    val dogFeeder = Feeder<Dog>()
    catFeeder.feed(animal = Cat())
    dogFeeder.feed(animal = Dog())
    serveDrink(cup = Cup<Coffee>(drink = Coffee(), amount = 100))
    serveDrink(cup = Cup<Juice>(drink = Juice(), amount = 300))
}