package aula_33_typealiases

typealias Operation = (Int, Int) -> Int

fun mathOperation(a: Int, b: Int, operation: Operation): Int {
    return operation(a, b)
}
typealias NomeDoAluno = String
typealias NotasDoAluno = List<Int>
typealias MapaDeEstudantes = Map<NomeDoAluno, NotasDoAluno>

fun processaNotas(mapaEstudantes: MapaDeEstudantes) {
    for ((nome, notas) in mapaEstudantes) {
        println("$nome => ${notas.average()}")
    }
}


fun main() {
    val estudantes = mapOf(
        "Alice" to listOf(10, 9, 8),
        "Bob" to listOf(7, 6, 9)
    )
    processaNotas(estudantes)
}