package aula_08_colecoes

fun main() {
    val array: Array<Int> = arrayOf(1, 2, 3, 4, 5)
    val array2: Array<String> = arrayOf("1", "2", "3")

    println(array.joinToString(prefix = "[", postfix = "]", separator = " | "))
    println(array2.joinToString())

    val array3: Array<Int> = arrayOf(6, 7, 8, 9, 10)
    val arraySum = array + array3
    println(arraySum.joinToString())
}