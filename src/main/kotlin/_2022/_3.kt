package _2022

import java.io.File
import java.io.InputStream

fun main() {
    partOne()
    partTwo()
}

private fun getDataFromFileSplit(): List<Pair<String, String>> {
    val listOfSacks = mutableListOf<Pair<String, String>>()
    val inputStream: InputStream = File("./src/main/kotlin/twenty_twenty_two/data/dayThree.txt").inputStream()

    //if a new line is blank clear the placeholder list and start adding anew
    inputStream.bufferedReader().use { reader ->
        reader.readLines().forEach { line ->
            if (line.isNotBlank()) {
                val len = line.length / 2
                val first = line.substring(0, len)
                val second = line.substring(len)
                listOfSacks.add(first to second)
            }
        }
    }

    return listOfSacks
}

private fun getDataFromFile(): List<String> {
    val listOfSacks = mutableListOf<String>()
    val inputStream: InputStream = File("./src/main/kotlin/twenty_twenty_two/data/dayThree.txt").inputStream()

    //if a new line is blank clear the placeholder list and start adding anew
    inputStream.bufferedReader().use { reader ->
        reader.readLines().forEach { line ->
            if (line.isNotBlank()) {
                listOfSacks.add(line)
            }
        }
    }

    return listOfSacks
}

private fun getMapOfPriorities(): Map<Char, Int> {

    val mapOfPriorities = mutableMapOf<Char, Int>()

    //lowercase letters
    ('a'..'z').toList().forEachIndexed { index, c ->
        mapOfPriorities[c] = index + 1
    }

    //uppercase letters
    ('A'..'Z').toList().forEachIndexed { index, c ->
        mapOfPriorities[c] = index + 27
    }

    return mapOfPriorities
}

private fun partTwo() {

    val listOfSacks = getDataFromFile()
    val mapOfPriorities = getMapOfPriorities()

    var sum = 0

    listOfSacks.chunked(3).forEach { group ->
        val sack1 = group[0]
        val sack2 = group[1]
        val sack3 = group[2]

        for (char in sack1) {
            if (sack2.contains(char) && sack3.contains(char)) {
                sum += mapOfPriorities[char] ?: 0
                return@forEach
            }
        }
    }


    println("part two $sum")
}

private fun partOne() {

    val sacks = getDataFromFileSplit()
    val priorityMap = getMapOfPriorities()

    var total = 0

    sacks.forEach { pair ->
        for (x in pair.first) {
            if (pair.second.contains(x)) {
                total += priorityMap[x] ?: 0
                return@forEach
            }
        }
    }

    println("part one $total")
}
