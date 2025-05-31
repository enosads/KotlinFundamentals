fun main() {
    println("Entre com o seu nome:")
    val name = readln()

    println("Hello, $name!")

    println("E qual é a sua idade?")
    val age = readln().toInt()

    for (i in 1..age) {
        val ageText = if (i == age) "A sua idade é $i" else "$i..."
        println(ageText)
    }
}