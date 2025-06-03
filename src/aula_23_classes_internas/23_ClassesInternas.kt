package aula_23_classes_internas

class Car(var model: String, val year: Int) {
    inner class Engine {
        inner class Fuel(val typeName: String) {
            fun fuelCar() {
                println("Abastecendo o carro $model, $year com $typeName")
            }
        }
        fun start() {
            println("Vrummmmmmmmmmmmmmm")
        }
    }
}

fun main() {
    val carEngine = Car("Ferrari", 2021).Engine()

    val carEngineFUelType = carEngine.Fuel(typeName = "Gasolina")

    carEngine.start()
    carEngineFUelType.fuelCar()

}