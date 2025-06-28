package desafios

data class Produto(
    val id: Int,
    val nome: String,
    val preco: Double,
    val quantidade: Int
)

interface Estoque<T> {
    fun inserir(item: T)
    fun deletar(id: Int): Boolean
    fun atualizar(item: T): Boolean
    fun buscar(id: Int): T?
    fun buscarTodos(): List<T>
}

class EstoqueDeProdutos : Estoque<Produto> {
    private val listaProdutos = mutableListOf<Produto>()
    override fun inserir(item: Produto) {
        listaProdutos.add(item)
    }

    override fun deletar(id: Int): Boolean {
        return listaProdutos.removeIf { it.id == id }
    }

    override fun atualizar(item: Produto): Boolean {
        val posicao = listaProdutos.indexOfFirst { it.id == item.id }
        if (posicao != -1) {
            listaProdutos[posicao] = item
            return true
        }
        return false
    }

    override fun buscar(id: Int): Produto? {
        return listaProdutos.find { it.id == id }
    }

    override fun buscarTodos(): List<Produto> {
        return listaProdutos.toList()
    }
}

fun preencherProdutoAtualizado(produtoASerAtualizado: Produto): Produto {
    var nome: String?
    var preco: Double?
    var quantidade: Int?
    println("Altere o NOME do produto: (caso não queira mudar, tecle ENTER):")
    do {
        print("-> ")
        nome = readlnOrNull()?.ifEmpty { produtoASerAtualizado.nome }
        if (nome.isNullOrEmpty()) {
            println("O NOME inserido é inválido. Tente novamente.")
        }
    } while (nome.isNullOrEmpty())
    println("Altere o PREÇO do produto  (caso não queira mudar, tecle ENTER): ")
    do {
        print("-> R$ ")
        preco = readlnOrNull()?.ifEmpty { produtoASerAtualizado.preco.toString() }?.toDoubleOrNull()
        if (preco == null || preco < 0) {
            println("O PREÇO inserido é inválido. Tente novamente.")
        }
    } while (preco == null || preco < 0)
    println("Altere a QUANTIDADE do produto em estoque  (caso não queira mudar, tecle ENTER): ")
    do {
        print("-> ")
        quantidade = readlnOrNull()?.ifEmpty { produtoASerAtualizado.quantidade.toString() }?.toIntOrNull()
        if (quantidade == null || quantidade < 0) {
            println("A QUANTIDADE inserido é inválido. Tente novamente.")
        }
    } while (quantidade == null || quantidade < 0)

    return Produto(id = produtoASerAtualizado.id, nome = nome, preco = preco, quantidade = quantidade)
}

fun preencherProduto(): Produto {
    var id: Int?
    var nome: String?
    var preco: Double?
    var quantidade: Int?

    println("Insira o ID do produto: ")
    do {
        print("-> ")
        id = readlnOrNull()?.toIntOrNull()
        if (id == null || id < 0) {
            println("O ID inserido é inválido. Tente novamente.")
        }
    } while (id == null || id < 0)
    println("Insira o NOME do produto: ")
    do {
        print("-> ")
        nome = readlnOrNull()
        if (nome.isNullOrEmpty()) {
            println("O NOME inserido é inválido. Tente novamente.")
        }
    } while (nome.isNullOrEmpty())
    println("Insira o PREÇO do produto: ")
    do {
        print("-> R$ ")
        preco = readlnOrNull()?.toDoubleOrNull()
        if (preco.isNullOrNegative()) {
            println("O PREÇO inserido é inválido. Tente novamente.")
        }
    } while (preco.isNullOrNegative())
    println("Insira a QUANTIDADE do produto em estoque: ")
    do {
        print("-> ")
        quantidade = readlnOrNull()?.toIntOrNull()
        if (quantidade.isNullOrNegative()) {
            println("A QUANTIDADE inserido é inválido. Tente novamente.")
        }
    } while (quantidade.isNullOrNegative())

    return Produto(id = id, nome = nome, preco = preco!!, quantidade = quantidade!!)
}

fun Int?.isNullOrNegative(): Boolean {
    return this == null || this < 0
}

fun Double?.isNullOrNegative(): Boolean {
    return this == null || this < 0
}

enum class AcoesMenu {
    DESCONHECIDA,
    ADICIONAR_PRODUTO,
    ATUALIZAR_PRODUTO,
    DELETAR_PRODUTO,
    BUSCAR_PRODUTO,
    SAIR
}

fun main() {
    val estoqueDeProdutos = EstoqueDeProdutos()

    var acao: Int?

    do {
        println(
            """
            +--------------------------------+
            | CONTROLE DE ESTOQUE - PRODUTOS |
            +--------------------------------+
            | 1 - Adicionar                  |
            | 2 - Atualizar                  |
            | 3 - Deletar                    |
            | 4 - Buscar                     |
            | 5 - Sair                       |
            +--------------------------------+
    
        """.trimIndent()
        )
        println("LISTA ATUAL DE PRODUTOS EM ESTOQUE:")
        println(
            estoqueDeProdutos.buscarTodos().joinToString("\n")
                .ifEmpty { "Nenhum produto foi adicionado ao estoque até o momento." })
        println("\nInsira ação de controle de estoque:")
        print("-> ")
        acao = readlnOrNull()?.toIntOrNull() ?: 0
        when (acao) {
            AcoesMenu.ADICIONAR_PRODUTO.ordinal -> {
                val produto = preencherProduto()
                estoqueDeProdutos.inserir(item = produto)
                println("O produto foi inserido com SUCESSO!")
            }

            AcoesMenu.ATUALIZAR_PRODUTO.ordinal -> {
                var id: Int?
                println("Insira o ID do produto a ser atualizado: ")
                do {
                    print("-> ")
                    id = readlnOrNull()?.toIntOrNull()
                    if (id.isNullOrNegative() || estoqueDeProdutos.buscar(id = id!!) == null)
                        println("O ID inserido é inválido. Tente novamente.")
                } while (id.isNullOrNegative() || estoqueDeProdutos.buscar(id = id!!) == null)
                val produtoASerAtualizado = estoqueDeProdutos.buscar(id = id)!!
                produtoASerAtualizado.let {
                    val produtoAtualizado = preencherProdutoAtualizado(produtoASerAtualizado = it)
                    estoqueDeProdutos.atualizar(item = produtoAtualizado)
                    println("O produto foi atualizado com SUCESSO!")

                }
            }

            AcoesMenu.DELETAR_PRODUTO.ordinal -> {
                var id: Int?
                println("Insira o ID do produto a ser deletado: ")
                do {
                    print("-> ")
                    id = readlnOrNull()?.toIntOrNull()
                    if (id == null || id < 0)
                        println("O ID inserido é inválido. Tente novamente.")
                } while (id == null || id < 0)
                val produtoDeletado = estoqueDeProdutos.deletar(id = id)
                println(
                    if (produtoDeletado) "O produto foi deletado com SUCESSO!"
                    else "Não existe nenhum produto com este ID."
                )
            }

            AcoesMenu.BUSCAR_PRODUTO.ordinal -> {
                var id: Int?
                println("Insira o ID do produto a ser buscado: ")
                do {
                    print("-> ")
                    id = readlnOrNull()?.toIntOrNull()
                    if (id == null || id < 0)
                        println("O ID inserido é inválido. Tente novamente.")
                } while (id == null || id < 0)
                val produtoBuscado = estoqueDeProdutos.buscar(id = id)
                println(
                    if (produtoBuscado != null) "O produto buscado é: $produtoBuscado"
                    else "Não existe nenhum produto com este ID."
                )

            }

            AcoesMenu.SAIR.ordinal -> {
                println("Obrigado! Volte sempre!")
            }

            else -> {
                println("Opção escolhida é inválida. Tente novamente.")
            }
        }
    } while (acao != AcoesMenu.SAIR.ordinal)

}