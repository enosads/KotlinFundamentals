package aula_11_funcoes

fun isEven(num: Int) {
    println("$num é par? ${num % 2 == 0}")
}

fun main() {
    isEven(num = 4)
}