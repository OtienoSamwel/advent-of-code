package _2022

import java.io.File
import java.io.InputStream

private fun getDataFromFile(): List<Int> {
    val listOfSums = mutableListOf<Int>()

    val placeholderList = mutableListOf<Int>()

    val inputStream: InputStream = File("./src/main/kotlin/twenty_twenty_two/data/dayOne.txt").inputStream()

    //if a new line is blank clear the placeholder list and start adding anew
    inputStream.bufferedReader().use { reader ->
        reader.readLines().forEach { line ->
            if (line.isBlank()) {
                listOfSums.add(placeholderList.sum())
                placeholderList.clear()
            } else {
                placeholderList.add(line.toInt())
            }
        }
    }


    return listOfSums
}


private fun partOne() {
println("part one ${getDataFromFile().maxOrNull() ?: 0 }")
}

private fun partTwo() {
    val sortedList = getDataFromFile().sorted()
    val sumOfLastThree = sortedList.takeLast(3).sum()
    print("past two $sumOfLastThree")
}

fun main() {
    partOne()
    partTwo()
}