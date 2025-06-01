package aula_06_controle_de_excesoes

fun main() {
    // try/catch
    var x: Int = 1
    x = try {
        // código desejado a ser eecutado pelo programa
        1 / 0
//        throw InvalidParameterException("Valor inválido")
//        println(x)
    } catch (e: ArithmeticException) {
        // caso uma excesão ao bloco try aconteça
        println("Erro de expressão aritmética.")
        3

    } catch (e: Exception) {
        println("Erro genérico.")
        4
    }
    println(x)
}