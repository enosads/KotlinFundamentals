package aula_04_OperadoresLogicos

fun main() {
    val a = true
    val b = false
    val c = true
    val d = false

    // operador E (&&)
    val result = a && b
    val result2 = a && c

    println("Operador E:")
    println(result)
    println(result2)

    // operador OU (||)
    val result3 = a || b
    val result4 = a || c
    val result5 = a || d

    println("Operador OU:")
    println(result3)
    println(result4)
    println(result5)

    // operador NOT (!)
    val result6 = !a
    val result7 = !b

    println("Operador NOT:")
    println(result6)
    println(result7)

    val num1 = 10
    val num2 = 5
    println("Operadores de comparação:")

    // operador IGUALDADE (==)
    println(num1 == num2)

    // operador DESIGUALDADE, DIFERENTE DE (!=)
    println(num1 != num2)

    // operador É DO TIPO e NÃO É DO TIPO (is e !is)

    println("Operadores É DO TIPO e NÃO É DO TIPO:")

    val num: Any = 1
    val numText: Any = "1"

    println(num is String)
    println(numText is String)

    println(num !is String)
    println(numText !is String)

    // operadores PERTENCE e NÃO PERTENCE (in e !in)
    val range = 1..10
    val e = 5
    val f = 11

    println("Operadores PERTENCE e NÃO PERTENCE:")
    println(e in range)
    println(f in range)

    println(e !in range)
    println(f !in range)
}