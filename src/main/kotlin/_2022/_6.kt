package _2022

import java.io.File


fun main() {
    //partOne()
    partTwo()
}


private fun getData(): String {
    return File("./src/main/kotlin/twenty_twenty_two/data/daySix.txt").readText()
}

private fun String.areCharsUnique(): Boolean {
    var unique = true
    forEachIndexed { index, c ->
        val chars = this.toMutableList()
        chars.removeAt(index)

        if (chars.contains(c)) unique = false

        println("$this $index chars $chars char $c unique = ${!unique}")
    }

    return unique
}

private fun partOne() {
    val data = getData().toList()

    var startOfChar = 0
    for (index in 0..data.lastIndex) {
        if (data.lastIndex > index + 3) {

            val fourChars = "${data[index]}${data[index + 1]}${data[index + 2]}${data[index + 3]}"
            println("$index four char : $fourChars unique ${fourChars.areCharsUnique()}")
            if (fourChars.areCharsUnique()) {
                startOfChar = index + 3 + 1
                break
            }
        }
    }

    println("part one $startOfChar")
}

private fun partTwo() {
    val data = getData().toList()

    var startOfChar = 0
    for (index in 0..data.lastIndex) {
        if (data.lastIndex > index + 13) {

            var fourteenChars = ""
            (0..13).forEach { fourteenChars += data[index + it] }
            println("$index four char : $fourteenChars unique ${fourteenChars.areCharsUnique()}")
            if (fourteenChars.areCharsUnique()) {
                startOfChar = index + 13 + 1
                break
            }
        }
    }

    println("part two $startOfChar")
}