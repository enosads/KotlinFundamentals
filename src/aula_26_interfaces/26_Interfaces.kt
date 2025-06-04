package aula_26_interfaces


data class Document(val text: String)

interface Printer {
    fun print(text: String): Document

    val printerType: String
}

interface TextConverter {
    val defaultText: String
        get() = "Desconhecida"

    fun convert(text: String, printerType: String): String {
       return text.ifEmpty { defaultText }
    }
}

class PdfPrinter : Printer, TextConverter {
    override fun print(text: String): Document {
        convert(text = text, printerType= printerType)
        println("PDF printing: $text")
        return Document(text=text)
    }

    override val printerType = "PDF"

    override fun convert(text: String, printerType: String): String {
        println("Converting text '${text}' to $printerType...")
        return text
    }
}

class WordPrinter : Printer, TextConverter {
    override fun print(text: String): Document {
        convert(text = text, printerType= printerType)
        println("Word printing: $text")
        return Document(text=text)
    }

    override val printerType: String
        get() = "WORD"

    override fun convert(text: String, printerType: String): String {
        println("Converting text '${text}' to $printerType...")
        return text
    }
}


fun main() {
    val pdfPrinter = PdfPrinter()
    val pdfDocument = pdfPrinter.print("Hello, World, from PDF!")
    println(pdfDocument)

    val wordPrinter = WordPrinter()
    val wordDocument = wordPrinter.print("Hello, World, from WORD!")
    println(wordDocument)
}