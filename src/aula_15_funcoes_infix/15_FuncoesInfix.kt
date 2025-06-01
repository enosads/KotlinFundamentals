package aula_15_funcoes_infix

infix fun Int.sum(num: Int) = this + num

class XY(val x: Int, val y: Int) {
    infix fun sum(xy: XY) = XY(x = this.x + xy.x, y = this.y + xy.y)
}

fun main() {
    println(10 sum 20)
    val xy = XY(x = 3, y = 2) sum XY(x =2, y= 2)
    println(xy.x)
    println(xy.y)
}