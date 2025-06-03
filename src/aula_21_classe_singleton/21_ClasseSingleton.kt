package aula_21_classe_singleton

object DataBaseUtil {
    val url: String = "jdbc:mysql://localhost:3306/db_curso"
    private val user: String = "root"
    private val password: String = "admin"

    fun connect() {
        println("Conectando ao banco de dados $url | Usuário: $user | Senha: $password")
    }
}

data object DataBaseHelper {

}

fun main() {
    DataBaseUtil.connect()
    println(DataBaseUtil)
    println(DataBaseHelper)
}