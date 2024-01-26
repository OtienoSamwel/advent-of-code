package _2022

import java.io.File
import java.io.InputStream

/**
 * plays
 * A - rock
 * B - paper
 * C - scissors
 *
 * responses
 * X - rock (1 point )
 * Y - paper (2 points )
 * z - scissors (3 points)
 */

/**
 * here we will return a map of the game outcome to the play
 *
 *Draw
 * A X => D : X
 * B Y => D : Y
 * C Z => D : Z
 *
 * Win
 * A Y => W : Y
 * B z => W : Z
 * C X => W : X
 *
 * The other conditions will be a loss
 */
private fun partOne() {
    fun getDataFromFile(): List<Pair<String, String>> {
        val mapOfGames = mutableListOf<Pair<String, String>>()

        val inputStream: InputStream = File("./src/main/kotlin/twenty_twenty_two/data/dayTwo.txt").inputStream()

        inputStream.bufferedReader().use { reader ->
            reader.readLines().forEach { line ->
                if (line.isNotBlank()) {
                    when (line.split(" ")) {
                        listOf("A", "X") -> mapOfGames.add("D" to "X")
                        listOf("B", "Y") -> mapOfGames.add("D" to "Y")
                        listOf("C", "Z") -> mapOfGames.add("D" to "Z")
                        listOf("A", "Y") -> mapOfGames.add("W" to "Y")
                        listOf("B", "Z") -> mapOfGames.add("W" to "Z")
                        listOf("C", "X") -> mapOfGames.add("W" to "X")
                        else -> {
                            mapOfGames.add("L" to line.split(" ").last())
                        }
                    }
                }
            }
        }
        return mapOfGames
    }

    //calculate all the points
    var totalPoints = 0

    getDataFromFile().forEach { pair ->
        when (pair.first) {
            "W" -> totalPoints += 6
            "D" -> totalPoints += 3
            "L" -> totalPoints += 0
        }

        when (pair.second) {
            "X" -> totalPoints += 1
            "Y" -> totalPoints += 2
            "Z" -> totalPoints += 3
        }
    }

    println("part one: $totalPoints")
}


/**
 * plays
 * A - rock
 * B - paper
 * C - scissors
 *
 * targets
 * X - win (1 point ) rock
 * Y - draw (2 points ) paper
 * z - lose (3 points) scissors
 */

/**
 * here we will return a pair list of the game outcome to the play
 *
 *Draw
 * A Y => D : X
 * B Y => D : Y
 * C Y => D : Z
 *
 * Win
 * A X => L : Z
 * B X => L : X
 * C X => L : Y
 *
 * Lose
 * A Z => W : Y
 * B Z => W : Z
 * C Z => W : X
 *
 * The other conditions will be a loss
 */
private fun partTwo() {
    fun getDataFromFile(): List<Pair<String, String>> {
        val mapOfGames = mutableListOf<Pair<String, String>>()

        val inputStream: InputStream = File("./src/main/kotlin/twenty_twenty_two/data/dayTwo.txt").inputStream()

        inputStream.bufferedReader().use { reader ->
            reader.readLines().forEach { line ->
                if (line.isNotBlank()) {
                    when (line.split(" ")) {
                        listOf("A", "X") -> mapOfGames.add("L" to "Z")
                        listOf("B", "X") -> mapOfGames.add("L" to "X")
                        listOf("C", "X") -> mapOfGames.add("L" to "Y")
                        listOf("A", "Y") -> mapOfGames.add("D" to "X")
                        listOf("B", "Y") -> mapOfGames.add("D" to "Y")
                        listOf("C", "Y") -> mapOfGames.add("D" to "Z")
                        listOf("A", "Z") -> mapOfGames.add("W" to "Y")
                        listOf("B", "Z") -> mapOfGames.add("W" to "Z")
                        listOf("C", "Z") -> mapOfGames.add("W" to "X")

                    }
                }
            }
        }
        return mapOfGames
    }

    //calculate all the points
    var totalPoints = 0

    getDataFromFile().forEach { pair ->
        when (pair.first) {
            "W" -> totalPoints += 6
            "D" -> totalPoints += 3
            "L" -> totalPoints += 0
        }

        when (pair.second) {
            "X" -> totalPoints += 1
            "Y" -> totalPoints += 2
            "Z" -> totalPoints += 3
        }
    }

    println("part two: $totalPoints")
}

fun main() {
    partOne()
    partTwo()
}