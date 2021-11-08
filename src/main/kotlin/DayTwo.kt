import java.io.File
import java.io.InputStream

object DayTwo {

    private fun getDAtaFromFile(): List<Password> {
        val listOfValue = mutableListOf<Password>()
        val inputStream: InputStream = File("dayTwo.txt").inputStream()
        inputStream.bufferedReader().use { reader ->
            reader.readLines().forEach { line ->
                val values = (line.split("-", " ", ": "))
                listOfValue.add(
                    Password(
                        char = values[2],
                        minChar = values[0].toInt(),
                        maxChar = values[1].toInt(),
                        password = values[3]
                    )
                )
            }
        }
        return listOfValue
    }

    private val input = getDAtaFromFile()

    fun partOne() {
        var validPass = 0
        input.forEach { passwordInfo ->
            val charNumber = passwordInfo.password.filter {
                it.toString() == passwordInfo.char
            }.length

            if (charNumber >= passwordInfo.minChar && charNumber <= passwordInfo.maxChar) {
                validPass++
            }
        }
        print(validPass)
    }
}


data class Password(
    val char: String,
    val minChar: Int,
    val maxChar: Int,
    val password: String
)