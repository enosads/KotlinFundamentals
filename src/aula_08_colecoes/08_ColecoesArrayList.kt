package aula_08_colecoes

fun main() {

    // array
    println("array")
    val array: Array<Int> = arrayOf(1, 2, 3, 4, 5)
    val array2: Array<String> = arrayOf("1", "2", "3")

    println(array.joinToString(prefix = "[", postfix = "]", separator = " | "))
    println(array2.joinToString())

    val array3: Array<Int> = arrayOf(6, 7, 8, 9, 10)
    val arraySum = array + array3
    println(arraySum.joinToString())

    // list
    println("list")
    val list = listOf(2, 2, 4, "1", false, 1..3, 4.0, 5, 3, 1)
    val mutableList = mutableListOf(1, 2, 3)

    mutableList.add(4)

    println(mutableList)
    val  listInt: List<Int> = list.filterIsInstance<Int>()
    println(listInt)

    val listIntHigherThan2 = list.filter { it is Int && it > 2 }
    println(listIntHigherThan2)

    val listIntMessy = listOf(9, 18, 70, 1, 3, 750, 8, 16, 32_550, 2)
    val listStringMessy = listOf("Bernardo", "Alice", "Jhonathan", "Roberto", "Clara")

    println(listIntMessy.sorted())
    println(listStringMessy.sorted())

    println(listIntMessy.reversed())
    println(listStringMessy.reversed())

    val intMax = listIntMessy.max()
    val intMin = listIntMessy.min()
    println("intMax: $intMax, intMin: $intMin")

    val findFirstOdd = list.find { it  is Int && it % 2 != 0 }
    val findLastOdd = list.findLast { it  is Int && it % 2 != 0 }
    println(findFirstOdd)
    println(findLastOdd)

    val booleanMapIntHigherThan10 = listIntMessy.map { it > 10}
    println(booleanMapIntHigherThan10)

    // outros métodos importantes

    println(list.first())
    println(list.last())
    println(list.subList(0, 3))
    println(list[3])
    println(list.indexOf(4))
    println(list.indices)
    println(list.size)
    println(list.isEmpty())
    println(list.isNotEmpty())
    println(list.drop(2))
    println(list.dropLast(2))
    println(list.dropWhile { it is Int })
    println(listInt.any { it < 0})
    println(listStringMessy.any { it.startsWith("Z")})
    println(list.all {it is Int})
    println(list.zip(listInt))
    println(list.elementAt(1))
    println(list.getOrNull(10))
    println(listInt.mapIndexed { index, item -> index + item })
}