package twenty_twenty_three

import java.io.File

fun readInput(): List<String> {
    return File("./src/main/kotlin/twenty_twenty_three/data/dayOne.txt").readLines()
}


fun part1(): Int {
    //todo create aversion two and do time and space complexity
    fun lineAnalysisV1(line: String): Int {
        val numbers = mutableListOf<Int>()
        line.map { runCatching { numbers.add(it.toString().toInt()) }.onFailure { /*not a number*/ } }
        return "${numbers.first()}${numbers.last()}".toInt()
    }

    val outputList = mutableListOf<Int>()
    readInput().forEach { line ->
        outputList.add(lineAnalysisV1(line))
    }
    return outputList.sum()
}


/**
 * Expanding and shrinking window algorithm
 * 1. Take first three chars and check if they contain any numbers. If so record that as the first number.
 * 2. Check against 3 character numbers; six, two, and one.
 * 3. Expand the window to four characters and check for any numbers then for three, four, five, and nine.
 * 4. Expand the window to five characters and check for any numbers then for seven and eight
 * 5. When the window size won;t accommodate the various sizes come up with placeholder sizes
 *
 */


val threeCharactersDigits = listOf("one", "two", "six")
val fourCharacterDigits = listOf("three", "four", "nine")
val fiveCharacterDigits = listOf("seven", "eight")
//fun windowAndPop(line: String): List<Int> {
//
//    val numbers = mutableListOf<Int>()
//
//    //
//    val firstThree = line.take(3)
//    firstThree.forEach {
//        runCatching { numbers.add(it.toString().toInt()) }.onFailure {
//            //
//        }.onSuccess {
//            //contains a number
//        }
//    }
//}

fun part2() {
    val list = ('a'..'g').map { it.toString() }
    println(list.windowed(size = 4))
}


fun main() {
    //part one
    //println(part1())

    //part two

    part2()
}