package aula_25_classes_abstratas

abstract class Vehicle(val color: String) {
    abstract val maxSpeed: Int
    abstract val wheelsAmount: Int

    abstract fun startMovement()
    fun info() {
        println(
            """
            Velocidade Máxima: $maxSpeed km/h
            Quantidade de rodas: $wheelsAmount
        """.trimIndent()
        )
    }
}

class Car(val model: String, val year: Int, color: String) : Vehicle(color = color) {
    override val maxSpeed: Int
        get() = 150
    override val wheelsAmount: Int
        get() = 4

    override fun startMovement() {
        println("Vrummmmmmmmmmmmmmm")
    }
    override fun toString(): String {
        super.info()
        return "$model, $year"
    }
}


class Bike(color: String) : Vehicle(color = color) {
    override val maxSpeed: Int
        get() = 40
    override val wheelsAmount: Int
        get() = 2

    override fun startMovement() {
        println("Pedalando...")
    }
}

fun main() {
    val car = Car(
        model = "Ferrari",
        year = 2021,
        color = "Vermelho"
    )
    val bike = Bike(color = "Azul")
    println(car)
    bike.info()
    car.startMovement()
    bike.startMovement()
}