import java.io.File

object DayFour {

    private fun getDAtaFromPFile(): List<String> {
        val data = mutableListOf<String>()
        val buffer = mutableListOf<String>()
        val input: List<String> = File("./data/dayFour.txt").bufferedReader().use { it.readLines() }


        input.forEach { line ->
            if (line.isNotBlank()) {
                buffer.add(line)
            } else {
                data.add(buffer.joinToString(" "))
                buffer.clear()
            }
        }

        return data
    }

    private val data = getDAtaFromPFile()
    private val validators = listOf("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid")

    fun partOne() {
        var valid = 0
        data.forEach { string ->
            if (string.split(":", " ").containsAll(validators)) valid++
        }
        println(valid)
    }
}

