package aula_03_DetalhesTiposDados

fun main() {
    val age: Int = 20

//    adicionar messes em formato decimal ao inteiro da idade (converter idade num tipo de dado numérico flutuante)

    var ageDouble: Double = age.toDouble()

    val monthPercent: Double = 1.0 / 12

    println("ageDouble = $ageDouble monthPercent = $monthPercent")

    // 2 meses depois...
    ageDouble += 2 * monthPercent
    println("ageDouble = $ageDouble monthPercent = $monthPercent")

    // mostrar a idade em formato String com padrão "A idade é X anos."
    val ageText:String = "A idade é $ageDouble anos."
    print(ageText);

    print(ageText.uppercase())
    print(ageText.lowercase())
}