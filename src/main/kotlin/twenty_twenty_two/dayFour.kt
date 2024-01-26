package twenty_twenty_two

import java.io.File
import java.io.InputStream

private fun getDataFromFileSplit(): List<Pair<List<Int>, List<Int>>> {
    val listOfPairs = mutableListOf<Pair<List<Int>, List<Int>>>()
    val inputStream: InputStream = File("./src/main/kotlin/twenty_twenty_two/data/dayFour.txt").inputStream()

    //if a new line is blank clear the placeholder list and start adding anew
    inputStream.bufferedReader().use { reader ->
        reader.readLines().forEach { line ->
            if (line.isNotBlank()) {
                val unwrapped = line.split(",")
                    .map { eachPair ->
                        eachPair.split("-")
                            .map { eachNumber -> eachNumber.toInt() }
                    }.map { eachList -> (eachList.first()..eachList.last()).toList() }

                listOfPairs.add(Pair(unwrapped.first(), unwrapped.last()))
            }
        }
    }

    return listOfPairs
}


fun main() {
    partOne()
    partTwo()
    getDataFromFileSplit()
}

private fun partOne() {
    var total = 0

    val input = getDataFromFileSplit()

    input.forEach { pair ->
        //find bigger array
        if (pair.first.size > pair.second.size) {
            val first: List<Int> = pair.first
            val second: List<Int> = pair.second

            if (second.all { first.contains(it) }) total += 1
        }else{
            val first: List<Int> = pair.second
            val second: List<Int> = pair.first

            if (second.all { first.contains(it) }) total += 1
        }
    }
    println("part one: $total")
}

private fun partTwo() {
    var total = 0

    val input = getDataFromFileSplit()

    input.forEach { pair ->
        //find bigger array
        if (pair.first.size > pair.second.size) {
            val first: List<Int> = pair.first
            val second: List<Int> = pair.second

            if (second.any { first.contains(it) }) total += 1
        }else{
            val first: List<Int> = pair.second
            val second: List<Int> = pair.first

            if (second.any { first.contains(it) }) total += 1
        }
    }
    println("part two: $total")
}