package aula_34_validacoes_de_argumentos

// require

fun dividir(a: Int, b: Int): Int {
    require(b != 0) {"O Divisor não pode ser zero"} // IllegalArgumentException
    return a / b
}

// requireNotNull
fun imprimirNome(nome: String?){
    val nomeNaoNulo = requireNotNull(nome) {"O nome de usuário não foi definido até o momento."} // IllegalArgumentException
    println(nomeNaoNulo)
}

// check

fun processarListaNotas(lista: List<Int>){
    check(lista.isNotEmpty()) { "A lista não pode ser processada. Não há nenhum item inserido"}
    println("Processando lista de tamanho ${lista.size}")
    check(lista.all {it != 0}) { "O aluno foi reprovado devido a possuir uma nota igual a zero"}
    println("A média é lista ${lista.average()}")
}

fun main() {
//    println(dividir(1, 2))
//    println(dividir(1, 0))

//    imprimirNome("Enos")
//    imprimirNome(null)

    processarListaNotas(listOf(1, 3, 3, 4, 5))
    processarListaNotas(emptyList())
}