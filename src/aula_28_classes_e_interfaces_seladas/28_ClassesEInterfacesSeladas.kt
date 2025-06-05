package aula_28_classes_e_interfaces_seladas

sealed interface Animal {
    data class Dog(val breed: String) : Animal {
        override fun sound(): String {
            return "Au!"
        }
    }

    data class Cat(val color: String) : Animal {
        override fun sound(): String {
            return "Miau!"
        }
    }
    data object Bird : Animal {
        override fun sound(): String {
            return "Piu!"
        }
    }

    fun sound(): String;
}

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

fun handleAnimal(animal: Animal){
    println(when(animal){
        is Animal.Cat -> "O animal é um gato. O som que ele faz é ${animal.sound()} e sua cor é ${animal.color}"
        is Animal.Dog -> "O animal é um cachorro. O som que ele faz é ${animal.sound()} e a sua raça é ${animal.breed}"
        Animal.Bird -> "O animal é um pássaro. O som que ele faz é ${Animal.Bird.sound()}"
    })
}


fun main() {
    val contacts = DataBase.getContacts()
    val isContactInserted = DataBase.insertContact(contact = "Enos")
    val isContactUpdated = DataBase.updateContact(id = 1, newContact = "Enos")


    handleResult(result = contacts)
    handleResult(result = isContactInserted)
    handleResult(result = isContactUpdated)

    val dog = Animal.Dog(breed = "Labrador")
    handleAnimal(animal = dog)

    val bird = Animal.Bird
    handleAnimal(animal = bird)

}