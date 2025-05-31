package aula_09_operadores_matematicos

import kotlin.math.ceil
import kotlin.math.floor
import kotlin.math.log10
import kotlin.math.pow
import kotlin.math.roundToInt

fun main() {
    val num = 4
    val num2 = 2

    // operadores básicos
    println("Operadores básicos")
    println("Soma: ${num.plus(num2)}")
    println("Subtração: ${num.minus(num2)}")
    println("Multiplicação: ${num.times(num2)}")
    println("Divisão: ${num.div(num2)}")
    println("Resto: ${num.rem(num2)}")

    var num3 = 10
    var num4 = 20

    //Operadores de incremento
    println("Operadores de incremento")
    println("Incremento ${num3++}")
    println("Decremento ${num4--}")

    // operadores de atribuição composta
    println("Operadores de atribuição composta")
    var num5 = 1
    num5 += num
    println(num5)
    num5 -= num
    println(num5)
    num5 *= num
    println(num5)
    num5 /= num
    println(num5)
    num5 %= num
    println(num5)

    // biblioteca math
    println("biblioteca math")
    val value = 2.567
    val valueRounded = value.roundToInt()
    println(valueRounded)

    val valueFloor = floor(value)
    println(valueFloor)

    val valueCeil = ceil(value)
    println(valueCeil)

    val base = 2.0
    val exponent = 3.0
    val valuePow = base.pow(exponent)
    println(valuePow)

    val logValue = log10(100.0)
    println(logValue)

}