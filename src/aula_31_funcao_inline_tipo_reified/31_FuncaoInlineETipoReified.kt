package aula_31_funcao_inline_tipo_reified

inline fun executeAction(action: () -> Unit ) {
    println("Before action")
    action()
    println("After action")
}

inline fun <reified T> printTypeName() {
    println("Type name: ${T::class.simpleName}")
}

open class Drink(val name: String)

class Juice: Drink(name = "Suco")
class Soda: Drink(name = "Refrigerante")
class Coffee: Drink(name = "Café")

class Cup<out T: Drink>(val drink: T, val amount: Int)

inline fun <reified T: Drink> serveDrink(cup: Cup<T>) {
    println("[${T::class.simpleName}] Serviu um ${cup.drink.name} com ${cup.amount} ml")
}

fun main() {
    executeAction { println("Action") }

    printTypeName<String>()
    printTypeName<Int>()

    val juice = Juice()
    val juiceCup = Cup<Juice>(juice, 100)
    serveDrink<Juice>(juiceCup)
}