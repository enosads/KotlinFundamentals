package desafios

fun main() {
    println("Insira o preço por litro da GASOLINA")
    print("R$ ")
    val precoGasolina = readlnOrNull()?.toDoubleOrNull()
    println("Insira o preço por litro do ETANOL")
    print("R$ ")
    val precoEtanol = readlnOrNull()?.toDoubleOrNull()

    if (precoGasolina == null || precoEtanol == null) {
        println("Os valores inseridos são inválidos")
        return
    }

    val razaoCombustivel = precoEtanol / precoGasolina
    println(
        when {
            razaoCombustivel < 0.7 -> "Etanol é mais econômico"
            razaoCombustivel > 0.7 -> "Gasolina é mais econômico"
            else -> "Ambos os combustíveis têm o mesmo custo-benefício"
        }
    )
}