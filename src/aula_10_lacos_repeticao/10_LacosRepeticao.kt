package aula_10_lacos_repeticao

fun main() {
    // for

    val list = listOf("abc", "def", "ghi", false, 10.0)

    for (item in list) {
        println(item)
    }

    list.forEach { item -> println(item) }

    list.forEachIndexed { index, item -> println("item[$index] = $item") }

    for((index, item) in list.withIndex()) {
        if(index == 3)
            continue
        println("item[$index] = $item")
    }

    // while
    var index = 1
    val maxLimit = 5

    while (index <= maxLimit) {
        println("index = $index")
        index++
    }

    // do / while

    var  index2 = 1
    do {
        println("index2 = $index2")

        if(index2 == 3)
            break
        index2++
    } while (index2 <= maxLimit)

    // laços aninhados

    loop@ for(i in 1..3){
        for(j in 1..3) {
            if(i == 2 && j == 2){
                break@loop
            }
            println("i = $i | j = $j")
        }
    }

    // repeat

    var index3 = 1
    repeat(5){
        println(index3)
        index3++
    }
}