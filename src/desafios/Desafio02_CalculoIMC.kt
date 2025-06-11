package desafios

import kotlin.math.pow

fun validarPeso(peso: Double?) = if (peso != null) peso in 0.0..300.0 else false
fun validarAltura(altura: Double?) = if (altura != null) altura in 0.0..3.0 else false

fun calcularIMC(peso: Double, altura: Double) = peso / altura.pow(2)

fun classificaIMC(imc: Double) = when {
    imc < 18.5 -> "Abaixo do peso"
    imc < 24.9 -> "Peso normal"
    imc < 29.9 -> "Sobrepeso"
    imc < 34.9 -> "Obesidade grau I"
    imc < 39.9 -> "Obesidade grau II"
    imc > 39.9 -> "Obesidade grau III"
    else -> "Desconhecido"
}

enum class ClassificacaoIMC(val descricao: String) {
    ABAIXO_DO_PESO("Abaixo do peso"),
    PESO_NORMAL("Peso normal"),
    SOBREPESO("Sobrepeso"),
    OBESIDADE_GRAU_I("Obesidade grau I"),
    OBESIDADE_GRAU_II("Obesidade grau II"),
    OBESIDADE_GRAU_III("Obesidade grau III"),
    DESCONHECIDO("Desconhecido");

    companion object {
        fun gerarClassificacao(imc: Double): ClassificacaoIMC {
            return when {
                imc < 18.4 -> ABAIXO_DO_PESO
                imc in 18.5..24.9 -> PESO_NORMAL
                imc in 25.0..29.9 -> SOBREPESO
                imc in 30.0..34.9 -> OBESIDADE_GRAU_I
                imc in 35.0..39.9 -> OBESIDADE_GRAU_II
                imc > 39.9 -> OBESIDADE_GRAU_III
                else -> DESCONHECIDO
            }
        }
    }
}

fun main() {
    println("Bem vindo ao Cálculo de IMC!")
    print("Insira o seu peso (em quilogramas): ")
    val peso = readlnOrNull()?.toDoubleOrNull()
    if (!validarPeso(peso = peso)) {
        println("O valor de peso inserido é inválido.")
        return
    }
    print("Insira a sua altura (em metros): ")
    val altura = readlnOrNull()?.toDoubleOrNull()
    if (!validarAltura(altura = altura)) {
        println("O valor de altura inserido é inválido.")
        return
    }

    val imc = calcularIMC(peso = peso!!, altura = altura!!)

    val classificacaoIMC = ClassificacaoIMC.gerarClassificacao(imc = imc)

    println("O seu IMC é ${"%.1f".format(imc)} e a sua classificação é ${classificacaoIMC.descricao}.")

}