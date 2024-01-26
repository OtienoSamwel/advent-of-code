package _2022

import java.io.File
import java.io.InputStream

fun main() {
    partOne()
    partTwo()
}


private fun getTowerInput(): List<MutableList<Char>> {

    val data = mutableListOf<MutableList<Char>>()
    val inputStream: InputStream = File("./src/main/kotlin/twenty_twenty_two/data/dayFive.txt").inputStream()
    inputStream.bufferedReader().use { reader ->

        val lines = reader.readLines()

        val maxLineLength = lines.maxOf { it.length }

        lines.forEach { line ->
            if (line.isNotBlank()) {
                //create the sublist if they don't exist
                (0..8).toList().forEach { index ->
                    runCatching { data[index] }.onFailure { data.add(emptyList<Char>().toMutableList()) }
                }



                line.trimEnd().forEachIndexed { index, c ->
                    if (!c.isWhitespace() && c != '[' && c != ']') {
                        val innerIndex = kotlin.math.round((index.toDouble() / maxLineLength) * 8.0).toInt()
                        data[innerIndex].add(c)
                    }
                }
            } else {
                return@use
            }
        }
    }

    return data.toList()
}

private fun getMoveList(): List<Move> {
    val moveList = mutableListOf<Move>()

    val inputStream: InputStream = File("./src/main/kotlin/twenty_twenty_two/data/dayFive.txt").inputStream()
    inputStream.bufferedReader().use { reader ->
        val lines = reader.readLines()
        lines.forEach { line ->
            if (line.startsWith('m')) {
                var qty = 0
                var from = 0
                var to = 0

                qty = line.split("from").first().trim().split(" ").last().toInt()
                from = line.split("from").last().trim().split("to").first().trim().toInt()
                to = line.split("from").last().trim().split("to").last().trim().toInt()


                moveList.add(Move(quantity = qty, from = from, to = to))
            }
        }
    }
    return moveList
}

data class Move(val quantity: Int, val from: Int, val to: Int)


private fun move(tower: List<MutableList<Char>>, move: Move) {

    val fromTower = tower[move.from - 1]
    val toTower = tower[move.to - 1]
    val movingItems = fromTower.take(move.quantity)

    repeat(move.quantity) {
        fromTower.removeFirst()
    }

    movingItems.forEach {
        toTower.add(0, it)
    }
}

private fun movePartTwo(tower: List<MutableList<Char>>, move: Move) {

    val fromTower = tower[move.from - 1]
    val toTower = tower[move.to - 1]
    val movingItems = fromTower.take(move.quantity)

    repeat(move.quantity) {
        fromTower.removeFirst()
    }

    movingItems.reversed().forEach {
        toTower.add(0, it)
    }
}

private fun partOne() {
    val tower = getTowerInput()

    val moveList = getMoveList()

    moveList.forEach { move ->
        move(tower, move)
    }

    var output = ""
    tower.forEach {
        output += it.first()
    }
    println("part one : $output")
}

private fun partTwo() {
    val tower = getTowerInput()


    val moveList = getMoveList()

    moveList.forEach { move ->
        movePartTwo(tower, move)
    }

    var output = ""
    tower.forEach {
        output += it.first()
    }
    println("part two : $output")

}