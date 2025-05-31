package aula_02_tipos_de_dados

fun main() {

    // numéricos

//    byte(8 bits) - vai de -128 a 127
    val byte: Byte = 127
//    short (16 bits) - vai de -32768 a 32767
    val short: Short = 32_767
//    int (32 bits) - vai de -2147483648 a 2147483647
    val int: Int = 2_147_483_647 // Int
//    long (64 bits) - vai de -9223372036854775808 a 9223372036854775
    val long: Long = 9_223_372_036_854_775_807 // Long

//    float (32 bits) -
    val float: Float = 3.14F
//    double (64 bits)
    val double: Double = 3.14

// char (16 bits)
    val char: Char = 'F'
// String
    val string: String = ""
    val string2 = """
        dgfgdgdfg gdf g
        
        gdfffffff
        gdfgs hfg hgdfh hfghfgh 
        hfhfghhfghfdh 
    """.trimIndent()
    val string3: String = "$char"

//    boolean true or false
    val boolean: Boolean = false

}