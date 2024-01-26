package twenty_twenty_two

import java.io.File

fun main() {
    partOne()
}

private fun input(): List<List<Int>> {
    return File("./src/main/kotlin/twenty_twenty_two/data/dayEight.txt").readLines()
        .map { line -> line.toList().map { num -> num.toString().toInt() } }
}


/**
 * Calculate all the edge trees
 * Skip the first and last indexes for bo the main array and the sub arrays.
 * check if a tree is visible from left, right, top, and bottom.
 */
private fun partOne() {
    val rows = input()
    val columns = transpose(input())

}

private fun partTwo() {

}

private inline fun <reified T> transpose(xs: List<List<T>>): List<List<T>> {
    val cols = xs[0].size
    val rows = xs.size
    return List(cols) { j ->
        List(rows) { i ->
            xs[i][j]
        }
    }
}

private fun samspose(inputList: List<List<Int>>): List<List<Int>> {
    return List(inputList.first().size) { index ->
        getListForIndex(index, inputList)
    }

}

fun getListForIndex(index: Int, inputList: List<List<Int>>): List<Int> {
    val list = mutableListOf<Int>()
    for (rowList in inputList) {
        list.add(rowList[index])
    }
    return list
}