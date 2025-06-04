package aula_24_classes_enumeradas

enum class Direction(val description: String) {
    NORTH(description = "Direção norte.") {
        override fun symbol(): String {
            return "⬆️"
        }

        override val symbol: String
            get() = "⬆️"
    },
    SOUTH(description = "Direção sul.") {
        override fun symbol(): String {
            return "⬇️"
        }

        override val symbol: String
            get() = "⬆️"
    },
    WEST(description = "Direção oeste.") {
        override fun symbol(): String {
            return "⬅️"
        }

        override val symbol: String
            get() = "⬅️"
    },
    EAST(description = "Direção leste.") {
        override fun symbol(): String {
            return "➡️"
        }

        override val symbol: String
            get() = "➡️"
    };

    companion object {
        fun sumDirection(firstDirection: Direction, secondDirection: Direction) {
            println(firstDirection.description)
            println(secondDirection.description)
        }
    }

    fun addDirection(direction: Direction) {
        println(this.description)
        println(direction.description)
    }

    abstract fun symbol(): String
    abstract val symbol: String
}

fun main() {
//    val north = Direction.NORTH
//
//    println(north.ordinal)
//    println(north.name)
//    println(north.description)
//
//    north.addDirection(direction = Direction.EAST)
//    Direction.sumDirection(firstDirection = north, secondDirection = Direction.SOUTH)

    // entries
    Direction.entries.forEach { item ->
        println(item.description)
        println(item.symbol)
    }

    // valueOf

    println(Direction.valueOf("SOUTH").ordinal)
}