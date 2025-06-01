package aula_05_estruturas_condicionais

fun main() {
    // if / else / else if
    val x = 50
    val y = 150

    val result = if (x > y) {
        "x > y"
    } else if (x < y) {
        "x < y"
    } else if (x == y) {
        "x == y"
    } else {
        "x is neither 'x' nor 'y'"
    }
    println("if / else if / else")
    println(result)

    val result2 = when (x) {
        in 1..100 -> "x está compreendido entre 1 e 100"
        100 -> "x é igual a 100"
        in 101..200 -> "x está compreendido entre 101 e 200"

        else -> "else"
    }
    println(result2)

    val result3 = when (y) {
        in 1..100 -> "y está compreendido entre 1 e 100"
        100 -> "y é igual a 100"
        in 101..200 -> "y está compreendido entre 101 e 200"

        else -> "else"
    }
    println(result3)
}