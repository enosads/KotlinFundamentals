package aula_06_nulos

fun main() {
    var a: String? = null

    val result: String = a ?: "1"

    println("Operador elvis")
    println(result)

    var b: Int = -1
    b = a?.toInt() ?: 0

    println("Operador de chamada segura")
    println(b)

    if(a!= null){
        println(a!!.toInt())
    }

    val c = a as? Int

    println("Operador save cast")
    println(c)

    println("método let contra nulos")
    b?.let { println(it) }
}