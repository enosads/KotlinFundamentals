package aula_22_classe_aninhada

class Car(val model: String, val year: Int) {
    class Engine {
        class FuelType(val name: String) {
            fun fuelCar() {
                println("Abastecendo o carro com o tipo de combustível: $name")
            }
        }

        fun start() { println("Vrummmmmmmmmmmmmmm") }
    }
}

fun main() {
    val car = Car("Ferrari", 2021)
    val carEngine = Car.Engine()

    val engine = Car.Engine()

    val fuelType = Car.Engine.FuelType("Gasolina")
    fuelType.fuelCar()
}