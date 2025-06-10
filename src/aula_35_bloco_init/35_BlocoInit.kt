package aula_35_bloco_init

class Pessoa(val nome: String, val idade: Int){
    init {
        require(nome.isNotBlank()) { "Nome não pode ser vazio."}
        println("Pessoa criada: $nome, $idade anos.")
    }
}

class Carro(val marca: String, val modelo: String){
    var ano: Int = 0

    init {
        println("Inicializando carro: $marca, $modelo, $ano.")
    }

    constructor(marca: String, modelo: String, ano: Int): this(marca, modelo){
        this.ano = ano
        println("Ano do carro definido: $ano.")
    }
}

fun main() {
//    val ana = Pessoa("", 39)

    val uno = Carro(marca = "Fiat", modelo = "Uno", ano = 2021)
    println("Ano do carro: ${uno.ano}")
}