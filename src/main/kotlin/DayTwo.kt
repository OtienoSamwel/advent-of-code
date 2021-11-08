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
        println(validPass)
    }

    fun partTwo() {
        var validPass = 0
        input.forEach { passWordInfo ->
            if (
                (passWordInfo.password[passWordInfo.minChar - 1].toString() == passWordInfo.char).xor(
                    passWordInfo.password[passWordInfo.maxChar - 1].toString() == passWordInfo.char
                )
            ) {
                validPass++
            }
        }
        println(validPass)
    }
}


data class Password(
    val char: String,
    val minChar: Int,
    val maxChar: Int,
    val password: String
)