package aula_28_classes_e_interfaces_seladas

sealed class Result {
    data class Success(val data: String) : Result()
    data class Error(val exception: Exception) : Result()
    data object Loading : Result()
}

fun handleResult(result: Result) {
    when (result) {
        is Result.Error -> println("Houve um error! ${result.exception.message}")
        is Result.Loading -> println("Loading...")
        is Result.Success -> println("Sucesso! ${result.data}")
    }
}

object DataBase {
    fun getContacts(): Result {
        return Result.Success(data = listOf<String>("João", "José", "Maria").joinToString())
    }

    fun insertContact(contact: String): Result {
        return Result.Error(exception = IllegalArgumentException("O contato a ser inserido possui caracteres inválidos"))
    }

    fun updateContact(id: Int, newContact: String): Result {
        return Result.Loading
    }

}

fun main() {
    val contacts = DataBase.getContacts()
    val isContactInserted = DataBase.insertContact(contact = "Enos")
    val isContactUpdated = DataBase.updateContact(id = 1, newContact = "Enos")

    handleResult(result = contacts)
    handleResult(result = isContactInserted)
    handleResult(result = isContactUpdated)
}