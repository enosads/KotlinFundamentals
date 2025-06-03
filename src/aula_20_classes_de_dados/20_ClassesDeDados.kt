package aula_20_classes_de_dados

class UserClass(val name: String, val age: Int) {

}

data class UserDataClass(val name: String, val age: Int)

fun main() {
    val userClass = UserClass("Enos", 29)
    val userDataClass = UserDataClass("Enos", 29)

    // toString()
    println(userClass)
    println(userDataClass)

    // equals
    val jose = UserDataClass("José", 30)
    val jose2 = UserDataClass("José", 30)
    val maria = UserDataClass("Maria", 40)
    val userClass2 = UserClass("Enos", 29)
    println(jose == jose2)
    println(userClass == userClass2)

    // copy
    val copyMaria = maria.copy(age =  50)
    println(copyMaria)

//    val (name, age) = jose
    val (name, age) = jose
    println(name)
    println(age)
}