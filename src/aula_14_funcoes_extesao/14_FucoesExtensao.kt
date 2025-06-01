package aula_14_funcoes_extesao

fun String.isPalindrome() = this.reversed() == this

fun Double.format(decimalDigits: Int): String {
    return "%.${decimalDigits}f".format(this)
}

fun main() {
    println("arara".isPalindrome())
    println("enos".isPalindrome())
    println("radar".isPalindrome())

    println(3.14159.format(decimalDigits = 2))
}